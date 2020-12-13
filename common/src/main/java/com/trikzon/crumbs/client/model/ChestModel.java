package com.trikzon.crumbs.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;

public abstract class ChestModel extends Model implements IChestModel {
	protected final ModelPart base;
	protected final ModelPart lid;

	public ChestModel() {
		super(RenderType::entityCutout);
		this.texWidth = 64;
		this.texHeight = 64;

		base = new ModelPart(this);
		// I don't know why... but it's upside down... so this fixes that
		base.xRot = (float) Math.toRadians(180);
		base.setPos(8.0F, 0.0F, 8.0F);
		base.texOffs(0, 19).addBox(-7.0F, -11.0F, -7.0F, 14.0F, 11.0F, 14.0F, 0.0F, false);

		lid = new ModelPart(this);
		base.addChild(lid);
		lid.setPos(0.0F, -9.0F, 7.0F);
		lid.texOffs(0, 0).addBox(-7.0F, -5.0F, -14.0F, 14.0F, 5.0F, 14.0F, 0.001F, false);
	}

	@Override
	public void renderToBuffer(PoseStack matrices, VertexConsumer consumer, int packedLight, int packedOverlay, float r, float g, float b, float a) {
	    base.render(matrices, consumer, packedLight, packedOverlay);
	}

	@Override
	public void render(PoseStack matrices, VertexConsumer consumer, int packedLight, int packedOverlay) {
		renderToBuffer(matrices, consumer, packedLight, packedOverlay, 1, 1, 1, 1);
	}

	@Override
	public void rotateLid(float pitch) {
	    pitch = 1.0f - pitch;
	    lid.xRot = -((1.0f - pitch * pitch * pitch) * 1.5707964f);
	}

	public static class Oak extends ChestModel {
		protected final ModelPart knob;

		public Oak() {
			knob = new ModelPart(this);
			lid.addChild(knob);
			knob.setPos(0.0F, 1.0F, -15.0F);
			knob.texOffs(8, 9).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		}
	}

	public static class Spruce extends ChestModel {
		protected final ModelPart knob;

		public Spruce() {
			knob = new ModelPart(this);
			lid.addChild(knob);
			knob.setPos(0.0F, 1.0F, -15.0F);
			knob.texOffs(4, 9).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 3.0F, 1.0F, 0.0F, false);
		}
	}

	public static class Acacia extends ChestModel {
		protected final ModelPart knob;

		public Acacia() {
		    knob = new ModelPart(this);
			lid.addChild(knob);
			knob.setPos(0.0F, 0.0F, -15.0F);
			knob.texOffs(43, 11).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 2.0F, 1.0F, 0.0F, false);
		}
	}

	public static class Birch extends ChestModel {
		protected final ModelPart knob;

		public Birch() {
			knob = new ModelPart(this);
			lid.addChild(knob);
			knob.setPos(0.0F, 1.0F, -15.0F);
			knob.texOffs(4, 12).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		}
	}

	public static class Crimson extends ChestModel {
		protected final ModelPart knob;

		public Crimson() {
			knob = new ModelPart(this);
			lid.addChild(knob);
			knob.setPos(0.0F, 1.0F, -15.0F);
			knob.texOffs(0, 10).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);
		}
	}
}