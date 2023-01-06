package com.entrate.cheesemod.sound;

import com.entrate.cheesemod.CheeseMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModSounds  {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CheeseMod.MOD_ID);

    public static final RegistryObject<SoundEvent> BOSS_SOUND_TRACK =
            registerSoundEvents("boss_sound_track");
    public static final RegistryObject<SoundEvent> VINE_BOOM =
            registerSoundEvents("vine_boom");



    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(CheeseMod.MOD_ID, name)));
    }
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}

