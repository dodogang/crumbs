package com.trikzon.crumbs.forge;

import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Function5;
import com.trikzon.crumbs.CrumbsCore;
import com.trikzon.crumbs.block.CrumbsBarrelBlock;
import com.trikzon.crumbs.forge.client.CrumbsClientForge;
import com.trikzon.crumbs.forge.mixin.PointOfInterestTypeAccessor;
import com.trikzon.crumbs.platform.AbstractPlatform;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.function.Supplier;

@Mod(CrumbsCore.MOD_ID)
public class CrumbsForge implements AbstractPlatform {
    private static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, CrumbsCore.MOD_ID);
    private static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, CrumbsCore.MOD_ID);
    private static final DeferredRegister<TileEntityType<?>> BLOCK_ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, CrumbsCore.MOD_ID);

    public CrumbsForge() {
        CrumbsCore.init(this);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> CrumbsClientForge::new);

        BLOCK_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEM_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());

        registerPointsOfInterest();
    }

    public static void registerPointsOfInterest() {
        // Copied from PoiType#registerBlockStates
        // Edited to allow adding blocks to a Poi
        CrumbsBarrelBlock.MOD_BARRELS.forEach((barrel) -> {
            PointOfInterestType poiType = PointOfInterestTypeAccessor.getTypeByState().put(barrel, PointOfInterestType.FISHERMAN);
            if (poiType != null) {
                throw Util.pauseInIde(new IllegalStateException(
                        String.format("%s is defined in too many tags", barrel)
                ));
            }
        });
        PointOfInterestTypeAccessor fishermanAccessor = (PointOfInterestTypeAccessor) PointOfInterestType.FISHERMAN;

        ArrayList<BlockState> blockStates = new ArrayList<>(fishermanAccessor.getMatchingStates());
        blockStates.addAll(CrumbsBarrelBlock.MOD_BARRELS);
        fishermanAccessor.setMatchingStates(ImmutableSet.copyOf(blockStates));
    }

    @Override
    public void registerBlock(ResourceLocation resourceLocation, Block block) {
        BLOCK_REGISTRY.register(resourceLocation.getPath(), () -> block);
    }

    @Override
    public void registerItem(ResourceLocation resourceLocation, Item item) {
        ITEM_REGISTRY.register(resourceLocation.getPath(), () -> item);
    }

    @Override
    public void registerBlockEntityType(ResourceLocation resourceLocation, TileEntityType<?> tileEntityType) {
        BLOCK_ENTITY_REGISTRY.register(resourceLocation.getPath(), () -> tileEntityType);
    }

    @Override
    public ItemGroup createCreativeTab(String name, Supplier<ItemStack> icon) {
        return new ItemGroup(CrumbsCore.MOD_ID + "." + name) {
            @Override
            public ItemStack makeIcon() {
                return icon.get();
            }
        };
    }

    @Override
    public void registerOnRightClickBlockHandler(Function5<PlayerEntity, World, Hand, BlockPos, Direction, ActionResultType> event) {
        MinecraftForge.EVENT_BUS.<PlayerInteractEvent.RightClickBlock>addListener(e -> {
            if (!e.getPlayer().isSpectator()) {
                e.setCancellationResult(event.apply(e.getPlayer(), e.getWorld(), e.getHand(), e.getPos(), e.getFace()));
            }
        });
    }

    @Override
    public boolean isAxe(ItemStack item) {
        return item.getItem().getToolTypes(item).contains(ToolType.AXE);
    }
}
