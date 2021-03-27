package net.dodogang.crumbs;

import net.dodogang.crumbs.block.CrumbsBlocks;
import net.dodogang.crumbs.block.entity.CrumbsBlockEntityTypes;
import net.dodogang.crumbs.event.RightClickBlockHandlers;
import net.dodogang.plume.ash.registry.ItemGroupBuilder;
import net.dodogang.plume.registry.PointOfInterestTypeAppender;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Crumbs {
    private Crumbs() {}

    public static final String MOD_ID = "crumbs";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final ItemGroup ITEM_GROUP = ItemGroupBuilder.build(
            new Identifier(MOD_ID, "item_group"),
            () -> new ItemStack(CrumbsBlocks.OAK_BUNDLED_LOG.get())
    );

    public static void initialize() {
        CrumbsBlocks.register();
        CrumbsBlockEntityTypes.register();
    }

    public static void setup() {
        RightClickBlockHandlers.register();

        registerToPointOfInterests();
    }

    private static void registerToPointOfInterests() {
        // Register barrels to fisherman point of interest.
        PointOfInterestTypeAppender.appendBlocks(
                PointOfInterestType.FISHERMAN,
                CrumbsBlocks.OAK_BARREL.get(),
                CrumbsBlocks.BIRCH_BARREL.get(),
                CrumbsBlocks.JUNGLE_BARREL.get(),
                CrumbsBlocks.ACACIA_BARREL.get(),
                CrumbsBlocks.DARK_OAK_BARREL.get(),
                CrumbsBlocks.CRIMSON_BARREL.get(),
                CrumbsBlocks.WARPED_BARREL.get()
        );
    }
}
