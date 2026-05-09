package com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.reduce;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.MekanismFanRecipeGen;
import com.chinaex123.create_more_catalysts.init.integration.Mekanism.MekanismFanRecipeType;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;

/**
 * 批量还原配方生成器
 */
public class ReduceRecipeGen extends MekanismFanRecipeGen {

    {
        // 氧化的铜块 → 铜块
        convert(() -> Ingredient.of(Items.OXIDIZED_COPPER), () -> Items.COPPER_BLOCK, 1.0f, new ModLoadedCondition("mekanism"));
        // 氧化的切制铜块 → 切制铜块
        convert(() -> Ingredient.of(Items.OXIDIZED_CUT_COPPER), () -> Items.CUT_COPPER, 1.0f, new ModLoadedCondition("mekanism"));
        // 氧化的切制铜楼梯 → 切制铜楼梯
        convert(() -> Ingredient.of(Items.OXIDIZED_CUT_COPPER_STAIRS), () -> Items.CUT_COPPER_STAIRS, 1.0f, new ModLoadedCondition("mekanism"));
        // 氧化的切制铜台阶 → 切制铜台阶
        convert(() -> Ingredient.of(Items.OXIDIZED_CUT_COPPER_SLAB), () -> Items.CUT_COPPER_SLAB, 1.0f, new ModLoadedCondition("mekanism"));

    }

    @Override
    protected MekanismFanRecipeType.RecipeTypeEntry getRecipeType() {
        return MekanismFanRecipeType.REDUCE;
    }

    public ReduceRecipeGen(PackOutput output) {
        super(output, CreateMoreCatalysts.MOD_ID);
    }
}
