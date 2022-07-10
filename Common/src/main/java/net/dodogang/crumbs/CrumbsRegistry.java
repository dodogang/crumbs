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

    public static final Item.Properties DEFAULT_PROPERTIES = new Item.Properties().tab(Crumbs.CRUMBS_TAB);

    public static final Supplier<Block> TEST_BLOCK = addBlock(
            "test_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)),
            DEFAULT_PROPERTIES
    );

    public static void register() {
        BLOCKS.register();
        ITEMS.register();
    }

    private static Supplier<Block> addBlock(String name, Supplier<Block> block, Item.Properties properties) {
        Supplier<Block> result = BLOCKS.add(name, block);
        ITEMS.add(name, () -> new BlockItem(result.get(), properties));
        return result;
    }
}
