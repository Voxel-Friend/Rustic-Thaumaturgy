package com.github.voxelfriend.rusticthaumaturgy.common.items;


import com.github.voxelfriend.rusticthaumaturgy.common.blocks.ModBlocksRT;
import com.github.voxelfriend.rusticthaumaturgy.reference.Names;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class ItemShimmerpetalBulb extends ItemSeeds {

    public ItemShimmerpetalBulb() {
        super(ModBlocksRT.SHIMMERPETAL, Blocks.FARMLAND);
        this.setUnlocalizedName(Names.Items.SHIMMERPETAL_BULB);
        this.setRegistryName(Names.Items.SHIMMERPETAL_BULB);
    }
}