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
import net.minecraft.world.World;

import java.util.Random;

public class CrumbsBarrelBlock extends BarrelBlock {
    public CrumbsBarrelBlock(Settings settings) {
        super(settings);
    }

    /**
     * Copied from BarrelBlockEntity.java and BarrelBlock.java to get around hard coded == Blocks.BARREL.
     */
    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockEntity be = world.getBlockEntity(pos);
        if (be == null || be.getWorld() == null)
            return;
        if (be instanceof BarrelBlockEntity) {
            int i = be.getPos().getX();
            int j = be.getPos().getY();
            int k = be.getPos().getZ();
            int numPlayersUsing = ChestBlockEntity.countViewers(be.getWorld(), (BarrelBlockEntity) be, i, j, k);
            if (numPlayersUsing > 0) {
                be.getWorld().getBlockTickScheduler().schedule(be.getPos(), be.getCachedState().getBlock(), 5);
            } else {
                if (state.get(BarrelBlock.OPEN)) {
                    playSound((BarrelBlockEntity) be, state);
                    be.getWorld().setBlockState(be.getPos(), state.with(BarrelBlock.OPEN, false), 3);
                }
            }
        }
    }

    /**
     * Copied from BarrelBlockEntity.java to get around hard coded == Blocks.BARREL.
     */
    private void playSound(BarrelBlockEntity te, BlockState state) {
        World world = te.getWorld();
        if (world == null)
            return;
        Vec3i vec3i = state.get(BarrelBlock.FACING).getVector();
        double d0 = (double)te.getPos().getX() + 0.5D + (double)vec3i.getX() / 2.0D;
        double d1 = (double)te.getPos().getY() + 0.5D + (double)vec3i.getY() / 2.0D;
        double d2 = (double)te.getPos().getZ() + 0.5D + (double)vec3i.getZ() / 2.0D;
        world.playSound(
                null, d0, d1, d2, SoundEvents.BLOCK_BARREL_CLOSE,
                SoundCategory.BLOCKS, 0.5F,
                world.random.nextFloat() * 0.1F + 0.9F
        );
    }
}
