package net.dodogang.crumbs.item.crafting;

import net.dodogang.ash.registry.api.ResourceBatch;
import net.dodogang.crumbs.Crumbs;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Supplier;

public class CrumbsRecipeTypes {
    private static final ResourceBatch<RecipeType<?>> RECIPE_TYPES = ResourceBatch.create(Registry.RECIPE_TYPE, Crumbs.MOD_ID);

    public static final Supplier<RecipeType<CarpentryTableRecipe>> CARPENTRY_TABLE = addRecipeType("carpentry_table");

    public static void register() {
        RECIPE_TYPES.register();
    }

    private static <T extends Recipe<?>> Supplier<RecipeType<T>> addRecipeType(String name){
        return RECIPE_TYPES.add(name, () -> new RecipeType<>() {
            @Override
            public String toString() {
                return name;
            }
        });
    }
}
