package com.chinaex123.create_more_catalysts.compat.jei;

import com.chinaex123.create_more_catalysts.compat.jei.fan.AnvilcraftJeiCategories;
import com.chinaex123.create_more_catalysts.compat.jei.fan.FanJeiCategories;
import com.chinaex123.create_more_catalysts.compat.jei.fan.ImmersiveEngineeringJeiCategories;
import com.chinaex123.create_more_catalysts.compat.jei.fan.MekanismJeiCategories;
import com.chinaex123.create_more_catalysts.init.FanRecipeType;
import com.chinaex123.create_more_catalysts.init.integration.Anvilcraft.AnvilcraftFanRecipeType;
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
    private final AnvilcraftJeiCategories anvilcraftCategories = new AnvilcraftJeiCategories();

    /**
     * 注册所有配方类别
     */
    public void registerAll() {
        registerVanillaCategories();
        registerMekanismCategories();
        registerImmersiveEngineeringCategories();
        registerAnvilcraftCategories();
    }

    /**
     * 注册模组本体的配方类别
     */
    private void registerVanillaCategories() {
        // ==================== 方块触媒 ====================
        // 批量凋零
        fanCategories.addBlockCategory("fan_withering", FanRecipeType.WITHERING, Blocks.WITHER_ROSE);
        // 批量雪流
        fanCategories.addBlockCategory("fan_snow_flow", FanRecipeType.SNOW_FLOW, Blocks.POWDER_SNOW);
        // 批量净化
        fanCategories.addBlockCategory("fan_purifying", FanRecipeType.PURIFYING, Blocks.BEACON);
        // 批量幽匿
        fanCategories.addBlockCategory("fan_sculking", FanRecipeType.SCULKING, Blocks.SCULK);
        // 批量共振
        fanCategories.addBlockCategory("fan_resonance", FanRecipeType.RESONANCE, Blocks.AMETHYST_CLUSTER);
        // 批量扬砂
        fanCategories.addBlockCategory("fan_sand_blow", FanRecipeType.SAND_BLOW, Blocks.SAND);
        // 批量吐息
        fanCategories.addHeadCategory("fan_breathed_wind", FanRecipeType.BREATHED_WIND, Blocks.DRAGON_HEAD);
        // 批量爆炸
        fanCategories.addHeadCategory("fan_exploding", FanRecipeType.EXPLODING, Blocks.CREEPER_HEAD);
        // 批量海潮
        fanCategories.addConduitCategory("fan_tidal", FanRecipeType.TIDAL);
        // 批量催泪
        fanCategories.addBlockCategory("fan_tear", FanRecipeType.TEAR, Blocks.CRYING_OBSIDIAN);
        // 批量苔化
        fanCategories.addBlockCategory("fan_mossify", FanRecipeType.MOSSIFY, Blocks.MOSS_BLOCK);
        // ==================== 流体触媒 ====================
        // 批量裹蜜
        fanCategories.addFluidCategory("fan_honey_coating", FanRecipeType.HONEY_COATING, AllFluids.HONEY.get());
        // 批量凝巧
        fanCategories.addFluidCategory("fan_chocolate_coating", FanRecipeType.CHOCOLATE_COATING, AllFluids.CHOCOLATE.get());
    }

    /**
     * 注册模组联动的配方类别
     */
    private void registerMekanismCategories() {
        if (!ModList.get().isLoaded("mekanism")) return;

        // 批量盐析
        mekanismCategories.addFluidCategory("fan_salout", MekanismFanRecipeType.SALOUT,
                BuiltInRegistries.FLUID.get(ResourceLocation.parse("mekanism:brine")));
        // 批量蚀刻
        mekanismCategories.addFluidCategory("fan_etch", MekanismFanRecipeType.ETCH,
                BuiltInRegistries.FLUID.get(ResourceLocation.parse("mekanism:hydrofluoric_acid")));
        // 批量磺化
        mekanismCategories.addFluidCategory("fan_sulfon", MekanismFanRecipeType.SULFON,
                BuiltInRegistries.FLUID.get(ResourceLocation.parse("mekanism:sulfur_dioxide")));
        // 批量脱水
        mekanismCategories.addFluidCategory("fan_dehyd", MekanismFanRecipeType.DEHYD,
                BuiltInRegistries.FLUID.get(ResourceLocation.parse("mekanism:sulfuric_acid")));
        // 批量氧化
        mekanismCategories.addFluidCategory("fan_oxidize", MekanismFanRecipeType.OXIDIZE,
                BuiltInRegistries.FLUID.get(ResourceLocation.parse("mekanism:oxygen")));
        // 批量还原
        mekanismCategories.addFluidCategory("fan_reduce", MekanismFanRecipeType.REDUCE,
                BuiltInRegistries.FLUID.get(ResourceLocation.parse("mekanism:hydrogen")));
        // 批量发酵
        mekanismCategories.addFluidCategory("fan_ferment", MekanismFanRecipeType.FERMENT,
                BuiltInRegistries.FLUID.get(ResourceLocation.parse("mekanismgenerators:bioethanol")));
    }

    /**
     * 注册模组联动的配方类别
     */
    private void registerImmersiveEngineeringCategories() {
        if (!ModList.get().isLoaded("immersiveengineering")) return;
        // 批量防腐
        immersiveengineeringCategories.addFluidCategory("fan_preservation", ImmersiveEngineeringFanRecipeType.PRESERVATION,
                BuiltInRegistries.FLUID.get(ResourceLocation.parse("immersiveengineering:creosote")));
    }

    /**
     * 注册模组联动的配方类别
     */
    private void registerAnvilcraftCategories() {
        boolean anvilcraftLoaded = ModList.get().isLoaded("anvilcraft");
        boolean l2hostilityLoaded = ModList.get().isLoaded("l2hostility");

        if (!anvilcraftLoaded && !l2hostilityLoaded) return;

        ResourceLocation beaconLoc = anvilcraftLoaded
                ? ResourceLocation.parse("anvilcraft:corrupted_beacon")
                : ResourceLocation.parse("l2hostility:hostility_beacon");

        // 批量腐化
        anvilcraftCategories.addBlockCategory("fan_corrupted", AnvilcraftFanRecipeType.CORRUPTED,
                BuiltInRegistries.BLOCK.get(beaconLoc));
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

    /**
     * 获取铁砧工艺联动配方类别管理器
     * @return 铁砧工艺联动配方类别管理器
     */
    public AnvilcraftJeiCategories getAnvilcraftCategories() {
        return anvilcraftCategories;
    }
}
