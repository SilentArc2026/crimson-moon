package name.crimsonmoon.mixin;

import name.crimsonmoon.block.ModBlocks;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AnimalEntity.class)
public abstract class BeeEntityMixin {

    @Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
    private void crimsonmoon$onFeedOpenEyeblossom(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        if ((Object) this instanceof BeeEntity bee) {
            ItemStack stack = player.getStackInHand(hand);

            if (stack.isOf(ModBlocks.CORRUPTED_OPEN_EYEBLOSSOM.asItem())) {
                if (!bee.getWorld().isClient) {
                    if (!player.getAbilities().creativeMode) {
                        stack.decrement(1);
                    }

                    bee.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 25));
                    bee.playSound(SoundEvents.ENTITY_GENERIC_EAT, 1.0F, 1.0F);
                }

                cir.setReturnValue(ActionResult.success(bee.getWorld().isClient));
            } else if (stack.isOf(ModBlocks.CORRUPTED_WITHER_ROSE.asItem())) {
                if (!bee.getWorld().isClient) {
                    if (!player.getAbilities().creativeMode) {
                        stack.decrement(1);
                    }

                    bee.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 10));
                    bee.playSound(SoundEvents.ENTITY_GENERIC_EAT, 1.0F, 1.0F);
                }
                cir.setReturnValue(ActionResult.success(bee.getWorld().isClient));

            }
        }
    }
}