package net.dodogang.crumbs.quilt;

import net.dodogang.crumbs.Crumbs;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class CrumbsQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        Crumbs.initialize();
    }
}
