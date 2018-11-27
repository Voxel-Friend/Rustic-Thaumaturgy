//Hello World

package com.github.voxelfriend.rusticthaumaturgy.core;

import com.github.voxelfriend.rusticthaumaturgy.common.blocks.ModBlocksRT;
import com.github.voxelfriend.rusticthaumaturgy.common.blocks.fluids.ModFluidsRT;
import com.github.voxelfriend.rusticthaumaturgy.common.items.ModItemsRT;
import com.github.voxelfriend.rusticthaumaturgy.configuration.RTConfiguration;
import com.github.voxelfriend.rusticthaumaturgy.crafting.Recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
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
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.golems.EnumGolemTrait;
import thaumcraft.api.golems.parts.GolemMaterial;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.api.research.*;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.items.ItemGenericEssentiaContainer;


public class CommonProxy {
	
	static ResourceLocation defaultGroup = new ResourceLocation("");
	 
	public static Configuration config;

	public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
		ModFluidsRT.init();
        ModBlocksRT.init();
        ModItemsRT.init();
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
    protected void initResearch() {    	
    	ResearchCategory rusticthaumaturgy = ResearchCategories.getResearchCategory("RUSTIC_THAUMATURGY"); {
    	
    }
	if (RTConfiguration.enableEssentiaCandles) {
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_aer"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_AER),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.AIR),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_terra"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_TERRA),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.EARTH),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_ignis"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_IGNIS),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.FIRE),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_aqua"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_AQUA),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.WATER),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_ordo"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_ORDO),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.ORDER),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_perditio"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_PERDITIO),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.ENTROPY),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_vacuos"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_VACUOS),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.VOID),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_auram"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_AURAM),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.AURA),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_vitium"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_VITIUM),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.FLUX),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_lux"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_LUX),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.LIGHT),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_potentia"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_POTENTIA),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.ENERGY),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_motus"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_MOTUS),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.MOTION),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_victus"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_VICTUS),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.LIFE),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_mortuus"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_MORTUUS),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.DEATH),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_volatus"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_VOLATUS),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.FLIGHT),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_tenebrae"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_TENEBRAE),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.DARKNESS),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_herba"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_HERBA),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.PLANT),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_spiritus"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_SPIRITUS),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.SOUL),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_humanus"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_HUMANUS),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.MAN),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_bestia"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_BESTIA),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.BEAST),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_exanimis"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_EXANIMIS),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.UNDEAD),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_cognitio"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_COGNITIO),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.MIND),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_sensus"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_SENSUS),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.SENSES),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_metallum"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_METALLUM),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.METAL),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_instrumentum"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_INSTRUMENTUM),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.TOOL),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_aversio"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_AVERSIO),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.AVERSION),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_gelum"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_GELUM),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.COLD),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_vitreus"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_VITREUS),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.CRYSTAL),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_alienis"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_ALIENIS),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.ELDRITCH),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_preamunio"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_PRAEMUNIO),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.PROTECT),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_fabrico"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_FABRICO),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.CRAFT),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_desiderium"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_DESIDERIUM),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.DESIRE),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_machina"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_MACHINA),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.MECHANISM),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_vinculum"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_VINCULUM),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.TRAP),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_permutatio"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_PERMUTATIO),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.EXCHANGE),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_praecantatio"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_PRAECANTATIO),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.MAGIC),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("rusticthaumaturgy:candle_alkimia"),
				
				new ShapedArcaneRecipe(
				//Group
			    defaultGroup,
			    "RT_CANDLES",
				//Vis Cost
				20,
				//Essentia Crystal Cost
				new AspectList()
               .add(Aspect.FIRE,1)
                .add(Aspect.AIR, 1),
               //Result
                new ItemStack(ModBlocksRT.CANDLE_ALKIMIA),
                //Recipe Shape
                "t", "i",
                        //Recipe Ingredients
                        't',ThaumcraftApiHelper.makeCrystal(Aspect.ALCHEMY),
                        'i',new ItemStack(Items.IRON_INGOT)
                        )
		);
		
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
    }
    
}
