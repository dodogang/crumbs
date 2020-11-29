package com.trikzon.crumbs.fabric.mixin;

import com.google.gson.Gson;
import com.trikzon.crumbs.CrumbsCore;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Optional;

@Mixin(RecipeManager.class)
public abstract class RecipeManagerMixin extends SimpleJsonResourceReloadListener {
    private RecipeManagerMixin(Gson gson, String string) { super(gson, string); }

    @Shadow public abstract <C extends Container, T extends Recipe<C>> List<T> getRecipesFor(RecipeType<T> recipeType, C container, Level level);

    @Inject(method = "getRecipeFor", at = @At("HEAD"), cancellable = true)
    private <C extends Container, T extends Recipe<C>> void crumbs_onGetRecipeFor(
            RecipeType<T> recipeType, C container, Level level, CallbackInfoReturnable<Optional<T>> cir
    ) {
        Optional<T> firstCrumbsMatch = this.getRecipesFor(recipeType, container, level).stream()
                .filter(t -> t.getId().getNamespace().equals(CrumbsCore.MOD_ID))
                .findFirst();
        if (firstCrumbsMatch.isPresent()) {
            cir.setReturnValue(firstCrumbsMatch);
        }
    }
}
