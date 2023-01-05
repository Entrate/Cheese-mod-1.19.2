package com.entrate.cheesemod.events;

import com.entrate.cheesemod.CheeseMod;
import com.entrate.cheesemod.entity.ModEntityTypes;
import com.entrate.cheesemod.entity.cutom.LegendaryCowEntity;
import com.entrate.cheesemod.item.ModItems;
import com.entrate.cheesemod.item.custom.BurningCheeseSwordItem;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;



@Mod.EventBusSubscriber(modid = CheeseMod.MOD_ID)
public class ModEvents {
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
    public static class ForgeEvents {



        }

        @Mod.EventBusSubscriber(modid = CheeseMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
        public static class ModEventBusEvents {
            @SubscribeEvent
            public static void entityAtributeEvent(EntityAttributeCreationEvent event) {
                event.put(ModEntityTypes.LEGENDARY_COW.get(), LegendaryCowEntity.setcreateAttributes());
            }
        }
    }
