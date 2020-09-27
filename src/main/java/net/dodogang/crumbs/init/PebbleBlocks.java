package net.dodogang.crumbs.init;

import net.dodogang.crumbs.block.PebbleBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.RegistryObject;

public class PebbleBlocks {
//    public static final RegistryObject<Block> GRANITE = create("granite", Blocks.GRANITE);
//    public static final RegistryObject<Block> DIORITE = create("diorite", Blocks.DIORITE);
//    public static final RegistryObject<Block> ANDESITE = create("andesite", Blocks.ANDESITE);
//    public static final RegistryObject<Block> BASALT = create("basalt", Blocks.BASALT);

    public PebbleBlocks() {}

    public static RegistryObject<Block> create(String name, Block from) {
        return CRegistry.registerBlock(name + "_pebble", new PebbleBlock(Block.Properties.from(from)));
    }
}
