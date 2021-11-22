package net.dodogang.crumbs.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public abstract class SingleChestModel extends Model implements ChestModel {
    protected final ModelPart base;
    protected final ModelPart lid;

    public SingleChestModel() {
        super(RenderLayer::getEntityCutout);
        this.textureWidth = 64;
        this.textureHeight = 64;

        base = new ModelPart(this);
        // I don't know why... but it's upside down... so this fixes that
        base.pitch = (float) Math.toRadians(180);


        base.setPivot(8.0F, 0.0F, 8.0F);
        base.setTextureOffset(0, 19).addCuboid(-7.0F, -11.0F, -7.0F, 14.0F, 11.0F, 14.0F, 0.0F, false);

        lid = new ModelPart(this);
        base.addChild(lid);
        lid.setPivot(0.0F, -9.0F, 7.0F);
        lid.setTextureOffset(0, 0).addCuboid(-7.0F, -5.0F, -14.0F, 14.0F, 5.0F, 14.0F, 0.001F, false);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        base.render(matrices, vertices, light, overlay);
    }

    // TODO: see where this is called from.
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, boolean isItem) {
        if (isItem) { base.yaw = (float) Math.toRadians(180); }
        this.render(matrices, vertices, light, overlay, 1, 1, 1, 1);
        base.yaw = 0;
    }

    @Override
    public void rotateLid(float pitch) {
        pitch = 1.0f - pitch;
        lid.pitch = -((1.0f - pitch * pitch * pitch) * 1.5707964f);
    }

    public static class Oak extends SingleChestModel {
        protected final ModelPart knob;

        public Oak() {
            knob = new ModelPart(this);
            lid.addChild(knob);
            knob.setPivot(0.0F, 1.0F, -15.0F);
            knob.setTextureOffset(8, 9).addCuboid(-1.0F, -3.0F, 0.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);
        }
    }

    public static class Spruce extends SingleChestModel {
        protected final ModelPart knob;

        public Spruce() {
            knob = new ModelPart(this);
            lid.addChild(knob);
            knob.setPivot(0.0F, 1.0F, -15.0F);
            knob.setTextureOffset(4, 9).addCuboid(-2.0F, -3.0F, 0.0F, 4.0F, 3.0F, 1.0F, 0.0F, false);
        }
    }

    public static class Acacia extends SingleChestModel {
        protected final ModelPart knob;

        public Acacia() {
            knob = new ModelPart(this);
            lid.addChild(knob);
            knob.setPivot(0.0F, 0.0F, -15.0F);
            knob.setTextureOffset(43, 11).addCuboid(-3.0F, -2.0F, 0.0F, 6.0F, 2.0F, 1.0F, 0.0F, false);
        }
    }

    public static class Birch extends SingleChestModel {
        protected final ModelPart knob;

        public Birch() {
            knob = new ModelPart(this);
            lid.addChild(knob);
            knob.setPivot(0.0F, 1.0F, -15.0F);
            knob.setTextureOffset(4, 12).addCuboid(-2.0F, -2.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        }
    }

    public static class Crimson extends SingleChestModel {
        protected final ModelPart knob;

        public Crimson() {
            knob = new ModelPart(this);
            lid.addChild(knob);
            knob.setPivot(0.0F, 1.0F, -15.0F);
            knob.setTextureOffset(0, 10).addCuboid(-3.0F, -3.0F, 0.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);
        }
    }
}
