package net.dodogang.crumbs.block;

import com.google.common.collect.ImmutableSet;

import net.dodogang.crumbs.init.CrumbsBlocks;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.BarrelTileEntity;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.Random;

public class CrumbsBarrelBlock extends BarrelBlock {
    public CrumbsBarrelBlock(Block.Properties properties) {
        super(properties);
    }

    /**
     * Copied from BarrelTileEntity.java and BarrelBlock.java
     * To get around hard coded == Blocks.BARREL
     */
    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        TileEntity te = worldIn.getTileEntity(pos);
        if (te == null || te.getWorld() == null) return;
        if (te instanceof BarrelTileEntity) {
            int i = te.getPos().getX();
            int j = te.getPos().getY();
            int k = te.getPos().getZ();
            int numPlayersUsing = ChestTileEntity.calculatePlayersUsing(
                    te.getWorld(),
                    (BarrelTileEntity) te,
                    i, j, k
            );
            if (numPlayersUsing > 0) {
                te.getWorld().getPendingBlockTicks().scheduleTick(
                        te.getPos(), te.getBlockState().getBlock(), 5
                );
            } else {
                if (state.get(BarrelBlock.PROPERTY_OPEN)) {
                    playSound(
                            (BarrelTileEntity) te, state
                    );
                    te.getWorld().setBlockState(
                            te.getPos(),
                            state.with(BarrelBlock.PROPERTY_OPEN, false),
                            3
                    );
                }
            }
        }
    }

    /**
     * Copied from BarrelTileEntity.java
     * To get around hard coded == Blocks.BARREL
     */
    private void playSound(BarrelTileEntity te, BlockState state) {
        World world = te.getWorld();
        if (world == null) return;
        Vec3i vec3i = state.get(BarrelBlock.PROPERTY_FACING).getDirectionVec();
        double d0 = (double)te.getPos().getX() + 0.5D + (double)vec3i.getX() / 2.0D;
        double d1 = (double)te.getPos().getY() + 0.5D + (double)vec3i.getY() / 2.0D;
        double d2 = (double)te.getPos().getZ() + 0.5D + (double)vec3i.getZ() / 2.0D;
        world.playSound(
            null, d0, d1, d2, SoundEvents.BLOCK_BARREL_CLOSE,
            SoundCategory.BLOCKS, 0.5F,
            world.rand.nextFloat() * 0.1F + 0.9F
        );
    }

    public static void registerAsPointOfInterest()
    {
        final ArrayList<BlockState> barrels = new ArrayList<>();
        final ArrayList<BlockState> modBarrels = new ArrayList<>();
        barrels.addAll(PointOfInterestType.FISHERMAN.blockStates);
        modBarrels.addAll(PointOfInterestType.getAllStates(CrumbsBlocks.OAK_BARREL));
        modBarrels.addAll(PointOfInterestType.getAllStates(CrumbsBlocks.BIRCH_BARREL));
        modBarrels.addAll(PointOfInterestType.getAllStates(CrumbsBlocks.JUNGLE_BARREL));
        modBarrels.addAll(PointOfInterestType.getAllStates(CrumbsBlocks.ACACIA_BARREL));
        modBarrels.addAll(PointOfInterestType.getAllStates(CrumbsBlocks.DARK_OAK_BARREL));
//        modBarrels.addAll(PointOfInterestType.getAllStates(CrumbsBlocks.CRIMSON_BARREL));
//        modBarrels.addAll(PointOfInterestType.getAllStates(CrumbsBlocks.WARPED_BARREL));

        // Copied from PointOfInterestType#registerBlockStates
        // Edited to allow adding blocks to a PointOfInterest so villagers use them
        modBarrels.forEach((modBarrel) -> {
            PointOfInterestType pointofinteresttype =
                    PointOfInterestType.POIT_BY_BLOCKSTATE.put(
                            modBarrel, PointOfInterestType.FISHERMAN
                    );
            if (pointofinteresttype != null) {
                throw Util.pauseDevMode(new IllegalStateException(
                        String.format("%s is defined in too many tags", modBarrel)
                ));
            }
        });

        barrels.addAll(modBarrels);
        PointOfInterestType.FISHERMAN.blockStates = ImmutableSet.copyOf(barrels);
    }
}
