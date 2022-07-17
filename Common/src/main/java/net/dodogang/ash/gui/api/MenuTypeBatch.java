package net.dodogang.ash.gui.api;

import net.dodogang.ash.impl.ImplLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public abstract class MenuTypeBatch {
    /**
     * Creates a {@link MenuTypeBatch} for creating and registering
     * {@link MenuType}s. New types can be created and added to the batch by
     * calling {@link MenuTypeBatch#add(String, MenuSupplier)} and the
     * types can all be registered to the game by calling
     * {@link MenuTypeBatch#register()}.
     *
     * @param modId the mod id for all menu types added to the registry
     * @return a {@link MenuTypeBatch}
     */
    public static MenuTypeBatch create(String modId) {
        return ImplLoader.load(MenuTypeBatch.class, modId);
    }

    protected final String modId;

    protected boolean registered;

    protected MenuTypeBatch(String modId) {
        this.modId = modId;
        this.registered = false;
    }

    /**
     * Creates and adds a {@link MenuType} to the batch to be registered.
     *
     * <p>On fabric and quilt the menu type will be registered instantly.</p>
     *
     * <p>On forge the menu type will be registered when
     * {@link MenuTypeBatch#register()} is called.</p>
     *
     * @param name the name of the menu type to be combined with the mod id to
     *             become the registered {@link ResourceLocation}
     * @param menuSupplier constructor for creating a custom
     *                     {@link AbstractContainerMenu}
     * @return a supplier which can provide the registered menu type
     * @param <T> type of menu in the menu type
     */
    public abstract <T extends AbstractContainerMenu> Supplier<MenuType<T>> add(String name, MenuSupplier<T> menuSupplier);

    /**
     * Registers all resources added to the batch. Can only be called once per
     * {@link MenuTypeBatch}.
     */
    public void register() {
        if (this.registered) {
            throw new IllegalStateException(String.format(
                    "Attempted to register MenuTypeBatch for mod %s twice.",
                    this.modId
            ));
        }
        this.registered = true;
        this.registerImpl();
    }

    protected abstract void registerImpl();

    @FunctionalInterface
    public interface MenuSupplier<T extends AbstractContainerMenu> {
        T create(int syncId, Inventory inventory);
    }
}
