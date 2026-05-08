package com.chinaex123.create_more_catalysts.processing.fans.vanilla.snow_flow;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.config.CommonConfig;
import com.chinaex123.create_more_catalysts.init.ModFluidTags;
import com.chinaex123.create_more_catalysts.processing.fans.FanCommonType;
import com.chinaex123.create_more_catalysts.processing.fans.FanEntityTransformHelper;
import com.chinaex123.create_more_catalysts.processing.fans.FanProcessingSounds;
import com.chinaex123.create_more_catalysts.init.FanRecipeType;
import com.chinaex123.create_more_catalysts.init.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.*;

/**
 * 批量雪流鼓风机类型
 */
public final class SnowFlowType extends FanCommonType {

    private static final int AIRFLOW_COLOR = 0xA8D8EA;
    private static final int SNOW_COLOR = 0xF0F8FF;

    private static final Map<EntityType<?>, EntityType<?>> TRANSFORM_MAP = new HashMap<>();
    private static final Map<EntityType<?>, Float> HEAL_MAP = new HashMap<>();
    private static boolean CONFIG_LOADED = false;
    private static final List<SnowFlowType.PotionEffectEntry> POTION_EFFECTS = new ArrayList<>();

    private static synchronized void ensureConfigLoaded() {
        if (CONFIG_LOADED) return;
        loadTransformConfig();
        loadHealConfig();
        loadPotionEffectsConfig();
        CONFIG_LOADED = true;
    }

    /**
     * 实体转换反馈效果
     */
    private static final FanEntityTransformHelper.TransformationFeedback ZOMBIE_STRAY_FEEDBACK =
            new FanEntityTransformHelper.TransformationFeedback(
                    SoundEvents.STRAY_AMBIENT,
                    SoundEvents.STRAY_STEP,
                    ParticleTypes.SNOWFLAKE
            );

    /**
     * 从配置文件加载实体转换规则
     */
    private static void loadTransformConfig() {
        List<? extends String> transforms = CommonConfig.SNOW_FLOW_ENTITY_TRANSFORMS.get();
        for (String transform : transforms) {
            String[] parts = transform.split("->");
            if (parts.length == 2) {

                try {
                    ResourceLocation inputLoc = ResourceLocation.tryParse(parts[0].trim());
                    ResourceLocation outputLoc = ResourceLocation.tryParse(parts[1].trim());
                    if (inputLoc != null && outputLoc != null) {
                        Optional<EntityType<?>> inputType = BuiltInRegistries.ENTITY_TYPE.getOptional(inputLoc);
                        Optional<EntityType<?>> outputType = BuiltInRegistries.ENTITY_TYPE.getOptional(outputLoc);

                        if (inputType.isPresent() && outputType.isPresent()) {
                            TRANSFORM_MAP.put(inputType.get(), outputType.get());
                        }
                    }
                } catch (Exception e) {
                    CreateMoreCatalysts.LOGGER.warn("[Batch Snow Flow]Invalid entity transform config: {}", transform);
                }
            }
        }
    }

    /**
     * 从配置文件加载治疗实体规则
     */
    private static void loadHealConfig() {
        List<? extends String> heals = CommonConfig.SNOW_FLOW_HEAL_ENTITIES.get();
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
                    String entityName = parts[0].trim();
                    String healValueStr = parts[1].trim();
                    CreateMoreCatalysts.LOGGER.warn("[Batch Snow Flow]Invalid heal amount for {}: {} (must be a number)", entityName, healValueStr);
                }
            }
        }
    }

    /**
     * 从配置文件加载状态效果规则
     */
    private static void loadPotionEffectsConfig() {
        POTION_EFFECTS.clear();
        List<? extends String> effects = CommonConfig.SNOW_FLOW_POTION_EFFECTS.get();
        for (String effect : effects) {
            String[] parts = effect.trim().split("\\s+");
            if (parts.length >= 3) {

                try {
                    ResourceLocation effectLoc = ResourceLocation.tryParse(parts[0]);
                    int duration = Integer.parseInt(parts[1]);
                    int amplifier = Integer.parseInt(parts[2]);

                    if (effectLoc != null) {
                        BuiltInRegistries.MOB_EFFECT.getHolder(effectLoc).ifPresent(eff ->
                                POTION_EFFECTS.add(new SnowFlowType.PotionEffectEntry(eff, duration, amplifier)));
                    }
                } catch (NumberFormatException e) {
                    CreateMoreCatalysts.LOGGER.warn("[Batch Snow Flow]Invalid potion effect config: {}", effect);
                }
            }
        }
    }

    /**
     * 构造函数
     */
    public SnowFlowType() {
        super(FanRecipeType.SNOW_FLOW);
    }

    /**
     * 检查鼓风机加工是否启用
     * @return 是否启用批量雪流鼓风机加工
     */
    @Override
    protected boolean isFanProcessingEnabled() {
        return CommonConfig.ENABLE_SNOW_FLOW_FAN.get();
    }

    /**
     * 验证催化剂有效性
     * @param level 世界实例
     * @param pos 待检测的位置
     * @return 该位置是否为有效的雪块催化剂位置
     */
    @Override
    public boolean isValidAt(Level level, BlockPos pos) {
        if (!isFanProcessingEnabled()) return false;
        return isValidCatalyst(level, pos,
                ModFluidTags.FAN_CATALYSTS_SNOW_FLOW,
                ModBlockTags.FAN_CATALYSTS_SNOW_FLOW
        );
    }

    /**
     * 获取优先级
     * @return 优先级数值
     */
    @Override
    public int getPriority() {
        return 2001;
    }

    /**
     * 生成加工粒子效果
     * @param level 世界实例
     * @param pos 粒子生成位置
     */
    @Override
    public void spawnProcessingParticles(Level level, Vec3 pos) {
        spawnDustWithParticle(level, pos, SNOW_COLOR, ParticleTypes.SNOWFLAKE);
    }

    /**
     * 修饰气流粒子
     * @param particleAccess 粒子访问器
     * @param random 随机数生成器
     */
    @Override
    public void morphAirFlow(AirFlowParticleAccess particleAccess, RandomSource random) {
        morphStandardAirFlow(particleAccess, random, AIRFLOW_COLOR, SNOW_COLOR, 0.06f, ParticleTypes.SNOWFLAKE);
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
            FanEntityTransformHelper.transformMob(level, living, mobType, ZOMBIE_STRAY_FEEDBACK);
            return;
        }

        // 为配置的实体提供治疗效果
        Float healAmount = HEAL_MAP.get(living.getType());
        if (healAmount != null) {
            living.heal(healAmount);
        }

        // 为配置的实体施加状态效果
        for (SnowFlowType.PotionEffectEntry entry : POTION_EFFECTS) {
            MobEffectInstance currentEffect = living.getEffect(entry.effect);
            if (currentEffect == null || currentEffect.getDuration() < 20) {
                living.addEffect(new MobEffectInstance(entry.effect, entry.duration, entry.amplifier, false, false));
            }
        }

        // 让实体进入细雪状态
        living.setTicksFrozen(living.getTicksRequiredToFreeze() + 20);

        // 播放音效
        FanProcessingSounds.snowFlowSound(level, living.blockPosition());
    }

    private record PotionEffectEntry(Holder.Reference<MobEffect> effect, int duration, int amplifier) {}
}
