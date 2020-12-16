package net.dodogang.crumbs.client.renderer;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Vector3f;
import net.dodogang.crumbs.block.CrumbsBlocks;
import net.dodogang.crumbs.block.CrumbsChestBlock;
import net.dodogang.crumbs.block.entity.CrumbsChestBlockEntity;
import net.dodogang.crumbs.client.model.ChestModel;
import net.dodogang.crumbs.client.model.DoubleChestModel;
import net.dodogang.crumbs.client.model.IChestModel;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.ChestType;

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
    public void render(CrumbsChestBlockEntity be, float tickDelta, PoseStack stack, MultiBufferSource buffer, int light, int overlay) {
        Block block = be.block;
        BlockState state = be.hasLevel() ? be.getBlockState() : block.defaultBlockState();
        ChestType chestType = state.getValue(ChestBlock.TYPE);
        if (chestType == ChestType.LEFT) {
            return;
        }

        if (block instanceof CrumbsChestBlock) {
            CrumbsChestBlock.ModelType modelType = ((CrumbsChestBlock)block).modelType;

            IChestModel model = MODELS.get(new Pair<>(modelType, chestType));
            if (model == null) {
                Util.pauseInIde(new IllegalStateException(String.format(
                        "Missing model definition for ModelType: %s, ChestType: %s", chestType
                )));
            }

            stack.pushPose();
            stack.translate(0.5d, 0.5d, 0.5d);
            stack.mulPose(Vector3f.YP.rotationDegrees(-state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot()));
            stack.translate(-0.5d, -0.5d, -0.5d);
            model.rotateLid(be.getOpenNess(tickDelta));

            DoubleBlockCombiner.NeighborCombineResult<CrumbsChestBlockEntity> combiner;
            if (be.hasLevel()) {
                combiner = (DoubleBlockCombiner.NeighborCombineResult<CrumbsChestBlockEntity>)
                        ((CrumbsChestBlock) state.getBlock()).combine(state, be.getLevel(), be.getBlockPos(), true);
            } else {
                combiner = DoubleBlockCombiner.Combiner::acceptNone;
            }
            model.render(stack,
                    new Material(Sheets.CHEST_SHEET, getTexture(block, chestType)).buffer(buffer, RenderType::entityCutout),
                    combiner.apply(new BrightnessCombiner<>()).applyAsInt(light), overlay, !be.hasLevel()
            );
            stack.popPose();
        }
    }

    private ResourceLocation getTexture(Block block, ChestType modelType) {
        if (block == CrumbsBlocks.BIRCH_CHEST && modelType == ChestType.SINGLE)
            return CrumbsSpriteSheets.BIRCH_CHEST;
        if (block == CrumbsBlocks.BIRCH_CHEST && modelType == ChestType.RIGHT)
            return CrumbsSpriteSheets.BIRCH_DOUBLE_CHEST;
        else if (block == CrumbsBlocks.JUNGLE_CHEST && modelType == ChestType.SINGLE)
            return CrumbsSpriteSheets.JUNGLE_CHEST;
        else if (block == CrumbsBlocks.JUNGLE_CHEST && modelType == ChestType.RIGHT)
            return CrumbsSpriteSheets.JUNGLE_DOUBLE_CHEST;
        else if (block == CrumbsBlocks.ACACIA_CHEST && modelType == ChestType.SINGLE)
            return CrumbsSpriteSheets.ACACIA_CHEST;
        else if (block == CrumbsBlocks.ACACIA_CHEST && modelType == ChestType.RIGHT)
            return CrumbsSpriteSheets.ACACIA_DOUBLE_CHEST;
        else if (block == CrumbsBlocks.DARK_OAK_CHEST && modelType == ChestType.SINGLE)
            return CrumbsSpriteSheets.DARK_OAK_CHEST;
        else if (block == CrumbsBlocks.DARK_OAK_CHEST && modelType == ChestType.RIGHT)
            return CrumbsSpriteSheets.DARK_OAK_DOUBLE_CHEST;
        else if (block == CrumbsBlocks.CRIMSON_CHEST && modelType == ChestType.SINGLE)
            return CrumbsSpriteSheets.CRIMSON_CHEST;
        else if (block == CrumbsBlocks.CRIMSON_CHEST && modelType == ChestType.RIGHT)
            return CrumbsSpriteSheets.CRIMSON_DOUBLE_CHEST;
        else if (block == CrumbsBlocks.WARPED_CHEST && modelType == ChestType.SINGLE)
            return CrumbsSpriteSheets.WARPED_CHEST;
        else if (block == CrumbsBlocks.WARPED_CHEST && modelType == ChestType.RIGHT)
            return CrumbsSpriteSheets.WARPED_DOUBLE_CHEST;
        else if (block == CrumbsBlocks.SPRUCE_CHEST && modelType == ChestType.RIGHT)
            return CrumbsSpriteSheets.SPRUCE_DOUBLE_CHEST;
        else
            return CrumbsSpriteSheets.SPRUCE_CHEST;
    }
}
