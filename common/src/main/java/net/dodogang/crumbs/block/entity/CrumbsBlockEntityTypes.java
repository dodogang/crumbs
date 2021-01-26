package net.dodogang.crumbs.block.entity;

import net.dodogang.crumbs.CrumbsCore;
import net.dodogang.crumbs.block.CrumbsBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class CrumbsBlockEntityTypes {
    public static final BlockEntityType<CrumbsChestBlockEntity> CRUMBS_CHEST = register(
            "chest", CrumbsChestBlockEntity::new,
            CrumbsBlocks.SPRUCE_CHEST, CrumbsBlocks.BIRCH_CHEST, CrumbsBlocks.JUNGLE_CHEST, CrumbsBlocks.ACACIA_CHEST,
            CrumbsBlocks.DARK_OAK_CHEST, CrumbsBlocks.CRIMSON_CHEST, CrumbsBlocks.WARPED_CHEST
    );

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, Supplier<T> beSupplier, Block... blocks) {
        Identifier id = CrumbsCore.getId(name);
        BlockEntityType<T> be = BlockEntityType.Builder.create(beSupplier, blocks).build(null);
        CrumbsCore.platform.registerBlockEntityType(id, be);
        return be;
    }
}