package mod.azure.doomweapon.client.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * SpiderDemon - Batpixxler Created using Tabula 8.0.0
 */
public class SpiderdemonModel<T extends Entity> extends EntityModel<T> {
	public ModelRenderer base;
	public ModelRenderer body;
	public ModelRenderer gunBase;
	public ModelRenderer rLeg1_1_flat;
	public ModelRenderer lLeg2_1_flat;
	public ModelRenderer lLeg1_1_flat;
	public ModelRenderer rLeg2_1_flat;
	public ModelRenderer topL;
	public ModelRenderer head;
	public ModelRenderer topR;
	public ModelRenderer lWire;
	public ModelRenderer rEye;
	public ModelRenderer lowJaw;
	public ModelRenderer lEye;
	public ModelRenderer topJaw;
	public ModelRenderer lowTeeth;
	public ModelRenderer topTeeth;
	public ModelRenderer snout;
	public ModelRenderer rWire;
	public ModelRenderer gunBarrel;
	public ModelRenderer rLeg1_1;
	public ModelRenderer rLeg1_2;
	public ModelRenderer rLeg1_3;
	public ModelRenderer rLeg1_4;
	public ModelRenderer rLeg1_5;
	public ModelRenderer lLeg2_1;
	public ModelRenderer lLeg2_2;
	public ModelRenderer lLeg2_3;
	public ModelRenderer lLeg2_4;
	public ModelRenderer lLeg2_5;
	public ModelRenderer lLeg1_1;
	public ModelRenderer lLeg1_2;
	public ModelRenderer lLeg1_3;
	public ModelRenderer lLeg1_4;
	public ModelRenderer lLeg1_5;
	public ModelRenderer rLeg2_1;
	public ModelRenderer rLeg2_2;
	public ModelRenderer rLeg2_3;
	public ModelRenderer rLeg2_4;
	public ModelRenderer rLeg2_5;

