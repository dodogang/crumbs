package net.dodogang.crumbs.inventory.container;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.util.IWorldPosCallable;

public class CrumbsWorkbenchContainer extends WorkbenchContainer {
    private final IWorldPosCallable worldPosCallable;
    private final Block block;

    public CrumbsWorkbenchContainer(int id, PlayerInventory playerInventoryIn, IWorldPosCallable pos, Block block) {
        super(id, playerInventoryIn, pos);
        worldPosCallable = pos;
        this.block = block;
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(this.worldPosCallable, playerIn, block);
    }
}
