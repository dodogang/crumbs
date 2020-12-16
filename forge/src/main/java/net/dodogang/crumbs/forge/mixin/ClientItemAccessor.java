package net.dodogang.crumbs.forge.mixin;

import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
@Mixin(Item.class)
public interface ClientItemAccessor {
    // remap = false because this field is part of a forge patch.
    @Accessor(value = "ister", remap = false)
    void setIster(Supplier<ItemStackTileEntityRenderer> ister);
}
