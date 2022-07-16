package net.dodogang.ash.gui.impl;

import net.dodogang.ash.api.ModEventBus;
import net.dodogang.ash.gui.api.MenuTypeBatch;
import net.minecraft.core.Registry;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MenuTypeBatchImpl extends MenuTypeBatch {
    private final DeferredRegister<MenuType<?>> deferredRegister;

    public MenuTypeBatchImpl(String modId) {
        super(modId);
        this.deferredRegister = DeferredRegister.create(Registry.MENU.key(), modId);
    }

    @Override
    public <T extends AbstractContainerMenu> Supplier<MenuType<T>> add(String name, MenuSupplier<T> menuSupplier) {
        return this.deferredRegister.register(name, () -> new MenuType<>((syncId, inventory) ->
                menuSupplier.create(syncId, inventory))
        );
    }

    @Override
    protected void registerImpl() {
        this.deferredRegister.register(ModEventBus.get(this.modId).orElseThrow(() -> new IllegalStateException(
                "Attempted to register MenuTypeBatch before registering a ModEventBus for " + this.modId + "."
        )));
    }
}
