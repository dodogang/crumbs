package net.dodogang.crumbs.forge;

import net.dodogang.crumbs.Crumbs;
import net.dodogang.crumbs.client.forge.CrumbsClientForge;
import net.dodogang.plume.ash.forge.ModEventBus;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Crumbs.MOD_ID)
public class CrumbsForge {
    public CrumbsForge() {
        ModEventBus.registerModEventBus(Crumbs.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        Crumbs.initialize();

        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> CrumbsClientForge::new);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    public void setup(FMLCommonSetupEvent event) {
        Crumbs.setup();
    }
}
