package com.chinaex123.create_more_catalysts.data.recipe;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.simibubi.create.api.data.recipe.StandardProcessingRecipeGen;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.createmod.catnip.registry.RegisteredObjectsHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.ICondition;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * 通用机械鼓风机配方生成器基类
 */
public abstract class ImmersiveEngineeringFanRecipeGen<R extends StandardProcessingRecipe<?>> extends StandardProcessingRecipeGen<R> {

    protected ImmersiveEngineeringFanRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, String defaultNamespace) {
        super(output, registries, defaultNamespace);
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
        return RegisteredObjectsHelper.getKeyOrThrow(itemLike.get().asItem()).getPath();
    }
}
