package net.dodogang.crumbs.item.crafting;

import net.dodogang.ash.registry.api.ResourceBatch;
import net.dodogang.crumbs.Crumbs;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Supplier;

public class CrumbsRecipeSerializers {
    private static final ResourceBatch<RecipeSerializer<?>> RECIPE_SERIALIZERS = ResourceBatch.create(Registry.RECIPE_SERIALIZER, Crumbs.MOD_ID);

    public static final Supplier<RecipeSerializer<CarpentryTableRecipe>> CARPENTRY_TABLE = RECIPE_SERIALIZERS.add(
            "carpentry_table",
            () -> new SingleItemRecipeSerializer<>(CarpentryTableRecipe::new)
    );

    public static void register() {
        RECIPE_SERIALIZERS.register();
    }
}
