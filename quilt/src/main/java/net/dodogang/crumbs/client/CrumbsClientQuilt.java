package net.dodogang.crumbs.client;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class CrumbsClientQuilt implements ClientModInitializer {
    @Override
    public void onInitializeClient(ModContainer mod) {
        CrumbsClient.initialize();
    }
}
