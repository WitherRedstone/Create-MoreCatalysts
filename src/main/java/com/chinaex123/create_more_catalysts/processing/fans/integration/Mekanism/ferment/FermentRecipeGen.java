package com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.ferment;

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
 * 批量发酵配方生成器
 */
public class FermentRecipeGen extends MekanismFanRecipeGen<FanRecipe> {

    {
        // 小麦 → 面包
        convert(() -> Ingredient.of(Items.WHEAT), () -> Items.BREAD, 1.0f, new ModLoadedCondition("mekanismgenerators"));
    }

    @Override
    protected MekanismFanRecipeType.RecipeTypeEntry getRecipeType() {
        return MekanismFanRecipeType.FERMENT;
    }

    public FermentRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateMoreCatalysts.MOD_ID);
    }
}
