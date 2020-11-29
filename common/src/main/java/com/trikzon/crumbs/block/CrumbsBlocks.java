package com.trikzon.crumbs.block;

import com.trikzon.crumbs.CrumbsCore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Function;

public class CrumbsBlocks {
    public static final Item.Properties DEFAULT_PROPS = new Item.Properties().tab(CrumbsCore.creativeTab);

    // Bundled Logs
    public static final Block OAK_BUNDLED_LOG = registerCopy("oak_bundled_log", RotatedPillarBlock::new, Blocks.OAK_LOG);
    public static final Block BIRCH_BUNDLED_LOG = registerCopy("birch_bundled_log", RotatedPillarBlock::new, Blocks.BIRCH_LOG);
    public static final Block SPRUCE_BUNDLED_LOG = registerCopy("spruce_bundled_log", RotatedPillarBlock::new, Blocks.SPRUCE_LOG);
    public static final Block JUNGLE_BUNDLED_LOG = registerCopy("jungle_bundled_log", RotatedPillarBlock::new, Blocks.JUNGLE_LOG);
    public static final Block ACACIA_BUNDLED_LOG = registerCopy("acacia_bundled_log", RotatedPillarBlock::new, Blocks.ACACIA_LOG);
    public static final Block DARK_OAK_BUNDLED_LOG = registerCopy("dark_oak_bundled_log", RotatedPillarBlock::new, Blocks.DARK_OAK_LOG);
    public static final Block CRIMSON_BUNDLED_STEM = registerCopy("crimson_bundled_stem", RotatedPillarBlock::new, Blocks.CRIMSON_STEM);
    public static final Block WARPED_BUNDLED_STEM = registerCopy("warped_bundled_stem", RotatedPillarBlock::new, Blocks.WARPED_STEM);

    public static final Block STRIPPED_OAK_BUNDLED_LOG = registerCopy("stripped_oak_bundled_log", RotatedPillarBlock::new, Blocks.STRIPPED_OAK_LOG);
    public static final Block STRIPPED_BIRCH_BUNDLED_LOG = registerCopy("stripped_birch_bundled_log", RotatedPillarBlock::new, Blocks.STRIPPED_BIRCH_LOG);
    public static final Block STRIPPED_SPRUCE_BUNDLED_LOG = registerCopy("stripped_spruce_bundled_log", RotatedPillarBlock::new, Blocks.STRIPPED_SPRUCE_LOG);
    public static final Block STRIPPED_JUNGLE_BUNDLED_LOG = registerCopy("stripped_jungle_bundled_log", RotatedPillarBlock::new, Blocks.STRIPPED_JUNGLE_LOG);
    public static final Block STRIPPED_ACACIA_BUNDLED_LOG = registerCopy("stripped_acacia_bundled_log", RotatedPillarBlock::new, Blocks.STRIPPED_ACACIA_LOG);
    public static final Block STRIPPED_DARK_OAK_BUNDLED_LOG = registerCopy("stripped_dark_oak_bundled_log", RotatedPillarBlock::new, Blocks.STRIPPED_DARK_OAK_LOG);
    public static final Block STRIPPED_CRIMSON_BUNDLED_STEM = registerCopy("stripped_crimson_bundled_stem", RotatedPillarBlock::new, Blocks.STRIPPED_CRIMSON_STEM);
    public static final Block STRIPPED_WARPED_BUNDLED_STEM = registerCopy("stripped_warped_bundled_stem", RotatedPillarBlock::new, Blocks.STRIPPED_WARPED_STEM);

    // Wooden Blocks
    public static final Block OAK_TILE = registerCopy("oak_tile", Block::new, Blocks.OAK_PLANKS);
    public static final Block SPRUCE_TILE = registerCopy("spruce_tile", Block::new, Blocks.SPRUCE_PLANKS);
    public static final Block BIRCH_TILE = registerCopy("birch_tile", Block::new, Blocks.BIRCH_PLANKS);
    public static final Block JUNGLE_TILE = registerCopy("jungle_tile", Block::new, Blocks.JUNGLE_PLANKS);
    public static final Block ACACIA_TILE = registerCopy("acacia_tile", Block::new, Blocks.ACACIA_PLANKS);
    public static final Block DARK_OAK_TILE = registerCopy("dark_oak_tile", Block::new, Blocks.DARK_OAK_PLANKS);
    public static final Block CRIMSON_TILE = registerCopy("crimson_tile", Block::new, Blocks.WARPED_PLANKS);
    public static final Block WARPED_TILE = registerCopy("warped_tile", Block::new, Blocks.WARPED_PLANKS);

