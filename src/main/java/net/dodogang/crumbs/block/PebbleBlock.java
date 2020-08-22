/*
 * Copyright 2020 Day Dreamers Dev
 *
 * Crumbs is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * https://www.gnu.org/licenses/
 *
 * File: PebbleBlock.java
 * Date: 2020-06-06 "v0.0.2 First Commit"
 * Revision:
 */
package net.dodogang.crumbs.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class PebbleBlock extends Block {
    protected static final VoxelShape PEBBLE_SHAPE = Block.makeCuboidShape(
            1.0D, 0.0D, 1.0D, 15.0D, 3.0D, 15.0D
    );

    public PebbleBlock(Block.Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return PEBBLE_SHAPE;
    }
}
