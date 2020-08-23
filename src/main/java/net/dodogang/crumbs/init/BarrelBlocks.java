package net.dodogang.crumbs.init;

import net.dodogang.crumbs.block.CBarrelBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.RegistryObject;

public class BarrelBlocks {
    public static final RegistryObject<Block> OAK = create("oak", Blocks.OAK_PLANKS);
    public static final RegistryObject<Block> BIRCH = create("birch", Blocks.BIRCH_PLANKS);
    public static final RegistryObject<Block> JUNGLE = create("jungle", Blocks.JUNGLE_PLANKS);
    public static final RegistryObject<Block> ACACIA = create("acacia", Blocks.ACACIA_PLANKS);
    public static final RegistryObject<Block> DARK_OAK = create("dark_oak", Blocks.DARK_OAK_PLANKS);
//    public static final RegistryObject<Block> CRIMSON = create("crimson", Blocks.CRIMSON_PLANKS
//    public static final RegistryObject<Block> WARPED = create("warped", Blocks.WARPED_PLANKS);

    public BarrelBlocks() {}

    private static RegistryObject<Block> create(String adjective, Block from) {
        return CRegistry.registerBlock(
                adjective + "_barrel",
                new CBarrelBlock(Block.Properties.from(from))
        );
    }
}
