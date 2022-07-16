package net.dodogang.ash.gui.impl;

import net.dodogang.ash.gui.api.MenuTypeBatch;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public class MenuTypeBatchImpl extends MenuTypeBatch {
    public MenuTypeBatchImpl(String modId) {
        super(modId);
    }

    @Override
    public <T extends AbstractContainerMenu> Supplier<MenuType<T>> add(String name, MenuSupplier<T> menuSupplier) {
        MenuType<T> menuType = new MenuType<>(menuSupplier::create);
        // We only return a Supplier to correctly support forge's
        // DeferredRegister system.
        return () -> menuType;
    }

    @Override
    protected void registerImpl() {
        // NOP: Not necessary on fabric because we can just directly register
        // to the vanilla Registry instead of forge's over-engineered
        // DeferredRegister system.
    }
}
