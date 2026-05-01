package com.chinaex123.create_more_catalysts.init;

import com.chinaex123.create_more_catalysts.data.recipe.FanRecipe;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.createmod.catnip.lang.Lang;

import java.util.Optional;

/**
 * 鼓风机配方类型注册器
 */
public final class FanRecipeType {

    private static final DeferredRegister<RecipeSerializer<?>> SERIALIZER_REGISTER = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, CreateMoreCatalysts.MOD_ID);
    private static final DeferredRegister<RecipeType<?>> TYPE_REGISTER = DeferredRegister.create(Registries.RECIPE_TYPE, CreateMoreCatalysts.MOD_ID);

    // =============================== 模组本体 ===============================
    // ==================== 方块触媒 ====================
    public static RecipeTypeEntry WITHERING; // 鼓风机 - 批量凋零
    public static RecipeTypeEntry SNOW_FLOW; // 鼓风机 - 批量雪流
    public static RecipeTypeEntry PURIFYING; // 鼓风机 - 批量净化
    public static RecipeTypeEntry SCULKING; // 鼓风机 - 批量幽匿
    public static RecipeTypeEntry RESONANCE; // 鼓风机 - 批量共振
    public static RecipeTypeEntry SAND_BLOW; // 鼓风机 - 批量扬砂
    public static RecipeTypeEntry BREATHED_WIND; // 鼓风机 - 批量吐息
    public static RecipeTypeEntry EXPLODING; // 鼓风机 - 批量爆炸
    // ==================== 流体触媒 ====================
    public static RecipeTypeEntry HONEY_COATING; // 鼓风机 - 批量裹蜜
    public static RecipeTypeEntry CHOCOLATE_COATING; // 鼓风机 - 批量凝巧

    /*
      静态初始化块：注册所有鼓风机配方类型
     */
    static {
        // =============================== 模组本体 ===============================
        // ==================== 方块触媒 ====================
        // 鼓风机 - 批量凋零
        WITHERING = registerStandard("withering", params -> new FanRecipe(WITHERING, params));
        // 鼓风机 - 批量雪流
        SNOW_FLOW = registerStandard("snow_flow", params -> new FanRecipe(SNOW_FLOW, params));
        // 鼓风机 - 批量净化
        PURIFYING = registerStandard("purifying", params -> new FanRecipe(PURIFYING, params));
        // 鼓风机 - 批量幽匿
        SCULKING = registerStandard("sculking", params -> new FanRecipe(SCULKING, params));
        // 鼓风机 - 批量共振
        RESONANCE = registerStandard("resonance", params -> new FanRecipe(RESONANCE, params));
        // 鼓风机 - 批量扬砂
        SAND_BLOW = registerStandard("sand_blow", params -> new FanRecipe(SAND_BLOW, params));
        // 鼓风机 - 批量吐息
        BREATHED_WIND = registerStandard("breathed_wind", params -> new FanRecipe(BREATHED_WIND, params));
        // 鼓风机 - 批量爆炸
        EXPLODING = registerStandard("exploding", params -> new FanRecipe(EXPLODING, params));
        // ==================== 流体触媒 ====================
        // 鼓风机 - 批量裹蜜
        HONEY_COATING = registerStandard("honey_coating", params -> new FanRecipe(HONEY_COATING, params));
        // 鼓风机 - 批量凝巧
        CHOCOLATE_COATING = registerStandard("chocolate_coating", params -> new FanRecipe(CHOCOLATE_COATING, params));
    }

    private FanRecipeType() {}

    /**
     * 注册配方类型到模组事件总线
     * @param modEventBus 模组事件总线
     */
    public static void register(IEventBus modEventBus) {
        ShapedRecipePattern.setCraftingSize(9, 9);
        SERIALIZER_REGISTER.register(modEventBus);
        TYPE_REGISTER.register(modEventBus);
    }

    /**
     * 注册标准加工配方：创建序列化器和类型并返回入口对象
     * @param name 配方名称标识
     * @param factory 配方工厂方法
     * @return 配方类型入口
     */
    static RecipeTypeEntry registerStandard(String name, StandardProcessingRecipe.Factory<?> factory) {
        String recipeName = Lang.asId(name);
        ResourceLocation id = CreateMoreCatalysts.id(recipeName);
        DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> serializer =
                SERIALIZER_REGISTER.register(recipeName, () -> new StandardProcessingRecipe.Serializer<>(factory));
        DeferredHolder<RecipeType<?>, RecipeType<?>> type =
                TYPE_REGISTER.register(recipeName, () -> RecipeType.simple(id));
        return new RecipeTypeEntry(id, serializer, type);
    }

    /**
     * 配方类型入口记录：封装配方的 ID、序列化器和类型信息
     */
    @SuppressWarnings("unchecked")
    public record RecipeTypeEntry(
            ResourceLocation id,
            DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> serializer,
            DeferredHolder<RecipeType<?>, RecipeType<?>> type
    ) implements IRecipeTypeInfo {

        @Override
        public ResourceLocation getId() {
            return id;
        }

        @Override
        public <T extends RecipeSerializer<?>> T getSerializer() {
            return (T) serializer.get();
        }

        @Override
        public <I extends RecipeInput, R extends Recipe<I>> RecipeType<R> getType() {
            return (RecipeType<R>) type.get();
        }

        /**
         * 查找匹配的配方：根据输入物品在世界中搜索对应配方
         * @param input 配方输入
         * @param level 世界实例
         * @return 匹配的配方持有者，未找到时返回空
         */
        public <I extends RecipeInput, R extends Recipe<I>> Optional<RecipeHolder<R>> find(I input, Level level) {
            return level.getRecipeManager().getRecipeFor(getType(), input, level);
        }
    }
}
