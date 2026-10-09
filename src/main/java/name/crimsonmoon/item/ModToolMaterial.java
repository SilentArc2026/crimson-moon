package name.crimsonmoon.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    CRIMSON(5, 2600, 11.0F, 5.0F, 28, () -> Ingredient.ofItems(ModItems.Crimsonite_Ingot)),
    SOLARIUM(6, 3800, 13.0F, 6.0F, 40, () -> Ingredient.ofItems(ModItems.SOLARIUM_INGOT)),
    HEAVENLY(7, 4000, 14.0F, 7.0F, 50, () -> Ingredient.ofItems(ModItems.SOLAR_STAR)),
    VAMPYRITE(3, 2000, 9.0F, 4.0F, 20, () -> Ingredient.ofItems(ModItems.VAMPYRITE_INGOT)),
    TURQITE(4, 2200, 10.0F, 5.0F, 25, () -> Ingredient.ofItems(ModItems.REFINED_TURQITE));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<>(repairIngredient);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
