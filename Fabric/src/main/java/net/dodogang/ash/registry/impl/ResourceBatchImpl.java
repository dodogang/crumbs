package net.dodogang.ash.registry.impl;

import net.dodogang.ash.registry.api.ResourceBatch;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public class ResourceBatchImpl<T> extends ResourceBatch<T> {
    public ResourceBatchImpl(Registry<T> registry, String modId) {
        super(registry, modId);
    }

    @Override
    public <R extends T> Supplier<R> add(String name, Supplier<R> resource) {
        // registeredEntry is computed outside the lambda so that the entry is
        // not registered repeatedly every time the `get() is run.
        R registeredEntry = Registry.register(
                this.registry,
                new ResourceLocation(this.modId, name),
                resource.get()
        );
        // We only return a Supplier to correctly support forge's
        // DeferredRegister system.
        return () -> registeredEntry;
    }

    @Override
    protected void registerImpl() {
        // NOP: Not necessary on fabric because we can just directly register
        // to the vanilla Registry instead of forge's over-engineered
        // DeferredRegister system.
    }
}