    public static final Block OAK_TILE_SLAB = registerCopy("oak_tile_slab", SlabBlock::new, OAK_TILE);
    public static final Block SPRUCE_TILE_SLAB = registerCopy("spruce_tile_slab", SlabBlock::new, SPRUCE_TILE);
    public static final Block BIRCH_TILE_SLAB = registerCopy("birch_tile_slab", SlabBlock::new, BIRCH_TILE);
    public static final Block JUNGLE_TILE_SLAB = registerCopy("jungle_tile_slab", SlabBlock::new, JUNGLE_TILE);
    public static final Block ACACIA_TILE_SLAB = registerCopy("acacia_tile_slab", SlabBlock::new, ACACIA_TILE);
    public static final Block DARK_OAK_TILE_SLAB = registerCopy("dark_oak_tile_slab", SlabBlock::new, DARK_OAK_TILE);
    public static final Block CRIMSON_TILE_SLAB = registerCopy("crimson_tile_slab", SlabBlock::new, CRIMSON_TILE);
    public static final Block WARPED_TILE_SLAB = registerCopy("warped_tile_slab", SlabBlock::new, WARPED_TILE);

    public static final Block REINFORCED_OAK_PLANKS = registerCopy("reinforced_oak_planks", RotatedPillarBlock::new, Blocks.OAK_PLANKS);
    public static final Block REINFORCED_SPRUCE_PLANKS = registerCopy("reinforced_spruce_planks", RotatedPillarBlock::new, Blocks.SPRUCE_PLANKS);
    public static final Block REINFORCED_BIRCH_PLANKS = registerCopy("reinforced_birch_planks", RotatedPillarBlock::new, Blocks.BIRCH_PLANKS);
    public static final Block REINFORCED_JUNGLE_PLANKS = registerCopy("reinforced_jungle_planks", RotatedPillarBlock::new, Blocks.JUNGLE_PLANKS);
    public static final Block REINFORCED_ACACIA_PLANKS = registerCopy("reinforced_acacia_planks", RotatedPillarBlock::new, Blocks.ACACIA_PLANKS);
    public static final Block REINFORCED_DARK_OAK_PLANKS = registerCopy("reinforced_dark_oak_planks", RotatedPillarBlock::new, Blocks.DARK_OAK_PLANKS);
    public static final Block REINFORCED_CRIMSON_PLANKS = registerCopy("reinforced_crimson_planks", RotatedPillarBlock::new, Blocks.CRIMSON_PLANKS);
    public static final Block REINFORCED_WARPED_PLANKS = registerCopy("reinforced_warped_planks", RotatedPillarBlock::new, Blocks.WARPED_PLANKS);

    public static final Block SPRUCE_CRAFTING_TABLE = registerCopy("spruce_crafting_table", CrumbsCraftingTableBlock::new, Blocks.SPRUCE_PLANKS);
    public static final Block BIRCH_CRAFTING_TABLE = registerCopy("birch_crafting_table", CrumbsCraftingTableBlock::new, Blocks.BIRCH_PLANKS);
    public static final Block JUNGLE_CRAFTING_TABLE = registerCopy("jungle_crafting_table", CrumbsCraftingTableBlock::new, Blocks.JUNGLE_PLANKS);
    public static final Block ACACIA_CRAFTING_TABLE = registerCopy("acacia_crafting_table", CrumbsCraftingTableBlock::new, Blocks.ACACIA_PLANKS);
    public static final Block DARK_OAK_CRAFTING_TABLE = registerCopy("dark_oak_crafting_table", CrumbsCraftingTableBlock::new, Blocks.DARK_OAK_PLANKS);
    public static final Block CRIMSON_CRAFTING_TABLE = registerCopy("crimson_crafting_table", CrumbsCraftingTableBlock::new, Blocks.CRIMSON_PLANKS);
    public static final Block WARPED_CRAFTING_TABLE = registerCopy("warped_crafting_table", CrumbsCraftingTableBlock::new, Blocks.WARPED_PLANKS);

    public static final Block OAK_BARREL = registerCopy("oak_barrel", CrumbsBarrelBlock::new, Blocks.OAK_PLANKS);
    public static final Block BIRCH_BARREL = registerCopy("birch_barrel", CrumbsBarrelBlock::new, Blocks.BIRCH_PLANKS);
    public static final Block JUNGLE_BARREL = registerCopy("jungle_barrel", CrumbsBarrelBlock::new, Blocks.JUNGLE_PLANKS);
    public static final Block ACACIA_BARREL = registerCopy("acacia_barrel", CrumbsBarrelBlock::new, Blocks.ACACIA_PLANKS);
    public static final Block DARK_OAK_BARREL = registerCopy("dark_oak_barrel", CrumbsBarrelBlock::new, Blocks.DARK_OAK_PLANKS);
    public static final Block CRIMSON_BARREL = registerCopy("crimson_barrel", CrumbsBarrelBlock::new, Blocks.CRIMSON_PLANKS);
    public static final Block WARPED_BARREL = registerCopy("warped_barrel", CrumbsBarrelBlock::new, Blocks.WARPED_PLANKS);

