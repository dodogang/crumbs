package net.dodogang.crumbs.block;

import net.dodogang.crumbs.screen.CrumbsCraftingScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrumbsCraftingTableBlock extends CraftingTableBlock {
    private static final Text TITLE = new TranslatableText("container.crafting");

    public CrumbsCraftingTableBlock(Settings settings) {
        super(settings);
    }

    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory((syncId, inv, player) -> {
            return new CrumbsCraftingScreenHandler(syncId, inv, ScreenHandlerContext.create(world, pos), this);
        }, TITLE);
    }
}
