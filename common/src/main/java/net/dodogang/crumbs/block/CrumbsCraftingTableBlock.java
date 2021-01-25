package net.dodogang.crumbs.block;

import net.dodogang.crumbs.screen.CrumbsCraftingScreenHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.*;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CrumbsCraftingTableBlock extends CraftingTableBlock {
    private static final Text TITLE = new TranslatableText("container.crafting");

    public CrumbsCraftingTableBlock(Settings settings) {
        super(settings);
    }

    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        // Using an anonymous class instead of a lambda because of an Architect bug: https://github.com/architectury/architect-plugin/issues/1
        // TODO: Test if this is still a bug.
        final Block block = this;
        return new SimpleNamedScreenHandlerFactory(new ScreenHandlerFactory() {
            @Nullable
            @Override
            public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
                return new CrumbsCraftingScreenHandler(syncId, inv, ScreenHandlerContext.create(world, pos), block);
            }
        }, TITLE);
    }
}
