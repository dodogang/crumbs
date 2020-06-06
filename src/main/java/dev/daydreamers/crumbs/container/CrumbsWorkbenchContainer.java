/*
 * Copyright 2020 Day Dreamers Dev
 *
 * Crumbs is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * https://www.gnu.org/licenses/
 *
 * File: CrumbsWorkbenchContainer.java
 * Date: 2020-06-06 "v0.0.2 First Commit"
 * Revision:
 */
package dev.daydreamers.crumbs.container;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.util.IWorldPosCallable;

public class CrumbsWorkbenchContainer extends WorkbenchContainer
{
    private final IWorldPosCallable worldPosCallable;
    private final Block block;

    public CrumbsWorkbenchContainer(int id, PlayerInventory playerInventoryIn,
                                    IWorldPosCallable pos, Block block)
    {
        super(id, playerInventoryIn, pos);
        worldPosCallable = pos;
        this.block = block;
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn)
    {
        return isWithinUsableDistance(this.worldPosCallable, playerIn, block);
    }
}
