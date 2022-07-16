package net.dodogang.crumbs.mixin.client;

import net.dodogang.crumbs.item.crafting.CrumbsRecipeTypes;
import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.crafting.Recipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientRecipeBook.class)
public class ClientRecipeBookMixin {
    /**
     * Silences the ClientRecipeBook's warning spam when it encounters our
     * modded recipe types.
     */
    @Inject(method = "getCategory", at = @At("HEAD"), cancellable = true)
    private static void onGetCategory(Recipe<?> recipe, CallbackInfoReturnable<RecipeBookCategories> cir) {
        if (recipe.getType() == CrumbsRecipeTypes.CARPENTRY_TABLE.get()) {
            cir.setReturnValue(RecipeBookCategories.UNKNOWN);
        }
    }
}
