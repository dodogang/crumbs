package net.dodogang.crumbs;

import net.dodogang.ash.api.ModEventBus;
import net.dodogang.crumbs.client.CrumbsClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Crumbs.MOD_ID)
public class CrumbsForge {
    public CrumbsForge() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModEventBus.register(Crumbs.MOD_ID, bus);

        bus.<FMLCommonSetupEvent>addListener(event -> Crumbs.postCommonSetup());
        bus.<FMLClientSetupEvent>addListener(event -> CrumbsClient.postClientSetup());

        Crumbs.initialize();

        Crumbs.commonSetup();
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> CrumbsClient::clientSetup);
    }
}
