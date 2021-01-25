package net.dodogang.crumbs.forge.client.mixin;

import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
@Mixin(Item.class)
public interface ItemAccessor {
    // remap = false because this field is part of a forge patch.
    @Accessor(value = "ister", remap = false)
    void setIster(Supplier<BuiltinModelItemRenderer> ister);
}
