package mod.azure.doom.client.render.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.LostSoulModel;
import mod.azure.doom.entity.projectiles.LostSoulEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class LayerFlames extends LayerRenderer<LostSoulEntity, LostSoulModel<LostSoulEntity>> {
	private static final ResourceLocation[] TEX = {
			new ResourceLocation(DoomMod.MODID, "textures/entity/lost_soul_fire_1.png"),
			new ResourceLocation(DoomMod.MODID, "textures/entity/lost_soul_fire_2.png"),
			new ResourceLocation(DoomMod.MODID, "textures/entity/lost_soul_fire_3.png"),
			new ResourceLocation(DoomMod.MODID, "textures/entity/lost_soul_fire_4.png"),
			new ResourceLocation(DoomMod.MODID, "textures/entity/lost_soul_fire_5.png"),
			new ResourceLocation(DoomMod.MODID, "textures/entity/lost_soul_fire_6.png"),
			new ResourceLocation(DoomMod.MODID, "textures/entity/lost_soul_fire_7.png"),
			new ResourceLocation(DoomMod.MODID, "textures/entity/lost_soul_fire_8.png") };

	public LayerFlames(IEntityRenderer<LostSoulEntity, LostSoulModel<LostSoulEntity>> featureRendererContext) {
		super(featureRendererContext);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn,
			LostSoulEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks,
			float ageInTicks, float netHeadYaw, float headPitch) {
		Minecraft.getInstance().getRenderManager().textureManager
				.bindTexture(TEX[(entitylivingbaseIn.getFlameTimer())]);
		matrixStackIn.push();
		matrixStackIn.translate(0.0D, 1.034D, 0.05D);
		IVertexBuilder ivertexbuilder = bufferIn
				.getBuffer(RenderType.getEntityCutoutNoCull(TEX[(entitylivingbaseIn.getFlameTimer())]));
		this.getEntityModel().renderFlame(matrixStackIn, ivertexbuilder, 100, 1);
		matrixStackIn.pop();
	}

}