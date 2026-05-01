package com.chinaex123.create_more_catalysts.processing.fans.vanilla.sand_blow;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipe;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipeGen;
import com.chinaex123.create_more_catalysts.init.FanRecipeType;
import com.simibubi.create.AllItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

/**
 * 批量扬砂配方生成器
 */
public class SandBlowRecipeGen extends FanRecipeGen<FanRecipe> {

    {
        // 纸 → 砂纸
        convert(Items.PAPER , AllItems.SAND_PAPER);
    }

    /**
     * 获取配方类型
     * @return 批量扬砂配方类型
     */
    @Override
    protected FanRecipeType.RecipeTypeEntry getRecipeType() {
        return FanRecipeType.SAND_BLOW;
    }

    /**
     * 初始化配方生成器
     * @param output 数据包输出目标
     * @param registries 注册表提供者
     */
    public SandBlowRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateMoreCatalysts.MOD_ID);
    }
}
