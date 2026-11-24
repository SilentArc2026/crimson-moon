package name.crimsonmoon.mixin.client;

import name.crimsonmoon.screen.BracerSlot;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreativeInventoryScreen.class)
public abstract class CreativeInventoryScreenMixin extends AbstractInventoryScreen<CreativeInventoryScreen.CreativeScreenHandler> {
    @Shadow
    private static ItemGroup selectedTab;

    @Unique
    private static final int CREATIVE_BRACER_X = 127;
    @Unique
    private static final int CREATIVE_BRACER_Y = 20;

    @Unique
    private static final Identifier SLOT_TEXTURE = new Identifier("textures/gui/container/inventory.png");

    public CreativeInventoryScreenMixin(CreativeInventoryScreen.CreativeScreenHandler screenHandler, PlayerInventory playerInventory, Text text) {
        super(screenHandler, playerInventory, text);
    }

    @Inject(method = "setSelectedTab", at = @At("TAIL"))
    private void moveBracerSlotInCreativeSurvivalTab(ItemGroup group, CallbackInfo ci) {
        if (group.getType() == ItemGroup.Type.INVENTORY) {
            for (Slot slot : this.handler.slots) {
                if (slot instanceof CreativeInventoryScreen.CreativeSlot creativeSlot
                        && creativeSlot.slot instanceof BracerSlot) {
                    creativeSlot.x = CREATIVE_BRACER_X;
                    creativeSlot.y = CREATIVE_BRACER_Y;
                    break;
                }
            }
        }
    }

    @Inject(method = "drawBackground", at = @At("TAIL"))
    private void drawCreativeBracerSlotBox(DrawContext context, float delta, int mouseX, int mouseY, CallbackInfo ci) {
        if (selectedTab != null && selectedTab.getType() == ItemGroup.Type.INVENTORY) {
            context.drawTexture(
                    SLOT_TEXTURE,
                    this.x + CREATIVE_BRACER_X - 1,
                    this.y + CREATIVE_BRACER_Y - 1,
                    7,
                    83,
                    18,
                    18
            );
        }
    }
}

