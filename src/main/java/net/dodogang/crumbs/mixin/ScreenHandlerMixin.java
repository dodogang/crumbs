package net.dodogang.crumbs.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.block.Block;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;

@Mixin(ScreenHandler.class)
public abstract class ScreenHandlerMixin {
    @Inject(method = "canUse", at = @At("RETURN"), cancellable = true)
    private static void canUse(ScreenHandlerContext context, PlayerEntity player, Block block, CallbackInfoReturnable<Boolean> cir) {
        if (context.run((world, blockPos) -> {
            return world.getBlockState(blockPos).getBlock() instanceof CraftingTableBlock && player.squaredDistanceTo(blockPos.getX() + 0.5D, blockPos.getY() + 0.5D, blockPos.getZ() + 0.5D) <= 64.0D;
        }, true)) cir.setReturnValue(true);
   }
}
