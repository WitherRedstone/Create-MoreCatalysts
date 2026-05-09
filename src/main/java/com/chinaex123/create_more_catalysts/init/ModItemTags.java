package com.chinaex123.create_more_catalysts.init;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public interface ModItemTags {

    TagKey<Item> WOOLS = neoforgeTag("wools");
    TagKey<Item> FOODS_RAW_MEAT = neoforgeTag("food/raw_meat");

    static TagKey<Item> neoforgeTag(String name) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", name));
    }
}
