package net.dodogang.ash.registry.impl;

import net.dodogang.ash.registry.api.RegistryBatch;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public class RegistryBatchImpl<T> extends RegistryBatch<T> {
    protected RegistryBatchImpl(Registry<T> registry, String modId) {
        super(registry, modId);
    }

    @Override
    protected <E> RegistryBatch<E> initialize(Registry<E> registry, String modId) {
        return new RegistryBatchImpl<>(registry, modId);
    }

    @Override
    public <E extends T> Supplier<E> register(String key, Supplier<E> entry) {
        return () -> Registry.register(this.registry, new ResourceLocation(this.modId, key), entry.get());
    }

    @Override
    public void bootstrap() {}
}