package com.trikzon.crumbs.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

public interface IChestModel {
    void render(PoseStack matrices, VertexConsumer consumer, int packedLight, int packedOverlay);
    void rotateLid(float pitch);
}
