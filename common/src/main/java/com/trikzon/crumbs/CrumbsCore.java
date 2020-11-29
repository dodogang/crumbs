package com.trikzon.crumbs;

import com.trikzon.crumbs.block.CrumbsBlocks;
import com.trikzon.crumbs.platform.AbstractPlatform;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CrumbsCore {
    public static final String MOD_ID = "crumbs";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static AbstractPlatform platform;

    public static void init(AbstractPlatform platform) {
        CrumbsCore.platform = platform;

        new CrumbsBlocks();
    }

    public static ResourceLocation getId(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}
