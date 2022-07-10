package net.dodogang.crumbs;

import net.dodogang.ash.registry.api.ResourceBatch;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class CrumbsRegistry {
    public static final ResourceBatch<Block> BLOCKS = ResourceBatch.create(Registry.BLOCK, Crumbs.MOD_ID);
    public static final ResourceBatch<Item> ITEMS = ResourceBatch.create(Registry.ITEM, Crumbs.MOD_ID);

    public static final Supplier<Block> TEST_BLOCK = BLOCKS.add(
            "test_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE))
    );
    public static final Supplier<Item> TEST_BLOCK_ITEM = ITEMS.add(
            "test_block",
            () -> new BlockItem(TEST_BLOCK.get(), new Item.Properties().tab(Crumbs.CRUMBS_TAB))
    );

    public static void register() {
        BLOCKS.register();
        ITEMS.register();
    }
}
