package com.entrate.cheesemod.events;

import com.entrate.cheesemod.CheeseMod;
import com.entrate.cheesemod.entity.ModEntityTypes;
import com.entrate.cheesemod.entity.cutom.LegendaryCowEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.random.RandomGenerator;

@Mod.EventBusSubscriber(modid = CheeseMod.MOD_ID)
public class ModEvents {
    public static class ForgeEvents {

        @SubscribeEvent
        public static void BabyEntitySpawnEvent (BabyEntitySpawnEvent event) {
            int randomizer = (int) Math.round(Math.random());

            if(event.getChild() instanceof Cow) {

            }

        }

    }
    @Mod.EventBusSubscriber(modid = CheeseMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {

        @SubscribeEvent
        public static void entityAtributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.LEGENDARY_COW.get(), LegendaryCowEntity.setcreateAttributes());
        }
    }
}
