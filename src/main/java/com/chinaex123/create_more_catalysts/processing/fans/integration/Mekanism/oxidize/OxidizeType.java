package com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.oxidize;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.config.CommonConfig;
import com.chinaex123.create_more_catalysts.init.ModBlockTags;
import com.chinaex123.create_more_catalysts.init.ModFluidTags;
import com.chinaex123.create_more_catalysts.init.integration.Mekanism.MekanismFanRecipeType;
import com.chinaex123.create_more_catalysts.processing.fans.FanEntityTransformHelper;
import com.chinaex123.create_more_catalysts.processing.fans.FanProcessingSounds;
import com.chinaex123.create_more_catalysts.processing.fans.MekanismFanCommonType;
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
 * 批量氧化鼓风机类型
 */
public final class OxidizeType extends MekanismFanCommonType {

    private static final int AIRFLOW_COLOR = 0x2E8B57;
    private static final int OXIDIZE_COLOR = 0x3BB16F;

    private static final Map<EntityType<?>, EntityType<?>> TRANSFORM_MAP = new HashMap<>();
    private static final Map<EntityType<?>, Float> HEAL_MAP = new HashMap<>();
    private static boolean CONFIG_LOADED = false;
    private static final List<PotionEffectEntry> POTION_EFFECTS = new ArrayList<>();

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
    private static final FanEntityTransformHelper.TransformationFeedback OXIDIZE_TRANSFORM_FEEDBACK =
            new FanEntityTransformHelper.TransformationFeedback(
                    SoundEvents.AMETHYST_BLOCK_CHIME,
                    SoundEvents.COPPER_BREAK,
                    ParticleTypes.FLAME
            );

    /**
     * 从配置文件加载实体转换规则
     */
    private static void loadTransformConfig() {
        List<? extends String> transforms = CommonConfig.OXIDIZE_ENTITY_TRANSFORMS.get();
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
                    CreateMoreCatalysts.LOGGER.warn("[Batch Oxidize]Invalid entity transform config: {}", transform);
                }
            }
        }
    }

    /**
     * 从配置文件加载治疗实体规则
     */
    private static void loadHealConfig() {
        List<? extends String> heals = CommonConfig.OXIDIZE_HEAL_ENTITIES.get();
        for (String heal : heals) {
            String[] parts = heal.split("->");
            if (parts.length == 2) {

                try {
                    ResourceLocation entityLoc = ResourceLocation.tryParse(parts[0].trim());
                    float healAmount = Float.parseFloat(parts[1].trim());
                    if (entityLoc != null) {
                        Optional<EntityType<?>> entityType = BuiltInRegistries.ENTITY_TYPE.getOptional(entityLoc);
                        entityType.ifPresent(type -> HEAL_MAP.put(type, healAmount));
                    }
                } catch (NumberFormatException e) {
                    String entityName = parts[0].trim();
                    String healValueStr = parts[1].trim();
                    CreateMoreCatalysts.LOGGER.warn("[Batch Oxidize]Invalid heal amount for {}: {} (must be a number)", entityName, healValueStr);
                }
            }
        }
    }

    /**
     * 从配置文件加载状态效果规则
     */
    private static void loadPotionEffectsConfig() {
        POTION_EFFECTS.clear();
        List<? extends String> effects = CommonConfig.OXIDIZE_POTION_EFFECTS.get();
        for (String effect : effects) {
            String[] parts = effect.trim().split("\\s+");
            if (parts.length >= 3) {

                try {
                    ResourceLocation effectLoc = ResourceLocation.tryParse(parts[0]);
                    int duration = Integer.parseInt(parts[1]);
                    int amplifier = Integer.parseInt(parts[2]);

                    if (effectLoc != null) {
                        BuiltInRegistries.MOB_EFFECT.getHolder(effectLoc).ifPresent(eff ->
                                POTION_EFFECTS.add(new PotionEffectEntry(eff, duration, amplifier)));
                    }
                } catch (NumberFormatException e) {
                    CreateMoreCatalysts.LOGGER.warn("[Batch Oxidize]Invalid potion effect config: {}", effect);
                }
            }
        }
    }

    public OxidizeType() {
        super(MekanismFanRecipeType.OXIDIZE);
    }

    /**
     * 检查鼓风机加工是否启用
     * @return 是否启用批量氧化鼓风机加工
     */
    @Override
    protected boolean isFanProcessingEnabled() {
        return CommonConfig.ENABLE_OXIDIZE_FAN.get();
    }

    /**
     * 验证催化剂有效性
     * @param level 世界实例
     * @param pos 待检测的位置
     * @return 该位置是否为有效的催化剂位置
     */
    @Override
    public boolean isValidAt(Level level, BlockPos pos) {
        if (!isFanProcessingEnabled()) return false;
        return isValidCatalyst(level, pos,
                ModFluidTags.FAN_CATALYSTS_OXIDIZE,
                ModBlockTags.FAN_CATALYSTS_OXIDIZE
        );
    }

    /**
     * 获取优先级
     * @return 优先级数值
     */
    @Override
    public int getPriority() {
        return 2204;
    }

    /**
     * 生成加工粒子效果
     * @param level 世界实例
     * @param pos 粒子生成位置
     */
    @Override
    public void spawnProcessingParticles(Level level, Vec3 pos) {
        spawnDustWithParticle(level, pos, OXIDIZE_COLOR, ParticleTypes.GLOW);
    }

    /**
     * 修饰气流粒子
     * @param particleAccess 粒子访问器
     * @param random 随机数生成器
     */
    @Override
    public void morphAirFlow(AirFlowParticleAccess particleAccess, RandomSource random) {
        morphStandardAirFlow(particleAccess, random, AIRFLOW_COLOR, OXIDIZE_COLOR, 0.02f, ParticleTypes.GLOW_SQUID_INK);
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
            FanEntityTransformHelper.transformMob(level, living, mobType, OXIDIZE_TRANSFORM_FEEDBACK);
            return;
        }

        // 为配置的实体提供治疗效果
        Float healAmount = HEAL_MAP.get(living.getType());
        if (healAmount != null) {
            living.heal(healAmount);
            return;
        }

        // 为配置的实体施加状态效果
        for (PotionEffectEntry entry : POTION_EFFECTS) {
            MobEffectInstance currentEffect = living.getEffect(entry.effect);
            if (currentEffect == null || currentEffect.getDuration() < 20) {
                living.addEffect(new MobEffectInstance(entry.effect, entry.duration, entry.amplifier, false, false));
            }
        }

        // 播放音效
        FanProcessingSounds.oxidizeSound(level, living.blockPosition());
    }

    private record PotionEffectEntry(Holder.Reference<MobEffect> effect, int duration, int amplifier) {}
}
