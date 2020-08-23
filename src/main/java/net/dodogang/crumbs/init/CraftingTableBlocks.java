package net.dodogang.crumbs.init;

import net.dodogang.crumbs.block.CCraftingTableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.RegistryObject;

public class CraftingTableBlocks {
    public static final RegistryObject<Block> SPRUCE = create("spruce", Blocks.SPRUCE_PLANKS);
    public static final RegistryObject<Block> BIRCH = create("birch",Blocks.BIRCH_PLANKS);
    public static final RegistryObject<Block> JUNGLE = create("jungle",Blocks.JUNGLE_PLANKS);
    public static final RegistryObject<Block> ACACIA = create("acacia",Blocks.ACACIA_PLANKS);
    public static final RegistryObject<Block> DARK_OAK = create("dark_oak",Blocks.DARK_OAK_PLANKS);
//    public static final RegistryObject<Block> CRIMSON = create("crimson",Blocks.CRIMSON_PLANKS);
//    public static final RegistryObject<Block> WARPED = create("warped",Blocks.WARPED_PLANKS);

    public CraftingTableBlocks() {}

    private static RegistryObject<Block> create(String adjective, Block from) {
        return CRegistry.registerBlock(
                adjective + "_crafting_table",
                new CCraftingTableBlock(Block.Properties.from(from))
        );
    }
}
