package net.dodogang.crumbs.init;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraftforge.fml.RegistryObject;

public class WoodBlocks {
    public static final RegistryObject<Block> OAK_TILE = create("oak_tile", Blocks.OAK_PLANKS);
    public static final RegistryObject<Block> SPRUCE_TILE = create("spruce_tile", Blocks.SPRUCE_PLANKS);
    public static final RegistryObject<Block> BIRCH_TILE = create("birch_tile", Blocks.BIRCH_PLANKS);
    public static final RegistryObject<Block> JUNGLE_TILE = create("jungle_tile", Blocks.JUNGLE_PLANKS);
    public static final RegistryObject<Block> ACACIA_TILE = create("acacia_tile", Blocks.ACACIA_PLANKS);
    public static final RegistryObject<Block> DARK_OAK_TILE = create("dark_oak_tile", Blocks.DARK_OAK_PLANKS);
//    public static final RegistryObject<Block> CRIMSON_TILE = create("crimson_tile", Blocks.WARPED_PLANKS);
//    public static final RegistryObject<Block> WARPED_TILE = create("warped_tile", Blocks.WARPED_PLANKS);

    public static final RegistryObject<Block> OAK_TILE_SLAB = createSlab("oak_tile", Blocks.OAK_PLANKS);
    public static final RegistryObject<Block> SPRUCE_TILE_SLAB = createSlab("spruce_tile", Blocks.SPRUCE_PLANKS);
    public static final RegistryObject<Block> BIRCH_TILE_SLAB = createSlab("birch_tile", Blocks.BIRCH_PLANKS);
    public static final RegistryObject<Block> JUNGLE_TILE_SLAB = createSlab("jungle_tile", Blocks.JUNGLE_PLANKS);
    public static final RegistryObject<Block> ACACIA_TILE_SLAB = createSlab("acacia_tile", Blocks.ACACIA_PLANKS);
    public static final RegistryObject<Block> DARK_OAK_TILE_SLAB = createSlab("dark_oak_tile", Blocks.DARK_OAK_PLANKS);
//    public static final RegistryObject<Block> CRIMSON_TILE_SLAB = createSlab("crimson_tile", Blocks.WARPED_PLANKS);
//    public static final RegistryObject<Block> WARPED_TILE_SLAB = createSlab("warped_tile", Blocks.WARPED_PLANKS);

    public static final RegistryObject<Block> RIDGED_OAK_PLANKS = create("ridged_oak_planks", Blocks.OAK_PLANKS);
    public static final RegistryObject<Block> RIDGED_SPRUCE_PLANKS = create("ridged_spruce_planks", Blocks.SPRUCE_PLANKS);
    public static final RegistryObject<Block> RIDGED_BIRCH_PLANKS = create("ridged_birch_planks", Blocks.BIRCH_PLANKS);
    public static final RegistryObject<Block> RIDGED_JUNGLE_PLANKS = create("ridged_jungle_planks", Blocks.JUNGLE_PLANKS);
    public static final RegistryObject<Block> RIDGED_ACACIA_PLANKS = create("ridged_acacia_planks", Blocks.ACACIA_PLANKS);
    public static final RegistryObject<Block> RIDGED_DARK_OAK_PLANKS = create("ridged_dark_oak_planks", Blocks.DARK_OAK_PLANKS);
//    public static final RegistryObject<Block> RIDGED_CRIMSON_PLANKS = create("ridged_crimson_planks", Blocks.WARPED_PLANKS);
//    public static final RegistryObject<Block> RIDGED_WARPED_PLANKS = create("ridged_warped_planks", Blocks.WARPED_PLANKS);

    public static final RegistryObject<Block> RIDGED_OAK_SLAB = createSlab("ridged_oak", Blocks.OAK_PLANKS);
    public static final RegistryObject<Block> RIDGED_SPRUCE_SLAB = createSlab("ridged_spruce", Blocks.SPRUCE_PLANKS);
    public static final RegistryObject<Block> RIDGED_BIRCH_SLAB = createSlab("ridged_birch", Blocks.BIRCH_PLANKS);
    public static final RegistryObject<Block> RIDGED_JUNGLE_SLAB = createSlab("ridged_jungle", Blocks.JUNGLE_PLANKS);
    public static final RegistryObject<Block> RIDGED_ACACIA_SLAB = createSlab("ridged_acacia", Blocks.ACACIA_PLANKS);
    public static final RegistryObject<Block> RIDGED_DARK_OAK_SLAB = createSlab("ridged_dark_oak", Blocks.DARK_OAK_PLANKS);
//    public static final RegistryObject<Block> RIDGED_CRIMSON_SLAB = createSlab("ridged_crimson", Blocks.WARPED_PLANKS);
//    public static final RegistryObject<Block> RIDGED_WARPED_SLAB = createSlab("ridged_warped", Blocks.WARPED_PLANKS);

    public WoodBlocks() {}

    private static RegistryObject<Block> create(String name, Block from) {
        return CRegistry.registerBlock(name, new Block(Block.Properties.from(from)));
    }

    private static RegistryObject<Block> createSlab(String name, Block from) {
        return CRegistry.registerBlock(name + "_slab", new SlabBlock(Block.Properties.from(from)));
    }
}
