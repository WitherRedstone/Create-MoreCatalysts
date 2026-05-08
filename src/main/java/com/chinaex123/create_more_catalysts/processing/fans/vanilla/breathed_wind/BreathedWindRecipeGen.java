package com.chinaex123.create_more_catalysts.processing.fans.vanilla.breathed_wind;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipe;
import com.chinaex123.create_more_catalysts.data.recipe.FanRecipeGen;
import com.chinaex123.create_more_catalysts.init.FanRecipeType;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

/**
 * 批量吐息配方生成器
 */
public class BreathedWindRecipeGen extends FanRecipeGen<FanRecipe> {

    {
        // 甜浆果 → 紫颂果
        convert(() -> Ingredient.of(Tags.Items.FOODS_BERRY), () -> Items.CHORUS_FRUIT);
        // 皮革 → 幻翼膜
        convert(() -> Ingredient.of(Tags.Items.LEATHERS), () -> Items.PHANTOM_MEMBRANE);

        // 附魔之瓶 → 龙息
        convert(Items.EXPERIENCE_BOTTLE, Items.DRAGON_BREATH);
        // 圆石 → 末地石
        convert(Items.COBBLESTONE, Items.END_STONE);
    }

    /**
     * 获取配方类型：返回批量吐息配方类型入口
     * @return 批量吐息配方类型
     */
    @Override
    protected FanRecipeType.RecipeTypeEntry getRecipeType() {
        return FanRecipeType.BREATHED_WIND;
    }

    /**
     * 初始化配方生成器
     * @param output 数据包输出目标
     * @param registries 注册表提供者
     */
    public BreathedWindRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateMoreCatalysts.MOD_ID);
    }
}
