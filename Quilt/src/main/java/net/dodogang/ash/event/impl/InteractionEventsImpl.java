package net.dodogang.ash.event.impl;

import net.dodogang.ash.event.api.InteractionEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;

public class InteractionEventsImpl extends InteractionEvents {
    @Override
    protected void rightClickBlockImpl(RightClickBlock callback) {
        UseBlockCallback.EVENT.register(callback::interact);
    }
}
