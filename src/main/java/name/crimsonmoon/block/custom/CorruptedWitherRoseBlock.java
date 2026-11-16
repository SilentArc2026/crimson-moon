package name.crimsonmoon.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.WitherRoseBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class CorruptedWitherRoseBlock extends WitherRoseBlock {
    private final StatusEffect customEffect;
    private final int duration;
    private final int amplifier;

    public CorruptedWitherRoseBlock(StatusEffect suspiciousStewEffect,
                                    StatusEffect customEffect, int duration, int amplifier, Settings settings) {
        // WitherRoseBlock only takes (StatusEffect, Settings)
        super(suspiciousStewEffect, settings);
        this.customEffect = customEffect;
        this.duration = duration;
        this.amplifier = amplifier;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && world.getDifficulty() != Difficulty.PEACEFUL) {
            if (entity instanceof LivingEntity livingEntity) {
                if (!livingEntity.isInvulnerableTo(world.getDamageSources().wither())) {
                    livingEntity.addStatusEffect(
                            new StatusEffectInstance(customEffect, duration, amplifier)
                    );
                }
            }
        }
    }
}