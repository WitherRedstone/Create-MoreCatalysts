package com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.salout;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipe;
import com.chinaex123.create_more_catalysts.data.recipe.MekanismFanRecipeGen;
import com.chinaex123.create_more_catalysts.init.integration.Mekanism.MekanismFanRecipeType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;

/**
 * 批量盐析配方生成器
 */
public class SaloutRecipeGen extends MekanismFanRecipeGen {

    {
        // 方解石 → 盐
        create(CreateMoreCatalysts.id("salt_from_calcite"),
                builder -> {
                    builder.withItemIngredients(Ingredient.of(Items.CALCITE))
                            .output(1.0f, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("mekanism", "salt")), 3)
                            .output(0.25f, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("mekanism", "salt")), 2)
                            .withCondition(new ModLoadedCondition("mekanism"));
                    return builder;
                });

    }

    @Override
    protected MekanismFanRecipeType.RecipeTypeEntry getRecipeType() {
        return MekanismFanRecipeType.SALOUT;
    }

    public SaloutRecipeGen(PackOutput output) {
        super(output, CreateMoreCatalysts.MOD_ID);
    }
}
