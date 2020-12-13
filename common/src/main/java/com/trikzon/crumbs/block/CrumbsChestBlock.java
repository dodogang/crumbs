package com.trikzon.crumbs.block;

import com.trikzon.crumbs.block.entity.CrumbsBlockEntityType;
import com.trikzon.crumbs.block.entity.CrumbsChestBlockEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;

public class CrumbsChestBlock extends ChestBlock implements EntityBlock {
    public final ModelType modelType;

    public CrumbsChestBlock( ModelType modelType, Properties properties) {
        super(properties, () -> CrumbsBlockEntityType.CRUMBS_CHEST);

        this.modelType = modelType;
    }

    @Override
    public BlockEntity newBlockEntity(BlockGetter blockGetter) {
        return new CrumbsChestBlockEntity();
    }

    public enum ModelType {
        OAK,
        BIRCH,
        SPRUCE,
        ACACIA,
        CRIMSON,
    }
}
