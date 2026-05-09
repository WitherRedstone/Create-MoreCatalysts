package com.chinaex123.create_more_catalysts.init;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public interface ModBlockTags {

    // =============================== 模组本体 ===============================
    TagKey<Block> FAN_CATALYSTS_WITHERING = fanBlockTag("fan_catalysts/withering"); // 批量凋零
    TagKey<Block> FAN_CATALYSTS_SNOW_FLOW = fanBlockTag("fan_catalysts/snow_flow"); // 批量雪流
    TagKey<Block> FAN_CATALYSTS_PURIFYING = fanBlockTag("fan_catalysts/purifying"); // 批量净化
    TagKey<Block> FAN_CATALYSTS_SCULKING = fanBlockTag("fan_catalysts/sculking"); // 批量幽匿
    TagKey<Block> FAN_CATALYSTS_RESONANCE = fanBlockTag("fan_catalysts/resonance"); // 批量共振
    TagKey<Block> FAN_CATALYSTS_SAND_BLOW = fanBlockTag("fan_catalysts/sand_blow"); // 批量扬砂
    TagKey<Block> FAN_CATALYSTS_BREATHED_WIND = fanBlockTag("fan_catalysts/breathed_wind"); // 批量吐息
    TagKey<Block> FAN_CATALYSTS_EXPLODING = fanBlockTag("fan_catalysts/exploding"); // 批量爆炸
    TagKey<Block> FAN_CATALYSTS_TIDAL = fanBlockTag("fan_catalysts/tidal"); // 批量海潮
    TagKey<Block> FAN_CATALYSTS_TEAR = fanBlockTag("fan_catalysts/tear"); // 批量催泪
    TagKey<Block> FAN_CATALYSTS_MOSSIFY = fanBlockTag("fan_catalysts/mossify"); // 批量苔化
    TagKey<Block> FAN_CATALYSTS_HONEY_COATING = fanBlockTag("fan_catalysts/honey_coating"); // 批量裹蜜
    TagKey<Block> FAN_CATALYSTS_CHOCOLATE_COATING = fanBlockTag("fan_catalysts/chocolate_coating"); // 批量凝巧

    // =============================== 模组联动内容 ===============================
    TagKey<Block> FAN_CATALYSTS_SALOUT = fanBlockTag("fan_catalysts/salout"); // 批量盐析
    TagKey<Block> FAN_CATALYSTS_ETCH = fanBlockTag("fan_catalysts/etch"); // 批量蚀刻
    TagKey<Block> FAN_CATALYSTS_SULFON = fanBlockTag("fan_catalysts/sulfon"); // 批量磺化
    TagKey<Block> FAN_CATALYSTS_DEHYD = fanBlockTag("fan_catalysts/dehyd"); // 批量脱水
    TagKey<Block> FAN_CATALYSTS_OXIDIZE = fanBlockTag("fan_catalysts/oxidize"); // 批量氧化
    TagKey<Block> FAN_CATALYSTS_REDUCE = fanBlockTag("fan_catalysts/reduce"); // 批量还原
    TagKey<Block> FAN_CATALYSTS_FERMENT = fanBlockTag("fan_catalysts/ferment"); // 批量发酵

    TagKey<Block> FAN_CATALYSTS_PRESERVATION = fanBlockTag("fan_catalysts/preservation"); // 批量防腐

    TagKey<Block> FAN_CATALYSTS_CORRUPTED = fanBlockTag("fan_catalysts/corrupted"); // 批量腐化

    static TagKey<Block> fanBlockTag(String name) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(CreateMoreCatalysts.MOD_ID, name));
    }
}
