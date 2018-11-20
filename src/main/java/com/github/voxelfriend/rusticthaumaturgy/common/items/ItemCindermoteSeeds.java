package com.github.voxelfriend.rusticthaumaturgy.common.items;


import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;




import java.util.List;

import javax.annotation.Nullable;

import com.github.voxelfriend.rusticthaumaturgy.common.blocks.ModBlocksRT;
import com.github.voxelfriend.rusticthaumaturgy.reference.Names;

public class ItemCindermoteSeeds extends ItemSeeds {

    public ItemCindermoteSeeds() {
        super(ModBlocksRT.CINDERMOTE, Blocks.FARMLAND);
        this.setUnlocalizedName(Names.Items.CINDERMOTE_SEEDS);
        this.setRegistryName(Names.Items.CINDERMOTE_SEEDS);
    }
}