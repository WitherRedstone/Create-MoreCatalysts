package com.chinaex123.create_more_catalysts.processing.fans.vanilla.purifying;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.config.CommonConfig;
import com.chinaex123.create_more_catalysts.init.ModFluidTags;
import com.chinaex123.create_more_catalysts.processing.fans.FanCommonType;
import com.chinaex123.create_more_catalysts.processing.fans.FanEntityTransformHelper;
import com.chinaex123.create_more_catalysts.processing.fans.FanProcessingSounds;
import com.chinaex123.create_more_catalysts.init.FanRecipeType;
import com.chinaex123.create_more_catalysts.init.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.EffectCures;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 批量净化鼓风机类型
 */
public final class PurifyingType extends FanCommonType {

    private static final int AIRFLOW_COLOR = 0xFFD700;
    private static final int PURIFYING_COLOR = 0xFFFFFF;

    private static final Map<EntityType<?>, EntityType<?>> TRANSFORM_MAP = new HashMap<>();
    private static final Map<EntityType<?>, Float> HEAL_MAP = new HashMap<>();
    private static boolean CONFIG_LOADED = false;

    private static synchronized void ensureConfigLoaded() {
        if (CONFIG_LOADED) return;
        loadTransformConfig();
        loadHealConfig();
        CONFIG_LOADED = true;
    }

    /**
     * 实体转换反馈效果
     */
    private static final FanEntityTransformHelper.TransformationFeedback DEFAULT_TRANSFORM_FEEDBACK =
            new FanEntityTransformHelper.TransformationFeedback(
                    SoundEvents.GENERIC_EXTINGUISH_FIRE,
                    SoundEvents.PLAYER_LEVELUP,
                    ParticleTypes.ENCHANT
            );

    /**
     * 从配置文件加载实体转换规则
     */
    private static void loadTransformConfig() {
        List<? extends String> transforms = CommonConfig.PURIFYING_ENTITY_TRANSFORMS.get();
        for (String transform : transforms) {
            String[] parts = transform.split("->");
            if (parts.length == 2) {
                ResourceLocation inputLoc = ResourceLocation.tryParse(parts[0].trim());
                ResourceLocation outputLoc = ResourceLocation.tryParse(parts[1].trim());

                if (inputLoc != null && outputLoc != null) {
                    Optional<EntityType<?>> inputType = BuiltInRegistries.ENTITY_TYPE.getOptional(inputLoc);
                    Optional<EntityType<?>> outputType = BuiltInRegistries.ENTITY_TYPE.getOptional(outputLoc);

                    if (inputType.isPresent() && outputType.isPresent()) {
                        TRANSFORM_MAP.put(inputType.get(), outputType.get());
                    }
                }
            }
        }
    }

    /**
     * 从配置文件加载治疗实体规则
     */
    private static void loadHealConfig() {
        List<? extends String> heals = CommonConfig.PURIFYING_HEAL_ENTITIES.get();
        for (String heal : heals) {
            String[] parts = heal.split("->");
            if (parts.length == 2) {
                ResourceLocation entityLoc = ResourceLocation.tryParse(parts[0].trim());
                try {
                    float healAmount = Float.parseFloat(parts[1].trim());
                    if (entityLoc != null) {
                        Optional<EntityType<?>> entityType = BuiltInRegistries.ENTITY_TYPE.getOptional(entityLoc);
                        entityType.ifPresent(type -> HEAL_MAP.put(type, healAmount));
                    }
                } catch (NumberFormatException e) {
                    CreateMoreCatalysts.LOGGER.warn("Invalid heal amount in purifying config: {}", heal);
                }
            }
        }
    }

    /**
     * 构造函数
     */
    public PurifyingType() {
        super(FanRecipeType.PURIFYING);
    }

    /**
     * 检查鼓风机加工是否启用
     * @return 是否启用批量净化鼓风机加工
     */
    @Override
    protected boolean isFanProcessingEnabled() {
        return CommonConfig.ENABLE_PURIFYING_FAN.get();
    }

    /**
     * 验证催化剂有效性
     * @param level 世界实例
     * @param pos 待检测的位置
     * @return 该位置是否为有效的信标催化剂位置
     */
    @Override
    public boolean isValidAt(Level level, BlockPos pos) {
        if (!isFanProcessingEnabled()) return false;
        return isValidCatalyst(level, pos,
                ModFluidTags.FAN_CATALYSTS_PURIFYING,
                ModBlockTags.FAN_CATALYSTS_PURIFYING
        );
    }

    /**
     * 获取优先级
     * @return 优先级数值
     */
    @Override
    public int getPriority() {
        return 2002;
    }

    /**
     * 生成加工粒子效果
     * @param level 世界实例
     * @param pos 粒子生成位置
     */
    @Override
    public void spawnProcessingParticles(Level level, Vec3 pos) {
        spawnDustWithParticle(level, pos, PURIFYING_COLOR, ParticleTypes.END_ROD);
    }

    /**
     * 修饰气流粒子
     * @param particleAccess 粒子访问器
     * @param random 随机数生成器
     */
    @Override
    public void morphAirFlow(AirFlowParticleAccess particleAccess, RandomSource random) {
        morphStandardAirFlow(particleAccess, random, AIRFLOW_COLOR, PURIFYING_COLOR, 0.04f, ParticleTypes.END_ROD);
    }

    /**
     * 影响生物实体
     * @param living 受影响的生物实体
     * @param level 世界实例
     */
    @Override
    protected void affectLivingEntity(LivingEntity living, Level level) {
        ensureConfigLoaded();

        // 检查配置的实体转换
        EntityType<?> outputType = TRANSFORM_MAP.get(living.getType());
        if (outputType != null) {
            @SuppressWarnings("unchecked")
            EntityType<? extends Mob> mobType = (EntityType<? extends Mob>) outputType;
            FanEntityTransformHelper.transformMob(level, living, mobType, DEFAULT_TRANSFORM_FEEDBACK);
            return;
        }

        // 为配置的实体提供治疗效果
        Float healAmount = HEAL_MAP.get(living.getType());
        if (healAmount != null) {
            living.heal(healAmount);
        }

        // 检查是否启用清除所有负面效果
        if (CommonConfig.PURIFYING_REMOVE_NEGATIVE_EFFECTS.get()) {
            living.removeEffectsCuredBy(EffectCures.MILK);
        }

        // 播放净化音效
        FanProcessingSounds.purifySound(level, living.blockPosition());
    }
}
