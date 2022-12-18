package com.entrate.cheesemod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CheeseItem extends Item {

    public CheeseItem(Properties properties) {
        super(properties);
    }
    String lastDamageSource = "nothing";
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
        outputRansdomNumber(player);
        outputlastdamageSource(player);
        }

        return super.use(level, player, hand);
    }
    private void outputRansdomNumber(Player player) {
        player.sendSystemMessage(Component.literal("Ball: " + getRandomNumber()));
    }
    private void outputlastdamageSource(Player player) {
        player.sendSystemMessage(Component.literal(String.valueOf(player.getLastDamageSource())));
    }

    private int getRandomNumber() {
        return RandomSource.createNewThreadLocalInstance().nextInt(10);
    }
}



