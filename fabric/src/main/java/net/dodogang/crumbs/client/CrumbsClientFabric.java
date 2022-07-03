package net.dodogang.crumbs.client;

import net.fabricmc.api.ClientModInitializer;

public class CrumbsClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CrumbsClient.clientSetup();
    }
}
