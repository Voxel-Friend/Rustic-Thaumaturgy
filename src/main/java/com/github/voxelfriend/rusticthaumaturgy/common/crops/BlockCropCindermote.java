package com.github.voxelfriend.rusticthaumaturgy.common.crops;

import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.voxelfriend.rusticthaumaturgy.common.blocks.ModBlocksRT;
import com.github.voxelfriend.rusticthaumaturgy.common.items.ModItemsRT;
import com.github.voxelfriend.rusticthaumaturgy.configuration.RTConfiguration;
import com.github.voxelfriend.rusticthaumaturgy.reference.Names;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCropCindermote extends BlockCrops {

    public BlockCropCindermote() {
        super();
        this.setUnlocalizedName(Names.Blocks.CINDERMOTE);
        this.setRegistryName(Names.Blocks.CINDERMOTE);

        ModBlocksRT.BLOCKS.add(this);
    }

    @Override
    @Nonnull
    protected Item getSeed() {
        return ModItemsRT.CINDERMOTE_SEEDS;
    }

    @Override
    @Nonnull
    protected Item getCrop() {
        return ModItemsRT.CINDERMOTE;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return RTConfiguration.canBonemealRTCrops;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, @Nullable IBlockState state, @Nullable Random rand) {
        if (state == null || rand == null)
            return;

        float baseChance = 25.0F;
            baseChance /= RTConfiguration.growthMultiplier;

        if (worldIn.getLightFromNeighbors(pos.up()) >= 9) {
            if (state.getValue(AGE) < 7) {
                if (rand.nextInt((int) (baseChance / getGrowthChance(this, worldIn, pos)) + 1) == 0) {
                    worldIn.setBlockState(pos, state.withProperty(AGE, state.getValue(AGE) + 1), 2);
                }
            }
        }
    }

    @Override
    public void getDrops(@Nonnull NonNullList<ItemStack> drops, @Nullable IBlockAccess world, @Nullable BlockPos pos, @Nonnull IBlockState state, int fortune) {
        final int age = state.getValue(AGE);
        final Random rand = world == null ? new Random() : ((World) world).rand;

        int crops = 0;
        int seeds = 0;

        // Seed chance
        if (rand.nextInt(100) < RTConfiguration.seedChance) {
            seeds++;
        }

        if (age == 7) {
            // Second seed chance
            if (rand.nextInt(100) < RTConfiguration.secondSeedChance) {
                seeds++;
            }

            // Crop chance
            if (rand.nextInt(100) < RTConfiguration.cropChance) {
            	crops++;
            }

            // Second crop chance
            if (rand.nextInt(100) < RTConfiguration.cropChance) {
            	crops++;
            }
        }

        drops.add(new ItemStack(this.getSeed(), seeds, 0));
        drops.add(new ItemStack(this.getCrop(), crops, 0));
    }

}
