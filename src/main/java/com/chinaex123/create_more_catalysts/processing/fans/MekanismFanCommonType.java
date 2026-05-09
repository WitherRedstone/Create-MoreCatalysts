package com.chinaex123.create_more_catalysts.processing.fans;

import com.chinaex123.create_more_catalysts.init.integration.Mekanism.MekanismFanRecipeType;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.foundation.recipe.RecipeApplier;
import net.createmod.catnip.theme.Color;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

import javax.annotation.Nullable;
import java.util.List;

/**
 * 通用机械鼓风机加工类型基类
 */
public abstract class MekanismFanCommonType implements FanProcessingType {

    private final MekanismFanRecipeType.RecipeTypeEntry recipeType;

    /**
     * 构造函数：绑定特定的鼓风机配方类型
     * @param recipeType 鼓风机配方类型入口
     */
    protected MekanismFanCommonType(MekanismFanRecipeType.RecipeTypeEntry recipeType) {
        this.recipeType = recipeType;
    }

    /**
     * 检查鼓风机加工功能是否启用：由子类读取配置实现
     * @return 是否启用该类型的鼓风机加工
     */
    protected abstract boolean isFanProcessingEnabled();

    /**
     * 判断物品是否可被此鼓风机类型处理：查询是否存在匹配的配方
     * @param stack 待处理的物品堆
     * @param level 世界实例
     * @return 是否存在对应配方
     */
    @Override
    public boolean canProcess(ItemStack stack, Level level) {
        if (!isFanProcessingEnabled()) return false;
        return recipeType.find(new SimpleContainer(stack), level).isPresent();
    }

    /**
     * 处理物品：应用匹配的鼓风机配方并返回结果
     * @param stack 输入物品堆
     * @param level 世界实例
     * @return 处理后的物品列表，无匹配配方时返回 null
     */
    @Override
    @Nullable
    public List<ItemStack> process(ItemStack stack, Level level) {
        if (!isFanProcessingEnabled()) return null;
        return recipeType.find(new SimpleContainer(stack), level)
                .map(recipe -> RecipeApplier.applyRecipeOn(level, stack, recipe, false))
                .orElse(null);
    }

    /**
     * 影响实体：对进入鼓风机范围的生物实体施加效果（仅服务端执行）
     * @param entity 受影响的实体
     * @param level 世界实例
     */
    @Override
    public final void affectEntity(Entity entity, Level level) {
        if (!isFanProcessingEnabled()) return;
        if (level.isClientSide || !(entity instanceof LivingEntity living)) return;
        affectLivingEntity(living, level);
    }

    /**
     * 影响生物实体：由子类实现具体的生物效果逻辑
     * @param living 受影响的生物实体
     * @param level 世界实例
     */
    protected abstract void affectLivingEntity(LivingEntity living, Level level);

    /**
     * 生成双色粒子效果：在指定位置随机生成尘埃粒子和次级粒子
     * @param level 世界实例
     * @param pos 粒子生成位置
     * @param colorLight 浅色粒子颜色值
     * @param secondary 次级粒子类型
     */
    protected static void spawnDustWithParticle(Level level, Vec3 pos, int colorLight, ParticleOptions secondary) {
        if (level.random.nextInt(12) != 0) return;
        Vector3f color = new Color(colorLight).asVectorF();
        level.addParticle(new DustParticleOptions(color, 1),
                pos.x + (level.random.nextFloat() - 0.5f) * 0.5f, pos.y + 0.5f,
                pos.z + (level.random.nextFloat() - 0.5f) * 0.5f, 0, 0.125f, 0);
        level.addParticle(secondary,
                pos.x + (level.random.nextFloat() - 0.5f) * 0.5f, pos.y + 0.5f,
                pos.z + (level.random.nextFloat() - 0.5f) * 0.5f, 0, 0.125f, 0);
    }

    /**
     * 修饰标准气流粒子：设置渐变色并随机生成额外粒子
     * @param access 气流粒子访问器
     * @param random 随机数生成器
     * @param colorDark 深色值
     * @param colorLight 浅色值
     * @param extraChance 额外粒子生成概率
     * @param extraParticle 额外粒子类型
     */
    protected static void morphStandardAirFlow(AirFlowParticleAccess access, RandomSource random, int colorDark, int colorLight, float extraChance, ParticleOptions extraParticle) {
        access.setColor(Color.mixColors(colorDark, colorLight, random.nextFloat()));
        access.setAlpha(1f);
        if (random.nextFloat() < extraChance)
            access.spawnExtraParticle(extraParticle, 0.125f);
    }

    /**
     * 验证方块催化剂有效性：仅检查方块标签
     * @param level 世界实例
     * @param pos 待检测位置
     * @param blockTag 方块标签
     * @return 是否为有效方块催化剂位置
     */
    protected static boolean isValidBlockCatalyst(Level level, BlockPos pos, TagKey<Block> blockTag) {
        return level.getBlockState(pos).is(blockTag);
    }

    /**
     * 验证流体催化剂有效性：仅检查流体标签
     * @param level 世界实例
     * @param pos 待检测位置
     * @param fluidTag 流体标签
     * @return 是否为有效流体催化剂位置
     */
    protected static boolean isValidFluidCatalyst(Level level, BlockPos pos, TagKey<Fluid> fluidTag) {
        return level.getFluidState(pos).is(fluidTag);
    }

    /**
     * 验证催化剂有效性：检查位置是否匹配指定的流体或方块标签
     * @param level 世界实例
     * @param pos 待检测位置
     * @param fluidTag 流体标签
     * @param blockTag 方块标签
     * @return 是否为有效催化剂位置
     */
    protected static boolean isValidCatalyst(Level level, BlockPos pos, TagKey<Fluid> fluidTag, TagKey<Block> blockTag) {
        return level.getFluidState(pos).is(fluidTag) || level.getBlockState(pos).is(blockTag);
    }
}
