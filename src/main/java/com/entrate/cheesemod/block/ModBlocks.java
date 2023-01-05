package com.entrate.cheesemod.block;

import com.entrate.cheesemod.CheeseMod;
import com.entrate.cheesemod.block.custom.JumpyBlock;
import com.entrate.cheesemod.block.custom.KJPortalBlock;
import com.entrate.cheesemod.block.custom.NoJumpBlock;
import com.entrate.cheesemod.block.custom.ZirconLampBlock;
import com.entrate.cheesemod.item.ModCreativeModeTab;
import com.entrate.cheesemod.item.ModItems;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EnderChestBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, CheeseMod.MOD_ID);

    public static final  RegistryObject<Block> ZIRCON_BLOCK = registerBlock("zircon_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.GLASS).strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.CHEESE_TAB);

    public static final  RegistryObject<Block> CHEESE_BLOCK = registerBlock("cheese_block",
            () -> new JumpyBlock(BlockBehaviour.Properties.of(Material.WOOL).sound(SoundType.SAND).strength(0.7f)
                    ), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final  RegistryObject<Block> HARD_CHEESE_BLOCK = registerBlock("hard_cheese_block",
            () -> new NoJumpBlock(BlockBehaviour.Properties.of(Material.STONE).strength(-1f, 360_000_000))
                    , CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final  RegistryObject<Block> FAKE_HARD_CHEESE_BLOCK = registerBlock("fake_hard_cheese_block",
            () -> new NoJumpBlock(BlockBehaviour.Properties.of(Material.WOOL).strength(3f, 360_000_000))
            , CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final  RegistryObject<Block> ZIRCON_LAMP = registerBlock("zircon_lamp",
            () -> new ZirconLampBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.GLASS).strength(6f)
                    .requiresCorrectToolForDrops().lightLevel(state -> state.getValue(ZirconLampBlock.LIT) ? 15 : 0)), ModCreativeModeTab.CHEESE_TAB);

    public static final  RegistryObject<Block> CHEESE_PORTAL = registerBlockWithoutBlockItem("cheese_portal",
          KJPortalBlock::new);




    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
