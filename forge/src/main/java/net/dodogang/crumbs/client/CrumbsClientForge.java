package net.dodogang.crumbs.client;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class CrumbsClientForge {
    public CrumbsClientForge() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        CrumbsClient.init();

        // Initialization code goes here
    }

    private void setup(FMLClientSetupEvent event) {
        CrumbsClient.postInit();

        // Post-initialization code goes here
    }
}