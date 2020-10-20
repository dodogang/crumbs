package net.dodogang.crumbs.init;

import net.minecraft.block.*;
import net.minecraftforge.fml.RegistryObject;

public class SandBlocks {
    public static final RegistryObject<Block> TILE = create("sandstone_tile", Blocks.SANDSTONE);
    public static final RegistryObject<Block> LARGE_TILE = create("large_sandstone_tile", Blocks.SANDSTONE);

    public static final RegistryObject<Block> RED_TILE = create("red_sandstone_tile", Blocks.RED_SANDSTONE);
    public static final RegistryObject<Block> RED_LARGE_TILE = create("large_red_sandstone_tile", Blocks.RED_SANDSTONE);

    public static final RegistryObject<Block> TILE_WALL = createWall("sandstone_tile", Blocks.SANDSTONE);
    public static final RegistryObject<Block> RED_TILE_WALL = createWall("red_sandstone_tile", Blocks.RED_SANDSTONE);

    public static final RegistryObject<Block> TILE_SLAB = createSlab("sandstone_tile", Blocks.SANDSTONE);
    public static final RegistryObject<Block> RED_TILE_SLAB = createSlab("red_sandstone_tile", Blocks.RED_SANDSTONE);

    public static final RegistryObject<Block> TILE_STAIRS = createStairs("sandstone_tile", Blocks.SANDSTONE);
    public static final RegistryObject<Block> RED_TILE_STAIRS = createStairs("red_sandstone_tile", Blocks.RED_SANDSTONE);

    public SandBlocks() {};

    private static RegistryObject<Block> create(String name, Block from) {
        return CRegistry.registerBlock(name, new Block(Block.Properties.from(from)));
    }

    private static RegistryObject<Block> createWall(String name, Block from) {
        return CRegistry.registerBlock(name + "_wall", new WallBlock(Block.Properties.from(from)));
    }

    private static RegistryObject<Block> createSlab(String name, Block from) {
        return CRegistry.registerBlock(name + "_slab", new SlabBlock(Block.Properties.from(from)));
    }

    private static RegistryObject<Block> createStairs(String name, Block from) {
        return CRegistry.registerBlock(name + "_stairs", new StairsBlock(
                from::getDefaultState,
                Block.Properties.from(from)
        ));
    }
}
