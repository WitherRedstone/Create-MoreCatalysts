package com.chinaex123.create_more_catalysts.processing.fans.vanilla.exploding;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipe;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipeGen;
import com.chinaex123.create_more_catalysts.init.FanRecipeType;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

/**
 * 批量爆炸配方生成器
 */
public class ExplodingRecipeGen extends FanRecipeGen<FanRecipe> {

    {
        // 橡树树叶 → 橡树苗
        convert(() -> Ingredient.of(Items.OAK_LEAVES), () -> Items.OAK_SAPLING, 0.25f);
        // 云杉树叶 → 云杉树苗
        convert(() -> Ingredient.of(Items.SPRUCE_LEAVES), () -> Items.SPRUCE_SAPLING, 0.25f);
        // 白桦树叶 → 白桦树苗
        convert(() -> Ingredient.of(Items.BIRCH_LEAVES), () -> Items.BIRCH_SAPLING, 0.25f);
        // 丛林树叶 → 丛林树苗
        convert(() -> Ingredient.of(Items.JUNGLE_LEAVES), () -> Items.JUNGLE_SAPLING, 0.25f);
        // 金合欢树叶 → 金合欢树苗
        convert(() -> Ingredient.of(Items.ACACIA_LEAVES), () -> Items.ACACIA_SAPLING, 0.25f);
        // 深色橡树树叶 → 深色橡树苗
        convert(() -> Ingredient.of(Items.DARK_OAK_LEAVES), () -> Items.DARK_OAK_SAPLING, 0.25f);
        // 红树树叶 → 红树树苗
        convert(() -> Ingredient.of(Items.MANGROVE_LEAVES), () -> Items.MANGROVE_PROPAGULE, 0.25f);
        // 樱花树叶 → 樱花树苗
        convert(() -> Ingredient.of(Items.CHERRY_LEAVES), () -> Items.CHERRY_SAPLING, 0.25f);
    }

    /**
     * 获取配方类型
     * @return 批量爆炸配方类型
     */
    @Override
    protected FanRecipeType.RecipeTypeEntry getRecipeType() {
        return FanRecipeType.EXPLODING;
    }

    /**
     * 初始化配方生成器
     * @param output 数据包输出目标
     * @param registries 注册表提供者
     */
    public ExplodingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateMoreCatalysts.MOD_ID);
    }
}
