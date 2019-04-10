//Hello World

package com.github.voxelfriend.rusticthaumaturgy.core;

import com.github.voxelfriend.rusticthaumaturgy.common.blocks.ModBlocksRT;
import com.github.voxelfriend.rusticthaumaturgy.common.items.ModItemsRT;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
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
	public static final String VERSION = "4.4";

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
			return new ItemStack(ModItemsRT.VISCAP);
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