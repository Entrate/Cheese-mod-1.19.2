package com.entrate.cheesemod.entity.client.model;

import com.entrate.cheesemod.CheeseMod;
import com.entrate.cheesemod.entity.cutom.RatKingBossEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RatBossModel extends AnimatedGeoModel<RatKingBossEntity> {
    @Override
    public ResourceLocation getModelResource(RatKingBossEntity object) {
        return new ResourceLocation(CheeseMod.MOD_ID, "geo/rat_boss.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RatKingBossEntity object) {
        return new ResourceLocation(CheeseMod.MOD_ID, "textures/entity/rat_boss_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RatKingBossEntity animatable) {
        return new ResourceLocation(CheeseMod.MOD_ID, "animations/rat_boss.animation.json");
    }
}

