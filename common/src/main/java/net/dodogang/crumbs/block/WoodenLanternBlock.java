package net.dodogang.crumbs.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class WoodenLanternBlock extends Block {
    public static final BooleanProperty LIT = Properties.LIT;

    public WoodenLanternBlock(Settings settings) {
        super(settings.luminance(state -> state.get(LIT) ? 15 : 0));
    }

    @Override
    public ActionResult onUse(
            BlockState state,
            World world,
            BlockPos pos,
            PlayerEntity player,
            Hand hand,
            BlockHitResult result
    ) {
        final boolean wasLit = state.get(LIT);

        world.setBlockState(pos, state.with(LIT, !wasLit));
        playSound(player, !wasLit);

        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        PlayerEntity player = ctx.getPlayer();
        boolean isSneaking = player != null && player.isSneaking();
        if (isSneaking) {
            // TODO: Test to see how it feels to play the sound if lighting the lamp while sneaking.
            playSound(ctx.getPlayer(), true);
        }

        BlockState sup = super.getPlacementState(ctx);
        return (sup == null ? this.getDefaultState() : sup).with(LIT, isSneaking);
    }

    private void playSound(PlayerEntity player, boolean isLit) {
        if (!player.world.isClient) {
            player.playSound(
                    isLit ? SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON : SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF,
                    SoundCategory.BLOCKS,
                    0.3f,
                    isLit ? 0.6f : 0.5f
            );
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(LIT);
    }
}
