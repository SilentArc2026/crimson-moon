package name.crimsonmoon.mixin;

import name.crimsonmoon.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.HorseScreenHandler;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

    @Mixin(HorseScreenHandler.class)
    public abstract class HorseScreenHandlerMixin {
        @ModifyArg(
                method = "<init>",
                at = @At(
                        value = "INVOKE",
                        target = "Lnet/minecraft/screen/HorseScreenHandler;addSlot(Lnet/minecraft/screen/slot/Slot;)Lnet/minecraft/screen/slot/Slot;",
                        ordinal = 0
                )
        )
        private Slot allowCustomSaddleInHorseSlot(Slot originalSlot) {
            return new Slot(originalSlot.inventory, originalSlot.getIndex(), originalSlot.x, originalSlot.y) {
                @Override
                public boolean canInsert(ItemStack stack) {
                    return stack.isOf(Items.SADDLE) || stack.isOf(ModItems.ACIDIC_SADDLE);
                }

                @Override
                public boolean isEnabled() {
                    return originalSlot.isEnabled();
                }

                @Override
                public int getMaxItemCount() {
                    return 1;
                }
            };
        }
    }
