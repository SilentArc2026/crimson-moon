package name.crimsonmoon.world;

import name.crimsonmoon.CrimsonMoon;
import name.crimsonmoon.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {


    public static final RegistryKey<PlacedFeature> CORRUPTED_PLACED_KEY = registerKey("corrupted_placed");
    public static final RegistryKey<PlacedFeature> ACIDIC_PLACED_KEY = registerKey("acidic_placed");
    public static final RegistryKey<PlacedFeature> CHARRED_PLACED_KEY = registerKey("charred_placed");
    public static final RegistryKey<PlacedFeature> PALM_PLACED_KEY = registerKey("palm_placed");
    public static final RegistryKey<PlacedFeature> WITHERED_PLACED_KEY = registerKey("withered_placed");
    public static final RegistryKey<PlacedFeature> ACIDIC_MUSHROOM_PLACED_KEY = registerKey("acidic_mushroom_placed");
    public static final RegistryKey<PlacedFeature> BLACKENED_MUSHROOM_PLACED_KEY = registerKey("blackened_mushroom_placed");
    public static final RegistryKey<PlacedFeature> CORRUPTED_MUSHROOM_PLACED_KEY = registerKey("corrupted_mushroom_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, CORRUPTED_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CORRUPTED_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.CORRUPTED_SAPLING));
        register(context, ACIDIC_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ACIDIC_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                    PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.ACIDIC_SAPLING));
        register(context, CHARRED_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHARRED_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                    PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.CHARRED_FUNGUS));
        register(context, PALM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PALM_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                    PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.PALM_SAPLING));
        register(context, WITHERED_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WITHERED_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                    PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.WITHERED_PALM_SAPLING));
        register(context, ACIDIC_MUSHROOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ACIDIC_MUSHROOM_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                    PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.ACIDIC_MUSHROOM));
        register(context, CORRUPTED_MUSHROOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CORRUPTED_MUSHROOM_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                    PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.CORRUPTED_MUSHROOM));
        register(context, BLACKENED_MUSHROOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLACKENED_MUSHROOM_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                    PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.BLACKENED_MUSHROOM));
    }


    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(CrimsonMoon.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
