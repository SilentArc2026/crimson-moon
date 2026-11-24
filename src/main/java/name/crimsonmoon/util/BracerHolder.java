package name.crimsonmoon.util;

import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;

public interface BracerHolder {
    SimpleInventory crimson_moon$getBracerInventory();

    default ItemStack crimson_moon$getEquippedBracer() {
        return this.crimson_moon$getBracerInventory().getStack(0);
    }

    default void crimson_moon$setEquippedBracer(ItemStack stack) {
        this.crimson_moon$getBracerInventory().setStack(0, stack);
    }
}