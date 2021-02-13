package net.dodogang.crumbs.client.renderer;

import net.dodogang.crumbs.Crumbs;
import net.dodogang.crumbs.client.CrumbsClient;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.util.Identifier;

public class CrumbsAtlasTextures {
    public static final Identifier SPRUCE_CHEST = registerChest(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, "spruce");
    public static final Identifier SPRUCE_DOUBLE_CHEST = registerChest(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, "spruce_double");
    public static final Identifier BIRCH_CHEST = registerChest(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, "birch");
    public static final Identifier BIRCH_DOUBLE_CHEST = registerChest(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, "birch_double");
    public static final Identifier JUNGLE_CHEST = registerChest(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, "jungle");
    public static final Identifier JUNGLE_DOUBLE_CHEST = registerChest(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, "jungle_double");
    public static final Identifier ACACIA_CHEST = registerChest(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, "acacia");
    public static final Identifier ACACIA_DOUBLE_CHEST = registerChest(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, "acacia_double");
    public static final Identifier DARK_OAK_CHEST = registerChest(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, "dark_oak");
    public static final Identifier DARK_OAK_DOUBLE_CHEST = registerChest(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, "dark_oak_double");
    public static final Identifier CRIMSON_CHEST = registerChest(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, "crimson");
    public static final Identifier CRIMSON_DOUBLE_CHEST = registerChest(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, "crimson_double");
    public static final Identifier WARPED_CHEST = registerChest(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, "warped");
    public static final Identifier WARPED_DOUBLE_CHEST = registerChest(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, "warped_double");

    private static Identifier registerChest(Identifier atlas, String name) {
        return register(atlas, "entity/chest/" + name);
    }

    private static Identifier register(Identifier atlas, String spritePath) {
        Identifier spriteLocation = Crumbs.getId(spritePath);
        CrumbsClient.platform.registerSpritesToAtlas(atlas, spriteLocation);
        return spriteLocation;
    }
}
