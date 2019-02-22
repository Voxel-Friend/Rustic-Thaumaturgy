/**
 * 
 */
package com.github.voxelfriend.rusticthaumaturgy.crafting;

import com.github.voxelfriend.rusticthaumaturgy.common.blocks.ModBlocksRT;
import com.github.voxelfriend.rusticthaumaturgy.core.CommonProxy;
import com.github.voxelfriend.rusticthaumaturgy.core.RusticThaumaturgy;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.IArcaneWorkbench;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.items.ItemGenericEssentiaContainer;
import thaumcraft.api.items.ItemsTC;

/**
 * @author Wind_Blade
 *
 */
public class SconceRecipe extends ShapedArcaneRecipe{

	public Aspect aspect = Aspect.AIR;
	
	public SconceRecipe() 
	{
		super(new ResourceLocation(RusticThaumaturgy.MODID, "candle"), "RT_SCONCES", 20, new AspectList().add(Aspect.FIRE,1).add(Aspect.AIR, 1), new ItemStack(ModBlocksRT.SCONCES.get(Aspect.AIR)), "t", "i",
                //Recipe Ingredients
                't',ThaumcraftApiHelper.makeCrystal(Aspect.AIR),
'i',new ItemStack(Items.IRON_INGOT));
	}

	
	
	@Override
    public boolean matches(InventoryCrafting inv, World world) {
        if(!(inv instanceof IArcaneWorkbench))return false;

        for(int i = 0; i < 9; i++) {
            if(inv.getStackInSlot(i).getItem() == ItemsTC.crystalEssence && inv.getStackInSlot(i+3).getItem() == Items.IRON_INGOT) {
                Aspect aspect2 = ((ItemGenericEssentiaContainer)ItemsTC.crystalEssence).getAspects(inv.getStackInSlot(i)).getAspects()[0];
                if(CommonProxy.VANILLA_ASPECTS.contains(aspect2)){
                       this.aspect = aspect2;
                       return true;
                }
            }
        }
        return false;
    }

	@Override
	public ItemStack getCraftingResult(InventoryCrafting var1) {
		return new ItemStack(ModBlocksRT.SCONCES.get(aspect), 3);
	}

	@Override
	public ItemStack getRecipeOutput() {
		return new ItemStack(ModBlocksRT.SCONCES.get(aspect), 3);
	}
}