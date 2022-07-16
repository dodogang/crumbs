package net.dodogang.ash.client.gui.impl;

import net.dodogang.ash.client.gui.api.MenuToScreenRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

public class MenuToScreenRegistryImpl extends MenuToScreenRegistry {
    @Override
    protected <M extends AbstractContainerMenu, U extends Screen & MenuAccess<M>> void registerImpl(
            MenuType<? extends M> menuType,
            MenuToScreenRegistry.ScreenConstructor<M, U> screenConstructor
    ) {
        MenuScreens.register(menuType, screenConstructor::create);
    }
}
