/*
 * Copyright 2020 Day Dreamers Dev
 *
 * Crumbs is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * https://www.gnu.org/licenses/
 *
 * File: CrumbsCraftingTableBlock.java
 * Date: 2020-06-06 "v0.0.2 First Commit"
 * Revision:
 */
package dev.daydreamers.crumbs.block;

import dev.daydreamers.crumbs.container.CrumbsWorkbenchContainer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class CrumbsCraftingTableBlock extends CraftingTableBlock
{
    private static final ITextComponent field_220271_a = new TranslationTextComponent("container.crafting");

    public CrumbsCraftingTableBlock(Block.Properties properties)
    {
        super(properties);
    }

    @Override
    public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos)
    {
        return new SimpleNamedContainerProvider(
                (inventory, callPos, p_220270_4_) ->
                        new CrumbsWorkbenchContainer(
                                inventory, callPos,
                                IWorldPosCallable.of(worldIn, pos), this
                        ),
                field_220271_a
        );
    }
}
