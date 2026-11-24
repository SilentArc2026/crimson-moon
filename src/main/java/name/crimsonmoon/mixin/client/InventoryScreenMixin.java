package name.crimsonmoon.mixin.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryScreen.class)
public abstract class InventoryScreenMixin extends AbstractInventoryScreen<PlayerScreenHandler> {

    private static final Identifier VANILLA_INVENTORY =
            new Identifier("minecraft", "textures/gui/container/inventory.png");
    private static final Identifier BRACER_ICON =
            new Identifier("crimson-moon", "textures/gui/empty_armor_slot_bracers.png");

    private static final int BRACER_SLOT_INDEX = 46;
    private static final int SLOT_X = 77;
    private static final int SLOT_Y = 44;

    public InventoryScreenMixin(PlayerScreenHandler screenHandler, PlayerInventory playerInventory, Text text) {
        super(screenHandler, playerInventory, text);
    }

    @Inject(method = "drawBackground", at = @At("TAIL"))
    private void drawBracerSlot(DrawContext context, float delta, int mouseX, int mouseY, CallbackInfo ci) {
        int x = this.x + SLOT_X;
        int y = this.y + SLOT_Y;

        // 1. Copy the 18x18 beveled slot frame from vanilla inventory.png (UV 7, 83)
        context.drawTexture(VANILLA_INVENTORY, x - 1, y - 1, 7, 83, 18, 18);

        // 2. Draw the 16x16 empty-slot silhouette when no bracer is equipped
        if (!this.handler.getSlot(BRACER_SLOT_INDEX).hasStack()) {
            context.drawTexture(BRACER_ICON, x, y, 0, 0, 16, 16, 16, 16);
        }
    }
}
