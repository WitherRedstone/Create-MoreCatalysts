package com.chinaex123.create_more_catalysts.data;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.init.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                               CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, CreateMoreCatalysts.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        // c:wools
        this.tag(ModItemTags.WOOLS)
                .add(Items.WHITE_WOOL) // 白色羊毛
                .add(Items.ORANGE_WOOL) // 橙色羊毛
                .add(Items.MAGENTA_WOOL) // 品红色羊毛
                .add(Items.LIGHT_BLUE_WOOL) // 淡蓝色羊毛
                .add(Items.YELLOW_WOOL) // 黄色羊毛
                .add(Items.LIME_WOOL) // 黄绿色羊毛
                .add(Items.PINK_WOOL) // 粉色羊毛
                .add(Items.GRAY_WOOL) // 灰色羊毛
                .add(Items.LIGHT_GRAY_WOOL) // 淡灰色羊毛
                .add(Items.CYAN_WOOL) // 青色羊毛
                .add(Items.PURPLE_WOOL) // 紫色羊毛
                .add(Items.BLUE_WOOL) // 蓝色羊毛
                .add(Items.BROWN_WOOL) // 棕色羊毛
                .add(Items.GREEN_WOOL) // 绿色羊毛
                .add(Items.RED_WOOL) // 红色羊毛
                .add(Items.BLACK_WOOL); // 黑色羊毛
    }
}
