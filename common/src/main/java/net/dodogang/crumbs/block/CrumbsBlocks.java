package net.dodogang.crumbs.block;

import net.dodogang.crumbs.Crumbs;
import net.dodogang.plume.block.PlumeCraftingTableBlock;
import net.dodogang.plume.block.PlumeLadderBlock;
import net.dodogang.plume.registry.BlockRegistryBatch;
import net.minecraft.block.*;
import net.minecraft.item.Item;

import java.util.function.Function;

@SuppressWarnings("unused")
public class CrumbsBlocks {
    private static final BlockRegistryBatch BATCH = new BlockRegistryBatch(Crumbs.MOD_ID).setDefaultItemSettings(new Item.Settings().group(Crumbs.ITEM_GROUP));

    public static final Block OAK_BUNDLED_LOG = copy("oak_bundled_log", PillarBlock::new, Blocks.OAK_LOG);
    public static final Block SPRUCE_BUNDLED_LOG = copy("spruce_bundled_log", PillarBlock::new, Blocks.SPRUCE_LOG);
    public static final Block BIRCH_BUNDLED_LOG = copy("birch_bundled_log", PillarBlock::new, Blocks.BIRCH_LOG);
    public static final Block JUNGLE_BUNDLED_LOG = copy("jungle_bundled_log", PillarBlock::new, Blocks.JUNGLE_LOG);
    public static final Block ACACIA_BUNDLED_LOG = copy("acacia_bundled_log", PillarBlock::new, Blocks.ACACIA_LOG);
    public static final Block DARK_OAK_BUNDLED_LOG = copy("dark_oak_bundled_log", PillarBlock::new, Blocks.DARK_OAK_LOG);
    public static final Block CRIMSON_BUNDLED_STEM = copy("crimson_bundled_stem", PillarBlock::new, Blocks.CRIMSON_STEM);
    public static final Block WARPED_BUNDLED_STEM = copy("warped_bundled_stem", PillarBlock::new, Blocks.WARPED_STEM);

    public static final Block STRIPPED_OAK_BUNDLED_LOG = copy("stripped_oak_bundled_log", PillarBlock::new, Blocks.STRIPPED_OAK_LOG);
    public static final Block STRIPPED_SPRUCE_BUNDLED_LOG = copy("stripped_spruce_bundled_log", PillarBlock::new, Blocks.STRIPPED_SPRUCE_LOG);
    public static final Block STRIPPED_BIRCH_BUNDLED_LOG = copy("stripped_birch_bundled_log", PillarBlock::new, Blocks.STRIPPED_BIRCH_LOG);
    public static final Block STRIPPED_JUNGLE_BUNDLED_LOG = copy("stripped_jungle_bundled_log", PillarBlock::new, Blocks.STRIPPED_JUNGLE_LOG);
    public static final Block STRIPPED_ACACIA_BUNDLED_LOG = copy("stripped_acacia_bundled_log", PillarBlock::new, Blocks.STRIPPED_ACACIA_LOG);
    public static final Block STRIPPED_DARK_OAK_BUNDLED_LOG = copy("stripped_dark_oak_bundled_log", PillarBlock::new, Blocks.STRIPPED_DARK_OAK_LOG);
    public static final Block STRIPPED_CRIMSON_BUNDLED_STEM = copy("stripped_crimson_bundled_stem", PillarBlock::new, Blocks.STRIPPED_CRIMSON_STEM);
    public static final Block STRIPPED_WARPED_BUNDLED_STEM = copy("stripped_warped_bundled_stem", PillarBlock::new, Blocks.STRIPPED_WARPED_STEM);

    public static final Block OAK_TILE = copy("oak_tile", Blocks.OAK_PLANKS);
    public static final Block SPRUCE_TILE = copy("spruce_tile", Blocks.SPRUCE_PLANKS);
    public static final Block BIRCH_TILE = copy("birch_tile", Blocks.BIRCH_PLANKS);
    public static final Block JUNGLE_TILE = copy("jungle_tile", Blocks.JUNGLE_PLANKS);
    public static final Block ACACIA_TILE = copy("acacia_tile", Blocks.ACACIA_PLANKS);
    public static final Block DARK_OAK_TILE = copy("dark_oak_tile", Blocks.DARK_OAK_PLANKS);
    public static final Block CRIMSON_TILE = copy("crimson_tile", Blocks.CRIMSON_PLANKS);
    public static final Block WARPED_TILE = copy("warped_tile", Blocks.WARPED_PLANKS);

