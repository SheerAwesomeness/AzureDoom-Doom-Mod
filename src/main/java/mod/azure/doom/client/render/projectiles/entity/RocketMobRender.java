package mod.azure.doom.client.render.projectiles.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.azure.doom.client.GeoProjectilesRenderer;
import mod.azure.doom.client.models.projectiles.RocketMobModel;
import mod.azure.doom.entity.projectiles.entity.RocketMobEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class RocketMobRender extends GeoProjectilesRenderer<RocketMobEntity> {

	public RocketMobRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new RocketMobModel());
	}

	protected int getBlockLight(RocketMobEntity entityIn, BlockPos partialTicks) {
		return 15;
	}

	@Override
	public RenderType getRenderType(RocketMobEntity animatable, float partialTicks, MatrixStack stack,
			IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}

}