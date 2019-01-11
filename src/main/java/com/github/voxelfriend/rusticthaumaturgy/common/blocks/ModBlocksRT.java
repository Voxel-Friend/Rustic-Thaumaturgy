//Hello World

package com.github.voxelfriend.rusticthaumaturgy.common.blocks;

import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

import com.github.voxelfriend.rusticthaumaturgy.common.crops.BlockCropCindermote;
import com.github.voxelfriend.rusticthaumaturgy.common.crops.BlockCropShimmerpetal;
import com.github.voxelfriend.rusticthaumaturgy.common.crops.BlockCropViscap;
import com.github.voxelfriend.rusticthaumaturgy.common.items.ModItemsRT;
import com.github.voxelfriend.rusticthaumaturgy.configuration.RTConfiguration;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import rustic.common.Config;

public class ModBlocksRT {

	public static BlockChair CHAIR_GREATWOOD;
	public static BlockChair CHAIR_SILVERWOOD;
	public static BlockTable TABLE_GREATWOOD;
	public static BlockTable TABLE_SILVERWOOD;	
	public static final List<Block> BLOCKS = new ArrayList<>();

	public static final BlockCropCindermote CINDERMOTE = new BlockCropCindermote();
	public static final BlockCropShimmerpetal SHIMMERPETAL = new BlockCropShimmerpetal();
	public static final BlockCropViscap VISCAP = new BlockCropViscap();
	
