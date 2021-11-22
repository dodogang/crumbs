package net.dodogang.crumbs.block.entity;

import net.dodogang.crumbs.block.CrumbsBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.entity.ChestBlockEntity;

public class WoodenChestBlockEntity extends ChestBlockEntity {
    public final Block block;

    public WoodenChestBlockEntity() {
        this(CrumbsBlocks.SPRUCE_CHEST);
    }

    public WoodenChestBlockEntity(Block block) {
        super(CrumbsBlockEntityTypes.WOODEN_CHEST);
        this.block = block;
    }
}
