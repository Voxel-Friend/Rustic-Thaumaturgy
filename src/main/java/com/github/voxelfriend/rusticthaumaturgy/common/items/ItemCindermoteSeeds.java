package com.github.voxelfriend.rusticthaumaturgy.common.items;


import com.github.voxelfriend.rusticthaumaturgy.common.blocks.ModBlocksRT;
import com.github.voxelfriend.rusticthaumaturgy.reference.Names;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class ItemCindermoteSeeds extends ItemSeeds {

    public ItemCindermoteSeeds() {
        super(ModBlocksRT.CINDERMOTE, Blocks.FARMLAND);
        this.setUnlocalizedName(Names.Items.CINDERMOTE_SEEDS);
        this.setRegistryName(Names.Items.CINDERMOTE_SEEDS);
    }
}