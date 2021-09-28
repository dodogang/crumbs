package net.dodogang.crumbs.block.entity;

import net.dodogang.crumbs.Crumbs;
import net.dodogang.crumbs.block.CrumbsBlocks;
import net.dodogang.plume.ash.registry.RegistryBatch;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class CrumbsBlockEntityTypes {
    private static final RegistryBatch<BlockEntityType<?>> BATCH = RegistryBatch.create(Registry.BLOCK_ENTITY_TYPE_KEY, Crumbs.MOD_ID);

    public static BlockEntityType<WoodenChestBlockEntity> WOODEN_CHEST = register(
        "chest", WoodenChestBlockEntity::new,
            CrumbsBlocks.OAK_CHEST,
            CrumbsBlocks.SPRUCE_CHEST,
            CrumbsBlocks.BIRCH_CHEST,
            CrumbsBlocks.JUNGLE_CHEST,
            CrumbsBlocks.ACACIA_CHEST,
            CrumbsBlocks.DARK_OAK_CHEST,
            CrumbsBlocks.CRIMSON_CHEST,
            CrumbsBlocks.WARPED_CHEST
    );

    static {
        BATCH.register();
    }

    private static <T extends BlockEntity> BlockEntityType<T> register(String id, Supplier<T> supplier, Block... blocks) {
        return BATCH.add(id, BlockEntityType.Builder.create(supplier, blocks).build(null));
    }
}
