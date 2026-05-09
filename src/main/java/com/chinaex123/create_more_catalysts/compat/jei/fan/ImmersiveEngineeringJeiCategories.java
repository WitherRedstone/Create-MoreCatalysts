package com.chinaex123.create_more_catalysts.compat.jei.fan;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipe;
import com.chinaex123.create_more_catalysts.init.integration.ImmersiveEngineering.ImmersiveEngineeringFanRecipeType;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.compat.jei.CreateJEI;
import com.simibubi.create.compat.jei.DoubleItemIcon;
import com.simibubi.create.compat.jei.EmptyBackground;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.createmod.catnip.gui.element.GuiGameElement;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * 沉浸工程联动配方类别管理器：负责注册和管理 ImmersiveEngineering 联动的鼓风机加工 JEI 配方类别
 */

public class ImmersiveEngineeringJeiCategories {

    private final List<CreateRecipeCategory<?>> categories = new ArrayList<>();

    /**
     * 注册所有配方类别到 JEI
     * @param registration JEI 类别注册器
     */
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(categories.toArray(CreateRecipeCategory[]::new));
    }

    /**
     * 注册所有配方到 JEI
     * @param registration JEI 配方注册器
     */
    public void registerRecipes(IRecipeRegistration registration) {
        categories.forEach(cat -> cat.registerRecipes(registration));
    }

    /**
     * 注册所有催化剂到 JEI
     * @param registration JEI 催化剂注册器
     */
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        categories.forEach(cat -> cat.registerCatalysts(registration));
    }

    /**
     * 添加流体催化剂的配方类别
     * @param name 类别名称标识
     * @param recipeType 配方类型入口
     * @param catalystFluid 催化剂流体
     */
    public void addFluidCategory(String name, ImmersiveEngineeringFanRecipeType.RecipeTypeEntry recipeType, Fluid catalystFluid) {
        categories.add(buildImmersiveEngineeringFanCategoryFluid(name, recipeType, catalystFluid));
    }

    /**
     * 添加方块催化剂的配方类别
     * @param name 类别名称标识
     * @param recipeType 配方类型入口
     * @param catalystBlock 催化剂方块
     */
    public void addBlockCategory(String name, ImmersiveEngineeringFanRecipeType.RecipeTypeEntry recipeType, Block catalystBlock) {
        categories.add(buildImmersiveEngineeringFanCategory(name, recipeType, catalystBlock));
    }

    /**
     * 构建通用机械鼓风机加工配方类别（方块催化剂）
     * @param name 类别名称标识
     * @param recipeType 配方类型入口
     * @param catalystBlock 催化剂方块
     * @return 构建完成的配方类别实例
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    private static CreateRecipeCategory<FanRecipe> buildImmersiveEngineeringFanCategory(
            String name,
            ImmersiveEngineeringFanRecipeType.RecipeTypeEntry recipeType,
            Block catalystBlock) {
        RecipeType<FanRecipe> jeiType = new RecipeType<>(
                CreateMoreCatalysts.id(name),
                FanRecipe.class
        );

        return new ImmersiveEngineeringFanProcessingCategory(
                new CreateRecipeCategory.Info(
                        jeiType,
                        Component.translatable("create_more_catalysts.recipe." + name),
                        new EmptyBackground(178, 72),
                        new DoubleItemIcon(() -> new ItemStack(AllItems.PROPELLER.get()), () -> new ItemStack(catalystBlock)),
                        (() -> {
                            List<FanRecipe> recipes = new ArrayList<>();
                            CreateJEI.consumeTypedRecipes(recipe -> recipes.add((FanRecipe) recipe), recipeType.getType());
                            return recipes;
                        }),
                        List.of((Supplier) AllBlocks.ENCASED_FAN::asStack)
                ),
                catalystBlock.defaultBlockState()
        );
    }

    /**
     * 构建通用机械鼓风机加工配方类别（流体催化剂）
     * @param name 类别名称标识
     * @param recipeType 配方类型入口
     * @param catalystFluid 催化剂流体
     * @return 构建完成的配方类别实例
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    private static CreateRecipeCategory<FanRecipe> buildImmersiveEngineeringFanCategoryFluid(
            String name,
            ImmersiveEngineeringFanRecipeType.RecipeTypeEntry recipeType,
            Fluid catalystFluid) {
        RecipeType<FanRecipe> jeiType = new RecipeType<>(
                CreateMoreCatalysts.id(name),
                FanRecipe.class
        );

        return new ImmersiveEngineeringFanProcessingCategory(
                new CreateRecipeCategory.Info(
                        jeiType,
                        Component.translatable("create_more_catalysts.recipe." + name),
                        new EmptyBackground(178, 72),
                        new DoubleItemIcon(() -> new ItemStack(AllItems.PROPELLER.get()), () -> new ItemStack(catalystFluid.getBucket())),
                        (() -> {
                            List<FanRecipe> recipes = new ArrayList<>();
                            CreateJEI.consumeTypedRecipes(recipe -> recipes.add((FanRecipe) recipe), recipeType.getType());
                            return recipes;
                        }),
                        List.of((Supplier) AllBlocks.ENCASED_FAN::asStack)
                ),
                catalystFluid.defaultFluidState().createLegacyBlock()
        );
    }

    /**
     * 通用机械鼓风机加工配方渲染类：负责渲染催化剂方块
     */
    private static final class ImmersiveEngineeringFanProcessingCategory extends ProcessingViaFanCategory.MultiOutput<FanRecipe> {

        private final BlockState catalystBlock;

        private ImmersiveEngineeringFanProcessingCategory(CreateRecipeCategory.Info<FanRecipe> info, BlockState catalystBlock) {
            super(info);
            this.catalystBlock = catalystBlock;
        }

        /**
         * 渲染附着在鼓风机前方的催化剂方块
         * @param graphics GUI 图形上下文
         */
        @Override
        protected void renderAttachedBlock(GuiGraphics graphics) {
            GuiGameElement.of(catalystBlock)
                    .scale(SCALE)
                    .atLocal(0, 0, 2)
                    .lighting(AnimatedKinetics.DEFAULT_LIGHTING)
                    .render(graphics);
        }
    }
}
