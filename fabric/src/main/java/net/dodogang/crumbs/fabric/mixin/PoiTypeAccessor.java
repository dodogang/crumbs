package net.dodogang.crumbs.fabric.mixin;

import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;
import java.util.Set;

@Mixin(PoiType.class)
public interface PoiTypeAccessor {
    @Accessor("TYPE_BY_STATE")
    static Map<BlockState, PoiType> getTypeByState() {
        throw new AssertionError();
    }

    @Accessor("matchingStates")
    Set<BlockState> getMatchingStates();

    @Accessor("matchingStates")
    void setMatchingStates(Set<BlockState> matchingStates);
}
