package name.crimsonmoon.block.custom;

import name.crimsonmoon.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;

public class CustomGrassBlock extends GrassBlock {
    public CustomGrassBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        // 1. Check if this grass block should decay into dirt due to lack of light
        if (!canSurvive(state, world, pos)) {
            world.setBlockState(pos, ModBlocks.CORRUPTED_DIRT.getDefaultState());
            return;
        }

        // 2. If light is bright enough, try to spread onto neighboring custom dirt blocks
        if (world.getLightLevel(pos.up()) >= 9) {
            for (int i = 0; i < 4; ++i) {
                // Pick a random nearby spot within a small 3x5x3 area
                BlockPos targetPos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                BlockState targetState = world.getBlockState(targetPos);

                // Check if the target is your custom dirt block and has enough light overhead to receive grass
                if (targetState.isOf(ModBlocks.CORRUPTED_DIRT) && canSpread(targetState, world, targetPos)) {
                    // Turn that custom dirt into your custom grass block!
                    world.setBlockState(targetPos, ModBlocks.CORRUPTED_GRASS_BLOCK.getDefaultState());
                }
            }
        }
    }

    // Helper checking vanilla's light constraints for grass survival
    private static boolean canSurvive(BlockState state, WorldView world, BlockPos pos) {
        BlockPos upPos = pos.up();
        BlockState upState = world.getBlockState(upPos);
        if (upState.isOf(Blocks.SNOW) && upState.get(net.minecraft.block.SnowBlock.LAYERS) == 1) {
            return true;
        } else if (upState.getFluidState().getLevel() == 8) {
            return false;
        } else {
            int light = ChunkLightProvider.getRealisticOpacity(world, state, pos, upState, upPos, net.minecraft.util.math.Direction.UP, upState.getOpacity(world, upPos));
            return world.getLightLevel(upPos) >= 4 && light < world.getMaxLightLevel();
        }
    }

    // Helper checking if a target block has clear lighting access to grow grass
    private static boolean canSpread(BlockState state, WorldView world, BlockPos pos) {
        BlockPos upPos = pos.up();
        return canSurvive(state, world, pos) && !world.getFluidState(upPos).isStill();
    }
}