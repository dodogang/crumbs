package net.dodogang.ash.loader.api;

import net.dodogang.ash.impl.ImplLoader;

import java.nio.file.Path;

public abstract class ModLoader {
    private static final ModLoader IMPL = ImplLoader.load(ModLoader.class);

    /**
     * Get the name of the running mod loader.
     *
     * <p>Possible returns are "fabric", "forge", and "quilt".</p>
     *
     * @return the name of the running mod loader
     */
    public static String getName() {
        return IMPL.getNameImpl();
    }

    /**
     * Checks if a mod with a given ID is loaded.
     *
     * @param modId the ID of the mod
     * @return whether the mod is present in the platform's Loader instance
     */
    public static boolean isModLoaded(String modId) {
        return IMPL.isModLoadedImpl(modId);
    }

    /**
     * Checks if the platform's Loader is currently running in a "development"
     * environment. Can be used for enabling debug mode or additional checks.
     *
     * <p>This should not be used to make assumptions on certain features, such
     * as mappings, but as a toggle for certain functionalities.</p>
     *
     * @return whether the platform's Loader is currently in a "development" environment
     */
    public static boolean isDevelopmentEnvironment() {
        return IMPL.isDevelopmentEnvironmentImpl();
    }

    /**
     * Get the current game working directory.
     *
     * @return the working directory
     */
    public static Path getGameDir() {
        return IMPL.getGameDirImpl();
    }

    /**
     * Get the current directory for game configuration files.
     *
     * @return the configuration directory
     */
    public static Path getConfigDir() {
        return IMPL.getConfigDirImpl();
    }

    protected abstract String getNameImpl();
    protected abstract boolean isModLoadedImpl(String modId);
    protected abstract boolean isDevelopmentEnvironmentImpl();
    protected abstract Path getGameDirImpl();
    protected abstract Path getConfigDirImpl();
}
