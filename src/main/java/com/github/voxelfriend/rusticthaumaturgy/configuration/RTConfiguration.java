package com.github.voxelfriend.rusticthaumaturgy.configuration;

import com.github.voxelfriend.rusticthaumaturgy.core.RusticThaumaturgy;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.*;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = RusticThaumaturgy.MODID)
@Config(modid = RusticThaumaturgy.MODID)
public class RTConfiguration {

    @Comment({"Percent chance to get an crop"})
    @RangeInt(min = 0, max = 100)
    public static int cropChance = 100;

    @Comment({"Percent chance to get a second crop"})
    @RangeInt(min = 0, max = 100)
    public static int secondCropChance = 10;

    @Comment({"Percent chance to get a seed drop"})
    @RangeInt(min = 0, max = 100)
    public static int seedChance = 100;

    @Comment({"Percent chance to get a second seed drop"})
    @RangeInt(min = 0, max = 100)
    public static int secondSeedChance = 0;

    @Comment({" Rustic Thaumaturgy Crop growth multiplier on tilled soil, this value multiplies default vanilla growth rate", "e.g. 10.5 -> Ten and a half times the speed of vanilla crop"})
    @RangeDouble(min = 0)
    public static float growthMultiplier = 0.5F;
    
    @Comment({"Whether or not you can use bonemeal on Rustic Thaumaturgy crops"})
    @RequiresMcRestart
    public static boolean canBonemealRTCrops = false;
    
    @Comment({"Set to true to enable to vis crystal candles."})
    @RequiresMcRestart
    public static boolean enableEssentiaCandles = true;
    
    @Comment({"Set to true to enable to vis crystal candles from Ice and Fire. WARNING:WIP"})
    @RequiresMcRestart
    public static boolean enableIceFireEssentiaCandles = false;
    
    @Comment({"Set to true to enable to Rustic styled Thaumcraft colored candles. WARNING:WIP"})
    @RequiresMcRestart
    public static boolean enableColoredCandles = false;

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(RusticThaumaturgy.MODID)) {
            ConfigManager.sync(RusticThaumaturgy.MODID, Type.INSTANCE);
        }
    }
}