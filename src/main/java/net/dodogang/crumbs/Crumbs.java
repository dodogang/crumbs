package net.dodogang.crumbs;

import net.dodogang.crumbs.block.CrumbsBarrelBlock;
import net.dodogang.crumbs.block.CrumbsCraftingTableBlock;
import net.dodogang.crumbs.block.PebbleBlock;
import net.minecraft.block.*;
import net.minecraft.item.*;
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
            return new ItemStack(BUNDLED_OAK_LOGS.get());
        }
    };

    public static RegistryObject<Block> BUNDLED_OAK_LOGS;

    public static RegistryObject<Block> OAK_BARREL;
    public static RegistryObject<Block> BIRCH_BARREL;
    public static RegistryObject<Block> JUNGLE_BARREL;
    public static RegistryObject<Block> ACACIA_BARREL;
    public static RegistryObject<Block> DARK_OAK_BARREL;
    public static RegistryObject<Block> CRIMSON_BARREL;
    public static RegistryObject<Block> WARPED_BARREL;

    private final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MOD_ID);
    private final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MOD_ID);

    private final Item.Properties DEF_PROPS = new Item.Properties().group(ITEM_GROUP);

    public Crumbs() {
        register();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        CrumbsBarrelBlock.registerAsPointOfInterest();
    }

    private void register() {
        BUNDLED_OAK_LOGS = registerBlock("bundled_oak_logs",
                new RotatedPillarBlock(Block.Properties.from(Blocks.OAK_LOG))
        );
        registerBlock("bundled_spruce_logs",
                new RotatedPillarBlock(Block.Properties.from(Blocks.SPRUCE_LOG))
        );
        registerBlock("bundled_birch_logs",
                new RotatedPillarBlock(Block.Properties.from(Blocks.BIRCH_LOG))
        );
        registerBlock("bundled_jungle_logs",
                new RotatedPillarBlock(Block.Properties.from(Blocks.JUNGLE_LOG))
        );
        registerBlock("bundled_acacia_logs",
                new RotatedPillarBlock(Block.Properties.from(Blocks.ACACIA_LOG))
        );
        registerBlock("bundled_dark_oak_logs",
                new RotatedPillarBlock(Block.Properties.from(Blocks.DARK_OAK_LOG))
        );
        registerBlock("bundled_crimson_logs",
                new RotatedPillarBlock(Block.Properties.from(Blocks.OAK_LOG))
        );
        registerBlock("bundled_warped_logs",
                new RotatedPillarBlock(Block.Properties.from(Blocks.OAK_LOG))
        );

        registerBlock("bundled_stripped_oak_logs",
                new RotatedPillarBlock(Block.Properties.from(Blocks.STRIPPED_OAK_LOG))
        );
        registerBlock("bundled_stripped_spruce_logs",
                new RotatedPillarBlock(Block.Properties.from(Blocks.STRIPPED_SPRUCE_LOG))
        );
        registerBlock("bundled_stripped_birch_logs",
                new RotatedPillarBlock(Block.Properties.from(Blocks.STRIPPED_BIRCH_LOG))
        );
        registerBlock("bundled_stripped_jungle_logs",
                new RotatedPillarBlock(Block.Properties.from(Blocks.STRIPPED_JUNGLE_LOG))
        );
        registerBlock("bundled_stripped_acacia_logs",
                new RotatedPillarBlock(Block.Properties.from(Blocks.STRIPPED_ACACIA_LOG))
        );
        registerBlock("bundled_stripped_dark_oak_logs",
                new RotatedPillarBlock(Block.Properties.from(Blocks.STRIPPED_DARK_OAK_LOG))
        );
        registerBlock("bundled_stripped_crimson_logs",
                new RotatedPillarBlock(Block.Properties.from(Blocks.STRIPPED_OAK_LOG))
        );
        registerBlock("bundled_stripped_warped_logs",
                new RotatedPillarBlock(Block.Properties.from(Blocks.STRIPPED_OAK_LOG))
        );

        registerBlock("oak_tile",
                new Block(Block.Properties.from(Blocks.OAK_PLANKS))
        );
        registerBlock("spruce_tile",
                new Block(Block.Properties.from(Blocks.SPRUCE_PLANKS))
        );
        registerBlock("birch_tile",
                new Block(Block.Properties.from(Blocks.BIRCH_PLANKS))
        );
        registerBlock("jungle_tile",
                new Block(Block.Properties.from(Blocks.JUNGLE_PLANKS))
        );
        registerBlock("acacia_tile",
                new Block(Block.Properties.from(Blocks.ACACIA_PLANKS))
        );
        registerBlock("dark_oak_tile",
                new Block(Block.Properties.from(Blocks.DARK_OAK_PLANKS))
        );
        registerBlock("crimson_tile",
                new Block(Block.Properties.from(Blocks.OAK_PLANKS))
        );
        registerBlock("warped_tile",
                new Block(Block.Properties.from(Blocks.OAK_PLANKS))
        );

        registerBlock("oak_tile_slab",
                new SlabBlock(Block.Properties.from(Blocks.OAK_PLANKS))
        );
        registerBlock("spruce_tile_slab",
                new SlabBlock(Block.Properties.from(Blocks.SPRUCE_PLANKS))
        );
        registerBlock("birch_tile_slab",
                new SlabBlock(Block.Properties.from(Blocks.BIRCH_PLANKS))
        );
        registerBlock("jungle_tile_slab",
                new SlabBlock(Block.Properties.from(Blocks.JUNGLE_PLANKS))
        );
        registerBlock("acacia_tile_slab",
                new SlabBlock(Block.Properties.from(Blocks.ACACIA_PLANKS))
        );
        registerBlock("dark_oak_tile_slab",
                new SlabBlock(Block.Properties.from(Blocks.DARK_OAK_PLANKS))
        );
        registerBlock("crimson_tile_slab",
                new SlabBlock(Block.Properties.from(Blocks.OAK_PLANKS))
        );
        registerBlock("warped_tile_slab",
                new SlabBlock(Block.Properties.from(Blocks.OAK_PLANKS))
        );

        registerBlock("ridged_oak_planks",
                new Block(Block.Properties.from(Blocks.OAK_PLANKS))
        );
        registerBlock("ridged_spruce_planks",
                new Block(Block.Properties.from(Blocks.SPRUCE_PLANKS))
        );
        registerBlock("ridged_birch_planks",
                new Block(Block.Properties.from(Blocks.BIRCH_PLANKS))
        );
        registerBlock("ridged_jungle_planks",
                new Block(Block.Properties.from(Blocks.JUNGLE_PLANKS))
        );
        registerBlock("ridged_acacia_planks",
                new Block(Block.Properties.from(Blocks.ACACIA_PLANKS))
        );
        registerBlock("ridged_dark_oak_planks",
                new Block(Block.Properties.from(Blocks.DARK_OAK_PLANKS))
        );
        registerBlock("ridged_crimson_planks",
                new Block(Block.Properties.from(Blocks.OAK_PLANKS))
        );
        registerBlock("ridged_warped_planks",
                new Block(Block.Properties.from(Blocks.OAK_PLANKS))
        );

        registerBlock("ridged_oak_slab",
                new SlabBlock(Block.Properties.from(Blocks.OAK_PLANKS))
        );
        registerBlock("ridged_spruce_slab",
                new SlabBlock(Block.Properties.from(Blocks.SPRUCE_PLANKS))
        );
        registerBlock("ridged_birch_slab",
                new SlabBlock(Block.Properties.from(Blocks.BIRCH_PLANKS))
        );
        registerBlock("ridged_jungle_slab",
                new SlabBlock(Block.Properties.from(Blocks.JUNGLE_PLANKS))
        );
        registerBlock("ridged_acacia_slab",
                new SlabBlock(Block.Properties.from(Blocks.ACACIA_PLANKS))
        );
        registerBlock("ridged_dark_oak_slab",
                new SlabBlock(Block.Properties.from(Blocks.DARK_OAK_PLANKS))
        );
        registerBlock("ridged_crimson_slab",
                new SlabBlock(Block.Properties.from(Blocks.OAK_PLANKS))
        );
        registerBlock("ridged_warped_slab",
                new SlabBlock(Block.Properties.from(Blocks.OAK_PLANKS))
        );

        registerBlock("spruce_crafting_table",
                new CrumbsCraftingTableBlock(Block.Properties.from(Blocks.SPRUCE_PLANKS))
        );
        registerBlock("birch_crafting_table",
                new CrumbsCraftingTableBlock(Block.Properties.from(Blocks.BIRCH_PLANKS))
        );
        registerBlock("jungle_crafting_table",
                new CrumbsCraftingTableBlock(Block.Properties.from(Blocks.JUNGLE_PLANKS))
        );
        registerBlock("acacia_crafting_table",
                new CrumbsCraftingTableBlock(Block.Properties.from(Blocks.ACACIA_PLANKS))
        );
        registerBlock("dark_oak_crafting_table",
                new CrumbsCraftingTableBlock(Block.Properties.from(Blocks.DARK_OAK_PLANKS))
        );
        registerBlock("crimson_crafting_table",
                new CrumbsCraftingTableBlock(Block.Properties.from(Blocks.OAK_PLANKS))
        );
        registerBlock("warped_crafting_table",
                new CrumbsCraftingTableBlock(Block.Properties.from(Blocks.OAK_PLANKS))
        );

        OAK_BARREL = registerBlock("oak_barrel",
            new CrumbsBarrelBlock(Block.Properties.from(Blocks.OAK_PLANKS))
        );
        BIRCH_BARREL = registerBlock("birch_barrel",
                new CrumbsBarrelBlock(Block.Properties.from(Blocks.BIRCH_PLANKS))
        );
        JUNGLE_BARREL = registerBlock("jungle_barrel",
                new CrumbsBarrelBlock(Block.Properties.from(Blocks.JUNGLE_PLANKS))
        );
        ACACIA_BARREL = registerBlock("acacia_barrel",
                new CrumbsBarrelBlock(Block.Properties.from(Blocks.ACACIA_PLANKS))
        );
        DARK_OAK_BARREL = registerBlock("dark_oak_barrel",
                new CrumbsBarrelBlock(Block.Properties.from(Blocks.DARK_OAK_PLANKS))
        );
        CRIMSON_BARREL = registerBlock("crimson_barrel",
                new CrumbsBarrelBlock(Block.Properties.from(Blocks.OAK_PLANKS))
        );
        WARPED_BARREL = registerBlock("warped_barrel",
                new CrumbsBarrelBlock(Block.Properties.from(Blocks.OAK_PLANKS))
        );

        registerBlock("glowing_granite",
                new Block(Block.Properties.from(Blocks.GRANITE))
        );
        Block cobbleGranite = new Block(Block.Properties.from(Blocks.GRANITE));
        registerBlock("cobble_granite", cobbleGranite);
        registerBlock("chiseled_granite",
                new Block(Block.Properties.from(Blocks.GRANITE))
        );
        registerBlock("bordered_granite",
                new Block(Block.Properties.from(Blocks.GRANITE))
        );
        Block crackedGranite = new Block(Block.Properties.from(Blocks.GRANITE));
        registerBlock("cracked_granite", crackedGranite);

        registerBlock("glowing_diorite",
                new Block(Block.Properties.from(Blocks.DIORITE))
        );
        Block cobbleDiorite = new Block(Block.Properties.from(Blocks.DIORITE));
        registerBlock("cobble_diorite",cobbleDiorite);
        registerBlock("chiseled_diorite",
                new Block(Block.Properties.from(Blocks.DIORITE))
        );
        registerBlock("bordered_diorite",
                new Block(Block.Properties.from(Blocks.DIORITE))
        );
        Block crackedDiorite = new Block(Block.Properties.from(Blocks.DIORITE));
        registerBlock("cracked_diorite", crackedDiorite);

        registerBlock("glowing_andesite",
                new Block(Block.Properties.from(Blocks.ANDESITE))
        );
        Block cobbleAndesite = new Block(Block.Properties.from(Blocks.ANDESITE));
        registerBlock("cobble_andesite", cobbleAndesite);
        registerBlock("chiseled_andesite",
                new Block(Block.Properties.from(Blocks.ANDESITE))
        );
        registerBlock("bordered_andesite",
                new Block(Block.Properties.from(Blocks.ANDESITE))
        );
        Block crackedAndesite =
                new Block(Block.Properties.from(Blocks.ANDESITE));
        registerBlock("cracked_andesite", crackedAndesite);

        registerBlock("glowing_basalt",
                new Block(Block.Properties.from(Blocks.STONE))
        );
        Block cobbleBasalt = new Block(Block.Properties.from(Blocks.STONE));
        registerBlock("cobble_basalt", cobbleBasalt);
        Block polishedBasalt = new Block(Block.Properties.from(Blocks.STONE));
        registerBlock("polished_basalt", polishedBasalt);
        registerBlock("chiseled_basalt",
                new Block(Block.Properties.from(Blocks.STONE))
        );
        registerBlock("bordered_basalt",
                new Block(Block.Properties.from(Blocks.STONE))
        );
        Block crackedBasalt = new Block(Block.Properties.from(Blocks.STONE));
        registerBlock("cracked_basalt", crackedBasalt);

        registerBlock("polished_basalt_slab",
                new SlabBlock(Block.Properties.from(polishedBasalt))
        );
        registerBlock("polished_basalt_stairs", new StairsBlock(
                polishedBasalt::getDefaultState,
                Block.Properties.from(polishedBasalt)
        ));
        
        registerBlock("cobble_granite_wall",
                new WallBlock(Block.Properties.from(cobbleGranite))
        );
        registerBlock("cobble_diorite_wall",
                new WallBlock(Block.Properties.from(cobbleDiorite))
        );
        registerBlock("cobble_andesite_wall",
                new WallBlock(Block.Properties.from(cobbleAndesite))
        );
        registerBlock("cobble_basalt_wall",
                new WallBlock(Block.Properties.from(cobbleBasalt))
        );


        registerBlock("cobble_granite_slab",
                new SlabBlock(Block.Properties.from(cobbleGranite))
        );
        registerBlock("cobble_diorite_slab",
                new SlabBlock(Block.Properties.from(cobbleDiorite))
        );
        registerBlock("cobble_andesite_slab",
                new SlabBlock(Block.Properties.from(cobbleAndesite))
        );
        registerBlock("cobble_basalt_slab",
                new SlabBlock(Block.Properties.from(cobbleBasalt))
        );

        registerBlock("cobble_granite_stairs", new StairsBlock(
                cobbleGranite::getDefaultState,
                Block.Properties.from(cobbleGranite)
        ));
        registerBlock("cobble_diorite_stairs", new StairsBlock(
                cobbleDiorite::getDefaultState,
                Block.Properties.from(cobbleDiorite)
        ));
        registerBlock("cobble_andesite_stairs", new StairsBlock(
                cobbleAndesite::getDefaultState,
                Block.Properties.from(cobbleAndesite)
        ));
        registerBlock("cobble_basalt_stairs", new StairsBlock(
                cobbleBasalt::getDefaultState,
                Block.Properties.from(cobbleBasalt)
        ));

        registerBlock("cracked_granite_slab",
                new SlabBlock(Block.Properties.from(crackedGranite))
        );
        registerBlock("cracked_diorite_slab",
                new SlabBlock(Block.Properties.from(crackedDiorite))
        );
        registerBlock("cracked_andesite_slab",
                new SlabBlock(Block.Properties.from(crackedAndesite))
        );
        registerBlock("cracked_basalt_slab",
                new SlabBlock(Block.Properties.from(crackedBasalt))
        );

        registerBlock("cracked_granite_stairs", new StairsBlock(
                crackedGranite::getDefaultState,
                Block.Properties.from(crackedGranite)
        ));
        registerBlock("cracked_diorite_stairs", new StairsBlock(
                crackedDiorite::getDefaultState,
                Block.Properties.from(crackedDiorite)
        ));
        registerBlock("cracked_andesite_stairs", new StairsBlock(
                crackedAndesite::getDefaultState,
                Block.Properties.from(crackedAndesite)
        ));
        registerBlock("cracked_basalt_stairs", new StairsBlock(
                crackedBasalt::getDefaultState,
                Block.Properties.from(crackedBasalt)
        ));

        registerBlock("granite_pebble",
                new PebbleBlock(Block.Properties.from(Blocks.GRANITE))
        );
        registerBlock("diorite_pebble",
                new PebbleBlock(Block.Properties.from(Blocks.DIORITE))
        );
        registerBlock("andesite_pebble",
                new PebbleBlock(Block.Properties.from(Blocks.ANDESITE))
        );
        registerBlock("basalt_pebble",
                new PebbleBlock(Block.Properties.from(Blocks.STONE))
        );

        registerBlock("glowing_sand",
                new Block(Block.Properties.from(Blocks.SAND))
        );
        Block sandstoneTile = new Block(
                Block.Properties.from(Blocks.SANDSTONE)
        );
        registerBlock("sandstone_tile", sandstoneTile);
        registerBlock("indented_sandstone_tile",
                new Block(Block.Properties.from(Blocks.SANDSTONE))
        );
        registerBlock("large_sandstone_tile",
                new Block(Block.Properties.from(Blocks.SANDSTONE))
        );

        registerBlock("glowing_red_sand",
                new Block(Block.Properties.from(Blocks.RED_SAND))
        );
        Block redSandstoneTile = new Block(
                Block.Properties.from(Blocks.RED_SANDSTONE)
        );
        registerBlock("red_sandstone_tile", redSandstoneTile);
        registerBlock("indented_red_sandstone_tile",
                new Block(Block.Properties.from(Blocks.RED_SANDSTONE))
        );
        registerBlock("large_red_sandstone_tile",
                new Block(Block.Properties.from(Blocks.RED_SANDSTONE))
        );

        registerBlock("sandstone_tile_wall",
                new WallBlock(Block.Properties.from(sandstoneTile))
        );
        registerBlock("red_sandstone_tile_wall",
                new WallBlock(Block.Properties.from(redSandstoneTile))
        );

        registerBlock("sandstone_tile_slab",
                new SlabBlock(Block.Properties.from(sandstoneTile))
        );
        registerBlock("red_sandstone_tile_slab",
                new SlabBlock(Block.Properties.from(redSandstoneTile))
        );

        registerBlock("sandstone_tile_stairs", new StairsBlock(
                sandstoneTile::getDefaultState,
                Block.Properties.from(sandstoneTile)
        ));
        registerBlock("red_sandstone_tile_stairs", new StairsBlock(
                redSandstoneTile::getDefaultState,
                Block.Properties.from(redSandstoneTile)
        ));

        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private RegistryObject<Block> registerBlock(String name, Block block) {
        return registerBlock(name, block, DEF_PROPS);
    }

    private RegistryObject<Block> registerBlock(String name, Block block, Item.Properties props) {
        registerItem(name, new BlockItem(block, props));
        return BLOCKS.register(name, () -> block);
    }

    private RegistryObject<Item> registerItem(String name, Item item) {
        return ITEMS.register(name, () -> item);
    }
}
