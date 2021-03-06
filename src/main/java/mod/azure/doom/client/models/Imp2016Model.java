package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.Imp2016Entity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class Imp2016Model extends AnimatedGeoModel<Imp2016Entity> {

	public Imp2016Model() {
	}

	@Override
	public ResourceLocation getModelLocation(Imp2016Entity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/imp2016.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(Imp2016Entity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/imp2016.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(Imp2016Entity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/imp2016.animation.json");
	}
}