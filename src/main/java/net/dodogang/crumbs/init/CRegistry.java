package net.dodogang.crumbs.init;

import net.dodogang.crumbs.Crumbs;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CRegistry {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Crumbs.MOD_ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Crumbs.MOD_ID);

    private static final Item.Properties DEF_PROPS = new Item.Properties().group(Crumbs.ITEM_GROUP);

    private static final BundledLogsBlocks BUNDLED_LOGS = new BundledLogsBlocks();
    private static final WoodBlocks WOOD_BLOCKS = new WoodBlocks();
    private static final CraftingTableBlocks CRAFTING_TABLE_BLOCKS = new CraftingTableBlocks();
    private static final BarrelBlocks BARREL_BLOCKS = new BarrelBlocks();
    private static final StoneBlocks STONE_BLOCKS = new StoneBlocks();
    private static final PebbleBlocks PEBBLE_BLOCKS = new PebbleBlocks();
    private static final SandBlocks SAND_BLOCKS = new SandBlocks();


    public CRegistry() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static RegistryObject<Block> registerBlock(String name, Block block) {
        return registerBlock(name, block, DEF_PROPS);
    }

    public static RegistryObject<Block> registerBlock(String name, Block block, Item.Properties props) {
        if (props != null) {
            registerItem(name, new BlockItem(block, props));
        }
        return BLOCKS.register(name, () -> block);
    }

    public static RegistryObject<Item> registerItem(String name, Item item) {
        return ITEMS.register(name, () -> item);
    }
}
