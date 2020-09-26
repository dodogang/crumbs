package net.dodogang.crumbs.block;

import net.dodogang.crumbs.state.property.CrumbsProperties;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class PebblesBlock extends Block implements Waterloggable {
    public static final IntProperty PEBBLES = CrumbsProperties.PEBBLES;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    protected static final VoxelShape ONE_PEBBLE_SHAPE = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 2.0D, 13.0D);
    protected static final VoxelShape TWO_PEBBLES_SHAPE = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 3.0D, 13.0D);
    protected static final VoxelShape THREE_PEBBLES_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D);
    protected static final VoxelShape FOUR_PEBBLES_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 10.0D, 15.0D);

    public PebblesBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(PEBBLES, 1));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState blockState = context.getWorld().getBlockState(context.getBlockPos());
        if (blockState.isOf(this)) {
            return blockState.with(PEBBLES, Math.min(4, (Integer) blockState.get(PEBBLES) + 1));
        } else {
            FluidState fluidState = context.getWorld().getFluidState(context.getBlockPos());
            return super.getPlacementState(context).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
        }
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        pos = pos.down();
        return !world.getBlockState(pos).getCollisionShape(world, pos).getFace(Direction.UP).isEmpty();
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState,
            WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if (!state.canPlaceAt(world, pos)) {
            return Blocks.AIR.getDefaultState();
        } else {
            if ((Boolean) state.get(WATERLOGGED)) {
                world.getFluidTickScheduler().schedule(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
            }

            return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
        }
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return context.getStack().getItem() == this.asItem() && (Integer) state.get(PEBBLES) < 4
            ? true
            : super.canReplace(state, context);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch ((Integer) state.get(PEBBLES)) {
            case 1:
            default:
                return ONE_PEBBLE_SHAPE;
            case 2:
                return TWO_PEBBLES_SHAPE;
            case 3:
                return THREE_PEBBLES_SHAPE;
            case 4:
                return FOUR_PEBBLES_SHAPE;
        }
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return (Boolean) state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(PEBBLES, WATERLOGGED);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}
