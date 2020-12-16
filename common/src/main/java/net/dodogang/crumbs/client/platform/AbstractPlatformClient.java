package net.dodogang.crumbs.client.platform;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Function;

public interface AbstractPlatformClient {
    <T extends BlockEntity> void registerBlockEntityRenderer(BlockEntityType<T> beType, Function<BlockEntityRenderDispatcher, BlockEntityRenderer<T>> renderer);

    void registerBuiltinItemRendererForBlock(Block block, BlockEntity blockEntity);

    void registerSpritesToAtlas(ResourceLocation atlas, ResourceLocation... spriteLocations);
}
