package com.trikzon.crumbs.block;

import com.trikzon.crumbs.CrumbsCore;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;

public class CrumbsBlocks {
    public static final ArrayList<Pair<String, Block>> BLOCKS = new ArrayList<>();

    public static final Block EXAMPLE_BLOCK = put("example_block", new ExampleBlock(BlockBehaviour.Properties.of(Material.STONE)));

    public static void register() {
        CrumbsCore.platform.registerBlocks(BLOCKS);

        ArrayList<Pair<String, Item>> items = new ArrayList<>();
        for (Pair<String, Block> pair : BLOCKS) {
            Item item = new BlockItem(pair.getRight(), new Item.Properties().tab(CreativeModeTab.TAB_MISC));
            items.add(Pair.of(pair.getLeft(), item));
        }
        CrumbsCore.platform.registerItems(items);
    }

    private static Block put(String name, Block block) {
        BLOCKS.add(Pair.of(name, block));
        return block;
    }
}
