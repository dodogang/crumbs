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

public class WoodLanternBlock extends Block {
    public static final BooleanProperty LIT = Properties.LIT;

    public WoodLanternBlock(Settings settings) {
        super(settings.luminance(state -> state.get(LIT) ? 15 : 0));
        setDefaultState(this.getDefaultState().with(LIT, false));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        final boolean lit = !state.get(LIT);
        world.setBlockState(pos, state.with(LIT, lit));

        if (!world.isClient) {
            player.playSound(
                    lit ? SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON : SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF,
                    SoundCategory.BLOCKS, 0.5f, 0.75f
            );
        }
        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        if (ctx.getPlayer().isSneaking()) {
            return super.getPlacementState(ctx).with(LIT, true);
        }
        return super.getPlacementState(ctx);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(LIT);
    }
}
