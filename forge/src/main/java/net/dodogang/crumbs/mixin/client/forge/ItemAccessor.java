package net.dodogang.crumbs.mixin.client.forge;

import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.function.Supplier;

@Mixin(Item.class)
public interface ItemAccessor {
    // remap = false because this field is part of a forge patch and doesn't get remapped.
    @Accessor(value = "ister", remap = false)
    void setIster(Supplier<BuiltinModelItemRenderer> ister);
}
