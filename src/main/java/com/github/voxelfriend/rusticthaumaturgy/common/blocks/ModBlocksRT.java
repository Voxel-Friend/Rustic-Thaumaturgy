//Hello World

package com.github.voxelfriend.rusticthaumaturgy.common.blocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.github.voxelfriend.rusticthaumaturgy.common.crops.BlockCropCindermote;
import com.github.voxelfriend.rusticthaumaturgy.common.crops.BlockCropShimmerpetal;
import com.github.voxelfriend.rusticthaumaturgy.common.crops.BlockCropViscap;
import com.github.voxelfriend.rusticthaumaturgy.configuration.RTConfiguration;
import com.github.voxelfriend.rusticthaumaturgy.core.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import rustic.common.Config;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.blocks.BlocksTC;

public class ModBlocksRT {

	public static BlockChair CHAIR_GREATWOOD;
	public static BlockChair CHAIR_SILVERWOOD;
	public static BlockTable TABLE_GREATWOOD;
	public static BlockTable TABLE_SILVERWOOD;	
	public static final List<Block> BLOCKS = new ArrayList<>();

	public static final BlockCropCindermote CINDERMOTE = new BlockCropCindermote();
	public static final BlockCropShimmerpetal SHIMMERPETAL = new BlockCropShimmerpetal();
	public static final BlockCropViscap VISCAP = new BlockCropViscap();
	
	public static HashMap<Aspect, BlockCandle> CANDLES = new HashMap<Aspect, BlockCandle>();
	
	public static BlockCandle CANDLE_WHITE;
	public static BlockCandle CANDLE_ORANGE;
	public static BlockCandle CANDLE_MAGENTA;
	public static BlockCandle CANDLE_LIGHT_BLUE;
	public static BlockCandle CANDLE_YELLOW;
	public static BlockCandle CANDLE_LIME;
	public static BlockCandle CANDLE_PINK;
	public static BlockCandle CANDLE_GRAY;
	public static BlockCandle CANDLE_LIGHT_GRAY;
	public static BlockCandle CANDLE_CYAN;
	public static BlockCandle CANDLE_PURPLE;
	public static BlockCandle CANDLE_BLUE;
	public static BlockCandle CANDLE_BROWN;
	public static BlockCandle CANDLE_GREEN;
	public static BlockCandle CANDLE_RED;
	public static BlockCandle CANDLE_BLACK;
	
	public static BlockCandle CANDLE_MYTHUS;
	public static BlockCandle CANDLE_DRACO;
	
	public static void init() {
		if (Config.ENABLE_CHAIRS) {
			CHAIR_GREATWOOD = new BlockChair("greatwood");
			CHAIR_SILVERWOOD = new BlockChair("silverwood");

		}
		if (Config.ENABLE_TABLES) {
			TABLE_GREATWOOD = new BlockTable("greatwood");
			TABLE_SILVERWOOD = new BlockTable("silverwood");

		}
		if (RTConfiguration.enableEssentiaCandles) {
			CommonProxy.VANILLA_ASPECTS.forEach(aspect -> {
					ModBlocksRT.CANDLES.put(aspect, new BlockCandle("candle_" + aspect.getName().toLowerCase()));			    
			}); 			
		}
		if (RTConfiguration.enableColoredCandles) {
			  CANDLE_WHITE = new BlockCandle("candle_white");
			  CANDLE_ORANGE = new BlockCandle("candle_orange");
			  CANDLE_MAGENTA = new BlockCandle("candle_magenta");
			  CANDLE_LIGHT_BLUE = new BlockCandle("candle_light_blue");
			  CANDLE_YELLOW = new BlockCandle("candle_yellow");
			  CANDLE_LIME = new BlockCandle("candle_lime");
			  CANDLE_PINK = new BlockCandle("candle_pink");
			  CANDLE_GRAY = new BlockCandle("candle_gray");
			  CANDLE_LIGHT_GRAY = new BlockCandle("candle_light_gray");
			  CANDLE_CYAN = new BlockCandle("candle_cyan");
			  CANDLE_PURPLE = new BlockCandle("candle_purple");
			  CANDLE_BLUE = new BlockCandle("candle_blue");
			  CANDLE_BROWN = new BlockCandle("candle_brown");
			  CANDLE_GREEN = new BlockCandle("candle_green");
			  CANDLE_RED = new BlockCandle("candle_red");
			  CANDLE_BLACK = new BlockCandle("candle_black");
		}
		if (RTConfiguration.enableIceFireEssentiaCandles) {
			  CANDLE_MYTHUS = new BlockCandle("candle_mythus");
			  CANDLE_DRACO = new BlockCandle("candle_draco");
		}
		
			
		GameRegistry.findRegistry(Block.class).register(CINDERMOTE);
		GameRegistry.findRegistry(Block.class).register(SHIMMERPETAL);
		GameRegistry.findRegistry(Block.class).register(VISCAP);

}

	@SideOnly(Side.CLIENT)
	public static void initModels() {
		if (Config.ENABLE_CHAIRS) {
			CHAIR_GREATWOOD.initModel();
			CHAIR_SILVERWOOD.initModel();

		}
		if (Config.ENABLE_TABLES) {
			TABLE_GREATWOOD.initModel();
			TABLE_SILVERWOOD.initModel();

		}
		if (RTConfiguration.enableIceFireEssentiaCandles) {
			CANDLE_MYTHUS.initModel();
			CANDLE_DRACO.initModel();
		}
		
		if (RTConfiguration.enableEssentiaCandles) {
			ModBlocksRT.CANDLES.values().forEach(candle -> candle.initModel());
		}
		
		if (RTConfiguration.enableColoredCandles) {
			CANDLE_WHITE.initModel();
			  CANDLE_ORANGE.initModel();
			  CANDLE_MAGENTA.initModel();
			  CANDLE_LIGHT_BLUE.initModel();
			  CANDLE_YELLOW.initModel();
			  CANDLE_LIME.initModel();
			  CANDLE_PINK.initModel();
			  CANDLE_GRAY.initModel();
			  CANDLE_LIGHT_GRAY.initModel();
			  CANDLE_CYAN.initModel();
			  CANDLE_PURPLE.initModel();
			  CANDLE_BLUE.initModel();
			  CANDLE_BROWN.initModel();
			  CANDLE_GREEN.initModel();
			  CANDLE_RED.initModel();
			  CANDLE_BLACK.initModel();
		}
		for (Block block : BLOCKS) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(),"inventory"));
		}
	}
}