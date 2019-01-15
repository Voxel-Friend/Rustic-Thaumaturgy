package com.github.voxelfriend.rusticthaumaturgy.common.items;


import com.github.voxelfriend.rusticthaumaturgy.common.blocks.ModBlocksRT;
import com.github.voxelfriend.rusticthaumaturgy.reference.Names;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class ItemViscapSpores extends ItemSeeds {

    public ItemViscapSpores() {
        super(ModBlocksRT.VISCAP, Blocks.FARMLAND);
        this.setUnlocalizedName(Names.Items.VISCAP_SPORES);
        this.setRegistryName(Names.Items.VISCAP_SPORES);
    }
}