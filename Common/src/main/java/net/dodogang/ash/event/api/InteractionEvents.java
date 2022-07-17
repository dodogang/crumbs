package net.dodogang.ash.event.api;

import net.dodogang.ash.impl.ImplLoader;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public abstract class InteractionEvents {
    private static InteractionEvents IMPL = ImplLoader.load(InteractionEvents.class);

    /**
     * An event indicating the player has right-clicked while targeting a
     * block.
     *
     * <p>Returning an {@link InteractionResult} that is
     * {@link InteractionResult#consumesAction()} will prevent further events
     * from being processed.</p>
     *
     * <p>Returning {@link InteractionResult#SUCCESS} will cause the player to
     * swing its hand.</p>
     *
     * <p>It is fired on both sides. Note that handling things differently
     * on the client vs the server may cause desync!</p>
     *
     * @param callback an implementation of {@link RightClickBlock}
     */
    public static void rightClickBlock(RightClickBlock callback) {
        IMPL.rightClickBlockImpl(callback);
    }

    /**
     * Functional interface to be implemented on callbacks for
     * {@link InteractionEvents#rightClickBlock(RightClickBlock)}.
     */
    @FunctionalInterface
    public interface RightClickBlock {
        InteractionResult interact(Player player, Level level, InteractionHand hand, BlockHitResult result);
    }

    protected abstract void rightClickBlockImpl(RightClickBlock callback);
}
