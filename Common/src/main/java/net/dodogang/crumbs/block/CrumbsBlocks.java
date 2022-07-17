package net.dodogang.crumbs.block;

import net.dodogang.ash.registry.api.ResourceBatch;
import net.dodogang.crumbs.Crumbs;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;
import java.util.function.Supplier;

public class CrumbsBlocks {
    public static final ResourceBatch<Block> BLOCKS = ResourceBatch.create(Registry.BLOCK, Crumbs.MOD_ID);
    public static final ResourceBatch<Item> ITEMS = ResourceBatch.create(Registry.ITEM, Crumbs.MOD_ID);

    public static final Supplier<Block> CARPENTRY_TABLE = addBlock(
            "carpentry_table",
            () -> new CarpentryTableBlock(
                    BlockBehaviour.Properties
                            .copy(Blocks.STONECUTTER)
                            .requiresCorrectToolForDrops()
                            .strength(2.5f)
            )
    );

    public static final Supplier<Block> OAK_POST = copy("oak_post", WallBlock::new, Blocks.OAK_PLANKS);
    public static final Supplier<Block> SPRUCE_POST = copy("spruce_post", WallBlock::new, Blocks.SPRUCE_PLANKS);
    public static final Supplier<Block> BIRCH_POST = copy("birch_post", WallBlock::new, Blocks.BIRCH_PLANKS);
    public static final Supplier<Block> JUNGLE_POST = copy("jungle_post", WallBlock::new, Blocks.JUNGLE_PLANKS);
    public static final Supplier<Block> ACACIA_POST = copy("acacia_post", WallBlock::new, Blocks.ACACIA_PLANKS);
    public static final Supplier<Block> DARK_OAK_POST = copy("dark_oak_post", WallBlock::new, Blocks.DARK_OAK_PLANKS);
    public static final Supplier<Block> MANGROVE_POST = copy("mangrove_post", WallBlock::new, Blocks.MANGROVE_PLANKS);
    public static final Supplier<Block> CRIMSON_POST = copy("crimson_post", WallBlock::new, Blocks.CRIMSON_PLANKS);
    public static final Supplier<Block> WARPED_POST = copy("warped_post", WallBlock::new, Blocks.WARPED_PLANKS);

    public static final Supplier<Block> STRIPPED_OAK_POST = copy("stripped_oak_post", WallBlock::new, Blocks.OAK_PLANKS);
    public static final Supplier<Block> STRIPPED_SPRUCE_POST = copy("stripped_spruce_post", WallBlock::new, Blocks.SPRUCE_PLANKS);
    public static final Supplier<Block> STRIPPED_BIRCH_POST = copy("stripped_birch_post", WallBlock::new, Blocks.BIRCH_PLANKS);
    public static final Supplier<Block> STRIPPED_JUNGLE_POST = copy("stripped_jungle_post", WallBlock::new, Blocks.JUNGLE_PLANKS);
    public static final Supplier<Block> STRIPPED_ACACIA_POST = copy("stripped_acacia_post", WallBlock::new, Blocks.ACACIA_PLANKS);
    public static final Supplier<Block> STRIPPED_DARK_OAK_POST = copy("stripped_dark_oak_post", WallBlock::new, Blocks.DARK_OAK_PLANKS);
    public static final Supplier<Block> STRIPPED_MANGROVE_POST = copy("stripped_mangrove_post", WallBlock::new, Blocks.MANGROVE_PLANKS);
    public static final Supplier<Block> STRIPPED_CRIMSON_POST = copy("stripped_crimson_post", WallBlock::new, Blocks.CRIMSON_PLANKS);
    public static final Supplier<Block> STRIPPED_WARPED_POST = copy("stripped_warped_post", WallBlock::new, Blocks.WARPED_PLANKS);

    public static void register() {
        BLOCKS.register();
        ITEMS.register();
    }

    private static <T extends Block> Supplier<T> copy(
            String name,
            Function<BlockBehaviour.Properties, T> constructor,
            BlockBehaviour toCopy
    ) {
        return addBlock(name, () -> constructor.apply(BlockBehaviour.Properties.copy(toCopy)));
    }

    private static <T extends Block> Supplier<T> addBlock(String name, Supplier<T> block) {
        return addBlock(name, block, new Item.Properties().tab(Crumbs.CRUMBS_TAB));
    }

    private static <T extends Block> Supplier<T> addBlock(String name, Supplier<T> block, Item.Properties properties) {
        Supplier<T> result = BLOCKS.add(name, block);
        ITEMS.add(name, () -> new BlockItem(result.get(), properties));
        return result;
    }
}
