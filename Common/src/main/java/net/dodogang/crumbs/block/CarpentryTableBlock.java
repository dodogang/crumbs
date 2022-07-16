package net.dodogang.crumbs.block;

import net.dodogang.crumbs.inventory.CarpentryTableMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CarpentryTableBlock extends HorizontalDirectionalBlock {
    public static final Component CONTAINER_TITLE = Component.translatable("container.carpentry_table");

    public static final DirectionProperty FACING_PROPERTY = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<Part> PART_PROPERTY = EnumProperty.create("part", Part.class);

    public static final VoxelShape TABLE_SHAPE = Block.box(0.0, 11.0, 0.0, 16.0, 16.0, 16.0);
    public static final VoxelShape NE_LEG_SHAPE = Block.box(13.0, 0.0, 1.0, 16.0, 11.0, 4.0);
    public static final VoxelShape NW_LEG_SHAPE = Block.box(0.0, 0.0, 1.0, 3.0, 11.0, 4.0);
    public static final VoxelShape SE_LEG_SHAPE = Block.box(13.0, 0.0, 12.0, 16.0, 11.0, 15.0);
    public static final VoxelShape SW_LEG_SHAPE = Block.box(0.0, 0.0, 12.0, 3.0, 11.0, 15.0);
    public static final VoxelShape EN_LEG_SHAPE = Block.box(12.0, 0.0, 0.0, 15.0, 11.0, 3.0);
    public static final VoxelShape ES_LEG_SHAPE = Block.box(12.0, 0.0, 13.0, 15.0, 11.0, 16.0);
    public static final VoxelShape WN_LEG_SHAPE = Block.box(1.0, 0.0, 0.0, 4.0, 11.0, 3.0);
    public static final VoxelShape WS_LEG_SHAPE = Block.box(1.0, 0.0, 13.0, 4.0, 11.0, 16.0);
    public static final VoxelShape N_BAR_SHAPE = Block.box(3.0, 1.0, 2.0, 13.0, 4.0, 4.0);
    public static final VoxelShape S_BAR_SHAPE = Block.box(3.0, 1.0, 12.0, 13.0, 4.0, 14.0);
    public static final VoxelShape E_BAR_SHAPE = Block.box(12.0, 1.0, 3.0, 14.0, 4.0, 13.0);
    public static final VoxelShape W_BAR_SHAPE = Block.box(2.0, 1.0, 1.0, 4.0, 4.0, 13.0);
    public static final VoxelShape NE_BAR_SHAPE = Block.box(13.0, 1.0, 4.0, 15.0, 4.0, 16.0);
    public static final VoxelShape NW_BAR_SHAPE = Block.box(1.0, 1.0, 4.0, 3.0, 4.0, 16.0);
    public static final VoxelShape SE_BAR_SHAPE = Block.box(13.0, 1.0, 0.0, 15.0, 4.0, 12.0);
    public static final VoxelShape SW_BAR_SHAPE = Block.box(1.0, 1.0, 0.0, 3.0,4.0, 12.0);
    public static final VoxelShape EN_BAR_SHAPE = Block.box(0.0, 1.0, 1.0, 12.0, 4.0, 3.0);
    public static final VoxelShape ES_BAR_SHAPE = Block.box(0.0, 1.0, 13.0, 12.0, 4.0, 15.0);
    public static final VoxelShape WN_BAR_SHAPE = Block.box(4.0, 1.0, 1.0, 16.0, 4.0, 3.0);
    public static final VoxelShape WS_BAR_SHAPE = Block.box(4.0, 1.0, 13.0, 16.0, 4.0, 15.0);

    public CarpentryTableBlock(BlockBehaviour.Properties props) {
        super(props);
        this.registerDefaultState(
                this.stateDefinition
                        .any()
                        .setValue(FACING_PROPERTY, Direction.NORTH)
                        .setValue(PART_PROPERTY, Part.TABLE)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING_PROPERTY, PART_PROPERTY);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction facing = context.getHorizontalDirection().getOpposite();
        BlockState tablePart = this.defaultBlockState().setValue(FACING_PROPERTY, facing);
        BlockState sawPart = this.defaultBlockState().setValue(FACING_PROPERTY, facing).setValue(PART_PROPERTY, Part.SAW);

        Level level = context.getLevel();
        BlockPos tablePos = context.getClickedPos();
        BlockPos sawPos = tablePos.relative(context.getHorizontalDirection());

        if (level.getBlockState(sawPos).canBeReplaced(context) && level.getWorldBorder().isWithinBounds(sawPos)) {
            level.setBlock(sawPos, sawPart, Block.UPDATE_ALL);
            return tablePart;
        } else {
            return null;
        }
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (level.isClientSide) {
            super.playerWillDestroy(level, pos, state, player);
            return;
        }

        Part thisPart = state.getValue(PART_PROPERTY);
        Part otherPart = thisPart == Part.TABLE ? Part.SAW : Part.TABLE;
        Direction facing = state.getValue(FACING_PROPERTY);
        BlockPos otherPos = pos.relative(thisPart == Part.TABLE ? facing.getOpposite() : facing);

        BlockState otherState = level.getBlockState(otherPos);

        if (otherState.is(this)) {
            if (otherState.getValue(FACING_PROPERTY) == facing && otherState.getValue(PART_PROPERTY) == otherPart) {
                level.setBlock(otherPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL | Block.UPDATE_SUPPRESS_DROPS);
            }
        }

        super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING_PROPERTY);
        Part part = state.getValue(PART_PROPERTY);

        if ((part == Part.TABLE && facing == Direction.NORTH) || (part == Part.SAW && facing == Direction.SOUTH)) {
            return Shapes.or(TABLE_SHAPE, NE_LEG_SHAPE, NW_LEG_SHAPE, N_BAR_SHAPE, NE_BAR_SHAPE, NW_BAR_SHAPE);
        } else if ((part == Part.TABLE && facing == Direction.SOUTH) || (part == Part.SAW && facing == Direction.NORTH)) {
            return Shapes.or(TABLE_SHAPE, SE_LEG_SHAPE, SW_LEG_SHAPE, S_BAR_SHAPE, SE_BAR_SHAPE, SW_BAR_SHAPE);
        } else if ((part == Part.TABLE && facing == Direction.EAST) || (part == Part.SAW && facing == Direction.WEST)) {
            return Shapes.or(TABLE_SHAPE, EN_LEG_SHAPE, ES_LEG_SHAPE, E_BAR_SHAPE, EN_BAR_SHAPE, ES_BAR_SHAPE);
        } else if ((part == Part.TABLE && facing == Direction.WEST) || (part == Part.SAW && facing == Direction.EAST)) {
            return Shapes.or(TABLE_SHAPE, WN_LEG_SHAPE, WS_LEG_SHAPE, W_BAR_SHAPE, WN_BAR_SHAPE, WS_BAR_SHAPE);
        }

        return Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState blockState) {
        return true;
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            player.openMenu(blockState.getMenuProvider(level, blockPos));
            // player.awardStat();  TODO: Award stat for CarpentryTableBlock interaction
            return InteractionResult.CONSUME;
        }
    }

    @Nullable
    @Override
    public MenuProvider getMenuProvider(BlockState blockState, Level level, BlockPos blockPos) {
        return new SimpleMenuProvider((i, inventory, player) -> {
            return new CarpentryTableMenu(i, inventory, ContainerLevelAccess.create(level, blockPos));
        }, CONTAINER_TITLE);
    }

    public enum Part implements StringRepresentable {
        TABLE,
        SAW;

        @Override
        public String getSerializedName() {
            return this.toString().toLowerCase();
        }
    }
}
