package name.crimsonmoon.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent RAW_ACIDIC_BEEF = new FoodComponent.Builder().meat().hunger(3).saturationModifier(1.8f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 600, 0), .1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0), 1).build();
}
