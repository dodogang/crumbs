package net.dodogang.ash.loader.impl;

import net.dodogang.ash.loader.api.ModLoader;
import org.quiltmc.loader.api.QuiltLoader;

import java.nio.file.Path;

public class ModLoaderImpl extends ModLoader {
    @Override
    protected String getNameImpl() {
        return "quilt";
    }

    @Override
    protected boolean isModLoadedImpl(String modId) {
        return QuiltLoader.isModLoaded(modId);
    }

    @Override
    protected boolean isDevelopmentEnvironmentImpl() {
        return QuiltLoader.isDevelopmentEnvironment();
    }

    @Override
    protected Path getGameDirImpl() {
        return QuiltLoader.getGameDir();
    }

    @Override
    protected Path getConfigDirImpl() {
        return QuiltLoader.getConfigDir();
    }
}
