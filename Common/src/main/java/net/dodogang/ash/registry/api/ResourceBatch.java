package net.dodogang.ash.registry.api;

import net.dodogang.ash.impl.ImplLoader;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public abstract class ResourceBatch<T> {
    /**
     * Creates a {@link ResourceBatch} for a specific {@link Registry}.
     * Resources can be added to the batch by calling
     * {@link ResourceBatch#add(String, Supplier)} and the resources can all
     * be registered to the game by calling {@link ResourceBatch#register()}.
     *
     * @param registry the registry to add resources to
     * @param modId the mod id for all resources added to the registry
     * @return a {@link ResourceBatch}
     * @param <T> the resource type
     */
    public static <T> ResourceBatch<T> create(Registry<T> registry, String modId) {
        return ImplLoader.load(ResourceBatch.class, new Class[]{Registry.class, String.class}, registry, modId);
    }

    protected final Registry<T> registry;
    protected final String modId;

    protected boolean registered;

    protected ResourceBatch(Registry<T> registry, String modId) {
        this.registry = registry;
        this.modId = modId;
        this.registered = false;
    }

    /**
     * Adds a resource to the batch to be registered.
     *
     * <p>On fabric and quilt the resource will be registered instantly.</p>
     *
     * <p>On forge the resource will be registered when
     * {@link ResourceBatch#register()} is called.</p>
     *
     * @param name the name of the resource to be combined with the mod id to
     *             become the registered {@link ResourceLocation}.
     * @param resource the resource to be registered
     * @return a supplier which can provide the registered resource
     * @param <R> the resource type
     */
    public abstract <R extends T> Supplier<R> add(String name, Supplier<R> resource);

    /**
     * Registers all resources added to the batch. Can only be called once per
     * {@link ResourceBatch}.
     */
    public void register() {
        if (this.registered) {
            throw new IllegalStateException(String.format(
                    "Attempted to register ResourceBatch of registry %s for mod %s twice.",
                    this.registry,
                    this.modId
            ));
        }
        this.registered = true;
        this.registerImpl();
    }

    protected abstract void registerImpl();
}
