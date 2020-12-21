package net.dodogang.crumbs.client;

import net.dodogang.crumbs.block.CrumbsBlocks;
import net.dodogang.crumbs.block.entity.CrumbsBlockEntityType;
import net.dodogang.crumbs.block.entity.CrumbsChestBlockEntity;
import net.dodogang.crumbs.client.platform.AbstractPlatformClient;
import net.dodogang.crumbs.client.renderer.CrumbsChestRenderer;
import net.dodogang.crumbs.client.renderer.CrumbsSpriteSheets;

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
