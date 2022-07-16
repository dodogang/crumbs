package net.dodogang.crumbs.item.crafting;

import net.dodogang.crumbs.block.CrumbsBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;

public class CarpentryTableRecipe extends SingleItemRecipe {
    public CarpentryTableRecipe(ResourceLocation resLoc, String name, Ingredient ingredient, ItemStack result) {
        super(
                CrumbsRecipeTypes.CARPENTRY_TABLE.get(),
                CrumbsRecipeSerializers.CARPENTRY_TABLE.get(),
                resLoc, name, ingredient, result
        );
    }

    @Override
    public boolean matches(Container container, Level level) {
        return this.ingredient.test(container.getItem(0));
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(CrumbsBlocks.CARPENTRY_TABLE.get());
    }
}
