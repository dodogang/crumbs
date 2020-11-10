package net.dodogang.crumbs.mixin;

import com.google.gson.Gson;
import net.dodogang.crumbs.Crumbs;
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
    public RecipeManagerMixin(Gson gson, String dataType) { super(gson, dataType); }

    @Shadow public abstract <C extends IInventory, T extends IRecipe<C>> List<T> getRecipes(IRecipeType<T> recipeTypeIn, C inventoryIn, World worldIn);

    // Redirects the getFirstMatch call in updateResult so we can handle the logic here.
    // This is to get around recipe conflicts with vanilla barrels, and possibly more in the future.
    // Now the crafting table will always choose a crumbs recipe in case of a conflict.
    @Inject(method = "getRecipe(Lnet/minecraft/item/crafting/IRecipeType;Lnet/minecraft/inventory/IInventory;Lnet/minecraft/world/World;)Ljava/util/Optional;", at = @At("HEAD"), cancellable = true)
    private <C extends IInventory, T extends IRecipe<C>> void
    crumbs_onGetRecipe(IRecipeType<T> type, C inventory, World world, CallbackInfoReturnable<Optional<T>> cir) {
        Optional<T> firstCrumbsMatch = this.getRecipes(type, inventory, world).stream()
                .filter(t -> t.getId().getNamespace().equals(Crumbs.MOD_ID))
                .findFirst();
        if (firstCrumbsMatch.isPresent()) {
            cir.setReturnValue(firstCrumbsMatch);
        }
    }
}
