package com.trikzon.crumbs.client.renderer;

import com.trikzon.crumbs.CrumbsCore;
import com.trikzon.crumbs.client.CrumbsClient;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.resources.ResourceLocation;

public class CrumbsSpriteSheets {
    public static final ResourceLocation SPRUCE_CHEST = registerChest(Sheets.CHEST_SHEET, "spruce");
    public static final ResourceLocation SPRUCE_DOUBLE_CHEST = registerChest(Sheets.CHEST_SHEET, "spruce_double");
    public static final ResourceLocation BIRCH_CHEST = registerChest(Sheets.CHEST_SHEET, "birch");
    public static final ResourceLocation BIRCH_DOUBLE_CHEST = registerChest(Sheets.CHEST_SHEET, "birch_double");
    public static final ResourceLocation JUNGLE_CHEST = registerChest(Sheets.CHEST_SHEET, "jungle");
    public static final ResourceLocation JUNGLE_DOUBLE_CHEST = registerChest(Sheets.CHEST_SHEET, "jungle_double");
    public static final ResourceLocation ACACIA_CHEST = registerChest(Sheets.CHEST_SHEET, "acacia");
    public static final ResourceLocation ACACIA_DOUBLE_CHEST = registerChest(Sheets.CHEST_SHEET, "acacia_double");
    public static final ResourceLocation DARK_OAK_CHEST = registerChest(Sheets.CHEST_SHEET, "dark_oak");
    public static final ResourceLocation DARK_OAK_DOUBLE_CHEST = registerChest(Sheets.CHEST_SHEET, "dark_oak_double");
    public static final ResourceLocation CRIMSON_CHEST = registerChest(Sheets.CHEST_SHEET, "crimson");
    public static final ResourceLocation CRIMSON_DOUBLE_CHEST = registerChest(Sheets.CHEST_SHEET, "crimson_double");
    public static final ResourceLocation WARPED_CHEST = registerChest(Sheets.CHEST_SHEET, "warped");
    public static final ResourceLocation WARPED_DOUBLE_CHEST = registerChest(Sheets.CHEST_SHEET, "warped_double");

    private static ResourceLocation registerChest(ResourceLocation atlas, String name) {
        return register(atlas, "entity/chest/" + name);
    }

    private static ResourceLocation register(ResourceLocation atlas, String spritePath) {
        ResourceLocation spriteLocation = CrumbsCore.getId(spritePath);
        CrumbsClient.platform.registerSpritesToAtlas(atlas, spriteLocation);
        return spriteLocation;
    }
}
