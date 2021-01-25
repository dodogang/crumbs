package net.dodogang.crumbs.block;

import net.dodogang.crumbs.block.entity.CrumbsBlockEntityType;
import net.dodogang.crumbs.block.entity.CrumbsChestBlockEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class CrumbsChestBlock extends ChestBlock implements BlockEntityProvider {
    public final ModelType modelType;

    public CrumbsChestBlock(ModelType modelType, Settings settings) {
        super(settings, () -> CrumbsBlockEntityType.CRUMBS_CHEST);

        this.modelType = modelType;
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new CrumbsChestBlockEntity(this);
    }

    public enum ModelType {
        OAK,
        BIRCH,
        SPRUCE,
        ACACIA,
        CRIMSON,
    }
}
