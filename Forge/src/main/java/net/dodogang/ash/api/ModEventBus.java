package net.dodogang.ash.api;

import net.minecraftforge.eventbus.api.IEventBus;

import java.util.HashMap;
import java.util.Optional;

public class ModEventBus {
    private ModEventBus() {}

    private static final HashMap<String, IEventBus> MOD_EVENT_BUSES = new HashMap<>();

    /**
     * Register a mod's Forge mod event bus for Ash to register events on.
     *
     * <p>{@code FMLJavaModLoadingContext.get().getModEventBus()}</p>
     *
     * @param modId the mod's mod id
     * @param bus the mod's Forge mod event bus
     */
    public static void register(String modId, IEventBus bus) {
        IEventBus previousBus = MOD_EVENT_BUSES.put(modId, bus);
        if (previousBus != null) {
            throw new IllegalStateException("Attempted to register a mod event bus for " + modId + " twice.");
        }
    }

    /**
     * Get the Forge mod event bus for the given mod id
     *
     * @param modId the mod id
     * @return the Forge mod event bus for the given mod id
     */
    public static Optional<IEventBus> get(String modId) {
        return Optional.ofNullable(MOD_EVENT_BUSES.get(modId));
    }

    /**
     * Convenience method of {@link ModEventBus#get(String)}.
     *
     * <p>Instead of returning Optional, simply returns the event bus if it
     * exists, or throws an exception if it doesn't.</p>
     *
     * @param modId the mod id
     * @return the Forge mod event bus for the given mod id
     */
    public static IEventBus getOrThrow(String modId) {
        return ModEventBus.get(modId).orElseThrow(
                () -> new IllegalStateException("Mod Event Bus for " + modId + "has not been registered.")
        );
    }
}
