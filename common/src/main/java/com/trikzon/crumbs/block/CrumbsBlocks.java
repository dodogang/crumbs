package com.trikzon.crumbs.block;

import com.trikzon.crumbs.CrumbsCore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class CrumbsBlocks {
    public static final Item.Properties DEFAULT_PROPS = new Item.Properties().tab(CreativeModeTab.TAB_MISC);

    public static final ExampleBlock EXAMPLE_BLOCK = register("example_block", new ExampleBlock(BlockBehaviour.Properties.of(Material.STONE)));

    private static <T extends Block> T register(String name, T block) {
        return register(name, block, DEFAULT_PROPS);
    }

    private static <T extends Block> T register(String name, T block, Item.Properties properties) {
        ResourceLocation id = CrumbsCore.getId(name);
        CrumbsCore.platform.registerBlock(id, block);
        if (properties != null) CrumbsCore.platform.registerItem(id, new BlockItem(block, properties));
        return block;
    }
}
