package net.dodogang.crumbs.block;

import net.dodogang.ash.registry.BatchedRegister;
import net.dodogang.ash.registry.RegistrySupplier;
import net.dodogang.crumbs.Crumbs;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class CrumbsBlocks {
    private CrumbsBlocks() {}

    public static final Item.Settings DEFAULT_SETTINGS = new Item.Settings().group(Crumbs.itemGroup);

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

    public static RegistrySupplier<CrumbsChestBlock> SPRUCE_CHEST;
    public static RegistrySupplier<CrumbsChestBlock> BIRCH_CHEST;
    public static RegistrySupplier<CrumbsChestBlock> JUNGLE_CHEST;
    public static RegistrySupplier<CrumbsChestBlock> ACACIA_CHEST;
    public static RegistrySupplier<CrumbsChestBlock> DARK_OAK_CHEST;
    public static RegistrySupplier<CrumbsChestBlock> CRIMSON_CHEST;
    public static RegistrySupplier<CrumbsChestBlock> WARPED_CHEST;

    public static void register() {
        BlockItemRegistry registry = new BlockItemRegistry();

        // Bundled Logs
        OAK_BUNDLED_LOG = registry.registerCopy("oak_bundled_log", PillarBlock::new, Blocks.OAK_LOG);
        SPRUCE_BUNDLED_LOG = registry.registerCopy("spruce_bundled_log", PillarBlock::new, Blocks.SPRUCE_LOG);
        BIRCH_BUNDLED_LOG = registry.registerCopy("birch_bundled_log", PillarBlock::new, Blocks.BIRCH_LOG);
        JUNGLE_BUNDLED_LOG = registry.registerCopy("jungle_bundled_log", PillarBlock::new, Blocks.JUNGLE_LOG);
        ACACIA_BUNDLED_LOG = registry.registerCopy("acacia_bundled_log", PillarBlock::new, Blocks.ACACIA_LOG);
        DARK_OAK_BUNDLED_LOG = registry.registerCopy("dark_oak_bundled_log", PillarBlock::new, Blocks.DARK_OAK_LOG);
        CRIMSON_BUNDLED_STEM = registry.registerCopy("crimson_bundled_stem", PillarBlock::new, Blocks.CRIMSON_STEM);
        WARPED_BUNDLED_STEM = registry.registerCopy("warped_bundled_stem", PillarBlock::new, Blocks.WARPED_STEM);

        STRIPPED_OAK_BUNDLED_LOG = registry.registerCopy("stripped_oak_bundled_log", PillarBlock::new, Blocks.STRIPPED_OAK_LOG);
        STRIPPED_SPRUCE_BUNDLED_LOG = registry.registerCopy("stripped_spruce_bundled_log", PillarBlock::new, Blocks.STRIPPED_SPRUCE_LOG);
        STRIPPED_BIRCH_BUNDLED_LOG = registry.registerCopy("stripped_birch_bundled_log", PillarBlock::new, Blocks.STRIPPED_BIRCH_LOG);
        STRIPPED_JUNGLE_BUNDLED_LOG = registry.registerCopy("stripped_jungle_bundled_log", PillarBlock::new, Blocks.STRIPPED_JUNGLE_LOG);
        STRIPPED_ACACIA_BUNDLED_LOG = registry.registerCopy("stripped_acacia_bundled_log", PillarBlock::new, Blocks.STRIPPED_ACACIA_LOG);
        STRIPPED_DARK_OAK_BUNDLED_LOG = registry.registerCopy("stripped_dark_oak_bundled_log", PillarBlock::new, Blocks.STRIPPED_DARK_OAK_LOG);
        STRIPPED_CRIMSON_BUNDLED_STEM = registry.registerCopy("stripped_crimson_bundled_stem", PillarBlock::new, Blocks.STRIPPED_CRIMSON_STEM);
        STRIPPED_WARPED_BUNDLED_STEM = registry.registerCopy("stripped_warped_bundled_stem", PillarBlock::new, Blocks.STRIPPED_WARPED_STEM);

        // Wooden Blocks
        Block OAK_TILE = registry.registerCopy("oak_tile", Block::new, Blocks.OAK_PLANKS).getEarly();
        Block SPRUCE_TILE = registry.registerCopy("spruce_tile", Block::new, Blocks.SPRUCE_PLANKS).getEarly();
        Block BIRCH_TILE = registry.registerCopy("birch_tile", Block::new, Blocks.BIRCH_PLANKS).getEarly();
        Block JUNGLE_TILE = registry.registerCopy("jungle_tile", Block::new, Blocks.JUNGLE_PLANKS).getEarly();
        Block ACACIA_TILE = registry.registerCopy("acacia_tile", Block::new, Blocks.ACACIA_PLANKS).getEarly();
        Block DARK_OAK_TILE = registry.registerCopy("dark_oak_tile", Block::new, Blocks.DARK_OAK_PLANKS).getEarly();
        Block CRIMSON_TILE = registry.registerCopy("crimson_tile", Block::new, Blocks.WARPED_PLANKS).getEarly();
        Block WARPED_TILE = registry.registerCopy("warped_tile", Block::new, Blocks.WARPED_PLANKS).getEarly();

        registry.registerCopy("oak_tile_slab", SlabBlock::new, OAK_TILE);
        registry.registerCopy("spruce_tile_slab", SlabBlock::new, SPRUCE_TILE);
        registry.registerCopy("birch_tile_slab", SlabBlock::new, BIRCH_TILE);
        registry.registerCopy("jungle_tile_slab", SlabBlock::new, JUNGLE_TILE);
        registry.registerCopy("acacia_tile_slab", SlabBlock::new, ACACIA_TILE);
        registry.registerCopy("dark_oak_tile_slab", SlabBlock::new, DARK_OAK_TILE);
        registry.registerCopy("crimson_tile_slab", SlabBlock::new, CRIMSON_TILE);
        registry.registerCopy("warped_tile_slab", SlabBlock::new, WARPED_TILE);

        registry.registerCopy("reinforced_oak_planks", PillarBlock::new, Blocks.OAK_PLANKS);
        registry.registerCopy("reinforced_spruce_planks", PillarBlock::new, Blocks.SPRUCE_PLANKS);
        registry.registerCopy("reinforced_birch_planks", PillarBlock::new, Blocks.BIRCH_PLANKS);
        registry.registerCopy("reinforced_jungle_planks", PillarBlock::new, Blocks.JUNGLE_PLANKS);
        registry.registerCopy("reinforced_acacia_planks", PillarBlock::new, Blocks.ACACIA_PLANKS);
        registry.registerCopy("reinforced_dark_oak_planks", PillarBlock::new, Blocks.DARK_OAK_PLANKS);
        registry.registerCopy("reinforced_crimson_planks", PillarBlock::new, Blocks.CRIMSON_PLANKS);
        registry.registerCopy("reinforced_warped_planks", PillarBlock::new, Blocks.WARPED_PLANKS);

        registry.registerCopy("spruce_crafting_table", CrumbsCraftingTableBlock::new, Blocks.SPRUCE_PLANKS);
        registry.registerCopy("birch_crafting_table", CrumbsCraftingTableBlock::new, Blocks.BIRCH_PLANKS);
        registry.registerCopy("jungle_crafting_table", CrumbsCraftingTableBlock::new, Blocks.JUNGLE_PLANKS);
        registry.registerCopy("acacia_crafting_table", CrumbsCraftingTableBlock::new, Blocks.ACACIA_PLANKS);
        registry.registerCopy("dark_oak_crafting_table", CrumbsCraftingTableBlock::new, Blocks.DARK_OAK_PLANKS);
        registry.registerCopy("crimson_crafting_table", CrumbsCraftingTableBlock::new, Blocks.CRIMSON_PLANKS);
        registry.registerCopy("warped_crafting_table", CrumbsCraftingTableBlock::new, Blocks.WARPED_PLANKS);

        registry.registerCopy("oak_barrel", CrumbsBarrelBlock::new, Blocks.OAK_PLANKS);
        registry.registerCopy("birch_barrel", CrumbsBarrelBlock::new, Blocks.BIRCH_PLANKS);
        registry.registerCopy("jungle_barrel", CrumbsBarrelBlock::new, Blocks.JUNGLE_PLANKS);
        registry.registerCopy("acacia_barrel", CrumbsBarrelBlock::new, Blocks.ACACIA_PLANKS);
        registry.registerCopy("dark_oak_barrel", CrumbsBarrelBlock::new, Blocks.DARK_OAK_PLANKS);
        registry.registerCopy("crimson_barrel", CrumbsBarrelBlock::new, Blocks.CRIMSON_PLANKS);
        registry.registerCopy("warped_barrel", CrumbsBarrelBlock::new, Blocks.WARPED_PLANKS);

        registry.registerCopy("oak_lantern", WoodLanternBlock::new, Blocks.OAK_PLANKS);
        registry.registerCopy("spruce_lantern", WoodLanternBlock::new, Blocks.SPRUCE_PLANKS);
        registry.registerCopy("birch_lantern", WoodLanternBlock::new, Blocks.BIRCH_PLANKS);
        registry.registerCopy("jungle_lantern", WoodLanternBlock::new, Blocks.JUNGLE_PLANKS);
        registry.registerCopy("acacia_lantern", WoodLanternBlock::new, Blocks.ACACIA_PLANKS);
        registry.registerCopy("dark_oak_lantern", WoodLanternBlock::new, Blocks.DARK_OAK_PLANKS);
        registry.registerCopy("crimson_lantern", WoodLanternBlock::new, Blocks.CRIMSON_PLANKS);
        registry.registerCopy("warped_lantern", WoodLanternBlock::new, Blocks.WARPED_PLANKS);

        SPRUCE_CHEST = registry.registerChestCopy("spruce_chest", CrumbsChestBlock.ModelType.SPRUCE, Blocks.SPRUCE_PLANKS);
        BIRCH_CHEST = registry.registerChestCopy("birch_chest", CrumbsChestBlock.ModelType.BIRCH, Blocks.BIRCH_PLANKS);
        JUNGLE_CHEST = registry.registerChestCopy("jungle_chest", CrumbsChestBlock.ModelType.OAK, Blocks.JUNGLE_PLANKS);
        ACACIA_CHEST = registry.registerChestCopy("acacia_chest", CrumbsChestBlock.ModelType.ACACIA, Blocks.ACACIA_PLANKS);
        DARK_OAK_CHEST = registry.registerChestCopy("dark_oak_chest", CrumbsChestBlock.ModelType.OAK, Blocks.DARK_OAK_PLANKS);
        CRIMSON_CHEST = registry.registerChestCopy("crimson_chest", CrumbsChestBlock.ModelType.CRIMSON, Blocks.CRIMSON_PLANKS);
        WARPED_CHEST = registry.registerChestCopy("warped_chest", CrumbsChestBlock.ModelType.CRIMSON, Blocks.WARPED_PLANKS);

        // Stone Blocks
        Block COBBLED_GRANITE = registry.registerCopy("cobbled_granite", Block::new, Blocks.GRANITE).getEarly();
        registry.registerCopy("chiseled_polished_granite", Block::new, Blocks.GRANITE);
        registry.registerCopy("beveled_polished_granite", Block::new, Blocks.GRANITE);
        registry.registerCopy("cracked_polished_granite", Block::new, Blocks.GRANITE);

        Block COBBLED_DIORITE = registry.registerCopy("cobbled_diorite", Block::new, Blocks.DIORITE).getEarly();
        registry.registerCopy("chiseled_polished_diorite", Block::new, Blocks.DIORITE);
        registry.registerCopy("beveled_polished_diorite", Block::new, Blocks.DIORITE);
        registry.registerCopy("cracked_polished_diorite", Block::new, Blocks.DIORITE);

        Block COBBLED_ANDESITE = registry.registerCopy("cobbled_andesite", Block::new, Blocks.ANDESITE).getEarly();
        registry.registerCopy("chiseled_polished_andesite", Block::new, Blocks.ANDESITE);
        registry.registerCopy("beveled_polished_andesite", Block::new, Blocks.ANDESITE);
        registry.registerCopy("cracked_polished_andesite", Block::new, Blocks.ANDESITE);

        registry.registerCopy("beveled_polished_blackstone", Block::new, Blocks.BLACKSTONE);
        registry.registerCopy("cracked_polished_blackstone", Block::new, Blocks.BLACKSTONE);

        registry.registerCopy("cobbled_granite_wall", WallBlock::new, COBBLED_GRANITE);
        registry.registerCopy("cobbled_diorite_wall", WallBlock::new, COBBLED_DIORITE);
        registry.registerCopy("cobbled_andesite_wall", WallBlock::new, COBBLED_ANDESITE);

        registry.registerStairCopy("cobbled_granite_stairs", COBBLED_GRANITE);
        registry.registerStairCopy("cobbled_diorite_stairs", COBBLED_DIORITE);
        registry.registerStairCopy("cobbled_andesite_stairs", COBBLED_ANDESITE);

        registry.registerCopy("cobbled_granite_slab", SlabBlock::new, COBBLED_GRANITE);
        registry.registerCopy("cobbled_diorite_slab", SlabBlock::new, COBBLED_DIORITE);
        registry.registerCopy("cobbled_andesite_slab", SlabBlock::new, COBBLED_ANDESITE);

        // Sand Blocks
        Block SANDSTONE_TILE = registry.registerCopy("sandstone_tile", Block::new, Blocks.SANDSTONE).getEarly();
        registry.registerCopy("large_sandstone_tile", Block::new, Blocks.SANDSTONE);

        Block RED_SANDSTONE_TILE = registry.registerCopy("red_sandstone_tile", Block::new, Blocks.RED_SANDSTONE).getEarly();
        registry.registerCopy("large_red_sandstone_tile", Block::new, Blocks.RED_SANDSTONE);

        registry.registerCopy("sandstone_tile_wall", WallBlock::new, SANDSTONE_TILE);
        registry.registerCopy("red_sandstone_tile_wall", WallBlock::new, RED_SANDSTONE_TILE);

        registry.registerCopy("sandstone_tile_slab", SlabBlock::new, SANDSTONE_TILE);
        registry.registerCopy("red_sandstone_tile_slab", SlabBlock::new, RED_SANDSTONE_TILE);

        registry.registerStairCopy("sandstone_tile_stairs", SANDSTONE_TILE);
        registry.registerStairCopy("red_sandstone_tile_stairs", RED_SANDSTONE_TILE);

        // Nether Bricks
        registry.registerCopy("chiseled_red_nether_bricks", Block::new, Blocks.RED_NETHER_BRICKS);
        registry.registerCopy("cracked_red_nether_bricks", Block::new, Blocks.RED_NETHER_BRICKS);

        registry.registerCopy("red_nether_brick_fence", FenceBlock::new, Blocks.RED_NETHER_BRICKS);

        Block BLUE_NETHER_BRICKS = registry.registerCopy("blue_nether_bricks", Block::new, Blocks.RED_NETHER_BRICKS).getEarly();
        registry.registerCopy("chiseled_blue_nether_bricks", Block::new, Blocks.RED_NETHER_BRICKS);
        registry.registerCopy("cracked_blue_nether_bricks", Block::new, Blocks.RED_NETHER_BRICKS);

        registry.registerCopy("blue_nether_brick_wall", WallBlock::new, BLUE_NETHER_BRICKS);
        registry.registerStairCopy("blue_nether_brick_stairs", BLUE_NETHER_BRICKS);
        registry.registerCopy("blue_nether_brick_slab", SlabBlock::new, BLUE_NETHER_BRICKS);
        registry.registerCopy("blue_nether_brick_fence", FenceBlock::new, BLUE_NETHER_BRICKS);

        registry.register();
    }

    // TODO: Move into Plume
    // Created so the BatchedRegisters aren't static and don't stick around wasting memory.
    private static class BlockItemRegistry {
        private final BatchedRegister<Block> blockBatchedRegister;
        private final BatchedRegister<Item> itemBatchedRegister;

        private BlockItemRegistry() {
            this.blockBatchedRegister = BatchedRegister.create(Registry.BLOCK_KEY, Crumbs.MOD_ID);
            this.itemBatchedRegister = BatchedRegister.create(Registry.ITEM_KEY, Crumbs.MOD_ID);
        }

        private void register() {
            blockBatchedRegister.register();
            itemBatchedRegister.register();
        }

        private RegistrySupplier<CrumbsChestBlock> registerChestCopy(
                String name, CrumbsChestBlock.ModelType modelType, Block toCopy
        ) {
            return register(name, new CrumbsChestBlock(modelType, AbstractBlock.Settings.copy(toCopy)));
        }

        private RegistrySupplier<PublicStairsBlock> registerStairCopy(String name, Block toCopy) {
            return register(name, new PublicStairsBlock(toCopy.getDefaultState(), AbstractBlock.Settings.copy(toCopy)));
        }

        private <T extends Block> RegistrySupplier<T> registerCopy(
                String name, Function<AbstractBlock.Settings, T> block, AbstractBlock toCopy
        ) {
            return register(name, block.apply(AbstractBlock.Settings.copy(toCopy)));
        }

        private <T extends Block> RegistrySupplier<T> register(String name, T block) {
            return register(name, block, DEFAULT_SETTINGS);
        }

        private <T extends Block> RegistrySupplier<T> register(String name, T block, @Nullable Item.Settings settings) {
            RegistrySupplier<T> result = blockBatchedRegister.add(name, block);
            if (settings != null) {
                itemBatchedRegister.add(name, new BlockItem(block, settings));
            }
            return result;
        }
    }

    // TODO: Move into Plume
    private static class PublicStairsBlock extends StairsBlock {
        public PublicStairsBlock(BlockState blockState, AbstractBlock.Settings settings) {
            super(blockState, settings);
        }
    }
}
