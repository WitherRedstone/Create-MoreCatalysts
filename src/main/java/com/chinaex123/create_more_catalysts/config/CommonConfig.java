package com.chinaex123.create_more_catalysts.config;

import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;

public class CommonConfig {

    // =============================== 模组本体 ===============================
    public static final ModConfigSpec.BooleanValue ENABLE_WITHERING_FAN; // 批量凋零
    public static final ModConfigSpec.ConfigValue<List<? extends String>> WITHERING_ENTITY_TRANSFORMS; // 批量凋零实体转换列表
    public static final ModConfigSpec.ConfigValue<List<? extends String>> WITHERING_HEAL_ENTITIES; // 批量凋零治疗实体列表

    public static final ModConfigSpec.BooleanValue ENABLE_SNOW_FLOW_FAN; // 批量雪流
    public static final ModConfigSpec.ConfigValue<List<? extends String>> SNOW_FLOW_ENTITY_TRANSFORMS; // 批量雪流实体转换列表
    public static final ModConfigSpec.ConfigValue<List<? extends String>> SNOW_FLOW_HEAL_ENTITIES; // 批量雪流治疗实体列表

    public static final ModConfigSpec.BooleanValue ENABLE_PURIFYING_FAN; // 批量净化
    public static final ModConfigSpec.BooleanValue PURIFYING_REMOVE_NEGATIVE_EFFECTS; // 批量净化清除负面效果开关
    public static final ModConfigSpec.ConfigValue<List<? extends String>> PURIFYING_ENTITY_TRANSFORMS; // 批量净化实体转换列表
    public static final ModConfigSpec.ConfigValue<List<? extends String>> PURIFYING_HEAL_ENTITIES; // 批量净化治疗实体列表

    public static final ModConfigSpec.BooleanValue ENABLE_SCULKING_FAN; // 批量幽匿
    public static final ModConfigSpec.ConfigValue<List<? extends String>> SCULKING_ENTITY_TRANSFORMS; // 批量幽匿实体转换列表
    public static final ModConfigSpec.ConfigValue<List<? extends String>> SCULKING_HEAL_ENTITIES; // 批量幽匿治疗实体列表

    public static final ModConfigSpec.BooleanValue ENABLE_RESONANCE_FAN; // 批量共振
    public static final ModConfigSpec.ConfigValue<List<? extends String>> RESONANCE_ENTITY_TRANSFORMS; // 批量共振实体转换列表
    public static final ModConfigSpec.ConfigValue<List<? extends String>> RESONANCE_HEAL_ENTITIES; // 批量共振治疗实体列表

    public static final ModConfigSpec.BooleanValue ENABLE_SAND_BLOW_FAN; // 批量扬砂
    public static final ModConfigSpec.ConfigValue<List<? extends String>> SAND_BLOW_ENTITY_TRANSFORMS; // 批量扬砂实体转换列表
    public static final ModConfigSpec.ConfigValue<List<? extends String>> SAND_BLOW_HEAL_ENTITIES; // 批量扬砂治疗实体列表

    public static final ModConfigSpec.BooleanValue ENABLE_BREATHED_WIND_FAN; // 批量吐息
    public static final ModConfigSpec.ConfigValue<List<? extends String>> BREATHED_WIND_ENTITY_TRANSFORMS; // 批量吐息实体转换列表
    public static final ModConfigSpec.ConfigValue<List<? extends String>> BREATHED_WIND_HEAL_ENTITIES; // 批量吐息治疗实体列表

    public static final ModConfigSpec.BooleanValue ENABLE_EXPLODING_FAN; // 批量爆炸
    public static final ModConfigSpec.ConfigValue<List<? extends String>> EXPLODING_ENTITY_TRANSFORMS; // 批量爆炸实体转换列表
    public static final ModConfigSpec.ConfigValue<List<? extends String>> EXPLODING_HEAL_ENTITIES; // 批量爆炸治疗实体列表

