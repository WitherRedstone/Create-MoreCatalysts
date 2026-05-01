package com.chinaex123.create_more_catalysts.data;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.config.CommonConfig;
import com.chinaex123.create_more_catalysts.init.ModBlockTags;
import com.chinaex123.create_more_catalysts.init.integration.Mekanism.MekanismFanRecipeType;
import com.simibubi.create.AllTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CreateMoreCatalysts.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        // 批量凋零
        tag(ModBlockTags.FAN_CATALYSTS_WITHERING)
                .add(Blocks.WITHER_ROSE);
        // 批量雪流
        tag(ModBlockTags.FAN_CATALYSTS_SNOW_FLOW)
                .add(Blocks.POWDER_SNOW);
        // 批量净化
        tag(ModBlockTags.FAN_CATALYSTS_PURIFYING)
                .add(Blocks.BEACON);
        // 批量幽匿
        tag(ModBlockTags.FAN_CATALYSTS_SCULKING)
                .add(Blocks.SCULK);
        // 批量共振
        tag(ModBlockTags.FAN_CATALYSTS_RESONANCE)
                .add(Blocks.AMETHYST_CLUSTER);
        // 批量扬砂
        tag(ModBlockTags.FAN_CATALYSTS_SAND_BLOW)
                .addTag(BlockTags.SAND);
        // 批量吐息
        tag(ModBlockTags.FAN_CATALYSTS_BREATHED_WIND)
                .add(Blocks.DRAGON_HEAD);
        // 批量爆炸
        tag(ModBlockTags.FAN_CATALYSTS_EXPLODING)
                .add(Blocks.CREEPER_HEAD);

        // 鼓风机气流可以穿透的方块
        tag(AllTags.AllBlockTags.FAN_TRANSPARENT.tag)
                .addTag(ModBlockTags.FAN_CATALYSTS_WITHERING)
                .addTag(ModBlockTags.FAN_CATALYSTS_SNOW_FLOW)
                .addTag(ModBlockTags.FAN_CATALYSTS_PURIFYING)
                .addTag(ModBlockTags.FAN_CATALYSTS_SCULKING)
                .addTag(ModBlockTags.FAN_CATALYSTS_RESONANCE)
                .addTag(ModBlockTags.FAN_CATALYSTS_SAND_BLOW)
                .addTag(ModBlockTags.FAN_CATALYSTS_BREATHED_WIND)
                .addTag(ModBlockTags.FAN_CATALYSTS_EXPLODING);


        if (ModList.get().isLoaded("mekanism")) {
            // 鼓风机 - 批量盐析
            tag(ModBlockTags.FAN_CATALYSTS_SALOUT)
                    .addOptional(ResourceLocation.fromNamespaceAndPath("mekanism", "block_salt"));

            // 鼓风机气流可以穿透的方块
            tag(AllTags.AllBlockTags.FAN_TRANSPARENT.tag)
                    .addTag(ModBlockTags.FAN_CATALYSTS_SALOUT);
        }
    }
}
