package name.crimsonmoon.world;

import name.crimsonmoon.CrimsonMoon;
import name.crimsonmoon.block.ModBlocks;
import name.crimsonmoon.world.feature.ModFeatures;
import name.crimsonmoon.world.tree.custom.PalmFoliagePlacer;
import net.minecraft.block.Blocks;
import net.minecraft.block.MushroomBlock;
import net.minecraft.client.gl.Uniform;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> CORRUPTED_KEY = registerKey("corrupted");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ACIDIC_KEY = registerKey("acidic");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CHARRED_KEY = registerKey("charred");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PALM_KEY = registerKey("palm");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WITHERED_KEY = registerKey("withered");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ACIDIC_MUSHROOM_KEY = registerKey("acidic_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CORRUPTED_MUSHROOM_KEY = registerKey("corrupted_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLACKENED_MUSHROOM_KEY = registerKey("blackened_mushroom");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, CORRUPTED_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.CORRUPTED_LOG),
                new CherryTrunkPlacer(5, 3, 3, UniformIntProvider.create(1, 2), UniformIntProvider.create(2, 3), UniformIntProvider.create(-1, 0), ConstantIntProvider.create(1)),
                BlockStateProvider.of(ModBlocks.CORRUPTED_LEAVES),
                new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5), 0.25f, 0.25f, 0.16666667f, 0.33333334f),
                new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, ACIDIC_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ACIDIC_LOG),
                new CherryTrunkPlacer(5, 3, 3, UniformIntProvider.create(1, 2), UniformIntProvider.create(2, 3), UniformIntProvider.create(-1, 0), ConstantIntProvider.create(1)),
                BlockStateProvider.of(ModBlocks.ACIDIC_LEAVES),
                new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5), 0.25f, 0.25f, 0.16666667f, 0.33333334f),
                new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, CHARRED_KEY, ModFeatures.CHARRED_HUGE_FUNGUS, new HugeFungusFeatureConfig(
                ModBlocks.CORRUPTED_GRASS_BLOCK.getDefaultState(),
                ModBlocks.CHARRED_LOG.getDefaultState(),
                ModBlocks.CHARRED_WART_BLOCK.getDefaultState(),
                ModBlocks.GLOOMLIGHT.getDefaultState(),
                BlockPredicate.matchingBlockTag(BlockTags.REPLACEABLE_BY_TREES), false));
        register(context, PALM_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PALM_LOG),
                new ForkingTrunkPlacer(5, 6, 3),
                BlockStateProvider.of(ModBlocks.PALM_LEAVES),
                new PalmFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, WITHERED_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.WITHERED_PALM_LOG),
                new ForkingTrunkPlacer(5, 6, 3),
                BlockStateProvider.of(ModBlocks.WITHERED_PALM_LEAVES),
                new PalmFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, CORRUPTED_MUSHROOM_KEY, Feature.HUGE_RED_MUSHROOM, new HugeMushroomFeatureConfig(
                BlockStateProvider.of(ModBlocks.CORRUPTED_MUSHROOM_BLOCK.getDefaultState().with(MushroomBlock.DOWN, false)),
                BlockStateProvider.of(ModBlocks.CORRUPTED_MUSHROOM_STEM.getDefaultState()),
                2
        ));
        register(context, ACIDIC_MUSHROOM_KEY, Feature.HUGE_BROWN_MUSHROOM, new HugeMushroomFeatureConfig(
                BlockStateProvider.of(ModBlocks.ACIDIC_MUSHROOM_BLOCK.getDefaultState().with(MushroomBlock.DOWN, false)),
                BlockStateProvider.of(ModBlocks.ACIDIC_MUSHROOM_STEM.getDefaultState()),
                3
        ));
        register(context, BLACKENED_MUSHROOM_KEY, Feature.HUGE_RED_MUSHROOM, new HugeMushroomFeatureConfig(
                BlockStateProvider.of(ModBlocks.BLACKENED_MUSHROOM_BLOCK.getDefaultState().with(MushroomBlock.DOWN, false)),
                BlockStateProvider.of(ModBlocks.CORRUPTED_MUSHROOM_STEM.getDefaultState()),
                2
        ));
    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(CrimsonMoon.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
