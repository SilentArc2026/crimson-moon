package name.crimsonmoon.mixin;

import name.crimsonmoon.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashSet;
import java.util.Set;

@Mixin(BlockEntityType.class)
public class BlockEntityTypeMixin {

    @Inject(method = "supports", at = @At("HEAD"), cancellable = true)
    private void supportBloodSculkBlocks(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (BlockEntityType.SCULK_CATALYST.equals(this) && state.isOf(ModBlocks.BLOOD_SCULK_CATALYST)) {
            cir.setReturnValue(true);
        } else if (BlockEntityType.SCULK_SENSOR.equals(this) && state.isOf(ModBlocks.BLOOD_SCULK_SENSOR)) {
            cir.setReturnValue(true);
        } else if (BlockEntityType.SCULK_SHRIEKER.equals(this) && state.isOf(ModBlocks.BLOOD_SCULK_SHRIEKER)) {
            cir.setReturnValue(true);
        }
    }
}