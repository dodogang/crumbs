package net.dodogang.crumbs.fabric;

import net.dodogang.crumbs.Crumbs;
import net.fabricmc.api.ModInitializer;

public class CrumbsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Crumbs.initialize();
        Crumbs.setup();
    }

}
