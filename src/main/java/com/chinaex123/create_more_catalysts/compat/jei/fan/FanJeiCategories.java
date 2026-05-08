package com.chinaex123.create_more_catalysts.compat.jei.fan;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.compat.jei.AnimatedConduit;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipe;
import com.chinaex123.create_more_catalysts.init.FanRecipeType;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import net.createmod.catnip.gui.element.GuiGameElement;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 鼓风机配方类别管理器：负责注册和管理所有鼓风机加工类型的 JEI 配方类别
 */
public final class FanJeiCategories {

    private final List<CreateRecipeCategory<?>> categories = new ArrayList<>();

    /**
     * 注册所有配方类别到 JEI
     * @param registration JEI 类别注册器
     */
    public void registerCategories(mezz.jei.api.registration.IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(categories.toArray(CreateRecipeCategory[]::new));
    }

    /**
     * 注册所有配方到 JEI
     * @param registration JEI 配方注册器
     */
    public void registerRecipes(mezz.jei.api.registration.IRecipeRegistration registration) {
        categories.forEach(cat -> cat.registerRecipes(registration));
    }

    /**
     * 注册所有催化剂到 JEI
     * @param registration JEI 催化剂注册器
     */
    public void registerRecipeCatalysts(mezz.jei.api.registration.IRecipeCatalystRegistration registration) {
        categories.forEach(cat -> cat.registerCatalysts(registration));
    }

    /**
     * 添加方块催化剂的配方类别
     * @param name 类别名称标识
     * @param recipeType 配方类型入口
     * @param catalystBlock 催化剂方块
     */
    public void addBlockCategory(String name, FanRecipeType.RecipeTypeEntry recipeType, Block catalystBlock) {
        categories.add(buildFanCategory(name, recipeType, catalystBlock, builder -> {}));
    }

    /**
     * 添加流体催化剂的配方类别
     * @param name 类别名称标识
     * @param recipeType 配方类型入口
     * @param catalystFluid 催化剂流体
     */
    public void addFluidCategory(String name, FanRecipeType.RecipeTypeEntry recipeType, Fluid catalystFluid) {
        categories.add(buildFanCategory(name, recipeType, catalystFluid, builder -> {}));
    }

    /**
     * 添加头颅催化剂的配方类别
     * @param name 类别名称标识
     * @param recipeType 配方类型入口
     * @param catalystBlock 催化剂头颅方块
     */
    public void addHeadCategory(String name, FanRecipeType.RecipeTypeEntry recipeType, Block catalystBlock) {
        categories.add(buildFanCategoryWithHead(name, recipeType, catalystBlock, builder -> {}));
    }

    /**
     * 添加潮涌核心催化剂的配方类别
     * @param name 类别名称标识
     * @param recipeType 配方类型入口
     */
    public void addConduitCategory(String name, FanRecipeType.RecipeTypeEntry recipeType) {
        categories.add(buildFanCategoryWithConduit(name, recipeType, builder -> {}));
    }

    /**
     * 构建鼓风机加工配方类别（方块催化剂）
     * @param name 类别名称标识
     * @param recipeType 配方类型入口
     * @param catalystBlock 催化剂方块
     * @param config 额外的配置回调
     * @return 构建完成的配方类别实例
     */
    private static CreateRecipeCategory<FanRecipe> buildFanCategory(
            String name,
            FanRecipeType.RecipeTypeEntry recipeType,
            Block catalystBlock,
            Consumer<CreateRecipeCategory.Builder<FanRecipe>> config) {
        return buildCategory(
                FanRecipe.class,
                name,
                info -> new FanProcessingCategory(info, catalystBlock.defaultBlockState()),
                builder -> {
                    builder
                            .addTypedRecipes(recipeType)
                            .catalystStack(AllBlocks.ENCASED_FAN::asStack)
                            .doubleItemIcon(AllItems.PROPELLER.get(), catalystBlock)
                            .emptyBackground(178, 72);
                    config.accept(builder);
                }
        );
    }

    /**
     * 构建鼓风机加工配方类别（流体催化剂）
     * @param name 类别名称标识
     * @param recipeType 配方类型入口
     * @param catalystFluid 催化剂流体
     * @param config 额外的配置回调
     * @return 构建完成的配方类别实例
     */
    private static CreateRecipeCategory<FanRecipe> buildFanCategory(
            String name,
            FanRecipeType.RecipeTypeEntry recipeType,
            Fluid catalystFluid,
            Consumer<CreateRecipeCategory.Builder<FanRecipe>> config) {
        return buildCategory(
                FanRecipe.class,
                name,
                info -> new FanProcessingCategory(info, catalystFluid.defaultFluidState().createLegacyBlock()),
                builder -> {
                    builder
                            .addTypedRecipes(recipeType)
                            .catalystStack(AllBlocks.ENCASED_FAN::asStack)
                            .doubleItemIcon(AllItems.PROPELLER.get(), catalystFluid.getBucket())
                            .emptyBackground(178, 72);
                    config.accept(builder);
                }
        );
    }

