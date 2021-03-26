package net.dodogang.crumbs.client.render.block.entity;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.dodogang.crumbs.Crumbs;
import net.dodogang.crumbs.block.CrumbsBlocks;
import net.dodogang.crumbs.block.WoodenChestBlock;
import net.dodogang.crumbs.block.entity.WoodenChestBlockEntity;
import net.dodogang.crumbs.client.model.ChestModel;
import net.dodogang.crumbs.client.model.DoubleChestModel;
import net.dodogang.crumbs.client.model.SingleChestModel;
import net.dodogang.crumbs.client.render.CrumbsAtlasTextures;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.DoubleBlockProperties;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.LightmapCoordinatesRetriever;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class WoodenChestRenderer extends BlockEntityRenderer<WoodenChestBlockEntity> {
    private static final ImmutableMap<Pair<WoodenChestBlock.ModelType, ChestType>, ChestModel> MODELS;

    static {
        MODELS = new ImmutableMap.Builder<Pair<WoodenChestBlock.ModelType, ChestType>, ChestModel>()
                .put(new Pair<>(WoodenChestBlock.ModelType.OAK, ChestType.SINGLE), new SingleChestModel.Oak())
                .put(new Pair<>(WoodenChestBlock.ModelType.OAK, ChestType.RIGHT), new DoubleChestModel.Oak())
                .put(new Pair<>(WoodenChestBlock.ModelType.BIRCH, ChestType.SINGLE), new SingleChestModel.Birch())
                .put(new Pair<>(WoodenChestBlock.ModelType.BIRCH, ChestType.RIGHT), new DoubleChestModel.Birch())
                .put(new Pair<>(WoodenChestBlock.ModelType.SPRUCE, ChestType.SINGLE), new SingleChestModel.Spruce())
                .put(new Pair<>(WoodenChestBlock.ModelType.SPRUCE, ChestType.RIGHT), new DoubleChestModel.Spruce())
                .put(new Pair<>(WoodenChestBlock.ModelType.ACACIA, ChestType.SINGLE), new SingleChestModel.Acacia())
                .put(new Pair<>(WoodenChestBlock.ModelType.ACACIA, ChestType.RIGHT), new DoubleChestModel.Acacia())
                .put(new Pair<>(WoodenChestBlock.ModelType.CRIMSON, ChestType.SINGLE), new SingleChestModel.Crimson())
                .put(new Pair<>(WoodenChestBlock.ModelType.CRIMSON, ChestType.RIGHT), new DoubleChestModel.Crimson())
                .build();
    }

    public WoodenChestRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void render(
            WoodenChestBlockEntity blockEntity,
            float tickDelta,
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light,
            int overlay
    ) {
        Block block = blockEntity.block;
        BlockState state = blockEntity.hasWorld() ? blockEntity.getCachedState() : block.getDefaultState();
        ChestType chestType = state.get(ChestBlock.CHEST_TYPE);
        if (chestType == ChestType.LEFT) {
            return;
        }

        if (block instanceof WoodenChestBlock) {
            WoodenChestBlock.ModelType modelType = ((WoodenChestBlock)block).modelType;

            ChestModel model = MODELS.get(new Pair<>(modelType, chestType));
            if (model == null) {
                Crumbs.LOGGER.error(
                        String.format("Missing model definition for ModelType: %s, ChestType: %s", modelType, chestType)
                );
                return;
            }

            matrices.push();

            matrices.translate(0.5d, 0.5d, 0.5d);
            matrices.multiply(
                    Vector3f.POSITIVE_Y.getDegreesQuaternion(-state.get(Properties.HORIZONTAL_FACING).asRotation())
            );
            matrices.translate(-0.5d, -0.5d, -0.5d);

            model.rotateLid(blockEntity.getAnimationProgress(tickDelta));

            DoubleBlockProperties.PropertySource<WoodenChestBlockEntity> combiner;
            if (blockEntity.hasWorld()) {
                combiner = (DoubleBlockProperties.PropertySource<WoodenChestBlockEntity>)
                        ((WoodenChestBlock)state.getBlock()).getBlockEntitySource(
                                state,
                                blockEntity.getWorld(),
                                blockEntity.getPos(),
                                true
                        );
            } else {
                combiner = DoubleBlockProperties.PropertyRetriever::getFallback;
            }

            model.render(
                    matrices,
                    new SpriteIdentifier(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, getTexture(block, chestType))
                            .getVertexConsumer(vertexConsumers, RenderLayer::getEntityCutout),
                    combiner.apply(new LightmapCoordinatesRetriever<>())
                            .applyAsInt(light),
                    overlay,
                    !blockEntity.hasWorld()
            );

            matrices.pop();
        }
    }

    private Identifier getTexture(Block block, ChestType chestType) {
        switch (chestType) {
            case SINGLE:
                if (block == CrumbsBlocks.OAK_CHEST.get())
                    return CrumbsAtlasTextures.OAK_CHEST;
                else if (block == CrumbsBlocks.SPRUCE_CHEST.get())
                    return CrumbsAtlasTextures.SPRUCE_CHEST;
                else if (block == CrumbsBlocks.BIRCH_CHEST.get())
                    return CrumbsAtlasTextures.BIRCH_CHEST;
                else if (block == CrumbsBlocks.JUNGLE_CHEST.get())
                    return CrumbsAtlasTextures.JUNGLE_CHEST;
                else if (block == CrumbsBlocks.ACACIA_CHEST.get())
                    return CrumbsAtlasTextures.ACACIA_CHEST;
                else if (block == CrumbsBlocks.DARK_OAK_CHEST.get())
                    return CrumbsAtlasTextures.DARK_OAK_CHEST;
                else if (block == CrumbsBlocks.CRIMSON_CHEST.get())
                    return CrumbsAtlasTextures.CRIMSON_CHEST;
                else if (block == CrumbsBlocks.WARPED_CHEST.get())
                    return CrumbsAtlasTextures.WARPED_CHEST;
            case RIGHT:
                if (block == CrumbsBlocks.OAK_CHEST.get())
                    return CrumbsAtlasTextures.OAK_DOUBLE_CHEST;
                else if (block == CrumbsBlocks.SPRUCE_CHEST.get())
                    return CrumbsAtlasTextures.SPRUCE_DOUBLE_CHEST;
                else if (block == CrumbsBlocks.BIRCH_CHEST.get())
                    return CrumbsAtlasTextures.BIRCH_DOUBLE_CHEST;
                else if (block == CrumbsBlocks.JUNGLE_CHEST.get())
                    return CrumbsAtlasTextures.JUNGLE_DOUBLE_CHEST;
                else if (block == CrumbsBlocks.ACACIA_CHEST.get())
                    return CrumbsAtlasTextures.ACACIA_DOUBLE_CHEST;
                else if (block == CrumbsBlocks.DARK_OAK_CHEST.get())
                    return CrumbsAtlasTextures.DARK_OAK_DOUBLE_CHEST;
                else if (block == CrumbsBlocks.CRIMSON_CHEST.get())
                    return CrumbsAtlasTextures.CRIMSON_DOUBLE_CHEST;
                else if (block == CrumbsBlocks.WARPED_CHEST.get())
                    return CrumbsAtlasTextures.WARPED_DOUBLE_CHEST;
        }
        return CrumbsAtlasTextures.SPRUCE_CHEST;
    }

    @Override
    public boolean rendersOutsideBoundingBox(WoodenChestBlockEntity blockEntity) {
        return true;
    }
}
