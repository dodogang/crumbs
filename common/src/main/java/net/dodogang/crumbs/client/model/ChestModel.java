package net.dodogang.crumbs.client.model;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

public interface ChestModel {
    void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, boolean isItem);

    void rotateLid(float pitch);
}
