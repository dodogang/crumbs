package net.dodogang.crumbs.client.render;

import net.dodogang.crumbs.Crumbs;
import net.dodogang.crumbs.client.CrumbsClient;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.util.Identifier;

public class CrumbsAtlasTextures {
    private CrumbsAtlasTextures() {}

    public static final Identifier SPRUCE_CHEST = chestSpriteId("spruce");
    public static final Identifier SPRUCE_DOUBLE_CHEST = chestSpriteId("spruce_double");
    public static final Identifier BIRCH_CHEST = chestSpriteId("birch");
    public static final Identifier BIRCH_DOUBLE_CHEST = chestSpriteId("birch_double");
    public static final Identifier JUNGLE_CHEST = chestSpriteId("jungle");
    public static final Identifier JUNGLE_DOUBLE_CHEST = chestSpriteId("jungle_double");
    public static final Identifier ACACIA_CHEST = chestSpriteId("acacia");
    public static final Identifier ACACIA_DOUBLE_CHEST = chestSpriteId("acacia_double");
    public static final Identifier DARK_OAK_CHEST = chestSpriteId("dark_oak");
    public static final Identifier DARK_OAK_DOUBLE_CHEST = chestSpriteId("dark_oak_double");
    public static final Identifier CRIMSON_CHEST = chestSpriteId("crimson");
    public static final Identifier CRIMSON_DOUBLE_CHEST = chestSpriteId("crimson_double");
    public static final Identifier WARPED_CHEST = chestSpriteId("warped");
    public static final Identifier WARPED_DOUBLE_CHEST = chestSpriteId("warped_double");

    public static void register() {
        CrumbsClient.platform.registerSpritesToAtlas(
                TexturedRenderLayers.CHEST_ATLAS_TEXTURE,
                SPRUCE_CHEST,
                SPRUCE_DOUBLE_CHEST,
                BIRCH_CHEST,
                BIRCH_DOUBLE_CHEST,
                JUNGLE_CHEST,
                JUNGLE_DOUBLE_CHEST,
                ACACIA_CHEST,
                ACACIA_DOUBLE_CHEST,
                DARK_OAK_CHEST,
                DARK_OAK_DOUBLE_CHEST,
                CRIMSON_CHEST,
                CRIMSON_DOUBLE_CHEST,
                WARPED_CHEST,
                WARPED_DOUBLE_CHEST
        );
    }

    private static Identifier chestSpriteId(String name) {
        return new Identifier(Crumbs.MOD_ID, "entity/chest/" + name);
    }
}
