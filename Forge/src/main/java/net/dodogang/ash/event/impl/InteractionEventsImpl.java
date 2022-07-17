package net.dodogang.ash.event.impl;

import net.dodogang.ash.event.api.InteractionEvents;
import net.minecraft.world.InteractionResult;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class InteractionEventsImpl extends InteractionEvents {
    @Override
    protected void rightClickBlockImpl(RightClickBlock callback) {
        MinecraftForge.EVENT_BUS.<PlayerInteractEvent.RightClickBlock>addListener(e -> {
            if (!e.getPlayer().isSpectator()) {
                InteractionResult result = callback.interact(e.getPlayer(), e.getWorld(), e.getHand(), e.getHitVec());
                if (result.consumesAction()) {
                    e.setCancellationResult(result);
                    e.setCanceled(true);
                }
            }
        });
    }
}
