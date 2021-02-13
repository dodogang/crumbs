package net.dodogang.crumbs.block.entity;

import net.dodogang.ash.registry.BatchedRegister;
import net.dodogang.ash.registry.RegistrySupplier;
import net.dodogang.crumbs.Crumbs;
import net.dodogang.crumbs.block.CrumbsBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class CrumbsBlockEntityTypes {
    private CrumbsBlockEntityTypes() {}

    public static RegistrySupplier<BlockEntityType<CrumbsChestBlockEntity>> CRUMBS_CHEST;

    public static void register() {
        BatchedRegister<BlockEntityType<?>> beBatchedRegister = BatchedRegister.create(
                Registry.BLOCK_ENTITY_TYPE_KEY, Crumbs.MOD_ID
        );

        CRUMBS_CHEST = beBatchedRegister.add("chest", createBE(
                CrumbsChestBlockEntity::new,
                CrumbsBlocks.SPRUCE_CHEST.getEarly(),
                CrumbsBlocks.BIRCH_CHEST.getEarly(),
                CrumbsBlocks.JUNGLE_CHEST.getEarly(),
                CrumbsBlocks.ACACIA_CHEST.getEarly(),
                CrumbsBlocks.DARK_OAK_CHEST.getEarly(),
                CrumbsBlocks.CRIMSON_CHEST.getEarly(),
                CrumbsBlocks.WARPED_CHEST.getEarly()
        ));

        beBatchedRegister.register();
    }

    private static <T extends BlockEntity> BlockEntityType<T> createBE(Supplier<T> beSupplier, Block... blocks) {
        return BlockEntityType.Builder.create(beSupplier, blocks).build(null);
    }
}