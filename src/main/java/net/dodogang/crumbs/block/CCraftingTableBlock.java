package net.dodogang.crumbs.block;

import net.dodogang.crumbs.container.CWorkbenchContainer;
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

public class CCraftingTableBlock extends CraftingTableBlock {

    private static final ITextComponent field_220271_a = new TranslationTextComponent("container.crafting");

    public CCraftingTableBlock(Block.Properties properties) {
        super(properties);
    }

    @Override
    public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
        return new SimpleNamedContainerProvider(
                (inventory, callPos, p_220270_4_) ->
                        new CWorkbenchContainer(
                                inventory, callPos,
                                IWorldPosCallable.of(worldIn, pos), this
                        ),
                field_220271_a
        );
    }
}
