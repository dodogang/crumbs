package net.dodogang.crumbs.init;

import net.minecraft.block.*;
import net.minecraftforge.fml.RegistryObject;

public class StoneBlocks {
    public static final RegistryObject<Block> COBBLED_GRANITE = create("cobbled_granite", Blocks.GRANITE);
    public static final RegistryObject<Block> CHISELED_GRANITE = create("chiseled_granite", Blocks.GRANITE);
    public static final RegistryObject<Block> BORDERED_GRANITE = create("bordered_granite", Blocks.GRANITE);
    public static final RegistryObject<Block> CRACKED_GRANITE = create("cracked_granite", Blocks.GRANITE);

    public static final RegistryObject<Block> COBBLED_DIORITE = create("cobbled_diorite", Blocks.DIORITE);
    public static final RegistryObject<Block> CHISELED_DIORITE = create("chiseled_diorite", Blocks.DIORITE);
    public static final RegistryObject<Block> BORDERED_DIORITE = create("bordered_diorite", Blocks.DIORITE);
    public static final RegistryObject<Block> CRACKED_DIORITE = create("cracked_diorite", Blocks.DIORITE);

    public static final RegistryObject<Block> COBBLED_ANDESITE = create("cobbled_andesite", Blocks.ANDESITE);
    public static final RegistryObject<Block> CHISELED_ANDESITE = create("chiseled_andesite", Blocks.ANDESITE);
    public static final RegistryObject<Block> BORDERED_ANDESITE = create("bordered_andesite", Blocks.ANDESITE);
    public static final RegistryObject<Block> CRACKED_ANDESITE = create("cracked_andesite", Blocks.ANDESITE);

//    public static final RegistryObject<Block> COBBLED_BASALT = create("cobbled_basalt", Blocks.BASALT);
//    public static final RegistryObject<Block> POLISHED_BASALT = create("polished_basalt", Blocks.BASALT);
//    public static final RegistryObject<Block> CHISELED_BASALT = create("chiseled_basalt", Blocks.BASALT);
//    public static final RegistryObject<Block> BORDERED_BASALT = create("bordered_basalt", Blocks.BASALT);
//    public static final RegistryObject<Block> CRACKED_BASALT = create("cracked_basalt", Blocks.BASALT);

//    public static final RegistryObject<Block> POLISHED_BASALT_SLAB = createSlab("polished_basalt", Blocks.BASALT);
//    public static final RegistryObject<Block> POLISHED_BASALT_STAIRS = createStairs("polished_basalt", Blocks.BASALT);

    public static final RegistryObject<Block> COBBLED_GRANITE_WALL = createWall("cobbled_granite", Blocks.GRANITE);
    public static final RegistryObject<Block> COBBLED_DIORITE_WALL = createWall("cobbled_diorite", Blocks.DIORITE);
    public static final RegistryObject<Block> COBBLED_ANDESITE_WALL = createWall("cobbled_andesite", Blocks.ANDESITE);
//    public static final RegistryObject<Block> COBBLED_BASALT_WALL = createWall("cobbled_basalt", Blocks.BASALT);

    public static final RegistryObject<Block> COBBLED_GRANITE_SLAB = createSlab("cobbled_granite", Blocks.GRANITE);
    public static final RegistryObject<Block> COBBLED_DIORITE_SLAB = createSlab("cobbled_diorite", Blocks.DIORITE);
    public static final RegistryObject<Block> COBBLED_ANDESITE_SLAB = createSlab("cobbled_andesite", Blocks.ANDESITE);
//    public static final RegistryObject<Block> COBBLED_BASALT_SLAB = createSlab("cobbled_basalt", Blocks.BASALT);

    public static final RegistryObject<Block> COBBLED_GRANITE_STAIRS = createStairs("cobbled_granite", Blocks.GRANITE);
    public static final RegistryObject<Block> COBBLED_DIORITE_STAIRS = createStairs("cobbled_diorite", Blocks.DIORITE);
    public static final RegistryObject<Block> COBBLED_ANDESITE_STAIRS = createStairs("cobbled_andesite", Blocks.ANDESITE);
//    public static final RegistryObject<Block> COBBLED_BASALT_STAIRS = createStairs("cobbled_basalt", Blocks.BASALT);

    public static final RegistryObject<Block> CRACKED_GRANITE_SLAB = createSlab("cracked_granite", Blocks.GRANITE);
    public static final RegistryObject<Block> CRACKED_DIORITE_SLAB = createSlab("cracked_diorite", Blocks.DIORITE);
    public static final RegistryObject<Block> CRACKED_ANDESITE_SLAB = createSlab("cracked_andesite", Blocks.ANDESITE);
//    public static final RegistryObject<Block> CRACKED_BASALT_SLAB = createSlab("cracked_basalt", Blocks.BASALT);

    public static final RegistryObject<Block> CRACKED_GRANITE_STAIRS = createStairs("cracked_granite", Blocks.GRANITE);
    public static final RegistryObject<Block> CRACKED_DIORITE_STAIRS = createStairs("cracked_diorite", Blocks.DIORITE);
    public static final RegistryObject<Block> CRACKED_ANDESITE_STAIRS = createStairs("cracked_andesite", Blocks.ANDESITE);
//    public static final RegistryObject<Block> CRACKED_BASALT_STAIRS = createStairs("cracked_basalt", Blocks.BASALT);

    public StoneBlocks() {}

    private static RegistryObject<Block> createGlowing(String stone, Block from) {
        return CRegistry.registerBlock("glowing_" + stone, new Block(Block.Properties.from(from).lightValue(15)));
    }

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
                from::getDefaultState, Block.Properties.from(from)
        ));
    }
}
