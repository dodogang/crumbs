package net.dodogang.crumbs.screen;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;

public class CrumbsCraftingScreenHandler extends CraftingScreenHandler {
    private final ScreenHandlerContext screenHandlerContext;
    private final Block block;

    public CrumbsCraftingScreenHandler(int syncId, PlayerInventory inventory, ScreenHandlerContext screenHandlerContext, Block block) {
        super(syncId, inventory, screenHandlerContext);
        this.screenHandlerContext = screenHandlerContext;
        this.block = block;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return canUse(this.screenHandlerContext, player, this.block);
    }
}
