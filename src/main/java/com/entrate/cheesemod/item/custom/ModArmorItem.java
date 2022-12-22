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
                            new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 7)).build();
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP_2 =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(ModArmourMaterials.NETHERITE_LEGENDARY_CHEESE,
                            new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2)).build();
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP_1 =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(ModArmourMaterials.NETHERITE_LEGENDARY_CHEESE,
                            new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1)).build();
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP_0 =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(ModArmourMaterials.NETHERITE_LEGENDARY_CHEESE,
                            new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0)).build();
    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties settings) {
        super(material, slot, settings);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if(!world.isClientSide()) {
            if(hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            } else if (has3OutOf4SuitOfArmorOn(player)) {

            } else if (has2OutOf4SuitOfArmorOn(player)) {

            } else if (has1OutOf4SuitOfArmorOn(player)) {

            }
        }
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffectInstance mapStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            } else if (hasCorrectArmorOn3(mapArmorMaterial, player)) {
                addStatusEffectForMaterial2(player, mapArmorMaterial, mapStatusEffect);
            } else if (hasCorrectArmorOn2(mapArmorMaterial, player)) {
                addStatusEffectForMaterial3(player, mapArmorMaterial, mapStatusEffect);
            } else if (hasCorrectArmorOn1(mapArmorMaterial, player)) {
                addStatusEffectForMaterial4(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial mapArmorMaterial,
                                            MobEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect.getEffect());

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addEffect(new MobEffectInstance(mapStatusEffect.getEffect(),
                    mapStatusEffect.getDuration(), mapStatusEffect.getAmplifier()));
        }
    }
    private void addStatusEffectForMaterial2(Player player, ArmorMaterial mapArmorMaterial,
                                            MobEffectInstance mapStatusEffect2) {
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect2.getEffect());

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addEffect(new MobEffectInstance(mapStatusEffect2.getEffect(),
                    mapStatusEffect2.getDuration(), mapStatusEffect2.getAmplifier()));
        }
    }
    private void addStatusEffectForMaterial3(Player player, ArmorMaterial mapArmorMaterial,
                                            MobEffectInstance mapStatusEffect1) {
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect1.getEffect());

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addEffect(new MobEffectInstance(mapStatusEffect1.getEffect(),
                    mapStatusEffect1.getDuration(), mapStatusEffect1.getAmplifier()));
        }
    }
    private void addStatusEffectForMaterial4(Player player, ArmorMaterial mapArmorMaterial,
                                            MobEffectInstance mapStatusEffect0) {
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect0.getEffect());

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addEffect(new MobEffectInstance(mapStatusEffect0.getEffect(),
                    mapStatusEffect0.getDuration(), mapStatusEffect0.getAmplifier()));
        }
    }
    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }
    private boolean has3OutOf4SuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }
    private boolean has2OutOf4SuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !boots.isEmpty();
    }
    private boolean has1OutOf4SuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);


        return !boots.isEmpty();
    }


    private boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {
        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());
        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;

    }
    private boolean hasCorrectArmorOn3(ArmorMaterial material, Player player) {
        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());
        return helmet.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;

    }
    private boolean hasCorrectArmorOn2(ArmorMaterial material, Player player) {
        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == material && boots.getMaterial() == material;

    }
    private boolean hasCorrectArmorOn1(ArmorMaterial material, Player player) {
        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());


        return boots.getMaterial() == material;

    }
}
