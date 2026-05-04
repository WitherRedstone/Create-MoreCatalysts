package com.chinaex123.create_more_catalysts.processing.fans.integration.ImmersiveEngineering.preservation;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipe;
import com.chinaex123.create_more_catalysts.data.recipe.ImmersiveEngineeringFanRecipeGen;
import com.chinaex123.create_more_catalysts.init.integration.ImmersiveEngineering.ImmersiveEngineeringFanRecipeType;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;

/**
 * 批量防腐配方生成器
 */
public class PreservationRecipeGen extends ImmersiveEngineeringFanRecipeGen<FanRecipe> {

    {
        // 任何木板 → 防腐木板
        convert(() -> Ingredient.of(ItemTags.PLANKS), () -> BuiltInRegistries.ITEM.get(
                ResourceLocation.fromNamespaceAndPath("immersiveengineering", "treated_wood_horizontal")), 1.0f,
                new ModLoadedCondition("immersiveengineering"));
    }

    @Override
    protected ImmersiveEngineeringFanRecipeType.RecipeTypeEntry getRecipeType() {
        return ImmersiveEngineeringFanRecipeType.PRESERVATION;
    }

    public PreservationRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateMoreCatalysts.MOD_ID);
    }
}
