package name.crimsonmoon.mixin;

import name.crimsonmoon.util.ModWoodTypes;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.client.gui.screen.ingame.AbstractSignEditScreen;
import net.minecraft.client.gui.screen.ingame.HangingSignEditScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;


@Mixin(HangingSignEditScreen.class)
public abstract class HangingSignEditScreenMixin extends AbstractSignEditScreen {

    protected HangingSignEditScreenMixin(SignBlockEntity blockEntity, boolean front, boolean filtered) {
        super(blockEntity, front, filtered);
    }

    @ModifyArg(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/Identifier;<init>(Ljava/lang/String;)V"
            )
    )
    private String fixCustomHangingSignGuiTexture(String originalPath) {
        if (this.signType == ModWoodTypes.CORRUPTED ||
                this.signType == ModWoodTypes.ACIDIC ||
                this.signType == ModWoodTypes.CHARRED) {

            String woodName = this.signType.name().contains(":")
                    ? this.signType.name().split(":")[1]
                    : this.signType.name();

            return "crimson-moon:textures/gui/hanging_signs/" + woodName + ".png";
        }
        return originalPath;
    }
}