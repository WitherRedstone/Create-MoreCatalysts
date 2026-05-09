package com.chinaex123.create_more_catalysts.processing.fans.vanilla.resonance;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipeGen;
import com.chinaex123.create_more_catalysts.init.FanRecipeType;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

/**
 * 批量共振配方生成器
 */
public class ResonanceRecipeGen extends FanRecipeGen{

    {
        // 石英 → 紫水晶碎片
        convert(() -> Ingredient.of(Tags.Items.GEMS_QUARTZ), () -> Items.AMETHYST_SHARD, 0.25f);
        // 红石中继器 → 红石比较器
        convert(Items.REPEATER, Items.COMPARATOR);
    }

    /**
     * 获取配方类型
     * @return 批量共振配方类型
     */
    @Override
    protected FanRecipeType.RecipeTypeEntry getRecipeType() {
        return FanRecipeType.RESONANCE;
    }

    /**
     * 初始化配方生成器
     * @param output 数据包输出目标
     */
    public ResonanceRecipeGen(PackOutput output) {
        super(output, CreateMoreCatalysts.MOD_ID);
    }
}