    public static final Block OAK_LANTERN = registerCopy("oak_lantern", WoodLanternBlock::new, Blocks.OAK_PLANKS);
    public static final Block SPRUCE_LANTERN = registerCopy("spruce_lantern", WoodLanternBlock::new, Blocks.SPRUCE_PLANKS);
    public static final Block BIRCH_LANTERN = registerCopy("birch_lantern", WoodLanternBlock::new, Blocks.BIRCH_PLANKS);
    public static final Block JUNGLE_LANTERN = registerCopy("jungle_lantern", WoodLanternBlock::new, Blocks.JUNGLE_PLANKS);
    public static final Block ACACIA_LANTERN = registerCopy("acacia_lantern", WoodLanternBlock::new, Blocks.ACACIA_PLANKS);
    public static final Block DARK_OAK_LANTERN = registerCopy("dark_oak_lantern", WoodLanternBlock::new, Blocks.DARK_OAK_PLANKS);
    public static final Block CRIMSON_LANTERN = registerCopy("crimson_lantern", WoodLanternBlock::new, Blocks.CRIMSON_PLANKS);
    public static final Block WARPED_LANTERN = registerCopy("warped_lantern", WoodLanternBlock::new, Blocks.WARPED_PLANKS);

    // Stone Blocks
    public static final Block COBBLED_GRANITE = registerCopy("cobbled_granite", Block::new, Blocks.GRANITE);
    public static final Block CHISELED_POLISHED_GRANITE = registerCopy("chiseled_polished_granite", Block::new, Blocks.GRANITE);
    public static final Block BEVELED_POLISHED_GRANITE = registerCopy("beveled_polished_granite", Block::new, Blocks.GRANITE);
    public static final Block CRACKED_POLISHED_GRANITE = registerCopy("cracked_polished_granite", Block::new, Blocks.GRANITE);

    public static final Block COBBLED_DIORITE = registerCopy("cobbled_diorite", Block::new, Blocks.DIORITE);
    public static final Block CHISELED_POLISHED_DIORITE = registerCopy("chiseled_polished_diorite", Block::new, Blocks.DIORITE);
    public static final Block BEVELED_POLISHED_DIORITE = registerCopy("beveled_polished_diorite", Block::new, Blocks.DIORITE);
    public static final Block CRACKED_POLISHED_DIORITE = registerCopy("cracked_polished_diorite", Block::new, Blocks.DIORITE);

    public static final Block COBBLED_ANDESITE = registerCopy("cobbled_andesite", Block::new, Blocks.ANDESITE);
    public static final Block CHISELED_POLISHED_ANDESITE = registerCopy("chiseled_polished_andesite", Block::new, Blocks.ANDESITE);
    public static final Block BEVELED_POLISHED_ANDESITE = registerCopy("beveled_polished_andesite", Block::new, Blocks.ANDESITE);
    public static final Block CRACKED_POLISHED_ANDESITE = registerCopy("cracked_polished_andesite", Block::new, Blocks.ANDESITE);

    public static final Block BEVELED_POLISHED_BLACKSTONE = registerCopy("beveled_polished_blackstone", Block::new, Blocks.BLACKSTONE);
    public static final Block CRACKED_POLISHED_BLACKSTONE = registerCopy("cracked_polished_blackstone", Block::new, Blocks.BLACKSTONE);

    public static final Block COBBLED_GRANITE_WALL = registerCopy("cobbled_granite_wall", WallBlock::new, COBBLED_GRANITE);
    public static final Block COBBLED_DIORITE_WALL = registerCopy("cobbled_diorite_wall", WallBlock::new, COBBLED_DIORITE);
    public static final Block COBBLED_ANDESITE_WALL = registerCopy("cobbled_andesite_wall", WallBlock::new, COBBLED_ANDESITE);

    public static final Block COBBLED_GRANITE_STAIRS = registerStairCopy("cobbled_granite_stairs", COBBLED_GRANITE);
    public static final Block COBBLED_DIORITE_STAIRS = registerStairCopy("cobbled_diorite_stairs", COBBLED_DIORITE);
    public static final Block COBBLED_ANDESITE_STAIRS = registerStairCopy("cobbled_andesite_stairs", COBBLED_ANDESITE);

