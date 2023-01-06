package com.entrate.cheesemod;

import com.entrate.cheesemod.block.ModBlocks;
import com.entrate.cheesemod.entity.ModEntityTypes;
import com.entrate.cheesemod.entity.client.renderer.LegendaryCowRenderer;
import com.entrate.cheesemod.entity.client.renderer.RatBossRenderer;
import com.entrate.cheesemod.events.ModEvents;
import com.entrate.cheesemod.item.ModItems;
import com.entrate.cheesemod.sound.ModSounds;
import com.entrate.cheesemod.villager.ModPOIs;
import com.entrate.cheesemod.villager.ModVillagers;
import com.entrate.cheesemod.world.dimension.ModDimensions;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CheeseMod.MOD_ID)
public class CheeseMod {
    public static final String MOD_ID = "cheesemod";
    private static final Logger LOGGER = LogUtils.getLogger();
    public CheeseMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModDimensions.register();
        ModEntityTypes.register(modEventBus);

        ModSounds.register(modEventBus);


        ModVillagers.register(modEventBus);
        ModPOIs.register(modEventBus);




        GeckoLib.initialize();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            EntityRenderers.register(ModEntityTypes.LEGENDARY_COW.get(), LegendaryCowRenderer::new);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHEESE_PORTAL.get(), RenderType.translucent());
            // I think setRenderLayer is set for removal
            EntityRenderers.register(ModEntityTypes.RAT_BOSS.get(), RatBossRenderer::new);

        }
    }
}
