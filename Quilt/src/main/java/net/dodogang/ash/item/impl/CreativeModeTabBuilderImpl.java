package net.dodogang.ash.item.impl;

import net.dodogang.ash.item.api.CreativeModeTabBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import org.quiltmc.qsl.item.group.api.QuiltItemGroup;

public class CreativeModeTabBuilderImpl extends CreativeModeTabBuilder {
    public CreativeModeTabBuilderImpl(ResourceLocation resLoc) {
        super(resLoc);
    }

    @Override
    public CreativeModeTab build() {
        return QuiltItemGroup.builder(resLoc)
                .icon(iconSupplier)
                .appendItems(stacksForDisplay)
                .build();
    }
}
