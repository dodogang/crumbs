package com.trikzon.crumbs.platform;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public interface AbstractPlatform {
    void registerBlock(ResourceLocation id, Block block);
    void registerItem(ResourceLocation id, Item item);
}
