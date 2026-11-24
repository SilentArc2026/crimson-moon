package name.crimsonmoon.mixin;

import name.crimsonmoon.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(WorldChunk.class)
public class WorldChunkSculkMixin {

    @Shadow
    @Final
    World world;

    @ModifyVariable(
            method = "setBlockState",
            at = @At("HEAD"),
            argsOnly = true
    )
    private BlockState replaceVanillaSculkWithBloodSculk(BlockState state, BlockPos pos) {
        if (this.world == null || this.world.isClient) {
            return state;
        }

        if (state.isOf(Blocks.SCULK_VEIN)) {
            if (isNearBloodSculk(this.world, pos)) {
                return ModBlocks.BLOOD_SCULK_VEIN.getStateWithProperties(state);
            }
        } else if (state.isOf(Blocks.SCULK)) {
            if (isNearBloodSculk(this.world, pos)) {
                return ModBlocks.BLOOD_SCULK.getDefaultState();
            }
        }
        return state;
    }

    @Unique
    private static boolean isNearBloodSculk(World world, BlockPos pos) {
        // 1. Fast check: immediate 6 neighbors (handles ongoing spread chains)
        for (Direction dir : Direction.values()) {
            BlockState neighbor = world.getBlockState(pos.offset(dir));
            if (neighbor.isOf(ModBlocks.BLOOD_SCULK)
                    || neighbor.isOf(ModBlocks.BLOOD_SCULK_VEIN)
                    || neighbor.isOf(ModBlocks.BLOOD_SCULK_CATALYST)) {
                return true;
            }
        }

        // 2. Catalyst radius check: 8-block radius (handles initial mob death drop)
        for (BlockPos checkPos : BlockPos.iterateOutwards(pos, 8, 8, 8)) {
            if (world.getBlockState(checkPos).isOf(ModBlocks.BLOOD_SCULK_CATALYST)) {
                return true;
            }
        }
        return false;
    }
}
