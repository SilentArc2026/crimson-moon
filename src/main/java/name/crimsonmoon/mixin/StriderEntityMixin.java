package name.crimsonmoon.mixin;

import name.crimsonmoon.item.ModItems;
import name.crimsonmoon.item.custom.CustomSaddleHolder;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.StriderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StriderEntity.class)
public abstract class StriderEntityMixin extends AnimalEntity implements CustomSaddleHolder {
    @Unique
    private static final TrackedData<Boolean> HAS_ACIDIC_SADDLE = DataTracker.registerData(StriderEntityMixin.class, TrackedDataHandlerRegistry.BOOLEAN);

    protected StriderEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean crimson_moon$hasAcidicSaddle() {
        return this.dataTracker.get(HAS_ACIDIC_SADDLE);
    }

    @Override
    public void crimson_moon$setAcidicSaddle(boolean value) {
        this.dataTracker.set(HAS_ACIDIC_SADDLE, value);
    }

    @Inject(method = "initDataTracker", at = @At("TAIL"))
    private void initAcidicSaddleTracker(CallbackInfo ci) {
        this.dataTracker.startTracking(HAS_ACIDIC_SADDLE, false);
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    private void writeAcidicSaddleNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putBoolean("HasAcidicSaddle", this.crimson_moon$hasAcidicSaddle());
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    private void readAcidicSaddleNbt(NbtCompound nbt, CallbackInfo ci) {
        this.crimson_moon$setAcidicSaddle(nbt.getBoolean("HasAcidicSaddle"));
    }

    // Allow right-clicking a strider with ACIDIC_SADDLE
    @Redirect(
            method = "interactMob",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
            )
    )
    private boolean allowCustomSaddleOnStrider(ItemStack itemStack, Item item) {
        return itemStack.isOf(item) || itemStack.isOf(ModItems.ACIDIC_SADDLE);
    }

    // Track when ACIDIC_SADDLE is equipped
    @Inject(method = "interactMob", at = @At("HEAD"))
    private void onEquipAcidicSaddle(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        ItemStack stack = player.getStackInHand(hand);
        if (stack.isOf(ModItems.ACIDIC_SADDLE) && !((StriderEntity) (Object) this).isSaddled() && this.isAlive() && !this.isBaby()) {
            this.crimson_moon$setAcidicSaddle(true);
        }
    }
    @Shadow
    public abstract boolean isSaddled();

    // Drop ACIDIC_SADDLE on death instead of vanilla saddle
    @Redirect(
            method = "dropInventory",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/passive/StriderEntity;dropItem(Lnet/minecraft/item/ItemConvertible;)Lnet/minecraft/entity/ItemEntity;"
            )
    )
    private ItemEntity dropCustomSaddle(StriderEntity strider, ItemConvertible item) {
        if (this.crimson_moon$hasAcidicSaddle()) {
            return strider.dropItem(ModItems.ACIDIC_SADDLE);
        }
        return strider.dropItem(item);
    }
}
