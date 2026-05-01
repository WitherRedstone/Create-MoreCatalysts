package com.chinaex123.create_more_catalysts.processing.fans.vanilla.chocolate_coating;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipe;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipeGen;
import com.chinaex123.create_more_catalysts.init.FanRecipeType;
import com.simibubi.create.AllItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

/**
 * 批量凝巧配方生成器
 */
public class ChocolateCoatingRecipeGen extends FanRecipeGen<FanRecipe> {

    {
        // 浆果 → 巧克力包层浆果
        convert(() -> Ingredient.of(Tags.Items.FOODS_BERRY), () -> AllItems.CHOCOLATE_BERRIES);
    }

    /**
     * 获取配方类型
     * @return 批量凝巧配方类型
     */
    @Override
    protected FanRecipeType.RecipeTypeEntry getRecipeType() {
        return FanRecipeType.CHOCOLATE_COATING;
    }

    /**
     * 初始化配方生成器
     * @param output 数据包输出目标
     * @param registries 注册表提供者
     */
    public ChocolateCoatingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateMoreCatalysts.MOD_ID);
    }
}
