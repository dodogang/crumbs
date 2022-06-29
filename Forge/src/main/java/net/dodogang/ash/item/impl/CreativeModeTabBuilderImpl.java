package net.dodogang.ash.item.impl;

import net.dodogang.ash.item.api.CreativeModeTabBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

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
            return new CreativeModeTab(String.format("%s.%s", resLoc.getNamespace(), resLoc.getPath())) {
                @Override
                public ItemStack makeIcon() {
                    return iconSupplier.get();
                }

                @Override
                public void fillItemList(NonNullList<ItemStack> stacks) {
                    super.fillItemList(stacks);
                    if (stacksForDisplay != null) {
                        stacksForDisplay.accept(stacks);
                    }
                }
            };
        }
    }
}
