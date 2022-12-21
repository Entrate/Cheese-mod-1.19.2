package com.entrate.cheesemod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static  final ForgeTier LEGENDARY_CHEESE_BROKEN = new ForgeTier(1,900,2f,
            1f, 0, BlockTags.NEEDS_STONE_TOOL,
            () -> Ingredient.of(ModItems.CHEESE.get()));

    public static  final ForgeTier LEGENDARY_CHEESE = new ForgeTier(3,900,5f,
            9f, 0, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.LEGENDARY_CHEESE.get()));



}
