package name.crimsonmoon.block.custom;

import name.crimsonmoon.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CactusBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class CrimsonCactusBlock extends CactusBlock {
    private static final int MAX_HEIGHT = 4; // Vanilla is 3
    private static final float CONTACT_DAMAGE = 2.0F; // Vanilla is 1.0F (0.5 hearts)

    public CrimsonCactusBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        for (Direction direction : Direction.Type.HORIZONTAL) {
            BlockState neighborState = world.getBlockState(pos.offset(direction));
            if (neighborState.isSolid() || world.getFluidState(pos.offset(direction)).isIn(FluidTags.LAVA)) {
                return false;
            }
        }

        BlockState floorState = world.getBlockState(pos.down());
        boolean isValidSand = floorState.isOf(Blocks.SAND)
                || floorState.isOf(Blocks.RED_SAND)
                || floorState.isOf(ModBlocks.BLACK_SAND)
                || floorState.isOf(ModBlocks.WET_SAND)
                || floorState.isOf(ModBlocks.WET_RED_SAND)
                || floorState.isOf(ModBlocks.WET_BLACK_SAND)
                || floorState.isIn(BlockTags.SAND);

        return (floorState.isOf(this) || isValidSand) && !world.getBlockState(pos.up()).isLiquid();
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockPos abovePos = pos.up();
        if (!world.isAir(abovePos)) {
            return;
        }

        int height = 1;
        while (world.getBlockState(pos.down(height)).isOf(this)) {
            height++;
        }

        if (height < MAX_HEIGHT) {
            int age = state.get(AGE);
            // Change 15 to a lower number (e.g., 7) for faster growth
            if (age == 15) {
                world.setBlockState(abovePos, this.getDefaultState());
                BlockState resetState = state.with(AGE, 0);
                world.setBlockState(pos, resetState, Block.NO_REDRAW);
                world.updateNeighbor(resetState, abovePos, this, pos, false);
            } else {
                world.setBlockState(pos, state.with(AGE, age + 1), Block.NO_REDRAW);
            }
        }
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        entity.damage(world.getDamageSources().cactus(), CONTACT_DAMAGE);
        if (!world.isClient && entity instanceof LivingEntity livingEntity) {
            // Optional: apply a brief debuff on contact
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 40, 0));
        }
    }
}