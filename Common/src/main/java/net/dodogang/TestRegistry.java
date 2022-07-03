package net.dodogang;

import net.dodogang.ash.registry.api.RegistryBatch;
import net.dodogang.crumbs.Crumbs;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

import java.util.function.Supplier;

public class TestRegistry {
    public static final RegistryBatch<Block> BLOCKS = RegistryBatch.create(Registry.BLOCK, Crumbs.MOD_ID);

    public static final Supplier<Block> TEST_BLOCK = BLOCKS.register("test_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)));
}