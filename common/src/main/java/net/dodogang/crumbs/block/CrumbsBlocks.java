package net.dodogang.crumbs.block;

import net.dodogang.crumbs.Crumbs;
import net.dodogang.plume.ash.registry.RegistrySupplier;
import net.dodogang.plume.block.PlumeCraftingTableBlock;
import net.dodogang.plume.block.PlumeLadderBlock;
import net.dodogang.plume.registry.BlockRegistryBatch;
import net.minecraft.block.*;
import net.minecraft.item.Item;

public class CrumbsBlocks {
    private CrumbsBlocks() {}

    public static RegistrySupplier<Block> OAK_BUNDLED_LOG;
    public static RegistrySupplier<Block> SPRUCE_BUNDLED_LOG;
    public static RegistrySupplier<Block> BIRCH_BUNDLED_LOG;
    public static RegistrySupplier<Block> JUNGLE_BUNDLED_LOG;
    public static RegistrySupplier<Block> ACACIA_BUNDLED_LOG;
    public static RegistrySupplier<Block> DARK_OAK_BUNDLED_LOG;
    public static RegistrySupplier<Block> CRIMSON_BUNDLED_STEM;
    public static RegistrySupplier<Block> WARPED_BUNDLED_STEM;

    public static RegistrySupplier<Block> STRIPPED_OAK_BUNDLED_LOG;
    public static RegistrySupplier<Block> STRIPPED_SPRUCE_BUNDLED_LOG;
    public static RegistrySupplier<Block> STRIPPED_BIRCH_BUNDLED_LOG;
    public static RegistrySupplier<Block> STRIPPED_JUNGLE_BUNDLED_LOG;
    public static RegistrySupplier<Block> STRIPPED_ACACIA_BUNDLED_LOG;
    public static RegistrySupplier<Block> STRIPPED_DARK_OAK_BUNDLED_LOG;
    public static RegistrySupplier<Block> STRIPPED_CRIMSON_BUNDLED_STEM;
    public static RegistrySupplier<Block> STRIPPED_WARPED_BUNDLED_STEM;

    public static RegistrySupplier<WoodenChestBlock> OAK_CHEST;
    public static RegistrySupplier<WoodenChestBlock> SPRUCE_CHEST;
    public static RegistrySupplier<WoodenChestBlock> BIRCH_CHEST;
    public static RegistrySupplier<WoodenChestBlock> JUNGLE_CHEST;
    public static RegistrySupplier<WoodenChestBlock> ACACIA_CHEST;
    public static RegistrySupplier<WoodenChestBlock> DARK_OAK_CHEST;
    public static RegistrySupplier<WoodenChestBlock> CRIMSON_CHEST;
    public static RegistrySupplier<WoodenChestBlock> WARPED_CHEST;

    public static RegistrySupplier<Block> SPRUCE_CRAFTING_TABLE;
    public static RegistrySupplier<Block> BIRCH_CRAFTING_TABLE;
    public static RegistrySupplier<Block> JUNGLE_CRAFTING_TABLE;
    public static RegistrySupplier<Block> ACACIA_CRAFTING_TABLE;
    public static RegistrySupplier<Block> DARK_OAK_CRAFTING_TABLE;
    public static RegistrySupplier<Block> CRIMSON_CRAFTING_TABLE;
    public static RegistrySupplier<Block> WARPED_CRAFTING_TABLE;

    public static RegistrySupplier<Block> OAK_BARREL;
    public static RegistrySupplier<Block> BIRCH_BARREL;
    public static RegistrySupplier<Block> JUNGLE_BARREL;
    public static RegistrySupplier<Block> ACACIA_BARREL;
    public static RegistrySupplier<Block> DARK_OAK_BARREL;
    public static RegistrySupplier<Block> CRIMSON_BARREL;
    public static RegistrySupplier<Block> WARPED_BARREL;

    public static RegistrySupplier<Block> OAK_LANTERN;
    public static RegistrySupplier<Block> SPRUCE_LANTERN;
    public static RegistrySupplier<Block> BIRCH_LANTERN;
    public static RegistrySupplier<Block> JUNGLE_LANTERN;
    public static RegistrySupplier<Block> ACACIA_LANTERN;
    public static RegistrySupplier<Block> DARK_OAK_LANTERN;
    public static RegistrySupplier<Block> CRIMSON_LANTERN;
    public static RegistrySupplier<Block> WARPED_LANTERN;

