package com.chinaex123.create_more_catalysts.processing.fans.vanilla.mossify;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipeGen;
import com.chinaex123.create_more_catalysts.init.FanRecipeType;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;

/**
 * 批量苔化配方生成器
 */
public class MossifyRecipeGen extends FanRecipeGen {

    {
        // 泥土 → 苔藓块
        convert(Blocks.DIRT, Blocks.MOSS_BLOCK);
        // 圆石 → 苔石
        convert(Blocks.COBBLESTONE, Blocks.MOSSY_COBBLESTONE);
        // 圆石楼梯 → 苔石楼梯
        convert(Blocks.COBBLESTONE_STAIRS, Blocks.MOSSY_COBBLESTONE_STAIRS);
        // 圆石台阶 → 苔石台阶
        convert(Blocks.COBBLESTONE_SLAB, Blocks.MOSSY_COBBLESTONE_SLAB);
        // 圆石墙 → 苔石墙
        convert(Blocks.COBBLESTONE_WALL, Blocks.MOSSY_COBBLESTONE_WALL);
        // 石砖 → 苔石砖
        convert(Blocks.STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS);
        // 石砖楼梯 → 苔石砖楼梯
        convert(Blocks.STONE_BRICK_STAIRS, Blocks.MOSSY_STONE_BRICK_STAIRS);
        // 石砖台阶 → 苔石砖台阶
        convert(Blocks.STONE_BRICK_SLAB, Blocks.MOSSY_STONE_BRICK_SLAB);
        // 石砖墙 → 苔石砖墙
        convert(Blocks.STONE_BRICK_WALL, Blocks.MOSSY_STONE_BRICK_WALL);
        // 虫蚀石砖 → 虫蚀苔石砖
        convert(Blocks.INFESTED_STONE_BRICKS, Blocks.INFESTED_MOSSY_STONE_BRICKS);
    }

    /**
     * 获取配方类型
     * @return 批量苔化配方类型
     */
    @Override
    protected FanRecipeType.RecipeTypeEntry getRecipeType() {
        return FanRecipeType.MOSSIFY;
    }

    /**
     * 初始化配方生成器
     * @param output 数据包输出目标
     */
    public MossifyRecipeGen(PackOutput output) {
        super(output, CreateMoreCatalysts.MOD_ID);
    }
}