    public static final Block OAK_TILE_SLAB = createSlab("oak_tile", OAK_TILE);
    public static final Block SPRUCE_TILE_SLAB = createSlab("spruce_tile", SPRUCE_TILE);
    public static final Block BIRCH_TILE_SLAB = createSlab("birch_tile", BIRCH_TILE);
    public static final Block JUNGLE_TILE_SLAB = createSlab("jungle_tile", JUNGLE_TILE);
    public static final Block ACACIA_TILE_SLAB = createSlab("acacia_tile", ACACIA_TILE);
    public static final Block DARK_OAK_TILE_SLAB = createSlab("dark_oak_tile", DARK_OAK_TILE);
    public static final Block CRIMSON_TILE_SLAB = createSlab("crimson_tile", CRIMSON_TILE);
    public static final Block WARPED_TILE_SLAB = createSlab("warped_tile", WARPED_TILE);

    public static final Block REINFORCED_OAK_PLANKS = copy("reinforced_oak_planks", PillarBlock::new, Blocks.OAK_PLANKS);
    public static final Block REINFORCED_SPRUCE_PLANKS = copy("reinforced_spruce_planks", PillarBlock::new, Blocks.SPRUCE_PLANKS);
    public static final Block REINFORCED_BIRCH_PLANKS = copy("reinforced_birch_planks", PillarBlock::new, Blocks.BIRCH_PLANKS);
    public static final Block REINFORCED_JUNGLE_PLANKS = copy("reinforced_jungle_planks", PillarBlock::new, Blocks.JUNGLE_PLANKS);
    public static final Block REINFORCED_ACACIA_PLANKS = copy("reinforced_acacia_planks", PillarBlock::new, Blocks.ACACIA_PLANKS);
    public static final Block REINFORCED_DARK_OAK_PLANKS = copy("reinforced_dark_oak_planks", PillarBlock::new, Blocks.DARK_OAK_PLANKS);
    public static final Block REINFORCED_CRIMSON_PLANKS = copy("reinforced_crimson_planks", PillarBlock::new, Blocks.CRIMSON_PLANKS);
    public static final Block REINFORCED_WARPED_PLANKS = copy("reinforced_warped_planks", PillarBlock::new, Blocks.WARPED_PLANKS);

    public static final Block OAK_CHEST = createChest("oak_chest", WoodenChestBlock.ModelType.OAK, Blocks.CHEST);
    public static final Block SPRUCE_CHEST = createChest("spruce_chest", WoodenChestBlock.ModelType.SPRUCE, Blocks.CHEST);
    public static final Block BIRCH_CHEST = createChest("birch_chest", WoodenChestBlock.ModelType.BIRCH, Blocks.CHEST);
    public static final Block JUNGLE_CHEST = createChest("jungle_chest", WoodenChestBlock.ModelType.OAK, Blocks.CHEST);
    public static final Block ACACIA_CHEST = createChest("acacia_chest", WoodenChestBlock.ModelType.ACACIA, Blocks.CHEST);
    public static final Block DARK_OAK_CHEST = createChest("dark_oak_chest", WoodenChestBlock.ModelType.OAK, Blocks.CHEST);
    public static final Block CRIMSON_CHEST = createChest("crimson_chest", WoodenChestBlock.ModelType.CRIMSON, Blocks.CHEST);
    public static final Block WARPED_CHEST = createChest("warped_chest", WoodenChestBlock.ModelType.CRIMSON, Blocks.CHEST);

    public static final Block SPRUCE_CRAFTING_TABLE = copy("spruce_crafting_table", PlumeCraftingTableBlock::new, Blocks.SPRUCE_PLANKS);
    public static final Block BIRCH_CRAFTING_TABLE = copy("birch_crafting_table", PlumeCraftingTableBlock::new, Blocks.BIRCH_PLANKS);
    public static final Block JUNGLE_CRAFTING_TABLE = copy("jungle_crafting_table", PlumeCraftingTableBlock::new, Blocks.JUNGLE_PLANKS);
    public static final Block ACACIA_CRAFTING_TABLE = copy("acacia_crafting_table", PlumeCraftingTableBlock::new, Blocks.ACACIA_PLANKS);
    public static final Block DARK_OAK_CRAFTING_TABLE = copy("dark_oak_crafting_table", PlumeCraftingTableBlock::new, Blocks.DARK_OAK_PLANKS);
    public static final Block CRIMSON_CRAFTING_TABLE = copy("crimson_crafting_table", PlumeCraftingTableBlock::new, Blocks.CRIMSON_PLANKS);
    public static final Block WARPED_CRAFTING_TABLE = copy("warped_crafting_table", PlumeCraftingTableBlock::new, Blocks.WARPED_PLANKS);

