package com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.sulfon;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.MekanismFanRecipeGen;
import com.chinaex123.create_more_catalysts.init.integration.Mekanism.MekanismFanRecipeType;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;

/**
 * 批量磺化配方生成器
 */
public class SulfonRecipeGen extends MekanismFanRecipeGen {

    {
        // 红石 → 火药
        convert(() -> Ingredient.of(Items.REDSTONE), () -> Items.GUNPOWDER, 1.0f, new ModLoadedCondition("mekanism"));
    }

    @Override
    protected MekanismFanRecipeType.RecipeTypeEntry getRecipeType() {
        return MekanismFanRecipeType.SULFON;
    }

    public SulfonRecipeGen(PackOutput output) {
        super(output, CreateMoreCatalysts.MOD_ID);
    }
}
