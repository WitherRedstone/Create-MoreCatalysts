package com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.reduce;

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
 * 批量还原配方生成器
 */
public class ReduceRecipeGen extends MekanismFanRecipeGen<FanRecipe> {

    {
        // 氧化的铜块 → 铜块
        convert(() -> Ingredient.of(Items.OXIDIZED_COPPER), () -> Items.COPPER_BLOCK, 1.0f, new ModLoadedCondition("mekanism"));
        // 氧化的雕纹铜块 → 雕纹铜块
        convert(() -> Ingredient.of(Items.OXIDIZED_CHISELED_COPPER), () -> Items.CHISELED_COPPER, 1.0f, new ModLoadedCondition("mekanism"));
        // 氧化的铜格栅 → 铜格栅
        convert(() -> Ingredient.of(Items.OXIDIZED_COPPER_GRATE), () -> Items.COPPER_GRATE, 1.0f, new ModLoadedCondition("mekanism"));
        // 氧化的切制铜块 → 切制铜块
        convert(() -> Ingredient.of(Items.OXIDIZED_CUT_COPPER), () -> Items.CUT_COPPER, 1.0f, new ModLoadedCondition("mekanism"));
        // 氧化的切制铜楼梯 → 切制铜楼梯
        convert(() -> Ingredient.of(Items.OXIDIZED_CUT_COPPER_STAIRS), () -> Items.CUT_COPPER_STAIRS, 1.0f, new ModLoadedCondition("mekanism"));
        // 氧化的切制铜台阶 → 切制铜台阶
        convert(() -> Ingredient.of(Items.OXIDIZED_CUT_COPPER_SLAB), () -> Items.CUT_COPPER_SLAB, 1.0f, new ModLoadedCondition("mekanism"));
        // 氧化的铜门 → 铜门
        convert(() -> Ingredient.of(Items.OXIDIZED_COPPER_DOOR), () -> Items.COPPER_DOOR, 1.0f, new ModLoadedCondition("mekanism"));
        // 氧化的铜活板门 → 铜活板门
        convert(() -> Ingredient.of(Items.OXIDIZED_COPPER_TRAPDOOR), () -> Items.COPPER_TRAPDOOR, 1.0f, new ModLoadedCondition("mekanism"));
        // 氧化的铜灯 → 铜灯
        convert(() -> Ingredient.of(Items.OXIDIZED_COPPER_BULB), () -> Items.COPPER_BULB, 1.0f, new ModLoadedCondition("mekanism"));

    }

    @Override
    protected MekanismFanRecipeType.RecipeTypeEntry getRecipeType() {
        return MekanismFanRecipeType.REDUCE;
    }

    public ReduceRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateMoreCatalysts.MOD_ID);
    }
}
