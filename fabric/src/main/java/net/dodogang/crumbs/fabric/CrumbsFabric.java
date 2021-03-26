package net.dodogang.crumbs.fabric;

import com.mojang.datafixers.util.Function5;
import net.dodogang.crumbs.Crumbs;
import net.dodogang.crumbs.platform.AbstractPlatform;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class CrumbsFabric implements ModInitializer, AbstractPlatform {
    @Override
    public void onInitialize() {
        Crumbs.initialize(this);
        Crumbs.setup();
    }

    @Override
    public void registerOnRightClickBlockHandler(
            Function5<PlayerEntity, World, Hand, BlockPos, Direction, ActionResult> event
    ) {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (!player.isSpectator()) {
                return event.apply(player, world, hand, hitResult.getBlockPos(), hitResult.getSide());
            } else {
                return ActionResult.PASS;
            }
        });
    }

    @Override
    public boolean isAxe(ItemStack stack) {
        return FabricToolTags.AXES.contains(stack.getItem());
    }
}
