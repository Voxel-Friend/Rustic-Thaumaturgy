//Hello World

package com.github.voxelfriend.rusticthaumaturgy.core;

import org.apache.logging.log4j.Logger;

import com.github.voxelfriend.rusticthaumaturgy.crafting.Recipes;
import com.github.voxelfriend.rusticthaumaturgy.common.blocks.ModBlocksRT;
import com.github.voxelfriend.rusticthaumaturgy.common.blocks.fluids.ModFluidsRT;
import com.github.voxelfriend.rusticthaumaturgy.common.items.ModItemsRT;
import com.github.voxelfriend.rusticthaumaturgy.core.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = RusticThaumaturgy.MODID, name = RusticThaumaturgy.NAME, version = RusticThaumaturgy.VERSION, dependencies = "required-after:rustic;required-after:thaumcraft")
public class RusticThaumaturgy {
	public static final String MODID = "rusticthaumaturgy";
	public static final String NAME = "Rustic Thaumaturgy";
	public static final String VERSION = "1.0";

	@SidedProxy(clientSide = "com.github.voxelfriend.rusticthaumaturgy.core.ClientProxy", serverSide = "com.github.voxelfriend.rusticthaumaturgy.core.CommonProxy")
	public static CommonProxy proxy;
	
	public static CreativeTabs mainTab = new CreativeTabs("rusticthaumaturgy.main") {
		@Override
		public String getTabLabel() {
			return "rusticthaumaturgy.main";
		}

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ModBlocksRT.CHAIR_GREATWOOD);
		}
    };

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

}