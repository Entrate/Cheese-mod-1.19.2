package com.entrate.cheesemod.events;

import com.entrate.cheesemod.CheeseMod;
import com.entrate.cheesemod.entity.ModEntityTypes;
import com.entrate.cheesemod.entity.cutom.LegendaryCowEntity;
import com.entrate.cheesemod.entity.cutom.RatKingBossEntity;
import com.entrate.cheesemod.item.ModItems;
import com.entrate.cheesemod.item.custom.BurningCheeseSwordItem;
import com.entrate.cheesemod.sound.ModSounds;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;




public class ModEvents {
    @Mod.EventBusSubscriber(modid = CheeseMod.MOD_ID)
    public static class ForgeEvents {
    @SubscribeEvent
    public static void setEntityOnFireWithBurningSword(LivingDamageEvent event) {
        if (!event.getEntity().level.isClientSide) {
            if (event.getSource().getDirectEntity() instanceof Player) {
                Player player = ((Player) event.getSource().getDirectEntity());
                if (player.getMainHandItem().getItem() == ModItems.LEGENDARY_CHEESE_SWORD_BURNING.get()) {
                    event.getEntity().setSecondsOnFire(5);
                }
            }
        }
    }
    @SubscribeEvent
    public static void setEntityOnFireWithGodlyBurningSword(LivingDamageEvent event) {
        if (!event.getEntity().level.isClientSide) {
            if (event.getSource().getDirectEntity() instanceof Player) {
                Player player = ((Player) event.getSource().getDirectEntity());
                if (player.getMainHandItem().getItem() == ModItems.GODLY_CHEESE_SWORD_BURNING.get()) {
                    event.getEntity().setSecondsOnFire(5);
                }
            }
        }
    }
    @SubscribeEvent
    public static void AddVineBoomToWoodenSword(LivingDamageEvent event) {
        if (!event.getEntity().level.isClientSide) {
            if (event.getSource().getDirectEntity() instanceof Player) {
                Player player = ((Player) event.getSource().getDirectEntity());
                if (player.getMainHandItem().getItem() == Items.WOODEN_SWORD) {
                    player.playSound(ModSounds.VINE_BOOM.get(), 3f, 1f);

                }
            }
        }
    }




        }

        @Mod.EventBusSubscriber(modid = CheeseMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
        public static class ModEventBusEvents {
            @SubscribeEvent
            public static void entityAtributeEvent(EntityAttributeCreationEvent event) {
                event.put(ModEntityTypes.LEGENDARY_COW.get(), LegendaryCowEntity.setcreateAttributes());
                event.put(ModEntityTypes.RAT_BOSS.get(), RatKingBossEntity.setAttributes());
            }

        }
    }
