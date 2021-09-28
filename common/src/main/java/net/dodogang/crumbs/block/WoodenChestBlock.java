package net.dodogang.crumbs.block;

import net.dodogang.crumbs.block.entity.CrumbsBlockEntityTypes;
import net.dodogang.crumbs.block.entity.WoodenChestBlockEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class WoodenChestBlock extends ChestBlock implements BlockEntityProvider {
    public final ModelType modelType;

    public WoodenChestBlock(ModelType modelType, Settings settings) {
        super(settings, () -> CrumbsBlockEntityTypes.WOODEN_CHEST);
        this.modelType = modelType;
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new WoodenChestBlockEntity(this);
    }

    public enum ModelType {
        OAK,
        BIRCH,
        SPRUCE,
        ACACIA,
        CRIMSON,
    }
}
