package net.dodogang.crumbs;

import com.google.common.reflect.Reflection;
import net.dodogang.crumbs.block.CrumbsBlocks;
import net.dodogang.crumbs.block.entity.CrumbsBlockEntityTypes;
import net.dodogang.crumbs.event.RightClickBlockHandlers;
import net.dodogang.plume.ash.registry.FuelRegistry;
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
            () -> new ItemStack(CrumbsBlocks.OAK_BUNDLED_LOG)
    );

    @SuppressWarnings("UnstableApiUsage")
    public static void initialize() {
        Reflection.initialize(
            CrumbsBlocks.class,
            CrumbsBlockEntityTypes.class
        );
    }

    @SuppressWarnings("UnstableApiUsage")
    public static void setup() {
        Reflection.initialize(
            RightClickBlockHandlers.class
        );

        registerToPointOfInterests();
        registerFuelBurnTimes();
    }

    private static void registerToPointOfInterests() {
        // Register barrels to fisherman point of interest.
        PointOfInterestTypeAppender.appendBlocks(
            PointOfInterestType.FISHERMAN,
                CrumbsBlocks.OAK_BARREL,
                CrumbsBlocks.BIRCH_BARREL,
                CrumbsBlocks.JUNGLE_BARREL,
                CrumbsBlocks.ACACIA_BARREL,
                CrumbsBlocks.DARK_OAK_BARREL,
                CrumbsBlocks.CRIMSON_BARREL,
                CrumbsBlocks.WARPED_BARREL
        );
    }

    private static void registerFuelBurnTimes() {
        FuelRegistry.register(
            300,
                CrumbsBlocks.OAK_BUNDLED_LOG,
                CrumbsBlocks.SPRUCE_BUNDLED_LOG,
                CrumbsBlocks.BIRCH_BUNDLED_LOG,
                CrumbsBlocks.JUNGLE_BUNDLED_LOG,
                CrumbsBlocks.ACACIA_BUNDLED_LOG,
                CrumbsBlocks.DARK_OAK_BUNDLED_LOG,
                CrumbsBlocks.CRIMSON_BUNDLED_STEM,
                CrumbsBlocks.WARPED_BUNDLED_STEM,

                CrumbsBlocks.STRIPPED_OAK_BUNDLED_LOG,
                CrumbsBlocks.STRIPPED_SPRUCE_BUNDLED_LOG,
                CrumbsBlocks.STRIPPED_BIRCH_BUNDLED_LOG,
                CrumbsBlocks.STRIPPED_JUNGLE_BUNDLED_LOG,
                CrumbsBlocks.STRIPPED_ACACIA_BUNDLED_LOG,
                CrumbsBlocks.STRIPPED_DARK_OAK_BUNDLED_LOG,
                CrumbsBlocks.STRIPPED_CRIMSON_BUNDLED_STEM,
                CrumbsBlocks.STRIPPED_WARPED_BUNDLED_STEM,

                CrumbsBlocks.OAK_CHEST,
                CrumbsBlocks.SPRUCE_CHEST,
                CrumbsBlocks.BIRCH_CHEST,
                CrumbsBlocks.JUNGLE_CHEST,
                CrumbsBlocks.ACACIA_CHEST,
                CrumbsBlocks.DARK_OAK_CHEST,
                CrumbsBlocks.CRIMSON_CHEST,
                CrumbsBlocks.WARPED_CHEST,

                CrumbsBlocks.SPRUCE_CRAFTING_TABLE,
                CrumbsBlocks.BIRCH_CRAFTING_TABLE,
                CrumbsBlocks.JUNGLE_CRAFTING_TABLE,
                CrumbsBlocks.ACACIA_CRAFTING_TABLE,
                CrumbsBlocks.DARK_OAK_CRAFTING_TABLE,
                CrumbsBlocks.CRIMSON_CRAFTING_TABLE,
                CrumbsBlocks.WARPED_CRAFTING_TABLE,

                CrumbsBlocks.OAK_BARREL,
                CrumbsBlocks.BIRCH_BARREL,
                CrumbsBlocks.JUNGLE_BARREL,
                CrumbsBlocks.ACACIA_BARREL,
                CrumbsBlocks.DARK_OAK_BARREL,
                CrumbsBlocks.CRIMSON_BARREL,
                CrumbsBlocks.WARPED_BARREL,

                CrumbsBlocks.SPRUCE_BOOKSHELF,
                CrumbsBlocks.BIRCH_BOOKSHELF,
                CrumbsBlocks.JUNGLE_BOOKSHELF,
                CrumbsBlocks.ACACIA_BOOKSHELF,
                CrumbsBlocks.DARK_OAK_BOOKSHELF,
                CrumbsBlocks.CRIMSON_BOOKSHELF,
                CrumbsBlocks.WARPED_BOOKSHELF,

                CrumbsBlocks.OAK_LANTERN,
                CrumbsBlocks.SPRUCE_LANTERN,
                CrumbsBlocks.BIRCH_LANTERN,
                CrumbsBlocks.JUNGLE_LANTERN,
                CrumbsBlocks.ACACIA_LANTERN,
                CrumbsBlocks.DARK_OAK_LANTERN,
                CrumbsBlocks.CRIMSON_LANTERN,
                CrumbsBlocks.WARPED_LANTERN,

                CrumbsBlocks.SPRUCE_LADDER,
                CrumbsBlocks.BIRCH_LADDER,
                CrumbsBlocks.JUNGLE_LADDER,
                CrumbsBlocks.ACACIA_LADDER,
                CrumbsBlocks.DARK_OAK_LADDER,
                CrumbsBlocks.CRIMSON_LADDER,
                CrumbsBlocks.WARPED_LADDER,

                CrumbsBlocks.OAK_POST,
                CrumbsBlocks.SPRUCE_POST,
                CrumbsBlocks.BIRCH_POST,
                CrumbsBlocks.JUNGLE_POST,
                CrumbsBlocks.ACACIA_POST,
                CrumbsBlocks.DARK_OAK_POST,
                CrumbsBlocks.CRIMSON_POST,
                CrumbsBlocks.WARPED_POST,

                CrumbsBlocks.STRIPPED_OAK_POST,
                CrumbsBlocks.STRIPPED_SPRUCE_POST,
                CrumbsBlocks.STRIPPED_BIRCH_POST,
                CrumbsBlocks.STRIPPED_JUNGLE_POST,
                CrumbsBlocks.STRIPPED_ACACIA_POST,
                CrumbsBlocks.STRIPPED_DARK_OAK_POST,
                CrumbsBlocks.STRIPPED_CRIMSON_POST,
                CrumbsBlocks.STRIPPED_WARPED_POST
        );
    }
}
