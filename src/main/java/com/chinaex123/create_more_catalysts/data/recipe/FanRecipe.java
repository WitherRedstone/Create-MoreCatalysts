package com.chinaex123.create_more_catalysts.data.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

/**
 * 鼓风机配方类
 */
public class FanRecipe extends StandardProcessingRecipe<SingleRecipeInput> {

    public FanRecipe(IRecipeTypeInfo recipeType, ProcessingRecipeParams params) {
        super(recipeType, params);
    }

    // 判断输入物品是否匹配此配方
    @Override
    public boolean matches(SingleRecipeInput inv, Level level) {
        // 如果输入为空，直接返回不匹配
        if (inv.isEmpty()) {
            return false;
        }
        // 检查第一个输入物品是否符合配方的原料要求
        return ingredients.getFirst().test(inv.getItem(0));
    }

    // 设置最大输入槽位数为1
    @Override
    protected int getMaxInputCount() {
        return 1;
    }

    // 设置最大输出槽位数为12
    @Override
    protected int getMaxOutputCount() {
        return 12;
    }
}
