package com.github.voxelfriend.rusticthaumaturgy.common.items;

import com.github.voxelfriend.rusticthaumaturgy.core.RusticThaumaturgy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rustic.core.Rustic;

public class ItemBase extends Item {
	
	public ItemBase(String name){
		super();
		setRegistryName(name);
		setUnlocalizedName(RusticThaumaturgy.MODID + "." + name);
		setCreativeTab(RusticThaumaturgy.mainTab);
		GameRegistry.findRegistry(Item.class).register(this);
	}
	
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName().toString()));
	}

}