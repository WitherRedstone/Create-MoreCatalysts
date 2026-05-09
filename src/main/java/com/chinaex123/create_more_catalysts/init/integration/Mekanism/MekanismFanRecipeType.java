package com.chinaex123.create_more_catalysts.init.integration.Mekanism;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeSerializer;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.createmod.catnip.lang.Lang;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Optional;

/**
 * 鼓风机配方类型注册器
 */
public final class MekanismFanRecipeType {

    private static final DeferredRegister<RecipeSerializer<?>> SERIALIZER_REGISTER = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER.key(), CreateMoreCatalysts.MOD_ID);
    private static final DeferredRegister<RecipeType<?>> TYPE_REGISTER = DeferredRegister.create(Registries.RECIPE_TYPE, CreateMoreCatalysts.MOD_ID);

    // =============================== 模组联动内容 ===============================
    public static RecipeTypeEntry SALOUT; // 批量盐析
    public static RecipeTypeEntry ETCH; // 批量盐析
    public static RecipeTypeEntry SULFON; // 批量磺化
    public static RecipeTypeEntry DEHYD; // 批量脱水
    public static RecipeTypeEntry OXIDIZE; // 批量氧化
    public static RecipeTypeEntry REDUCE; // 批量还原
    public static RecipeTypeEntry FERMENT; // 批量发酵


    /*
      静态初始化块：注册所有鼓风机配方类型
     */
    static {
        // 批量盐析
        SALOUT = registerStandard("salout", params -> new FanRecipe(SALOUT, params));
        // 批量蚀刻
        ETCH = registerStandard("etch", params -> new FanRecipe(ETCH, params));
        // 批量磺化
        SULFON = registerStandard("sulfon", params -> new FanRecipe(SULFON, params));
        // 批量脱水
        DEHYD = registerStandard("dehyd", params -> new FanRecipe(DEHYD, params));
        // 批量氧化
        OXIDIZE = registerStandard("oxidize", params -> new FanRecipe(OXIDIZE, params));
        // 批量还原
        REDUCE = registerStandard("reduce", params -> new FanRecipe(REDUCE, params));
        // 批量发酵
        FERMENT = registerStandard("ferment", params -> new FanRecipe(FERMENT, params));


    }

    private MekanismFanRecipeType() {}

    /**
     * 注册配方类型到模组事件总线
     * @param modEventBus 模组事件总线
     */
    public static void register(IEventBus modEventBus) {
        SERIALIZER_REGISTER.register(modEventBus);
        TYPE_REGISTER.register(modEventBus);
    }

    /**
     * 注册标准加工配方：创建序列化器和类型并返回入口对象
     * @param name 配方名称标识
     * @param factory 配方工厂方法
     * @return 配方类型入口
     */
    static RecipeTypeEntry registerStandard(String name, ProcessingRecipeBuilder.ProcessingRecipeFactory<FanRecipe> factory) {
        String recipeName = Lang.asId(name);
        ResourceLocation id = CreateMoreCatalysts.id(recipeName);
        RegistryObject<RecipeSerializer<?>> serializer =
                SERIALIZER_REGISTER.register(recipeName, () -> new ProcessingRecipeSerializer<>(factory));
        RegistryObject<RecipeType<?>> type =
                TYPE_REGISTER.register(recipeName, () -> RecipeType.simple(id));
        return new RecipeTypeEntry(id, serializer, type);
    }

    /**
     * 配方类型入口记录：封装配方的 ID、序列化器和类型信息
     */
    @SuppressWarnings("unchecked")
    public record RecipeTypeEntry(
            ResourceLocation id,
            RegistryObject<RecipeSerializer<?>> serializer,
            RegistryObject<RecipeType<?>> type
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
        public RecipeType<?> getType() {
            return type.get();
        }

        /**
         * 查找匹配的配方：根据输入物品在世界中搜索对应配方
         * @param input 配方输入
         * @param level 世界实例
         * @return 匹配的配方持有者，未找到时返回空
         */
        @SuppressWarnings("unchecked")
        public <C extends Container> Optional<Recipe<C>> find(C input, Level level) {
            return (Optional) level.getRecipeManager().getRecipeFor((RecipeType) getType(), input, level);
        }
    }
}
