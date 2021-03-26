package net.dodogang.crumbs.client;

import net.dodogang.crumbs.block.CrumbsBlocks;
import net.dodogang.crumbs.block.entity.CrumbsBlockEntityTypes;
import net.dodogang.crumbs.block.entity.WoodenChestBlockEntity;
import net.dodogang.crumbs.client.platform.AbstractPlatformClient;
import net.dodogang.crumbs.client.render.CrumbsAtlasTextures;
import net.dodogang.crumbs.client.render.block.entity.WoodenChestRenderer;

public class CrumbsClient {
    private CrumbsClient() {}

    public static AbstractPlatformClient platform;

    public static void initialize(AbstractPlatformClient platform) {
        CrumbsClient.platform = platform;

        CrumbsAtlasTextures.register();
    }

    public static void setup() {
        registerBlockEntityRenderers();
        registerBuiltInItemRenderers();
    }

    public static void registerBlockEntityRenderers() {
        platform.registerBlockEntityRenderer(CrumbsBlockEntityTypes.WOODEN_CHEST.get(), WoodenChestRenderer::new);
    }

    public static void registerBuiltInItemRenderers() {
        platform.registerBuiltInItemRendererForBlock(
                CrumbsBlocks.SPRUCE_CHEST.get(),
                new WoodenChestBlockEntity(CrumbsBlocks.SPRUCE_CHEST.get())
        );
        platform.registerBuiltInItemRendererForBlock(
                CrumbsBlocks.BIRCH_CHEST.get(),
                new WoodenChestBlockEntity(CrumbsBlocks.BIRCH_CHEST.get())
        );
        platform.registerBuiltInItemRendererForBlock(
                CrumbsBlocks.JUNGLE_CHEST.get(),
                new WoodenChestBlockEntity(CrumbsBlocks.JUNGLE_CHEST.get())
        );
        platform.registerBuiltInItemRendererForBlock(
                CrumbsBlocks.ACACIA_CHEST.get(),
                new WoodenChestBlockEntity(CrumbsBlocks.ACACIA_CHEST.get())
        );
        platform.registerBuiltInItemRendererForBlock(
                CrumbsBlocks.DARK_OAK_CHEST.get(),
                new WoodenChestBlockEntity(CrumbsBlocks.DARK_OAK_CHEST.get())
        );
        platform.registerBuiltInItemRendererForBlock(
                CrumbsBlocks.CRIMSON_CHEST.get(),
                new WoodenChestBlockEntity(CrumbsBlocks.CRIMSON_CHEST.get())
        );
        platform.registerBuiltInItemRendererForBlock(
                CrumbsBlocks.WARPED_CHEST.get(),
                new WoodenChestBlockEntity(CrumbsBlocks.WARPED_CHEST.get())
        );
    }
}
