package com.github.voxelfriend.rusticthaumaturgy.common.items;

import com.github.voxelfriend.rusticthaumaturgy.core.RusticThaumaturgy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItemsRT {
	public static ItemBase BLAZE_POWDER_TINY;
	public static ItemBase CINDERMOTE;
	public static ItemBase SHIMMERPETAL;
	public static ItemBase VISCAP;
	public static ItemSeeds CINDERMOTE_SEEDS = new ItemCindermoteSeeds();
	public static ItemSeeds SHIMMERPETAL_BULB = new ItemShimmerpetalBulb();
	public static ItemSeeds VISCAP_SPORES = new ItemViscapSpores();

	
	
	public static void init() {
		BLAZE_POWDER_TINY = new ItemBase("dust_tiny_blaze");
		BLAZE_POWDER_TINY.setCreativeTab(RusticThaumaturgy.mainTab);
		CINDERMOTE = new ItemBase("cindermote");
		CINDERMOTE.setCreativeTab(RusticThaumaturgy.mainTab);
		CINDERMOTE_SEEDS = new ItemCindermoteSeeds();
		CINDERMOTE_SEEDS.setCreativeTab(RusticThaumaturgy.mainTab);
		SHIMMERPETAL = new ItemBase("shimmerpetal");
		SHIMMERPETAL.setCreativeTab(RusticThaumaturgy.mainTab);
		SHIMMERPETAL_BULB =new ItemShimmerpetalBulb();
		SHIMMERPETAL_BULB.setCreativeTab(RusticThaumaturgy.mainTab);
		VISCAP = new ItemBase("viscap");
		VISCAP.setCreativeTab(RusticThaumaturgy.mainTab);
		VISCAP_SPORES =new ItemViscapSpores();
		VISCAP_SPORES.setCreativeTab(RusticThaumaturgy.mainTab);
		GameRegistry.findRegistry(Item.class).register(CINDERMOTE_SEEDS);
		GameRegistry.findRegistry(Item.class).register(SHIMMERPETAL_BULB);
		GameRegistry.findRegistry(Item.class).register(VISCAP_SPORES);
	}
	public static void onModelRegistry() {
	}
	
	public static void initModels() {
		BLAZE_POWDER_TINY.initModel();
		CINDERMOTE.initModel();
		SHIMMERPETAL.initModel();
		VISCAP.initModel();
		ModelLoader.setCustomModelResourceLocation(CINDERMOTE_SEEDS, 0, new ModelResourceLocation(CINDERMOTE_SEEDS.getRegistryName(),"inventory"));
		ModelLoader.setCustomModelResourceLocation(SHIMMERPETAL_BULB, 0, new ModelResourceLocation(SHIMMERPETAL_BULB.getRegistryName(),"inventory"));
		ModelLoader.setCustomModelResourceLocation(VISCAP_SPORES, 0, new ModelResourceLocation(VISCAP_SPORES.getRegistryName(),"inventory"));
		
	}


}