package net.dodogang.ash.client.api;

import net.dodogang.ash.impl.ImplLoader;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public abstract class RenderTypeMap {
    private static final RenderTypeMap IMPL = ImplLoader.load(RenderTypeMap.class);

    /**
     * Sets the render type of the specified blocks.
     * @param type render type
     * @param blocks target blocks
     */
    public static void put(RenderType type, Block... blocks) {
        IMPL.putImpl(type, blocks);
    }

    /**
     * Sets the render type of the specified fluids.
     * @param type render type
     * @param fluids target fluids
     */
    public static void put(RenderType type, Fluid... fluids) {
        IMPL.putImpl(type, fluids);
    }

    protected abstract void putImpl(RenderType type, Block... blocks);
    protected abstract void putImpl(RenderType type, Fluid... fluids);
}
