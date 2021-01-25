package net.dodogang.crumbs.fabric.client;


import net.dodogang.crumbs.client.CrumbsClient;
import net.dodogang.crumbs.client.platform.AbstractPlatformClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class CrumbsClientFabric implements ClientModInitializer, AbstractPlatformClient {
    @Override
    public void onInitializeClient() {
        CrumbsClient.init(this);
        CrumbsClient.setup();
    }

    @Override
    public <T extends BlockEntity> void registerBlockEntityRenderer(BlockEntityType<T> beType, Function<BlockEntityRenderDispatcher, BlockEntityRenderer<T>> renderer) {
        BlockEntityRendererRegistry.INSTANCE.register(beType, renderer);
    }

    @Override
    public void registerBuiltinItemRendererForBlock(Block block, BlockEntity blockEntity) {
        BuiltinItemRendererRegistry.INSTANCE.register(block, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            matrices.push();
            BlockEntityRenderDispatcher.INSTANCE.renderEntity(blockEntity, matrices, vertexConsumers, light, overlay);
            matrices.pop();
        });
    }

    @Override
    public void registerSpritesToAtlas(Identifier atlas, Identifier... spriteLocations) {
        ClientSpriteRegistryCallback.event(atlas).register((atlasTexture, registry) -> {
            for (Identifier sprite : spriteLocations) {
                registry.register(sprite);
            }
        });
    }
}
