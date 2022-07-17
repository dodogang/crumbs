package net.dodogang.crumbs.event;

import com.google.common.collect.ImmutableMap;
import net.dodogang.ash.tag.api.Tools;
import net.dodogang.crumbs.block.CrumbsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;


public class StripLogsHandler {
    private static final ImmutableMap<Block, Block> LOG_TO_STRIPPED = new ImmutableMap.Builder<Block, Block>()
            .put(CrumbsBlocks.OAK_POST.get(), CrumbsBlocks.STRIPPED_OAK_POST.get())
            .put(CrumbsBlocks.SPRUCE_POST.get(), CrumbsBlocks.STRIPPED_SPRUCE_POST.get())
            .put(CrumbsBlocks.BIRCH_POST.get(), CrumbsBlocks.STRIPPED_BIRCH_POST.get())
            .put(CrumbsBlocks.JUNGLE_POST.get(), CrumbsBlocks.STRIPPED_JUNGLE_POST.get())
            .put(CrumbsBlocks.ACACIA_POST.get(), CrumbsBlocks.STRIPPED_ACACIA_POST.get())
            .put(CrumbsBlocks.DARK_OAK_POST.get(), CrumbsBlocks.STRIPPED_DARK_OAK_POST.get())
            .put(CrumbsBlocks.MANGROVE_POST.get(), CrumbsBlocks.STRIPPED_MANGROVE_POST.get())
            .put(CrumbsBlocks.CRIMSON_POST.get(), CrumbsBlocks.STRIPPED_CRIMSON_POST.get())
            .put(CrumbsBlocks.WARPED_POST.get(), CrumbsBlocks.STRIPPED_WARPED_POST.get())
            .build();

    public static InteractionResult stripLogs(Player player, Level level, InteractionHand hand, BlockHitResult result) {
        BlockPos pos = result.getBlockPos();
        BlockState state = level.getBlockState(pos);
        ItemStack stack = player.getItemInHand(hand);

        if (Tools.Axe.canStrip(stack) && LOG_TO_STRIPPED.containsKey(state.getBlock())) {
            level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0f, 1.0f);
            if (!level.isClientSide) {
                Block strippedWall = LOG_TO_STRIPPED.get(state.getBlock());

                level.setBlock(
                        pos,
                        strippedWall.defaultBlockState()
                                .setValue(WallBlock.UP, state.getValue(WallBlock.UP))
                                .setValue(WallBlock.NORTH_WALL, state.getValue(WallBlock.NORTH_WALL))
                                .setValue(WallBlock.SOUTH_WALL, state.getValue(WallBlock.SOUTH_WALL))
                                .setValue(WallBlock.EAST_WALL, state.getValue(WallBlock.EAST_WALL))
                                .setValue(WallBlock.WEST_WALL, state.getValue(WallBlock.WEST_WALL))
                                .setValue(WallBlock.WATERLOGGED, state.getValue(WallBlock.WATERLOGGED)),
                        Block.UPDATE_ALL_IMMEDIATE
                );

                if (!player.isCreative()) {
                    stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));
                }
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
