package net.dodogang.crumbs.client;

import com.google.common.reflect.Reflection;
import net.dodogang.crumbs.block.CrumbsBlocks;
import net.dodogang.crumbs.block.entity.CrumbsBlockEntityTypes;
import net.dodogang.crumbs.block.entity.WoodenChestBlockEntity;
import net.dodogang.crumbs.client.render.CrumbsAtlasTextures;
import net.dodogang.crumbs.client.render.block.entity.WoodenChestRenderer;
import net.dodogang.plume.ash.client.registry.BlockEntityRendererRegistry;
import net.dodogang.plume.ash.client.registry.BuiltinItemRendererRegistry;
import net.dodogang.plume.ash.client.registry.RenderLayerRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class CrumbsClient {
    private CrumbsClient() {}

    @SuppressWarnings("UnstableApiUsage")
    public static void initialize() {
        Reflection.initialize(
            CrumbsAtlasTextures.class
        );
        setBlockRenderLayers();
    }

    public static void setup() {
        registerBlockEntityRenderers();
        registerBuiltInItemRenderers();
    }

    private static void registerBlockEntityRenderers() {
        BlockEntityRendererRegistry.register(CrumbsBlockEntityTypes.WOODEN_CHEST, WoodenChestRenderer::new);
    }

    private static void registerBuiltInItemRenderers() {
        BuiltinItemRendererRegistry.registerBlockEntityRenderer(CrumbsBlocks.OAK_CHEST, new WoodenChestBlockEntity(CrumbsBlocks.OAK_CHEST));
        BuiltinItemRendererRegistry.registerBlockEntityRenderer(CrumbsBlocks.SPRUCE_CHEST, new WoodenChestBlockEntity(CrumbsBlocks.SPRUCE_CHEST));
        BuiltinItemRendererRegistry.registerBlockEntityRenderer(CrumbsBlocks.BIRCH_CHEST, new WoodenChestBlockEntity(CrumbsBlocks.BIRCH_CHEST));
        BuiltinItemRendererRegistry.registerBlockEntityRenderer(CrumbsBlocks.JUNGLE_CHEST, new WoodenChestBlockEntity(CrumbsBlocks.JUNGLE_CHEST));
        BuiltinItemRendererRegistry.registerBlockEntityRenderer(CrumbsBlocks.ACACIA_CHEST, new WoodenChestBlockEntity(CrumbsBlocks.ACACIA_CHEST));
        BuiltinItemRendererRegistry.registerBlockEntityRenderer(CrumbsBlocks.DARK_OAK_CHEST, new WoodenChestBlockEntity(CrumbsBlocks.DARK_OAK_CHEST));
        BuiltinItemRendererRegistry.registerBlockEntityRenderer(CrumbsBlocks.CRIMSON_CHEST, new WoodenChestBlockEntity(CrumbsBlocks.CRIMSON_CHEST));
        BuiltinItemRendererRegistry.registerBlockEntityRenderer(CrumbsBlocks.WARPED_CHEST, new WoodenChestBlockEntity(CrumbsBlocks.WARPED_CHEST));
    }

    private static void setBlockRenderLayers() {
        RenderLayerRegistry.setRenderLayer(
            RenderLayer.getCutoutMipped(),
                CrumbsBlocks.SPRUCE_LADDER,
                CrumbsBlocks.BIRCH_LADDER,
                CrumbsBlocks.JUNGLE_LADDER,
                CrumbsBlocks.ACACIA_LADDER,
                CrumbsBlocks.DARK_OAK_LADDER,
                CrumbsBlocks.CRIMSON_LADDER,
                CrumbsBlocks.WARPED_LADDER
        );
    }
}
