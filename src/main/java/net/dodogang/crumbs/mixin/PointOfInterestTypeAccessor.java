package net.dodogang.crumbs.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.village.PointOfInterestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;
import java.util.Set;

@Mixin(PointOfInterestType.class)
public interface PointOfInterestTypeAccessor {
    @Accessor("POIT_BY_BLOCKSTATE")
    static Map<BlockState, PointOfInterestType> getBlockStateToPointOfInterest() {
        throw new AssertionError();
    }

    @Accessor("blockStates")
    Set<BlockState> getBlockStates();

    @Accessor("blockStates")
    void setBlockStates(Set<BlockState> blockStates);
}
