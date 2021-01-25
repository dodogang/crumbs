package net.dodogang.crumbs.block.entity;

import net.dodogang.crumbs.block.CrumbsBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.entity.ChestBlockEntity;

public class CrumbsChestBlockEntity extends ChestBlockEntity {
    public final Block block;

    public CrumbsChestBlockEntity() {
        this(CrumbsBlocks.SPRUCE_CHEST);
    }

    public CrumbsChestBlockEntity(Block block) {
        super(CrumbsBlockEntityType.CRUMBS_CHEST);
        this.block = block;
    }
}