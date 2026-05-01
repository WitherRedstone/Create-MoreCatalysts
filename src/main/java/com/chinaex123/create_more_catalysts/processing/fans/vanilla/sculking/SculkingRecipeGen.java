package com.chinaex123.create_more_catalysts.processing.fans.vanilla.sculking;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipe;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipeGen;
import com.chinaex123.create_more_catalysts.init.FanRecipeType;
import com.chinaex123.create_more_catalysts.init.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

/**
 * 批量幽匿配方生成器
 */
public class SculkingRecipeGen extends FanRecipeGen<FanRecipe> {

    {
        // 任何羊毛 → 幽匿块
        create(CreateMoreCatalysts.id("sculking/sculk_from_wools"), builder ->
                builder.withItemIngredients(Ingredient.of(ModItemTags.WOOLS)).output(0.75F, Items.SCULK));

        // 紫水晶碎片 → 回响碎片
        convert(() -> Ingredient.of(Tags.Items.GEMS_AMETHYST), () -> Items.SCULK, 0.75F);
        // 纸 → 砂纸
        convert(Items.AMETHYST_SHARD , Items.ECHO_SHARD);
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
     * @param registries 注册表提供者
     */
    public SculkingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateMoreCatalysts.MOD_ID);
    }
}
