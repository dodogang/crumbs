package net.dodogang.crumbs;

import net.dodogang.ash.api.ModEventBus;
import net.dodogang.crumbs.client.CrumbsClientForge;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Crumbs.MOD_ID)
public class CrumbsForge {
    public CrumbsForge() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModEventBus.register(Crumbs.MOD_ID, bus);

        bus.addListener(this::setup);

        Crumbs.init();
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> CrumbsClientForge::new);

        // Initialization code goes here
    }

    private void setup(FMLCommonSetupEvent event) {
        Crumbs.postInit();

        // Post-initialization code goes here
    }
}
