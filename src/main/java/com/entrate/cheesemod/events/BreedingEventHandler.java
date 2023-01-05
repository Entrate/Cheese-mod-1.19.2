package com.entrate.cheesemod.events;

import com.entrate.cheesemod.CheeseMod;
import com.entrate.cheesemod.entity.ModEntityTypes;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.animal.Cow;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CheeseMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BreedingEventHandler {
    @SubscribeEvent
    public static void BabyEntitySpawnEvent(BabyEntitySpawnEvent event) {
        int randomizer = (int) Math.round(Math.random() * 100);
        AgeableMob parentA = (AgeableMob) event.getParentA();
        ServerLevel world = (ServerLevel) parentA.getLevel();
        if(parentA instanceof Cow && randomizer == 1){
            AgeableMob ProposedMob = ModEntityTypes.LEGENDARY_COW.get().create(world);
            event.setChild(ProposedMob);
        }
    }
}
