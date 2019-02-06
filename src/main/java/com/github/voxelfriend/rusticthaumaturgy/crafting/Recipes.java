//Hello World

package com.github.voxelfriend.rusticthaumaturgy.crafting;

//import static blusunrize.immersiveengineering.api.*;

import static rustic.common.crafting.Recipes.brewingRecipes;
import static rustic.common.crafting.Recipes.crushingTubRecipes;
import static rustic.common.crafting.Recipes.evaporatingRecipes;

import com.github.voxelfriend.rusticthaumaturgy.common.blocks.ModBlocksRT;
import com.github.voxelfriend.rusticthaumaturgy.common.blocks.fluids.ModFluidsRT;
import com.github.voxelfriend.rusticthaumaturgy.common.items.ModItemsRT;
import com.github.voxelfriend.rusticthaumaturgy.configuration.RTConfiguration;
import com.github.voxelfriend.rusticthaumaturgy.core.RusticThaumaturgy;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import rustic.common.Config;
import rustic.common.crafting.BrewingBarrelRecipe;
import rustic.common.crafting.CrushingTubRecipe;
import rustic.common.crafting.EvaporatingBasinRecipe;
import rustic.common.items.ModItems;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.items.ItemsTC;

@Mod.EventBusSubscriber(modid = RusticThaumaturgy.MODID)
public class Recipes {
	
	
    public static void init() {
		addCrushingTubRecipes();
		addEvaporatingRecipes();
		addBrewingRecipes();
		addSqueezingRecipes();
    }
    
   public static void addOreDictEntries() {
		//Adds Tiny Pile of Blaze Powder to OreDict
    	OreDictionary.registerOre("dustTinyBlaze", new ItemStack(ModItemsRT.BLAZE_POWDER_TINY));	
	}
		
