package name.crimsonmoon.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.function.Supplier;

public class ModEyeBlossomBlock extends FlowerBlock {
    private final boolean open;
    private final Supplier<Block> oppositeStateBlock;

    public ModEyeBlossomBlock(boolean open, Supplier<Block> oppositeStateBlock, StatusEffect stewEffect, int stewDurationSeconds, Settings settings) {
        super(stewEffect, stewDurationSeconds, settings);
        this.open = open;
        this.oppositeStateBlock = oppositeStateBlock;
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (tryChangeState(state, world, pos, random)) {
            // Play long sound for the "initiator" flower that starts the wave
            SoundEvent sound = this.open ? SoundEvents.BLOCK_FLOWERING_AZALEA_PLACE : SoundEvents.BLOCK_FLOWERING_AZALEA_BREAK; // Replace with custom SoundEvents
            world.playSound(null, pos, sound, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (tryChangeState(state, world, pos, random)) {
            // Play shorter sound for flowers triggered by the chain reaction
            SoundEvent sound = this.open ? SoundEvents.BLOCK_GRASS_PLACE : SoundEvents.BLOCK_GRASS_BREAK; // Replace with custom SoundEvents
            world.playSound(null, pos, sound, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
    }

    private boolean tryChangeState(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        // Eyeblossoms never change state in dimensions without a standard daylight cycle (Nether/End)
        if (!world.getDimension().natural()) {
            return false;
        }

        // Vanilla checks if it is currently night (approx. 13000 to 23000 ticks)
        long timeOfDay = world.getTimeOfDay() % 24000L;
        boolean shouldBeOpen = timeOfDay >= 13000L && timeOfDay < 23000L;

        if (this.open == shouldBeOpen) {
            return false;
        }

        // Swap to the opposite block (triggers Observers and Sculk Sensors automatically)
        Block nextBlock = this.oppositeStateBlock.get();
        world.setBlockState(pos, nextBlock.getDefaultState(), Block.NOTIFY_ALL);
        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(state));

        // Spawn burst of particles on transition
        Vec3d center = Vec3d.ofCenter(pos);
        world.spawnParticles(this.open ? ParticleTypes.SMOKE : ParticleTypes.FLAME, center.x, center.y, center.z, 8, 0.2, 0.2, 0.2, 0.02);

        // Chain-reaction: notify other eyeblossoms in a 7x5x7 box (3 horizontal, 2 vertical)
        BlockPos.iterate(pos.add(-3, -2, -3), pos.add(3, 2, 3)).forEach(targetPos -> {
            if (!targetPos.equals(pos)) {
                BlockState targetState = world.getBlockState(targetPos);
                if (targetState.getBlock() instanceof ModEyeBlossomBlock targetFlower && targetFlower.open != shouldBeOpen) {
                    // Schedule a delayed tick (2 to 10 ticks) to create a wave effect
                    world.scheduleBlockTick(targetPos, targetFlower, 2 + random.nextInt(9));
                }
            }
        });

        return true;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        // Poison bees when touching an open eyeblossom on non-Peaceful difficulties
        if (!world.isClient && this.open && world.getDifficulty() != Difficulty.PEACEFUL) {
            if (entity instanceof BeeEntity bee && !bee.hasStatusEffect(StatusEffects.POISON)) {
                bee.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 25)); // 1.25 seconds (25 ticks)
            }
        }
        super.onEntityCollision(state, world, pos, entity);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        // Ambient particles and sounds when open
        if (this.open && random.nextInt(15) == 0) {
            double x = pos.getX() + 0.5 + (random.nextDouble() - 0.5) * 0.4;
            double y = pos.getY() + 0.4 + random.nextDouble() * 0.3;
            double z = pos.getZ() + 0.5 + (random.nextDouble() - 0.5) * 0.4;
            world.addParticle(ParticleTypes.FLAME, x, y, z, 0.0, 0.01, 0.0);

            // Optional: Play eerie idle sound if resting on specific custom soil/moss
            if (random.nextInt(20) == 0) {
                world.playSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                        SoundEvents.BLOCK_SCULK_SENSOR_CLICKING, SoundCategory.BLOCKS, 0.3F, 0.6F, false);
            }
        }
    }
}