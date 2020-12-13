package com.trikzon.crumbs.client;

import com.trikzon.crumbs.block.entity.CrumbsBlockEntityType;
import com.trikzon.crumbs.client.platform.AbstractPlatformClient;
import com.trikzon.crumbs.client.renderer.CrumbsChestRenderer;
import com.trikzon.crumbs.client.renderer.CrumbsSpriteSheets;

public class CrumbsClient {
    public static AbstractPlatformClient platform;

    public static void init(AbstractPlatformClient platform) {
        CrumbsClient.platform = platform;

        new CrumbsSpriteSheets();

        registerBlockEntityRenderers();
    }

    public static void registerBlockEntityRenderers() {
        platform.registerBlockEntityRenderer(CrumbsBlockEntityType.CRUMBS_CHEST, CrumbsChestRenderer::new);
    }
}