    public static final Block OAK_BARREL = copy("oak_barrel", WoodenBarrelBlock::new, Blocks.OAK_PLANKS);
    public static final Block BIRCH_BARREL = copy("birch_barrel", WoodenBarrelBlock::new, Blocks.BIRCH_PLANKS);
    public static final Block JUNGLE_BARREL = copy("jungle_barrel", WoodenBarrelBlock::new, Blocks.JUNGLE_PLANKS);
    public static final Block ACACIA_BARREL = copy("acacia_barrel", WoodenBarrelBlock::new, Blocks.ACACIA_PLANKS);
    public static final Block DARK_OAK_BARREL = copy("dark_oak_barrel", WoodenBarrelBlock::new, Blocks.DARK_OAK_PLANKS);
    public static final Block CRIMSON_BARREL = copy("crimson_barrel", WoodenBarrelBlock::new, Blocks.CRIMSON_PLANKS);
    public static final Block WARPED_BARREL = copy("warped_barrel", WoodenBarrelBlock::new, Blocks.WARPED_PLANKS);

    public static final Block SPRUCE_BOOKSHELF = copy("spruce_bookshelf", Blocks.BOOKSHELF);
    public static final Block BIRCH_BOOKSHELF = copy("birch_bookshelf", Blocks.BOOKSHELF);
    public static final Block JUNGLE_BOOKSHELF = copy("jungle_bookshelf", Blocks.BOOKSHELF);
    public static final Block ACACIA_BOOKSHELF = copy("acacia_bookshelf", Blocks.BOOKSHELF);
    public static final Block DARK_OAK_BOOKSHELF = copy("dark_oak_bookshelf", Blocks.BOOKSHELF);
    public static final Block CRIMSON_BOOKSHELF = copy("crimson_bookshelf", Blocks.BOOKSHELF);
    public static final Block WARPED_BOOKSHELF = copy("warped_bookshelf", Blocks.BOOKSHELF);

    public static final Block OAK_LANTERN = copy("oak_lantern", WoodenLanternBlock::new, Blocks.OAK_PLANKS);
    public static final Block SPRUCE_LANTERN = copy("spruce_lantern", WoodenLanternBlock::new, Blocks.SPRUCE_PLANKS);
    public static final Block BIRCH_LANTERN = copy("birch_lantern", WoodenLanternBlock::new, Blocks.BIRCH_PLANKS);
    public static final Block JUNGLE_LANTERN = copy("jungle_lantern", WoodenLanternBlock::new, Blocks.JUNGLE_PLANKS);
    public static final Block ACACIA_LANTERN = copy("acacia_lantern", WoodenLanternBlock::new, Blocks.ACACIA_PLANKS);
    public static final Block DARK_OAK_LANTERN = copy("dark_oak_lantern", WoodenLanternBlock::new, Blocks.DARK_OAK_PLANKS);
    public static final Block CRIMSON_LANTERN = copy("crimson_lantern", WoodenLanternBlock::new, Blocks.CRIMSON_PLANKS);
    public static final Block WARPED_LANTERN = copy("warped_lantern", WoodenLanternBlock::new, Blocks.WARPED_PLANKS);

    public static final Block SPRUCE_LADDER = copy("spruce_ladder", PlumeLadderBlock::new, Blocks.LADDER);
    public static final Block BIRCH_LADDER = copy("birch_ladder", PlumeLadderBlock::new, Blocks.LADDER);
    public static final Block JUNGLE_LADDER = copy("jungle_ladder", PlumeLadderBlock::new, Blocks.LADDER);
    public static final Block ACACIA_LADDER = copy("acacia_ladder", PlumeLadderBlock::new, Blocks.LADDER);
    public static final Block DARK_OAK_LADDER = copy("dark_oak_ladder", PlumeLadderBlock::new, Blocks.LADDER);
    public static final Block CRIMSON_LADDER = copy("crimson_ladder", PlumeLadderBlock::new, Blocks.LADDER);
    public static final Block WARPED_LADDER = copy("warped_ladder", PlumeLadderBlock::new, Blocks.LADDER);

