package com.chinaex123.create_more_catalysts.init;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.breathed_wind.BreathedWindType;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.exploding.ExplodingType;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.chocolate_coating.ChocolateCoatingType;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.honey_coating.HoneyCoatingType;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.mossify.MossifyType;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.purifying.PurifyingType;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.resonance.ResonanceType;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.sand_blow.SandBlowType;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.sculking.SculkingType;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.snow_flow.SnowFlowType;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.tear.TearType;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.tidal.TidalType;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.withering.WitheringType;
import com.simibubi.create.api.registry.CreateBuiltInRegistries;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import net.minecraft.core.Registry;

public final class FanType {

    private FanType() {}

    // =============================== 模组本体 ===============================
    // ==================== 方块触媒 ====================
    // 批量凋零
    public static final WitheringType WITHERING = register("withering", new WitheringType());
    // 批量雪流
    public static final SnowFlowType SNOW_FLOW = register("snow_flow", new SnowFlowType());
    // 批量净化
    public static final PurifyingType PURIFYING = register("purifying", new PurifyingType());
    // 批量幽匿
    public static final SculkingType SCULKING = register("sculking", new SculkingType());
    // 批量共振
    public static final ResonanceType RESONANCE = register("resonance", new ResonanceType());
    // 批量扬砂
    public static final SandBlowType SAND_BLOW = register("sand_blow", new SandBlowType());
    // 批量吐息
    public static final BreathedWindType BREATHED_WIND = register("breathed_wind", new BreathedWindType());
    // 批量爆炸
    public static final ExplodingType EXPLODING = register("exploding", new ExplodingType());
    // 批量海潮
    public static final TidalType TIDAL = register("tidal", new TidalType());
    // 批量催泪
    public static final TearType TEAR = register("tear", new TearType());
    // 批量苔化
    public static final MossifyType MOSSIFY = register("mossify", new MossifyType());
    // ==================== 流体触媒 ====================
    // 批量裹蜜
    public static final HoneyCoatingType HONEY_COATING = register("honey_coating", new HoneyCoatingType());
    // 批量凝巧
    public static final ChocolateCoatingType CHOCOLATE_COATING = register("chocolate_coating", new ChocolateCoatingType());

    private static <T extends FanProcessingType> T register(String name, T type) {
        return Registry.register(CreateBuiltInRegistries.FAN_PROCESSING_TYPE, CreateMoreCatalysts.id(name), type);
    }

    public static void init() {}
}
