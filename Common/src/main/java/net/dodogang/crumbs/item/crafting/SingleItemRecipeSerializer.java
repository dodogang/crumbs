package net.dodogang.crumbs.item.crafting;

import com.google.gson.JsonObject;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SingleItemRecipe;

public class SingleItemRecipeSerializer<T extends SingleItemRecipe> implements RecipeSerializer<T> {
    final SingleItemMaker<T> factory;

    public SingleItemRecipeSerializer(SingleItemMaker<T> factory) {
        this.factory = factory;
    }

    @Override
    public T fromJson(ResourceLocation resLoc, JsonObject jsonObject) {
        String group = GsonHelper.getAsString(jsonObject, "group", "");

        Ingredient ingredient;
        if (GsonHelper.isArrayNode(jsonObject, "ingredient")) {
            ingredient = Ingredient.fromJson(GsonHelper.getAsJsonArray(jsonObject, "ingredient"));
        } else {
            ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(jsonObject, "ingredient"));
        }

        String resultResLoc = GsonHelper.getAsString(jsonObject, "result");
        int resultCount = GsonHelper.getAsInt(jsonObject, "count");
        ItemStack result = new ItemStack(Registry.ITEM.get(new ResourceLocation(resultResLoc)), resultCount);

        return this.factory.create(resLoc, group, ingredient, result);
    }

    @Override
    public T fromNetwork(ResourceLocation resLoc, FriendlyByteBuf friendlyByteBuf) {
        String group = friendlyByteBuf.readUtf();
        Ingredient ingredient = Ingredient.fromNetwork(friendlyByteBuf);
        ItemStack result = friendlyByteBuf.readItem();
        return this.factory.create(resLoc, group, ingredient, result);
    }

    @Override
    public void toNetwork(FriendlyByteBuf friendlyByteBuf, T recipe) {
        friendlyByteBuf.writeUtf(recipe.getGroup());
        recipe.getIngredients().get(0).toNetwork(friendlyByteBuf);
        friendlyByteBuf.writeItem(recipe.getResultItem());
    }

    interface SingleItemMaker<T extends SingleItemRecipe> {
        T create(ResourceLocation resourceLocation, String string, Ingredient ingredient, ItemStack itemStack);
    }
}
