package com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.oxidize;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipe;
import com.chinaex123.create_more_catalysts.data.recipe.MekanismFanRecipeGen;
import com.chinaex123.create_more_catalysts.init.integration.Mekanism.MekanismFanRecipeType;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;

/**
 * 批量氧化配方生成器
 */
public class OxidizeRecipeGen extends MekanismFanRecipeGen<FanRecipe> {

    {
        // 铜块 → 氧化的铜块
        convert(() -> Ingredient.of(Items.COPPER_BLOCK), () -> Items.OXIDIZED_COPPER, 1.0f, new ModLoadedCondition("mekanism"));
        // 雕纹铜块 → 氧化的雕纹铜块
        convert(() -> Ingredient.of(Items.CHISELED_COPPER), () -> Items.OXIDIZED_CHISELED_COPPER, 1.0f, new ModLoadedCondition("mekanism"));
        // 铜格栅 → 氧化的铜格栅
        convert(() -> Ingredient.of(Items.COPPER_GRATE), () -> Items.OXIDIZED_COPPER_GRATE, 1.0f, new ModLoadedCondition("mekanism"));
        // 切制铜块 → 氧化的切制铜块
        convert(() -> Ingredient.of(Items.CUT_COPPER), () -> Items.OXIDIZED_CUT_COPPER, 1.0f, new ModLoadedCondition("mekanism"));
        // 切制铜楼梯 → 氧化的切制铜楼梯
        convert(() -> Ingredient.of(Items.CUT_COPPER_STAIRS), () -> Items.OXIDIZED_CUT_COPPER_STAIRS, 1.0f, new ModLoadedCondition("mekanism"));
        // 切制铜台阶 → 氧化的切制铜台阶
        convert(() -> Ingredient.of(Items.CUT_COPPER_SLAB), () -> Items.OXIDIZED_CUT_COPPER_SLAB, 1.0f, new ModLoadedCondition("mekanism"));
        // 铜门 → 氧化的铜门
        convert(() -> Ingredient.of(Items.COPPER_DOOR), () -> Items.OXIDIZED_COPPER_DOOR, 1.0f, new ModLoadedCondition("mekanism"));
        // 铜活板门 → 氧化的铜活板门
        convert(() -> Ingredient.of(Items.COPPER_TRAPDOOR), () -> Items.OXIDIZED_COPPER_TRAPDOOR, 1.0f, new ModLoadedCondition("mekanism"));
        // 铜灯 → 氧化的铜灯
        convert(() -> Ingredient.of(Items.COPPER_BULB), () -> Items.OXIDIZED_COPPER_BULB, 1.0f, new ModLoadedCondition("mekanism"));
    }

    @Override
    protected MekanismFanRecipeType.RecipeTypeEntry getRecipeType() {
        return MekanismFanRecipeType.OXIDIZE;
    }

    public OxidizeRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateMoreCatalysts.MOD_ID);
    }
}
