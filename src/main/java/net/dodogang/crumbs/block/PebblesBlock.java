package net.dodogang.crumbs.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class PebblesBlock extends Block {
    protected static final VoxelShape PEBBLE_SHAPE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 3.0D, 15.0D);

    public PebblesBlock(Block.Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return PEBBLE_SHAPE;
    }
}
