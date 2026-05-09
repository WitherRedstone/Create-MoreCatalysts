package com.chinaex123.create_more_catalysts.processing.fans.vanilla.withering;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipeGen;
import com.chinaex123.create_more_catalysts.init.FanRecipeType;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

/**
 * 批量凋零配方生成器
 */
public class WitheringRecipeGen extends FanRecipeGen {

    {
        // 虞美人 → 凋零玫瑰
        convert(Items.POPPY, Items.WITHER_ROSE);
        // 骷髅头颅 → 凋灵骷髅头颅
        convert(Items.SKELETON_SKULL, Items.WITHER_SKELETON_SKULL);
    }

    /**
     * 获取配方类型
     * @return 批量凋零配方类型
     */
    @Override
    protected FanRecipeType.RecipeTypeEntry getRecipeType() {
        return FanRecipeType.WITHERING;
    }

    /**
     * 初始化配方生成器
     * @param output 数据包输出目标
     */
    public WitheringRecipeGen(PackOutput output) {
        super(output, CreateMoreCatalysts.MOD_ID);
    }
}
