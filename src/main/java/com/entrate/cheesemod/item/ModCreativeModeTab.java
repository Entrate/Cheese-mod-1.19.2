package com.entrate.cheesemod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab CHEESE_TAB = new CreativeModeTab("cheesetab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CHEESE.get());
        }
    };

}
