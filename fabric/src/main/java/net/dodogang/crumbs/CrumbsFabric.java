package net.dodogang.crumbs;

import net.fabricmc.api.ModInitializer;

public class CrumbsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Crumbs.initialize();
    }
}
