package net.dodogang.ash.item.impl;

import net.dodogang.ash.item.api.CreativeModeTabBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import org.quiltmc.qsl.item.group.api.QuiltItemGroup;

public class CreativeModeTabBuilderImpl extends CreativeModeTabBuilder {
    @Override
    protected Builder createImpl(ResourceLocation resLoc) {
        return new BuilderImpl(resLoc);
    }

    private static class BuilderImpl extends Builder {
        private BuilderImpl(ResourceLocation resLoc) {
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
}