	@SubscribeEvent
	public static void initRecipes(RegistryEvent.Register<IRecipe> event) {
		
		GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "brass_candle_tallow"),
				new ResourceLocation(RusticThaumaturgy.MODID, "brass_candle"), new ItemStack(ModBlocksRT.BRASS_CANDLE, 4), "S", "T", "I", 'S', new ItemStack(Items.STRING), 'T', new ItemStack(ModItems.TALLOW), 'I', new ItemStack(Items.IRON_INGOT));
		
		GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "brass_candle_beeswax"),
				new ResourceLocation(RusticThaumaturgy.MODID, "brass_candle"), new ItemStack(ModBlocksRT.BRASS_CANDLE, 4), "S", "B", "I", 'S', new ItemStack(Items.STRING), 'B', new ItemStack(ModItems.BEESWAX), 'I', new ItemStack(Items.IRON_INGOT));
		
		GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "chandelier_brass"),
				new ResourceLocation(RusticThaumaturgy.MODID, "chandelier_brass"), new ItemStack(ModBlocksRT.CHANDELIER_BRASS, 4), " B ", "C C", "BBB", 'B', new ItemStack(ItemsTC.ingots, 1, 2), 'C', new ItemStack(ModBlocksRT.CHAIN_BRASS));
		
		GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "brass_lantern"),
				new ResourceLocation(RusticThaumaturgy.MODID, "brass_lantern"), new ItemStack(ModBlocksRT.BRASS_LANTERN, 4), " B ", " C ", " B ", 'B', new ItemStack(ItemsTC.ingots, 1, 2), 'C', new ItemStack(Items.COAL, 1, 32767));
		
		GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "chain_brass"),
				new ResourceLocation(RusticThaumaturgy.MODID, "chain_brass"), new ItemStack(ModBlocksRT.CHAIN_BRASS, 12), " B ", " B ", " B ", 'B', new ItemStack(ItemsTC.ingots, 1, 2));
		
		
		if (Config.ENABLE_CHAIRS) {
			//Greatwood Chair Recipe
			GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "greatwood_chair"),
				new ResourceLocation(RusticThaumaturgy.MODID, "chair"), new ItemStack(ModBlocksRT.CHAIR_GREATWOOD, 4), "P  ", "PPP", "S S", 'P', new ItemStack(BlocksTC.plankGreatwood), 'S', new ItemStack(Items.STICK));
			
			//Silverwood Chair Recipe
			GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "silverwood_chair"),
				new ResourceLocation(RusticThaumaturgy.MODID, "chair"), new ItemStack(ModBlocksRT.CHAIR_SILVERWOOD, 4), "P  ", "PPP", "S S", 'P', new ItemStack(BlocksTC.plankSilverwood), 'S', new ItemStack(Items.STICK));
		}
		if (Config.ENABLE_TABLES) {
			//Greatwood Table Recipe
			GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "greatwood_table"),
				new ResourceLocation(RusticThaumaturgy.MODID, "table"), new ItemStack(ModBlocksRT.TABLE_GREATWOOD, 2), "PPP", "S S", 'P', new ItemStack(BlocksTC.plankGreatwood), 'S', new ItemStack(Items.STICK));
			
			//Silverwood Table Recipe
			GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "silverwood_table"),
				new ResourceLocation(RusticThaumaturgy.MODID, "table"), new ItemStack(ModBlocksRT.TABLE_SILVERWOOD, 2), "PPP", "S S", 'P', new ItemStack(BlocksTC.plankSilverwood), 'S', new ItemStack(Items.STICK));

		if (RTConfiguration.enableColoredCandles ) {
			
		}
		//Tiny Pile of Blaze Powder to Blaze Powder Recipe
		GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "dustTinyBlaze"), new ResourceLocation(RusticThaumaturgy.MODID, "conversion"), new ItemStack(Items.BLAZE_POWDER, 1), "PP", "PP", 'P', new ItemStack(ModItemsRT.BLAZE_POWDER_TINY));
		//Blaze Powder to Tiny Pile of Blaze Powder Recipe
		GameRegistry.addShapelessRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "blaze_powder"), new ResourceLocation(RusticThaumaturgy.MODID, "conversion"), new ItemStack(ModItemsRT.BLAZE_POWDER_TINY, 4), Ingredient.fromStacks(new ItemStack(Items.BLAZE_POWDER)));
		//Cindermote to Tiny Pile of Blaze Powder Conversion Recipe
		GameRegistry.addShapelessRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "cindermote"), new ResourceLocation(RusticThaumaturgy.MODID, "conversion"), new ItemStack(ModItemsRT.BLAZE_POWDER_TINY), Ingredient.fromStacks(new ItemStack(ModItemsRT.CINDERMOTE)));
		GameRegistry.addShapelessRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "shimmerpetal"), new ResourceLocation(RusticThaumaturgy.MODID, "conversion"), new ItemStack(ItemsTC.nuggets, 1 ,5), Ingredient.fromStacks(new ItemStack(ModItemsRT.SHIMMERPETAL)));
		}
	}
	
	public static void addSqueezingRecipes() {
		if (Loader.isModLoaded("immersiveengineering")) {
			
		}
			
		
	}
	
	public static void addCrushingTubRecipes() {
		//Cinderfire Wort Crushing Recipes
		crushingTubRecipes.add(new CrushingTubRecipe(new FluidStack(ModFluidsRT.CINDERFIRE_WORT, 125), new ItemStack(ModItemsRT.CINDERMOTE)));
		crushingTubRecipes.add(new CrushingTubRecipe(new FluidStack(ModFluidsRT.CINDERFIRE_WORT, 250), new ItemStack(BlocksTC.cinderpearl)));
		
		//Shimmerdew Wort Crushing Recipes
		crushingTubRecipes.add(new CrushingTubRecipe(new FluidStack(ModFluidsRT.SHIMMERDEW_WORT, 125), new ItemStack(ModItemsRT.SHIMMERPETAL)));
		crushingTubRecipes.add(new CrushingTubRecipe(new FluidStack(ModFluidsRT.SHIMMERDEW_WORT, 250), new ItemStack(BlocksTC.shimmerleaf)));
		
		//Viscous Brew Crushing Recipes
		crushingTubRecipes.add(new CrushingTubRecipe(new FluidStack(ModFluidsRT.VISCOUS_WORT, 125), new ItemStack(ModItemsRT.VISCAP)));
		crushingTubRecipes.add(new CrushingTubRecipe(new FluidStack(ModFluidsRT.VISCOUS_WORT, 250), new ItemStack(BlocksTC.vishroom)));
	}
		
	public static void addEvaporatingRecipes() {
		//Tiny Pile of Blaze Powder Evaporation Recipe
		evaporatingRecipes.add(new EvaporatingBasinRecipe(new ItemStack(ModItemsRT.BLAZE_POWDER_TINY, 1),
					new FluidStack(ModFluidsRT.CINDERFIRE_WORT, 500)));
	}
		
	public static void addBrewingRecipes() {
		//Cinderfire Whiskey Recipe
		brewingRecipes.add(new BrewingBarrelRecipe(new FluidStack(ModFluidsRT.CINDERFIRE_WHISKEY, 1), new FluidStack(ModFluidsRT.CINDERFIRE_WORT, 1)));
		
		//Shimmerdew Spirits Recipe
		brewingRecipes.add(new BrewingBarrelRecipe(new FluidStack(ModFluidsRT.SHIMMERDEW_SPIRITS, 1), new FluidStack(ModFluidsRT.SHIMMERDEW_WORT, 1)));
		
		//Viscous Brew Recipe
		brewingRecipes.add(new BrewingBarrelRecipe(new FluidStack(ModFluidsRT.VISCOUS_BREW, 1),new FluidStack(ModFluidsRT.VISCOUS_WORT, 1)));
	}
}