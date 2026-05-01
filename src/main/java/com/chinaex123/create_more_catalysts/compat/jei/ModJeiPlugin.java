package com.chinaex123.create_more_catalysts.compat.jei;

import com.chinaex123.create_more_catalysts.compat.jei.fan.FanCategoryRegistrar;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;

/**
 * JEI 插件主类：负责注册自定义配方类别、具体配方和催化剂到 JEI 界面
 */
@JeiPlugin
public final class ModJeiPlugin implements IModPlugin {

    private static final ResourceLocation PLUGIN_UID = CreateMoreCatalysts.id("jei_plugin");

    private final FanCategoryRegistrar categoryRegistrar = new FanCategoryRegistrar();

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return PLUGIN_UID;
    }

    /**
     * 注册配方类别：在 JEI 右侧创建新的分类标签页
     * @param registration JEI 类别注册器
     */
    @Override
    public void registerCategories(@NotNull IRecipeCategoryRegistration registration) {
        categoryRegistrar.registerAll();
        categoryRegistrar.getFanCategories().registerCategories(registration);
        categoryRegistrar.getMekanismCategories().registerCategories(registration);
    }

    /**
     * 注册具体配方：将游戏中的实际配方数据添加到 JEI 显示
     * @param registration JEI 配方注册器
     */
    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        categoryRegistrar.getFanCategories().registerRecipes(registration);
        categoryRegistrar.getMekanismCategories().registerRecipes(registration);
    }

    /**
     * 注册配方催化剂：在 JEI 左侧显示可点击的催化剂物品（如封装鼓风机）
     * @param registration JEI 催化剂注册器
     */
    @Override
    public void registerRecipeCatalysts(@NotNull IRecipeCatalystRegistration registration) {
        categoryRegistrar.getFanCategories().registerRecipeCatalysts(registration);
        categoryRegistrar.getMekanismCategories().registerRecipeCatalysts(registration);
    }
}