    public static final Block COBBLED_GRANITE_SLAB = registerCopy("cobbled_granite_slab", SlabBlock::new, COBBLED_GRANITE);
    public static final Block COBBLED_DIORITE_SLAB = registerCopy("cobbled_diorite_slab", SlabBlock::new, COBBLED_DIORITE);
    public static final Block COBBLED_ANDESITE_SLAB = registerCopy("cobbled_andesite_slab", SlabBlock::new, COBBLED_ANDESITE);

    // Sand Blocks
    public static final Block SANDSTONE_TILE = registerCopy("sandstone_tile", Block::new, Blocks.SANDSTONE);
    public static final Block LARGE_SANDSTONE_TILE = registerCopy("large_sandstone_tile", Block::new, Blocks.SANDSTONE);

    public static final Block RED_SANDSTONE_TILE = registerCopy("red_sandstone_tile", Block::new, Blocks.RED_SANDSTONE);
    public static final Block LARGE_RED_SANDSTONE_TILE = registerCopy("large_red_sandstone_tile", Block::new, Blocks.RED_SANDSTONE);

    public static final Block SANDSTONE_TILE_WALL = registerCopy("sandstone_tile_wall", WallBlock::new, SANDSTONE_TILE);
    public static final Block SANDSTONE_RED_TILE_WALL = registerCopy("red_sandstone_tile_wall", WallBlock::new, RED_SANDSTONE_TILE);

    public static final Block SANDSTONE_TILE_SLAB = registerCopy("sandstone_tile_slab", SlabBlock::new, SANDSTONE_TILE);
    public static final Block RED_SANDSTONE_TILE_SLAB = registerCopy("red_sandstone_tile_slab", SlabBlock::new, RED_SANDSTONE_TILE);

    public static final Block SANDSTONE_TILE_STAIRS = registerStairCopy("sandstone_tile_stairs", SANDSTONE_TILE);
    public static final Block RED_SANDSTONE_TILE_STAIRS = registerStairCopy("red_sandstone_tile_stairs", RED_SANDSTONE_TILE);

    // Nether Bricks
    public static final Block CHISELED_RED_NETHER_BRICKS = registerCopy("chiseled_red_nether_bricks", Block::new, Blocks.NETHER_BRICKS);
    public static final Block CRACKED_RED_NETHER_BRICKS = registerCopy("cracked_red_nether_bricks", Block::new, Blocks.NETHER_BRICKS);

    public static final Block BLUE_NETHER_BRICKS = registerCopy("blue_nether_bricks", Block::new, Blocks.NETHER_BRICKS);
    public static final Block CHISELED_BLUE_NETHER_BRICKS = registerCopy("chiseled_blue_nether_bricks", Block::new, Blocks.NETHER_BRICKS);
    public static final Block CRACKED_BLUE_NETHER_BRICKS = registerCopy("cracked_blue_nether_bricks", Block::new, Blocks.NETHER_BRICKS);

    public static final Block BLUE_NETHER_BRICK_WALL = registerCopy("blue_nether_brick_wall", WallBlock::new, BLUE_NETHER_BRICKS);
    public static final Block BLUE_NETHER_BRICK_STAIRS = registerStairCopy("blue_nether_brick_stairs", BLUE_NETHER_BRICKS);
    public static final Block BLUE_NETHER_BRICK_SLAB = registerCopy("blue_nether_brick_slab", SlabBlock::new, BLUE_NETHER_BRICKS);

    private static <T extends Block> T registerStairCopy(String name, Block toCopy) {
        return (T) register(name, new PublicStairBlock(toCopy.defaultBlockState(), BlockBehaviour.Properties.copy(toCopy)));
    }

    private static <T extends Block> T registerCopy(String name, Function<BlockBehaviour.Properties, T> block, BlockBehaviour toCopy) {
        return register(name, block.apply(BlockBehaviour.Properties.copy(toCopy)));
    }

    private static <T extends Block> T register(String name, T block) {
        return register(name, block, DEFAULT_PROPS);
    }

    private static <T extends Block> T register(String name, T block, Item.Properties properties) {
        ResourceLocation id = CrumbsCore.getId(name);
        CrumbsCore.platform.registerBlock(id, block);
        if (properties != null) CrumbsCore.platform.registerItem(id, new BlockItem(block, properties));
        return block;
    }

    private static class PublicStairBlock extends StairBlock {
        public PublicStairBlock(BlockState blockState, Properties properties) {
            super(blockState, properties);
        }
    }
}
