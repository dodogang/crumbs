package net.dodogang.crumbs.client.model;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

public abstract class DoubleChestModel extends Model implements IChestModel {
    protected final ModelPart base;
    protected final ModelPart lid;

    public DoubleChestModel() {
        super(RenderLayer::getEntityCutout);
        this.textureWidth = 128;
        this.textureHeight = 64;

        base = new ModelPart(this);
        // I don't know why... but it's upside down... so this fixes that
        base.pivotX = (float) Math.toRadians(180);
        base.setPivot(8.0F, 0.0F, 8.0F);
        base.setTextureOffset(0, 19).addCuboid(-7.0F, -11.0F, -7.0F, 30.0F, 11.0F, 14.0F, 0.0F, false);

        lid = new ModelPart(this);
        base.addChild(lid);
        lid.setPivot(0.0F, -9.0F, 7.0F);
        lid.setTextureOffset(0, 0).addCuboid(-7.0F, -5.0F, -14.0F, 30.0F, 5.0F, 14.0F, 0.001F, false);

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        base.render(matrices, vertices, light, overlay);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, boolean isItem) {
        this.render(matrices, vertices, light, overlay, 1, 1, 1, 1);
    }

    @Override
    public void rotateLid(float pitch) {
        pitch = 1.0f - pitch;
        lid.pivotX = -((1.0f - pitch * pitch * pitch) * 1.5707964f);
    }

    public static class Oak extends DoubleChestModel {
        protected final ModelPart knob;

        public Oak() {
            knob = new ModelPart(this);
            lid.addChild(knob);
            knob.setPivot(7.0F, 1.0F, -15.0F);
            knob.setTextureOffset(8, 9).addCuboid(0.0F, -3.0F, 0.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);
        }
    }

    public static class Spruce extends DoubleChestModel {
        protected final ModelPart knob;

        public Spruce() {
            knob = new ModelPart(this);
            lid.addChild(knob);
            knob.setPivot(8.0F, 1.0F, -15.0F);
            knob.setTextureOffset(4, 9).addCuboid(-2.0F, -3.0F, 0.0F, 4.0F, 3.0F, 1.0F, 0.0F, false);
        }
    }

    public static class Acacia extends DoubleChestModel {
        protected final ModelPart knob;

        public Acacia() {
            knob = new ModelPart(this);
            lid.addChild(knob);
            knob.setPivot(8.0F, 0.0F, -15.0F);
            knob.setTextureOffset(75, 11).addCuboid(-3.0F, -2.0F, 0.0F, 6.0F, 2.0F, 1.0F, 0.0F, false);
        }
    }

    public static class Birch extends DoubleChestModel {
        protected final ModelPart knob;

        public Birch() {
            knob = new ModelPart(this);
            lid.addChild(knob);
            knob.setPivot(8.0F, 1.0F, -15.0F);
            knob.setTextureOffset(4, 12).addCuboid(-2.0F, -2.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        }
    }

    public static class Crimson extends DoubleChestModel {
        protected final ModelPart knob;

        public Crimson() {
            knob = new ModelPart(this);
            lid.addChild(knob);
            knob.setPivot(8.0F, 0.0F, -15.0F);
            knob.setTextureOffset(0, 10).addCuboid(-3.0F, -2.0F, 0.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);
        }
    }
}
