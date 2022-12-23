package com.entrate.cheesemod.entity.client.renderer;

import com.entrate.cheesemod.CheeseMod;
import com.entrate.cheesemod.entity.cutom.LegendaryCowEntity;
import net.minecraft.client.model.CowModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Cow;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LegendaryCowRenderer extends MobRenderer<LegendaryCowEntity, CowModel<LegendaryCowEntity>> {
    private static final ResourceLocation LEGENDARY_COW_LOCATION = new ResourceLocation("textures/entity/cow/legendary_cow.png");

    public LegendaryCowRenderer(EntityRendererProvider.Context p_173956_) {
        super(p_173956_, new CowModel<>(p_173956_.bakeLayer(ModelLayers.COW)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(LegendaryCowEntity pEntity) {
        return new ResourceLocation(CheeseMod.MOD_ID, "textures/entity/cow/legendary_cow.png");
    }
    }



