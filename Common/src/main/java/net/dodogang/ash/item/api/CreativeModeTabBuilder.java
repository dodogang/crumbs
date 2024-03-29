package net.dodogang.ash.item.api;

import net.dodogang.ash.impl.ImplLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class CreativeModeTabBuilder {
    /**
     * Creates a {@link CreativeModeTabBuilder} that helps with creating a
     * platform's extension of {@link CreativeModeTab}.
     *
     * @param resLoc the {@link ResourceLocation} will become the name of the
     *               {@link CreativeModeTab} and will be used for the translation key
     * @return a {@link CreativeModeTabBuilder}
     */
    public static CreativeModeTabBuilder create(ResourceLocation resLoc) {
        return ImplLoader.load(CreativeModeTabBuilder.class, resLoc);
    }

    protected final ResourceLocation resLoc;
    protected Supplier<ItemStack> iconSupplier = () -> ItemStack.EMPTY;
    protected Consumer<List<ItemStack>> stacksForDisplay;

    protected CreativeModeTabBuilder(ResourceLocation resLoc) {
        this.resLoc = resLoc;
    }

    /**
     * Adds an icon to the {@link CreativeModeTab}.
     *
     * @param iconSupplier the supplier should return the {@link ItemStack}
     *                     that you wish to show on the tab
     * @return this
     */
    public CreativeModeTabBuilder icon(Supplier<ItemStack> iconSupplier) {
        this.iconSupplier = iconSupplier;
        return this;
    }

    /**
     * Adds a custom list of items to be displayed in a tab, such as items
     * with enchantments, potions, or other NBT values.
     *
     * @param stacksForDisplay add {@link ItemStack}s to this list to show
     *                         in the {@link CreativeModeTab}
     * @return this
     */
    public CreativeModeTabBuilder appendItems(Consumer<List<ItemStack>> stacksForDisplay) {
        this.stacksForDisplay = stacksForDisplay;
        return this;
    }

    /**
     * @return a new {@link CreativeModeTab}
     */
    public abstract CreativeModeTab build();
}