    public static RegistrySupplier<Block> SPRUCE_LADDER;
    public static RegistrySupplier<Block> BIRCH_LADDER;
    public static RegistrySupplier<Block> JUNGLE_LADDER;
    public static RegistrySupplier<Block> ACACIA_LADDER;
    public static RegistrySupplier<Block> DARK_OAK_LADDER;
    public static RegistrySupplier<Block> CRIMSON_LADDER;
    public static RegistrySupplier<Block> WARPED_LADDER;

    public static RegistrySupplier<Block> OAK_POST;
    public static RegistrySupplier<Block> SPRUCE_POST;
    public static RegistrySupplier<Block> BIRCH_POST;
    public static RegistrySupplier<Block> JUNGLE_POST;
    public static RegistrySupplier<Block> ACACIA_POST;
    public static RegistrySupplier<Block> DARK_OAK_POST;
    public static RegistrySupplier<Block> CRIMSON_POST;
    public static RegistrySupplier<Block> WARPED_POST;

    public static RegistrySupplier<Block> STRIPPED_OAK_POST;
    public static RegistrySupplier<Block> STRIPPED_SPRUCE_POST;
    public static RegistrySupplier<Block> STRIPPED_BIRCH_POST;
    public static RegistrySupplier<Block> STRIPPED_JUNGLE_POST;
    public static RegistrySupplier<Block> STRIPPED_ACACIA_POST;
    public static RegistrySupplier<Block> STRIPPED_DARK_OAK_POST;
    public static RegistrySupplier<Block> STRIPPED_CRIMSON_POST;
    public static RegistrySupplier<Block> STRIPPED_WARPED_POST;


