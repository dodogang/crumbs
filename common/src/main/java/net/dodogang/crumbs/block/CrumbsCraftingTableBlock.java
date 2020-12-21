package net.dodogang.crumbs.block;

import net.dodogang.crumbs.screen.CrumbsCraftingMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CrumbsCraftingTableBlock extends CraftingTableBlock {
    private static final Component TITLE = new TranslatableComponent("container.crafting");

    public CrumbsCraftingTableBlock(Properties properties) {
        super(properties);
    }

    @Override
    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new SimpleMenuProvider((syncId, inv, player) -> {
            return new CrumbsCraftingMenu(syncId, inv, ContainerLevelAccess.create(level, pos), this);
        }, TITLE);
    }
}
