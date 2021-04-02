package net.dodogang.crumbs;

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
            () -> new ItemStack(CrumbsBlocks.OAK_BUNDLED_LOG.get())
    );

    public static void initialize() {
        CrumbsBlocks.register();
        CrumbsBlockEntityTypes.register();
    }

    public static void setup() {
        RightClickBlockHandlers.register();

        registerToPointOfInterests();
        registerFuelBurnTimes();
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

    private static void registerFuelBurnTimes() {
        FuelRegistry.register(
                300,

                CrumbsBlocks.OAK_BUNDLED_LOG.get(),
                CrumbsBlocks.SPRUCE_BUNDLED_LOG.get(),
                CrumbsBlocks.BIRCH_BUNDLED_LOG.get(),
                CrumbsBlocks.JUNGLE_BUNDLED_LOG.get(),
                CrumbsBlocks.ACACIA_BUNDLED_LOG.get(),
                CrumbsBlocks.DARK_OAK_BUNDLED_LOG.get(),
                CrumbsBlocks.CRIMSON_BUNDLED_STEM.get(),
                CrumbsBlocks.WARPED_BUNDLED_STEM.get(),

                CrumbsBlocks.STRIPPED_OAK_BUNDLED_LOG.get(),
                CrumbsBlocks.STRIPPED_SPRUCE_BUNDLED_LOG.get(),
                CrumbsBlocks.STRIPPED_BIRCH_BUNDLED_LOG.get(),
                CrumbsBlocks.STRIPPED_JUNGLE_BUNDLED_LOG.get(),
                CrumbsBlocks.STRIPPED_ACACIA_BUNDLED_LOG.get(),
                CrumbsBlocks.STRIPPED_DARK_OAK_BUNDLED_LOG.get(),
                CrumbsBlocks.STRIPPED_CRIMSON_BUNDLED_STEM.get(),
                CrumbsBlocks.STRIPPED_WARPED_BUNDLED_STEM.get(),

                CrumbsBlocks.SPRUCE_CRAFTING_TABLE.get(),
                CrumbsBlocks.BIRCH_CRAFTING_TABLE.get(),
                CrumbsBlocks.JUNGLE_CRAFTING_TABLE.get(),
                CrumbsBlocks.ACACIA_CRAFTING_TABLE.get(),
                CrumbsBlocks.DARK_OAK_CRAFTING_TABLE.get(),
                CrumbsBlocks.CRIMSON_CRAFTING_TABLE.get(),
                CrumbsBlocks.WARPED_CRAFTING_TABLE.get(),

                CrumbsBlocks.OAK_BARREL.get(),
                CrumbsBlocks.BIRCH_BARREL.get(),
                CrumbsBlocks.JUNGLE_BARREL.get(),
                CrumbsBlocks.ACACIA_BARREL.get(),
                CrumbsBlocks.DARK_OAK_BARREL.get(),
                CrumbsBlocks.CRIMSON_BARREL.get(),
                CrumbsBlocks.WARPED_BARREL.get(),

                CrumbsBlocks.OAK_LANTERN.get(),
                CrumbsBlocks.SPRUCE_LANTERN.get(),
                CrumbsBlocks.BIRCH_LANTERN.get(),
                CrumbsBlocks.JUNGLE_LANTERN.get(),
                CrumbsBlocks.ACACIA_LANTERN.get(),
                CrumbsBlocks.DARK_OAK_LANTERN.get(),
                CrumbsBlocks.CRIMSON_LANTERN.get(),
                CrumbsBlocks.WARPED_LANTERN.get(),

                CrumbsBlocks.OAK_CHEST.get(),
                CrumbsBlocks.SPRUCE_CHEST.get(),
                CrumbsBlocks.BIRCH_CHEST.get(),
                CrumbsBlocks.JUNGLE_CHEST.get(),
                CrumbsBlocks.ACACIA_CHEST.get(),
                CrumbsBlocks.DARK_OAK_CHEST.get(),
                CrumbsBlocks.CRIMSON_CHEST.get(),
                CrumbsBlocks.WARPED_CHEST.get()
        );
    }
}
