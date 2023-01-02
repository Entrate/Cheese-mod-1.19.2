package com.entrate.cheesemod.villager;


import com.entrate.cheesemod.CheeseMod;
import com.entrate.cheesemod.block.ModBlocks;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;




public class ModPOIs {
    public static final DeferredRegister<PoiType> POI
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, CheeseMod.MOD_ID);

    public static final RegistryObject<PoiType> CHEESE_PORTAL =
            POI.register("cheese_portal", () -> new PoiType
                    (getBlockStates(ModBlocks.CHEESE_PORTAL.get()), 0, 1));

    private static Set<BlockState> getBlockStates(Block block) {
        return ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates());

    }
    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}