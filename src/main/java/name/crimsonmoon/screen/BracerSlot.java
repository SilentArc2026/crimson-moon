package name.crimsonmoon.screen;

import com.mojang.datafixers.util.Pair;
import name.crimsonmoon.item.custom.BracerItem;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class BracerSlot extends Slot {
    private static final Identifier EMPTY_BRACER_SLOT_TEXTURE =
            new Identifier("crimson-moon", "item/empty_armor_slot_bracers");

    public BracerSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Nullable
    @Override
    public Pair<Identifier, Identifier> getBackgroundSprite() {
        return Pair.of(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE, EMPTY_BRACER_SLOT_TEXTURE);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.getItem() instanceof BracerItem;
    }

    @Override
    public int getMaxItemCount() {
        return 1;
    }

    @Override
    public boolean canTakeItems(PlayerEntity playerEntity) {
        ItemStack stack = this.getStack();
        if (!stack.isEmpty() && !playerEntity.isCreative() && EnchantmentHelper.hasBindingCurse(stack)) {
            return false;
        }
        return super.canTakeItems(playerEntity);
    }
}
