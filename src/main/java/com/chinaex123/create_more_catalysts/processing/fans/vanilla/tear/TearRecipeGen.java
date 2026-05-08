package com.chinaex123.create_more_catalysts.processing.fans.vanilla.tear;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipe;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipeGen;
import com.chinaex123.create_more_catalysts.init.FanRecipeType;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

/**
 * 批量催泪配方生成器
 */
public class TearRecipeGen extends FanRecipeGen<FanRecipe> {

    {
        // 黑曜石 → 哭泣的黑曜石
        convert(Items.OBSIDIAN, Items.CRYING_OBSIDIAN);
    }

    /**
     * 获取配方类型
     * @return 批量催泪配方类型
     */
    @Override
    protected FanRecipeType.RecipeTypeEntry getRecipeType() {
        return FanRecipeType.TEAR;
    }

    /**
     * 初始化配方生成器
     * @param output 数据包输出目标
     * @param registries 注册表提供者
     */
    public TearRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateMoreCatalysts.MOD_ID);
    }
}
