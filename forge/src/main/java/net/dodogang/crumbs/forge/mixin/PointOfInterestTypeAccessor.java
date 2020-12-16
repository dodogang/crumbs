package net.dodogang.crumbs.forge.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.village.PointOfInterestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;
import java.util.Set;

@Mixin(PointOfInterestType.class)
public interface PointOfInterestTypeAccessor {
    @Accessor("TYPE_BY_STATE")
    static Map<BlockState, PointOfInterestType> getTypeByState() {
        throw new AssertionError();
    }

    @Accessor("matchingStates")
    Set<BlockState> getMatchingStates();

    @Accessor("matchingStates")
    void setMatchingStates(Set<BlockState> matchingStates);
}
