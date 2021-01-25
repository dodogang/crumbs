package net.dodogang.crumbs.client.renderer;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.dodogang.crumbs.block.CrumbsBlocks;
import net.dodogang.crumbs.block.CrumbsChestBlock;
import net.dodogang.crumbs.block.entity.CrumbsChestBlockEntity;
import net.dodogang.crumbs.client.model.ChestModel;
import net.dodogang.crumbs.client.model.DoubleChestModel;
import net.dodogang.crumbs.client.model.IChestModel;
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
import net.minecraft.util.Util;

public class CrumbsChestRenderer extends BlockEntityRenderer<CrumbsChestBlockEntity> {
    private static final ImmutableMap<Pair<CrumbsChestBlock.ModelType, ChestType>, IChestModel> MODELS =
            new ImmutableMap.Builder<Pair<CrumbsChestBlock.ModelType, ChestType>, IChestModel>()
                    .put(new Pair(CrumbsChestBlock.ModelType.OAK, ChestType.SINGLE), new ChestModel.Oak())
                    .put(new Pair(CrumbsChestBlock.ModelType.OAK, ChestType.RIGHT), new DoubleChestModel.Oak())
                    .put(new Pair(CrumbsChestBlock.ModelType.BIRCH, ChestType.SINGLE), new ChestModel.Birch())
                    .put(new Pair(CrumbsChestBlock.ModelType.BIRCH, ChestType.RIGHT), new DoubleChestModel.Birch())
                    .put(new Pair(CrumbsChestBlock.ModelType.SPRUCE, ChestType.SINGLE), new ChestModel.Spruce())
                    .put(new Pair(CrumbsChestBlock.ModelType.SPRUCE, ChestType.RIGHT), new DoubleChestModel.Spruce())
                    .put(new Pair(CrumbsChestBlock.ModelType.ACACIA, ChestType.SINGLE), new ChestModel.Acacia())
                    .put(new Pair(CrumbsChestBlock.ModelType.ACACIA, ChestType.RIGHT), new DoubleChestModel.Acacia())
                    .put(new Pair(CrumbsChestBlock.ModelType.CRIMSON, ChestType.SINGLE), new ChestModel.Crimson())
                    .put(new Pair(CrumbsChestBlock.ModelType.CRIMSON, ChestType.RIGHT), new DoubleChestModel.Crimson())
                    .build();

    public CrumbsChestRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(CrumbsChestBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        Block block = entity.block;
        BlockState state = entity.hasWorld() ? entity.getCachedState() : block.getDefaultState();
        ChestType chestType = state.get(ChestBlock.CHEST_TYPE);
        if (chestType == ChestType.LEFT) {
            return;
        }

        if (block instanceof CrumbsChestBlock) {
            CrumbsChestBlock.ModelType modelType = ((CrumbsChestBlock)block).modelType;

            IChestModel model = MODELS.get(new Pair<>(modelType, chestType));
            if (model == null) {
                Util.throwOrPause(new IllegalStateException(String.format(
                        "Missing model definition for ModelType: %s, ChestType: %s", chestType
                )));
            }

            matrices.push();
            matrices.translate(0.5d, 0.5d, 0.5d);
            matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(-state.get(Properties.HORIZONTAL_FACING).getOffsetY()));
            matrices.translate(-0.5d, -0.5d, -0.5d);
            model.rotateLid(entity.getAnimationProgress(tickDelta));

            DoubleBlockProperties.PropertySource<CrumbsChestBlockEntity> combiner;
            if (entity.hasWorld()) {
                combiner = (DoubleBlockProperties.PropertySource<CrumbsChestBlockEntity>)
                        ((CrumbsChestBlock) state.getBlock()).getBlockEntitySource(state, entity.getWorld(), entity.getPos(), true);
            } else {
                combiner = DoubleBlockProperties.PropertyRetriever::getFallback;
            }
            model.render(
                    matrices,
                    new SpriteIdentifier(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, getTexture(block, chestType))
                            .getVertexConsumer(vertexConsumers, RenderLayer::getEntityCutout),
                    combiner.apply(new LightmapCoordinatesRetriever<>()).applyAsInt(light), overlay, !entity.hasWorld()
            );
            matrices.pop();
        }
    }

    private Identifier getTexture(Block block, ChestType modelType) {
        if (block == CrumbsBlocks.BIRCH_CHEST && modelType == ChestType.SINGLE)
            return CrumbsAtlasTextures.BIRCH_CHEST;
        if (block == CrumbsBlocks.BIRCH_CHEST && modelType == ChestType.RIGHT)
            return CrumbsAtlasTextures.BIRCH_DOUBLE_CHEST;
        else if (block == CrumbsBlocks.JUNGLE_CHEST && modelType == ChestType.SINGLE)
            return CrumbsAtlasTextures.JUNGLE_CHEST;
        else if (block == CrumbsBlocks.JUNGLE_CHEST && modelType == ChestType.RIGHT)
            return CrumbsAtlasTextures.JUNGLE_DOUBLE_CHEST;
        else if (block == CrumbsBlocks.ACACIA_CHEST && modelType == ChestType.SINGLE)
            return CrumbsAtlasTextures.ACACIA_CHEST;
        else if (block == CrumbsBlocks.ACACIA_CHEST && modelType == ChestType.RIGHT)
            return CrumbsAtlasTextures.ACACIA_DOUBLE_CHEST;
        else if (block == CrumbsBlocks.DARK_OAK_CHEST && modelType == ChestType.SINGLE)
            return CrumbsAtlasTextures.DARK_OAK_CHEST;
        else if (block == CrumbsBlocks.DARK_OAK_CHEST && modelType == ChestType.RIGHT)
            return CrumbsAtlasTextures.DARK_OAK_DOUBLE_CHEST;
        else if (block == CrumbsBlocks.CRIMSON_CHEST && modelType == ChestType.SINGLE)
            return CrumbsAtlasTextures.CRIMSON_CHEST;
        else if (block == CrumbsBlocks.CRIMSON_CHEST && modelType == ChestType.RIGHT)
            return CrumbsAtlasTextures.CRIMSON_DOUBLE_CHEST;
        else if (block == CrumbsBlocks.WARPED_CHEST && modelType == ChestType.SINGLE)
            return CrumbsAtlasTextures.WARPED_CHEST;
        else if (block == CrumbsBlocks.WARPED_CHEST && modelType == ChestType.RIGHT)
            return CrumbsAtlasTextures.WARPED_DOUBLE_CHEST;
        else if (block == CrumbsBlocks.SPRUCE_CHEST && modelType == ChestType.RIGHT)
            return CrumbsAtlasTextures.SPRUCE_DOUBLE_CHEST;
        else
            return CrumbsAtlasTextures.SPRUCE_CHEST;
    }
}
