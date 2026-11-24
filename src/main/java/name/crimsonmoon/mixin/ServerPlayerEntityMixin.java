package name.crimsonmoon.mixin;

import name.crimsonmoon.util.BracerHolder;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin {
    @Inject(method = "copyFrom", at = @At("TAIL"))
    private void copyBracerOnRespawn(ServerPlayerEntity oldPlayer, boolean alive, CallbackInfo ci) {
        ItemStack oldBracer = ((BracerHolder) oldPlayer).crimson_moon$getBracerInventory().getStack(0);
        ((BracerHolder) this).crimson_moon$getBracerInventory().setStack(0, oldBracer.copy());
    }
}