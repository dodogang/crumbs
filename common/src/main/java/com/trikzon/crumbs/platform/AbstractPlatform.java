package com.trikzon.crumbs.platform;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;

public interface AbstractPlatform {
    void registerBlocks(ArrayList<Pair<String, Block>> blocks);
    void registerItems(ArrayList<Pair<String, Item>> items);
}
