package com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.dehyd;

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
 * 批量脱水配方生成器
 */
public class DehydRecipeGen extends MekanismFanRecipeGen<FanRecipe> {

    {
        // 海带 → 干海带
        convert(() -> Ingredient.of(Items.KELP), () -> Items.DRIED_KELP, 1.0f, new ModLoadedCondition("mekanism"));
        // 海绵 → 湿海绵
        convert(() -> Ingredient.of(Items.WET_SPONGE), () -> Items.SPONGE, 1.0f, new ModLoadedCondition("mekanism"));
    }

    @Override
    protected MekanismFanRecipeType.RecipeTypeEntry getRecipeType() {
        return MekanismFanRecipeType.DEHYD;
    }

    public DehydRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateMoreCatalysts.MOD_ID);
    }
}
