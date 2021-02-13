package net.dodogang.crumbs.client;

import net.dodogang.crumbs.block.CrumbsBlocks;
import net.dodogang.crumbs.block.entity.CrumbsBlockEntityTypes;
import net.dodogang.crumbs.block.entity.CrumbsChestBlockEntity;
import net.dodogang.crumbs.client.platform.AbstractPlatformClient;
import net.dodogang.crumbs.client.renderer.CrumbsChestRenderer;
import net.dodogang.crumbs.client.renderer.CrumbsAtlasTextures;

public class CrumbsClient {
    public static AbstractPlatformClient platform;

    public static void init(AbstractPlatformClient platform) {
        CrumbsClient.platform = platform;

        new CrumbsAtlasTextures();
    }

    public static void setup() {
        registerBlockEntityRenderers();
        registerBuiltInItemRenderers();
    }

    public static void registerBlockEntityRenderers() {
        platform.registerBlockEntityRenderer(CrumbsBlockEntityTypes.CRUMBS_CHEST.get(), CrumbsChestRenderer::new);
    }

    public static void registerBuiltInItemRenderers() {
        platform.registerBuiltinItemRendererForBlock(CrumbsBlocks.SPRUCE_CHEST.get(), new CrumbsChestBlockEntity(CrumbsBlocks.SPRUCE_CHEST.get()));
        platform.registerBuiltinItemRendererForBlock(CrumbsBlocks.BIRCH_CHEST.get(), new CrumbsChestBlockEntity(CrumbsBlocks.BIRCH_CHEST.get()));
        platform.registerBuiltinItemRendererForBlock(CrumbsBlocks.JUNGLE_CHEST.get(), new CrumbsChestBlockEntity(CrumbsBlocks.JUNGLE_CHEST.get()));
        platform.registerBuiltinItemRendererForBlock(CrumbsBlocks.ACACIA_CHEST.get(), new CrumbsChestBlockEntity(CrumbsBlocks.ACACIA_CHEST.get()));
        platform.registerBuiltinItemRendererForBlock(CrumbsBlocks.DARK_OAK_CHEST.get(), new CrumbsChestBlockEntity(CrumbsBlocks.DARK_OAK_CHEST.get()));
        platform.registerBuiltinItemRendererForBlock(CrumbsBlocks.CRIMSON_CHEST.get(), new CrumbsChestBlockEntity(CrumbsBlocks.CRIMSON_CHEST.get()));
        platform.registerBuiltinItemRendererForBlock(CrumbsBlocks.WARPED_CHEST.get(), new CrumbsChestBlockEntity(CrumbsBlocks.WARPED_CHEST.get()));
    }
}
