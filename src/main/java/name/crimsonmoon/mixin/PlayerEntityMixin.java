package name.crimsonmoon.mixin;

import name.crimsonmoon.item.custom.BracerItem;
import name.crimsonmoon.util.BracerHolder;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.util.Collections;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity implements BracerHolder {

    @Unique
    private static final TrackedData<ItemStack> SYNCED_BRACER =
            DataTracker.registerData(PlayerEntity.class, TrackedDataHandlerRegistry.ITEM_STACK);

    @Unique
    private ItemStack lastEquippedBracer = ItemStack.EMPTY;

    @Unique
    private final SimpleInventory crimson_moon$bracerInventory = new SimpleInventory(1) {
        @Override
        public int getMaxCountPerStack() {
            return 1;
        }

        @Override
        public void markDirty() {
            super.markDirty();
            if (!getWorld().isClient) {
                dataTracker.set(SYNCED_BRACER, this.getStack(0).copy());
            }
        }
    };

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "initDataTracker", at = @At("TAIL"))
    private void initBracerTracker(CallbackInfo ci) {
        this.dataTracker.startTracking(SYNCED_BRACER, ItemStack.EMPTY);
    }

    @Override
    public SimpleInventory crimson_moon$getBracerInventory() {
        // Only copy TrackedData for OTHER players in multiplayer; never overwrite your own local slot!
        if (this.getWorld().isClient && !((PlayerEntity) (Object) this).isMainPlayer()) {
            this.crimson_moon$bracerInventory.setStack(0, this.dataTracker.get(SYNCED_BRACER));
        }
        return this.crimson_moon$bracerInventory;
    }


    @Inject(method = "tick", at = @At("TAIL"))
    private void updateBracerAttributes(CallbackInfo ci) {
        if (!this.getWorld().isClient) {
            ItemStack current = this.crimson_moon$bracerInventory.getStack(0);
            if (!ItemStack.areEqual(current, this.lastEquippedBracer)) {
                if (this.lastEquippedBracer.getItem() instanceof BracerItem oldBracer) {
                    this.getAttributes().removeModifiers(oldBracer.getAttributeModifiers());
                }
                if (current.getItem() instanceof BracerItem newBracer) {
                    this.getAttributes().addTemporaryModifiers(newBracer.getAttributeModifiers());
                }
                this.lastEquippedBracer = current.copy();
                this.dataTracker.set(SYNCED_BRACER, current.copy());
            }
        }
    }

    @Inject(method = "dropInventory", at = @At("TAIL"))
    private void dropBracerOnDeath(CallbackInfo ci) {
        if (!this.getWorld().getGameRules().getBoolean(GameRules.KEEP_INVENTORY)) {
            ItemStack stack = this.crimson_moon$bracerInventory.getStack(0);
            if (!stack.isEmpty()) {
                if (!EnchantmentHelper.hasVanishingCurse(stack)) {
                    ((PlayerEntity) (Object) this).dropItem(stack, true, false);
                }
                this.crimson_moon$bracerInventory.setStack(0, ItemStack.EMPTY);
            }
        }
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    private void writeBracerNbt(NbtCompound nbt, CallbackInfo ci) {
        ItemStack stack = this.crimson_moon$bracerInventory.getStack(0);
        if (!stack.isEmpty()) {
            nbt.put("CrimsonMoonBracer", stack.writeNbt(new NbtCompound()));
        }
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    private void readBracerNbt(NbtCompound nbt, CallbackInfo ci) {
        if (nbt.contains("CrimsonMoonBracer", NbtElement.COMPOUND_TYPE)) {
            ItemStack loaded = ItemStack.fromNbt(nbt.getCompound("CrimsonMoonBracer"));
            this.crimson_moon$bracerInventory.setStack(0, loaded);
            if (!this.getWorld().isClient) {
                this.dataTracker.set(SYNCED_BRACER, loaded.copy());
            }
        } else {
            this.crimson_moon$bracerInventory.setStack(0, ItemStack.EMPTY);
        }
    }

    @Inject(method = "damageArmor", at = @At("TAIL"))
    private void damageBracerOnHit(DamageSource source, float amount, CallbackInfo ci) {
        ItemStack stack = this.crimson_moon$bracerInventory.getStack(0);
        if (!stack.isEmpty() && stack.getItem() instanceof BracerItem) {
            int damage = (int) Math.max(1.0F, amount / 4.0F);
            stack.damage(damage, (PlayerEntity) (Object) this, p -> {});
        }
    }

    // 2. Guarantee +2 Melee Attack Damage on every melee swing
    @ModifyVariable(method = "attack", at = @At(value = "STORE", ordinal = 0), ordinal = 0)
    private float addBracerMeleeDamage(float baseDamage) {
        ItemStack stack = this.crimson_moon$bracerInventory.getStack(0);
        if (!stack.isEmpty() && stack.getItem() instanceof BracerItem) {
            return baseDamage + 2.0F;
        }
        return baseDamage;
    }

    @Override
    protected float modifyAppliedDamage(DamageSource source, float amount) {
        float modified = super.modifyAppliedDamage(source, amount);
        ItemStack bracer = this.crimson_moon$bracerInventory.getStack(0);
        if (!bracer.isEmpty() && !source.isIn(net.minecraft.registry.tag.DamageTypeTags.BYPASSES_ENCHANTMENTS)) {
            int protLevel = EnchantmentHelper.getProtectionAmount(Collections.singletonList(bracer), source);
            if (protLevel > 0) {
                modified = net.minecraft.entity.DamageUtil.getInflictedDamage(modified, (float) protLevel);
            }
        }
        return modified;
    }

    @Inject(method = "damage", at = @At("RETURN"))
    private void triggerBracerThorns(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue() && !this.getWorld().isClient) {
            ItemStack bracer = this.crimson_moon$bracerInventory.getStack(0);
            int thornsLevel = EnchantmentHelper.getLevel(Enchantments.THORNS, bracer);
            Entity attacker = source.getAttacker();
            if (thornsLevel > 0 && attacker != null && net.minecraft.enchantment.ThornsEnchantment.shouldDamageAttacker(thornsLevel, this.random)) {
                attacker.damage(this.getDamageSources().thorns(this), (float) net.minecraft.enchantment.ThornsEnchantment.getDamageAmount(thornsLevel, this.random));
                bracer.damage(2, (PlayerEntity) (Object) this, p -> {});
            }
        }
    }

    @Inject(method = "addExperience", at = @At("HEAD"), cancellable = true)
    private void mendEquippedBracer(int experience, CallbackInfo ci) {
        ItemStack bracer = this.crimson_moon$bracerInventory.getStack(0);
        if (!bracer.isEmpty() && bracer.isDamaged() && EnchantmentHelper.getLevel(Enchantments.MENDING, bracer) > 0 && experience > 0) {
            int repairAmount = Math.min(experience * 2, bracer.getDamage());
            bracer.setDamage(bracer.getDamage() - repairAmount);
            int leftoverXp = experience - (repairAmount / 2);
            if (leftoverXp <= 0) {
                ci.cancel();
            }
        }
    }

}
