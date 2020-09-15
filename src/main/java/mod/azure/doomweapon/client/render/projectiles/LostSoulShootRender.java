package mod.azure.doomweapon.client.render.projectiles;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.client.models.LostSoulModel;
import mod.azure.doomweapon.client.render.layers.LayerFlames;
import mod.azure.doomweapon.entity.projectiles.LostSoulEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class LostSoulShootRender extends MobRenderer<LostSoulEntity, LostSoulModel<LostSoulEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/lost_soul.png");

	public LostSoulShootRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new LostSoulModel<>(), 0.8F);
		this.addLayer(new LayerFlames(this));
	}

	@Override
	protected int getBlockLight(LostSoulEntity entityIn, float partialTicks) {
		return 5;
	}

	@Override
	public ResourceLocation getEntityTexture(LostSoulEntity entity) {
		return TEXTURE;
	}
}