package net.dodogang.crumbs.container;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.util.IWorldPosCallable;

public class CWorkbenchContainer extends WorkbenchContainer
{
    private final IWorldPosCallable worldPosCallable;
    private final Block block;

    public CWorkbenchContainer(int id, PlayerInventory playerInventoryIn, IWorldPosCallable pos, Block block) {
        super(id, playerInventoryIn, pos);
        worldPosCallable = pos;
        this.block = block;
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(this.worldPosCallable, playerIn, block);
    }
}
