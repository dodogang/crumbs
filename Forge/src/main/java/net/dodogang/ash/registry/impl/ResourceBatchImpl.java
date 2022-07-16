package net.dodogang.ash.registry.impl;

import net.dodogang.ash.api.ModEventBus;
import net.dodogang.ash.registry.api.ResourceBatch;
import net.minecraft.core.Registry;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ResourceBatchImpl<T> extends ResourceBatch<T> {
    private final DeferredRegister<T> deferredRegister;

    public ResourceBatchImpl(Registry<T> registry, String modId) {
        super(registry, modId);
        this.deferredRegister = DeferredRegister.create(registry.key(), modId);
    }

    @Override
    public <R extends T> Supplier<R> add(String name, Supplier<R> resource) {
        return this.deferredRegister.register(name, resource);
    }

    @Override
    protected void registerImpl() {
        this.deferredRegister.register(ModEventBus.get(this.modId).orElseThrow(() -> new IllegalStateException(
                "Attempted to register ResourceBatch before registering a ModEventBus for " + this.modId + "."
        )));
    }
}