    public static final Block OAK_POST = copy("oak_post", WallBlock::new, Blocks.OAK_PLANKS);
    public static final Block SPRUCE_POST = copy("spruce_post", WallBlock::new, Blocks.SPRUCE_PLANKS);
    public static final Block BIRCH_POST = copy("birch_post", WallBlock::new, Blocks.BIRCH_PLANKS);
    public static final Block JUNGLE_POST = copy("jungle_post", WallBlock::new, Blocks.JUNGLE_PLANKS);
    public static final Block ACACIA_POST = copy("acacia_post", WallBlock::new, Blocks.ACACIA_PLANKS);
    public static final Block DARK_OAK_POST = copy("dark_oak_post", WallBlock::new, Blocks.DARK_OAK_PLANKS);
    public static final Block CRIMSON_POST = copy("crimson_post", WallBlock::new, Blocks.CRIMSON_PLANKS);
    public static final Block WARPED_POST = copy("warped_post", WallBlock::new, Blocks.WARPED_PLANKS);

    public static final Block STRIPPED_OAK_POST = copy("stripped_oak_post", WallBlock::new, Blocks.OAK_PLANKS);
    public static final Block STRIPPED_SPRUCE_POST = copy("stripped_spruce_post", WallBlock::new, Blocks.SPRUCE_PLANKS);
    public static final Block STRIPPED_BIRCH_POST = copy("stripped_birch_post", WallBlock::new, Blocks.BIRCH_PLANKS);
    public static final Block STRIPPED_JUNGLE_POST = copy("stripped_jungle_post", WallBlock::new, Blocks.JUNGLE_PLANKS);
    public static final Block STRIPPED_ACACIA_POST = copy("stripped_acacia_post", WallBlock::new, Blocks.ACACIA_PLANKS);
    public static final Block STRIPPED_DARK_OAK_POST = copy("stripped_dark_oak_post", WallBlock::new, Blocks.DARK_OAK_PLANKS);
    public static final Block STRIPPED_CRIMSON_POST = copy("stripped_crimson_post", WallBlock::new, Blocks.CRIMSON_PLANKS);
    public static final Block STRIPPED_WARPED_POST = copy("stripped_warped_post", WallBlock::new, Blocks.WARPED_PLANKS);

    public static final Block COBBLED_GRANITE = copy("cobbled_granite", Blocks.GRANITE);
    public static final Block CHISELED_POLISHED_GRANITE = copy("chiseled_polished_granite", Blocks.GRANITE);
    public static final Block BEVELED_POLISHED_GRANITE = copy("beveled_polished_granite", Blocks.GRANITE);
    public static final Block CRACKED_POLISHED_GRANITE = copy("cracked_polished_granite", Blocks.GRANITE);

    public static final Block COBBLED_DIORITE = copy("cobbled_diorite", Blocks.DIORITE);
    public static final Block CHISELED_POLISHED_DIORITE = copy("chiseled_polished_diorite", Blocks.DIORITE);
    public static final Block BEVELED_POLISHED_DIORITE = copy("beveled_polished_diorite", Blocks.DIORITE);
    public static final Block CRACKED_POLISHED_DIORITE = copy("cracked_polished_diorite", Blocks.DIORITE);

    public static final Block COBBLED_ANDESITE = copy("cobbled_andesite", Blocks.ANDESITE);
    public static final Block CHISELED_POLISHED_ANDESITE = copy("chiseled_polished_andesite", Blocks.ANDESITE);
    public static final Block BEVELED_POLISHED_ANDESITE = copy("beveled_polished_andesite", Blocks.ANDESITE);
    public static final Block CRACKED_POLISHED_ANDESITE = copy("cracked_polished_andesite", Blocks.ANDESITE);

    public static final Block BEVELED_POLISHED_BLACKSTONE = copy("beveled_polished_blackstone", Blocks.BLACKSTONE);
    public static final Block CRACKED_POLISHED_BLACKSTONE = copy("cracked_polished_blackstone", Blocks.BLACKSTONE);

    public static final Block COBBLED_GRANITE_WALL = createWall("cobbled_granite", COBBLED_GRANITE);
    public static final Block COBBLED_DIORITE_WALL = createWall("cobbled_diorite", COBBLED_DIORITE);
    public static final Block COBBLED_ANDESITE_WALL = createWall("cobbled_andesite", COBBLED_ANDESITE);

    public static final Block COBBLED_GRANITE_STAIRS = createStairs("cobbled_granite", COBBLED_GRANITE);
    public static final Block COBBLED_DIORITE_STAIRS = createStairs("cobbled_diorite", COBBLED_DIORITE);
    public static final Block COBBLED_ANDESITE_STAIRS = createStairs("cobbled_andesite", COBBLED_ANDESITE);

