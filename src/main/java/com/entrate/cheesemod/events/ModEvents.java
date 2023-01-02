package com.entrate.cheesemod.events;

import com.entrate.cheesemod.CheeseMod;
import com.entrate.cheesemod.entity.ModEntityTypes;
import com.entrate.cheesemod.entity.cutom.LegendaryCowEntity;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cow;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = CheeseMod.MOD_ID)
public class ModEvents {
    public static class ForgeEvents {

        @SubscribeEvent
        public static void BabyEntitySpawnEvent (BabyEntitySpawnEvent event, Mob parentA, Mob parentB, AgeableMob proposedChild) {
            int randomizer = (int) Math.round(Math.random());

            if(parentA instanceof Cow) {

                event.setChild(proposedChild);
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
