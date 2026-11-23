package name.crimsonmoon.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import name.crimsonmoon.item.ModItems;
import name.crimsonmoon.item.custom.CustomSaddleHolder;
import net.minecraft.client.render.entity.feature.SaddleFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.Saddleable;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.StriderEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(SaddleFeatureRenderer.class)
public abstract class SaddleFeatureRendererMixin<T extends Entity & Saddleable, M extends EntityModel<T>> {
    @Unique
    private static final Identifier ACIDIC_PIG_SADDLE = new Identifier("crimson-moon", "textures/entity/pig/acidic_pig_saddle.png");
    @Unique
    private static final Identifier ACIDIC_HORSE_SADDLE = new Identifier("crimson-moon", "textures/entity/horse/acidic_horse_saddle.png");
    @Unique
    private static final Identifier ACIDIC_STRIDER_SADDLE = new Identifier("crimson-moon", "textures/entity/strider/acidic_strider_saddle.png");

    @ModifyArg(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/RenderLayer;getEntityCutoutNoCull(Lnet/minecraft/util/Identifier;)Lnet/minecraft/client/render/RenderLayer;"
            )
    )
    private Identifier swapAcidicSaddleTexture(Identifier originalTexture, @Local(argsOnly = true) T entity) {
        if (entity instanceof CustomSaddleHolder holder && holder.crimson_moon$hasAcidicSaddle()) {
            if (entity instanceof PigEntity) {
                return ACIDIC_PIG_SADDLE;
            }
            if (entity instanceof StriderEntity) {
                return ACIDIC_STRIDER_SADDLE;
            }
        }
        if (entity instanceof AbstractHorseEntity horse
                && ((AbstractHorseEntityAccessor) horse).getItems().getStack(0).isOf(ModItems.ACIDIC_SADDLE)) {
            return ACIDIC_HORSE_SADDLE;
        }
        return originalTexture;
    }
}