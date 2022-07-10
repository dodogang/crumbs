package net.dodogang.crumbs.client;

import net.fabricmc.api.ClientModInitializer;

public class CrumbsClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CrumbsClient.init();

        // Initialization code goes here

        this.postInit();
    }

    public void postInit() {
        CrumbsClient.postInit();

        // Post-initialization code goes here
    }
}
