package com.chinaex123.create_more_catalysts.processing.fans;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;

/**
 * 风扇加工音效管理器：处理风扇作用时的分层音效播放和频率控制
 */
public final class FanProcessingSounds {

    private FanProcessingSounds() {}

    /**
     * 播放凋零音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void witherSound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 36, 17)) return;
        playLayered(level, pos,
                SoundEvents.WITHER_AMBIENT, 0.3f, 1.0f, 1.2f,
                SoundEvents.SOUL_ESCAPE, 0.15f, 0.9f, 1.1f);
    }

    /**
     * 播放雪流音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void snowFlowSound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 25, 31)) return;
        play(level, pos, SoundEvents.PLAYER_HURT_FREEZE, 0.3f, 1.0f, 1.2f);
    }

    /**
     * 播放净化音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void purifySound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 40, 23)) return;
        playLayered(level, pos,
                SoundEvents.BEACON_AMBIENT, 0.3f, 1.0f, 1.2f,
                SoundEvents.BEACON_ACTIVATE, 0.15f, 0.9f, 1.1f);
    }

    /**
     * 播放幽匿音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void sculkingSound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 20, 29)) return;
        playLayered(level, pos,
                SoundEvents.SCULK_BLOCK_PLACE, 0.3f, 1.0f, 1.2f,
                SoundEvents.SCULK_SENSOR_PLACE, 0.15f, 0.9f, 1.1f);
    }

    /**
     * 播放共振音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void resonanceSound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 30, 29)) return;
        playLayered(level, pos,
                SoundEvents.AMETHYST_CLUSTER_PLACE, 0.3f, 1.0f, 1.2f,
                SoundEvents.AMETHYST_BLOCK_CHIME, 0.15f, 0.9f, 1.1f);
    }

    /**
     * 播放扬砂音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void sandBlowSound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 28, 37)) return;
        play(level, pos, SoundEvents.SAND_PLACE, 0.3f, 1.0f, 1.2f);
    }

    /**
     * 播放吐息音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void breathedWindSound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 35, 41)) return;
        playLayered(level, pos,
                SoundEvents.ENDER_DRAGON_AMBIENT, 0.3f, 1.0f, 1.2f,
                SoundEvents.ENDER_DRAGON_GROWL, 0.15f, 0.9f, 1.1f);
    }

    /**
     * 播放爆炸音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void explodingSound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 32, 49)) return;
        playLayered(level, pos,
                SoundEvents.CREEPER_PRIMED, 0.3f, 1.0f, 1.2f,
                SoundEvents.TNT_PRIMED, 0.15f, 0.9f, 1.1f);
    }

    /**
     * 播放裹蜜音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void honeyCoatingSound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 30, 51)) return;
        playLayered(level, pos,
                SoundEvents.HONEY_BLOCK_PLACE, 0.3f, 1.0f, 1.2f,
                SoundEvents.HONEY_DRINK, 0.15f, 0.9f, 1.1f);
    }

    /**
     * 播放凝巧音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void chocolateCoatingSound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 30, 57)) return;
        playLayered(level, pos,
                SoundEvents.HONEY_DRINK, 0.3f, 1.0f, 1.2f,
                SoundEvents.CAKE_ADD_CANDLE, 0.15f, 0.9f, 1.1f);
    }

    /**
     * 播放海潮音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void tidalSound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 28, 71)) return;
        playLayered(level, pos,
                SoundEvents.CONDUIT_AMBIENT, 0.3f, 1.0f, 1.2f,
                SoundEvents.CONDUIT_ACTIVATE, 0.15f, 0.9f, 1.1f);
    }

    /**
     * 播放催泪音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void tearSound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 30, 73)) return;
        playLayered(level, pos,
                SoundEvents.VEX_AMBIENT, 0.3f, 1.0f, 1.2f,
                SoundEvents.GHAST_HURT, 0.15f, 0.9f, 1.1f);
    }


    // =============================== 联动 ===============================

    /**
     * 播放盐析音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void saloutSound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 30, 19)) return;
        playLayered(level, pos,
                SoundEvents.SLIME_ATTACK, 0.3f, 1.0f, 1.2f,
                SoundEvents.SLIME_JUMP, 0.15f, 0.9f, 1.1f);
    }

    /**
     * 播放蚀刻音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void etchSound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 25, 37)) return;
        playLayered(level, pos,
                SoundEvents.GENERIC_BURN, 0.3f, 1.0f, 1.2f,
                SoundEvents.FIRE_EXTINGUISH, 0.15f, 0.9f, 1.1f);
    }

    /**
     * 播放磺化音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void sulfonSound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 28, 43)) return;
        playLayered(level, pos,
                SoundEvents.SLIME_ATTACK, 0.3f, 1.0f, 1.2f,
                SoundEvents.GENERIC_BURN, 0.15f, 0.9f, 1.1f);
    }

    /**
     * 播放脱水音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void dehydSound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 32, 47)) return;
        playLayered(level, pos,
                SoundEvents.SAND_BREAK, 0.3f, 1.0f, 1.2f,
                SoundEvents.GRAVEL_PLACE, 0.15f, 0.9f, 1.1f);
    }

    /**
     * 播放氧化音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void oxidizeSound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 30, 53)) return;
        playLayered(level, pos,
                SoundEvents.AMETHYST_BLOCK_CHIME, 0.3f, 1.0f, 1.2f,
                SoundEvents.COPPER_BREAK, 0.15f, 0.9f, 1.1f);
    }

    /**
     * 播放还原音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void reduceSound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 28, 59)) return;
        playLayered(level, pos,
                SoundEvents.FISHING_BOBBER_RETRIEVE, 0.3f, 1.0f, 1.2f,
                SoundEvents.GENERIC_SPLASH, 0.15f, 0.9f, 1.1f);
    }

    /**
     * 播放发酵音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void fermentSound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 30, 61)) return;
        playLayered(level, pos,
                SoundEvents.COMPOSTER_READY, 0.3f, 1.0f, 1.2f,
                SoundEvents.SLIME_ATTACK, 0.15f, 0.9f, 1.1f);
    }

    /**
     * 播放防腐音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void preservationSound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 30, 63)) return;
        playLayered(level, pos,
                SoundEvents.HONEY_DRINK, 0.3f, 1.0f, 1.2f,
                SoundEvents.GENERIC_DRINK, 0.15f, 0.9f, 1.1f);
    }

    /**
     * 播放腐化音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void corruptedSound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 30, 75)) return;
        playLayered(level, pos,
                SoundEvents.BEACON_DEACTIVATE, 0.3f, 1.0f, 1.2f,
                SoundEvents.WITHER_SPAWN, 0.15f, 0.9f, 1.1f);
    }

    /**
     * 播放苔化音效
     * @param level 世界实例
     * @param pos 音效播放位置
     */
    public static void mossifySound(Level level, BlockPos pos) {
        if (shouldNotPlayOnTick(level, pos, 30, 77)) return;
        playLayered(level, pos,
                SoundEvents.MOSS_PLACE, 0.3f, 1.0f, 1.2f,
                SoundEvents.GRASS_PLACE, 0.15f, 0.9f, 1.1f);
    }

