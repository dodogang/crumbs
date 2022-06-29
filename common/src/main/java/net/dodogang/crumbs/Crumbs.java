package net.dodogang.crumbs;

import net.dodogang.ash.loader.api.ModLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Crumbs {
    public static final String MOD_ID = "crumbs";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static void initialize() {
        LOGGER.info("getName: " + ModLoader.getName());
        LOGGER.info("isModLoaded('fabric'): " + ModLoader.isModLoaded("fabric"));
        LOGGER.info("isDevelopmentEnvironment: " + ModLoader.isDevelopmentEnvironment());
        LOGGER.info("getGameDir: " + ModLoader.getGameDir());
        LOGGER.info("getConfigDir: " + ModLoader.getConfigDir());
    }
}
