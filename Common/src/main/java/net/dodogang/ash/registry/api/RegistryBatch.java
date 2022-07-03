package net.dodogang.ash.registry.api;

import net.dodogang.ash.impl.ImplLoader;
import net.minecraft.core.Registry;

import java.util.function.Supplier;

public abstract class RegistryBatch<T> {
    private static final RegistryBatch<?> IMPL = ImplLoader.load(RegistryBatch.class);

    protected final Registry<T> registry;
    protected final String modId;
    protected boolean isPresent;

    protected RegistryBatch(Registry<T> registry, String modId) {
        this.registry = registry;
        this.modId = modId;
        this.isPresent = false;
    }

    public static <T> RegistryBatch<T> create(Registry<T> registry, String modId) {
        IMPL.isPresent = false;
        return IMPL.initialize(registry, modId);
    }

    public abstract <E extends T> Supplier<E> register(String key, Supplier<E> entry);

    public void register() {
        if (IMPL.isPresent) throw new IllegalArgumentException("Duplication of Registry: " + this.registry);
        this.isPresent = true;
        this.bootstrap();
    }

    public abstract void bootstrap();

    protected abstract <E> RegistryBatch<E> initialize(Registry<E> registry, String modId);
    protected abstract void setPresence(boolean flag);
    protected abstract boolean isPresent();
    protected abstract boolean getRegistry();
}