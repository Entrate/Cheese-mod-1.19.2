package com.entrate.cheesemod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CHEESE = (new FoodProperties.Builder()).fast().nutrition(2).saturationMod(0.3F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0), 1F).build();

    public static final FoodProperties CHEESE_STEAK = (new FoodProperties.Builder()).fast().nutrition(15).saturationMod(1.5F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 600, 0), 1F).build();

}
