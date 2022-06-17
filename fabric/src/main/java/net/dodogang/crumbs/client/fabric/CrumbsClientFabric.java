package net.dodogang.crumbs.client.fabric;

import net.dodogang.crumbs.client.CrumbsClient;
import net.fabricmc.api.ClientModInitializer;

public class CrumbsClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CrumbsClient.initialize();
    }
}
