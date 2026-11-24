package name.crimsonmoon.block.custom;

import name.crimsonmoon.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.entity.SculkSpreadManager;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;

public class BloodSculkVeinBlock extends SculkVeinBlock {
    public BloodSculkVeinBlock(Settings settings) {
        super(settings);
    }

    @Override
    public int spread(SculkSpreadManager.Cursor cursor, WorldAccess world, BlockPos catalystPos, Random random, SculkSpreadManager spreadManager, boolean shouldConvertToBlock) {
        if (shouldConvertToBlock && this.convertToBloodBlock(spreadManager, world, cursor.getPos(), random)) {
            return cursor.getCharge() - 1;
        }
        return random.nextInt(spreadManager.getSpreadChance()) == 0
                ? MathHelper.floor((float) cursor.getCharge() * 0.5f)
                : cursor.getCharge();
    }

    private boolean convertToBloodBlock(SculkSpreadManager spreadManager, WorldAccess world, BlockPos pos, Random random) {
        BlockState veinState = world.getBlockState(pos);
        TagKey<Block> replaceableTag = spreadManager.getReplaceableTag();

        for (Direction dir : Direction.shuffle(random)) {
            if (!hasDirection(veinState, dir)) continue;
            BlockPos targetPos = pos.offset(dir);
            BlockState targetState = world.getBlockState(targetPos);

            if (!targetState.isIn(replaceableTag)) continue;

            // Convert target block into BLOOD_SCULK
            BlockState bloodSculkState = ModBlocks.BLOOD_SCULK.getDefaultState();
            world.setBlockState(targetPos, bloodSculkState, Block.NOTIFY_ALL);
            Block.pushEntitiesUpBeforeBlockChange(targetState, bloodSculkState, world, targetPos);
            world.playSound(null, targetPos, SoundEvents.BLOCK_SCULK_SPREAD, SoundCategory.BLOCKS, 1.0f, 1.0f);

            // Spread BLOOD_SCULK_VEIN onto adjacent faces
            this.getGrower().grow(bloodSculkState, world, targetPos, spreadManager.isWorldGen());

            // Clean up any veins now facing into the new Blood Sculk block
            Direction opposite = dir.getOpposite();
            for (Direction checkDir : DIRECTIONS) {
                if (checkDir == opposite) continue;
                BlockPos neighborPos = targetPos.offset(checkDir);
                BlockState neighborState = world.getBlockState(neighborPos);
                if (neighborState.isOf(this)) {
                    this.spreadAtSamePosition(world, neighborState, neighborPos, random);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void spreadAtSamePosition(WorldAccess world, BlockState state, BlockPos pos, Random random) {
        if (!state.isOf(this)) return;
        for (Direction dir : DIRECTIONS) {
            BooleanProperty prop = getProperty(dir);
            if (state.get(prop) && world.getBlockState(pos.offset(dir)).isOf(ModBlocks.BLOOD_SCULK)) {
                state = state.with(prop, false);
            }
        }
        if (!hasAnyDirection(state)) {
            FluidState fluidState = world.getFluidState(pos);
            world.setBlockState(pos, (fluidState.isOf(Fluids.WATER) ? Blocks.WATER : Blocks.AIR).getDefaultState(), Block.NOTIFY_ALL);
        } else {
            world.setBlockState(pos, state, Block.NOTIFY_ALL);
        }
    }
}