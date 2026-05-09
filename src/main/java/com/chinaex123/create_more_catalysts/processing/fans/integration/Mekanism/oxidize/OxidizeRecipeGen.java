package com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.oxidize;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.MekanismFanRecipeGen;
import com.chinaex123.create_more_catalysts.init.integration.Mekanism.MekanismFanRecipeType;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;

/**
 * 批量氧化配方生成器
 */
public class OxidizeRecipeGen extends MekanismFanRecipeGen {

    {
        // 铜块 → 氧化的铜块
        convert(() -> Ingredient.of(Items.COPPER_BLOCK), () -> Items.OXIDIZED_COPPER, 1.0f, new ModLoadedCondition("mekanism"));
        // 切制铜块 → 氧化的切制铜块
        convert(() -> Ingredient.of(Items.CUT_COPPER), () -> Items.OXIDIZED_CUT_COPPER, 1.0f, new ModLoadedCondition("mekanism"));
        // 切制铜楼梯 → 氧化的切制铜楼梯
        convert(() -> Ingredient.of(Items.CUT_COPPER_STAIRS), () -> Items.OXIDIZED_CUT_COPPER_STAIRS, 1.0f, new ModLoadedCondition("mekanism"));
        // 切制铜台阶 → 氧化的切制铜台阶
        convert(() -> Ingredient.of(Items.CUT_COPPER_SLAB), () -> Items.OXIDIZED_CUT_COPPER_SLAB, 1.0f, new ModLoadedCondition("mekanism"));
    }

    @Override
    protected MekanismFanRecipeType.RecipeTypeEntry getRecipeType() {
        return MekanismFanRecipeType.OXIDIZE;
    }

    public OxidizeRecipeGen(PackOutput output) {
        super(output, CreateMoreCatalysts.MOD_ID);
    }
}
