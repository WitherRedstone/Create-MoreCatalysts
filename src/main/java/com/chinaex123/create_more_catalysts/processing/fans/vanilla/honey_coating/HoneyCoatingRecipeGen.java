package com.chinaex123.create_more_catalysts.processing.fans.vanilla.honey_coating;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipeGen;
import com.chinaex123.create_more_catalysts.init.FanRecipeType;
import com.simibubi.create.AllItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

/**
 * 批量裹蜜配方生成器
 */
public class HoneyCoatingRecipeGen extends FanRecipeGen {

    {
        // 苹果 → 蜜渍苹果
        convert(Items.APPLE, AllItems.HONEYED_APPLE.get());
    }

    /**
     * 获取配方类型
     * @return 批量裹蜜配方类型
     */
    @Override
    protected FanRecipeType.RecipeTypeEntry getRecipeType() {
        return FanRecipeType.HONEY_COATING;
    }

    /**
     * 初始化配方生成器
     * @param output 数据包输出目标
     */
    public HoneyCoatingRecipeGen(PackOutput output) {
        super(output, CreateMoreCatalysts.MOD_ID);
    }
}
