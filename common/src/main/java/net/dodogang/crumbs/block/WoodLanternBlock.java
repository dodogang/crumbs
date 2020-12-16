package net.dodogang.crumbs.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class WoodLanternBlock extends Block {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public WoodLanternBlock(Properties properties) {
        super(properties.lightLevel(state -> state.getValue(LIT) ? 15 : 0));
        registerDefaultState(this.defaultBlockState().setValue(LIT, false));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        final boolean lit = !state.getValue(LIT);
        level.setBlockAndUpdate(pos, state.setValue(LIT, lit));

        if (!level.isClientSide) {
            player.playNotifySound(
                    lit ? SoundEvents.WOODEN_BUTTON_CLICK_ON : SoundEvents.WOODEN_BUTTON_CLICK_OFF,
                    SoundSource.BLOCKS, 0.5f, 0.75f
            );
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        if (context.getPlayer().isShiftKeyDown()) {
            return super.getStateForPlacement(context).setValue(LIT, true);
        }
        return super.getStateForPlacement(context);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(LIT);
    }
}
