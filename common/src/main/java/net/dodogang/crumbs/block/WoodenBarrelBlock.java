package net.dodogang.crumbs.block;

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

import java.util.Random;

public class WoodenBarrelBlock extends BarrelBlock {
    public WoodenBarrelBlock(Settings settings) {
        super(settings);
    }

    // Copied from BarrelBlock#scheduledTick and BarrelBlockEntity#tick to get
    // around hard-coded blockState.is(Blocks.BARREL).
    @Override
    public void scheduledTick(BlockState blockState, ServerWorld serverWorld, BlockPos blockPos, Random random) {
        BlockEntity blockEntity = serverWorld.getBlockEntity(blockPos);
        if (blockEntity instanceof BarrelBlockEntity) {
            int x = blockEntity.getPos().getX();
            int y = blockEntity.getPos().getY();
            int z = blockEntity.getPos().getZ();
            int numPlayersUsing = ChestBlockEntity.countViewers(serverWorld, (BarrelBlockEntity) blockEntity, x, y, z);
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

    // Copied from BarrelBlockEntity#playSound. See WoodenBarrelBlock#scheduledTick.
    private void playSound(BlockEntity blockEntity, BlockState blockState) {
        Vec3i vec3i = blockState.get(BarrelBlock.FACING).getVector();
        double x = blockEntity.getPos().getX() + 0.5D + (double)vec3i.getX() / 2.0D;
        double y = blockEntity.getPos().getY() + 0.5D + (double)vec3i.getY() / 2.0D;
        double z = blockEntity.getPos().getZ() + 0.5D + (double)vec3i.getZ() / 2.0D;
        blockEntity.getWorld().playSound(
                null,
                x, y, z,
                SoundEvents.BLOCK_BARREL_CLOSE,
                SoundCategory.BLOCKS,
                0.5F,
                blockEntity.getWorld().random.nextFloat() * 0.1F + 0.9F
        );
    }
}
