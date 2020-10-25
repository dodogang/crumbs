package net.dodogang.crumbs.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.world.poi.PointOfInterestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;
import java.util.Set;

@Mixin(PointOfInterestType.class)
public interface PointOfInterestTypeAccessor {
    @Accessor("BLOCK_STATE_TO_POINT_OF_INTEREST_TYPE")
    static Map<BlockState, PointOfInterestType> getBlockStateToPointOfInterest() {
        throw new AssertionError();
    }

    @Accessor("blockStates")
    Set<BlockState> getBlockStates();

    @Accessor("blockStates")
    void setBlockStates(Set<BlockState> blockStates);
}