    public static void register() {
        BlockRegistryBatch batch = new BlockRegistryBatch(Crumbs.MOD_ID);

        batch.setDefaultItemSettings(new Item.Settings().group(Crumbs.ITEM_GROUP));

        // -------- Wooden Blocks --------
        // -------------------------------
        OAK_BUNDLED_LOG = batch.addCopy("oak_bundled_log", PillarBlock::new, Blocks.OAK_LOG);
        SPRUCE_BUNDLED_LOG = batch.addCopy("spruce_bundled_log", PillarBlock::new, Blocks.SPRUCE_LOG);
        BIRCH_BUNDLED_LOG = batch.addCopy("birch_bundled_log", PillarBlock::new, Blocks.BIRCH_LOG);
        JUNGLE_BUNDLED_LOG = batch.addCopy("jungle_bundled_log", PillarBlock::new, Blocks.JUNGLE_LOG);
        ACACIA_BUNDLED_LOG = batch.addCopy("acacia_bundled_log", PillarBlock::new, Blocks.ACACIA_LOG);
        DARK_OAK_BUNDLED_LOG = batch.addCopy("dark_oak_bundled_log", PillarBlock::new, Blocks.DARK_OAK_LOG);
        CRIMSON_BUNDLED_STEM = batch.addCopy("crimson_bundled_stem", PillarBlock::new, Blocks.CRIMSON_STEM);
        WARPED_BUNDLED_STEM = batch.addCopy("warped_bundled_stem", PillarBlock::new, Blocks.WARPED_STEM);

        STRIPPED_OAK_BUNDLED_LOG = batch.addCopy("stripped_oak_bundled_log", PillarBlock::new, Blocks.STRIPPED_OAK_LOG);
        STRIPPED_SPRUCE_BUNDLED_LOG = batch.addCopy("stripped_spruce_bundled_log", PillarBlock::new, Blocks.STRIPPED_SPRUCE_LOG);
        STRIPPED_BIRCH_BUNDLED_LOG = batch.addCopy("stripped_birch_bundled_log", PillarBlock::new, Blocks.STRIPPED_BIRCH_LOG);
        STRIPPED_JUNGLE_BUNDLED_LOG = batch.addCopy("stripped_jungle_bundled_log", PillarBlock::new, Blocks.STRIPPED_JUNGLE_LOG);
        STRIPPED_ACACIA_BUNDLED_LOG = batch.addCopy("stripped_acacia_bundled_log", PillarBlock::new, Blocks.STRIPPED_ACACIA_LOG);
        STRIPPED_DARK_OAK_BUNDLED_LOG = batch.addCopy("stripped_dark_oak_bundled_log", PillarBlock::new, Blocks.STRIPPED_DARK_OAK_LOG);
        STRIPPED_CRIMSON_BUNDLED_STEM = batch.addCopy("stripped_crimson_bundled_stem", PillarBlock::new, Blocks.STRIPPED_CRIMSON_STEM);
        STRIPPED_WARPED_BUNDLED_STEM = batch.addCopy("stripped_warped_bundled_stem", PillarBlock::new, Blocks.STRIPPED_WARPED_STEM);

        Block oakTile = batch.addCopy("oak_tile", Block::new, Blocks.OAK_PLANKS).getInitialValue();
        Block spruceTile = batch.addCopy("spruce_tile", Block::new, Blocks.SPRUCE_PLANKS).getInitialValue();
        Block birchTile = batch.addCopy("birch_tile", Block::new, Blocks.BIRCH_PLANKS).getInitialValue();
        Block jungleTile = batch.addCopy("jungle_tile", Block::new, Blocks.JUNGLE_PLANKS).getInitialValue();
        Block acaciaTile = batch.addCopy("acacia_tile", Block::new, Blocks.ACACIA_PLANKS).getInitialValue();
        Block darkOakTile = batch.addCopy("dark_oak_tile", Block::new, Blocks.DARK_OAK_PLANKS).getInitialValue();
        Block crimsonTile = batch.addCopy("crimson_tile", Block::new, Blocks.CRIMSON_PLANKS).getInitialValue();
        Block warpedTile = batch.addCopy("warped_tile", Block::new, Blocks.WARPED_PLANKS).getInitialValue();

        batch.addCopy("oak_tile_slab", SlabBlock::new, oakTile);
        batch.addCopy("spruce_tile_slab", SlabBlock::new, spruceTile);
        batch.addCopy("birch_tile_slab", SlabBlock::new, birchTile);
        batch.addCopy("jungle_tile_slab", SlabBlock::new, jungleTile);
        batch.addCopy("acacia_tile_slab", SlabBlock::new, acaciaTile);
        batch.addCopy("dark_oak_tile_slab", SlabBlock::new, darkOakTile);
        batch.addCopy("crimson_tile_slab", SlabBlock::new, crimsonTile);
        batch.addCopy("warped_tile_slab", SlabBlock::new, warpedTile);

        batch.addCopy("reinforced_oak_planks", PillarBlock::new, Blocks.OAK_PLANKS);
        batch.addCopy("reinforced_spruce_planks", PillarBlock::new, Blocks.SPRUCE_PLANKS);
        batch.addCopy("reinforced_birch_planks", PillarBlock::new, Blocks.BIRCH_PLANKS);
        batch.addCopy("reinforced_jungle_planks", PillarBlock::new, Blocks.JUNGLE_PLANKS);
        batch.addCopy("reinforced_acacia_planks", PillarBlock::new, Blocks.ACACIA_PLANKS);
        batch.addCopy("reinforced_dark_oak_planks", PillarBlock::new, Blocks.DARK_OAK_PLANKS);
        batch.addCopy("reinforced_crimson_planks", PillarBlock::new, Blocks.CRIMSON_PLANKS);
        batch.addCopy("reinforced_warped_planks", PillarBlock::new, Blocks.WARPED_PLANKS);

        OAK_CHEST = addChestCopy(batch, "oak_chest", WoodenChestBlock.ModelType.OAK, Blocks.CHEST);
        SPRUCE_CHEST = addChestCopy(batch, "spruce_chest", WoodenChestBlock.ModelType.SPRUCE, Blocks.CHEST);
        BIRCH_CHEST = addChestCopy(batch, "birch_chest", WoodenChestBlock.ModelType.BIRCH, Blocks.CHEST);
        JUNGLE_CHEST = addChestCopy(batch, "jungle_chest", WoodenChestBlock.ModelType.OAK, Blocks.CHEST);
        ACACIA_CHEST = addChestCopy(batch, "acacia_chest", WoodenChestBlock.ModelType.ACACIA, Blocks.CHEST);
        DARK_OAK_CHEST = addChestCopy(batch, "dark_oak_chest", WoodenChestBlock.ModelType.OAK, Blocks.CHEST);
        CRIMSON_CHEST = addChestCopy(batch, "crimson_chest", WoodenChestBlock.ModelType.CRIMSON, Blocks.CHEST);
        WARPED_CHEST = addChestCopy(batch, "warped_chest", WoodenChestBlock.ModelType.CRIMSON, Blocks.CHEST);

        SPRUCE_CRAFTING_TABLE = batch.addCopy("spruce_crafting_table", PlumeCraftingTableBlock::new, Blocks.SPRUCE_PLANKS);
        BIRCH_CRAFTING_TABLE = batch.addCopy("birch_crafting_table", PlumeCraftingTableBlock::new, Blocks.BIRCH_PLANKS);
        JUNGLE_CRAFTING_TABLE = batch.addCopy("jungle_crafting_table", PlumeCraftingTableBlock::new, Blocks.JUNGLE_PLANKS);
        ACACIA_CRAFTING_TABLE = batch.addCopy("acacia_crafting_table", PlumeCraftingTableBlock::new, Blocks.ACACIA_PLANKS);
        DARK_OAK_CRAFTING_TABLE = batch.addCopy("dark_oak_crafting_table", PlumeCraftingTableBlock::new, Blocks.DARK_OAK_PLANKS);
        CRIMSON_CRAFTING_TABLE = batch.addCopy("crimson_crafting_table", PlumeCraftingTableBlock::new, Blocks.CRIMSON_PLANKS);
        WARPED_CRAFTING_TABLE = batch.addCopy("warped_crafting_table", PlumeCraftingTableBlock::new, Blocks.WARPED_PLANKS);

        OAK_BARREL = batch.addCopy("oak_barrel", WoodenBarrelBlock::new, Blocks.OAK_PLANKS);
        BIRCH_BARREL = batch.addCopy("birch_barrel", WoodenBarrelBlock::new, Blocks.BIRCH_PLANKS);
        JUNGLE_BARREL = batch.addCopy("jungle_barrel", WoodenBarrelBlock::new, Blocks.JUNGLE_PLANKS);
        ACACIA_BARREL = batch.addCopy("acacia_barrel", WoodenBarrelBlock::new, Blocks.ACACIA_PLANKS);
        DARK_OAK_BARREL = batch.addCopy("dark_oak_barrel", WoodenBarrelBlock::new, Blocks.DARK_OAK_PLANKS);
        CRIMSON_BARREL = batch.addCopy("crimson_barrel", WoodenBarrelBlock::new, Blocks.CRIMSON_PLANKS);
        WARPED_BARREL = batch.addCopy("warped_barrel", WoodenBarrelBlock::new, Blocks.WARPED_PLANKS);

        batch.addCopy("spruce_bookshelf", Block::new, Blocks.BOOKSHELF);
        batch.addCopy("birch_bookshelf", Block::new, Blocks.BOOKSHELF);
        batch.addCopy("jungle_bookshelf", Block::new, Blocks.BOOKSHELF);
        batch.addCopy("acacia_bookshelf", Block::new, Blocks.BOOKSHELF);
        batch.addCopy("dark_oak_bookshelf", Block::new, Blocks.BOOKSHELF);
        batch.addCopy("crimson_bookshelf", Block::new, Blocks.BOOKSHELF);
        batch.addCopy("warped_bookshelf", Block::new, Blocks.BOOKSHELF);

        OAK_LANTERN = batch.addCopy("oak_lantern", WoodenLanternBlock::new, Blocks.OAK_PLANKS);
        SPRUCE_LANTERN = batch.addCopy("spruce_lantern", WoodenLanternBlock::new, Blocks.SPRUCE_PLANKS);
        BIRCH_LANTERN = batch.addCopy("birch_lantern", WoodenLanternBlock::new, Blocks.BIRCH_PLANKS);
        JUNGLE_LANTERN = batch.addCopy("jungle_lantern", WoodenLanternBlock::new, Blocks.JUNGLE_PLANKS);
        ACACIA_LANTERN = batch.addCopy("acacia_lantern", WoodenLanternBlock::new, Blocks.ACACIA_PLANKS);
        DARK_OAK_LANTERN = batch.addCopy("dark_oak_lantern", WoodenLanternBlock::new, Blocks.DARK_OAK_PLANKS);
        CRIMSON_LANTERN = batch.addCopy("crimson_lantern", WoodenLanternBlock::new, Blocks.CRIMSON_PLANKS);
        WARPED_LANTERN = batch.addCopy("warped_lantern", WoodenLanternBlock::new, Blocks.WARPED_PLANKS);

        SPRUCE_LADDER = batch.addCopy("spruce_ladder", PlumeLadderBlock::new, Blocks.LADDER);
        BIRCH_LADDER = batch.addCopy("birch_ladder", PlumeLadderBlock::new, Blocks.LADDER);
        JUNGLE_LADDER = batch.addCopy("jungle_ladder", PlumeLadderBlock::new, Blocks.LADDER);
        ACACIA_LADDER = batch.addCopy("acacia_ladder", PlumeLadderBlock::new, Blocks.LADDER);
        DARK_OAK_LADDER = batch.addCopy("dark_oak_ladder", PlumeLadderBlock::new, Blocks.LADDER);
        CRIMSON_LADDER = batch.addCopy("crimson_ladder", PlumeLadderBlock::new, Blocks.LADDER);
        WARPED_LADDER = batch.addCopy("warped_ladder", PlumeLadderBlock::new, Blocks.LADDER);

        OAK_POST = batch.addCopy("oak_post", WallBlock::new, Blocks.OAK_PLANKS);
        SPRUCE_POST = batch.addCopy("spruce_post", WallBlock::new, Blocks.SPRUCE_PLANKS);
        BIRCH_POST = batch.addCopy("birch_post", WallBlock::new, Blocks.BIRCH_PLANKS);
        JUNGLE_POST = batch.addCopy("jungle_post", WallBlock::new, Blocks.JUNGLE_PLANKS);
        ACACIA_POST = batch.addCopy("acacia_post", WallBlock::new, Blocks.ACACIA_PLANKS);
        DARK_OAK_POST = batch.addCopy("dark_oak_post", WallBlock::new, Blocks.DARK_OAK_PLANKS);
        CRIMSON_POST = batch.addCopy("crimson_post", WallBlock::new, Blocks.CRIMSON_PLANKS);
        WARPED_POST = batch.addCopy("warped_post", WallBlock::new, Blocks.WARPED_PLANKS);

        STRIPPED_OAK_POST = batch.addCopy("stripped_oak_post", WallBlock::new, Blocks.OAK_PLANKS);
        STRIPPED_SPRUCE_POST = batch.addCopy("stripped_spruce_post", WallBlock::new, Blocks.SPRUCE_PLANKS);
        STRIPPED_BIRCH_POST = batch.addCopy("stripped_birch_post", WallBlock::new, Blocks.BIRCH_PLANKS);
        STRIPPED_JUNGLE_POST = batch.addCopy("stripped_jungle_post", WallBlock::new, Blocks.JUNGLE_PLANKS);
        STRIPPED_ACACIA_POST = batch.addCopy("stripped_acacia_post", WallBlock::new, Blocks.ACACIA_PLANKS);
        STRIPPED_DARK_OAK_POST = batch.addCopy("stripped_dark_oak_post", WallBlock::new, Blocks.DARK_OAK_PLANKS);
        STRIPPED_CRIMSON_POST = batch.addCopy("stripped_crimson_post", WallBlock::new, Blocks.CRIMSON_PLANKS);
        STRIPPED_WARPED_POST = batch.addCopy("stripped_warped_post", WallBlock::new, Blocks.WARPED_PLANKS);

        // -------- Stone Blocks --------
        // ------------------------------
        Block cobbledGranite = batch.addCopy("cobbled_granite", Block::new, Blocks.GRANITE).getInitialValue();
        batch.addCopy("chiseled_polished_granite", Block::new, Blocks.GRANITE);
        batch.addCopy("beveled_polished_granite", Block::new, Blocks.GRANITE);
        batch.addCopy("cracked_polished_granite", Block::new, Blocks.GRANITE);

        Block cobbledDiorite = batch.addCopy("cobbled_diorite", Block::new, Blocks.DIORITE).getInitialValue();
        batch.addCopy("chiseled_polished_diorite", Block::new, Blocks.DIORITE);
        batch.addCopy("beveled_polished_diorite", Block::new, Blocks.DIORITE);
        batch.addCopy("cracked_polished_diorite", Block::new, Blocks.DIORITE);

        Block cobbledAndesite = batch.addCopy("cobbled_andesite", Block::new, Blocks.ANDESITE).getInitialValue();
        batch.addCopy("chiseled_polished_andesite", Block::new, Blocks.ANDESITE);
        batch.addCopy("beveled_polished_andesite", Block::new, Blocks.ANDESITE);
        batch.addCopy("cracked_polished_andesite", Block::new, Blocks.ANDESITE);

        batch.addCopy("beveled_polished_blackstone", Block::new, Blocks.BLACKSTONE);
        batch.addCopy("cracked_polished_blackstone", Block::new, Blocks.BLACKSTONE);

        batch.addCopy("cobbled_granite_wall", WallBlock::new, cobbledGranite);
        batch.addCopy("cobbled_diorite_wall", WallBlock::new, cobbledDiorite);
        batch.addCopy("cobbled_andesite_wall", WallBlock::new, cobbledAndesite);

        batch.addStairCopy("cobbled_granite_stairs", cobbledGranite);
        batch.addStairCopy("cobbled_diorite_stairs", cobbledDiorite);
        batch.addStairCopy("cobbled_andesite_stairs", cobbledAndesite);

        batch.addCopy("cobbled_granite_slab", SlabBlock::new, cobbledGranite);
        batch.addCopy("cobbled_diorite_slab", SlabBlock::new, cobbledDiorite);
        batch.addCopy("cobbled_andesite_slab", SlabBlock::new, cobbledAndesite);

        // -------- Sand Blocks --------
        // -----------------------------
        Block sandstoneTile = batch.addCopy("sandstone_tile", Block::new, Blocks.SANDSTONE).getInitialValue();
        batch.addCopy("large_sandstone_tile", Block::new, Blocks.SANDSTONE);

        Block redSandstoneTile = batch.addCopy("red_sandstone_tile", Block::new, Blocks.RED_SANDSTONE).getInitialValue();
        batch.addCopy("large_red_sandstone_tile", Block::new, Blocks.RED_SANDSTONE);

        batch.addCopy("sandstone_tile_wall", WallBlock::new, sandstoneTile);
        batch.addCopy("red_sandstone_tile_wall", WallBlock::new, redSandstoneTile);

        batch.addCopy("sandstone_tile_slab", SlabBlock::new, sandstoneTile);
        batch.addCopy("red_sandstone_tile_slab", SlabBlock::new, redSandstoneTile);

        batch.addStairCopy("sandstone_tile_stairs", sandstoneTile);
        batch.addStairCopy("red_sandstone_tile_stairs", redSandstoneTile);

        // -------- Nether Bricks --------
        // -------------------------------
        batch.addCopy("chiseled_red_nether_bricks", Block::new, Blocks.RED_NETHER_BRICKS);
        batch.addCopy("cracked_red_nether_bricks", Block::new, Blocks.RED_NETHER_BRICKS);

        batch.addCopy("red_nether_brick_fence", FenceBlock::new, Blocks.RED_NETHER_BRICKS);

        Block blueNetherBricks = batch.addCopy("blue_nether_bricks", Block::new, Blocks.RED_NETHER_BRICKS).getInitialValue();
        batch.addCopy("chiseled_blue_nether_bricks", Block::new, blueNetherBricks);
        batch.addCopy("cracked_blue_nether_bricks", Block::new, blueNetherBricks);

        batch.addCopy("blue_nether_brick_wall", WallBlock::new, blueNetherBricks);
        batch.addStairCopy("blue_nether_brick_stairs", blueNetherBricks);
        batch.addCopy("blue_nether_brick_slab", SlabBlock::new, blueNetherBricks);
        batch.addCopy("blue_nether_brick_fence", FenceBlock::new, blueNetherBricks);

        batch.register();
    }

    private static RegistrySupplier<WoodenChestBlock> addChestCopy(
            BlockRegistryBatch batch,
            String name,
            WoodenChestBlock.ModelType modelType,
            Block toCopy
    ) {
        return batch.add(name, new WoodenChestBlock(modelType, AbstractBlock.Settings.copy(toCopy)));
    }
}
