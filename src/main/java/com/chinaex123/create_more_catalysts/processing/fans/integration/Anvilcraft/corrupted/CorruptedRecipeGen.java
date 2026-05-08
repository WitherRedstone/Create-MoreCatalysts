package com.chinaex123.create_more_catalysts.processing.fans.integration.Anvilcraft.corrupted;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.AnvilcraftFanRecipeGen;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipe;
import com.chinaex123.create_more_catalysts.init.integration.Anvilcraft.AnvilcraftFanRecipeType;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.conditions.OrCondition;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 批量腐化配方生成器
 */
public class CorruptedRecipeGen extends AnvilcraftFanRecipeGen<FanRecipe> {

    {
        // 任何生肉 → 腐肉
        convert(() -> Ingredient.of(Tags.Items.FOODS_RAW_MEAT),
                new OrCondition(List.of(
                        new ModLoadedCondition("anvilcraft"),
                        new ModLoadedCondition("l2hostility")
                )),
                new OutputEntry(1.0f, Items.ROTTEN_FLESH, 4),
                new OutputEntry(0.25f, Items.ROTTEN_FLESH, 2)
        );
    }

    @Override
    protected AnvilcraftFanRecipeType.RecipeTypeEntry getRecipeType() {
        return AnvilcraftFanRecipeType.CORRUPTED;
    }

    public CorruptedRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateMoreCatalysts.MOD_ID);
    }
}