    /**
     * 判断当前刻是否应跳过音效播放：基于位置和游戏时间的哈希算法实现分散播放
     * @param level 世界实例
     * @param pos 音效位置
     * @param interval 播放间隔（刻）
     * @param salt 随机盐值用于分散不同位置的播放时机
     * @return true 表示当前刻不应播放
     */
    private static boolean shouldNotPlayOnTick(Level level, BlockPos pos, int interval, int salt) {
        long phaseSeed = pos.asLong() ^ salt;
        int phase = Math.floorMod(Long.hashCode(phaseSeed), interval);
        return Math.floorMod(level.getGameTime() + phase, interval) != 0;
    }

    /**
     * 播放分层音效：同时播放主音效和次级音效以增强听觉层次
     * @param level 世界实例
     * @param pos 音效位置
     * @param primary 主音效
     * @param primaryVolume 主音效音量
     * @param primaryMinPitch 主音效最小音高
     * @param primaryMaxPitch 主音效最大音高
     * @param secondary 次级音效
     * @param secondaryVolume 次级音效音量
     * @param secondaryMinPitch 次级音效最小音高
     * @param secondaryMaxPitch 次级音效最大音高
     */
    private static void playLayered(Level level, BlockPos pos, SoundEvent primary, float primaryVolume, float primaryMinPitch, float primaryMaxPitch,
                                    SoundEvent secondary, float secondaryVolume, float secondaryMinPitch, float secondaryMaxPitch) {
        if (level.isClientSide) {
            return;
        }

        play(level, pos, primary, primaryVolume, primaryMinPitch, primaryMaxPitch);
        play(level, pos, secondary, secondaryVolume, secondaryMinPitch, secondaryMaxPitch);
    }

    /**
     * 播放单个音效：在指定范围内随机化音高以增加自然感
     * @param level 世界实例
     * @param pos 音效位置
     * @param event 音效事件
     * @param volume 音量
     * @param minPitch 最小音高
     * @param maxPitch 最大音高
     */
    private static void play(Level level, BlockPos pos, SoundEvent event, float volume, float minPitch, float maxPitch) {
        level.playSound(null, pos, event, SoundSource.BLOCKS, volume, minPitch + (level.random.nextFloat() * (maxPitch - minPitch)));
    }
}
