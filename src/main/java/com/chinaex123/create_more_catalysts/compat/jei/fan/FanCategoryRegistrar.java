package com.chinaex123.create_more_catalysts.compat.jei.fan;

import com.chinaex123.create_more_catalysts.init.FanRecipeType;
import com.chinaex123.create_more_catalysts.init.integration.ImmersiveEngineering.ImmersiveEngineeringFanRecipeType;
import com.chinaex123.create_more_catalysts.init.integration.Mekanism.MekanismFanRecipeType;
import com.simibubi.create.AllFluids;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.fml.ModList;

/**
 * 配方类别注册器：负责注册所有鼓风机加工类型的 JEI 配方类别
 */
public final class FanCategoryRegistrar {

    private final FanJeiCategories fanCategories = new FanJeiCategories();
    private final MekanismJeiCategories mekanismCategories = new MekanismJeiCategories();
    private final ImmersiveEngineeringJeiCategories immersiveengineeringCategories = new ImmersiveEngineeringJeiCategories();

    /**
     * 注册所有配方类别
     */
    public void registerAll() {
        registerVanillaCategories();
        registerMekanismCategories();
        registerImmersiveEngineeringCategories();
    }

    /**
     * 注册模组本体的配方类别
     */
    private void registerVanillaCategories() {
        // ==================== 方块触媒 ====================
        // 鼓风机 - 批量凋零
        fanCategories.addBlockCategory("fan_withering", FanRecipeType.WITHERING, Blocks.WITHER_ROSE);
        // 鼓风机 - 批量雪流
        fanCategories.addBlockCategory("fan_snow_flow", FanRecipeType.SNOW_FLOW, Blocks.POWDER_SNOW);
        // 鼓风机 - 批量净化
        fanCategories.addBlockCategory("fan_purifying", FanRecipeType.PURIFYING, Blocks.BEACON);
        // 鼓风机 - 批量幽匿
        fanCategories.addBlockCategory("fan_sculking", FanRecipeType.SCULKING, Blocks.SCULK);
        // 鼓风机 - 批量共振
        fanCategories.addBlockCategory("fan_resonance", FanRecipeType.RESONANCE, Blocks.AMETHYST_CLUSTER);
        // 鼓风机 - 批量扬砂
        fanCategories.addBlockCategory("fan_sand_blow", FanRecipeType.SAND_BLOW, Blocks.SAND);
        // 鼓风机 - 批量吐息
        fanCategories.addHeadCategory("fan_breathed_wind", FanRecipeType.BREATHED_WIND, Blocks.DRAGON_HEAD);
        // 鼓风机 - 批量爆炸
        fanCategories.addHeadCategory("fan_exploding", FanRecipeType.EXPLODING, Blocks.CREEPER_HEAD);
        // ==================== 流体触媒 ====================
        // 鼓风机 - 批量裹蜜
        fanCategories.addFluidCategory("fan_honey_coating", FanRecipeType.HONEY_COATING, AllFluids.HONEY.get());
        // 鼓风机 - 批量凝巧
        fanCategories.addFluidCategory("fan_chocolate_coating", FanRecipeType.CHOCOLATE_COATING, AllFluids.CHOCOLATE.get());
    }

    /**
     * 注册模组联动的配方类别
     */
    private void registerMekanismCategories() {
        if (!ModList.get().isLoaded("mekanism")) return;

        // 鼓风机 - 批量盐析
        mekanismCategories.addFluidCategory("fan_salout", MekanismFanRecipeType.SALOUT,
                BuiltInRegistries.FLUID.get(ResourceLocation.parse("mekanism:brine")));
        // 鼓风机 - 批量蚀刻
        mekanismCategories.addFluidCategory("fan_etch", MekanismFanRecipeType.ETCH,
                BuiltInRegistries.FLUID.get(ResourceLocation.parse("mekanism:hydrofluoric_acid")));
        // 鼓风机 - 批量磺化
        mekanismCategories.addFluidCategory("fan_sulfon", MekanismFanRecipeType.SULFON,
                BuiltInRegistries.FLUID.get(ResourceLocation.parse("mekanism:sulfur_dioxide")));
        // 鼓风机 - 批量脱水
        mekanismCategories.addFluidCategory("fan_dehyd", MekanismFanRecipeType.DEHYD,
                BuiltInRegistries.FLUID.get(ResourceLocation.parse("mekanism:sulfuric_acid")));
        // 鼓风机 - 批量氧化
        mekanismCategories.addFluidCategory("fan_oxidize", MekanismFanRecipeType.OXIDIZE,
                BuiltInRegistries.FLUID.get(ResourceLocation.parse("mekanism:oxygen")));
        // 鼓风机 - 批量还原
        mekanismCategories.addFluidCategory("fan_reduce", MekanismFanRecipeType.REDUCE,
                BuiltInRegistries.FLUID.get(ResourceLocation.parse("mekanism:hydrogen")));
        // 鼓风机 - 批量发酵
        mekanismCategories.addFluidCategory("fan_ferment", MekanismFanRecipeType.FERMENT,
                BuiltInRegistries.FLUID.get(ResourceLocation.parse("mekanismgenerators:bioethanol")));
    }

    /**
     * 注册模组联动的配方类别
     */
    private void registerImmersiveEngineeringCategories() {
        if (!ModList.get().isLoaded("immersiveengineering")) return;
        // 鼓风机 - 批量防腐
        immersiveengineeringCategories.addFluidCategory("fan_preservation", ImmersiveEngineeringFanRecipeType.PRESERVATION,
                BuiltInRegistries.FLUID.get(ResourceLocation.parse("immersiveengineering:creosote")));
    }

    /**
     * 获取鼓风机配方类别管理器
     * @return 鼓风机配方类别管理器
     */
    public FanJeiCategories getFanCategories() {
        return fanCategories;
    }

    /**
     * 获取通用机械联动配方类别管理器
     * @return 通用机械联动配方类别管理器
     */
    public MekanismJeiCategories getMekanismCategories() {
        return mekanismCategories;
    }

    /**
     * 获取通用机械联动配方类别管理器
     * @return 通用机械联动配方类别管理器
     */
    public ImmersiveEngineeringJeiCategories getImmersiveEngineeringCategories() {
        return immersiveengineeringCategories;
    }
}
