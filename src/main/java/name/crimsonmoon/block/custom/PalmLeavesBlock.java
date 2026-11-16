package name.crimsonmoon.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class PalmLeavesBlock extends LeavesBlock {
    public static final int MAX_PALM_DISTANCE = 12;
    public static final IntProperty PALM_DISTANCE = IntProperty.of("palm_distance", 1, MAX_PALM_DISTANCE);

    public PalmLeavesBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(DISTANCE, 1)
                .with(PALM_DISTANCE, MAX_PALM_DISTANCE)
                .with(PERSISTENT, false)
                .with(WATERLOGGED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(PALM_DISTANCE);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return state.get(PERSISTENT);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockState updated = updatePalmDistance(state, world, pos);
        if (updated != state) {
            world.setBlockState(pos, updated, Block.NOTIFY_ALL);
            state = updated;
        }
        if (this.shouldDecay(state)) {
            dropStacks(state, world, pos);
            world.removeBlock(pos, false);
        }
    }

    @Override
    protected boolean shouldDecay(BlockState state) {
        return !state.get(PERSISTENT) && state.get(PALM_DISTANCE) == MAX_PALM_DISTANCE;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.setBlockState(pos, updatePalmDistance(state, world, pos), Block.NOTIFY_ALL);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        int i = getDistanceFromLog(neighborState) + 1;
        if (i != 1 || state.get(PALM_DISTANCE) != i) {
            world.scheduleBlockTick(pos, this, 1);
        }
        return state;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState state = super.getPlacementState(ctx);
        return updatePalmDistance(state, ctx.getWorld(), ctx.getBlockPos());
    }

    private static BlockState updatePalmDistance(BlockState state, WorldAccess world, BlockPos pos) {
        int i = MAX_PALM_DISTANCE;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (Direction direction : Direction.values()) {
            mutable.set(pos, direction);
            i = Math.min(i, getDistanceFromLog(world.getBlockState(mutable)) + 1);
            if (i == 1) break;
        }
        return state.with(PALM_DISTANCE, i);
    }

    private static int getDistanceFromLog(BlockState state) {
        if (state.isIn(BlockTags.LOGS)) {
            return 0;
        }
        if (state.getBlock() instanceof PalmLeavesBlock) {
            return state.get(PALM_DISTANCE);
        }
        return MAX_PALM_DISTANCE;
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!world.isClient) {
            world.scheduleBlockTick(pos, this, 1);
        }
    }
}
