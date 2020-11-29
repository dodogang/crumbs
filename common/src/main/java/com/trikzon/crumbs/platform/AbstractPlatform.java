package com.trikzon.crumbs.platform;

import com.mojang.datafixers.util.Function5;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public interface AbstractPlatform {
    void registerBlock(ResourceLocation id, Block block);
    void registerItem(ResourceLocation id, Item item);

    CreativeModeTab createCreativeTab(String name, Supplier<ItemStack> icon);

    void registerOnRightClickBlockHandler(Function5<Player, Level, InteractionHand, BlockPos, Direction, InteractionResult> event);

    boolean isAxe(ItemStack item);
}
