package name.crimsonmoon.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import name.crimsonmoon.util.BracerHolder;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class BracerItem extends Item {
    private static final UUID BRACER_ARMOR_UUID = UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B");
    private static final UUID BRACER_TOUGHNESS_UUID = UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D");
    private static final UUID BRACER_KNOCKBACK_UUID = UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E");

    private final ArmorMaterial material;
    private final int protection;
    private final float toughness;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public BracerItem(ArmorMaterial material, int protection, float toughness, Settings settings) {
        super(settings.maxDamage(material.getDurability(ArmorItem.Type.CHESTPLATE)));
        this.material = material;
        this.protection = protection;
        this.toughness = toughness;

        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(
                BRACER_ARMOR_UUID, "Bracer armor", this.protection, EntityAttributeModifier.Operation.ADDITION));
        if (this.toughness > 0) {
            builder.put(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier(
                    BRACER_TOUGHNESS_UUID, "Bracer toughness", this.toughness, EntityAttributeModifier.Operation.ADDITION));
        }
        if (material.getKnockbackResistance() > 0) {
            builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(
                    BRACER_KNOCKBACK_UUID, "Bracer knockback resistance", material.getKnockbackResistance(), EntityAttributeModifier.Operation.ADDITION));
        }
        this.attributeModifiers = builder.build();
    }

    // --- Enchantability & Anvil Repair ---
    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantability() {
        return this.material.getEnchantability();
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return this.material.getRepairIngredient().test(ingredient) || super.canRepair(stack, ingredient);
    }

    // --- Right-Click Equip ---
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack handStack = user.getStackInHand(hand);
        BracerHolder holder = (BracerHolder) user;
        ItemStack equippedStack = holder.crimson_moon$getEquippedBracer();

        if (!world.isClient) {
            holder.crimson_moon$setEquippedBracer(handStack.copy());
            user.setStackInHand(hand, equippedStack.isEmpty() ? ItemStack.EMPTY : equippedStack);
        }
        user.playSound(this.material.getEquipSound(), 1.0F, 1.0F);
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        return TypedActionResult.success(user.getStackInHand(hand), world.isClient());
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.modifiers.chest").formatted(Formatting.GRAY));
        tooltip.add(Text.literal(" +" + this.protection + " Armor").formatted(Formatting.BLUE));
        tooltip.add(Text.literal(" +2 Attack Damage").formatted(Formatting.BLUE));
        if (this.toughness > 0) {
            tooltip.add(Text.literal(" +" + (int) this.toughness + " Armor Toughness").formatted(Formatting.BLUE));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }

    public ArmorMaterial getMaterial() { return this.material; }
    public int getProtection() { return this.protection; }
    public float getToughness() { return this.toughness; }
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers() { return this.attributeModifiers; }
}

