package com.trikzon.crumbs.block.entity;

import com.trikzon.crumbs.CrumbsCore;
import com.trikzon.crumbs.block.CrumbsBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class CrumbsBlockEntityType {
    public static final BlockEntityType<CrumbsChestBlockEntity> CRUMBS_CHEST = register(
            "chest", CrumbsChestBlockEntity::new,
            CrumbsBlocks.SPRUCE_CHEST, CrumbsBlocks.BIRCH_CHEST, CrumbsBlocks.JUNGLE_CHEST, CrumbsBlocks.ACACIA_CHEST,
            CrumbsBlocks.DARK_OAK_CHEST, CrumbsBlocks.CRIMSON_CHEST, CrumbsBlocks.WARPED_CHEST
    );

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, Supplier<T> beSupplier, Block... blocks) {
        ResourceLocation id = CrumbsCore.getId(name);
        BlockEntityType<T> be = BlockEntityType.Builder.of(beSupplier, blocks).build(null);
        CrumbsCore.platform.registerBlockEntityType(id, be);
        return be;
    }
}
