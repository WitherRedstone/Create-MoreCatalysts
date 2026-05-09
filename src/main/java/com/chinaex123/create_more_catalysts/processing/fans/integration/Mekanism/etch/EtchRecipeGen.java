package com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.etch;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.MekanismFanRecipeGen;
import com.chinaex123.create_more_catalysts.init.integration.Mekanism.MekanismFanRecipeType;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;

public class EtchRecipeGen extends MekanismFanRecipeGen{

    {
        // 白色带釉陶瓦 → 白色混凝土粉末
        convert(() -> Ingredient.of(Items.WHITE_GLAZED_TERRACOTTA), () -> Items.WHITE_CONCRETE_POWDER, 1.0f, new ModLoadedCondition("mekanism"));
        // 橙色带釉陶瓦 → 橙色混凝土粉末
        convert(() -> Ingredient.of(Items.ORANGE_GLAZED_TERRACOTTA), () -> Items.ORANGE_CONCRETE_POWDER, 1.0f, new ModLoadedCondition("mekanism"));
        // 品红色带釉陶瓦 → 品红色混凝土粉末
        convert(() -> Ingredient.of(Items.MAGENTA_GLAZED_TERRACOTTA), () -> Items.MAGENTA_CONCRETE_POWDER, 1.0f, new ModLoadedCondition("mekanism"));
        // 淡蓝色带釉陶瓦 → 淡蓝色混凝土粉末
        convert(() -> Ingredient.of(Items.LIGHT_BLUE_GLAZED_TERRACOTTA), () -> Items.LIGHT_BLUE_CONCRETE_POWDER, 1.0f, new ModLoadedCondition("mekanism"));
        // 黄色带釉陶瓦 → 黄色混凝土粉末
        convert(() -> Ingredient.of(Items.YELLOW_GLAZED_TERRACOTTA), () -> Items.YELLOW_CONCRETE_POWDER, 1.0f, new ModLoadedCondition("mekanism"));
        // 黄绿色带釉陶瓦 → 黄绿色混凝土粉末
        convert(() -> Ingredient.of(Items.LIME_GLAZED_TERRACOTTA), () -> Items.LIME_CONCRETE_POWDER, 1.0f, new ModLoadedCondition("mekanism"));
        // 粉红色带釉陶瓦 → 粉红色混凝土粉末
        convert(() -> Ingredient.of(Items.PINK_GLAZED_TERRACOTTA), () -> Items.PINK_CONCRETE_POWDER, 1.0f, new ModLoadedCondition("mekanism"));
        // 灰色带釉陶瓦 → 灰色混凝土粉末
        convert(() -> Ingredient.of(Items.GRAY_GLAZED_TERRACOTTA), () -> Items.GRAY_CONCRETE_POWDER, 1.0f, new ModLoadedCondition("mekanism"));
        // 淡灰色带釉陶瓦 → 淡灰色混凝土粉末
        convert(() -> Ingredient.of(Items.LIGHT_GRAY_GLAZED_TERRACOTTA), () -> Items.LIGHT_GRAY_CONCRETE_POWDER, 1.0f, new ModLoadedCondition("mekanism"));
        // 青色带釉陶瓦 → 青色混凝土粉末
        convert(() -> Ingredient.of(Items.CYAN_GLAZED_TERRACOTTA), () -> Items.CYAN_CONCRETE_POWDER, 1.0f, new ModLoadedCondition("mekanism"));
        // 紫色带釉陶瓦 → 紫色混凝土粉末
        convert(() -> Ingredient.of(Items.PURPLE_GLAZED_TERRACOTTA), () -> Items.PURPLE_CONCRETE_POWDER, 1.0f, new ModLoadedCondition("mekanism"));
        // 蓝色带釉陶瓦 → 蓝色混凝土粉末
        convert(() -> Ingredient.of(Items.BLUE_GLAZED_TERRACOTTA), () -> Items.BLUE_CONCRETE_POWDER, 1.0f, new ModLoadedCondition("mekanism"));
        // 棕色带釉陶瓦 → 棕色混凝土粉末
        convert(() -> Ingredient.of(Items.BROWN_GLAZED_TERRACOTTA), () -> Items.BROWN_CONCRETE_POWDER, 1.0f, new ModLoadedCondition("mekanism"));
        // 绿色带釉陶瓦 → 绿色混凝土粉末
        convert(() -> Ingredient.of(Items.GREEN_GLAZED_TERRACOTTA), () -> Items.GREEN_CONCRETE_POWDER, 1.0f, new ModLoadedCondition("mekanism"));
        // 红色带釉陶瓦 → 红色混凝土粉末
        convert(() -> Ingredient.of(Items.RED_GLAZED_TERRACOTTA), () -> Items.RED_CONCRETE_POWDER, 1.0f, new ModLoadedCondition("mekanism"));
        // 黑色带釉陶瓦 → 黑色混凝土粉末
        convert(() -> Ingredient.of(Items.BLACK_GLAZED_TERRACOTTA), () -> Items.BLACK_CONCRETE_POWDER, 1.0f, new ModLoadedCondition("mekanism"));
        // 石头 → 沙砾
        convert(() -> Ingredient.of(Tags.Items.STONE), () -> Items.GRAVEL, 1.0f, new ModLoadedCondition("mekanism"));
    }

    @Override
    protected MekanismFanRecipeType.RecipeTypeEntry getRecipeType() {
        return MekanismFanRecipeType.ETCH;
    }

    public EtchRecipeGen(PackOutput output) {
        super(output, CreateMoreCatalysts.MOD_ID);
    }
}
