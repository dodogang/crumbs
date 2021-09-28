package net.dodogang.crumbs.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public interface ChestModel {
    void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, boolean isItem);

    void rotateLid(float pitch);
}
