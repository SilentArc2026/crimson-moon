package name.crimsonmoon.mixin;

import name.crimsonmoon.item.custom.BracerItem;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.enchantment.EnchantmentTarget$2")
public class ArmorEnchantmentTargetMixin {
    @Inject(method = "isAcceptableItem", at = @At("HEAD"), cancellable = true)
    private void allowBracers(Item item, CallbackInfoReturnable<Boolean> cir) {
        if (item instanceof BracerItem) {
            cir.setReturnValue(true);
        }
    }
}

