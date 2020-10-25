package net.dodogang.crumbs;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.dodogang.crumbs.block.CrumbsBarrelBlock;
import net.dodogang.crumbs.init.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(Crumbs.MOD_ID)
public class Crumbs {
    public static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "crumbs";
    public static final String MOD_NAME = "Crumbs";

    public static final ItemGroup ITEM_GROUP = new ItemGroup(MOD_ID + ".item_group") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(CrumbsBlocks.OAK_BUNDLED_LOG);
        }
    };

    public Crumbs() {
        log("Initializing");

        IEventBus eventBus = MinecraftForge.EVENT_BUS;
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(CrumbsBlocks::addStrippingFunctionality);

        modEventBus.addGenericListener(Block.class, CrumbsBlocks::registerBlocks);
        modEventBus.addGenericListener(Item.class, CrumbsBlocks::registerBlockItems);

        new CrumbsBlocks();

        CrumbsBarrelBlock.registerPointsOfInterest();

        log("Initialized");
    }

    public static void log(Level level, String message) {
        LOGGER.log(level, "[" + MOD_NAME + "] " + message);
    }
    public static void log(String message) {
        log(Level.INFO, message);
    }
}
