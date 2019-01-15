package com.github.voxelfriend.rusticthaumaturgy.core;

import com.github.voxelfriend.rusticthaumaturgy.common.items.ModItemsRT;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import rustic.common.blocks.ModBlocks;
import rustic.common.blocks.crops.Herbs;
import rustic.common.items.ModItems;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectEventProxy;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.aspects.AspectRegistryEvent;

@Mod.EventBusSubscriber(modid = RusticThaumaturgy.MODID)
public class AspectRegistrar {
	
	@SubscribeEvent(priority = EventPriority.LOW)
	public static void registerAspects(AspectRegistryEvent event) {
		AspectEventProxy registry = event.register;
		
		// decoration
		registry.registerObjectTag(new ItemStack(ModBlocks.SLATE), new AspectList().add(Aspect.EARTH, 5));
		registry.registerObjectTag(new ItemStack(ModBlocks.SLATE_ROOF), new AspectList().add(Aspect.EARTH, 3));
		registry.registerObjectTag(new ItemStack(ModBlocks.SLATE_BRICK), new AspectList().add(Aspect.EARTH, 3));
		registry.registerObjectTag(new ItemStack(ModBlocks.SLATE_TILE), new AspectList().add(Aspect.EARTH, 3));
		registry.registerObjectTag(new ItemStack(ModBlocks.SLATE_CHISELED), new AspectList().add(Aspect.EARTH, 3).add(Aspect.ORDER, 1));
		registry.registerComplexObjectTag(new ItemStack(ModBlocks.CHAIN), new AspectList().add(Aspect.MOTION, 1));
		registry.registerComplexObjectTag(new ItemStack(ModBlocks.CANDLE), new AspectList().add(Aspect.LIGHT, 5));
		registry.registerComplexObjectTag(new ItemStack(ModBlocks.CLAY_WALL_CROSS), new AspectList().add(Aspect.EARTH, 1).add(Aspect.WATER, 1));
		registry.registerComplexObjectTag(new ItemStack(ModBlocks.CLAY_WALL_DIAG), new AspectList().add(Aspect.EARTH, 1).add(Aspect.WATER, 1));
		registry.registerComplexObjectTag(new ItemStack(ModBlocks.IRON_LANTERN), new AspectList().add(Aspect.LIGHT, 5));
		registry.registerComplexObjectTag(new ItemStack(ModBlocks.GARGOYLE), new AspectList().add(Aspect.BEAST, 2).add(Aspect.WATER, 1));
		registry.registerObjectTag(new ItemStack(ModBlocks.CABINET), new AspectList().add(Aspect.PLANT, 20).add(Aspect.MOTION, 3));
		registry.registerObjectTag(new ItemStack(ModBlocks.PLANKS, 1, 1), new AspectList().add(Aspect.PLANT, 3).add(Aspect.METAL, 1));
		registry.registerComplexObjectTag(new ItemStack(ModBlocks.OLIVE_FENCE_GATE), new AspectList().add(Aspect.TRAP, 5).add(Aspect.MECHANISM, 5));
		registry.registerComplexObjectTag(new ItemStack(ModBlocks.IRONWOOD_FENCE_GATE), new AspectList().add(Aspect.TRAP, 5).add(Aspect.MECHANISM, 5));
		registry.registerComplexObjectTag(new ItemStack(ModBlocks.ROPE), new AspectList().add(Aspect.MOTION, 1));
		registry.registerComplexObjectTag(ModBlocks.DOOR_OLIVE.getItem(null, null, null), new AspectList().add(Aspect.TRAP, 5).add(Aspect.MECHANISM, 5));
		registry.registerComplexObjectTag(ModBlocks.DOOR_IRONWOOD.getItem(null, null, null), new AspectList().add(Aspect.TRAP, 5).add(Aspect.MECHANISM, 5));
		// agriculture
		registry.registerObjectTag(new ItemStack(ModBlocks.BEEHIVE), new AspectList().add(Aspect.BEAST, 3).add(Aspect.TRAP, 1).add(Aspect.PLANT, 1));
		registry.registerComplexObjectTag(new ItemStack(ModBlocks.APIARY), new AspectList().add(Aspect.TRAP, 10));
		registry.registerObjectTag(new ItemStack(ModBlocks.FERTILE_SOIL), new AspectList().add(Aspect.EARTH, 5).add(Aspect.WATER, 2).add(Aspect.LIFE, 1));
		registry.registerObjectTag(new ItemStack(ModBlocks.LOG, 1, 1), new AspectList().add(Aspect.PLANT, 20).add(Aspect.METAL, 2));
		registry.registerComplexObjectTag(new ItemStack(ModBlocks.CRUSHING_TUB), new AspectList().add(Aspect.CRAFT, 15));
		registry.registerComplexObjectTag(new ItemStack(ModBlocks.EVAPORATING_BASIN), new AspectList().add(Aspect.FIRE, 1).add(Aspect.AIR, 5));
		registry.registerObjectTag(new ItemStack(ModBlocks.WILDBERRY_BUSH), new AspectList().add(Aspect.PLANT, 5));
		registry.registerObjectTag(new ItemStack(ModBlocks.GRAPE_STEM), new AspectList().add(Aspect.PLANT, 5).add(Aspect.LIFE, 1));
		registry.registerComplexObjectTag(new ItemStack(ModBlocks.BREWING_BARREL), new AspectList().add(Aspect.EXCHANGE, 10).add(Aspect.ALCHEMY, 5));
		registry.registerObjectTag(new ItemStack(ModBlocks.APPLE_SEEDS), new AspectList().add(Aspect.PLANT, 5).add(Aspect.LIFE, 1));
		registry.registerObjectTag(new ItemStack(ModItems.BEE), new AspectList().add(Aspect.BEAST, 5).add(Aspect.FLIGHT, 5));
		registry.registerObjectTag(new ItemStack(ModItems.HONEYCOMB), new AspectList().add(Aspect.LIFE, 3).add(Aspect.ORDER, 2).add(Aspect.DESIRE, 1));
		registry.registerObjectTag(new ItemStack(ModItems.BEESWAX), new AspectList().add(Aspect.LIFE, 3).add(Aspect.CRAFT, 3).add(Aspect.FIRE, 1));
		registry.registerObjectTag(new ItemStack(ModItems.TALLOW), new AspectList().add(Aspect.MAN, 5).add(Aspect.LIFE, 5).add(Aspect.ENTROPY, 5).add(Aspect.FIRE, 1));
		registry.registerObjectTag(new ItemStack(ModItems.OLIVES), new AspectList().add(Aspect.PLANT, 5).add(Aspect.LIFE, 3));
		registry.registerObjectTag(new ItemStack(ModItems.IRONBERRIES), new AspectList().add(Aspect.PLANT, 5).add(Aspect.LIFE, 2).add(Aspect.METAL, 1));
		registry.registerObjectTag(new ItemStack(ModItems.FLUID_BOTTLE), new AspectList().add(Aspect.WATER, 5));
		registry.registerObjectTag(new ItemStack(ModItems.IRON_DUST_TINY), new AspectList().add(Aspect.METAL, 1));
		registry.registerObjectTag(new ItemStack(ModItems.TOMATO), new AspectList().add(Aspect.PLANT, 5).add(Aspect.LIFE, 5).add(Aspect.WATER, 5));
		registry.registerObjectTag(new ItemStack(ModItems.TOMATO_SEEDS), new AspectList().add(Aspect.PLANT, 5).add(Aspect.LIFE, 1));
		registry.registerObjectTag(new ItemStack(ModItems.CHILI_PEPPER), new AspectList().add(Aspect.PLANT, 5).add(Aspect.LIFE, 5).add(Aspect.FIRE, 5));
		registry.registerObjectTag(new ItemStack(ModItems.CHILI_PEPPER_SEEDS), new AspectList().add(Aspect.PLANT, 5).add(Aspect.LIFE, 1));
		registry.registerObjectTag(new ItemStack(ModItems.WILDBERRIES), new AspectList().add(Aspect.PLANT, 6).add(Aspect.LIFE, 3));
		registry.registerObjectTag(new ItemStack(ModItems.GRAPES), new AspectList().add(Aspect.PLANT, 5).add(Aspect.LIFE, 4).add(Aspect.EXCHANGE, 1));
		// alchemy
		registry.registerComplexObjectTag(new ItemStack(ModBlocks.CONDENSER), new AspectList().add(Aspect.ALCHEMY, 15).add(Aspect.FIRE, 6));
		registry.registerComplexObjectTag(new ItemStack(ModBlocks.RETORT), new AspectList().add(Aspect.ALCHEMY, 3));
		registry.registerComplexObjectTag(new ItemStack(ModBlocks.CONDENSER_ADVANCED), new AspectList().add(Aspect.ALCHEMY, 20).add(Aspect.FIRE, 4));
		registry.registerComplexObjectTag(new ItemStack(ModBlocks.RETORT_ADVANCED), new AspectList().add(Aspect.ALCHEMY, 3));
		registry.registerObjectTag(new ItemStack(Herbs.ALOE_VERA), new AspectList().add(Aspect.PLANT, 2).add(Aspect.WATER, 2));
		registry.registerObjectTag(new ItemStack(Herbs.BLOOD_ORCHID), new AspectList().add(Aspect.PLANT, 2).add(Aspect.LIFE, 2));
		registry.registerObjectTag(new ItemStack(Herbs.CHAMOMILE), new AspectList().add(Aspect.PLANT, 2).add(Aspect.LIFE, 2));
		registry.registerObjectTag(new ItemStack(Herbs.COHOSH), new AspectList().add(Aspect.PLANT, 2).add(Aspect.LIFE, 2));
		registry.registerObjectTag(new ItemStack(Herbs.DEATHSTALK), new AspectList().add(Aspect.PLANT, 2).add(Aspect.DEATH, 2));
		registry.registerObjectTag(new ItemStack(Herbs.HORSETAIL), new AspectList().add(Aspect.PLANT, 2).add(Aspect.ALCHEMY, 2));
		registry.registerObjectTag(new ItemStack(Herbs.MOONCAP), new AspectList().add(Aspect.PLANT, 2).add(Aspect.LIGHT, 2));
		registry.registerObjectTag(new ItemStack(Herbs.WIND_THISTLE), new AspectList().add(Aspect.PLANT, 2).add(Aspect.MOTION, 2));
		registry.registerObjectTag(new ItemStack(Herbs.CLOUDSBLUFF), new AspectList().add(Aspect.PLANT, 2).add(Aspect.FLIGHT, 2));
		registry.registerObjectTag(new ItemStack(Herbs.CORE_ROOT), new AspectList().add(Aspect.PLANT, 2).add(Aspect.EARTH, 2));
		registry.registerObjectTag(new ItemStack(Herbs.GINSENG), new AspectList().add(Aspect.PLANT, 2).add(Aspect.AVERSION, 2));
		registry.registerObjectTag(new ItemStack(Herbs.MARSH_MALLOW), new AspectList().add(Aspect.PLANT, 2).add(Aspect.ENERGY, 2));
		registry.registerObjectTag(new ItemStack(ModItems.ELIXIR), new AspectList().add(Aspect.ALCHEMY, 3).add(Aspect.WATER, 5));
		registry.registerObjectTag(new ItemStack(ModItemsRT.BLAZE_POWDER_TINY), new AspectList().add(Aspect.ALCHEMY, 1).add(Aspect.FIRE, 1));
		registry.registerObjectTag(new ItemStack(ModItemsRT.CINDERMOTE), new AspectList().add(Aspect.FIRE, 1).add(Aspect.PLANT, 2).add(Aspect.AURA, 2));
		registry.registerObjectTag(new ItemStack(ModItemsRT.SHIMMERPETAL), new AspectList().add(Aspect.AURA, 2).add(Aspect.PLANT, 2).add(Aspect.ENERGY, 2));
		registry.registerObjectTag(new ItemStack(ModItemsRT.VISCAP), new AspectList().add(Aspect.PLANT, 1).add(Aspect.DEATH, 1).add(Aspect.ENTROPY, 1));
		registry.registerObjectTag(new ItemStack(ModItemsRT.CINDERMOTE_SEEDS), new AspectList().add(Aspect.PLANT, 28).add(Aspect.LIFE, 16).add(Aspect.SENSES, 15).add(Aspect.FIRE, 12));
		registry.registerObjectTag(new ItemStack(ModItemsRT.SHIMMERPETAL_BULB), new AspectList().add(Aspect.PLANT, 28).add(Aspect.LIFE, 28).add(Aspect.SENSES, 15).add(Aspect.AURA, 12));
		registry.registerObjectTag(new ItemStack(ModItemsRT.VISCAP_SPORES), new AspectList().add(Aspect.PLANT, 26).add(Aspect.LIFE, 16).add(Aspect.SENSES, 15).add(Aspect.DARKNESS, 12));

	}
	
 }