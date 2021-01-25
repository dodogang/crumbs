package net.dodogang.crumbs.forge.client;

import net.dodogang.crumbs.client.CrumbsClient;
import net.dodogang.crumbs.client.platform.AbstractPlatformClient;
import net.dodogang.crumbs.forge.client.mixin.ItemAccessor;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
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
    public <T extends BlockEntity> void registerBlockEntityRenderer(BlockEntityType<T> beType, Function<BlockEntityRenderDispatcher, BlockEntityRenderer<T>> renderer) {
        ClientRegistry.bindTileEntityRenderer(beType, renderer);
    }

    @Override
    public void registerBuiltinItemRendererForBlock(Block block, BlockEntity blockEntity) {
        ItemAccessor item = (ItemAccessor) block.asItem();
        if (item == Items.AIR) {
            throw new RuntimeException(String.format("Attempted to register a Builtin Item Renderer for a block without an item: %s.", block));
        }
        item.setIster(() -> new CustomBuiltinModelItemRenderer(blockEntity));
    }

    private static class CustomBuiltinModelItemRenderer extends BuiltinModelItemRenderer {
        private final BlockEntity blockEntity;

        public CustomBuiltinModelItemRenderer(BlockEntity blockEntity) {
            this.blockEntity = blockEntity;
        }

        @Override
        public void render(ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
            matrices.push();
            BlockEntityRenderDispatcher.INSTANCE.renderEntity(blockEntity, matrices, vertexConsumers, light, overlay);
            matrices.pop();
        }
    }

    @Override
    public void registerSpritesToAtlas(Identifier atlas, Identifier... spriteLocations) {
        FMLJavaModLoadingContext.get().getModEventBus().<TextureStitchEvent.Pre>addListener(event -> {
            if (event.getMap().getId().equals(atlas)) {
                for (Identifier spriteLocation : spriteLocations) {
                    event.addSprite(spriteLocation);
                }
            }
        });
    }
}
