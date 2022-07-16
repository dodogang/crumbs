package net.dodogang.crumbs;

import net.dodogang.ash.item.api.CreativeModeTabBuilder;
import net.dodogang.crumbs.block.CrumbsBlocks;
import net.dodogang.crumbs.inventory.CrumbsMenuTypes;
import net.dodogang.crumbs.item.crafting.CrumbsRecipeSerializers;
import net.dodogang.crumbs.item.crafting.CrumbsRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Crumbs {
    public static final String MOD_ID = "crumbs";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final CreativeModeTab CRUMBS_TAB = CreativeModeTabBuilder
            .create(new ResourceLocation(MOD_ID, "crumbs"))
            .icon(() -> new ItemStack(CrumbsBlocks.CARPENTRY_TABLE.get()))
            .build();

    public static void init() {
        CrumbsBlocks.register();
        CrumbsRecipeSerializers.register();
        CrumbsRecipeTypes.register();
        CrumbsMenuTypes.register();
    }

    public static void postInit() {
        // Post-initialization code goes here:
    }
}