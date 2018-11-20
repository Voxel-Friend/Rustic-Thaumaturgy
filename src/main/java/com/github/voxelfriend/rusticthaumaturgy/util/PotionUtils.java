package com.github.voxelfriend.rusticthaumaturgy.util;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public final class PotionUtils {

    private PotionUtils () {

        throw new IllegalAccessError("Utility class");
    }

    public static boolean isBeneficial (Potion potion) {

        return potion.beneficial;
    }

    public static void deincrementDuration (PotionEffect potionEffect) {

        potionEffect.deincrementDuration();
    }
}