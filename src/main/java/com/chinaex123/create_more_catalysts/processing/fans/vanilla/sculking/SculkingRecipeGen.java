package com.chinaex123.create_more_catalysts.processing.fans.vanilla.sculking;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipeGen;
import com.chinaex123.create_more_catalysts.init.FanRecipeType;
import com.chinaex123.create_more_catalysts.init.ModItemTags;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.concurrent.CompletableFuture;

/**
 * 批量幽匿配方生成器
 */
public class SculkingRecipeGen extends FanRecipeGen {

    {
        // 任何羊毛 → 幽匿块
        create(CreateMoreCatalysts.id("sculk_from_wools"), builder ->
                builder.withItemIngredients(Ingredient.of(ModItemTags.WOOLS)).output(0.75F, Items.SCULK));

        // 紫水晶碎片 → 回响碎片
        convert(() -> Ingredient.of(Tags.Items.GEMS_AMETHYST), () -> Items.ECHO_SHARD, 0.75F);
        // 藤蔓 → 幽匿脉络
        convert(Items.VINE, Items.SCULK_VEIN);
    }

    /**
     * 获取配方类型
     * @return 批量幽匿配方类型
     */
    @Override
    protected FanRecipeType.RecipeTypeEntry getRecipeType() {
        return FanRecipeType.SCULKING;
    }

    /**
     * 初始化配方生成器
     * @param output 数据包输出目标
     */
    public SculkingRecipeGen(PackOutput output) {
        super(output, CreateMoreCatalysts.MOD_ID);
    }
}
