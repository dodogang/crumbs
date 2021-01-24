package net.dodogang.crumbs.mixin;

import com.google.gson.Gson;
import net.dodogang.crumbs.CrumbsCore;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.resource.JsonDataLoader;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Optional;

@Mixin(RecipeManager.class)
public abstract class RecipeManagerMixin extends JsonDataLoader {
    @Shadow public abstract <C extends Inventory, T extends Recipe<C>> List<T> getAllMatches(RecipeType<T> type, C inventory, World world);

    public RecipeManagerMixin(Gson gson, String dataType) {
        super(gson, dataType);
    }

    @Inject(method = "getFirstMatch", at = @At("HEAD"), cancellable = true)
    private <C extends Inventory, T extends Recipe<C>> void crumbs_getFirstMatch(
            RecipeType<T> type, C inventory, World world, CallbackInfoReturnable<Optional<T>> cir
    ) {
        Optional<T> firstCrumbsMatch = this.getAllMatches(type, inventory, world).stream()
                .filter(t -> t.getId().getNamespace().equals(CrumbsCore.MOD_ID))
                .findFirst();
        if (firstCrumbsMatch.isPresent()) {
            cir.setReturnValue(firstCrumbsMatch);
        }
    }
}