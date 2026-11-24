package name.crimsonmoon.block.custom;

import name.crimsonmoon.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.entity.SculkSpreadManager;
import net.minecraft.fluid.Fluids;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;

public class BloodSculkBlock extends SculkBlock {
    public BloodSculkBlock(Settings settings) {
        super(settings);
    }

    @Override
    public int spread(SculkSpreadManager.Cursor cursor, WorldAccess world, BlockPos catalystPos, Random random, SculkSpreadManager spreadManager, boolean shouldConvertToBlock) {
        int charge = cursor.getCharge();
        if (charge == 0 || random.nextInt(spreadManager.getSpreadChance()) != 0) {
            return charge;
        }
        BlockPos pos = cursor.getPos();
        boolean farEnough = pos.isWithinDistance(catalystPos, spreadManager.getMaxDistance());

        if (!farEnough && shouldNotDecay(world, pos)) {
            int extraCharge = spreadManager.getExtraBlockChance();
            if (random.nextInt(extraCharge) < charge) {
                BlockPos above = pos.up();
                BlockState growthState = this.getBloodExtraBlockState(world, above, random, spreadManager.isWorldGen());
                world.setBlockState(above, growthState, Block.NOTIFY_ALL);
                world.playSound(null, pos, growthState.getSoundGroup().getPlaceSound(), SoundCategory.BLOCKS, 1.0f, 1.0f);
            }
            return Math.max(0, charge - extraCharge);
        }
        return random.nextInt(spreadManager.getDecayChance()) != 0
                ? charge
                : charge - (farEnough ? 1 : getDecay(spreadManager, pos, catalystPos, charge));
    }

    private BlockState getBloodExtraBlockState(WorldAccess world, BlockPos pos, Random random, boolean allowShrieker) {
        BlockState state = random.nextInt(11) == 0
                ? ModBlocks.BLOOD_SCULK_SHRIEKER.getDefaultState().with(SculkShriekerBlock.CAN_SUMMON, allowShrieker)
                : ModBlocks.BLOOD_SCULK_SENSOR.getDefaultState();

        return state.contains(Properties.WATERLOGGED) && !world.getFluidState(pos).isEmpty()
                ? state.with(Properties.WATERLOGGED, true)
                : state;
    }

    private static boolean shouldNotDecay(WorldAccess world, BlockPos pos) {
        BlockState aboveState = world.getBlockState(pos.up());
        if (!aboveState.isAir() && (!aboveState.isOf(Blocks.WATER) || !aboveState.getFluidState().isOf(Fluids.WATER))) {
            return false;
        }
        int nearbySensorsOrShriekers = 0;
        for (BlockPos checkPos : BlockPos.iterate(pos.add(-4, 0, -4), pos.add(4, 2, 4))) {
            BlockState checkState = world.getBlockState(checkPos);
            if (checkState.isOf(ModBlocks.BLOOD_SCULK_SENSOR) || checkState.isOf(ModBlocks.BLOOD_SCULK_SHRIEKER)) {
                nearbySensorsOrShriekers++;
            }
            if (nearbySensorsOrShriekers > 2) {
                return false;
            }
        }
        return true;
    }

    private static int getDecay(SculkSpreadManager spreadManager, BlockPos cursorPos, BlockPos catalystPos, int charge) {
        int maxDist = spreadManager.getMaxDistance();
        float distSq = MathHelper.square((float) Math.sqrt(cursorPos.getSquaredDistance(catalystPos)) - (float) maxDist);
        int rangeSq = MathHelper.square(24 - maxDist);
        float factor = Math.min(1.0f, distSq / (float) rangeSq);
        return Math.max(1, (int) ((float) charge * factor * 0.5f));
    }
}
