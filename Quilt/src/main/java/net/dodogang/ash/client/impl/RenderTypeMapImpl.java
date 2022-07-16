package net.dodogang.ash.client.impl;

import net.dodogang.ash.client.api.RenderTypeMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;

public class RenderTypeMapImpl extends RenderTypeMap {
    @Override
    protected void putImpl(RenderType type, Block... blocks) {
        BlockRenderLayerMap.put(type, blocks);
    }

    @Override
    protected void putImpl(RenderType type, Fluid... fluids) {
        BlockRenderLayerMap.put(type, fluids);
    }
}
