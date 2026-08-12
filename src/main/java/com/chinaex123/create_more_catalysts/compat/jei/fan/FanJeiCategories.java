package com.chinaex123.create_more_catalysts.compat.jei.fan;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.compat.jei.AnimatedConduit;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipe;
import com.chinaex123.create_more_catalysts.init.FanRecipeType;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.compat.jei.DoubleItemIcon;
import com.simibubi.create.compat.jei.EmptyBackground;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.createmod.catnip.gui.element.GuiGameElement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Supplier;

/**
 * 鼓风机配方类别管理器：负责注册和管理所有鼓风机加工类型的 JEI 配方类别
 */
public final class FanJeiCategories {

    // 使用 Map 确保每个 UID 只对应一个类别
    private final Map<String, CreateRecipeCategory<?>> categories = new LinkedHashMap<>();

    /**
     * 注册所有配方类别到 JEI
     * @param registration JEI 类别注册器
     */
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(categories.values().toArray(CreateRecipeCategory[]::new));
    }

    /**
     * 注册所有配方到 JEI
     * @param registration JEI 配方注册器
     */
    public void registerRecipes(IRecipeRegistration registration) {
        categories.values().forEach(cat -> cat.registerRecipes(registration));
    }

    /**
     * 注册所有催化剂到 JEI
     * @param registration JEI 催化剂注册器
     */
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        categories.values().forEach(cat -> cat.registerCatalysts(registration));
    }

    /**
     * 添加方块催化剂的配方类别
     * @param name 类别名称标识
     * @param recipeType 配方类型入口
     * @param catalystBlock 催化剂方块
     */
    public void addBlockCategory(String name, FanRecipeType.RecipeTypeEntry recipeType, Block catalystBlock) {
        if (!categories.containsKey(name)) {
            categories.put(name, createFanCategory(name, recipeType, catalystBlock.defaultBlockState()));
        }
    }

    /**
     * 添加流体催化剂的配方类别
     * @param name 类别名称标识
     * @param recipeType 配方类型入口
     * @param catalystFluid 催化剂流体
     */
    public void addFluidCategory(String name, FanRecipeType.RecipeTypeEntry recipeType, Fluid catalystFluid) {
        if (!categories.containsKey(name)) {
            categories.put(name, createFanCategoryFluid(name, recipeType, catalystFluid));
        }
    }

    /**
     * 添加头颅催化剂的配方类别
     * @param name 类别名称标识
     * @param recipeType 配方类型入口
     * @param catalystBlock 催化剂头颅方块
     */
    public void addHeadCategory(String name, FanRecipeType.RecipeTypeEntry recipeType, Block catalystBlock) {
        if (!categories.containsKey(name)) {
            categories.put(name, createFanCategoryWithHead(name, recipeType, catalystBlock.defaultBlockState()));
        }
    }

    /**
     * 添加潮涌核心催化剂的配方类别
     * @param name 类别名称标识
     * @param recipeType 配方类型入口
     */
    public void addConduitCategory(String name, FanRecipeType.RecipeTypeEntry recipeType) {
        if (!categories.containsKey(name)) {
            categories.put(name, createFanCategoryWithConduit(name, recipeType));
        }
    }

    /**
     * 创建鼓风机加工配方类别（方块/流体催化剂）
     * @param name 类别名称标识
     * @param recipeType 配方类型入口
     * @param catalystState 催化剂方块状态
     * @return 构建完成的配方类别实例
     */
    private static CreateRecipeCategory<FanRecipe> createFanCategory(String name, FanRecipeType.RecipeTypeEntry recipeType, BlockState catalystState) {
        return new FanProcessingCategory(createInfo(name, recipeType, catalystState.getBlock().asItem()), catalystState);
    }

    /**
     * 创建鼓风机加工配方类别（流体催化剂）
     * @param name 类别名称标识
     * @param recipeType 配方类型入口
     * @param catalystFluid 催化剂流体
     * @return 构建完成的配方类别实例
     */
    private static CreateRecipeCategory<FanRecipe> createFanCategoryFluid(String name, FanRecipeType.RecipeTypeEntry recipeType, Fluid catalystFluid) {
        return new FanProcessingCategory(createInfoFluid(name, recipeType, catalystFluid), catalystFluid.defaultFluidState().createLegacyBlock());
    }

    /**
     * 创建鼓风机加工配方类别（头颅催化剂）
     * @param name 类别名称标识
     * @param recipeType 配方类型入口
     * @param catalystState 催化剂头颅方块状态
     * @return 构建完成的配方类别实例
     */
    private static CreateRecipeCategory<FanRecipe> createFanCategoryWithHead(String name, FanRecipeType.RecipeTypeEntry recipeType, BlockState catalystState) {
        return new FanProcessingCategoryWithHead(createInfo(name, recipeType, catalystState.getBlock().asItem()), catalystState);
    }

    /**
     * 创建鼓风机加工配方类别（潮涌核心催化剂）
     * @param name 类别名称标识
     * @param recipeType 配方类型入口
     * @return 构建完成的配方类别实例
     */
    private static CreateRecipeCategory<FanRecipe> createFanCategoryWithConduit(String name, FanRecipeType.RecipeTypeEntry recipeType) {
        return new FanProcessingCategoryWithConduit(createInfo(name, recipeType, Blocks.CONDUIT.asItem()));
    }

    /**
     * 创建 JEI Info 对象，包含催化剂堆栈列表以支持 U 键查询
     * @param name 类别名称
     * @param recipeType 配方类型入口
     * @param catalystItem 催化剂物品
     * @return Info 对象
     */
    private static CreateRecipeCategory.Info<FanRecipe> createInfo(String name, FanRecipeType.RecipeTypeEntry recipeType, net.minecraft.world.level.ItemLike catalystItem) {
        Component title = Component.translatable("create_more_catalysts.recipe." + name);
        IDrawable background = new EmptyBackground(178, 72);
        IDrawable icon = new DoubleItemIcon(
                AllItems.PROPELLER::asStack,
                () -> catalystItem.asItem().getDefaultInstance()
        );
        Supplier<ItemStack> catalystStackSupplier = () -> catalystItem.asItem().getDefaultInstance();
        Supplier<ItemStack> fanStackSupplier = AllBlocks.ENCASED_FAN::asStack;

        RecipeType<RecipeHolder<FanRecipe>> type = getOrCreateRecipeType(name);

        return new CreateRecipeCategory.Info<>(
                type,
                title,
                background,
                icon,
                () -> {
                    if (Minecraft.getInstance().level != null) {
                        return Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(recipeType.getType());
                    }
                    return List.of();
                },
                List.of(fanStackSupplier, catalystStackSupplier)
        );
    }

    /**
     * 创建 JEI Info 对象（流体催化剂专用）
     * @param name 类别名称
     * @param recipeType 配方类型入口
     * @param catalystFluid 催化剂流体
     * @return Info 对象
     */
    private static CreateRecipeCategory.Info<FanRecipe> createInfoFluid(String name, FanRecipeType.RecipeTypeEntry recipeType, Fluid catalystFluid) {
        Component title = Component.translatable("create_more_catalysts.recipe." + name);
        IDrawable background = new EmptyBackground(178, 72);
        IDrawable icon = new DoubleItemIcon(
                AllItems.PROPELLER::asStack,
                () -> catalystFluid.getBucket().getDefaultInstance()
        );
        Supplier<ItemStack> catalystStackSupplier = () -> catalystFluid.getBucket().getDefaultInstance();
        Supplier<ItemStack> fanStackSupplier = AllBlocks.ENCASED_FAN::asStack;

        RecipeType<RecipeHolder<FanRecipe>> type = getOrCreateRecipeType(name);

        return new CreateRecipeCategory.Info<>(
                type,
                title,
                background,
                icon,
                () -> {
                    if (Minecraft.getInstance().level != null) {
                        return Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(recipeType.getType());
                    }
                    return List.of();
                },
                List.of(fanStackSupplier, catalystStackSupplier)
        );
    }

    // RecipeType 缓存
    private static final Map<String, RecipeType<RecipeHolder<FanRecipe>>> RECIPE_TYPES = new HashMap<>();

    private static RecipeType<RecipeHolder<FanRecipe>> getOrCreateRecipeType(String name) {
        return RECIPE_TYPES.computeIfAbsent(name,
                k -> RecipeType.createRecipeHolderType(CreateMoreCatalysts.id(k)));
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
        protected void renderAttachedBlock(@NotNull GuiGraphics graphics) {
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
        protected void renderAttachedBlock(@NotNull GuiGraphics graphics) {
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
        protected void renderAttachedBlock(@NotNull GuiGraphics graphics) {
            conduit.draw(graphics, 0, 0);
        }
    }
}