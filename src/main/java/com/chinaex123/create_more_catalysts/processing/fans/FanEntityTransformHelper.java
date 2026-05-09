package com.chinaex123.create_more_catalysts.processing.fans;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.level.Level;

/**
 * 风扇实体转化助手：处理生物在风扇作用下的渐进式转化逻辑，包含进度追踪、音效和粒子反馈
 */
public final class FanEntityTransformHelper {

    /**
     * 转化所需总刻数（50 tick = 2.5 秒）
     */
    private static final int TRANSFORMATION_TICKS = 50;

    /**
     * 进度音效播放间隔（每 10 tick 播放一次）
     */
    private static final int PROGRESS_SOUND_INTERVAL_TICKS = 10;

    /**
     * 进度音效最小音高
     */
    private static final float PROGRESS_MIN_PITCH = 0.50f;

    /**
     * 进度音效最大音高
     */
    private static final float PROGRESS_MAX_PITCH = 1.20f;

    /**
     * NBT 数据中转化进度的键名前缀
     */
    private static final String TRANSFORMATION_KEY_PREFIX = "create_processing_transform_";

    /**
     * 净化僵尸村民的专用键名
     */
    private static final String PURIFY_ZOMBIE_VILLAGER_KEY = "create_processing_purify_zombie_villager";

    private FanEntityTransformHelper() {
    }

    /**
     * 净化僵尸村民：将其转化为普通村民并给予玩家奖励
     * @param level 世界实例
     * @param entity 待净化的实体
     * @param feedback 转化反馈效果（音效和粒子）
     * @return 是否成功转化
     */
    public static boolean purifyZombieVillager(Level level, Entity entity, TransformationFeedback feedback) {
        if (!(level instanceof ServerLevel serverLevel) || !(entity instanceof ZombieVillager source)) {
            return false;
        }

        if (advanceTransformation(serverLevel, source, PURIFY_ZOMBIE_VILLAGER_KEY, feedback)) {
            Villager villager = createVillager(serverLevel);
            if (villager == null) {
                return false;
            }

            copyMobState(source, villager);

            configurePurifiedVillager(serverLevel, source, villager);

            if (!serverLevel.addFreshEntity(villager)) {
                return false;
            }

            clearTransformationProgress(source, PURIFY_ZOMBIE_VILLAGER_KEY);
            source.discard();
            return true;
        }

        return false;
    }

    /**
     * 转化生物实体：将源生物渐进式转化为目标类型
     * @param level 世界实例
     * @param entity 源生物实体
     * @param targetType 目标生物类型
     * @param feedback 转化反馈效果
     * @return 是否成功转化
     */
    public static boolean transformMob(Level level, Entity entity, EntityType<? extends Mob> targetType, TransformationFeedback feedback) {
        if (!(level instanceof ServerLevel serverLevel) || !(entity instanceof Mob sourceMob)) {
            return false;
        }

        String transformationKey = transformationKey(targetType);
        if (advanceTransformation(serverLevel, sourceMob, transformationKey, feedback)) {
            Mob targetMob = createMob(serverLevel, targetType);
            if (targetMob == null) {
                return false;
            }

            copyMobState(sourceMob, targetMob);

            if (!serverLevel.addFreshEntity(targetMob)) {
                return false;
            }

            clearTransformationProgress(sourceMob, transformationKey);
            sourceMob.discard();
            return true;
        }

        return false;
    }

    /**
     * 创建村民实例
     * @param serverLevel 服务端世界
     * @return 新创建的村民实体
     */
    private static Villager createVillager(ServerLevel serverLevel) {
        return EntityType.VILLAGER.create(serverLevel);
    }

    /**
     * 创建目标生物实例
     * @param serverLevel 服务端世界
     * @param targetType 目标生物类型
     * @return 新创建的生物实体
     */
    private static Mob createMob(ServerLevel serverLevel, EntityType<? extends Mob> targetType) {
        return targetType.create(serverLevel);
    }

