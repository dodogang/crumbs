package com.trikzon.crumbs.block.entity;

import com.trikzon.crumbs.block.CrumbsBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.ChestBlockEntity;

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
