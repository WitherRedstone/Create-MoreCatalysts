package com.chinaex123.create_more_catalysts.data;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.init.ModBlockTags;
import com.simibubi.create.AllTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.ModList;
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
                .add(Blocks.SCULK_CATALYST);
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
        // 批量海潮
        tag(ModBlockTags.FAN_CATALYSTS_TIDAL)
                .add(Blocks.CONDUIT);
        // 批量催泪
        tag(ModBlockTags.FAN_CATALYSTS_TEAR)
                .add(Blocks.CRYING_OBSIDIAN);
        // 批量苔化
        tag(ModBlockTags.FAN_CATALYSTS_MOSSIFY)
                .add(Blocks.MOSS_BLOCK);
        // 批量裹蜜
        tag(ModBlockTags.FAN_CATALYSTS_HONEY_COATING);
        // 批量凝巧
        tag(ModBlockTags.FAN_CATALYSTS_CHOCOLATE_COATING);

        // 鼓风机气流可以穿透的方块
        tag(AllTags.AllBlockTags.FAN_TRANSPARENT.tag)
                .addTag(ModBlockTags.FAN_CATALYSTS_WITHERING) // 批量凋零
                .addTag(ModBlockTags.FAN_CATALYSTS_SNOW_FLOW) // 批量雪流
                .addTag(ModBlockTags.FAN_CATALYSTS_PURIFYING) // 批量净化
                .addTag(ModBlockTags.FAN_CATALYSTS_SCULKING) // 批量幽匿
                .addTag(ModBlockTags.FAN_CATALYSTS_RESONANCE) // 批量共振
                .addTag(ModBlockTags.FAN_CATALYSTS_SAND_BLOW) // 批量扬砂
                .addTag(ModBlockTags.FAN_CATALYSTS_BREATHED_WIND) // 批量吐息
                .addTag(ModBlockTags.FAN_CATALYSTS_EXPLODING) // 批量爆炸
                .addTag(ModBlockTags.FAN_CATALYSTS_TIDAL) // 批量海潮
                .addTag(ModBlockTags.FAN_CATALYSTS_TEAR) // 批量催泪
                .addTag(ModBlockTags.FAN_CATALYSTS_MOSSIFY) // 批量苔化
                .addTag(ModBlockTags.FAN_CATALYSTS_HONEY_COATING) // 批量裹蜜
                .addTag(ModBlockTags.FAN_CATALYSTS_CHOCOLATE_COATING); // 批量凝巧


        if (ModList.get().isLoaded("mekanism")) {
            // 批量盐析
            tag(ModBlockTags.FAN_CATALYSTS_SALOUT)
                    .addOptional(ResourceLocation.fromNamespaceAndPath("mekanism", "block_salt"));
            // 批量盐析
            tag(ModBlockTags.FAN_CATALYSTS_SALOUT);
            // 批量蚀刻
            tag(ModBlockTags.FAN_CATALYSTS_ETCH);
            // 批量磺化
            tag(ModBlockTags.FAN_CATALYSTS_SULFON);
            // 批量脱水
            tag(ModBlockTags.FAN_CATALYSTS_DEHYD);
            // 批量氧化
            tag(ModBlockTags.FAN_CATALYSTS_OXIDIZE);
            // 批量还原
            tag(ModBlockTags.FAN_CATALYSTS_REDUCE);
            // 批量发酵
            tag(ModBlockTags.FAN_CATALYSTS_FERMENT);
            
            // 鼓风机气流可以穿透的方块
            tag(AllTags.AllBlockTags.FAN_TRANSPARENT.tag)
                    .addTag(ModBlockTags.FAN_CATALYSTS_SALOUT) // 批量盐析
                    .addTag(ModBlockTags.FAN_CATALYSTS_ETCH) // 批量蚀刻
                    .addTag(ModBlockTags.FAN_CATALYSTS_SULFON) // 批量磺化
                    .addTag(ModBlockTags.FAN_CATALYSTS_DEHYD) // 批量脱水
                    .addTag(ModBlockTags.FAN_CATALYSTS_OXIDIZE) // 批量氧化
                    .addTag(ModBlockTags.FAN_CATALYSTS_REDUCE) // 批量还原
                    .addTag(ModBlockTags.FAN_CATALYSTS_FERMENT); // 批量发酵
        }

        if (ModList.get().isLoaded("immersiveengineering")) {
            // 批量防腐
            tag(ModBlockTags.FAN_CATALYSTS_PRESERVATION);

            // 鼓风机气流可以穿透的方块
            tag(AllTags.AllBlockTags.FAN_TRANSPARENT.tag)
                    .addTag(ModBlockTags.FAN_CATALYSTS_PRESERVATION); // 批量防腐
        }

        if (ModList.get().isLoaded("anvilcraft") || ModList.get().isLoaded("l2hostility")) {
            // 批量腐化
            tag(ModBlockTags.FAN_CATALYSTS_CORRUPTED)
                    .addOptional(ResourceLocation.fromNamespaceAndPath("anvilcraft", "corrupted_beacon"))
                    .addOptional(ResourceLocation.fromNamespaceAndPath("l2hostility", "hostility_beacon"));

            // 鼓风机气流可以穿透的方块
            tag(AllTags.AllBlockTags.FAN_TRANSPARENT.tag)
                    .addTag(ModBlockTags.FAN_CATALYSTS_CORRUPTED); // 批量腐化
        }
    }
}
