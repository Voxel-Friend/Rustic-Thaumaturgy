//Hello World

package com.github.voxelfriend.rusticthaumaturgy.core;

import java.util.Arrays;
import java.util.List;

import com.github.voxelfriend.rusticthaumaturgy.common.blocks.ModBlocksRT;
import com.github.voxelfriend.rusticthaumaturgy.common.blocks.fluids.ModFluidsRT;
import com.github.voxelfriend.rusticthaumaturgy.common.items.ModItemsRT;
import com.github.voxelfriend.rusticthaumaturgy.configuration.RTConfiguration;
import com.github.voxelfriend.rusticthaumaturgy.crafting.BrassCandleRecipe;
import com.github.voxelfriend.rusticthaumaturgy.crafting.CandleRecipe;
import com.github.voxelfriend.rusticthaumaturgy.crafting.Recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import rustic.common.blocks.ModBlocks;
import rustic.common.items.ItemFluidBottle;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.golems.EnumGolemTrait;
import thaumcraft.api.golems.parts.GolemMaterial;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchCategory;
import thaumcraft.api.research.ScanBlockState;
import thaumcraft.api.research.ScanItem;
import thaumcraft.api.research.ScanningManager;


public class CommonProxy {
	
	static ResourceLocation defaultGroup = new ResourceLocation("");
	 
	public static Configuration config;
	public static List<Aspect> VANILLA_ASPECTS;

