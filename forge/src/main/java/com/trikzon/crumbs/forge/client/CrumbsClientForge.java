package com.trikzon.crumbs.forge.client;

import com.trikzon.crumbs.client.CrumbsClient;
import com.trikzon.crumbs.client.platform.AbstractPlatformClient;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.function.Function;

public class CrumbsClientForge implements AbstractPlatformClient {
    public CrumbsClientForge() {
        CrumbsClient.init(this);
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
}
