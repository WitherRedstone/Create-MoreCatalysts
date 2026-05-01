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
 * 鼓风机配方生成器基类
 */
public abstract class FanRecipeGen<R extends StandardProcessingRecipe<?>> extends StandardProcessingRecipeGen<R> {

    /**
     * 构造函数：初始化配方生成器
     * @param output 数据包输出目标
     * @param registries 注册表提供者
     * @param defaultNamespace 默认命名空间
     */
    protected FanRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, String defaultNamespace) {
        super(output, registries, defaultNamespace);
    }

    /**
     * 获取配方类型信息：由子类实现以指定具体的配方类型
     * @return 配方类型入口
     */
    @Override
    protected abstract IRecipeTypeInfo getRecipeType();

    /**
     * 将输入物品转换为输出物品（默认概率 100%）
     * @param input 输入物品
     * @param output 输出物品
     * @return 生成的配方实例
     */
    protected GeneratedRecipe convert(ItemLike input, ItemLike output) {
        return convert(() -> Ingredient.of(input), () -> output);
    }

    /**
     * 将输入物品转换为输出物品（指定概率）
     * @param input 输入物品
     * @param output 输出物品
     * @param chance 产出概率（0.0-1.0）
     * @return 生成的配方实例
     */
    protected GeneratedRecipe convert(ItemLike input, ItemLike output, float chance) {
        return convert(() -> Ingredient.of(input), () -> output, chance);
    }

    /**
     * 使用供应器转换物品（默认概率 100%）
     * @param input 输入物品供应器
     * @param output 输出物品供应器
     * @return 生成的配方实例
     */
    protected GeneratedRecipe convert(Supplier<Ingredient> input, Supplier<ItemLike> output) {
        return convert(input, output, 1f);
    }

    /**
     * 使用供应器转换物品（指定概率）
     * @param input 输入物品供应器
     * @param output 输出物品供应器
     * @param chance 产出概率（0.0-1.0）
     * @return 生成的配方实例
     */
    protected GeneratedRecipe convert(Supplier<Ingredient> input, Supplier<ItemLike> output, float chance) {
        return create(asResource(getPath(output) + "_for_" + getPath(() -> input.get().getItems()[0].getItem())),
                builder -> builder.withItemIngredients(input.get()).output(chance, output.get()));
    }

    /**
     * 使用供应器转换物品（支持条件）
     * @param input 输入物品供应器
     * @param output 输出物品供应器
     * @param chance 产出概率（0.0-1.0）
     * @param conditions 配方加载条件数组
     * @return 生成的配方实例
     */
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
     * 获取物品路径名称：从物品注册表中提取物品的资源路径
     * @param itemLike 物品供应器
     * @return 物品的资源路径字符串
     */
    protected static String getPath(Supplier<ItemLike> itemLike) {
        return RegisteredObjectsHelper.getKeyOrThrow(itemLike.get().asItem()).getPath();
    }
}
