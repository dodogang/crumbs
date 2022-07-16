package net.dodogang.crumbs.client;

import net.dodogang.ash.client.api.RenderTypeMap;
import net.dodogang.ash.client.gui.api.MenuToScreenRegistry;
import net.dodogang.crumbs.block.CrumbsBlocks;
import net.dodogang.crumbs.client.gui.CarpentryTableScreen;
import net.dodogang.crumbs.inventory.CrumbsMenuTypes;
import net.minecraft.client.renderer.RenderType;

public class CrumbsClient {
    public static void init() {
        // Initialization code goes here
    }

    public static void postInit() {
        RenderTypeMap.put(RenderType.cutout(), CrumbsBlocks.CARPENTRY_TABLE.get());
        MenuToScreenRegistry.register(CrumbsMenuTypes.CARPENTRY_TABLE.get(), CarpentryTableScreen::new);
    }
}