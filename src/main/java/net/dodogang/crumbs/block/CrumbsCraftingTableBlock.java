package net.dodogang.crumbs.block;

import net.dodogang.crumbs.inventory.container.CrumbsWorkbenchContainer;
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

public class CrumbsCraftingTableBlock extends CraftingTableBlock {
    private static final ITextComponent CONTAINER_NAME = new TranslationTextComponent("container.crafting");

    public CrumbsCraftingTableBlock(Block.Properties properties) {
        super(properties);
    }

    @Override
    public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
        return new SimpleNamedContainerProvider(
                (inventory, callPos, p_220270_4_) ->
                        new CrumbsWorkbenchContainer(
                                inventory, callPos, IWorldPosCallable.of(worldIn, pos), this
                        ),
                CONTAINER_NAME
        );
    }
}