    public static final ModConfigSpec.BooleanValue ENABLE_HONEY_COATING_FAN; // 批量裹蜜
    public static final ModConfigSpec.ConfigValue<List<? extends String>> HONEY_COATING_ENTITY_TRANSFORMS; // 批量裹蜜实体转换列表
    public static final ModConfigSpec.ConfigValue<List<? extends String>> HONEY_COATING_HEAL_ENTITIES; // 批量裹蜜治疗实体列表

    public static final ModConfigSpec.BooleanValue ENABLE_CHOCOLATE_COATING_FAN; // 批量凝巧
    public static final ModConfigSpec.ConfigValue<List<? extends String>> CHOCOLATE_COATING_ENTITY_TRANSFORMS; // 批量凝巧实体转换列表
    public static final ModConfigSpec.ConfigValue<List<? extends String>> CHOCOLATE_COATING_HEAL_ENTITIES; // 批量凝巧治疗实体列表


    // =============================== 模组联动内容 ===============================
    public static final ModConfigSpec.BooleanValue ENABLE_SALOUT_FAN; // 批量盐析
     public static final ModConfigSpec.ConfigValue<List<? extends String>> SALOUT_ENTITY_TRANSFORMS; // 批量凝巧实体转换列表
    public static final ModConfigSpec.ConfigValue<List<? extends String>> SALOUT_HEAL_ENTITIES; // 批量凝巧治疗实体列表

    public static final ModConfigSpec.BooleanValue ENABLE_ETCH_FAN; // 批量蚀刻
    public static final ModConfigSpec.ConfigValue<List<? extends String>> ETCH_ENTITY_TRANSFORMS; // 批量蚀刻实体转换列表
    public static final ModConfigSpec.ConfigValue<List<? extends String>> ETCH_HEAL_ENTITIES; // 批量蚀刻治疗实体列表

    public static final ModConfigSpec.BooleanValue ENABLE_SULFON_FAN; // 批量磺化
    public static final ModConfigSpec.ConfigValue<List<? extends String>> SULFON_ENTITY_TRANSFORMS; // 批量磺化实体转换列表
    public static final ModConfigSpec.ConfigValue<List<? extends String>> SULFON_HEAL_ENTITIES; // 批量磺化治疗实体列表

    public static final ModConfigSpec.BooleanValue ENABLE_DEHYD_FAN; // 批量脱水
    public static final ModConfigSpec.ConfigValue<List<? extends String>> DEHYD_ENTITY_TRANSFORMS; // 批量脱水实体转换列表
    public static final ModConfigSpec.ConfigValue<List<? extends String>> DEHYD_HEAL_ENTITIES; // 批量脱水治疗实体列表

    public static final ModConfigSpec.BooleanValue ENABLE_OXIDIZE_FAN; // 批量氧化
    public static final ModConfigSpec.ConfigValue<List<? extends String>> OXIDIZE_ENTITY_TRANSFORMS; // 批量氧化实体转换列表
    public static final ModConfigSpec.ConfigValue<List<? extends String>> OXIDIZE_HEAL_ENTITIES; // 批量氧化治疗实体列表

    public static final ModConfigSpec.BooleanValue ENABLE_REDUCE_FAN; // 批量还原
    public static final ModConfigSpec.ConfigValue<List<? extends String>> REDUCE_ENTITY_TRANSFORMS; // 批量还原实体转换列表
    public static final ModConfigSpec.ConfigValue<List<? extends String>> REDUCE_HEAL_ENTITIES; // 批量还原治疗实体列表

    public static final ModConfigSpec.BooleanValue ENABLE_FERMENT_FAN; // 批量发酵
    public static final ModConfigSpec.ConfigValue<List<? extends String>> FERMENT_ENTITY_TRANSFORMS; // 批量发酵实体转换列表
    public static final ModConfigSpec.ConfigValue<List<? extends String>> FERMENT_HEAL_ENTITIES; // 批量发酵治疗实体列表

