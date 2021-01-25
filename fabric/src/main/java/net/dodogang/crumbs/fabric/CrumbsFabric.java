package net.dodogang.crumbs.fabric;

import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Function5;
import net.dodogang.crumbs.CrumbsCore;
import net.dodogang.crumbs.block.CrumbsBarrelBlock;
import net.dodogang.crumbs.mixin.PointOfInterestTypeAccessor;
import net.dodogang.crumbs.platform.AbstractPlatform;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.ArrayList;
import java.util.function.Supplier;

public class CrumbsFabric implements ModInitializer, AbstractPlatform {
    @Override
    public void onInitialize() {
        CrumbsCore.init(this);
        CrumbsCore.setup();

        registerPointsOfInterest();
    }

    public static void registerPointsOfInterest() {
        // Copied from PoiType#registerBlockStates
        // Edited to allow adding blocks to a Poi
        CrumbsBarrelBlock.MOD_BARRELS.forEach((barrel) -> {
            PointOfInterestType poiType = PointOfInterestTypeAccessor.getBlockStatePoiMap()
                    .put(barrel, PointOfInterestType.FISHERMAN);
            if (poiType != null) {
                throw Util.throwOrPause(new IllegalStateException(
                        String.format("%s is defined in too many tags", barrel)
                ));
            }
        });
        PointOfInterestTypeAccessor fishermanAccessor = (PointOfInterestTypeAccessor) PointOfInterestType.FISHERMAN;

        ArrayList<BlockState> blockStates = new ArrayList<>(fishermanAccessor.getBlockStates());
        blockStates.addAll(CrumbsBarrelBlock.MOD_BARRELS);
        fishermanAccessor.setBlockStates(ImmutableSet.copyOf(blockStates));
    }

    @Override
    public void registerBlock(Identifier id, Block block) {
        Registry.register(Registry.BLOCK, id, block);
    }

    @Override
    public void registerItem(Identifier id, Item item) {
        Registry.register(Registry.ITEM, id, item);
    }

    @Override
    public void registerBlockEntityType(Identifier id, BlockEntityType<?> beType) {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, id, beType);
    }

    @Override
    public ItemGroup createItemGroup(String name, Supplier<ItemStack> icon) {
        return FabricItemGroupBuilder.build(new Identifier(CrumbsCore.MOD_ID, name), icon);
    }

    @Override
    public void registerOnRightClickBlockHandler(Function5<PlayerEntity, World, Hand, BlockPos, Direction, ActionResult> event) {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (!player.isSpectator()) {
                return event.apply(player, world, hand, hitResult.getBlockPos(), hitResult.getSide());
            } else {
                return ActionResult.PASS;
            }
        });
    }

    @Override
    public boolean isAxe(ItemStack item) {
        return FabricToolTags.AXES.contains(item.getItem());
    }
}
