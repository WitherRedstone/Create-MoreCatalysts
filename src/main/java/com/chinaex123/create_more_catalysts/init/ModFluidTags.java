package com.chinaex123.create_more_catalysts.init;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public interface ModFluidTags {

    // =============================== 模组本体 ===============================
    TagKey<Fluid> FAN_CATALYSTS_WITHERING = fanFluidsTag("fan_catalysts/withering"); // 批量凋零
    TagKey<Fluid> FAN_CATALYSTS_SNOW_FLOW = fanFluidsTag("fan_catalysts/snow_flow"); // 批量雪流
    TagKey<Fluid> FAN_CATALYSTS_PURIFYING = fanFluidsTag("fan_catalysts/purifying"); // 批量净化
    TagKey<Fluid> FAN_CATALYSTS_SCULKING = fanFluidsTag("fan_catalysts/sculking"); // 批量幽匿
    TagKey<Fluid> FAN_CATALYSTS_RESONANCE = fanFluidsTag("fan_catalysts/resonance"); // 批量共振
    TagKey<Fluid> FAN_CATALYSTS_SAND_BLOW = fanFluidsTag("fan_catalysts/sand_blow"); // 批量扬砂
    TagKey<Fluid> FAN_CATALYSTS_BREATHED_WIND = fanFluidsTag("fan_catalysts/breathed_wind"); // 批量吐息
    TagKey<Fluid> FAN_CATALYSTS_EXPLODING = fanFluidsTag("fan_catalysts/exploding"); // 批量爆炸
    TagKey<Fluid> FAN_CATALYSTS_TIDAL = fanFluidsTag("fan_catalysts/tidal"); // 批量海潮
    TagKey<Fluid> FAN_CATALYSTS_TEAR = fanFluidsTag("fan_catalysts/tear"); // 批量催泪
    TagKey<Fluid> FAN_CATALYSTS_MOSSIFY = fanFluidsTag("fan_catalysts/mossify"); // 批量苔化
    TagKey<Fluid> FAN_CATALYSTS_HONEY_COATING = fanFluidsTag("fan_catalysts/honey_coating"); // 批量裹蜜
    TagKey<Fluid> FAN_CATALYSTS_CHOCOLATE_COATING = fanFluidsTag("fan_catalysts/chocolate_coating"); // 批量凝巧

    // =============================== 模组联动内容 ===============================
    TagKey<Fluid> FAN_CATALYSTS_SALOUT = fanFluidsTag("fan_catalysts/salout"); // 批量盐析
    TagKey<Fluid> FAN_CATALYSTS_ETCH = fanFluidsTag("fan_catalysts/etch"); // 批量蚀刻
    TagKey<Fluid> FAN_CATALYSTS_SULFON = fanFluidsTag("fan_catalysts/sulfon"); // 批量磺化
    TagKey<Fluid> FAN_CATALYSTS_DEHYD = fanFluidsTag("fan_catalysts/dehyd"); // 批量脱水
    TagKey<Fluid> FAN_CATALYSTS_OXIDIZE = fanFluidsTag("fan_catalysts/oxidize"); // 批量氧化
    TagKey<Fluid> FAN_CATALYSTS_REDUCE = fanFluidsTag("fan_catalysts/reduce"); // 批量还原
    TagKey<Fluid> FAN_CATALYSTS_FERMENT = fanFluidsTag("fan_catalysts/ferment"); // 批量发酵

    TagKey<Fluid> FAN_CATALYSTS_PRESERVATION = fanFluidsTag("fan_catalysts/preservation"); // 批量防腐

    TagKey<Fluid> FAN_CATALYSTS_CORRUPTED = fanFluidsTag("fan_catalysts/corrupted"); // 批量腐化

    private static TagKey<Fluid> fanFluidsTag(String name) {
        return TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(CreateMoreCatalysts.MOD_ID, name));
    }
}
