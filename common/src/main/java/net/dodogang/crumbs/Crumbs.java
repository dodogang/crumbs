package net.dodogang.crumbs;

import net.dodogang.ash.item.api.CreativeModeTabBuilder;
import net.dodogang.ash.loader.api.ModLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Crumbs {
    public static final String MOD_ID = "crumbs";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final CreativeModeTab CRUMBS_TAB = CreativeModeTabBuilder
            .create(new ResourceLocation(MOD_ID, "crumbs"))
            .icon(() -> new ItemStack(Blocks.MANGROVE_LOG))
            .appendItems(stacksForDisplay -> stacksForDisplay.add(new ItemStack(Blocks.MANGROVE_LOG)))
            .build();

    public static void initialize() {
        LOGGER.info("getName: " + ModLoader.getName());
        LOGGER.info("isModLoaded('fabric'): " + ModLoader.isModLoaded("fabric"));
        LOGGER.info("isDevelopmentEnvironment: " + ModLoader.isDevelopmentEnvironment());
        LOGGER.info("getGameDir: " + ModLoader.getGameDir());
        LOGGER.info("getConfigDir: " + ModLoader.getConfigDir());
    }
}
