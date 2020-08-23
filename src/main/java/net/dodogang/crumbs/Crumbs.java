package net.dodogang.crumbs;

import net.dodogang.crumbs.block.CBarrelBlock;
import net.dodogang.crumbs.block.CCraftingTableBlock;
import net.dodogang.crumbs.block.PebbleBlock;
import net.dodogang.crumbs.init.BundledLogsBlocks;
import net.dodogang.crumbs.init.CRegistry;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Crumbs.MOD_ID)
public class Crumbs {
    public static final String MOD_ID = "crumbs";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final ItemGroup ITEM_GROUP = new ItemGroup(MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BundledLogsBlocks.OAK.get());
        }
    };

    public Crumbs() {
        new CRegistry();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.addListener(BundledLogsBlocks::stripLogsOnRightClick);
    }

    private void setup(final FMLCommonSetupEvent event) {
        CBarrelBlock.registerAsPointOfInterest();
    }
}
