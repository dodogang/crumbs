package net.dodogang.crumbs;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class CrumbsQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        Crumbs.init();

        // Initialization code goes here

        this.setup();
    }

    private void setup() {
        Crumbs.postInit();

        // Post-initialization code goes here
    }
}
