package net.dodogang.crumbs.block.vanilla;

import java.util.function.Supplier;

import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

public class PublicStairsBlock extends StairsBlock {
    public PublicStairsBlock(Supplier<BlockState> state, Properties properties) {
        super(state, properties);
    }
}
