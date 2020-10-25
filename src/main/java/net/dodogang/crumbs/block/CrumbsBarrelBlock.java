package net.dodogang.crumbs.block;

import com.google.common.collect.ImmutableSet;

import net.dodogang.crumbs.mixin.PointOfInterestTypeAccessor;
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
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.Random;

public class CrumbsBarrelBlock extends BarrelBlock {
    public static final ArrayList<BlockState> modBarrels = new ArrayList<>();

    public CrumbsBarrelBlock(Block.Properties properties) {
        super(properties);

        modBarrels.addAll(PointOfInterestType.getAllStates(this));
    }

    /**
     * Copied from BarrelTileEntity.java and BarrelBlock.java To get around hard
     * coded == Blocks.BARREL
     */
    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        TileEntity te = worldIn.getTileEntity(pos);
        if (te == null || te.getWorld() == null)
            return;
        if (te instanceof BarrelTileEntity) {
            int i = te.getPos().getX();
            int j = te.getPos().getY();
            int k = te.getPos().getZ();
            int numPlayersUsing = ChestTileEntity.calculatePlayersUsing(te.getWorld(), (BarrelTileEntity) te, i, j, k);
            if (numPlayersUsing > 0) {
                te.getWorld().getPendingBlockTicks().scheduleTick(te.getPos(), te.getBlockState().getBlock(), 5);
            } else {
                if (state.get(BarrelBlock.PROPERTY_OPEN)) {
                    playSound((BarrelTileEntity) te, state);
                    te.getWorld().setBlockState(te.getPos(), state.with(BarrelBlock.PROPERTY_OPEN, false), 3);
                }
            }
        }
    }

    /**
     * Copied from BarrelTileEntity.java To get around hard coded == Blocks.BARREL
     */
    private void playSound(BarrelTileEntity te, BlockState state) {
        World world = te.getWorld();
        if (world == null)
            return;
        Vector3i vec3i = state.get(BarrelBlock.PROPERTY_FACING).getDirectionVec();
        double d0 = (double)te.getPos().getX() + 0.5D + (double)vec3i.getX() / 2.0D;
        double d1 = (double)te.getPos().getY() + 0.5D + (double)vec3i.getY() / 2.0D;
        double d2 = (double)te.getPos().getZ() + 0.5D + (double)vec3i.getZ() / 2.0D;
        world.playSound(
            null, d0, d1, d2, SoundEvents.BLOCK_BARREL_CLOSE,
            SoundCategory.BLOCKS, 0.5F,
            world.rand.nextFloat() * 0.1F + 0.9F
        );
    }

    public static void registerPointsOfInterest() {
        // Copied from PointOfInterestType#registerBlockStates
        // Edited to allow adding blocks to a POI
        modBarrels.forEach((modBarrel) -> {
            PointOfInterestType pointOfInterestType = PointOfInterestTypeAccessor.getBlockStateToPointOfInterest()
                    .put(modBarrel, PointOfInterestType.FISHERMAN);
            if (pointOfInterestType != null) {
                throw Util.pauseDevMode(new IllegalStateException(
                        String.format("%s is defined in too many tags", modBarrel)
                ));
            }
        });
        PointOfInterestTypeAccessor fishermanAccessor = (PointOfInterestTypeAccessor) PointOfInterestType.FISHERMAN;

        ArrayList<BlockState> blockStates = new ArrayList<>(fishermanAccessor.getBlockStates());
        blockStates.addAll(modBarrels);

        fishermanAccessor.setBlockStates(ImmutableSet.copyOf(blockStates));
    }
}