	public SpiderdemonModel() {
		this.textureWidth = 200;
		this.textureHeight = 160;
		this.rLeg1_2 = new ModelRenderer(this, 0, 0);
		this.rLeg1_2.setRotationPoint(0.0F, 24.0F, 0.0F);
		this.rLeg1_2.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg1_2, 0.4098033003787853F, 0.0F, 0.0F);
		this.rLeg2_1_flat = new ModelRenderer(this, 0, 94);
		this.rLeg2_1_flat.setRotationPoint(-13.0F, 5.0F, 17.0F);
		this.rLeg2_1_flat.addBox(-2.5F, 0.0F, -2.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		this.lLeg1_1_flat = new ModelRenderer(this, 0, 94);
		this.lLeg1_1_flat.setRotationPoint(13.0F, 5.0F, -15.0F);
		this.lLeg1_1_flat.addBox(-2.5F, 0.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.rLeg1_3 = new ModelRenderer(this, 0, 94);
		this.rLeg1_3.setRotationPoint(0.0F, 4.0F, 0.0F);
		this.rLeg1_3.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 26.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg1_3, 0.6829473549475088F, 0.0F, 0.0F);
		this.rWire = new ModelRenderer(this, 91, 3);
		this.rWire.setRotationPoint(9.0F, 3.0F, 3.0F);
		this.rWire.addBox(0.0F, -17.0F, -23.0F, 1.0F, 17.0F, 46.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rWire, 0.0F, 0.0F, 0.7285004590772052F);
		this.lLeg1_2 = new ModelRenderer(this, 0, 0);
		this.lLeg1_2.setRotationPoint(0.0F, 24.0F, 0.0F);
		this.lLeg1_2.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg1_2, 0.4098033003787853F, 0.0F, 0.0F);
		this.lLeg1_5 = new ModelRenderer(this, 67, 68);
		this.lLeg1_5.setRotationPoint(0.0F, 7.2F, 0.0F);
		this.lLeg1_5.addBox(-4.5F, 0.0F, -4.5F, 9.0F, 4.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg1_5, 0.18203784630933073F, 0.0F, 0.0F);
		this.gunBase = new ModelRenderer(this, 0, 138);
		this.gunBase.setRotationPoint(0.0F, 0.2F, -20.0F);
		this.gunBase.addBox(-7.5F, 0.0F, 0.0F, 15.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.rLeg2_1 = new ModelRenderer(this, 0, 94);
		this.rLeg2_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rLeg2_1.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 26.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg2_1, 1.7756979436947757F, -0.6829473549475088F, 0.0F);
		this.rLeg2_3 = new ModelRenderer(this, 0, 94);
		this.rLeg2_3.setRotationPoint(0.0F, 4.0F, 0.0F);
		this.rLeg2_3.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 26.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg2_3, -0.6829473549475088F, 0.0F, 0.0F);
		this.topJaw = new ModelRenderer(this, 0, 60);
		this.topJaw.setRotationPoint(0.0F, 3.9F, -1.0F);
		this.topJaw.addBox(-3.5F, -2.0F, -3.0F, 7.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.lLeg2_1_flat = new ModelRenderer(this, 0, 94);
		this.lLeg2_1_flat.setRotationPoint(13.0F, 5.0F, 17.0F);
		this.lLeg2_1_flat.addBox(-2.5F, 0.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.lLeg1_3 = new ModelRenderer(this, 0, 94);
		this.lLeg1_3.setRotationPoint(0.0F, 4.0F, 0.0F);
		this.lLeg1_3.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 26.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg1_3, 0.6829473549475088F, 0.0F, 0.0F);
		this.base = new ModelRenderer(this, 0, 94);
		this.base.setRotationPoint(0.0F, -6.5F, 3.0F);
		this.base.addBox(-18.0F, 0.0F, -18.0F, 35.0F, 8.0F, 36.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(base, 0.0F, 0.0F, -0.006283185556850939F);
		this.lowTeeth = new ModelRenderer(this, 18, 125);
		this.lowTeeth.setRotationPoint(-0.5F, -1.3F, -2.6F);
		this.lowTeeth.addBox(-2.0F, 0.0F, 0.0F, 5.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.gunBarrel = new ModelRenderer(this, 35, 138);
		this.gunBarrel.setRotationPoint(0.0F, 0.5F, 0.0F);
		this.gunBarrel.addBox(-3.0F, 0.0F, -4.0F, 6.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.lWire = new ModelRenderer(this, 91, 3);
		this.lWire.mirror = true;
		this.lWire.setRotationPoint(-9.0F, 3.0F, 3.0F);
		this.lWire.addBox(0.0F, -17.0F, -23.0F, 1.0F, 17.0F, 46.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lWire, 0.0F, 0.0F, -0.7285004590772052F);
		this.lLeg2_3 = new ModelRenderer(this, 0, 94);
		this.lLeg2_3.setRotationPoint(0.0F, 4.0F, 0.0F);
		this.lLeg2_3.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 26.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg2_3, -0.6829473549475088F, 0.0F, 0.0F);
		this.snout = new ModelRenderer(this, 0, 67);
		this.snout.setRotationPoint(0.0F, -1.7F, -3.0F);
		this.snout.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(snout, 0.7740534966278743F, 0.0F, 0.0F);
		this.rLeg1_5 = new ModelRenderer(this, 67, 68);
		this.rLeg1_5.setRotationPoint(0.0F, 7.2F, 0.0F);
		this.rLeg1_5.addBox(-4.5F, 0.0F, -4.5F, 9.0F, 4.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg1_5, 0.18203784630933073F, 0.0F, 0.0F);
		this.rLeg1_4 = new ModelRenderer(this, 0, 12);
		this.rLeg1_4.setRotationPoint(0.0F, 24.0F, 0.0F);
		this.rLeg1_4.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 8.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg1_4, 0.5462880092689061F, 0.0F, 0.0F);
		this.lLeg2_5 = new ModelRenderer(this, 67, 68);
		this.lLeg2_5.setRotationPoint(0.0F, 7.2F, 0.0F);
		this.lLeg2_5.addBox(-4.5F, 0.0F, -4.5F, 9.0F, 4.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg2_5, -0.18203784630933073F, 0.0F, 0.0F);
		this.lEye = new ModelRenderer(this, 0, 74);
		this.lEye.mirror = true;
		this.lEye.setRotationPoint(5.5F, 7.0F, -0.6F);
		this.lEye.addBox(0.0F, -7.0F, 0.0F, 9.0F, 7.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lEye, 0.0F, 0.0F, -0.6373942508178124F);
		this.rLeg2_2 = new ModelRenderer(this, 0, 0);
		this.rLeg2_2.setRotationPoint(0.0F, 24.0F, 0.0F);
		this.rLeg2_2.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg2_2, -0.4098033003787853F, 0.0F, 0.0F);
		this.rEye = new ModelRenderer(this, 0, 74);
		this.rEye.setRotationPoint(-5.0F, 7.0F, -0.6F);
		this.rEye.addBox(-9.0F, -7.0F, 0.0F, 9.0F, 7.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rEye, 0.0F, 0.0F, 0.6373942508178124F);
		this.lLeg2_2 = new ModelRenderer(this, 0, 0);
		this.lLeg2_2.setRotationPoint(0.0F, 24.0F, 0.0F);
		this.lLeg2_2.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg2_2, -0.4098033003787853F, 0.0F, 0.0F);
		this.rLeg1_1_flat = new ModelRenderer(this, 0, 94);
		this.rLeg1_1_flat.setRotationPoint(-13.0F, 5.0F, -15.0F);
		this.rLeg1_1_flat.addBox(-2.5F, 0.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.rLeg2_5 = new ModelRenderer(this, 67, 68);
		this.rLeg2_5.setRotationPoint(0.0F, 7.2F, 0.0F);
		this.rLeg2_5.addBox(-4.5F, 0.0F, -4.5F, 9.0F, 4.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg2_5, -0.18203784630933073F, 0.0F, 0.0F);
		this.topL = new ModelRenderer(this, 0, 49);
		this.topL.setRotationPoint(-2.0F, -17.5F, 0.0F);
		this.topL.addBox(-17.0F, -5.0F, -13.0F, 17.0F, 12.0F, 33.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(topL, 0.0F, 0.0F, -0.27314400463445304F);
		this.topR = new ModelRenderer(this, 0, 49);
		this.topR.mirror = true;
		this.topR.setRotationPoint(2.0F, -17.5F, 0.0F);
		this.topR.addBox(-1.0F, -5.0F, -13.0F, 17.0F, 12.0F, 33.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(topR, 0.0F, 0.0F, 0.27314400463445304F);
		this.topTeeth = new ModelRenderer(this, 0, 125);
		this.topTeeth.setRotationPoint(0.0F, 0.4F, -2.8F);
		this.topTeeth.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.lLeg2_4 = new ModelRenderer(this, 0, 12);
		this.lLeg2_4.setRotationPoint(0.0F, 24.0F, 0.0F);
		this.lLeg2_4.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 8.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg2_4, -0.5462880092689061F, 0.0F, 0.0F);
		this.lowJaw = new ModelRenderer(this, 0, 27);
		this.lowJaw.setRotationPoint(0.0F, 5.8F, -0.9F);
		this.lowJaw.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lowJaw, 0.9105382388075086F, 0.0F, 0.0F);
		this.rLeg2_4 = new ModelRenderer(this, 0, 12);
		this.rLeg2_4.setRotationPoint(0.0F, 24.0F, 0.0F);
		this.rLeg2_4.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 8.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg2_4, -0.5462880092689061F, 0.0F, 0.0F);
		this.head = new ModelRenderer(this, 0, 49);
		this.head.setRotationPoint(-1.0F, -7.3F, -13.4F);
		this.head.addBox(-5.0F, -1.0F, -1.0F, 10.0F, 10.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.lLeg2_1 = new ModelRenderer(this, 0, 94);
		this.lLeg2_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lLeg2_1.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 26.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg2_1, 1.7756979436947757F, 0.6829473549475088F, 0.0F);
		this.body = new ModelRenderer(this, 0, 0);
		this.body.setRotationPoint(0.0F, -4.0F, -3.5F);
		this.body.addBox(-17.5F, -11.0F, -13.5F, 34.0F, 15.0F, 34.0F, 0.0F, 0.0F, 0.0F);
		this.lLeg1_4 = new ModelRenderer(this, 0, 12);
		this.lLeg1_4.setRotationPoint(0.0F, 24.0F, 0.0F);
		this.lLeg1_4.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 8.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg1_4, 0.5462880092689061F, 0.0F, 0.0F);
		this.rLeg1_1 = new ModelRenderer(this, 0, 94);
		this.rLeg1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rLeg1_1.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 26.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg1_1, -1.7756979436947757F, 0.6829473549475088F, 0.0F);
		this.lLeg1_1 = new ModelRenderer(this, 0, 94);
		this.lLeg1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lLeg1_1.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 26.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg1_1, -1.7756979436947757F, -0.6829473549475088F, 0.0F);
		this.rLeg1_1.addChild(this.rLeg1_2);
		this.base.addChild(this.rLeg2_1_flat);
		this.base.addChild(this.lLeg1_1_flat);
		this.rLeg1_2.addChild(this.rLeg1_3);
		this.topR.addChild(this.rWire);
		this.lLeg1_1.addChild(this.lLeg1_2);
		this.lLeg1_4.addChild(this.lLeg1_5);
		this.base.addChild(this.gunBase);
		this.rLeg2_1_flat.addChild(this.rLeg2_1);
		this.rLeg2_2.addChild(this.rLeg2_3);
		this.head.addChild(this.topJaw);
		this.base.addChild(this.lLeg2_1_flat);
		this.lLeg1_2.addChild(this.lLeg1_3);
		this.lowJaw.addChild(this.lowTeeth);
		this.gunBase.addChild(this.gunBarrel);
		this.topL.addChild(this.lWire);
		this.lLeg2_2.addChild(this.lLeg2_3);
		this.topJaw.addChild(this.snout);
		this.rLeg1_4.addChild(this.rLeg1_5);
		this.rLeg1_3.addChild(this.rLeg1_4);
		this.lLeg2_4.addChild(this.lLeg2_5);
		this.head.addChild(this.lEye);
		this.rLeg2_1.addChild(this.rLeg2_2);
		this.head.addChild(this.rEye);
		this.lLeg2_1.addChild(this.lLeg2_2);
		this.base.addChild(this.rLeg1_1_flat);
		this.rLeg2_4.addChild(this.rLeg2_5);
		this.body.addChild(this.topL);
		this.body.addChild(this.topR);
		this.topJaw.addChild(this.topTeeth);
		this.lLeg2_3.addChild(this.lLeg2_4);
		this.head.addChild(this.lowJaw);
		this.rLeg2_3.addChild(this.rLeg2_4);
		this.body.addChild(this.head);
		this.lLeg2_1_flat.addChild(this.lLeg2_1);
		this.base.addChild(this.body);
		this.lLeg1_3.addChild(this.lLeg1_4);
		this.rLeg1_1_flat.addChild(this.rLeg1_1);
		this.lLeg1_1_flat.addChild(this.lLeg1_1);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.base).forEach((modelRenderer) -> {
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.rLeg2_1_flat.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount / 1.0F;
		this.lLeg1_1_flat.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.4F * limbSwingAmount
				/ 1.0F;
		this.rLeg1_1_flat.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount / 1.0F;
		this.lLeg2_1_flat.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.4F * limbSwingAmount
				/ 1.0F;
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}