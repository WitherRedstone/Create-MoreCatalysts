package com.chinaex123.create_more_catalysts;

import com.chinaex123.create_more_catalysts.config.CommonConfig;
import com.chinaex123.create_more_catalysts.init.FanRecipeType;
import com.chinaex123.create_more_catalysts.init.FanType;
import com.chinaex123.create_more_catalysts.init.integration.Anvilcraft.AnvilcraftFanRecipeType;
import com.chinaex123.create_more_catalysts.init.integration.Anvilcraft.AnvilcraftFanType;
import com.chinaex123.create_more_catalysts.init.integration.ImmersiveEngineering.ImmersiveEngineeringFanType;
import com.chinaex123.create_more_catalysts.init.integration.ImmersiveEngineering.ImmersiveEngineeringFanRecipeType;
import com.chinaex123.create_more_catalysts.init.integration.Mekanism.MekanismFanRecipeType;
import com.chinaex123.create_more_catalysts.init.integration.Mekanism.MekanismFanType;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.ModList;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(CreateMoreCatalysts.MOD_ID)
public class CreateMoreCatalysts {
    public static final String MOD_ID = "create_more_catalysts";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CreateMoreCatalysts(IEventBus modEventBus, ModContainer modContainer) {
        FanRecipeType.register(modEventBus);
        modEventBus.addListener((RegisterEvent event) -> FanType.init());

        // 通用机械
        if (ModList.get().isLoaded("mekanism")) {
            MekanismFanRecipeType.register(modEventBus);
            modEventBus.addListener((RegisterEvent event) -> MekanismFanType.init());
        }

        // 沉浸工程
        if (ModList.get().isLoaded("immersiveengineering")) {
            ImmersiveEngineeringFanRecipeType.register(modEventBus);
            modEventBus.addListener((RegisterEvent event) -> ImmersiveEngineeringFanType.init());
        }

        // 铁砧工艺
        if (ModList.get().isLoaded("anvilcraft") || ModList.get().isLoaded("l2hostility")) {
            AnvilcraftFanRecipeType.register(modEventBus);
            modEventBus.addListener((RegisterEvent event) -> AnvilcraftFanType.init());
        }

        modContainer.registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC);
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(CreateMoreCatalysts.MOD_ID, path);
    }
}
