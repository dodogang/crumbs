package net.dodogang.crumbs.init;

import com.google.common.collect.ImmutableMap;

import net.dodogang.crumbs.Crumbs;
import net.dodogang.crumbs.block.*;
import net.dodogang.crumbs.block.vanilla.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CrumbsBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Crumbs.MOD_ID);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Crumbs.MOD_ID);

    // BUNDLED LOGS

    public static final Block OAK_BUNDLED_LOG = registerPillarBlock("oak_bundled_log", Blocks.OAK_LOG);
    public static final Block BIRCH_BUNDLED_LOG = registerPillarBlock("birch_bundled_log", Blocks.BIRCH_LOG);
    public static final Block SPRUCE_BUNDLED_LOG = registerPillarBlock("spruce_bundled_log", Blocks.SPRUCE_LOG);
    public static final Block JUNGLE_BUNDLED_LOG = registerPillarBlock("jungle_bundled_log", Blocks.JUNGLE_LOG);
    public static final Block ACACIA_BUNDLED_LOG = registerPillarBlock("acacia_bundled_log", Blocks.ACACIA_LOG);
    public static final Block DARK_OAK_BUNDLED_LOG = registerPillarBlock("dark_oak_bundled_log", Blocks.DARK_OAK_LOG);
    // public static final Block CRIMSON_BUNDLED_LOG = registerPillarBlock("crimson_bundled_log", Blocks.CRIMSON_LOG);
    // public static final Block WARPED_BUNDLED_LOG = registerPillarBlock("warped_bundled_log", Blocks.WARPED_LOG);

    public static final Block STRIPPED_OAK_BUNDLED_LOG = registerPillarBlock("stripped_oak_bundled_log", Blocks.STRIPPED_OAK_LOG);
    public static final Block STRIPPED_BIRCH_BUNDLED_LOG = registerPillarBlock("stripped_birch_bundled_log", Blocks.STRIPPED_BIRCH_LOG);
    public static final Block STRIPPED_SPRUCE_BUNDLED_LOG = registerPillarBlock("stripped_spruce_bundled_log", Blocks.STRIPPED_SPRUCE_LOG);
    public static final Block STRIPPED_JUNGLE_BUNDLED_LOG = registerPillarBlock("stripped_jungle_bundled_log", Blocks.STRIPPED_JUNGLE_LOG);
    public static final Block STRIPPED_ACACIA_BUNDLED_LOG = registerPillarBlock("stripped_acacia_bundled_log", Blocks.STRIPPED_ACACIA_LOG);
    public static final Block STRIPPED_DARK_OAK_BUNDLED_LOG = registerPillarBlock("stripped_dark_oak_bundled_log", Blocks.STRIPPED_DARK_OAK_LOG);
    // public static final Block STRIPPED_CRIMSON_BUNDLED_LOG = registerPillarBlock("stripped_crimson_bundled_log", Blocks.STRIPPED_CRIMSON_LOG);
    // public static final Block STRIPPED_WARPED_BUNDLED_LOG = registerPillarBlock("stripped_warped_bundled_log", Blocks.STRIPPED_WARPED_LOG);

    // WOODEN BLOCKS
    
    public static final Block OAK_TILE = registerCopy("oak_tile", Blocks.OAK_PLANKS);
    public static final Block SPRUCE_TILE = registerCopy("spruce_tile", Blocks.SPRUCE_PLANKS);
    public static final Block BIRCH_TILE = registerCopy("birch_tile", Blocks.BIRCH_PLANKS);
    public static final Block JUNGLE_TILE = registerCopy("jungle_tile", Blocks.JUNGLE_PLANKS);
    public static final Block ACACIA_TILE = registerCopy("acacia_tile", Blocks.ACACIA_PLANKS);
    public static final Block DARK_OAK_TILE = registerCopy("dark_oak_tile", Blocks.DARK_OAK_PLANKS);
    // public static final Block CRIMSON_TILE = registerCopy("crimson_tile", Blocks.WARPED_PLANKS);
    // public static final Block WARPED_TILE = registerCopy("warped_tile", Blocks.WARPED_PLANKS);

    public static final Block OAK_TILE_SLAB = registerSlab("oak_tile", Blocks.OAK_PLANKS);
    public static final Block SPRUCE_TILE_SLAB = registerSlab("spruce_tile", Blocks.SPRUCE_PLANKS);
    public static final Block BIRCH_TILE_SLAB = registerSlab("birch_tile", Blocks.BIRCH_PLANKS);
    public static final Block JUNGLE_TILE_SLAB = registerSlab("jungle_tile", Blocks.JUNGLE_PLANKS);
    public static final Block ACACIA_TILE_SLAB = registerSlab("acacia_tile", Blocks.ACACIA_PLANKS);
    public static final Block DARK_OAK_TILE_SLAB = registerSlab("dark_oak_tile", Blocks.DARK_OAK_PLANKS);
    // public static final Block CRIMSON_TILE_SLAB = registerSlab("crimson_tile", Blocks.WARPED_PLANKS);
    // public static final Block WARPED_TILE_SLAB = registerSlab("warped_tile", Blocks.WARPED_PLANKS);

    public static final Block REINFORCED_OAK_PLANKS = registerCopy("reinforced_oak_planks", Blocks.OAK_PLANKS);
    public static final Block REINFORCED_SPRUCE_PLANKS = registerCopy("reinforced_spruce_planks", Blocks.SPRUCE_PLANKS);
    public static final Block REINFORCED_BIRCH_PLANKS = registerCopy("reinforced_birch_planks", Blocks.BIRCH_PLANKS);
    public static final Block REINFORCED_JUNGLE_PLANKS = registerCopy("reinforced_jungle_planks", Blocks.JUNGLE_PLANKS);
    public static final Block REINFORCED_ACACIA_PLANKS = registerCopy("reinforced_acacia_planks", Blocks.ACACIA_PLANKS);
    public static final Block REINFORCED_DARK_OAK_PLANKS = registerCopy("reinforced_dark_oak_planks", Blocks.DARK_OAK_PLANKS);
    // public static final Block REINFORCED_CRIMSON_PLANKS = registerCopy("reinforced_crimson_planks", Blocks.WARPED_PLANKS);
    // public static final Block REINFORCED_WARPED_PLANKS = registerCopy("reinforced_warped_planks", Blocks.WARPED_PLANKS);

    public static final Block REINFORCED_OAK_SLAB = registerSlab("reinforced_oak", Blocks.OAK_PLANKS);
    public static final Block REINFORCED_SPRUCE_SLAB = registerSlab("reinforced_spruce", Blocks.SPRUCE_PLANKS);
    public static final Block REINFORCED_BIRCH_SLAB = registerSlab("reinforced_birch", Blocks.BIRCH_PLANKS);
    public static final Block REINFORCED_JUNGLE_SLAB = registerSlab("reinforced_jungle", Blocks.JUNGLE_PLANKS);
    public static final Block REINFORCED_ACACIA_SLAB = registerSlab("reinforced_acacia", Blocks.ACACIA_PLANKS);
    public static final Block REINFORCED_DARK_OAK_SLAB = registerSlab("reinforced_dark_oak", Blocks.DARK_OAK_PLANKS);
    // public static final Block REINFORCED_CRIMSON_SLAB = registerSlab("reinforced_crimson", Blocks.WARPED_PLANKS);
    // public static final Block REINFORCED_WARPED_SLAB = registerSlab("reinforced_warped", Blocks.WARPED_PLANKS);

    public static final Block SPRUCE_CRAFTING_TABLE = registerCraftingTable("spruce", Blocks.SPRUCE_PLANKS);
    public static final Block BIRCH_CRAFTING_TABLE = registerCraftingTable("birch", Blocks.BIRCH_PLANKS);
    public static final Block JUNGLE_CRAFTING_TABLE = registerCraftingTable("jungle", Blocks.JUNGLE_PLANKS);
    public static final Block ACACIA_CRAFTING_TABLE = registerCraftingTable("acacia", Blocks.ACACIA_PLANKS);
    public static final Block DARK_OAK_CRAFTING_TABLE = registerCraftingTable("dark_oak", Blocks.DARK_OAK_PLANKS);
    // public static final Block CRIMSON_CRAFTING_TABLE = registerCraftingTable("crimson",Blocks.CRIMSON_PLANKS);
    // public static final Block WARPED_CRAFTING_TABLE = registerCraftingTable("warped",Blocks.WARPED_PLANKS);

    public static final Block OAK_BARREL = registerBarrel("oak", Blocks.OAK_PLANKS);
    public static final Block BIRCH_BARREL = registerBarrel("birch", Blocks.BIRCH_PLANKS);
    public static final Block JUNGLE_BARREL = registerBarrel("jungle", Blocks.JUNGLE_PLANKS);
    public static final Block ACACIA_BARREL = registerBarrel("acacia", Blocks.ACACIA_PLANKS);
    public static final Block DARK_OAK_BARREL = registerBarrel("dark_oak", Blocks.DARK_OAK_PLANKS);
    // public static final Block CRIMSON_BARREL = registerBarrel("crimson", Blocks.CRIMSON_PLANKS
    // public static final Block WARPED_BARREL = registerBarrel("warped", Blocks.WARPED_PLANKS);

    public static final Block OAK_LANTERN = registerWoodLantern("oak", Blocks.OAK_PLANKS);
    public static final Block SPRUCE_LANTERN = registerWoodLantern("spruce", Blocks.SPRUCE_PLANKS);
    public static final Block BIRCH_LANTERN = registerWoodLantern("birch", Blocks.BIRCH_PLANKS);
    public static final Block JUNGLE_LANTERN = registerWoodLantern("jungle", Blocks.JUNGLE_PLANKS);
    public static final Block ACACIA_LANTERN = registerWoodLantern("acacia", Blocks.ACACIA_PLANKS);
    public static final Block DARK_OAK_LANTERN = registerWoodLantern("dark_oak", Blocks.DARK_OAK_PLANKS);
    // public static final Block CRIMSON_LANTERN = registerWoodLantern("crimson", Blocks.CRIMSON_PLANKS);
    // public static final Block WARPED_LANTERN = registerWoodLantern("warped", Blocks.WARPED_PLANKS);

    // STONE BLOCKS

    // public static final Block GRANITE_PEBBLES = registerPebbles("granite", Blocks.GRANITE);
    // public static final Block DIORITE_PEBBLES = registerPebbles("diorite", Blocks.DIORITE);
    // public static final Block ANDESITE_PEBBLES = registerPebbles("andesite", Blocks.ANDESITE);
    // public static final Block BASALT_PEBBLES = registerPebbles("basalt", Blocks.BASALT);

    public static final Block COBBLED_GRANITE = registerCopy("cobbled_granite", Blocks.GRANITE);
    public static final Block CHISELED_GRANITE = registerCopy("chiseled_granite", Blocks.GRANITE);
    public static final Block BORDERED_GRANITE = registerCopy("bordered_granite", Blocks.GRANITE);
    public static final Block CRACKED_GRANITE = registerCopy("cracked_granite", Blocks.GRANITE);

    public static final Block COBBLED_DIORITE = registerCopy("cobbled_diorite", Blocks.DIORITE);
    public static final Block CHISELED_DIORITE = registerCopy("chiseled_diorite", Blocks.DIORITE);
    public static final Block BORDERED_DIORITE = registerCopy("bordered_diorite", Blocks.DIORITE);
    public static final Block CRACKED_DIORITE = registerCopy("cracked_diorite", Blocks.DIORITE);

    public static final Block COBBLED_ANDESITE = registerCopy("cobbled_andesite", Blocks.ANDESITE);
    public static final Block CHISELED_ANDESITE = registerCopy("chiseled_andesite", Blocks.ANDESITE);
    public static final Block BORDERED_ANDESITE = registerCopy("bordered_andesite", Blocks.ANDESITE);
    public static final Block CRACKED_ANDESITE = registerCopy("cracked_andesite", Blocks.ANDESITE);

    // public static final Block COBBLED_BASALT = registerCopy("cobbled_basalt", Blocks.BASALT);
    // public static final Block POLISHED_BASALT = registerCopy("polished_basalt", Blocks.BASALT);
    // public static final Block CHISELED_BASALT = registerCopy("chiseled_basalt", Blocks.BASALT);
    // public static final Block BORDERED_BASALT = registerCopy("bordered_basalt", Blocks.BASALT);
    // public static final Block CRACKED_BASALT = registerCopy("cracked_basalt", Blocks.BASALT);

    // public static final Block POLISHED_BASALT_SLAB = registerSlab("polished_basalt", Blocks.BASALT);
    // public static final Block POLISHED_BASALT_STAIRS = registerStairs("polished_basalt", Blocks.BASALT);

    public static final Block COBBLED_GRANITE_WALL = registerWall("cobbled_granite", Blocks.GRANITE);
    public static final Block COBBLED_DIORITE_WALL = registerWall("cobbled_diorite", Blocks.DIORITE);
    public static final Block COBBLED_ANDESITE_WALL = registerWall("cobbled_andesite", Blocks.ANDESITE);
    // public static final Block COBBLED_BASALT_WALL = registerWall("cobbled_basalt", Blocks.BASALT);

    public static final Block COBBLED_GRANITE_SLAB = registerSlab("cobbled_granite", Blocks.GRANITE);
    public static final Block COBBLED_DIORITE_SLAB = registerSlab("cobbled_diorite", Blocks.DIORITE);
    public static final Block COBBLED_ANDESITE_SLAB = registerSlab("cobbled_andesite", Blocks.ANDESITE);
    // public static final Block COBBLED_BASALT_SLAB = registerSlab("cobbled_basalt", Blocks.BASALT);

    public static final Block COBBLED_GRANITE_STAIRS = registerStairs("cobbled_granite", Blocks.GRANITE);
    public static final Block COBBLED_DIORITE_STAIRS = registerStairs("cobbled_diorite", Blocks.DIORITE);
    public static final Block COBBLED_ANDESITE_STAIRS = registerStairs("cobbled_andesite", Blocks.ANDESITE);
    // public static final Block COBBLED_BASALT_STAIRS = registerStairs("cobbled_basalt", Blocks.BASALT);

    public static final Block CRACKED_GRANITE_SLAB = registerSlab("cracked_granite", Blocks.GRANITE);
    public static final Block CRACKED_DIORITE_SLAB = registerSlab("cracked_diorite", Blocks.DIORITE);
    public static final Block CRACKED_ANDESITE_SLAB = registerSlab("cracked_andesite", Blocks.ANDESITE);
    // public static final Block CRACKED_BASALT_SLAB = registerSlab("cracked_basalt", Blocks.BASALT);

    public static final Block CRACKED_GRANITE_STAIRS = registerStairs("cracked_granite", Blocks.GRANITE);
    public static final Block CRACKED_DIORITE_STAIRS = registerStairs("cracked_diorite", Blocks.DIORITE);
    public static final Block CRACKED_ANDESITE_STAIRS = registerStairs("cracked_andesite", Blocks.ANDESITE);
    // public static final Block CRACKED_BASALT_STAIRS = registerStairs("cracked_basalt", Blocks.BASALT);

    // SAND BLOCKS

    public static final Block SANDSTONE_TILE = registerCopy("sandstone_tile", Blocks.SANDSTONE);
    public static final Block LARGE_SANDSTONE_TILE = registerCopy("large_sandstone_tile", Blocks.SANDSTONE);

    public static final Block RED_SANDSTONE_TILE = registerCopy("red_sandstone_tile", Blocks.RED_SANDSTONE);
    public static final Block LARGE_RED_SANDSTONE_TILE = registerCopy("large_red_sandstone_tile", Blocks.RED_SANDSTONE);

    public static final Block SANDSTONE_TILE_WALL = registerWall("sandstone_tile", Blocks.SANDSTONE);
    public static final Block RED_SANDSTONE_TILE_WALL = registerWall("red_sandstone_tile", Blocks.RED_SANDSTONE);

    public static final Block SANDSTONE_TILE_SLAB = registerSlab("sandstone_tile", Blocks.SANDSTONE);
    public static final Block RED_SANDSTONE_TILE_SLAB = registerSlab("red_sandstone_tile", Blocks.RED_SANDSTONE);

    public static final Block SANDSTONE_TILE_STAIRS = registerStairs("sandstone_tile", Blocks.SANDSTONE);
    public static final Block RED_SANDSTONE_TILE_STAIRS = registerStairs("red_sandstone_tile", Blocks.RED_SANDSTONE);

    public static void registerBlocks(RegistryEvent.Register<Block> registry) {
        for (CrumbsBlock crumbsBlock : CrumbsBlock.getAll()) {
            registry.getRegistry().register(crumbsBlock.getBlock().setRegistryName(new ResourceLocation(Crumbs.MOD_ID, crumbsBlock.getId())));
        }
    }
    public static void registerBlockItems(RegistryEvent.Register<Item> registry) {
        for (CrumbsBlock crumbsBlock : CrumbsBlock.getAll()) {
            Block block = crumbsBlock.getBlock();
            registry.getRegistry().register(new BlockItem(
                    block, new Item.Properties().group(Crumbs.ITEM_GROUP)).setRegistryName(block.getRegistryName()
            ));
        }
    }

    public static void addStrippingFunctionality(PlayerInteractEvent.RightClickBlock event) {
        if (!(event.getItemStack().getItem() instanceof AxeItem)) return;

        World world = event.getWorld();
        BlockPos pos = event.getPos();
        BlockState blockState = world.getBlockState(pos);

        new ImmutableMap.Builder<Block, Block>()
            .put(OAK_BUNDLED_LOG, STRIPPED_OAK_BUNDLED_LOG)
            .put(DARK_OAK_BUNDLED_LOG, STRIPPED_DARK_OAK_BUNDLED_LOG)
            .put(ACACIA_BUNDLED_LOG, STRIPPED_ACACIA_BUNDLED_LOG)
            .put(BIRCH_BUNDLED_LOG, STRIPPED_BIRCH_BUNDLED_LOG)
            .put(JUNGLE_BUNDLED_LOG, STRIPPED_JUNGLE_BUNDLED_LOG)
            .put(SPRUCE_BUNDLED_LOG, STRIPPED_SPRUCE_BUNDLED_LOG)
            // .put(WARPED_BUNDLED_STEM, STRIPPED_WARPED_BUNDLED_STEM)
            // .put(CRIMSON_BUNDLED_STEM, STRIPPED_CRIMSON_BUNDLED_STEM)
            .build().forEach((base, result) -> {
                if (blockState.getBlock() == base) {
                    PlayerEntity player = event.getPlayer();
                    world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0f, 1.0f);
                    player.swingArm(event.getHand());
                    if (!world.isRemote) {
                        world.setBlockState(pos, result.getDefaultState().with(RotatedPillarBlock.AXIS, blockState.get(RotatedPillarBlock.AXIS)), 11);
                        event.getItemStack().damageItem(1, player, playerEntity -> playerEntity.sendBreakAnimation(event.getHand()));
                    }
                }
            });

        event.setCancellationResult(ActionResultType.CONSUME);
    }

    private static Block registerCopy(String id, Block base) {
        return register(id, new Block(Block.Properties.from(base)));
    }
    private static Block registerCraftingTable(String id, Block base) {
        return register(id + "_crafting_table", new CrumbsCraftingTableBlock(Block.Properties.from(base)));
    }
    private static Block registerWoodLantern(String id, Block base) {
        return register(id + "_lantern", new WoodLanternBlock(Block.Properties.from(base)));
    }
    // private static Block registerPebbles(String id, Block base) {
        //  return register(id + "_pebbles", new PebblesBlock(Block.Properties.from(base).hardnessAndResistance(0.0F)));
    // }
    private static Block registerSlab(String id, Block base) {
        return register(id + "_slab", new SlabBlock(Block.Properties.from(base)));
    }
    private static Block registerStairs(String id, Block base) {
        return register(id + "_stairs", new PublicStairsBlock(base::getDefaultState, Block.Properties.from(base)));
    }
    private static Block registerWall(String id, Block base) {
        return register(id + "_wall", new WallBlock(Block.Properties.from(base)));
    }
    private static Block registerBarrel(String id, Block base) {
        return register(id + "_barrel", new CrumbsBarrelBlock(Block.Properties.from(base)));
    }
    private static Block registerPillarBlock(String id, Block base) {
        return register(id, new RotatedPillarBlock(Block.Properties.from(base)));
    }

    public static Block register(String id, Block block, boolean registerItem) {
        CrumbsBlock crumbsBlock = new CrumbsBlock(id, block);
        return crumbsBlock.getBlock();
    }
    public static Block register(String id, Block block) {
        return register(id, block, true);
    }
}
