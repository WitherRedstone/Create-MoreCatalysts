package com.chinaex123.create_more_catalysts.init.integration.ImmersiveEngineering;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.processing.fans.integration.ImmersiveEngineering.preservation.PreservationType;
import com.simibubi.create.api.registry.CreateBuiltInRegistries;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import net.minecraft.core.Registry;
import net.neoforged.fml.ModList;

public final class ImmersiveEngineeringFanType {

    private ImmersiveEngineeringFanType() {}

    // 批量防腐
    public static final PreservationType PRESERVATION = isModLoaded("immersiveengineering") ? register("preservation", new PreservationType()) : null;


    private static boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    private static <T extends FanProcessingType> T register(String name, T type) {
        return Registry.register(CreateBuiltInRegistries.FAN_PROCESSING_TYPE, CreateMoreCatalysts.id(name), type);
    }

    public static void init() {}
}
