package com.chinaex123.create_more_catalysts.config;


import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class CommonConfig {

    // =============================== 模组本体 ===============================
    public static final ForgeConfigSpec.BooleanValue ENABLE_WITHERING_FAN; // 批量凋零
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> WITHERING_ENTITY_TRANSFORMS; // 批量凋零实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> WITHERING_HEAL_ENTITIES; // 批量凋零治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> WITHERING_POTION_EFFECTS; // 批量凋零状态效果列表

    public static final ForgeConfigSpec.BooleanValue ENABLE_SNOW_FLOW_FAN; // 批量雪流
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> SNOW_FLOW_ENTITY_TRANSFORMS; // 批量雪流实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> SNOW_FLOW_HEAL_ENTITIES; // 批量雪流治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> SNOW_FLOW_POTION_EFFECTS; // 批量雪流状态效果列表

    public static final ForgeConfigSpec.BooleanValue ENABLE_PURIFYING_FAN; // 批量净化
    public static final ForgeConfigSpec.BooleanValue PURIFYING_REMOVE_NEGATIVE_EFFECTS; // 批量净化清除负面效果开关
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> PURIFYING_ENTITY_TRANSFORMS; // 批量净化实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> PURIFYING_HEAL_ENTITIES; // 批量净化治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> PURIFYING_POTION_EFFECTS; // 批量净化状态效果列表

    public static final ForgeConfigSpec.BooleanValue ENABLE_SCULKING_FAN; // 批量幽匿
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> SCULKING_ENTITY_TRANSFORMS; // 批量幽匿实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> SCULKING_HEAL_ENTITIES; // 批量幽匿治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> SCULKING_POTION_EFFECTS; // 批量幽匿状态效果列表

    public static final ForgeConfigSpec.BooleanValue ENABLE_RESONANCE_FAN; // 批量共振
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> RESONANCE_ENTITY_TRANSFORMS; // 批量共振实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> RESONANCE_HEAL_ENTITIES; // 批量共振治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> RESONANCE_POTION_EFFECTS; // 批量共振状态效果列表

    public static final ForgeConfigSpec.BooleanValue ENABLE_SAND_BLOW_FAN; // 批量扬砂
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> SAND_BLOW_ENTITY_TRANSFORMS; // 批量扬砂实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> SAND_BLOW_HEAL_ENTITIES; // 批量扬砂治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> SAND_BLOW_POTION_EFFECTS; // 批量扬砂状态效果列表

    public static final ForgeConfigSpec.BooleanValue ENABLE_BREATHED_WIND_FAN; // 批量吐息
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> BREATHED_WIND_ENTITY_TRANSFORMS; // 批量吐息实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> BREATHED_WIND_HEAL_ENTITIES; // 批量吐息治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> BREATHED_WIND_POTION_EFFECTS; // 批量吐息状态效果列表

    public static final ForgeConfigSpec.BooleanValue ENABLE_EXPLODING_FAN; // 批量爆炸
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> EXPLODING_ENTITY_TRANSFORMS; // 批量爆炸实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> EXPLODING_HEAL_ENTITIES; // 批量爆炸治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> EXPLODING_POTION_EFFECTS; // 批量爆炸状态效果列表

    public static final ForgeConfigSpec.BooleanValue ENABLE_TIDAL_FAN; // 批量海潮
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> TIDAL_ENTITY_TRANSFORMS; // 批量海潮实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> TIDAL_HEAL_ENTITIES; // 批量海潮治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> TIDAL_POTION_EFFECTS; // 批量海潮状态效果列表

    public static final ForgeConfigSpec.BooleanValue ENABLE_TEAR_FAN; // 批量催泪
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> TEAR_ENTITY_TRANSFORMS; // 批量催泪实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> TEAR_HEAL_ENTITIES; // 批量催泪治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> TEAR_POTION_EFFECTS; // 批量催泪状态效果列表

    public static final ForgeConfigSpec.BooleanValue ENABLE_MOSSIFY_FAN; // 批量苔化
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> MOSSIFY_ENTITY_TRANSFORMS; // 批量苔化实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> MOSSIFY_HEAL_ENTITIES; // 批量苔化治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> MOSSIFY_POTION_EFFECTS; // 批量苔化状态效果列表

    public static final ForgeConfigSpec.BooleanValue ENABLE_HONEY_COATING_FAN; // 批量裹蜜
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> HONEY_COATING_ENTITY_TRANSFORMS; // 批量裹蜜实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> HONEY_COATING_HEAL_ENTITIES; // 批量裹蜜治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> HONEY_COATING_POTION_EFFECTS; // 批量裹蜜状态效果列表

    public static final ForgeConfigSpec.BooleanValue ENABLE_CHOCOLATE_COATING_FAN; // 批量凝巧
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CHOCOLATE_COATING_ENTITY_TRANSFORMS; // 批量凝巧实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CHOCOLATE_COATING_HEAL_ENTITIES; // 批量凝巧治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CHOCOLATE_COATING_POTION_EFFECTS; // 批量凝巧状态效果列表


    // =============================== 模组联动内容 ===============================
    public static final ForgeConfigSpec.BooleanValue ENABLE_SALOUT_FAN; // 批量盐析
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> SALOUT_ENTITY_TRANSFORMS; // 批量盐析实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> SALOUT_HEAL_ENTITIES; // 批量盐析治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> SALOUT_POTION_EFFECTS; // 批量盐析状态效果列表

    public static final ForgeConfigSpec.BooleanValue ENABLE_ETCH_FAN; // 批量蚀刻
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> ETCH_ENTITY_TRANSFORMS; // 批量蚀刻实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> ETCH_HEAL_ENTITIES; // 批量蚀刻治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> ETCH_POTION_EFFECTS; // 批量蚀刻状态效果列表

    public static final ForgeConfigSpec.BooleanValue ENABLE_SULFON_FAN; // 批量磺化
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> SULFON_ENTITY_TRANSFORMS; // 批量磺化实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> SULFON_HEAL_ENTITIES; // 批量磺化治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> SULFON_POTION_EFFECTS; // 批量磺化状态效果列表

    public static final ForgeConfigSpec.BooleanValue ENABLE_DEHYD_FAN; // 批量脱水
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> DEHYD_ENTITY_TRANSFORMS; // 批量脱水实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> DEHYD_HEAL_ENTITIES; // 批量脱水治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> DEHYD_POTION_EFFECTS; // 批量脱水状态效果列表

    public static final ForgeConfigSpec.BooleanValue ENABLE_OXIDIZE_FAN; // 批量氧化
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> OXIDIZE_ENTITY_TRANSFORMS; // 批量氧化实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> OXIDIZE_HEAL_ENTITIES; // 批量氧化治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> OXIDIZE_POTION_EFFECTS; // 批量氧化状态效果列表

    public static final ForgeConfigSpec.BooleanValue ENABLE_REDUCE_FAN; // 批量还原
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> REDUCE_ENTITY_TRANSFORMS; // 批量还原实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> REDUCE_HEAL_ENTITIES; // 批量还原治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> REDUCE_POTION_EFFECTS; // 批量还原状态效果列表

    public static final ForgeConfigSpec.BooleanValue ENABLE_FERMENT_FAN; // 批量发酵
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> FERMENT_ENTITY_TRANSFORMS; // 批量发酵实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> FERMENT_HEAL_ENTITIES; // 批量发酵治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> FERMENT_POTION_EFFECTS; // 批量发酵状态效果列表

    public static final ForgeConfigSpec.BooleanValue ENABLE_PRESERVATION_FAN; // 批量防腐
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> PRESERVATION_ENTITY_TRANSFORMS; // 批量防腐实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> PRESERVATION_HEAL_ENTITIES; // 批量防腐治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> PRESERVATION_POTION_EFFECTS; // 批量防腐状态效果列表

    public static final ForgeConfigSpec.BooleanValue ENABLE_CORRUPTED_FAN; // 批量腐化
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CORRUPTED_ENTITY_TRANSFORMS; // 批量腐化实体转换列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CORRUPTED_HEAL_ENTITIES; // 批量腐化治疗实体列表
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CORRUPTED_POTION_EFFECTS; // 批量腐化状态效果列表




    public static final ForgeConfigSpec SPEC;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        // =============================== 原版 ===============================
        builder.push("CoreCcontent");

        builder.push("WitheringFan"); // 批量凋零
        ENABLE_WITHERING_FAN = builder
                .comment("Enable Batch Withering Fan")
                .define("enableWitheringFan", true);
        WITHERING_ENTITY_TRANSFORMS = builder
                .comment("Batch Withering entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("witheringEntityTransforms",
                        List.of(
                                "minecraft:skeleton->minecraft:wither_skeleton"
                        ),
                        obj -> obj instanceof String);
        WITHERING_HEAL_ENTITIES = builder
                .comment("Batch Withering entity healing list and amount, format: entity_id->heal_amount")
                .defineList("witheringHealEntities",
                        List.of(
                                "minecraft:wither->10.0", // 凋灵+10点生命
                                "minecraft:wither_skeleton->2.0" // 凋零骷髅+2点生命
                        ),
                        obj -> obj instanceof String);
        WITHERING_POTION_EFFECTS = builder
                .comment("Batch Withering potion effects to apply, format: effect_id duration amplifier")
                .defineList("witheringPotionEffects",
                        List.of(
                                "minecraft:wither 100 0", // 1级凋零5秒
                                ""
                        ),
                        obj -> obj instanceof String);
        builder.pop();

        builder.push("SnowFlowFan"); // 批量雪流
        ENABLE_SNOW_FLOW_FAN = builder
                .comment("Enable Batch Snow Flow Fan")
                .define("enableSnowFlowFan", true);
        SNOW_FLOW_ENTITY_TRANSFORMS = builder
                .comment("Batch Snow Flow entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("snowFlowEntityTransforms",
                        List.of(
                                "minecraft:skeleton->minecraft:stray", // 骷髅->流浪者
                                "minecraft:villager->minecraft:snow_golem" // 村民->雪傀儡
                        ),
                        obj -> obj instanceof String);
        SNOW_FLOW_HEAL_ENTITIES = builder
                .comment("Batch Snow Flow entity healing list and amount, format: entity_id->heal_amount")
                .defineList("snowFlowHealEntities",
                        List.of(
                                "minecraft:stray->2.0", // 流浪者+2点生命
                                "minecraft:snow_golem->4.0" // 雪傀儡+4点生命
                        ),
                        obj -> obj instanceof String);
        SNOW_FLOW_POTION_EFFECTS = builder
                .comment("Batch Snow Flow potion effects to apply, format: effect_id duration amplifier")
                .defineList("snowFlowPotionEffects",
                        List.of(
                                "minecraft:slowness 120 0", // 1级缓慢6秒
                                ""
                        ),
                        obj -> obj instanceof String);
        builder.pop();

        builder.push("PurifyingFan"); // 批量净化
        ENABLE_PURIFYING_FAN = builder
                .comment("Enable Batch Purifying Fan")
                .define("enablePurifyingFan", true);
        PURIFYING_REMOVE_NEGATIVE_EFFECTS = builder
                .comment("Whether Batch Purifying removes negative effects from entities")
                .define("purifyingRemoveNegativeEffects", true);
        PURIFYING_ENTITY_TRANSFORMS = builder
                .comment("Batch Purifying entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("purifyingEntityTransforms",
                        List.of(
                                "minecraft:zombie_villager->minecraft:villager", // 僵尸村民->村民
                                "minecraft:vex->minecraft:allay", // 恼鬼->悦灵
                                "minecraft:hoglin->minecraft:pig", // 疣猪兽->猪
                                "minecraft:ravager->minecraft:cow", // 劫掠兽->牛
                                "minecraft:elder_guardian->minecraft:guardian", // 远古守卫者->守卫者
                                "minecraft:vindicator->minecraft:villager", // 卫道士->村民
                                "minecraft:phantom->minecraft:bat", // 幻翼->蝙蝠
                                "minecraft:zombie_horse->minecraft:horse", // 僵尸马->马
                                "minecraft:endermite->minecraft:silverfish" // 末影螨->蠹虫
                        ),
                        obj -> obj instanceof String);
        PURIFYING_HEAL_ENTITIES = builder
                .comment("Batch Purifying entity healing list and amount, format: entity_id->heal_amount")
                .defineList("purifyingHealEntities",
                        List.of(
                                "minecraft:villager->2.0",  // 村民+2点生命
                                ""
                        ),
                        obj -> obj instanceof String);
        PURIFYING_POTION_EFFECTS = builder
                .comment("Batch Purifying potion effects to apply, format: effect_id duration amplifier")
                .defineList("purifyingPotionEffects",
                        List.of(
                                "minecraft:regeneration 120 0", //  1级再生6秒
                                ""
                        ),
                        obj -> obj instanceof String);
        builder.pop();

        builder.push("SculkingFan"); // 批量幽匿
        ENABLE_SCULKING_FAN = builder
                .comment("Enable Batch Sculking Fan")
                .define("enableSculkingFan", true);
        SCULKING_ENTITY_TRANSFORMS = builder
                .comment("Batch Sculking entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("sculkingEntityTransforms",
                        List.of(
                                "minecraft:iron_golem'->minecraft:warden", // 铁傀儡->监守者
                                ""
                        ),
                        obj -> obj instanceof String);
        SCULKING_HEAL_ENTITIES = builder
                .comment("Batch Sculking entity healing list and amount, format: entity_id->heal_amount")
                .defineList("sculkingHealEntities",
                        List.of(
                                "minecraft:warden->10.0", // 监守者+10点生命
                                ""
                        ),
                        obj -> obj instanceof String);
        SCULKING_POTION_EFFECTS = builder
                .comment("Batch Sculking potion effects to apply, format: effect_id duration amplifier")
                .defineList("sculkingPotionEffects",
                        List.of(
                                "minecraft:darkness 80 0", // 1级黑暗6秒
                                "minecraft:blindness 80 0" // 1级失明6秒
                        ),
                        obj -> obj instanceof String);
        builder.pop();

        builder.push("ResonanceFan"); // 批量共振
        ENABLE_RESONANCE_FAN = builder
                .comment("Enable Batch Resonance Fan")
                .define("enableResonanceFan", true);
        RESONANCE_ENTITY_TRANSFORMS = builder
                .comment("Batch Resonance entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("resonanceEntityTransforms",
                        List.of("", ""),
                        obj -> obj instanceof String);
        RESONANCE_HEAL_ENTITIES = builder
                .comment("Batch Resonance entity healing list and amount, format: entity_id->heal_amount")
                .defineList("resonanceHealEntities",
                        List.of("", ""),
                        obj -> obj instanceof String);
        RESONANCE_POTION_EFFECTS = builder
                .comment("Batch Resonance potion effects to apply, format: effect_id duration amplifier")
                .defineList("resonancePotionEffects",
                        List.of("", ""),
                        obj -> obj instanceof String);
        builder.pop();


        builder.push("SandBlowFan"); // 批量扬砂
        ENABLE_SAND_BLOW_FAN = builder
                .comment("Enable Batch Sand Blow Fan")
                .define("enableSandBlowFan", true);
        SAND_BLOW_ENTITY_TRANSFORMS = builder
                .comment("Batch Sand Blow entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("sandBlowEntityTransforms",
                        List.of(
                                "minecraft:zombie->minecraft:husk", // 僵尸->尸壳
                                ""
                        ),
                        obj -> obj instanceof String);
        SAND_BLOW_HEAL_ENTITIES = builder
                .comment("Batch Sand Blow entity healing list and amount, format: entity_id->heal_amount")
                .defineList("sandBlowHealEntities",
                        List.of(
                                "minecraft:husk->2.0", // 尸壳+2点生命
                                ""
                        ),
                        obj -> obj instanceof String);
        SAND_BLOW_POTION_EFFECTS = builder
                .comment("Batch Sand Blow potion effects to apply, format: effect_id duration amplifier")
                .defineList("sandBlowPotionEffects",
                        List.of(
                                "minecraft:slowness 120 0", // 1级缓慢6秒
                                ""
                        ),
                        obj -> obj instanceof String);
        builder.pop();

        builder.push("BreathedWindFan"); // 批量吐息
        ENABLE_BREATHED_WIND_FAN = builder
                .comment("Enable Batch Breathed Wind Fan")
                .define("enableBreathedWindFan", true);
        BREATHED_WIND_ENTITY_TRANSFORMS = builder
                .comment("Batch Breathed Wind entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("breathedWindEntityTransforms",
                        List.of("", ""),
                        obj -> obj instanceof String);
        BREATHED_WIND_HEAL_ENTITIES = builder
                .comment("Batch Breathed Wind entity healing list and amount, format: entity_id->heal_amount")
                .defineList("breathedWindHealEntities",
                        List.of("", ""),
                        obj -> obj instanceof String);
        BREATHED_WIND_POTION_EFFECTS = builder
                .comment("Batch Breathed potion effects to apply, format: effect_id duration amplifier")
                .defineList("breathedPotionEffects",
                        List.of("", ""),
                        obj -> obj instanceof String);
        builder.pop();

        builder.push("ExplodingFan"); // 批量爆炸
        ENABLE_EXPLODING_FAN = builder
                .comment("Enable Batch Exploding Fan")
                .define("enableExplodingFan", true);
        EXPLODING_ENTITY_TRANSFORMS = builder
                .comment("Batch Exploding entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("explodingEntityTransforms",
                        List.of("", ""),
                        obj -> obj instanceof String);
        EXPLODING_HEAL_ENTITIES = builder
                .comment("Batch Exploding entity healing list and amount, format: entity_id->heal_amount")
                .defineList("explodingHealEntities",
                        List.of("", ""),
                        obj -> obj instanceof String);
        EXPLODING_POTION_EFFECTS = builder
                .comment("Batch Exploding potion effects to apply, format: effect_id duration amplifier")
                .defineList("explodingPotionEffects",
                        List.of("", ""),
                        obj -> obj instanceof String);
        builder.pop();

        builder.push("TidalFan"); // 批量海潮
        ENABLE_TIDAL_FAN = builder
                .comment("Enable Batch Tidal Fan")
                .define("enableTidalFan", true);
        TIDAL_ENTITY_TRANSFORMS = builder
                .comment("Batch Tidal entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("tidalEntityTransforms",
                        List.of("", ""),
                        obj -> obj instanceof String);
        TIDAL_HEAL_ENTITIES = builder
                .comment("Batch Tidal entity healing list and amount, format: entity_id->heal_amount")
                .defineList("tidalHealEntities",
                        List.of("", ""),
                        obj -> obj instanceof String);
        TIDAL_POTION_EFFECTS = builder
                .comment("Batch Tidal potion effects to apply, format: effect_id duration amplifier")
                .defineList("tidalPotionEffects",
                        List.of(
                                "minecraft:conduit_power 160 0", // 1级潮涌能量6秒
                                ""
                        ),
                        obj -> obj instanceof String);
        builder.pop();

        builder.push("TearFan"); // 批量催泪
        ENABLE_TEAR_FAN = builder
                .comment("Enable Batch Tear Fan")
                .define("enableTearFan", true);
        TEAR_ENTITY_TRANSFORMS = builder
                .comment("Batch Tear entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("tearEntityTransforms",
                        List.of(
                                "minecraft:phantom->minecraft:ghast", // 幻翼->恶魂
                                ""
                        ),
                        obj -> obj instanceof String);
        TEAR_HEAL_ENTITIES = builder
                .comment("Batch Tear entity healing list and amount, format: entity_id->heal_amount")
                .defineList("tearHealEntities",
                        List.of("", ""),
                        obj -> obj instanceof String);
        TEAR_POTION_EFFECTS = builder
                .comment("Batch Tear potion effects to apply, format: effect_id duration amplifier")
                .defineList("tearPotionEffects",
                        List.of(
                                "minecraft:blindness 80 0", // 1级失明6秒
                                ""
                        ),
                        obj -> obj instanceof String);
        builder.pop();

        builder.push("MossifyFan"); // 批量苔化
        ENABLE_MOSSIFY_FAN = builder
                .comment("Enable Batch Mossify Fan")
                .define("enableMossifyFan", true);
        MOSSIFY_ENTITY_TRANSFORMS = builder
                .comment("Batch Mossify entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("mossifyEntityTransforms",
                        List.of(
                                "minecraft:skeleton->minecraft:bogged", // 骷髅->沼骸
                                ""
                        ),
                        obj -> obj instanceof String);
        MOSSIFY_HEAL_ENTITIES = builder
                .comment("Batch Mossify entity healing list and amount, format: entity_id->heal_amount")
                .defineList("mossifyHealEntities",
                        List.of(
                                "minecraft:bogged->2.0", // 沼骸+2点生命
                                ""
                        ),
                        obj -> obj instanceof String);
        MOSSIFY_POTION_EFFECTS = builder
                .comment("Batch Mossify potion effects to apply, format: effect_id duration amplifier")
                .defineList("mossifyPotionEffects",
                        List.of("", ""),
                        obj -> obj instanceof String);
        builder.pop();

        builder.push("HoneyCoatingFan"); // 批量裹蜜
        ENABLE_HONEY_COATING_FAN = builder
                .comment("Enable Batch Honey Coating Fan")
                .define("enableHoneyCoatingFan", true);
        HONEY_COATING_ENTITY_TRANSFORMS = builder
                .comment("Batch Honey Coating entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("honeyCoatingEntityTransforms",
                        List.of("", ""),
                        obj -> obj instanceof String);
        HONEY_COATING_HEAL_ENTITIES = builder
                .comment("Batch Honey Coating entity healing list and amount, format: entity_id->heal_amount")
                .defineList("honeyCoatingHealEntities",
                        List.of("minecraft:bee->5.0", ""),
                        obj -> obj instanceof String);
        HONEY_COATING_POTION_EFFECTS = builder
                .comment("Batch Honey potion effects to apply, format: effect_id duration amplifier")
                .defineList("honeyPotionEffects",
                        List.of("", ""),
                        obj -> obj instanceof String);
        builder.pop();

        builder.push("ChocolateCoatingFan"); // 批量凝巧
        ENABLE_CHOCOLATE_COATING_FAN = builder
                .comment("Enable Batch Chocolate Coating Fan")
                .define("enableChocolateCoatingFan", true);
        CHOCOLATE_COATING_ENTITY_TRANSFORMS = builder
                .comment("Batch Chocolate Coating entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("chocolateCoatingEntityTransforms",
                        List.of("", ""),
                        obj -> obj instanceof String);
        CHOCOLATE_COATING_HEAL_ENTITIES = builder
                .comment("Batch Chocolate Coating entity healing list and amount, format: entity_id->heal_amount")
                .defineList("chocolateCoatingHealEntities",
                        List.of("", ""),
                        obj -> obj instanceof String);
        CHOCOLATE_COATING_POTION_EFFECTS = builder
                .comment("Batch Chocolate potion effects to apply, format: effect_id duration amplifier")
                .defineList("chocolatePotionEffects",
                        List.of("", ""),
                        obj -> obj instanceof String);
        builder.pop();



        builder.pop();


        // =============================== 联动模组 ===============================
        builder.push("Integration Mod");

        builder.push("SaloutFan"); // 批量盐析
        ENABLE_SALOUT_FAN = builder
                .comment("Enable Batch Salout Fan (Requires Mekanism)")
                .define("enableSaloutFan", true);
        SALOUT_ENTITY_TRANSFORMS = builder
                .comment("Batch Salout entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("saloutEntityTransforms",
                        List.of("", ""),
                        obj -> obj instanceof String);
        SALOUT_HEAL_ENTITIES = builder
                .comment("Batch Salout entity healing list and amount, format: entity_id->heal_amount")
                .defineList("saloutHealEntities",
                        List.of("", ""),
                        obj -> obj instanceof String);
        SALOUT_POTION_EFFECTS = builder
                .comment("Batch Salout potion effects to apply, format: effect_id duration amplifier")
                .defineList("saloutPotionEffects",
                        List.of("", ""),
                        obj -> obj instanceof String);
        builder.pop();

        builder.push("EtchFan"); // 批量蚀刻
        ENABLE_ETCH_FAN = builder
                .comment("Enable Batch Etch Fan (Requires Mekanism)")
                .define("enableEtchFan", true);
        ETCH_ENTITY_TRANSFORMS = builder
                .comment("Batch Etch entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("etchEntityTransforms",
                        List.of("", ""),
                        obj -> obj instanceof String);
        ETCH_HEAL_ENTITIES = builder
                .comment("Batch Etch entity healing list and amount, format: entity_id->heal_amount")
                .defineList("etchHealEntities",
                        List.of("", ""),
                        obj -> obj instanceof String);
        ETCH_POTION_EFFECTS = builder
                .comment("Batch Etch potion effects to apply, format: effect_id duration amplifier")
                .defineList("etchPotionEffects",
                        List.of("minecraft:poison 100 3", "minecraft:mining_fatigue 100 2", "minecraft:weakness 100 1"),
                        obj -> obj instanceof String);
        builder.pop();

        builder.push("SulfonFan"); // 批量磺化
        ENABLE_SULFON_FAN = builder
                .comment("Enable Batch Sulfon Fan (Requires Mekanism)")
                .define("enableSulfonFan", true);
        SULFON_ENTITY_TRANSFORMS = builder
                .comment("Batch Sulfon entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("sulfonEntityTransforms",
                        List.of("", ""),
                        obj -> obj instanceof String);
        SULFON_HEAL_ENTITIES = builder
                .comment("Batch Sulfon entity healing list and amount, format: entity_id->heal_amount")
                .defineList("sulfonHealEntities",
                        List.of("", ""),
                        obj -> obj instanceof String);
        SULFON_POTION_EFFECTS = builder
                .comment("Batch Sulfon potion effects to apply, format: effect_id duration amplifier")
                .defineList("sulfonPotionEffects",
                        List.of("", ""),
                        obj -> obj instanceof String);
        builder.pop();

        builder.push("DehydFan"); // 批量脱水
        ENABLE_DEHYD_FAN = builder
                .comment("Enable Batch Dehyd Fan (Requires Mekanism)")
                .define("enableDehydFan", true);
        DEHYD_ENTITY_TRANSFORMS = builder
                .comment("Batch Dehyd entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("dehydEntityTransforms",
                        List.of("", ""),
                        obj -> obj instanceof String);
        DEHYD_HEAL_ENTITIES = builder
                .comment("Batch Dehyd entity healing list and amount, format: entity_id->heal_amount")
                .defineList("dehydHealEntities",
                        List.of("", ""),
                        obj -> obj instanceof String);
        DEHYD_POTION_EFFECTS = builder
                .comment("Batch Dehyd potion effects to apply, format: effect_id duration amplifier")
                .defineList("dehydPotionEffects",
                        List.of("", ""),
                        obj -> obj instanceof String);
        builder.pop();

        builder.push("OxidizeFan"); // 批量氧化
        ENABLE_OXIDIZE_FAN = builder
                .comment("Enable Batch Oxidize Fan (Requires Mekanism)")
                .define("enableOxidizeFan", true);
        OXIDIZE_ENTITY_TRANSFORMS = builder
                .comment("Batch Oxidize entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("oxidizeEntityTransforms",
                        List.of("", ""),
                        obj -> obj instanceof String);
        OXIDIZE_HEAL_ENTITIES = builder
                .comment("Batch Oxidize entity healing list and amount, format: entity_id->heal_amount")
                .defineList("oxidizeHealEntities",
                        List.of("", ""),
                        obj -> obj instanceof String);
        OXIDIZE_POTION_EFFECTS = builder
                .comment("Batch Oxidize potion effects to apply, format: effect_id duration amplifier")
                .defineList("oxidizePotionEffects",
                        List.of("", ""),
                        obj -> obj instanceof String);
        builder.pop();

        builder.push("ReduceFan"); // 批量还原
        ENABLE_REDUCE_FAN = builder
                .comment("Enable Batch Reduce Fan (Requires Mekanism)")
                .define("enableReduceFan", true);
        REDUCE_ENTITY_TRANSFORMS = builder
                .comment("Batch Reduce entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("reduceEntityTransforms",
                        List.of("", ""),
                        obj -> obj instanceof String);
        REDUCE_HEAL_ENTITIES = builder
                .comment("Batch Reduce entity healing list and amount, format: entity_id->heal_amount")
                .defineList("reduceHealEntities",
                        List.of("", ""),
                        obj -> obj instanceof String);
        REDUCE_POTION_EFFECTS = builder
                .comment("Batch Reduce potion effects to apply, format: effect_id duration amplifier")
                .defineList("reducePotionEffects",
                        List.of("", ""),
                        obj -> obj instanceof String);
        builder.pop();

        builder.push("FermentFan"); // 批量发酵
        ENABLE_FERMENT_FAN = builder
                .comment("Enable Batch Ferment Fan (Requires Mekanism Generators)")
                .define("enableFermentFan", true);
        FERMENT_ENTITY_TRANSFORMS = builder
                .comment("Batch Ferment entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("fermentEntityTransforms",
                        List.of("", ""),
                        obj -> obj instanceof String);
        FERMENT_HEAL_ENTITIES = builder
                .comment("Batch Ferment entity healing list and amount, format: entity_id->heal_amount")
                .defineList("fermentHealEntities",
                        List.of("", ""),
                        obj -> obj instanceof String);
        FERMENT_POTION_EFFECTS = builder
                .comment("Batch Ferment potion effects to apply, format: effect_id duration amplifier")
                .defineList("fermentPotionEffects",
                        List.of("", ""),
                        obj -> obj instanceof String);
        builder.pop();

        builder.push("PreservationFan"); // 批量防腐
        ENABLE_PRESERVATION_FAN = builder
                .comment("Enable Batch Preservation Fan (Requires Immersive Engineering)")
                .define("enablePreservationFan", true);
        PRESERVATION_ENTITY_TRANSFORMS = builder
                .comment("Batch Preservation entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("preservationEntityTransforms",
                        java.util.List.of(),
                        obj -> obj instanceof String);
        PRESERVATION_HEAL_ENTITIES = builder
                .comment("Batch Preservation entity healing list and amount, format: entity_id->heal_amount")
                .defineList("preservationHealEntities",
                        java.util.List.of("", ""),
                        obj -> obj instanceof String);
        PRESERVATION_POTION_EFFECTS = builder
                .comment("Batch Preservation potion effects to apply, format: effect_id duration amplifier")
                .defineList("preservationPotionEffects",
                        List.of("", ""),
                        obj -> obj instanceof String);
        builder.pop();

        builder.push("CorruptedFan"); // 批量腐化
        ENABLE_CORRUPTED_FAN = builder
                .comment("Enable Batch Corrupted Fan (Requires Anvilcraft or L2hostility)")
                .define("enableCorruptedFan", true);
        CORRUPTED_ENTITY_TRANSFORMS = builder
                .comment("Batch Corrupted entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("corruptedEntityTransforms",
                        java.util.List.of(
                                "minecraft:pig->minecraft:hoglin", // 猪->疣猪兽
                                "minecraft:cow->minecraft:ravager", // 牛->劫掠兽
                                "minecraft:guardian->minecraft:elder_guardian", // 守卫者->远古守卫者
                                "minecraft:villager->minecraft:vindicator", // 村民->卫道士
                                "minecraft:allay->minecraft:vex", // 羊驼->恼鬼
                                "minecraft:bat->minecraft:phantom", // 蝙蝠->幻翼
                                "minecraft:horse->minecraft:zombie_horse", // 马->僵尸马
                                "minecraft:silverfish->minecraft:endermite" // 蠹虫->末影螨
                        ),
                        obj -> obj instanceof String);
        CORRUPTED_HEAL_ENTITIES = builder
                .comment("Batch Corrupted entity healing list and amount, format: entity_id->heal_amount")
                .defineList("corruptedHealEntities",
                        java.util.List.of("", ""),
                        obj -> obj instanceof String);
        CORRUPTED_POTION_EFFECTS = builder
                .comment("Batch Corrupted potion effects to apply, format: effect_id duration amplifier")
                .defineList("corruptedPotionEffects",
                        List.of(
                                "minecraft:wither 120 1", // 2级凋零6秒
                                ""
                        ),
                        obj -> obj instanceof String);
        builder.pop();





        builder.pop();


        SPEC = builder.build();
    }
}
