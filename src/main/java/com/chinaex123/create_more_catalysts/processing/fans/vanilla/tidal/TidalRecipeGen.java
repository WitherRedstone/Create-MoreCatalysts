package com.chinaex123.create_more_catalysts.processing.fans.vanilla.tidal;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipeGen;
import com.chinaex123.create_more_catalysts.init.FanRecipeType;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * 批量海潮配方生成器
 */
public class TidalRecipeGen extends FanRecipeGen {

    {
        // 下界之星 → 海洋之心
        convert(Items.NETHER_STAR, Items.HEART_OF_THE_SEA);
        // 沙子 → 海晶碎片/海晶砂粒
        create(CreateMoreCatalysts.id("prismarine_shard_for_nether_star"),
                builder -> builder.withItemIngredients(Ingredient.of(Items.SAND))
                        .output(0.50f, Items.PRISMARINE_SHARD, 2)
                        .output(0.25f, Items.PRISMARINE_CRYSTALS));

    }

    /**
     * 获取配方类型
     * @return 批量海潮配方类型
     */
    @Override
    protected FanRecipeType.RecipeTypeEntry getRecipeType() {
        return FanRecipeType.TIDAL;
    }

    /**
     * 初始化配方生成器
     * @param output 数据包输出目标
     */
    public TidalRecipeGen(PackOutput output) {
        super(output, CreateMoreCatalysts.MOD_ID);
    }
}
