package com.chinaex123.create_more_catalysts.init.integration.Anvilcraft;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.processing.fans.integration.Anvilcraft.corrupted.CorruptedType;
import com.simibubi.create.api.registry.CreateBuiltInRegistries;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import net.minecraft.core.Registry;
import net.neoforged.fml.ModList;

public final class AnvilcraftFanType {

    private AnvilcraftFanType() {}

    // 批量腐化
    public static final CorruptedType CORRUPTED = (isModLoaded("anvilcraft") || isModLoaded("l2hostility")) ? register("corrupted", new CorruptedType()) : null;


    private static boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    private static <T extends FanProcessingType> T register(String name, T type) {
        return Registry.register(CreateBuiltInRegistries.FAN_PROCESSING_TYPE, CreateMoreCatalysts.id(name), type);
    }

    public static void init() {}
}
