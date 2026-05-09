package com.chinaex123.create_more_catalysts.data.recipe;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.simibubi.create.api.data.recipe.ProcessingRecipeGen;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public abstract class ImmersiveEngineeringFanRecipeGen extends ProcessingRecipeGen {

    protected ImmersiveEngineeringFanRecipeGen(PackOutput output, String defaultNamespace) {
        super(output, defaultNamespace);
    }

    @Override
    protected abstract IRecipeTypeInfo getRecipeType();

    protected GeneratedRecipe convert(Supplier<Ingredient> input, Supplier<ItemLike> output, float chance, ICondition... conditions) {
        return create(CreateMoreCatalysts.id(getPath(output) + "_for_" + getPath(() -> input.get().getItems()[0].getItem())),
                builder -> {
                    var configuredBuilder = builder.withItemIngredients(input.get()).output(chance, output.get());
                    for (ICondition condition : conditions) {
                        configuredBuilder.withCondition(condition);
                    }
                    return configuredBuilder;
                });
    }

    protected static String getPath(Supplier<ItemLike> itemLike) {
        ResourceLocation key = ForgeRegistries.ITEMS.getKey(itemLike.get().asItem());
        return key != null ? key.getPath() : "unknown";
    }
}
