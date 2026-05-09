package com.chinaex123.create_more_catalysts.processing.fans.vanilla.purifying;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipeGen;
import com.chinaex123.create_more_catalysts.init.FanRecipeType;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

/**
 * 批量净化配方生成器
 */
public class PurifyingRecipeGen extends FanRecipeGen {

    {
        // 腐肉 → 皮革
        convert(Items.ROTTEN_FLESH, Items.LEATHER);
        // 毒马铃薯 → 马铃薯
        convert(Items.POISONOUS_POTATO, Items.POTATO);
        // 发酵蜘蛛眼 → 蜘蛛眼
        convert(Items.FERMENTED_SPIDER_EYE, Items.SPIDER_EYE);
    }

    /**
     * 获取配方类型
     *
     * @return 批量精华配方类型
     */
    @Override
    protected FanRecipeType.RecipeTypeEntry getRecipeType() {
        return FanRecipeType.PURIFYING;
    }

    /**
     * 初始化配方生成器
     *
     * @param output     数据包输出目标
     */
    public PurifyingRecipeGen(PackOutput output) {
        super(output, CreateMoreCatalysts.MOD_ID);
    }
}
