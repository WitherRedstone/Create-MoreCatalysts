package com.chinaex123.create_more_catalysts.processing.fans.vanilla.snow_flow;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipe;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipeGen;
import com.chinaex123.create_more_catalysts.init.FanRecipeType;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

/**
 * 批量雪流配方生成器
 */
public class SnowFlowRecipeGen extends FanRecipeGen<FanRecipe> {

    {
        // 水桶 → 雪桶
        convert(Items.WATER_BUCKET, Items.POWDER_SNOW_BUCKET);
        // 黏土 → 雪球
        convert(Items.CLAY_BALL, Items.SNOWBALL);
    }

    /**
     * 获取配方类型
     * @return 批量雪流配方类型
     */
    @Override
    protected FanRecipeType.RecipeTypeEntry getRecipeType() {
        return FanRecipeType.SNOW_FLOW;
    }

    /**
     * 初始化配方生成器
     * @param output 数据包输出目标
     * @param registries 注册表提供者
     */
    public SnowFlowRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateMoreCatalysts.MOD_ID);
    }
}
