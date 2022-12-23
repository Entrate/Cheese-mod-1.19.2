package com.entrate.cheesemod.entity;

import com.entrate.cheesemod.CheeseMod;
import com.entrate.cheesemod.entity.cutom.LegendaryCowEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    private static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CheeseMod.MOD_ID);

    public static final RegistryObject<EntityType<LegendaryCowEntity>> LEGENDARY_COW =
            ENTITY_TYPES.register("legendary_cow",
                    () -> EntityType.Builder.of(LegendaryCowEntity::new, MobCategory.CREATURE).sized(0.9F, 1.4F)
                            .build(new ResourceLocation(CheeseMod.MOD_ID, "legendary_cow").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
