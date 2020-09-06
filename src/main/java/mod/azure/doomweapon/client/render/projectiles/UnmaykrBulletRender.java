package mod.azure.doomweapon.client.render.projectiles;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.entity.projectiles.UnmaykrBoltEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class UnmaykrBulletRender extends ArrowRenderer<UnmaykrBoltEntity> {

	private static final ResourceLocation ARGENT_BOLT_TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/projectiles/argent_bolt.png");

	public UnmaykrBulletRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public ResourceLocation getEntityTexture(UnmaykrBoltEntity entity) {
		return ARGENT_BOLT_TEXTURE;
	}

}