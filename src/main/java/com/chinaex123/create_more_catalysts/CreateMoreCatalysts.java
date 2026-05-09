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
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

@Mod(CreateMoreCatalysts.MOD_ID)
public class CreateMoreCatalysts {
    public static final String MOD_ID = "create_more_catalysts";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CreateMoreCatalysts(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

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
        if (ModList.get().isLoaded("anvilcraft")) {
            AnvilcraftFanRecipeType.register(modEventBus);
            modEventBus.addListener((RegisterEvent event) -> AnvilcraftFanType.init());
        }

        context.registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC);
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(CreateMoreCatalysts.MOD_ID, path);
    }
}