	public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
		VANILLA_ASPECTS = Arrays.asList(new Aspect[]{Aspect.AIR, Aspect.EARTH, Aspect.FIRE, Aspect.WATER, Aspect.ORDER, Aspect.ENTROPY, Aspect.VOID, Aspect.LIGHT, Aspect.MOTION, Aspect.COLD, Aspect.CRYSTAL, Aspect.METAL, Aspect.LIFE, Aspect.DEATH, Aspect.ENERGY, Aspect.EXCHANGE, Aspect.MAGIC, Aspect.AURA, Aspect.ALCHEMY, Aspect.FLUX, Aspect.DARKNESS, Aspect.ELDRITCH, Aspect.FLIGHT, Aspect.PLANT, Aspect.TOOL, Aspect.CRAFT, Aspect.MECHANISM, Aspect.TRAP, Aspect.SOUL, Aspect.MIND, Aspect.SENSES, Aspect.AVERSION, Aspect.PROTECT, Aspect.DESIRE, Aspect.UNDEAD, Aspect.BEAST, Aspect.MAN});
		ModFluidsRT.init();
        ModBlocksRT.init();
        ModItemsRT.init();
        initGolems();
    }
	
	public void init(FMLInitializationEvent event) {
    	Recipes.init();
		initFluidBottle();
		ResearchCategories.registerCategory("RUSTIC_THAUMATURGY", "UNLOCKAUROMANCY",
				new AspectList(),
				new ResourceLocation("rusticthaumaturgy", "textures/research/brewing_barrel.png"),
				new ResourceLocation("thaumcraft", "textures/gui/gui_research_back_2.jpg"),
                new ResourceLocation("thaumcraft", "textures/gui/gui_research_back_over.png"));
		
		ThaumcraftApi.registerResearchLocation(new ResourceLocation(RusticThaumaturgy.MODID, "research/rustic_thaumaturgy"));
	
	}

    public void postInit(FMLPostInitializationEvent event) {
    	initResearch();
    }
    
    public void initFluidBottle() {
        ItemFluidBottle.addFluid(ModFluidsRT.CINDERFIRE_WHISKEY);
        ItemFluidBottle.addFluid(ModFluidsRT.CINDERFIRE_WORT);
        ItemFluidBottle.addFluid(ModFluidsRT.SHIMMERDEW_WORT);
        ItemFluidBottle.addFluid(ModFluidsRT.SHIMMERDEW_SPIRITS);
        ItemFluidBottle.addFluid(ModFluidsRT.VISCOUS_WORT);
        ItemFluidBottle.addFluid(ModFluidsRT.VISCOUS_BREW);
    }
    protected void initGolems() {
    	ResearchCategory rusticthaumaturgy = ResearchCategories.getResearchCategory("RUSTIC_THAUMATURGY");
    	GolemMaterial.register(
                new GolemMaterial(
                        "IRONWOOD",
                        new String[]{"RT_MATSTUDIRONWOOD"},
                        new ResourceLocation(
                                "rusticthaumaturgy",
                                "textures/entity/mat_ironwood.png"
                        ),
                        11045996,
                        6,
                        2,
                        1,
                        new ItemStack(
                                ModBlocks.PLANKS,
                                1,
                                1
                        ),
                        new ItemStack(
                                ItemsTC.mechanismSimple
                        ),
                        new EnumGolemTrait[]{EnumGolemTrait.BLASTPROOF}
                        )
        );
    	
    }
    protected void initResearch() {    	
    	ResearchCategory rusticthaumaturgy = ResearchCategories.getResearchCategory("RUSTIC_THAUMATURGY"); 

    	if (RTConfiguration.enableEssentiaCandles) {    	    
    	    ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "candle"), new CandleRecipe());
    	    ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "candle_brass"), new BrassCandleRecipe());
    	}
    	
    	ThaumcraftApi.addInfusionCraftingRecipe(
    			new ResourceLocation(RusticThaumaturgy.MODID, "cindermote_seeds"
    			    ),
				new InfusionRecipe("RT_CINDERMOTE",
						//Result
						new ItemStack(ModItemsRT.CINDERMOTE_SEEDS),
						//Stability
						2,
						//Essentia Requirements
						new AspectList()
						.add(Aspect.PLANT, 50)
						.add(Aspect.LIFE, 50)
						.add(Aspect.FIRE, 25),
						//Center Item
						new ItemStack(BlocksTC.cinderpearl),
						//Outer Items
						new ItemStack(Items.WHEAT_SEEDS),
						new ItemStack(Items.DYE, 1, 15),
						new ItemStack(Items.WATER_BUCKET),
						new ItemStack(Items.WHEAT_SEEDS),
						new ItemStack(Items.DYE, 1, 15),
						new ItemStack(Items.WATER_BUCKET),
						new ItemStack(Items.WHEAT_SEEDS),
						new ItemStack(Items.DYE, 1, 15),
						new ItemStack(Items.WATER_BUCKET),
						new ItemStack(Items.WHEAT_SEEDS),
						new ItemStack(Items.DYE, 1, 15),
						new ItemStack(Items.WATER_BUCKET)
			    )
		);
    	
    	ThaumcraftApi.addInfusionCraftingRecipe(
    			new ResourceLocation(RusticThaumaturgy.MODID, "shimmerpetal_bulb"
    			),
				new InfusionRecipe("RT_SHIMMERPETAL",
						//Result
						new ItemStack(ModItemsRT.SHIMMERPETAL_BULB),
						//Stability
						2,
						//Essentia Requirements
						new AspectList()
						.add(Aspect.PLANT, 50)
						.add(Aspect.LIFE, 50)
						.add(Aspect.AURA, 25),
						//Center Item
						new ItemStack(BlocksTC.shimmerleaf),
						//Outer Items
						new ItemStack(Items.POTATO),
						new ItemStack(Items.DYE, 1, 15),
						new ItemStack(Items.WATER_BUCKET),
						new ItemStack(Items.POTATO),
						new ItemStack(Items.DYE, 1, 15),
						new ItemStack(Items.WATER_BUCKET),
						new ItemStack(Items.POTATO),
						new ItemStack(Items.DYE, 1, 15),
						new ItemStack(Items.WATER_BUCKET),
						new ItemStack(Items.POTATO),
						new ItemStack(Items.DYE, 1, 15),
						new ItemStack(Items.WATER_BUCKET)
			    )
		);
    	
    	ThaumcraftApi.addInfusionCraftingRecipe(
    			new ResourceLocation(RusticThaumaturgy.MODID, "viscap_spores"
    			),
				new InfusionRecipe("RT_VISCAP",
						//Result
						new ItemStack(ModItemsRT.VISCAP_SPORES),
						//Stability
						2,
						//Essentia Requirements
						new AspectList()
						.add(Aspect.PLANT, 50)
						.add(Aspect.LIFE, 50)
						.add(Aspect.MAGIC, 25),
						//Center Item
						new ItemStack(BlocksTC.vishroom),
						//Outer Items
						new ItemStack(Blocks.BROWN_MUSHROOM),
						new ItemStack(Items.DYE, 1, 15),
						new ItemStack(Items.WATER_BUCKET),
						new ItemStack(Blocks.RED_MUSHROOM),
						new ItemStack(Items.DYE, 1, 15),
						new ItemStack(Items.WATER_BUCKET),
						new ItemStack(Blocks.BROWN_MUSHROOM),
						new ItemStack(Items.DYE, 1, 15),
						new ItemStack(Items.WATER_BUCKET),
						new ItemStack(Blocks.RED_MUSHROOM),
						new ItemStack(Items.DYE, 1, 15),
						new ItemStack(Items.WATER_BUCKET)
			    )
		);
    	
        ScanningManager.addScannableThing(
                new ScanItem(
                        "f_RT_IRONWOOD",
                        new ItemStack(
                                ModBlocks.LOG,
                                1,
                                1
                        )
                )
        );
        ScanningManager.addScannableThing(
                new ScanBlockState(
                        "f_RT_IRONWOOD",
                        ModBlocks.LOG.getStateFromMeta(1),
                        false
                )
        );
        
        ScanningManager.addScannableThing(
                new ScanItem(
                        "f_RT_CANDLES",
                        new ItemStack(
                                ModBlocks.CANDLE,
                                1
                        )
                )
        );
        ScanningManager.addScannableThing(
                new ScanBlockState(
                        "f_RT_CANDLES",
                        ModBlocks.CANDLE.getStateFromMeta(0),
                        false
                )
        );
        ScanningManager.addScannableThing(
                new ScanBlockState(
                        "f_RT_CANDLES",
                        ModBlocks.CANDLE.getStateFromMeta(1),
                        false
                )
        );
        ScanningManager.addScannableThing(
                new ScanBlockState(
                        "f_RT_CANDLES",
                        ModBlocks.CANDLE.getStateFromMeta(2),
                        false
                )
        );
        ScanningManager.addScannableThing(
                new ScanBlockState(
                        "f_RT_CANDLES",
                        ModBlocks.CANDLE.getStateFromMeta(3),
                        false
                )
        );
        ScanningManager.addScannableThing(
                new ScanBlockState(
                        "f_RT_CANDLES",
                        ModBlocks.CANDLE.getStateFromMeta(4),
                        false
                )
        );
    }
    
}
