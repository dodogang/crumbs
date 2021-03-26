package net.dodogang.crumbs.block.entity;

import net.dodogang.crumbs.Crumbs;
import net.dodogang.crumbs.block.CrumbsBlocks;
import net.dodogang.plume.ash.registry.RegistryBatch;
import net.dodogang.plume.ash.registry.RegistrySupplier;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class CrumbsBlockEntityTypes {
    private CrumbsBlockEntityTypes() {}

    public static RegistrySupplier<BlockEntityType<WoodenChestBlockEntity>> WOODEN_CHEST;

    public static void register() {
        RegistryBatch<BlockEntityType<?>> batch = RegistryBatch.create(
                Registry.BLOCK_ENTITY_TYPE_KEY,
                Crumbs.MOD_ID
        );

        WOODEN_CHEST = batch.add(
                "chest",
                BlockEntityType.Builder.create(
                    WoodenChestBlockEntity::new,
                    CrumbsBlocks.OAK_CHEST.getInitialValue(),
                    CrumbsBlocks.SPRUCE_CHEST.getInitialValue(),
                    CrumbsBlocks.BIRCH_CHEST.getInitialValue(),
                    CrumbsBlocks.JUNGLE_CHEST.getInitialValue(),
                    CrumbsBlocks.ACACIA_CHEST.getInitialValue(),
                    CrumbsBlocks.DARK_OAK_CHEST.getInitialValue(),
                    CrumbsBlocks.CRIMSON_CHEST.getInitialValue(),
                    CrumbsBlocks.WARPED_CHEST.getInitialValue()
                ).build(null)
        );

        batch.register();
    }
}
