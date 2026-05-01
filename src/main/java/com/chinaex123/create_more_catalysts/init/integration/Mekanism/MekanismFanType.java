package com.chinaex123.create_more_catalysts.init.integration.Mekanism;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.dehyd.DehydType;
import com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.etch.EtchType;
import com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.ferment.FermentType;
import com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.oxidize.OxidizeType;
import com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.reduce.ReduceType;
import com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.salout.SaloutType;
import com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.sulfon.SulfonType;
import com.simibubi.create.api.registry.CreateBuiltInRegistries;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import net.minecraft.core.Registry;
import net.neoforged.fml.ModList;

public final class MekanismFanType {

    private MekanismFanType() {}

    // 批量盐析
    public static final SaloutType SALOUT = isModLoaded("mekanism") ? register("salout", new SaloutType()) : null;
    // 批量蚀刻
    public static final EtchType ETCH = isModLoaded("mekanism") ? register("etch", new EtchType()) : null;
    // 批量磺化
    public static final SulfonType SULFON = isModLoaded("mekanism") ? register("sulfon", new SulfonType()) : null;
    // 批量脱水
    public static final DehydType DEHYD = isModLoaded("mekanism") ? register("dehyd", new DehydType()) : null;
    // 批量脱水
    public static final OxidizeType OXIDIZE = isModLoaded("mekanism") ? register("oxidize", new OxidizeType()) : null;
    // 批量还原
    public static final ReduceType REDUCE = isModLoaded("mekanism") ? register("reduce", new ReduceType()) : null;
    // 批量发酵
    public static final FermentType FERMENT = isModLoaded("mekanismgenerators") ? register("ferment", new FermentType()) : null;


    private static boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    private static <T extends FanProcessingType> T register(String name, T type) {
        return Registry.register(CreateBuiltInRegistries.FAN_PROCESSING_TYPE, CreateMoreCatalysts.id(name), type);
    }

    public static void init() {}
}
