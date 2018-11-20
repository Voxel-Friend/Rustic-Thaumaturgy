package com.github.voxelfriend.rusticthaumaturgy.common.items;


import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;




import java.util.List;

import javax.annotation.Nullable;

import com.github.voxelfriend.rusticthaumaturgy.common.blocks.ModBlocksRT;
import com.github.voxelfriend.rusticthaumaturgy.reference.Names;

public class ItemShimmerpetalBulb extends ItemSeeds {

    public ItemShimmerpetalBulb() {
        super(ModBlocksRT.SHIMMERPETAL, Blocks.FARMLAND);
        this.setUnlocalizedName(Names.Items.SHIMMERPETAL_BULB);
        this.setRegistryName(Names.Items.SHIMMERPETAL_BULB);
    }
}