package com.trikzon.crumbs.forge;

import com.mojang.datafixers.util.Function5;
import com.trikzon.crumbs.CrumbsCore;
import com.trikzon.crumbs.platform.AbstractPlatform;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

@Mod(CrumbsCore.MOD_ID)
public class CrumbsForge implements AbstractPlatform {
    private static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, CrumbsCore.MOD_ID);
    private static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, CrumbsCore.MOD_ID);

    public CrumbsForge() {
        CrumbsCore.init(this);

        BLOCK_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEM_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
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
