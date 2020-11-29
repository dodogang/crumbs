package com.trikzon.crumbs.block;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.entity.BarrelBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.Random;

public class CrumbsBarrelBlock extends BarrelBlock {
    public static final ArrayList<BlockState> MOD_BARRELS = new ArrayList<>();

    public CrumbsBarrelBlock(Properties properties) {
        super(properties);

        // Copied from PoiType#getBlockStates because it is private.
        MOD_BARRELS.addAll(ImmutableSet.copyOf(this.getStateDefinition().getPossibleStates()));
    }

    // Copied from BarrelBlock#tick and BarrelBlockEntity#recheckOpen to get around
    // hard-coded blockState.is(Blocks.BARREL).
    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, Random random) {
        BlockEntity blockEntity = serverLevel.getBlockEntity(blockPos);
        if (blockEntity instanceof BarrelBlockEntity) {
            int i = blockEntity.getBlockPos().getX();
            int j = blockEntity.getBlockPos().getY();
            int k = blockEntity.getBlockPos().getZ();
            int numPlayersUsing = ChestBlockEntity.getOpenCount(serverLevel, (BarrelBlockEntity) blockEntity, i, j, k);
            if (numPlayersUsing > 0) {
                serverLevel.getBlockTicks().scheduleTick(blockPos, blockState.getBlock(), 5);
            } else {
                if (!(blockState.getBlock() instanceof BarrelBlock)) {
                    blockEntity.setRemoved();
                    return;
                }
                if (blockState.getValue(BarrelBlock.OPEN)) {
                    this.playSound(blockEntity, blockState);
                    serverLevel.setBlock(blockPos, blockState.setValue(BarrelBlock.OPEN, false), 3);
                }
            }
        }
    }

    // Copied from BarrelBlockEntity#playSound. See CrumbsBarrelBlock#tick.
    private void playSound(BlockEntity blockEntity, BlockState blockState) {
        Vec3i vec3i = blockState.getValue(BarrelBlock.FACING).getNormal();
        double d = blockEntity.getBlockPos().getX() + 0.5D + (double)vec3i.getX() / 2.0D;
        double e = blockEntity.getBlockPos().getY() + 0.5D + (double)vec3i.getY() / 2.0D;
        double f = blockEntity.getBlockPos().getZ() + 0.5D + (double)vec3i.getZ() / 2.0D;
        blockEntity.getLevel().playSound(
                null, d, e, f, SoundEvents.BARREL_CLOSE,
                SoundSource.BLOCKS, 0.5F,
                blockEntity.getLevel().random.nextFloat() * 0.1F + 0.9F
        );
    }

    // TODO: Register Point Of Interest
    public static void registerPointsOfInterest() {

    }
}
