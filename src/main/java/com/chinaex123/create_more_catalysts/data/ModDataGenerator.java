package com.chinaex123.create_more_catalysts.data;

import com.chinaex123.create_more_catalysts.CreateMoreCatalysts;
import com.chinaex123.create_more_catalysts.processing.fans.integration.Anvilcraft.corrupted.CorruptedRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.integration.ImmersiveEngineering.preservation.PreservationRecipeGen;
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
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.mossify.MossifyRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.purifying.PurifyingRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.resonance.ResonanceRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.sand_blow.SandBlowRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.sculking.SculkingRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.snow_flow.SnowFlowRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.tear.TearRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.tidal.TidalRecipeGen;
import com.chinaex123.create_more_catalysts.processing.fans.vanilla.withering.WitheringRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = CreateMoreCatalysts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new ModBlockTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModFluidTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModItemTagsProvider(packOutput, lookupProvider,
                CompletableFuture.completedFuture(TagsProvider.TagLookup.empty()), existingFileHelper));


        // 鼓风机处理数据生成
        // =============================== 模组本体 ===============================
        // ==================== 方块触媒 ====================
        generator.addProvider(event.includeServer(), new WitheringRecipeGen(packOutput)); // 批量凋零
        generator.addProvider(event.includeServer(), new SnowFlowRecipeGen(packOutput)); // 批量雪流
        generator.addProvider(event.includeServer(), new PurifyingRecipeGen(packOutput)); // 批量净化
        generator.addProvider(event.includeServer(), new SculkingRecipeGen(packOutput)); // 批量幽匿
        generator.addProvider(event.includeServer(), new ResonanceRecipeGen(packOutput)); // 批量共振
        generator.addProvider(event.includeServer(), new SandBlowRecipeGen(packOutput)); // 批量扬砂
        generator.addProvider(event.includeServer(), new BreathedWindRecipeGen(packOutput)); // 批量吐息
        generator.addProvider(event.includeServer(), new ExplodingRecipeGen(packOutput)); // 批量爆炸
        generator.addProvider(event.includeServer(), new TidalRecipeGen(packOutput)); // 批量海潮
        generator.addProvider(event.includeServer(), new TearRecipeGen(packOutput)); // 批量催泪
        generator.addProvider(event.includeServer(), new MossifyRecipeGen(packOutput)); // 批量苔化
        // ==================== 流体触媒 ====================
        generator.addProvider(event.includeServer(), new HoneyCoatingRecipeGen(packOutput)); // 批量裹蜜
        generator.addProvider(event.includeServer(), new ChocolateCoatingRecipeGen(packOutput)); // 批量凝巧

        // =============================== 模组联动内容 ===============================
        // ==================== 通用机械 联动 ====================
        if (ModList.get().isLoaded("mekanism")) {
            generator.addProvider(event.includeServer(), new SaloutRecipeGen(packOutput)); // 批量盐析
            generator.addProvider(event.includeServer(), new EtchRecipeGen(packOutput)); // 批量蚀刻
            generator.addProvider(event.includeServer(), new SulfonRecipeGen(packOutput)); // 批量磺化
            generator.addProvider(event.includeServer(), new DehydRecipeGen(packOutput)); // 批量脱水
            generator.addProvider(event.includeServer(), new OxidizeRecipeGen(packOutput)); // 批量氧化
            generator.addProvider(event.includeServer(), new ReduceRecipeGen(packOutput)); // 批量还原
            generator.addProvider(event.includeServer(), new FermentRecipeGen(packOutput)); // 批量发酵
        }

        // ==================== 沉浸工程 联动 ====================
        if (ModList.get().isLoaded("immersiveengineering")) {
            generator.addProvider(event.includeServer(), new PreservationRecipeGen(packOutput)); // 批量防腐
        }

        // ==================== 铁砧工艺/莱特兰-恶意 联动 ====================
        if (ModList.get().isLoaded("anvilcraft") || ModList.get().isLoaded("l2hostility")) {
            generator.addProvider(event.includeServer(), new CorruptedRecipeGen(packOutput)); // 批量腐化
        }
    }
}
