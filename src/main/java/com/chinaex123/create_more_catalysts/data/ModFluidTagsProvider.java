package com.chinaex123.create_more_catalysts.data;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.init.ModFluidTags;
import com.simibubi.create.AllFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagsProvider extends FluidTagsProvider {
    public ModFluidTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CreateMoreCatalysts.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        // 批量凋零
        tag(ModFluidTags.FAN_CATALYSTS_WITHERING);
        // 批量雪流
        tag(ModFluidTags.FAN_CATALYSTS_SNOW_FLOW);
        // 批量净化
        tag(ModFluidTags.FAN_CATALYSTS_PURIFYING);
        // 批量幽匿
        tag(ModFluidTags.FAN_CATALYSTS_SCULKING);
        // 批量共振
        tag(ModFluidTags.FAN_CATALYSTS_RESONANCE);
        // 批量扬砂
        tag(ModFluidTags.FAN_CATALYSTS_SAND_BLOW);
        // 批量吐息
        tag(ModFluidTags.FAN_CATALYSTS_BREATHED_WIND);
        // 批量爆炸
        tag(ModFluidTags.FAN_CATALYSTS_EXPLODING);
        // 批量裹蜜
        tag(ModFluidTags.FAN_CATALYSTS_HONEY_COATING)
                .add(AllFluids.HONEY.get())
                .addTag(Tags.Fluids.HONEY);
        // 批量凝巧
        tag(ModFluidTags.FAN_CATALYSTS_CHOCOLATE_COATING)
                .add(AllFluids.CHOCOLATE.get())
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("c", "chocolate"));


        if (ModList.get().isLoaded("mekanism")) {
            // 批量盐析
            tag(ModFluidTags.FAN_CATALYSTS_SALOUT)
                    .addOptionalTag(ResourceLocation.fromNamespaceAndPath("c", "brine"));
            // 批量蚀刻
            tag(ModFluidTags.FAN_CATALYSTS_ETCH)
                    .addOptionalTag(ResourceLocation.fromNamespaceAndPath("c", "hydrofluoric_acid"));
            // 批量磺化
            tag(ModFluidTags.FAN_CATALYSTS_SULFON)
                    .addOptionalTag(ResourceLocation.fromNamespaceAndPath("c", "sulfur_dioxide"));
            // 批量脱水
            tag(ModFluidTags.FAN_CATALYSTS_DEHYD)
                    .addOptionalTag(ResourceLocation.fromNamespaceAndPath("c", "sulfuric_acid"));
            // 批量氧化
            tag(ModFluidTags.FAN_CATALYSTS_OXIDIZE)
                    .addOptionalTag(ResourceLocation.fromNamespaceAndPath("c", "oxygen"));
            // 批量还原
            tag(ModFluidTags.FAN_CATALYSTS_REDUCE)
                    .addOptionalTag(ResourceLocation.fromNamespaceAndPath("c", "hydrogen"));
            // 批量发酵
            tag(ModFluidTags.FAN_CATALYSTS_FERMENT)
                    .addOptionalTag(ResourceLocation.fromNamespaceAndPath("c", "bioethanol"));
        }

        if (ModList.get().isLoaded("immersiveengineering")) {
            // 批量防腐
            tag(ModFluidTags.FAN_CATALYSTS_PRESERVATION)
                    .addOptionalTag(ResourceLocation.fromNamespaceAndPath("c", "creosote"));
        }

        if (ModList.get().isLoaded("immersiveengineering")) {
            // 批量防腐
            tag(ModFluidTags.FAN_CATALYSTS_PRESERVATION);
        }
    }
}
