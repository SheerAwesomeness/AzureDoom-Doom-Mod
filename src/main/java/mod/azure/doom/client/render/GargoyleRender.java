package mod.azure.doom.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.azure.doom.client.models.GargoyleModel;
import mod.azure.doom.entity.GargoyleEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GargoyleRender extends GeoEntityRenderer<GargoyleEntity> {

	public GargoyleRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new GargoyleModel());
	}

	@Override
	public RenderType getRenderType(GargoyleEntity animatable, float partialTicks, MatrixStack stack,
			IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}

	@Override
	protected float getDeathMaxRotation(GargoyleEntity entityLivingBaseIn) {
		return 0.0F;
	}

}