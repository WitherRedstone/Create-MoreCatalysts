package com.chinaex123.create_more_catalysts.data;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.init.ModBlockTags;
import com.chinaex123.create_more_catalysts.init.ModFluidTags;
import com.simibubi.create.AllFluids;
import com.simibubi.create.AllTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagEntry;
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

        // 鼓风机 - 批量凋零
        tag(ModFluidTags.FAN_CATALYSTS_HONEY_COATING)
                .add(AllFluids.HONEY.get())
                .addTag(Tags.Fluids.HONEY);
        // 鼓风机 - 批量凝巧
        tag(ModFluidTags.FAN_CATALYSTS_CHOCOLATE_COATING)
                .add(AllFluids.CHOCOLATE.get())
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("c", "chocolate"));


        if (ModList.get().isLoaded("mekanism")) {
            // 鼓风机 - 批量盐析
            tag(ModFluidTags.FAN_CATALYSTS_SALOUT)
                    .addOptionalTag(ResourceLocation.fromNamespaceAndPath("c", "brine"));
            // 鼓风机 - 批量蚀刻
            tag(ModFluidTags.FAN_CATALYSTS_ETCH)
                    .addOptionalTag(ResourceLocation.fromNamespaceAndPath("c", "hydrofluoric_acid"));
            // 鼓风机 - 批量磺化
            tag(ModFluidTags.FAN_CATALYSTS_SULFON)
                    .addOptionalTag(ResourceLocation.fromNamespaceAndPath("c", "sulfur_dioxide"));
            // 鼓风机 - 批量脱水
            tag(ModFluidTags.FAN_CATALYSTS_DEHYD)
                    .addOptionalTag(ResourceLocation.fromNamespaceAndPath("c", "sulfuric_acid"));
            // 鼓风机 - 批量氧化
            tag(ModFluidTags.FAN_CATALYSTS_OXIDIZE)
                    .addOptionalTag(ResourceLocation.fromNamespaceAndPath("c", "oxygen"));
            // 鼓风机 - 批量还原
            tag(ModFluidTags.FAN_CATALYSTS_REDUCE)
                    .addOptionalTag(ResourceLocation.fromNamespaceAndPath("c", "hydrogen"));
            // 鼓风机 - 批量发酵
            tag(ModFluidTags.FAN_CATALYSTS_FERMENT)
                    .addOptionalTag(ResourceLocation.fromNamespaceAndPath("c", "bioethanol"));
        }

    }
}
