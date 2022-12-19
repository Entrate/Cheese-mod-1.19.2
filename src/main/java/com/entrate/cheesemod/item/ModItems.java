package com.entrate.cheesemod.item;

import com.entrate.cheesemod.CheeseMod;
import com.entrate.cheesemod.item.custom.CheeseItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public  static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CheeseMod.MOD_ID);

    public static final RegistryObject<Item> OLDCHEESE = ITEMS.register("oldcheese",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.CHEESE)));

    public static final RegistryObject<Item> MYSTICAL_CHEESE = ITEMS.register("mystical_cheese",
            () -> new CheeseItem(new Item.Properties().tab(ModCreativeModeTab.CHEESE_TAB).stacksTo(1)));

    public static final RegistryObject<Item> LEGENDARY_CHEESE = ITEMS.register("legendary_cheese",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<Item> LEGENDARY_MILK_BUCKET = ITEMS.register("legendary_milk_bucket",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS).stacksTo(1)));

    public static final RegistryObject<Item> GODLY_CHEESE = ITEMS.register("godly_cheese",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<Item> LEGENDARY_CHEESE_SWORD_BROKEN = ITEMS.register("legendary_cheese_sword_broken",
            () -> new SwordItem(ModTiers.LEGENDARY_CHEESE, 2, 2f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));




    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
