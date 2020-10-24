package net.dodogang.crumbs.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class WoodLanternBlock extends Block {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public WoodLanternBlock(Block.Properties properties) {
        super(properties.setLightLevel((state) -> {
            return state.get(LIT) ? 15 : 0;
        }));
        setDefaultState(this.getDefaultState().with(LIT, false));
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        final boolean lit = !state.get(LIT);
        worldIn.setBlockState(pos, state.with(LIT, lit));

        if (!worldIn.isRemote) {
            player.playSound(
                    lit ? SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON : SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF,
                    SoundCategory.BLOCKS, 0.5f, 0.75f
            );
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        if (context.getPlayer().isCrouching())
            return super.getStateForPlacement(context).with(LIT, true);
        return super.getStateForPlacement(context);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(LIT);
    }
}
