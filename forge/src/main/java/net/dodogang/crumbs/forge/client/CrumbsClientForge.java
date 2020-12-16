package net.dodogang.crumbs.forge.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.dodogang.crumbs.client.CrumbsClient;
import net.dodogang.crumbs.client.platform.AbstractPlatformClient;
import net.dodogang.crumbs.forge.mixin.ClientItemAccessor;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.function.Function;

public class CrumbsClientForge implements AbstractPlatformClient {
    public CrumbsClientForge() {
        CrumbsClient.init(this);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    public void setup(FMLClientSetupEvent event) {
        CrumbsClient.setup();
    }

    @Override
    public <T extends TileEntity> void registerBlockEntityRenderer(TileEntityType<T> beType, Function<TileEntityRendererDispatcher, TileEntityRenderer<T>> renderer) {
        ClientRegistry.bindTileEntityRenderer(beType, renderer);
    }

    @Override
    public void registerSpritesToAtlas(ResourceLocation atlas, ResourceLocation... spriteLocations) {
        FMLJavaModLoadingContext.get().getModEventBus().<TextureStitchEvent.Pre>addListener(event -> {
            if (event.getMap().location().equals(atlas)) {
                for (ResourceLocation spriteLocation : spriteLocations) {
                    event.addSprite(spriteLocation);
                }
            }
        });
    }

    @Override
    public void registerBuiltinItemRendererForBlock(Block block, TileEntity blockEntity) {
        ClientItemAccessor item = (ClientItemAccessor) block.asItem();
        if (item == Items.AIR) {
            throw new RuntimeException(String.format("Attempted to register a Builtin Item Renderer for a block without an item: %s.", block));
        }
        item.setIster(() -> new BuiltInItemRenderer(block, blockEntity));
    }

    private class BuiltInItemRenderer extends ItemStackTileEntityRenderer {
        private final Block block;
        private TileEntity blockEntity;

        public BuiltInItemRenderer(Block block, TileEntity blockEntity) {
            this.block = block;
            this.blockEntity = blockEntity;
        }

        @Override
        public void renderByItem(ItemStack stack, ItemCameraTransforms.TransformType type, MatrixStack matrices, IRenderTypeBuffer vertexConsumers, int light, int overlay) {
            matrices.pushPose();
            TileEntityRendererDispatcher.instance.renderItem(blockEntity, matrices, vertexConsumers, light, overlay);
            matrices.popPose();
        }
    }
}
