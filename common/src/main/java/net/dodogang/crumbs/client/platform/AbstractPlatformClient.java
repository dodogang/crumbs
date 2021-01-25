package net.dodogang.crumbs.client.platform;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public interface AbstractPlatformClient {
    <T extends BlockEntity> void registerBlockEntityRenderer(BlockEntityType<T> beType, Function<BlockEntityRenderDispatcher, BlockEntityRenderer<T>> renderer);

    void registerBuiltinItemRendererForBlock(Block block, BlockEntity blockEntity);

    void registerSpritesToAtlas(Identifier atlas, Identifier... spriteLocations);
}
