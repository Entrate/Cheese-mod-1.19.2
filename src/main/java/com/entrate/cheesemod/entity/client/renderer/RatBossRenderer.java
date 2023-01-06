package com.entrate.cheesemod.entity.client.renderer;

import com.entrate.cheesemod.CheeseMod;
import com.entrate.cheesemod.entity.client.model.RatBossModel;
import com.entrate.cheesemod.entity.cutom.RatKingBossEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RatBossRenderer extends GeoEntityRenderer<RatKingBossEntity> {


    public RatBossRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RatBossModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(RatKingBossEntity instance) {
        return new ResourceLocation(CheeseMod.MOD_ID, "textures/entity/rat_boss_texture.png");
    }

    @Override
    public RenderType getRenderType(RatKingBossEntity animatable, float partialTick, PoseStack poseStack,
                                    @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {
        poseStack.scale(2f,2f,2f);
        return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
    }
}
