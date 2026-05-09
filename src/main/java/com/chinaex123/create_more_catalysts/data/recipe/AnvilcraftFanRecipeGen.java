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

public abstract class AnvilcraftFanRecipeGen extends ProcessingRecipeGen {

    protected AnvilcraftFanRecipeGen(PackOutput output, String defaultNamespace) {
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

    /**
     * 带输出数量和条件的配方转换
     * @param input 输入材料
     * @param output 输出物品
     * @param chance 产出概率
     * @param count 输出数量
     * @param conditions 条件数组
     */
    protected GeneratedRecipe convert(Supplier<Ingredient> input, Supplier<ItemLike> output, float chance, int count, ICondition... conditions) {
        return create(CreateMoreCatalysts.id(getPath(output) + "_for_" + getPath(() -> input.get().getItems()[0].getItem())),
                builder -> {
                    var configuredBuilder = builder.withItemIngredients(input.get()).output(chance, output.get(), count);
                    for (ICondition condition : conditions) {
                        configuredBuilder.withCondition(condition);
                    }
                    return configuredBuilder;
                });
    }

    /**
     * 带多个概率输出的配方转换
     * @param input 输入材料
     * @param outputs 输出条目数组，每个条目包含 [概率, 物品, 数量]
     */
    protected final GeneratedRecipe convert(Supplier<Ingredient> input, ICondition[] conditions, OutputEntry... outputs) {
        return create(CreateMoreCatalysts.id("multi_output_for_" + getPath(() -> input.get().getItems()[0].getItem())),
                builder -> {
                    var configuredBuilder = builder.withItemIngredients(input.get());
                    for (OutputEntry entry : outputs) {
                        configuredBuilder.output(entry.chance(), entry.item(), entry.count());
                    }
                    for (ICondition condition : conditions) {
                        configuredBuilder.withCondition(condition);
                    }
                    return configuredBuilder;
                });
    }

    /**
     * 输出条目记录类
     * @param chance 产出概率
     * @param item 输出物品
     * @param count 输出数量
     */
    public record OutputEntry(float chance, ItemLike item, int count) {}

    protected static String getPath(Supplier<ItemLike> itemLike) {
        ResourceLocation key = ForgeRegistries.ITEMS.getKey(itemLike.get().asItem());
        return key != null ? key.getPath() : "unknown";
    }
}