    public static final ModConfigSpec.BooleanValue ENABLE_PRESERVATION_FAN; // 批量防腐
    public static final ModConfigSpec.ConfigValue<List<? extends String>> PRESERVATION_ENTITY_TRANSFORMS; // 批量防腐实体转换列表
    public static final ModConfigSpec.ConfigValue<List<? extends String>> PRESERVATION_HEAL_ENTITIES; // 批量防腐治疗实体列表



    public static final ModConfigSpec SPEC;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        // =============================== Core Content ===============================
        builder.push("CoreCcontent");

        builder.push("WitheringFan");
        ENABLE_WITHERING_FAN = builder
                .comment("Enable Batch Withering Fan")
                .define("enableWitheringFan", true);
        WITHERING_ENTITY_TRANSFORMS = builder
                .comment("Batch Withering entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("witheringEntityTransforms",
                        List.of("minecraft:skeleton->minecraft:wither_skeleton", ""),
                        () -> "", obj -> obj instanceof String);
        WITHERING_HEAL_ENTITIES = builder
                .comment("Batch Withering entity healing list and amount, format: entity_id->heal_amount")
                .defineList("witheringHealEntities",
                        List.of("minecraft:wither->10.0", "minecraft:wither_skeleton->2.0"),
                        () -> "", obj -> obj instanceof String);
        builder.pop();

        builder.push("SnowFlowFan");
        ENABLE_SNOW_FLOW_FAN = builder
                .comment("Enable Batch Snow Flow Fan")
                .define("enableSnowFlowFan", true);
        SNOW_FLOW_ENTITY_TRANSFORMS = builder
                .comment("Batch Snow Flow entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("snowFlowEntityTransforms",
                        List.of("minecraft:zombie->minecraft:stray", ""),
                        () -> "", obj -> obj instanceof String);
        SNOW_FLOW_HEAL_ENTITIES = builder
                .comment("Batch Snow Flow entity healing list and amount, format: entity_id->heal_amount")
                .defineList("snowFlowHealEntities",
                        List.of("minecraft:stray->2.0", ""),
                        () -> "", obj -> obj instanceof String);
        builder.pop();

