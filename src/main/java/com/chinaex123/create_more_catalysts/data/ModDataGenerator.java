package com.chinaex123.create_more_catalysts.data;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.dehyd.DehydRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.etch.EtchRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.ferment.FermentRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.oxidize.OxidizeRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.reduce.ReduceRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.salout.SaloutRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.integration.Mekanism.sulfon.SulfonRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.breathed_wind.BreathedWindRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.chocolate_coating.ChocolateCoatingRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.exploding.ExplodingRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.honey_coating.HoneyCoatingRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.purifying.PurifyingRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.resonance.ResonanceRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.sand_blow.SandBlowRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.sculking.SculkingRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.snow_flow.SnowFlowRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.withering.WitheringRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = CreateMoreCatalysts.MOD_ID)
public class ModDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new ModBlockTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModFluidTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModItemTagsProvider(packOutput, lookupProvider,
                CompletableFuture.completedFuture(TagsProvider.TagLookup.empty()), existingFileHelper));


        // 鼓风机处理数据生成
        // =============================== 模组本体 ===============================
        // ==================== 方块触媒 ====================
        generator.addProvider(event.includeServer(), new WitheringRecipeGen(packOutput, lookupProvider)); // 批量凋零
        generator.addProvider(event.includeServer(), new SnowFlowRecipeGen(packOutput, lookupProvider)); // 批量雪流
        generator.addProvider(event.includeServer(), new PurifyingRecipeGen(packOutput, lookupProvider)); // 批量净化
        generator.addProvider(event.includeServer(), new SculkingRecipeGen(packOutput, lookupProvider)); // 批量幽匿
        generator.addProvider(event.includeServer(), new ResonanceRecipeGen(packOutput, lookupProvider)); // 批量共振
        generator.addProvider(event.includeServer(), new SandBlowRecipeGen(packOutput, lookupProvider)); // 批量扬砂
        generator.addProvider(event.includeServer(), new BreathedWindRecipeGen(packOutput, lookupProvider)); // 批量吐息
        generator.addProvider(event.includeServer(), new ExplodingRecipeGen(packOutput, lookupProvider)); // 批量爆炸
        // ==================== 流体触媒 ====================
        generator.addProvider(event.includeServer(), new HoneyCoatingRecipeGen(packOutput, lookupProvider)); // 批量裹蜜
        generator.addProvider(event.includeServer(), new ChocolateCoatingRecipeGen(packOutput, lookupProvider)); // 批量凝巧

        // =============================== 模组联动内容 ===============================
        // ==================== Mekanism 联动 ====================
        if (ModList.get().isLoaded("mekanism")) {
            generator.addProvider(event.includeServer(), new SaloutRecipeGen(packOutput, lookupProvider)); // 批量盐析
            generator.addProvider(event.includeServer(), new EtchRecipeGen(packOutput, lookupProvider)); // 批量蚀刻
            generator.addProvider(event.includeServer(), new SulfonRecipeGen(packOutput, lookupProvider)); // 批量磺化
            generator.addProvider(event.includeServer(), new DehydRecipeGen(packOutput, lookupProvider)); // 批量脱水
            generator.addProvider(event.includeServer(), new OxidizeRecipeGen(packOutput, lookupProvider)); // 批量氧化
            generator.addProvider(event.includeServer(), new ReduceRecipeGen(packOutput, lookupProvider)); // 批量还原
            generator.addProvider(event.includeServer(), new FermentRecipeGen(packOutput, lookupProvider)); // 批量发酵
        }
    }
}
