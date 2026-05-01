package com.chinaex123.create_more_catalysts.init;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public interface ModFluidTags {

    // =============================== 模组本体 ===============================
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

    private static TagKey<Fluid> fanFluidsTag(String name) {
        return TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(CreateMoreCatalysts.MOD_ID, name));
    }
}
