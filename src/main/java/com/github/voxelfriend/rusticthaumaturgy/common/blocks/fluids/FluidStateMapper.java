package com.github.voxelfriend.rusticthaumaturgy.common.blocks.fluids;

import com.github.voxelfriend.rusticthaumaturgy.core.RusticThaumaturgy;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidStateMapper extends StateMapperBase implements ItemMeshDefinition {
	
	private final Fluid fluid;
	
	public FluidStateMapper(Fluid fluid) {
		this.fluid = fluid;
	}

	@Override
	protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
		return new ModelResourceLocation(new ResourceLocation(RusticThaumaturgy.MODID, "block_fluid"), fluid.getName());
	}

	@Override
	public ModelResourceLocation getModelLocation(ItemStack stack) {
		return new ModelResourceLocation(new ResourceLocation(RusticThaumaturgy.MODID, "block_fluid"), fluid.getName());
	}

}