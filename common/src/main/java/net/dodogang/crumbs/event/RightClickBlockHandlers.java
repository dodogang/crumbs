package net.dodogang.crumbs.event;

import com.google.common.collect.ImmutableMap;
import net.dodogang.crumbs.block.CrumbsBlocks;
import net.dodogang.plume.ash.event.InteractionCallback;
import net.dodogang.plume.ash.tag.ToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class RightClickBlockHandlers {
    private static final ImmutableMap<Block, Block> LOG_TO_STRIPPED_MAP;
    private static final ImmutableMap<Block, Block> WALL_TO_STRIPPED_MAP;

    static {
        LOG_TO_STRIPPED_MAP = new ImmutableMap.Builder<Block, Block>()
                .put(CrumbsBlocks.OAK_BUNDLED_LOG.get(), CrumbsBlocks.STRIPPED_OAK_BUNDLED_LOG.get())
                .put(CrumbsBlocks.BIRCH_BUNDLED_LOG.get(), CrumbsBlocks.STRIPPED_BIRCH_BUNDLED_LOG.get())
                .put(CrumbsBlocks.SPRUCE_BUNDLED_LOG.get(), CrumbsBlocks.STRIPPED_SPRUCE_BUNDLED_LOG.get())
                .put(CrumbsBlocks.JUNGLE_BUNDLED_LOG.get(), CrumbsBlocks.STRIPPED_JUNGLE_BUNDLED_LOG.get())
                .put(CrumbsBlocks.ACACIA_BUNDLED_LOG.get(), CrumbsBlocks.STRIPPED_ACACIA_BUNDLED_LOG.get())
                .put(CrumbsBlocks.DARK_OAK_BUNDLED_LOG.get(), CrumbsBlocks.STRIPPED_DARK_OAK_BUNDLED_LOG.get())
                .put(CrumbsBlocks.CRIMSON_BUNDLED_STEM.get(), CrumbsBlocks.STRIPPED_CRIMSON_BUNDLED_STEM.get())
                .put(CrumbsBlocks.WARPED_BUNDLED_STEM.get(), CrumbsBlocks.STRIPPED_WARPED_BUNDLED_STEM.get())
                .build();

        WALL_TO_STRIPPED_MAP = new ImmutableMap.Builder<Block, Block>()
                .put(CrumbsBlocks.OAK_POST.get(), CrumbsBlocks.STRIPPED_OAK_POST.get())
                .put(CrumbsBlocks.BIRCH_POST.get(), CrumbsBlocks.STRIPPED_BIRCH_POST.get())
                .put(CrumbsBlocks.SPRUCE_POST.get(), CrumbsBlocks.STRIPPED_SPRUCE_POST.get())
                .put(CrumbsBlocks.JUNGLE_POST.get(), CrumbsBlocks.STRIPPED_JUNGLE_POST.get())
                .put(CrumbsBlocks.ACACIA_POST.get(), CrumbsBlocks.STRIPPED_ACACIA_POST.get())
                .put(CrumbsBlocks.DARK_OAK_POST.get(), CrumbsBlocks.STRIPPED_DARK_OAK_POST.get())
                .put(CrumbsBlocks.CRIMSON_POST.get(), CrumbsBlocks.STRIPPED_CRIMSON_POST.get())
                .put(CrumbsBlocks.WARPED_POST.get(), CrumbsBlocks.STRIPPED_WARPED_POST.get())
                .build();
    }

    static {
        InteractionCallback.RightClickBlock.register(RightClickBlockHandlers::stripLog);
    }

    public static ActionResult stripLog(PlayerEntity player, World world, Hand hand, BlockPos pos, Direction dir) {
        BlockState state = world.getBlockState(pos);
        ItemStack stack = player.getStackInHand(hand);

        if (ToolTags.AXES.contains(stack) && LOG_TO_STRIPPED_MAP.containsKey(state.getBlock())) {
            world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0f, 1.0f);
            if (!world.isClient) {
                Block strippedLog = LOG_TO_STRIPPED_MAP.get(state.getBlock());

                world.setBlockState(
                        pos,
                        strippedLog.getDefaultState().with(PillarBlock.AXIS, state.get(PillarBlock.AXIS)),
                        11
                );

                if (!player.isCreative()) {
                    stack.damage(1, player, (_player) -> {
                        _player.sendToolBreakStatus(hand);
                    });
                }
            }
            return ActionResult.SUCCESS;
        } else if (ToolTags.AXES.contains(stack) && WALL_TO_STRIPPED_MAP.containsKey(state.getBlock())) {
            world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0f, 1.0f);
            if (!world.isClient) {
                Block strippedWall = WALL_TO_STRIPPED_MAP.get(state.getBlock());

                world.setBlockState(
                        pos,
                        strippedWall.getDefaultState()
                                .with(WallBlock.UP, state.get(WallBlock.UP))
                                .with(WallBlock.EAST_SHAPE, state.get(WallBlock.EAST_SHAPE))
                                .with(WallBlock.NORTH_SHAPE, state.get(WallBlock.NORTH_SHAPE))
                                .with(WallBlock.SOUTH_SHAPE, state.get(WallBlock.SOUTH_SHAPE))
                                .with(WallBlock.WEST_SHAPE, state.get(WallBlock.WEST_SHAPE))
                                .with(WallBlock.WATERLOGGED, state.get(WallBlock.WATERLOGGED)),
                        11
                );

                if (!player.isCreative()) {
                    stack.damage(1, player, (_player) -> {
                        _player.sendToolBreakStatus(hand);
                    });
                }
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
}