	public static BlockCandle CANDLE_AER;
	public static BlockCandle CANDLE_TERRA;
	public static BlockCandle CANDLE_IGNIS;
	public static BlockCandle CANDLE_AQUA;
	public static BlockCandle CANDLE_ORDO;
	public static BlockCandle CANDLE_PERDITIO;
	public static BlockCandle CANDLE_VACUOS;
	public static BlockCandle CANDLE_AURAM;
	public static BlockCandle CANDLE_VITIUM;
	public static BlockCandle CANDLE_LUX;
	public static BlockCandle CANDLE_POTENTIA;
	public static BlockCandle CANDLE_MOTUS;
	public static BlockCandle CANDLE_VICTUS;
	public static BlockCandle CANDLE_MORTUUS;
	public static BlockCandle CANDLE_VOLATUS;
	public static BlockCandle CANDLE_TENEBRAE;
	public static BlockCandle CANDLE_HERBA;
	public static BlockCandle CANDLE_SPIRITUS;
	public static BlockCandle CANDLE_HUMANUS;
	public static BlockCandle CANDLE_BESTIA;
	public static BlockCandle CANDLE_EXANIMIS;
	public static BlockCandle CANDLE_COGNITIO;
	public static BlockCandle CANDLE_SENSUS;
	public static BlockCandle CANDLE_METALLUM;
	public static BlockCandle CANDLE_INSTRUMENTUM;
	public static BlockCandle CANDLE_AVERSIO;
	public static BlockCandle CANDLE_GELUM;
	public static BlockCandle CANDLE_VITREUS;
	public static BlockCandle CANDLE_ALIENIS;
	public static BlockCandle CANDLE_PRAEMUNIO;
	public static BlockCandle CANDLE_FABRICO;
	public static BlockCandle CANDLE_DESIDERIUM;
	public static BlockCandle CANDLE_MACHINA;
	public static BlockCandle CANDLE_VINCULUM;
	public static BlockCandle CANDLE_PERMUTATIO;
	public static BlockCandle CANDLE_PRAECANTATIO;
	public static BlockCandle CANDLE_ALKIMIA;
	
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
			CANDLE_AER = new BlockCandle("candle_aer");
			CANDLE_TERRA = new BlockCandle("candle_terra");
			CANDLE_IGNIS = new BlockCandle("candle_ignis");
			CANDLE_AQUA = new BlockCandle("candle_aqua");
			CANDLE_ORDO = new BlockCandle("candle_ordo");
			CANDLE_PERDITIO = new BlockCandle("candle_perditio");
			CANDLE_VACUOS = new BlockCandle("candle_vacuos");
			CANDLE_AURAM = new BlockCandle("candle_auram");
			CANDLE_VITIUM = new BlockCandle("candle_vitium");
			CANDLE_LUX = new BlockCandle("candle_lux");
			CANDLE_POTENTIA = new BlockCandle("candle_potentia");
			CANDLE_MOTUS = new BlockCandle("candle_motus");
			CANDLE_VICTUS = new BlockCandle("candle_victus");
			CANDLE_MORTUUS = new BlockCandle("candle_mortuus");
			CANDLE_VOLATUS = new BlockCandle("candle_volatus");
			CANDLE_TENEBRAE = new BlockCandle("candle_tenebrae");
			CANDLE_HERBA = new BlockCandle("candle_herba");
			CANDLE_SPIRITUS = new BlockCandle("candle_spiritus");
			CANDLE_HUMANUS = new BlockCandle("candle_humanus");
			CANDLE_BESTIA = new BlockCandle("candle_bestia");
			CANDLE_EXANIMIS = new BlockCandle("candle_exanimis");
			CANDLE_COGNITIO = new BlockCandle("candle_cognitio");
			CANDLE_SENSUS = new BlockCandle("candle_sensus");
			CANDLE_METALLUM = new BlockCandle("candle_metallum");
			CANDLE_INSTRUMENTUM = new BlockCandle("candle_instrumentum");
			CANDLE_AVERSIO = new BlockCandle("candle_aversio");
			CANDLE_GELUM = new BlockCandle("candle_gelum");
			CANDLE_VITREUS = new BlockCandle("candle_vitreus");
			CANDLE_ALIENIS = new BlockCandle("candle_alienis");
			CANDLE_PRAEMUNIO = new BlockCandle("candle_praemunio");
			CANDLE_FABRICO = new BlockCandle("candle_fabrico");
			CANDLE_DESIDERIUM = new BlockCandle("candle_desiderium");
			CANDLE_MACHINA = new BlockCandle("candle_machina");
			CANDLE_VINCULUM = new BlockCandle("candle_vinculum");
			CANDLE_PERMUTATIO = new BlockCandle("candle_permutatio");
			CANDLE_PRAECANTATIO = new BlockCandle("candle_praecantatio");
			CANDLE_ALKIMIA = new BlockCandle("candle_alkimia");	
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
			CANDLE_AER.initModel();
			CANDLE_TERRA.initModel();
			CANDLE_IGNIS.initModel();
			CANDLE_AQUA.initModel();
			CANDLE_ORDO.initModel();
			CANDLE_PERDITIO.initModel();
			CANDLE_VACUOS.initModel();
			CANDLE_AURAM.initModel();
			CANDLE_VITIUM.initModel();
			CANDLE_LUX.initModel();
			CANDLE_POTENTIA.initModel();
			CANDLE_MOTUS.initModel();
			CANDLE_VICTUS.initModel();
			CANDLE_MORTUUS.initModel();
			CANDLE_VOLATUS.initModel();
			CANDLE_TENEBRAE.initModel();
			CANDLE_HERBA.initModel();
			CANDLE_SPIRITUS.initModel();
			CANDLE_HUMANUS.initModel();
			CANDLE_BESTIA.initModel();
			CANDLE_EXANIMIS.initModel();
			CANDLE_COGNITIO.initModel();
			CANDLE_SENSUS.initModel();
			CANDLE_METALLUM.initModel();
			CANDLE_INSTRUMENTUM.initModel();
			CANDLE_AVERSIO.initModel();
			CANDLE_GELUM.initModel();
			CANDLE_VITREUS.initModel();
			CANDLE_ALIENIS.initModel();
			CANDLE_PRAEMUNIO.initModel();
			CANDLE_FABRICO.initModel();
			CANDLE_DESIDERIUM.initModel();
			CANDLE_MACHINA.initModel();
			CANDLE_VINCULUM.initModel();
			CANDLE_PERMUTATIO.initModel();
			CANDLE_PRAECANTATIO.initModel();
			CANDLE_ALKIMIA.initModel();
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