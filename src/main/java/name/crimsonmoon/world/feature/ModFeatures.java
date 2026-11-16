package name.crimsonmoon.world.feature;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeFungusFeatureConfig;

public class ModFeatures {
    public static final Feature<HugeFungusFeatureConfig> CHARRED_HUGE_FUNGUS = Registry.register(
            Registries.FEATURE,
            new Identifier("your_mod_id", "charred_huge_fungus"),
            new CharredHugeFungusFeature(HugeFungusFeatureConfig.CODEC)
    );

    public static void registerModFeatures() {
    }
}