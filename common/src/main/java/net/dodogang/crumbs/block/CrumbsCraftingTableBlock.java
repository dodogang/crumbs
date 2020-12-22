package net.dodogang.crumbs.block;

import net.dodogang.crumbs.world.inventory.CrumbsCraftingMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuConstructor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class CrumbsCraftingTableBlock extends CraftingTableBlock {
    private static final Component TITLE = new TranslatableComponent("container.crafting");

    public CrumbsCraftingTableBlock(Properties properties) {
        super(properties);
    }

    @Override
    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        // Using an anonymous class instead of a lambda because of an Architect bug: https://github.com/architectury/architect-plugin/issues/1
        final Block block = this;
        return new SimpleMenuProvider(new MenuConstructor() {
            @Nullable
            @Override
            public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
                return new CrumbsCraftingMenu(syncId, inventory, ContainerLevelAccess.create(level, pos), block);
            }
        }, TITLE);
    }
}
