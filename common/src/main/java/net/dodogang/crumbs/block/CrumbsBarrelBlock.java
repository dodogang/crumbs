package net.dodogang.crumbs.block;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BarrelBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;

import java.util.ArrayList;
import java.util.Random;

public class CrumbsBarrelBlock extends BarrelBlock {
    public static final ArrayList<BlockState> MOD_BARRELS = new ArrayList<>();

    public CrumbsBarrelBlock(Settings settings) {
        super(settings);

        // Copied from PointOfInterestType#getAllStatesOf because it is private.
        MOD_BARRELS.addAll(ImmutableSet.copyOf(this.getStateManager().getStates()));
    }

    // Copied from BarrelBlock#scheduleTick and BarrelBlockEntity#tick to get around
    // hard-coded blockState.is(Blocks.BARREL).
    @Override
    public void scheduledTick(BlockState blockState, ServerWorld serverWorld, BlockPos blockPos, Random random) {
        BlockEntity blockEntity = serverWorld.getBlockEntity(blockPos);
        if (blockEntity instanceof BarrelBlockEntity) {
            int i = blockEntity.getPos().getX();
            int j = blockEntity.getPos().getY();
            int k = blockEntity.getPos().getZ();
            int numPlayersUsing = ChestBlockEntity.countViewers(serverWorld, (BarrelBlockEntity) blockEntity, i, j, k);
            if (numPlayersUsing > 0) {
                serverWorld.getBlockTickScheduler().schedule(blockPos, blockState.getBlock(), 5);
            } else {
                if (!(blockState.getBlock() instanceof BarrelBlock)) {
                    blockEntity.markRemoved();
                    return;
                }
                if (blockState.get(BarrelBlock.OPEN)) {
                    this.playSound(blockEntity, blockState);
                    serverWorld.setBlockState(blockPos, blockState.with(BarrelBlock.OPEN, false), 3);
                }
            }
        }
    }

    // Copied from BarrelBlockEntity#playSound. See CrumbsBarrelBlock#tick.
    private void playSound(BlockEntity blockEntity, BlockState blockState) {
        Vec3i vec3i = blockState.get(BarrelBlock.FACING).getVector();
        double d = blockEntity.getPos().getX() + 0.5D + (double)vec3i.getX() / 2.0D;
        double e = blockEntity.getPos().getY() + 0.5D + (double)vec3i.getY() / 2.0D;
        double f = blockEntity.getPos().getZ() + 0.5D + (double)vec3i.getZ() / 2.0D;
        blockEntity.getWorld().playSound(
                null, d, e, f, SoundEvents.BLOCK_BARREL_CLOSE,
                SoundCategory.BLOCKS, 0.5F,
                blockEntity.getWorld().random.nextFloat() * 0.1F + 0.9F);
    }
}