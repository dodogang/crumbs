package net.dodogang.crumbs.client.forge;

import net.dodogang.crumbs.client.CrumbsClient;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class CrumbsClientForge {
    public CrumbsClientForge() {
        CrumbsClient.initialize();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    public void setup(FMLClientSetupEvent event) {
        CrumbsClient.setup();
    }
}