        builder.push("PurifyingFan");
        ENABLE_PURIFYING_FAN = builder
                .comment("Enable Batch Purifying Fan")
                .define("enablePurifyingFan", true);
        PURIFYING_REMOVE_NEGATIVE_EFFECTS = builder
                .comment("Whether Batch Purifying removes negative effects from entities")
                .define("purifyingRemoveNegativeEffects", true);
        PURIFYING_ENTITY_TRANSFORMS = builder
                .comment("Batch Purifying entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("purifyingEntityTransforms",
                        List.of("minecraft:zombie_villager->minecraft:villager", "minecraft:vex->minecraft:allay"),
                        () -> "", obj -> obj instanceof String);
        PURIFYING_HEAL_ENTITIES = builder
                .comment("Batch Purifying entity healing list and amount, format: entity_id->heal_amount")
                .defineList("purifyingHealEntities",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        builder.pop();

        builder.push("SculkingFan");
        ENABLE_SCULKING_FAN = builder
                .comment("Enable Batch Sculking Fan")
                .define("enableSculkingFan", true);
        SCULKING_ENTITY_TRANSFORMS = builder
                .comment("Batch Sculking entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("sculkingEntityTransforms",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        SCULKING_HEAL_ENTITIES = builder
                .comment("Batch Sculking entity healing list and amount, format: entity_id->heal_amount")
                .defineList("sculkingHealEntities",
                        List.of("minecraft:warden->10.0"),
                        () -> "", obj -> obj instanceof String);
        builder.pop();

        builder.push("ResonanceFan");
        ENABLE_RESONANCE_FAN = builder
                .comment("Enable Batch Resonance Fan")
                .define("enableResonanceFan", true);
        RESONANCE_ENTITY_TRANSFORMS = builder
                .comment("Batch Resonance entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("resonanceEntityTransforms",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        RESONANCE_HEAL_ENTITIES = builder
                .comment("Batch Resonance entity healing list and amount, format: entity_id->heal_amount")
                .defineList("resonanceHealEntities",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        builder.pop();


        builder.push("SandBlowFan");
        ENABLE_SAND_BLOW_FAN = builder
                .comment("Enable Batch Sand Blow Fan")
                .define("enableSandBlowFan", true);
        SAND_BLOW_ENTITY_TRANSFORMS = builder
                .comment("Batch Sand Blow entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("sandBlowEntityTransforms",
                        List.of("minecraft:zombie->minecraft:husk", ""),
                        () -> "", obj -> obj instanceof String);
        SAND_BLOW_HEAL_ENTITIES = builder
                .comment("Batch Sand Blow entity healing list and amount, format: entity_id->heal_amount")
                .defineList("sandBlowHealEntities",
                        List.of("minecraft:husk->2.0", ""),
                        () -> "", obj -> obj instanceof String);
        builder.pop();

        builder.push("BreathedWindFan");
        ENABLE_BREATHED_WIND_FAN = builder
                .comment("Enable Batch Breathed Wind Fan")
                .define("enableBreathedWindFan", true);
        BREATHED_WIND_ENTITY_TRANSFORMS = builder
                .comment("Batch Breathed Wind entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("breathedWindEntityTransforms",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        BREATHED_WIND_HEAL_ENTITIES = builder
                .comment("Batch Breathed Wind entity healing list and amount, format: entity_id->heal_amount")
                .defineList("breathedWindHealEntities",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        builder.pop();

        builder.push("ExplodingFan");
        ENABLE_EXPLODING_FAN = builder
                .comment("Enable Batch Exploding Fan")
                .define("enableExplodingFan", true);
        EXPLODING_ENTITY_TRANSFORMS = builder
                .comment("Batch Exploding entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("explodingEntityTransforms",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        EXPLODING_HEAL_ENTITIES = builder
                .comment("Batch Exploding entity healing list and amount, format: entity_id->heal_amount")
                .defineList("explodingHealEntities",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        builder.pop();

        builder.push("HoneyCoatingFan");
        ENABLE_HONEY_COATING_FAN = builder
                .comment("Enable Batch Honey Coating Fan")
                .define("enableHoneyCoatingFan", true);
        HONEY_COATING_ENTITY_TRANSFORMS = builder
                .comment("Batch Honey Coating entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("honeyCoatingEntityTransforms",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        HONEY_COATING_HEAL_ENTITIES = builder
                .comment("Batch Honey Coating entity healing list and amount, format: entity_id->heal_amount")
                .defineList("honeyCoatingHealEntities",
                        List.of("minecraft:bee->5.0", ""),
                        () -> "", obj -> obj instanceof String);
        builder.pop();

        builder.push("ChocolateCoatingFan");
        ENABLE_CHOCOLATE_COATING_FAN = builder
                .comment("Enable Batch Chocolate Coating Fan")
                .define("enableChocolateCoatingFan", true);
        CHOCOLATE_COATING_ENTITY_TRANSFORMS = builder
                .comment("Batch Chocolate Coating entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("chocolateCoatingEntityTransforms",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        CHOCOLATE_COATING_HEAL_ENTITIES = builder
                .comment("Batch Chocolate Coating entity healing list and amount, format: entity_id->heal_amount")
                .defineList("chocolateCoatingHealEntities",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        builder.pop();

        builder.pop();


        // =============================== Integration Mod ===============================
        builder.push("Integration Mod");

        builder.push("SaloutFan");
        ENABLE_SALOUT_FAN = builder
                .comment("Enable Batch Salout Fan (Requires Mekanism)")
                .define("enableSaloutFan", true);
        SALOUT_ENTITY_TRANSFORMS = builder
                .comment("Batch Salout entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("saloutEntityTransforms",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        SALOUT_HEAL_ENTITIES = builder
                .comment("Batch Salout entity healing list and amount, format: entity_id->heal_amount")
                .defineList("saloutHealEntities",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        builder.pop();

        builder.push("EtchFan");
        ENABLE_ETCH_FAN = builder
                .comment("Enable Batch Etch Fan (Requires Mekanism)")
                .define("enableEtchFan", true);
        ETCH_ENTITY_TRANSFORMS = builder
                .comment("Batch Etch entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("etchEntityTransforms",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        ETCH_HEAL_ENTITIES = builder
                .comment("Batch Etch entity healing list and amount, format: entity_id->heal_amount")
                .defineList("etchHealEntities",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        builder.pop();

        builder.push("SulfonFan");
        ENABLE_SULFON_FAN = builder
                .comment("Enable Batch Sulfon Fan (Requires Mekanism)")
                .define("enableSulfonFan", true);
        SULFON_ENTITY_TRANSFORMS = builder
                .comment("Batch Sulfon entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("sulfonEntityTransforms",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        SULFON_HEAL_ENTITIES = builder
                .comment("Batch Sulfon entity healing list and amount, format: entity_id->heal_amount")
                .defineList("sulfonHealEntities",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        builder.pop();

        builder.push("DehydFan");
        ENABLE_DEHYD_FAN = builder
                .comment("Enable Batch Dehyd Fan (Requires Mekanism)")
                .define("enableDehydFan", true);
        DEHYD_ENTITY_TRANSFORMS = builder
                .comment("Batch Dehyd entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("dehydEntityTransforms",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        DEHYD_HEAL_ENTITIES = builder
                .comment("Batch Dehyd entity healing list and amount, format: entity_id->heal_amount")
                .defineList("dehydHealEntities",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        builder.pop();

        builder.push("OxidizeFan");
        ENABLE_OXIDIZE_FAN = builder
                .comment("Enable Batch Oxidize Fan (Requires Mekanism)")
                .define("enableOxidizeFan", true);
        OXIDIZE_ENTITY_TRANSFORMS = builder
                .comment("Batch Oxidize entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("oxidizeEntityTransforms",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        OXIDIZE_HEAL_ENTITIES = builder
                .comment("Batch Oxidize entity healing list and amount, format: entity_id->heal_amount")
                .defineList("oxidizeHealEntities",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        builder.pop();

        builder.push("ReduceFan");
        ENABLE_REDUCE_FAN = builder
                .comment("Enable Batch Reduce Fan (Requires Mekanism)")
                .define("enableReduceFan", true);
        REDUCE_ENTITY_TRANSFORMS = builder
                .comment("Batch Reduce entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("reduceEntityTransforms",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        REDUCE_HEAL_ENTITIES = builder
                .comment("Batch Reduce entity healing list and amount, format: entity_id->heal_amount")
                .defineList("reduceHealEntities",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        builder.pop();

        builder.push("FermentFan");
        ENABLE_FERMENT_FAN = builder
                .comment("Enable Batch Ferment Fan (Requires Mekanism Generators)")
                .define("enableFermentFan", true);
        FERMENT_ENTITY_TRANSFORMS = builder
                .comment("Batch Ferment entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("fermentEntityTransforms",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        FERMENT_HEAL_ENTITIES = builder
                .comment("Batch Ferment entity healing list and amount, format: entity_id->heal_amount")
                .defineList("fermentHealEntities",
                        List.of("", ""),
                        () -> "", obj -> obj instanceof String);
        builder.pop();

        builder.push("PreservationFan");
        ENABLE_PRESERVATION_FAN = builder
                .comment("Enable Batch Preservation Fan (Requires Immersive Engineering)")
                .define("enablePreservationFan", true);
        PRESERVATION_ENTITY_TRANSFORMS = builder
                .comment("Batch Preservation entity transformation list, format: input_entity_id->output_entity_id")
                .defineList("preservationEntityTransforms",
                        java.util.List.of("", ""),
                        () -> "",
                        obj -> obj instanceof String);
        PRESERVATION_HEAL_ENTITIES = builder
                .comment("Batch Preservation entity healing list and amount, format: entity_id->heal_amount")
                .defineList("preservationHealEntities",
                        java.util.List.of("", ""),
                        () -> "",
                        obj -> obj instanceof String);
        builder.pop();





        builder.pop();


        SPEC = builder.build();
    }
}
