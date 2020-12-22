package net.dodogang.crumbs.world.inventory;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.level.block.Block;

public class CrumbsCraftingMenu extends CraftingMenu {
    private final ContainerLevelAccess containerLevelAccess;
    private final Block block;

    public CrumbsCraftingMenu(int syncId, Inventory inventory, ContainerLevelAccess containerLevelAccess, Block block) {
        super(syncId, inventory, containerLevelAccess);
        this.containerLevelAccess = containerLevelAccess;
        this.block = block;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.containerLevelAccess, player, this.block);
    }
}
