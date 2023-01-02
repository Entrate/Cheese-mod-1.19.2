package com.entrate.cheesemod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantment;

public class CheeseSwordItem extends SwordItem {
    public CheeseSwordItem(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity livingEntity, LivingEntity entity) {
        livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 5), entity);
        return super.hurtEnemy(itemStack, livingEntity, entity);
    }
}