    /**
     * 构建鼓风机加工配方类别（头颅催化剂）
     * @param name 类别名称标识
     * @param recipeType 配方类型入口
     * @param catalystBlock 催化剂头颅方块
     * @param config 额外的配置回调
     * @return 构建完成的配方类别实例
     */
    private static CreateRecipeCategory<FanRecipe> buildFanCategoryWithHead(
            String name,
            FanRecipeType.RecipeTypeEntry recipeType,
            Block catalystBlock,
            Consumer<CreateRecipeCategory.Builder<FanRecipe>> config) {
        return buildCategory(
                FanRecipe.class,
                name,
                info -> new FanProcessingCategoryWithHead(info, catalystBlock.defaultBlockState()),
                builder -> {
                    builder
                            .addTypedRecipes(recipeType)
                            .catalystStack(AllBlocks.ENCASED_FAN::asStack)
                            .doubleItemIcon(AllItems.PROPELLER.get(), catalystBlock)
                            .emptyBackground(178, 72);
                    config.accept(builder);
                }
        );
    }

    /**
     * 构建鼓风机加工配方类别（潮涌核心催化剂）
     * @param name 类别名称标识
     * @param recipeType 配方类型入口
     * @param config 额外的配置回调
     * @return 构建完成的配方类别实例
     */
    private static CreateRecipeCategory<FanRecipe> buildFanCategoryWithConduit(
            String name,
            FanRecipeType.RecipeTypeEntry recipeType,
            Consumer<CreateRecipeCategory.Builder<FanRecipe>> config) {
        return buildCategory(
                FanRecipe.class,
                name,
                FanProcessingCategoryWithConduit::new,
                builder -> {
                    builder
                            .addTypedRecipes(recipeType)
                            .catalystStack(AllBlocks.ENCASED_FAN::asStack)
                            .doubleItemIcon(AllItems.PROPELLER.get(), Blocks.CONDUIT)
                            .emptyBackground(178, 72);
                    config.accept(builder);
                }
        );
    }

    /**
     * 通用配方类别构建方法
     * @param recipeClass 配方类类型
     * @param name 类别名称
     * @param factory 类别工厂方法
     * @param config 配置回调
     * @return 构建完成的配方类别
     */
    private static <T extends Recipe<?>> CreateRecipeCategory<T> buildCategory(
            Class<T> recipeClass,
            String name,
            CreateRecipeCategory.Factory<T> factory,
            Consumer<CreateRecipeCategory.Builder<T>> config) {
        CreateRecipeCategory.Builder<T> builder = new CreateRecipeCategory.Builder<>(recipeClass);
        config.accept(builder);
        return builder.build(CreateMoreCatalysts.id(name), factory);
    }

    /**
     * 鼓风机加工配方渲染类：负责渲染催化剂方块
     */
    private static final class FanProcessingCategory extends ProcessingViaFanCategory.MultiOutput<FanRecipe> {

        private final BlockState catalystBlock;

        private FanProcessingCategory(Info<FanRecipe> info, BlockState catalystBlock) {
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

    /**
     * 鼓风机加工配方渲染类（头颅专用）：调整缩放和旋转以正确显示头颅
     */
    private static final class FanProcessingCategoryWithHead extends ProcessingViaFanCategory.MultiOutput<FanRecipe> {

        private final BlockState catalystBlock;

        private FanProcessingCategoryWithHead(Info<FanRecipe> info, BlockState catalystBlock) {
            super(info);
            this.catalystBlock = catalystBlock;
        }

        @Override
        protected void renderAttachedBlock(GuiGraphics graphics) {
            GuiGameElement.of(new SkullBlockEntity(BlockPos.ZERO, catalystBlock))
                    .rotateBlock(0, 180, 0)
                    .scale(SCALE)
                    .atLocal(0, 0, 2)
                    .lighting(AnimatedKinetics.DEFAULT_LIGHTING)
                    .render(graphics);
        }
    }

    /**
     * 鼓风机加工配方渲染类（潮涌核心专用）：使用自定义动画渲染器
     */
    private static final class FanProcessingCategoryWithConduit extends ProcessingViaFanCategory.MultiOutput<FanRecipe> {

        private final AnimatedConduit conduit = new AnimatedConduit();

        private FanProcessingCategoryWithConduit(Info<FanRecipe> info) {
            super(info);
        }

        @Override
        protected void renderAttachedBlock(GuiGraphics graphics) {
            conduit.draw(graphics, 0, 0);
        }
    }
}
