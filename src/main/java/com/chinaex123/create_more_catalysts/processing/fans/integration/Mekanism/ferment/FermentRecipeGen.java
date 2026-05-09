package com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.ferment;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.MekanismFanRecipeGen;
import com.chinaex123.create_more_catalysts.init.integration.Mekanism.MekanismFanRecipeType;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;

/**
 * 批量发酵配方生成器
 */
public class FermentRecipeGen extends MekanismFanRecipeGen {

    {
        // 小麦 → 面包
        convert(() -> Ingredient.of(Items.WHEAT), () -> Items.BREAD, 1.0f, new ModLoadedCondition("mekanismgenerators"));
    }

    @Override
    protected MekanismFanRecipeType.RecipeTypeEntry getRecipeType() {
        return MekanismFanRecipeType.FERMENT;
    }

    public FermentRecipeGen(PackOutput output) {
        super(output,CreateMoreCatalysts.MOD_ID);
    }
}
