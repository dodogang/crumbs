package net.dodogang.ash;

import net.minecraftforge.eventbus.api.IEventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class EventBuses {
    private static final HashMap<String, IEventBus> MOD_EVENT_BUSES = new HashMap<>();
    private static final Map<String, List<Consumer<IEventBus>>> ON_REGISTERED = new HashMap<>();

    public static void registerModEventBus(String modId, IEventBus bus) {
        IEventBus previousBus = MOD_EVENT_BUSES.put(modId, bus);
        if (previousBus != null) {
            throw new IllegalStateException("Attempted to register a mod event bus for modid '" + modId + "' twice.");
        }
    }

    public static void onRegistered(String modId, Consumer<IEventBus> busConsumer) {
        if (MOD_EVENT_BUSES.containsKey(modId)) {
            busConsumer.accept(MOD_EVENT_BUSES.get(modId));
        } else {
            synchronized (ON_REGISTERED) {
                ON_REGISTERED.computeIfAbsent(modId, s -> new ArrayList<>()).add(busConsumer);
            }
        }
    }

    public static Optional<IEventBus> getModEventBus(String modId) {
        return Optional.ofNullable(MOD_EVENT_BUSES.get(modId));
    }

    public static IEventBus getModEventBusOrThrow(String modId) {
        return getModEventBus(modId).orElseThrow(
                () -> new IllegalStateException("Mod Event Bus for modid '" + modId + "' has not been registered.")
        );
    }
}