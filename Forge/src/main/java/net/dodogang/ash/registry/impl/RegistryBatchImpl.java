package net.dodogang.ash.registry.impl;

import net.dodogang.ash.EventBuses;
import net.dodogang.ash.registry.api.RegistryBatch;
import net.minecraft.core.Registry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RegistryBatchImpl<T> extends RegistryBatch<T> {
    private final DeferredRegister<T> registry;

    protected RegistryBatchImpl(Registry<T> registry, String modId) {
        super(registry, modId);
        this.registry = DeferredRegister.create(registry.key(), modId);
    }

    @Override
    protected <E> RegistryBatch<E> initialize(Registry<E> registry, String modId) {
        return new RegistryBatchImpl<>(registry, modId);
    }

    @Override
    public <E extends T> Supplier<E> register(String key, Supplier<E> entry) {
        return this.registry.register(key, entry);
    }

    @Override
    public void bootstrap() {
        IEventBus bus = EventBuses.getModEventBus(this.modId).orElseThrow(() -> new IllegalStateException("Attempted to register stuff before registering a Mod Event Bus for: " + this.modId));
        this.registry.register(bus);
    }
}