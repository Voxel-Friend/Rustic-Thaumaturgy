package com.github.voxelfriend.rusticthaumaturgy.common.blocks;


import com.github.voxelfriend.rusticthaumaturgy.core.RusticThaumaturgy;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockBase extends Block {

	public BlockBase(Material mat, String name) {
		super(mat);
		setRegistryName(name);
		setUnlocalizedName(RusticThaumaturgy.MODID + "." + name);
		register();
		setHardness(1F);
		setCreativeTab(RusticThaumaturgy.mainTab);
	}
	
	public BlockBase(Material mat, String name, boolean register) {
		super(mat);
		setRegistryName(name);
		setUnlocalizedName(RusticThaumaturgy.MODID + "." + name);
		setHardness(1F);
		setCreativeTab(RusticThaumaturgy.mainTab);
		if (register) {
			register();
		}
	}
	
	public void register(Item item) {
		GameRegistry.findRegistry(Block.class).register(this);
		GameRegistry.findRegistry(Item.class).register(item);
	}
	
	public void register() {
		register(new ItemBlock(this).setRegistryName(getRegistryName()));
	}
	
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName().toString(),"inventory"));
	}
	
	public BlockBase setBlockSoundType(SoundType soundType) {
		setSoundType(soundType);
		return this;
	}
	
}