    public static final Block COBBLED_GRANITE_SLAB = createSlab("cobbled_granite", COBBLED_GRANITE);
    public static final Block COBBLED_DIORITE_SLAB = createSlab("cobbled_diorite", COBBLED_DIORITE);
    public static final Block COBBLED_ANDESITE_SLAB = createSlab("cobbled_andesite", COBBLED_ANDESITE);

    public static final Block SANDSTONE_TILE = copy("sandstone_tile", Blocks.SANDSTONE);
    public static final Block LARGE_SANDSTONE_TILE = copy("large_sandstone_tile", Blocks.SANDSTONE);

    public static final Block RED_SANDSTONE_TILE = copy("red_sandstone_tile", Blocks.RED_SANDSTONE);
    public static final Block LARGE_RED_SANDSTONE_TILE = copy("large_red_sandstone_tile", Blocks.RED_SANDSTONE);

    public static final Block SANDSTONE_TILE_WALL = createWall("sandstone_tile", SANDSTONE_TILE);
    public static final Block RED_SANDSTONE_TILE_WALL = createWall("red_sandstone_tile", RED_SANDSTONE_TILE);

    public static final Block SANDSTONE_TILE_SLAB = createSlab("sandstone_tile", SANDSTONE_TILE);
    public static final Block RED_SANDSTONE_TILE_SLAB = createSlab("red_sandstone_tile", RED_SANDSTONE_TILE);

    public static final Block SANDSTONE_TILE_STAIRS = createStairs("sandstone_tile", SANDSTONE_TILE);
    public static final Block RED_SANDSTONE_TILE_STAIRS = createStairs("red_sandstone_tile", RED_SANDSTONE_TILE);

    public static final Block CHISELED_RED_NETHER_BRICKS = copy("chiseled_red_nether_bricks", Blocks.RED_NETHER_BRICKS);
    public static final Block CRACKED_RED_NETHER_BRICKS = copy("cracked_red_nether_bricks", Blocks.RED_NETHER_BRICKS);

    public static final Block RED_NETHER_BRICK_FENCE = createFence("red_nether_brick", Blocks.RED_NETHER_BRICKS);

    public static final Block BLUE_NETHER_BRICKS = copy("blue_nether_bricks", Blocks.RED_NETHER_BRICKS);
    public static final Block CHISELED_BLUE_NETHER_BRICKS = copy("chiseled_blue_nether_bricks", BLUE_NETHER_BRICKS);
    public static final Block CRACKED_BLUE_NETHER_BRICKS = copy("cracked_blue_nether_bricks", BLUE_NETHER_BRICKS);

    public static final Block BLUE_NETHER_BRICK_WALL = createWall("blue_nether_brick", BLUE_NETHER_BRICKS);
    public static final Block BLUE_NETHER_BRICK_STAIRS = createStairs("blue_nether_brick", BLUE_NETHER_BRICKS);
    public static final Block BLUE_NETHER_BRICK_SLAB = createSlab("blue_nether_brick", BLUE_NETHER_BRICKS);
    public static final Block BLUE_NETHER_BRICK_FENCE = createFence("blue_nether_brick", BLUE_NETHER_BRICKS);

    static {
        BATCH.register();
    }

    private static Block register(String id, Block block) {
        return BATCH.add(id, block);
    }

    private static <B extends Block> Block copy(String id, Function<AbstractBlock.Settings, B> blockFunction, Block copy) {
        return BATCH.addCopy(id, blockFunction, copy);
    }
    private static Block copy(String id, Block copy) {
        return copy(id, Block::new, copy);
    }

    private static Block createSlab(String id, Block block) {
        return copy(String.format("%s_slab", id), SlabBlock::new, block);
    }
    private static Block createWall(String id, Block block) {
        return copy(String.format("%s_wall", id), WallBlock::new, block);
    }
    private static Block createStairs(String id, Block block) {
        return BATCH.addStairCopy(String.format("%s_stairs", id), block);
    }
    private static Block createFence(String id, Block block) {
        return copy(String.format("%s_fence", id), FenceBlock::new, block);
    }
    private static Block createChest(String id, WoodenChestBlock.ModelType modelType, Block copy) {
        return BATCH.add(id, new WoodenChestBlock(modelType, AbstractBlock.Settings.copy(copy)));
    }
}
