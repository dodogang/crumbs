package net.dodogang.ash.item.api;

import net.dodogang.ash.impl.ImplLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class CreativeModeTabBuilder {
    private static final CreativeModeTabBuilder IMPL = ImplLoader.load(CreativeModeTabBuilder.class);

    public static Builder create(ResourceLocation resLoc) {
        return IMPL.createImpl(resLoc);
    }

    protected abstract Builder createImpl(ResourceLocation resLoc);

    public static abstract class Builder {
        protected final ResourceLocation resLoc;
        protected Supplier<ItemStack> iconSupplier = () -> ItemStack.EMPTY;
        protected Consumer<List<ItemStack>> stacksForDisplay;

        protected Builder(ResourceLocation resLoc) {
            this.resLoc = resLoc;
        }

        public Builder icon(Supplier<ItemStack> iconSupplier) {
            this.iconSupplier = iconSupplier;
            return this;
        }

        public Builder appendItems(Consumer<List<ItemStack>> stacksForDisplay) {
            this.stacksForDisplay = stacksForDisplay;
            return this;
        }

        public abstract CreativeModeTab build();
    }
}
