package com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.sulfon;

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
 * 批量磺化配方生成器
 */
public class SulfonRecipeGen extends MekanismFanRecipeGen<FanRecipe> {

    {
        // 红石 → 火药
        convert(() -> Ingredient.of(Items.REDSTONE), () -> Items.GUNPOWDER, 1.0f, new ModLoadedCondition("mekanism"));
    }

    @Override
    protected MekanismFanRecipeType.RecipeTypeEntry getRecipeType() {
        return MekanismFanRecipeType.SULFON;
    }

    public SulfonRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateMoreCatalysts.MOD_ID);
    }
}
