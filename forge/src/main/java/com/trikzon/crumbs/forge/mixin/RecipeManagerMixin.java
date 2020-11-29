package com.trikzon.crumbs.forge.mixin;

import com.google.gson.Gson;
import com.trikzon.crumbs.CrumbsCore;
import net.minecraft.client.resources.JsonReloadListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Optional;

@Mixin(RecipeManager.class)
public abstract class RecipeManagerMixin extends JsonReloadListener {
    private RecipeManagerMixin(Gson gson, String string) { super(gson, string); }

    @Shadow public abstract <C extends IInventory, T extends IRecipe<C>> List<T> getRecipesFor(IRecipeType<T> recipeType, C container, World world);

    @Inject(method = "getRecipeFor", at = @At("HEAD"), cancellable = true)
    private <C extends IInventory, T extends IRecipe<C>> void crumbs_onGetRecipeFor(
            IRecipeType<T> recipeType, C container, World world, CallbackInfoReturnable<Optional<T>> cir
    ) {
        Optional<T> firstCrumbsMatch = this.getRecipesFor(recipeType, container, world).stream()
                .filter(t -> t.getId().getNamespace().equals(CrumbsCore.MOD_ID))
                .findFirst();
        if (firstCrumbsMatch.isPresent()) {
            cir.setReturnValue(firstCrumbsMatch);
        }
    }
}
