package net.dodogang.crumbs.platform;

import com.mojang.datafixers.util.Function5;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.function.Supplier;

public interface AbstractPlatform {
    void registerBlock(Identifier id, Block block);
    void registerItem(Identifier id, Item item);
    void registerBlockEntityType(Identifier id, BlockEntityType<?> beType);

    ItemGroup createItemGroup(String name, Supplier<ItemStack> icon);

    void registerOnRightClickBlockHandler(Function5<PlayerEntity, World, Hand, BlockPos, Direction, ActionResult> event);

    boolean isAxe(ItemStack item);
}
