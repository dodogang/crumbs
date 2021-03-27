package net.dodogang.crumbs.event;

import com.google.common.collect.ImmutableMap;
import net.dodogang.crumbs.block.CrumbsBlocks;
import net.dodogang.plume.ash.event.InteractionCallback;
import net.dodogang.plume.ash.tag.ToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
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
    private RightClickBlockHandlers() {}

    private static ImmutableMap<Block, Block> logToStrippedMap;

    static {
        logToStrippedMap = new ImmutableMap.Builder<Block, Block>()
                .put(CrumbsBlocks.OAK_BUNDLED_LOG.get(), CrumbsBlocks.STRIPPED_OAK_BUNDLED_LOG.get())
                .put(CrumbsBlocks.BIRCH_BUNDLED_LOG.get(), CrumbsBlocks.STRIPPED_BIRCH_BUNDLED_LOG.get())
                .put(CrumbsBlocks.SPRUCE_BUNDLED_LOG.get(), CrumbsBlocks.STRIPPED_SPRUCE_BUNDLED_LOG.get())
                .put(CrumbsBlocks.JUNGLE_BUNDLED_LOG.get(), CrumbsBlocks.STRIPPED_JUNGLE_BUNDLED_LOG.get())
                .put(CrumbsBlocks.ACACIA_BUNDLED_LOG.get(), CrumbsBlocks.STRIPPED_ACACIA_BUNDLED_LOG.get())
                .put(CrumbsBlocks.DARK_OAK_BUNDLED_LOG.get(), CrumbsBlocks.STRIPPED_DARK_OAK_BUNDLED_LOG.get())
                .put(CrumbsBlocks.CRIMSON_BUNDLED_STEM.get(), CrumbsBlocks.STRIPPED_CRIMSON_BUNDLED_STEM.get())
                .put(CrumbsBlocks.WARPED_BUNDLED_STEM.get(), CrumbsBlocks.STRIPPED_WARPED_BUNDLED_STEM.get())
                .build();
    }

    public static void register() {
        InteractionCallback.RightClickBlock.register(RightClickBlockHandlers::stripLog);
    }

    public static ActionResult stripLog(PlayerEntity player, World world, Hand hand, BlockPos pos, Direction dir) {
        BlockState state = world.getBlockState(pos);
        ItemStack stack = player.getStackInHand(hand);

        if (ToolTags.AXES.contains(stack) && logToStrippedMap.containsKey(state.getBlock())) {
            world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0f, 1.0f);
            if (!world.isClient) {
                Block strippedLog = logToStrippedMap.get(state.getBlock());

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
        }
        return ActionResult.PASS;
    }
}
