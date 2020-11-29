package com.trikzon.crumbs.fabric;

import com.trikzon.crumbs.CrumbsCore;
import com.trikzon.crumbs.platform.AbstractPlatform;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;

public class CrumbsFabric implements ModInitializer, AbstractPlatform {
    @Override
    public void onInitialize() {
        CrumbsCore.init(this);
    }

    @Override
    public void registerBlock(ResourceLocation id, Block block) {
        Registry.register(Registry.BLOCK, id, block);
    }

    @Override
    public void registerItem(ResourceLocation id, Item item) {
        Registry.register(Registry.ITEM, id, item);
    }
}
