package com.chinaex123.create_more_catalysts.init;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public interface ModBlockTags {

    // =============================== 模组本体 ===============================
    TagKey<Block> FAN_CATALYSTS_WITHERING = fanTypesTag("fan_catalysts/withering"); // 批量凋零
    TagKey<Block> FAN_CATALYSTS_SNOW_FLOW = fanTypesTag("fan_catalysts/snow_flow"); // 批量雪流
    TagKey<Block> FAN_CATALYSTS_PURIFYING = fanTypesTag("fan_catalysts/purifying"); // 批量净化
    TagKey<Block> FAN_CATALYSTS_SCULKING = fanTypesTag("fan_catalysts/sculking"); // 批量幽匿
    TagKey<Block> FAN_CATALYSTS_RESONANCE = fanTypesTag("fan_catalysts/resonance"); // 批量共振
    TagKey<Block> FAN_CATALYSTS_SAND_BLOW = fanTypesTag("fan_catalysts/sand_blow"); // 批量扬砂
    TagKey<Block> FAN_CATALYSTS_BREATHED_WIND = fanTypesTag("fan_catalysts/breathed_wind"); // 批量吐息
    TagKey<Block> FAN_CATALYSTS_EXPLODING = fanTypesTag("fan_catalysts/exploding"); // 批量爆炸
    TagKey<Block> FAN_CATALYSTS_HONEY_COATING = fanTypesTag("fan_catalysts/honey_coating"); // 批量裹蜜
    TagKey<Block> FAN_CATALYSTS_CHOCOLATE_COATING = fanTypesTag("fan_catalysts/chocolate_coating"); // 批量凝巧

    // =============================== 模组联动内容 ===============================
    TagKey<Block> FAN_CATALYSTS_SALOUT = fanTypesTag("fan_catalysts/salout"); // 批量盐析

    static TagKey<Block> fanTypesTag(String name) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(CreateMoreCatalysts.MOD_ID, name));
    }
}
