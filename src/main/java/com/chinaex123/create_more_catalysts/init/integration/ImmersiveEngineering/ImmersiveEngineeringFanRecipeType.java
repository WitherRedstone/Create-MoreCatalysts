package com.chinaex123.create_more_catalysts.init.integration.ImmersiveEngineering;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipe;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.createmod.catnip.lang.Lang;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Optional;

/**
 * 鼓风机配方类型注册器
 */
public final class ImmersiveEngineeringFanRecipeType {

    private static final DeferredRegister<RecipeSerializer<?>> SERIALIZER_REGISTER = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, CreateMoreCatalysts.MOD_ID);
    private static final DeferredRegister<RecipeType<?>> TYPE_REGISTER = DeferredRegister.create(Registries.RECIPE_TYPE, CreateMoreCatalysts.MOD_ID);

    // =============================== 模组联动内容 ===============================
    public static RecipeTypeEntry PRESERVATION; // 鼓风机 - 批量防腐


    /*
      静态初始化块：注册所有鼓风机配方类型
     */
    static {
        // 鼓风机 - 批量防腐
        PRESERVATION = registerStandard("preservation", params -> new FanRecipe(PRESERVATION, params));


    }

    private ImmersiveEngineeringFanRecipeType() {}

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
