package com.trikzon.crumbs.event;

import com.google.common.collect.ImmutableMap;
import com.trikzon.crumbs.CrumbsCore;
import com.trikzon.crumbs.block.CrumbsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

public class RightClickBlockHandlers {
    private final ImmutableMap<Block, Block> logToStrippedMap;

    public RightClickBlockHandlers() {
        logToStrippedMap = new ImmutableMap.Builder<Block, Block>()
                .put(CrumbsBlocks.OAK_BUNDLED_LOG, CrumbsBlocks.STRIPPED_OAK_BUNDLED_LOG)
                .put(CrumbsBlocks.BIRCH_BUNDLED_LOG, CrumbsBlocks.STRIPPED_BIRCH_BUNDLED_LOG)
                .put(CrumbsBlocks.SPRUCE_BUNDLED_LOG, CrumbsBlocks.STRIPPED_SPRUCE_BUNDLED_LOG)
                .put(CrumbsBlocks.JUNGLE_BUNDLED_LOG, CrumbsBlocks.STRIPPED_JUNGLE_BUNDLED_LOG)
                .put(CrumbsBlocks.ACACIA_BUNDLED_LOG, CrumbsBlocks.STRIPPED_ACACIA_BUNDLED_LOG)
                .put(CrumbsBlocks.DARK_OAK_BUNDLED_LOG, CrumbsBlocks.STRIPPED_DARK_OAK_BUNDLED_LOG)
                .put(CrumbsBlocks.CRIMSON_BUNDLED_STEM, CrumbsBlocks.STRIPPED_CRIMSON_BUNDLED_STEM)
                .put(CrumbsBlocks.WARPED_BUNDLED_STEM, CrumbsBlocks.STRIPPED_WARPED_BUNDLED_STEM)
                .build();

        CrumbsCore.platform.registerOnRightClickBlockHandler(this::stripLog);
    }

    public InteractionResult stripLog(Player player, Level level, InteractionHand hand, BlockPos pos, Direction dir) {
        BlockState state = level.getBlockState(pos);
        ItemStack stack = player.getItemInHand(hand);

        if (CrumbsCore.platform.isAxe(stack) && logToStrippedMap.containsKey(state.getBlock())) {
            level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0f, 1.0f);
            if (!level.isClientSide) {
                Block strippedLog = logToStrippedMap.get(state.getBlock());

                level.setBlock(pos, strippedLog.defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS)), 11);
                if (!player.isCreative()) {
                    stack.hurtAndBreak(1, player, (playerX) -> {
                        playerX.broadcastBreakEvent(hand);
                    });
                }
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
