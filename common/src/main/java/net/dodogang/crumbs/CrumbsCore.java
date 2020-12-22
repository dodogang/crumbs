package net.dodogang.crumbs;

import net.dodogang.crumbs.block.CrumbsBlocks;
import net.dodogang.crumbs.block.entity.CrumbsBlockEntityType;
import net.dodogang.crumbs.event.RightClickBlockHandlers;
import net.dodogang.crumbs.platform.AbstractPlatform;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CrumbsCore {
    public static final String MOD_ID = "crumbs";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static AbstractPlatform platform;
    public static CreativeModeTab creativeTab;

    public static void init(AbstractPlatform platform) {
        CrumbsCore.platform = platform;
        CrumbsCore.creativeTab = platform.createCreativeTab("item_group", () -> new ItemStack(CrumbsBlocks.OAK_BUNDLED_LOG));

        new CrumbsBlocks();
//        new CrumbsItems();
//        new CrumbsBlockEntityType();
        new RightClickBlockHandlers();
    }

    public static void setup() {

    }

    public static ResourceLocation getId(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}
