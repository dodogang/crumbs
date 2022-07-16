package net.dodogang.ash.item.impl;

import net.dodogang.ash.item.api.CreativeModeTabBuilder;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CreativeModeTabBuilderImpl extends CreativeModeTabBuilder {
    public CreativeModeTabBuilderImpl(ResourceLocation resLoc) {
        super(resLoc);
    }

    @Override
    public CreativeModeTab build() {
        return FabricItemGroupBuilder.create(resLoc)
                .icon(iconSupplier)
                .appendItems((stacks, tab) -> {
                    for (Item item : Registry.ITEM) {
                        if (item.getItemCategory() == tab) {
                            stacks.add(new ItemStack(item));
                        }
                    }
                    if (stacksForDisplay != null) {
                        stacksForDisplay.accept(stacks);
                    }
                }).build();
    }
}
