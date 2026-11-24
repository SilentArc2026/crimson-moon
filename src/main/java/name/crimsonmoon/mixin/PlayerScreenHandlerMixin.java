package name.crimsonmoon.mixin;

import name.crimsonmoon.item.custom.BracerItem;
import name.crimsonmoon.screen.BracerSlot;
import name.crimsonmoon.util.BracerHolder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerScreenHandler.class)
public abstract class PlayerScreenHandlerMixin extends AbstractRecipeScreenHandler<CraftingInventory> {

    @Unique
    private static final int BRACER_SLOT_INDEX = 46;

    public PlayerScreenHandlerMixin(ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void addBracerSlot(PlayerInventory inventory, boolean onServer, PlayerEntity owner, CallbackInfo ci) {
        this.addSlot(new BracerSlot(((BracerHolder) owner).crimson_moon$getBracerInventory(), 0, 77, 44));
    }

    @Inject(method = "quickMove", at = @At("HEAD"), cancellable = true)
    private void quickMoveBracer(PlayerEntity player, int slotIndex, CallbackInfoReturnable<ItemStack> cir) {
        Slot slot = this.slots.get(slotIndex);
        if (slot != null && slot.hasStack()) {
            ItemStack stack = slot.getStack();
            ItemStack originalStack = stack.copy();

            // Shift-clicking OUT of the bracer slot -> move to player inventory (9..45)
            if (slotIndex == BRACER_SLOT_INDEX) {
                if (!this.insertItem(stack, 9, 45, false)) {
                    cir.setReturnValue(ItemStack.EMPTY);
                    return;
                }
                slot.onQuickTransfer(stack, originalStack);
                slot.markDirty();
                cir.setReturnValue(originalStack);
                return;
            }

            // Shift-clicking a BracerItem IN inventory -> move into the bracer slot
            if (stack.getItem() instanceof BracerItem && !this.slots.get(BRACER_SLOT_INDEX).hasStack()) {
                if (this.insertItem(stack, BRACER_SLOT_INDEX, BRACER_SLOT_INDEX + 1, false)) {
                    slot.markDirty();
                    cir.setReturnValue(originalStack);
                    return;
                }
            }
        }
    }
}

