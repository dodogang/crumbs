package net.dodogang.crumbs.client;

import net.dodogang.crumbs.block.CrumbsBlocks;
import net.dodogang.crumbs.block.entity.CrumbsBlockEntityTypes;
import net.dodogang.crumbs.block.entity.WoodenChestBlockEntity;
import net.dodogang.crumbs.client.render.CrumbsAtlasTextures;
import net.dodogang.crumbs.client.render.block.entity.WoodenChestRenderer;
import net.dodogang.plume.ash.client.registry.BlockEntityRendererRegistry;
import net.dodogang.plume.ash.client.registry.BuiltinItemRendererRegistry;

public class CrumbsClient {
    private CrumbsClient() {}

    public static void initialize() {
        CrumbsAtlasTextures.register();
    }

    public static void setup() {
        registerBlockEntityRenderers();
        registerBuiltInItemRenderers();
    }

    public static void registerBlockEntityRenderers() {
        BlockEntityRendererRegistry.register(CrumbsBlockEntityTypes.WOODEN_CHEST.get(), WoodenChestRenderer::new);
    }

    public static void registerBuiltInItemRenderers() {
        BuiltinItemRendererRegistry.registerBlockEntityRenderer(
                CrumbsBlocks.OAK_CHEST.get(),
                new WoodenChestBlockEntity(CrumbsBlocks.OAK_CHEST.get())
        );
        BuiltinItemRendererRegistry.registerBlockEntityRenderer(
                CrumbsBlocks.SPRUCE_CHEST.get(),
                new WoodenChestBlockEntity(CrumbsBlocks.SPRUCE_CHEST.get())
        );
        BuiltinItemRendererRegistry.registerBlockEntityRenderer(
                CrumbsBlocks.BIRCH_CHEST.get(),
                new WoodenChestBlockEntity(CrumbsBlocks.BIRCH_CHEST.get())
        );
        BuiltinItemRendererRegistry.registerBlockEntityRenderer(
                CrumbsBlocks.JUNGLE_CHEST.get(),
                new WoodenChestBlockEntity(CrumbsBlocks.JUNGLE_CHEST.get())
        );
        BuiltinItemRendererRegistry.registerBlockEntityRenderer(
                CrumbsBlocks.ACACIA_CHEST.get(),
                new WoodenChestBlockEntity(CrumbsBlocks.ACACIA_CHEST.get())
        );
        BuiltinItemRendererRegistry.registerBlockEntityRenderer(
                CrumbsBlocks.DARK_OAK_CHEST.get(),
                new WoodenChestBlockEntity(CrumbsBlocks.DARK_OAK_CHEST.get())
        );
        BuiltinItemRendererRegistry.registerBlockEntityRenderer(
                CrumbsBlocks.CRIMSON_CHEST.get(),
                new WoodenChestBlockEntity(CrumbsBlocks.CRIMSON_CHEST.get())
        );
        BuiltinItemRendererRegistry.registerBlockEntityRenderer(
                CrumbsBlocks.WARPED_CHEST.get(),
                new WoodenChestBlockEntity(CrumbsBlocks.WARPED_CHEST.get())
        );
    }
}
