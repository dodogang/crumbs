package net.dodogang.crumbs;

import net.fabricmc.api.ModInitializer;

public class CrumbsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Crumbs.init();

        // Initialization code goes here

        this.postInit();
    }

    public void postInit() {
        Crumbs.postInit();

        // Post-initialization code goes here
    }
}
