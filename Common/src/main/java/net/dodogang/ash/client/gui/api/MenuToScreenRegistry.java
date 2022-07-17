package net.dodogang.ash.client.gui.api;

import net.dodogang.ash.impl.ImplLoader;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

public abstract class MenuToScreenRegistry {
    private static final MenuToScreenRegistry IMPL = ImplLoader.load(MenuToScreenRegistry.class);

    /**
     * Registers a {@link MenuType} to a {@link Screen} through the vanilla
     * {@link MenuScreens#register(MenuType, MenuScreens.ScreenConstructor)}.
     *
     * @param menuType the menu type to pair with a screen
     * @param screenConstructor the constructor of the screen to pair
     */
    public static <M extends AbstractContainerMenu, U extends Screen & MenuAccess<M>> void register(
            MenuType<? extends M> menuType,
            ScreenConstructor<M, U> screenConstructor
    ) {
        IMPL.registerImpl(menuType, screenConstructor);
    }

    protected abstract <M extends AbstractContainerMenu, U extends Screen & MenuAccess<M>> void registerImpl(
            MenuType<? extends M> menuType,
            ScreenConstructor<M, U> screenConstructor
    );

    @FunctionalInterface
    public interface ScreenConstructor<T extends AbstractContainerMenu, U extends Screen & MenuAccess<T>> {
        U create(T abstractContainerMenu, Inventory inventory, Component component);
    }
}
