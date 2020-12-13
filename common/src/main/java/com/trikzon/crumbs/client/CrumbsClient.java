package com.trikzon.crumbs.client;

import com.trikzon.crumbs.block.CrumbsBlocks;
import com.trikzon.crumbs.block.entity.CrumbsBlockEntityType;
import com.trikzon.crumbs.block.entity.CrumbsChestBlockEntity;
import com.trikzon.crumbs.client.platform.AbstractPlatformClient;
import com.trikzon.crumbs.client.renderer.CrumbsChestRenderer;
import com.trikzon.crumbs.client.renderer.CrumbsSpriteSheets;

public class CrumbsClient {
    public static AbstractPlatformClient platform;

    public static void init(AbstractPlatformClient platform) {
        CrumbsClient.platform = platform;

        new CrumbsSpriteSheets();
    }

    public static void setup() {
        registerBlockEntityRenderers();
        registerBuiltInItemRenderers();
    }

    public static void registerBlockEntityRenderers() {
        platform.registerBlockEntityRenderer(CrumbsBlockEntityType.CRUMBS_CHEST, CrumbsChestRenderer::new);
    }

    public static void registerBuiltInItemRenderers() {
        platform.registerBuiltinItemRendererForBlock(CrumbsBlocks.SPRUCE_CHEST, new CrumbsChestBlockEntity(CrumbsBlocks.SPRUCE_CHEST));
        platform.registerBuiltinItemRendererForBlock(CrumbsBlocks.BIRCH_CHEST, new CrumbsChestBlockEntity(CrumbsBlocks.BIRCH_CHEST));
        platform.registerBuiltinItemRendererForBlock(CrumbsBlocks.JUNGLE_CHEST, new CrumbsChestBlockEntity(CrumbsBlocks.JUNGLE_CHEST));
        platform.registerBuiltinItemRendererForBlock(CrumbsBlocks.ACACIA_CHEST, new CrumbsChestBlockEntity(CrumbsBlocks.ACACIA_CHEST));
        platform.registerBuiltinItemRendererForBlock(CrumbsBlocks.DARK_OAK_CHEST, new CrumbsChestBlockEntity(CrumbsBlocks.DARK_OAK_CHEST));
        platform.registerBuiltinItemRendererForBlock(CrumbsBlocks.CRIMSON_CHEST, new CrumbsChestBlockEntity(CrumbsBlocks.CRIMSON_CHEST));
        platform.registerBuiltinItemRendererForBlock(CrumbsBlocks.WARPED_CHEST, new CrumbsChestBlockEntity(CrumbsBlocks.WARPED_CHEST));
    }
}