    /**
     * 配置净化后的村民属性：设置职业、生态群系类型并添加再生效果
     * @param serverLevel 服务端世界
     * @param source 源僵尸村民
     * @param villager 目标村民
     */
    private static void configurePurifiedVillager(ServerLevel serverLevel, ZombieVillager source, Villager villager) {
        VillagerType biomeType = VillagerType.byBiome(serverLevel.getBiome(source.blockPosition()));
        villager.setVillagerData(villager.getVillagerData()
                .setType(biomeType)
                .setProfession(VillagerProfession.NONE));

        villager.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, false, true));

        rewardNearestPlayerForPurification(serverLevel, source, villager);
    }

    /**
     * 为附近玩家添加好感度奖励：净化僵尸村民后提升村民对玩家的评价
     * @param serverLevel 服务端世界
     * @param source 源僵尸村民
     * @param villager 新生成的村民
     */
    private static void rewardNearestPlayerForPurification(ServerLevel serverLevel, ZombieVillager source, Villager villager) {
        Player nearestPlayer = serverLevel.getNearestPlayer(source, 32.0d);
        if (nearestPlayer != null) {
            villager.getGossips().add(
                    nearestPlayer.getUUID(),
                    net.minecraft.world.entity.ai.gossip.GossipType.MAJOR_POSITIVE,
                    20
            );
        }
    }

    /**
     * 推进转化进度：累加进度值并播放阶段性反馈，达到阈值时完成转化
     * @param level 服务端世界
     * @param entity 正在转化的实体
     * @param key NBT 进度键名
     * @param feedback 转化反馈效果
     * @return 是否已完成转化
     */
    private static boolean advanceTransformation(ServerLevel level, Entity entity, String key, TransformationFeedback feedback) {
        CompoundTag data = entity.getPersistentData();
        int progress = data.getInt(key);

        if (progress % PROGRESS_SOUND_INTERVAL_TICKS == 0) {
            playProgressFeedback(level, entity, progress, feedback);
        }

        int nextProgress = progress + 1;
        if (nextProgress < TRANSFORMATION_TICKS) {
            data.putInt(key, nextProgress);
            return false;
        }

        data.putInt(key, TRANSFORMATION_TICKS);
        playCompletionFeedback(level, entity, feedback);
        return true;
    }

    /**
     * 清除实体的转化进度数据
     * @param entity 目标实体
     * @param key NBT 进度键名
     */
    private static void clearTransformationProgress(Entity entity, String key) {
        entity.getPersistentData().remove(key);
    }

    /**
     * 生成转化进度的 NBT 键名：基于目标实体类型的路径名称
     * @param targetType 目标实体类型
     * @return 完整的 NBT 键名
     */
    private static String transformationKey(EntityType<?> targetType) {
        return TRANSFORMATION_KEY_PREFIX + BuiltInRegistries.ENTITY_TYPE.getKey(targetType).getPath();
    }

    /**
     * 复制生物状态：转移位置、运动、AI 状态、自定义名称和生命值比例
     * @param sourceMob 源生物
     * @param targetMob 目标生物
     */
    private static void copyMobState(Mob sourceMob, Mob targetMob) {
        targetMob.moveTo(sourceMob.getX(), sourceMob.getY(), sourceMob.getZ(), sourceMob.getYRot(), sourceMob.getXRot());
        targetMob.setDeltaMovement(sourceMob.getDeltaMovement());
        targetMob.setNoAi(sourceMob.isNoAi());
        targetMob.setSilent(sourceMob.isSilent());

        if (sourceMob.hasCustomName()) {
            targetMob.setCustomName(sourceMob.getCustomName());
            targetMob.setCustomNameVisible(sourceMob.isCustomNameVisible());
        }

        float healthRatio = sourceMob.getHealth() / Math.max(1.0f, sourceMob.getMaxHealth());
        targetMob.setHealth(Math.max(1.0f, targetMob.getMaxHealth() * healthRatio));
    }

    /**
     * 播放转化进度反馈：包括音效和粒子效果
     * @param level 服务端世界
     * @param entity 转化中的实体
     * @param progress 当前进度值
     * @param feedback 转化反馈配置
     */
    private static void playProgressFeedback(ServerLevel level, Entity entity, int progress, TransformationFeedback feedback) {
        playProgressSound(level, entity, progress, feedback);
        playProgressParticles(level, entity, feedback);
    }

    /**
     * 播放进度音效：音高随进度线性增长
     * @param level 服务端世界
     * @param entity 转化中的实体
     * @param progress 当前进度值
     * @param feedback 转化反馈配置
     */
    private static void playProgressSound(ServerLevel level, Entity entity, int progress, TransformationFeedback feedback) {
        float ratio = Mth.clamp(progress / (float) (TRANSFORMATION_TICKS - 1), 0.0f, 1.0f);
        float pitch = Mth.lerp(ratio, PROGRESS_MIN_PITCH, PROGRESS_MAX_PITCH);
        level.playSound(null, entity.blockPosition(), feedback.progressSound(), SoundSource.NEUTRAL, 0.85f, pitch);
    }

    /**
     * 生成进度粒子：在实体周围随机散布
     * @param level 服务端世界
     * @param entity 转化中的实体
     * @param feedback 转化反馈配置
     */
    private static void playProgressParticles(ServerLevel level, Entity entity, TransformationFeedback feedback) {
        if (feedback.progressParticle() != null) {
            level.sendParticles(
                    feedback.progressParticle(),
                    entity.getX(), entity.getY(0.5d), entity.getZ(),
                    4,
                    entity.getBbWidth() * 0.35d,
                    entity.getBbHeight() * 0.25d,
                    entity.getBbWidth() * 0.35d,
                    0.02d
            );
        }
    }

    /**
     * 播放转化完成反馈：包括完成音效和大量粒子爆发
     * @param level 服务端世界
     * @param entity 完成转化的实体
     * @param feedback 转化反馈配置
     */
    private static void playCompletionFeedback(ServerLevel level, Entity entity, TransformationFeedback feedback) {
        level.playSound(null, entity.blockPosition(), feedback.completionSound(), SoundSource.NEUTRAL,
                1.15f, 0.9f + level.random.nextFloat() * 0.2f);

        playCompletionParticles(level, entity, feedback);
    }

    /**
     * 生成完成粒子：在实体周围大量爆发
     * @param level 服务端世界
     * @param entity 完成转化的实体
     * @param feedback 转化反馈配置
     */
    private static void playCompletionParticles(ServerLevel level, Entity entity, TransformationFeedback feedback) {
        if (feedback.progressParticle() != null) {
            level.sendParticles(
                    feedback.progressParticle(),
                    entity.getX(), entity.getY(0.5d), entity.getZ(),
                    16,
                    entity.getBbWidth() * 0.45d,
                    entity.getBbHeight() * 0.35d,
                    entity.getBbWidth() * 0.45d,
                    0.06d
            );
        }
    }

    /**
     * 转化反馈记录：封装转化过程中的音效和粒子配置
     * @param progressSound 进度音效
     * @param completionSound 完成音效
     * @param progressParticle 进度粒子类型
     */
    public record TransformationFeedback(SoundEvent progressSound, SoundEvent completionSound, ParticleOptions progressParticle) {
    }
}
