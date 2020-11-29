package com.trikzon.crumbs.platform;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public interface AbstractPlatform {
    void registerBlock(ResourceLocation id, Block block);
    void registerItem(ResourceLocation id, Item item);

    CreativeModeTab createCreativeTab(String name, Supplier<ItemStack> icon);
}
