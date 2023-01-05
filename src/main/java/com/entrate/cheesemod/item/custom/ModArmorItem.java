package com.entrate.cheesemod.item.custom;

import com.entrate.cheesemod.item.ModArmourMaterials;
import com.google.common.collect.ImmutableMap;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(ModArmourMaterials.NETHERITE_LEGENDARY_CHEESE,
                            new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 4)).build();

    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties settings) {
        super(material, slot, settings);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if(!world.isClientSide()) {
            if(hasHelmetOn(player) || hasChestOn(player) || hasLeggingsOn(player) || hasBootsOn(player)) {
                evaluateArmorEffects(player);
            }
        }
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffectInstance mapStatusEffect = entry.getValue();

            if(hasCorrectHelmetOn(mapArmorMaterial, player) || hasCorrectChestOn(mapArmorMaterial, player) ||
                    hasCorrectLeggingsOn(mapArmorMaterial, player) || hasCorrectBootsOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial mapArmorMaterial,
                                            MobEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect.getEffect());

        if(hasCorrectHelmetOn(mapArmorMaterial, player) || hasCorrectChestOn(mapArmorMaterial, player) ||
                hasCorrectLeggingsOn(mapArmorMaterial, player) || hasCorrectBootsOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addEffect(new MobEffectInstance(mapStatusEffect.getEffect(),
                    mapStatusEffect.getDuration(), mapStatusEffect.getAmplifier()));
        }
    }

    private boolean hasHelmetOn(Player player) {

        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty();
    }
    private boolean hasChestOn(Player player) {
        ItemStack breastplate = player.getInventory().getArmor(2);

        return !breastplate.isEmpty();

    }
    private boolean hasLeggingsOn(Player player) {
        ItemStack leggings = player.getInventory().getArmor(1);

        return !leggings.isEmpty();
    }
    private boolean hasBootsOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);

        return !boots.isEmpty();
    }


    private boolean hasCorrectHelmetOn(ArmorMaterial material, Player player) {
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());
        return helmet.getMaterial() == material;

    }
    private boolean hasCorrectChestOn(ArmorMaterial material, Player player) {

        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());

        return breastplate.getMaterial() == material;


    }
    private boolean hasCorrectLeggingsOn(ArmorMaterial material, Player player) {
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());

        return leggings.getMaterial() == material;

    }
    private boolean hasCorrectBootsOn(ArmorMaterial material, Player player) {
        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());

        return boots.getMaterial() == material;

    }
}
