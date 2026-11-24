package name.crimsonmoon.block;

import name.crimsonmoon.CrimsonMoon;
import name.crimsonmoon.block.custom.*;
import name.crimsonmoon.util.ModWoodTypes;
import name.crimsonmoon.world.tree.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.PlaceableOnWaterItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.structure.StrongholdGenerator;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block CORRUPTED_REDSTONE_HEART = registerBlock("corrupted_redstone_heart",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK).luminance(state -> 5)));

    public static final Block Crimsonite_Block = registerBlock("crimsonite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)));
    public static final Block PALM_MOSAIC = registerBlock("palm_mosaic",
            new Block(FabricBlockSettings.copyOf(Blocks.BAMBOO_MOSAIC)));
    public static final Block WITHERED_PALM_MOSAIC = registerBlock("withered_palm_mosaic",
            new Block(FabricBlockSettings.copyOf(Blocks.BAMBOO_MOSAIC)));
    public static final Block PALM_MOSAIC_SLAB = registerBlock("palm_mosaic_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.BAMBOO_MOSAIC_SLAB)));
    public static final Block WITHERED_PALM_MOSAIC_SLAB = registerBlock("withered_palm_mosaic_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.BAMBOO_MOSAIC_SLAB)));
    public static final Block PALM_MOSAIC_STAIRS = registerBlock("palm_mosaic_stairs",
            new StairsBlock(ModBlocks.PALM_MOSAIC.getDefaultState(), FabricBlockSettings.copyOf(Blocks.BAMBOO_MOSAIC_STAIRS)));
    public static final Block WITHERED_PALM_MOSAIC_STAIRS = registerBlock("withered_palm_mosaic_stairs",
            new StairsBlock(ModBlocks.WITHERED_PALM_MOSAIC.getDefaultState(), FabricBlockSettings.copyOf(Blocks.BAMBOO_MOSAIC_STAIRS)));
    public static final Block Deepslate_Vampyrite_Ore = registerBlock("deepslate_vampyrite_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE)));
    public static final Block Raw_Vampyrite_Block = registerBlock("raw_vampyrite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final Block Solarium_Block = registerBlock("solarium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)));
    public static final Block Vampyrite_Block = registerBlock("vampyrite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK)));
    public static final Block Vampyrite_Ore = registerBlock("vampyrite_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block Budding_Crystalized_Turqite_Block = registerBlock("budding_crystalized_turqite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.BUDDING_AMETHYST)));
    public static final Block Crystalized_Turqite_Block = registerBlock("crystalized_turqite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
    public static final Block Refined_Turqite_Block = registerBlock("refined_turqite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
    public static final Block Smooth_Basalt_Turqite_Ore = registerBlock("smooth_basalt_turqite_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.SMOOTH_BASALT)));
    public static final Block Turqite_Bricks = registerBlock("turqite_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
    public static final Block Turqite_Crystal_Block = registerBlock("turqite_crystal_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
    public static final Block SMALL_TURQITE_BUD = registerBlock("small_turqite_bud",
            new AmethystClusterBlock(3, 4, FabricBlockSettings.copyOf(Blocks.SMALL_AMETHYST_BUD)));
    public static final Block MEDIUM_TURQITE_BUD = registerBlock("medium_turqite_bud",
            new AmethystClusterBlock(4, 3, FabricBlockSettings.copyOf(Blocks.MEDIUM_AMETHYST_BUD)));
    public static final Block LARGE_TURQITE_BUD = registerBlock("large_turqite_bud",
            new AmethystClusterBlock(5, 3, FabricBlockSettings.copyOf(Blocks.LARGE_AMETHYST_BUD)));
    public static final Block Turqite_Cluster = registerBlock("turqite_cluster",
            new AmethystClusterBlock(7, 3, FabricBlockSettings.copyOf(Blocks.AMETHYST_CLUSTER)));
    public static final Block CORRUPTED_LOG = registerBlock("corrupted_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block CORRUPTED_WOOD = registerBlock("corrupted_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block STRIPPED_CORRUPTED_LOG = registerBlock("stripped_corrupted_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block STRIPPED_CORRUPTED_WOOD = registerBlock("stripped_corrupted_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block CORRUPTED_PLANKS  = registerBlock("corrupted_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block CORRUPTED_LEAVES  = registerBlock("corrupted_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block WITHERED_PALM_LOG = registerBlock("withered_palm_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block WITHERED_PALM_WOOD = registerBlock("withered_palm_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block STRIPPED_WITHERED_PALM_LOG = registerBlock("stripped_withered_palm_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block STRIPPED_WITHERED_PALM_WOOD = registerBlock("stripped_withered_palm_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block WITHERED_PALM_PLANKS  = registerBlock("withered_palm_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block WITHERED_PALM_LEAVES  = registerBlock("withered_palm_leaves",
            new PalmLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block WITHERED_PALM_SAPLING = registerBlock("withered_palm_sapling",
            new SaplingBlock(new WitheredSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block CORRUPTED_SAPLING  = registerBlock("corrupted_sapling",
            new SaplingBlock(new CorruptedSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block CHARRED_FUNGUS  = registerBlock("charred_fungus",
            new SaplingBlock(new CharredSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.CRIMSON_FUNGUS)));
    public static final Block ACIDIC_MUSHROOM  = registerBlock("acidic_mushroom",
            new SaplingBlock(new AcidicMushroomSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.CRIMSON_FUNGUS)));
    public static final Block BLACKENED_MUSHROOM  = registerBlock("blackened_mushroom",
            new SaplingBlock(new BlackenedMushroomSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.CRIMSON_FUNGUS)));
    public static final Block CORRUPTED_MUSHROOM  = registerBlock("corrupted_mushroom",
            new SaplingBlock(new CorruptedMushroomSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.CRIMSON_FUNGUS)));
    public static final Block ACIDIC_LOG = registerBlock("acidic_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block ACIDIC_WOOD = registerBlock("acidic_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block STRIPPED_ACIDIC_LOG = registerBlock("stripped_acidic_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block STRIPPED_ACIDIC_WOOD = registerBlock("stripped_acidic_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block CHARRED_LOG = registerBlock("charred_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block CHARRED_WOOD = registerBlock("charred_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block STRIPPED_CHARRED_LOG = registerBlock("stripped_charred_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block STRIPPED_CHARRED_WOOD = registerBlock("stripped_charred_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block CHARRED_PLANKS = registerBlock("charred_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block PALM_LOG = registerBlock("palm_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block PALM_WOOD = registerBlock("palm_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block STRIPPED_PALM_LOG = registerBlock("stripped_palm_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block STRIPPED_PALM_WOOD = registerBlock("stripped_palm_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block PALM_PLANKS = registerBlock("palm_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block PALM_LEAVES = registerBlock("palm_leaves",
            new PalmLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block ACIDIC_PLANKS  = registerBlock("acidic_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block ACIDIC_LEAVES  = registerBlock("acidic_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block ACIDIC_SAPLING  = registerBlock("acidic_sapling",
            new SaplingBlock(new AcidicSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block PALM_SAPLING  = registerBlock("palm_sapling",
            new SaplingBlock(new PalmSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block DOLOMITE = registerBlock("dolomite",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block DOLOMITE_BRICKS = registerBlock("dolomite_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block POLISHED_DOLOMITE = registerBlock("polished_dolomite",
            new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE)));
    public static final Block CHARRED_WART_BLOCK = registerBlock("charred_wart_block",
            new Block(FabricBlockSettings.copyOf(Blocks.WARPED_WART_BLOCK)));
    public static final Block ACIDIC_MUSHROOM_BLOCK = registerBlock("acidic_mushroom_block",
            new MushroomBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block CORRUPTED_MUSHROOM_BLOCK = registerBlock("corrupted_mushroom_block",
            new MushroomBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block BLACKENED_MUSHROOM_BLOCK = registerBlock("blackened_mushroom_block",
            new MushroomBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block CORRUPTED_MUSHROOM_STEM = registerBlock("corrupted_mushroom_stem",
            new MushroomBlock(FabricBlockSettings.copyOf(Blocks.MUSHROOM_STEM)));
    public static final Block ACIDIC_MUSHROOM_STEM = registerBlock("acidic_mushroom_stem",
            new MushroomBlock(FabricBlockSettings.copyOf(Blocks.MUSHROOM_STEM)));
    public static final Block BLACK_SAND = registerBlock("black_sand",
            new CustomSandBlock(0x141414, FabricBlockSettings.copyOf(Blocks.SAND)));
    public static final Block WET_BLACK_SAND = registerBlock("wet_black_sand",
            new CustomSandBlock(0x141414, FabricBlockSettings.copyOf(Blocks.SAND)));
    public static final Block WET_RED_SAND = registerBlock("wet_red_sand",
            new CustomSandBlock(0xA95821, FabricBlockSettings.copyOf(Blocks.SAND)));
    public static final Block WET_SAND = registerBlock("wet_sand",
            new CustomSandBlock(0xD8C38A, FabricBlockSettings.copyOf(Blocks.SAND)));

    public static final Block BLACK_SANDSTONE = registerBlock("black_sandstone",
            new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE)));
    public static final Block CUT_BLACK_SANDSTONE = registerBlock("cut_black_sandstone",
            new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE)));
    public static final Block CHISELED_BLACK_SANDSTONE = registerBlock("chiseled_black_sandstone",
            new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE)));
    public static final Block SMOOTH_BLACK_SANDSTONE = registerBlock("smooth_black_sandstone",
            new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE)));
    public static final Block BLACK_SANDSTONE_STAIRS = registerBlock("black_sandstone_stairs",
            new StairsBlock(BLACK_SANDSTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.SANDSTONE)));
    public static final Block BLACK_SANDSTONE_SLAB = registerBlock("black_sandstone_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE)));
    public static final Block BLACK_SANDSTONE_WALL = registerBlock("black_sandstone_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE)));
    public static final Block CUT_BLACK_SANDSTONE_STAIRS = registerBlock("cut_black_sandstone_stairs",
            new StairsBlock(CUT_BLACK_SANDSTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.CUT_SANDSTONE)));
    public static final Block CUT_BLACK_SANDSTONE_SLAB = registerBlock("cut_black_sandstone_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.CUT_SANDSTONE_SLAB)));
    public static final Block SMOOTH_BLACK_SANDSTONE_STAIRS = registerBlock("smooth_black_sandstone_stairs",
            new StairsBlock(SMOOTH_BLACK_SANDSTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.SMOOTH_SANDSTONE_STAIRS)));
    public static final Block SMOOTH_BLACK_SANDSTONE_SLAB = registerBlock("smooth_black_sandstone_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_SANDSTONE_SLAB)));
    public static final Block REDSTONE_HEART = registerBlock("redstone_heart",
            new Block(FabricBlockSettings.copyOf(ModBlocks.CORRUPTED_REDSTONE_HEART).strength(-1.0f, 3600000.0f)));

    public static final Block BLOOD_SCULK = registerBlock("blood_sculk",
            new BloodSculkBlock(FabricBlockSettings.copyOf(Blocks.SCULK)));
    public static final Block BLOOD_SCULK_VEIN = registerBlock("blood_sculk_vein",
            new BloodSculkVeinBlock(FabricBlockSettings.copyOf(Blocks.SCULK_VEIN)));
    public static final Block BLOOD_SCULK_CATALYST = registerBlock("blood_sculk_catalyst",
            new BloodSculkCatalystBlock(FabricBlockSettings.copyOf(Blocks.SCULK_CATALYST)));
    public static final Block BLOOD_SCULK_SENSOR = registerBlock("blood_sculk_sensor",
            new SculkSensorBlock(FabricBlockSettings.copyOf(Blocks.SCULK_SENSOR)));
    public static final Block BLOOD_SCULK_SHRIEKER = registerBlock("blood_sculk_shrieker",
            new SculkShriekerBlock(FabricBlockSettings.copyOf(Blocks.SCULK_SHRIEKER)));

    public static final Block CHARRED_SIGN = registerBlockWithoutBlockItem("charred_sign",
            new ModStandingSignBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_SIGN), ModWoodTypes.CHARRED));
    public static final Block CHARRED_WALL_SIGN = registerBlockWithoutBlockItem("charred_wall_sign",
            new ModWallSignBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_WALL_SIGN), ModWoodTypes.CHARRED));
    public static final Block CHARRED_HANGING_SIGN = registerBlockWithoutBlockItem("charred_hanging_sign",
            new ModHangingSignBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_HANGING_SIGN), ModWoodTypes.CHARRED));
    public static final Block CHARRED_HANGING_WALL_SIGN = registerBlockWithoutBlockItem("charred_hanging_wall_sign",
            new ModWallHangingSignBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_WALL_HANGING_SIGN), ModWoodTypes.CHARRED));
    public static final Block WITHERED_PALM_SIGN = registerBlockWithoutBlockItem("withered_palm_sign",
            new ModStandingSignBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_SIGN), ModWoodTypes.WITHERED));
    public static final Block WITHERED_PALM_WALL_SIGN = registerBlockWithoutBlockItem("withered_palm_wall_sign",
            new ModWallSignBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_WALL_SIGN), ModWoodTypes.WITHERED));
    public static final Block WITHERED_PALM_HANGING_SIGN = registerBlockWithoutBlockItem("withered_palm_hanging_sign",
            new ModHangingSignBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_HANGING_SIGN), ModWoodTypes.WITHERED));
    public static final Block WITHERED_PALM_HANGING_WALL_SIGN = registerBlockWithoutBlockItem("withered_palm_hanging_wall_sign",
            new ModWallHangingSignBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_WALL_HANGING_SIGN), ModWoodTypes.WITHERED));
    public static final Block CORRUPTED_SIGN = registerBlockWithoutBlockItem("corrupted_sign",
            new ModStandingSignBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_SIGN), ModWoodTypes.CORRUPTED));
    public static final Block CORRUPTED_WALL_SIGN = registerBlockWithoutBlockItem("corrupted_wall_sign",
            new ModWallSignBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_WALL_SIGN), ModWoodTypes.CORRUPTED));
    public static final Block CORRUPTED_HANGING_SIGN = registerBlockWithoutBlockItem("corrupted_hanging_sign",
            new ModHangingSignBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_HANGING_SIGN), ModWoodTypes.CORRUPTED));
    public static final Block CORRUPTED_HANGING_WALL_SIGN = registerBlockWithoutBlockItem("corrupted_hanging_wall_sign",
            new ModWallHangingSignBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_WALL_HANGING_SIGN), ModWoodTypes.CORRUPTED));
    public static final Block ACIDIC_SIGN = registerBlockWithoutBlockItem("acidic_sign",
            new ModStandingSignBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_SIGN), ModWoodTypes.ACIDIC));
    public static final Block ACIDIC_WALL_SIGN = registerBlockWithoutBlockItem("acidic_wall_sign",
            new ModWallSignBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_WALL_SIGN), ModWoodTypes.ACIDIC));
    public static final Block ACIDIC_HANGING_SIGN = registerBlockWithoutBlockItem("acidic_hanging_sign",
            new ModHangingSignBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_HANGING_SIGN), ModWoodTypes.ACIDIC));
    public static final Block ACIDIC_HANGING_WALL_SIGN = registerBlockWithoutBlockItem("acidic_hanging_wall_sign",
            new ModWallHangingSignBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_WALL_HANGING_SIGN), ModWoodTypes.ACIDIC));
    public static final Block PALM_SIGN = registerBlockWithoutBlockItem("palm_sign",
            new ModStandingSignBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_SIGN), ModWoodTypes.PALM));
    public static final Block PALM_WALL_SIGN = registerBlockWithoutBlockItem("palm_wall_sign",
            new ModWallSignBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_WALL_SIGN), ModWoodTypes.PALM));
    public static final Block PALM_HANGING_SIGN = registerBlockWithoutBlockItem("palm_hanging_sign",
            new ModHangingSignBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_HANGING_SIGN), ModWoodTypes.PALM));
    public static final Block PALM_HANGING_WALL_SIGN = registerBlockWithoutBlockItem("palm_hanging_wall_sign",
            new ModWallHangingSignBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_WALL_HANGING_SIGN), ModWoodTypes.PALM));
    public static final Block CORRUPTED_MOSS_BLOCK = registerBlock("corrupted_moss_block",
            new MossBlock(FabricBlockSettings.copyOf(Blocks.MOSS_BLOCK)));
    public static final Block CRIMSON_CACTUS = registerBlock("crimson_cactus",
            new CrimsonCactusBlock(AbstractBlock.Settings.copy(Blocks.CACTUS)));
    public static final Block POTTED_CRIMSON_CACTUS = registerBlockWithoutBlockItem("potted_crimson_cactus",
            new FlowerPotBlock(CRIMSON_CACTUS, FabricBlockSettings.copyOf(Blocks.POTTED_CACTUS)));
    public static final Block DARKSTEEL_BLOCK = registerBlock("darksteel_block",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)));
    public static final Block DARKSTEEL_DOOR = registerBlock("darksteel_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK), BlockSetType.IRON));
    public static final Block DARKSTEEL_TRAPDOOR = registerBlock("darksteel_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_TRAPDOOR), BlockSetType.IRON));
    public static final Block DARKSTEEL_BARS = registerBlock("darksteel_bars",
            new ModPaneBlock(FabricBlockSettings.copyOf(Blocks.IRON_BARS)));

    public static final Block DARKSTEEL_LANTERN = registerBlock("darksteel_lantern",
            new LanternBlock(FabricBlockSettings.copyOf(Blocks.LANTERN)));

    public static final Block DARKSTEEL_CHAIN = registerBlock("darksteel_chain",
            new ChainBlock(FabricBlockSettings.copyOf(Blocks.CHAIN)));

    public static final Block DARKSTEEL_SOUL_LANTERN = registerBlock("darksteel_soul_lantern",
            new LanternBlock(FabricBlockSettings.copyOf(Blocks.SOUL_LANTERN)));

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(CrimsonMoon.MOD_ID, name), block);
    }

    public static final Block CORRUPTED_STAIRS = registerBlock("corrupted_stairs",
            new StairsBlock(ModBlocks.CORRUPTED_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block CORRUPTED_SLAB = registerBlock("corrupted_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block WITHERED_PALM_STAIRS = registerBlock("withered_palm_stairs",
            new StairsBlock(ModBlocks.WITHERED_PALM_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block WITHERED_PALM_SLAB = registerBlock("withered_palm_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block PALM_STAIRS = registerBlock("palm_stairs",
            new StairsBlock(ModBlocks.PALM_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block PALM_SLAB = registerBlock("palm_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block ACIDIC_STAIRS = registerBlock("acidic_stairs",
            new StairsBlock(ModBlocks.ACIDIC_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block ACIDIC_SLAB = registerBlock("acidic_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block CHARRED_STAIRS = registerBlock("charred_stairs",
            new StairsBlock(ModBlocks.ACIDIC_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block CHARRED_SLAB = registerBlock("charred_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block CORRUPTED_BUTTON = registerBlock("corrupted_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));
    public static final Block CORRUPTED_PRESSURE_PLATE = registerBlock("corrupted_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
    public static final Block ACIDIC_TRAPPED_RUG = registerBlock("acidic_trapped_rug",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.GREEN_CARPET), BlockSetType.OAK));
    public static final Block WITHERED_PALM_BUTTON = registerBlock("withered_palm_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));
    public static final Block WITHERED_PALM_PRESSURE_PLATE = registerBlock("withered_palm_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
    public static final Block PALM_BUTTON = registerBlock("palm_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));
    public static final Block PALM_PRESSURE_PLATE = registerBlock("palm_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
    public static final Block CHARRED_BUTTON = registerBlock("charred_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));
    public static final Block CHARRED_PRESSURE_PLATE = registerBlock("charred_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
    public static final Block ACIDIC_BUTTON = registerBlock("acidic_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));
    public static final Block ACIDIC_FENCE = registerBlock("acidic_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
    public static final Block ACIDIC_FENCE_GATE = registerBlock("acidic_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.OAK));
    public static final Block WITHERED_PALM_FENCE = registerBlock("withered_palm_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
    public static final Block WITHERED_PALM_FENCE_GATE = registerBlock("withered_palm_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.OAK));
    public static final Block CORRUPTED_FENCE = registerBlock("corrupted_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
    public static final Block CORRUPTED_FENCE_GATE = registerBlock("corrupted_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.OAK));
    public static final Block CHARRED_FENCE = registerBlock("charred_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
    public static final Block CHARRED_FENCE_GATE = registerBlock("charred_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.OAK));
    public static final Block PALM_FENCE = registerBlock("palm_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
    public static final Block PALM_FENCE_GATE = registerBlock("palm_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.OAK));
    public static final Block ACIDIC_PRESSURE_PLATE = registerBlock("acidic_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
    public static final Block CORRUPTED_DOOR = registerBlock("corrupted_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR), BlockSetType.OAK));
    public static final Block CORRUPTED_TRAPDOOR = registerBlock("corrupted_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    public static final Block WITHERED_PALM_DOOR = registerBlock("withered_palm_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR), BlockSetType.OAK));
    public static final Block WITHERED_PALM_TRAPDOOR = registerBlock("withered_palm_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    public static final Block PALM_DOOR = registerBlock("palm_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR), BlockSetType.OAK));
    public static final Block PALM_TRAPDOOR = registerBlock("palm_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    public static final Block ACIDIC_DOOR = registerBlock("acidic_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR), BlockSetType.OAK));
    public static final Block ACIDIC_TRAPDOOR = registerBlock("acidic_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    public static final Block CHARRED_DOOR = registerBlock("charred_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR), BlockSetType.OAK));
    public static final Block CHARRED_TRAPDOOR = registerBlock("charred_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    public static final Block CORRUPTED_GRASS_BLOCK = registerBlock("corrupted_grass_block",
            new CustomGrassBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.GRASS).strength(0.5f).ticksRandomly()));
    public static final Block CORRUPTED_DIRT = registerBlock("corrupted_dirt",
            new Block(FabricBlockSettings.copyOf(Blocks.DIRT)));
    public static final Block ACIDIC_GRASS_BLOCK = registerBlock("acidic_grass_block",
            new CustomGrassBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.GRASS).strength(0.5f).ticksRandomly()));
    public static final Block ACIDIC_DIRT = registerBlock("acidic_dirt",
            new Block(FabricBlockSettings.copyOf(Blocks.DIRT)));
    public static final Block ACIDIC_GRASS = registerBlock("acidic_grass",
            new PlantBlock(FabricBlockSettings.create().noCollision().replaceable().breakInstantly().sounds(BlockSoundGroup.GRASS)));
    public static final Block CORRUPTED_GRASS = registerBlock("corrupted_grass",
            new PlantBlock(FabricBlockSettings.create().noCollision().replaceable().breakInstantly().sounds(BlockSoundGroup.GRASS)));
    public static final Block ACIDIC_TALL_GRASS = registerBlock("acidic_tall_grass",
            new TallPlantBlock(FabricBlockSettings.create().noCollision().replaceable().breakInstantly().sounds(BlockSoundGroup.GRASS)));
    public static final Block CORRUPTED_TALL_GRASS = registerBlock("corrupted_tall_grass",
            new TallPlantBlock(FabricBlockSettings.create().noCollision().replaceable().breakInstantly().sounds(BlockSoundGroup.GRASS)));



    public static final Block ACID_FLOWER = registerBlock("acid_flower",
            new FlowerBlock(StatusEffects.POISON, 5, FabricBlockSettings.copyOf(Blocks.ALLIUM)));
    public static final Block POTTED_ACID_FLOWER = registerBlockWithoutBlockItem("potted_acid_flower",
            new FlowerPotBlock(ACID_FLOWER, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM)));
    public static final Block DEAD_BLOOD_BUSH = registerBlock("dead_blood_bush",
            new CustomShrubBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH)));
    public static final Block POTTED_DEAD_BLOOD_BUSH = registerBlockWithoutBlockItem("potted_dead_blood_bush",
            new FlowerPotBlock(DEAD_BLOOD_BUSH, FabricBlockSettings.copyOf(Blocks.POTTED_DEAD_BUSH)));
    public static final Block PINK_FLOWER = registerBlock("pink_flower",
            new FlowerBlock(StatusEffects.REGENERATION, 5, FabricBlockSettings.copyOf(Blocks.ALLIUM)));
    public static final Block POTTED_PINK_FLOWER = registerBlockWithoutBlockItem("potted_pink_flower",
            new FlowerPotBlock(PINK_FLOWER, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM)));
    public static final Block CORRUPTED_POPPY = registerBlock("corrupted_poppy",
            new FlowerBlock(StatusEffects.WITHER, 4, FabricBlockSettings.copyOf(Blocks.ALLIUM)));
    public static final Block POTTED_CORRUPTED_POPPY = registerBlockWithoutBlockItem("potted_corrupted_poppy",
            new FlowerPotBlock(CORRUPTED_POPPY, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM)));
    public static final Block FIRE_FLOWER = registerBlock("fire_flower",
            new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 4, FabricBlockSettings.copyOf(Blocks.ALLIUM)));
    public static final Block POTTED_FIRE_FLOWER = registerBlockWithoutBlockItem("potted_fire_flower",
            new FlowerPotBlock(FIRE_FLOWER, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM)));
    public static final Block CORRUPTED_WITHER_ROSE = registerBlock("corrupted_wither_rose",
            new CorruptedWitherRoseBlock(StatusEffects.WITHER, StatusEffects.DARKNESS, 60, 0, AbstractBlock.Settings.copy(Blocks.WITHER_ROSE)));
    public static final Block POTTED_CORRUPTED_WITHER_ROSE = registerBlockWithoutBlockItem("potted_corrupted_wither_rose",
            new FlowerPotBlock(CORRUPTED_WITHER_ROSE, FabricBlockSettings.copyOf(Blocks.POTTED_WITHER_ROSE)));
    public static final Block ACIDIC_LILAC = registerBlock("acidic_lilac",
            new TallFlowerBlock(FabricBlockSettings.copyOf(Blocks.LILAC)));
    public static final Block CAT_TAILS = registerBlock("cat_tails",
            new TallFlowerBlock(FabricBlockSettings.copyOf(Blocks.LILAC)));
    public static final Block WITHERED_CAT_TAILS = registerBlock("withered_cat_tails",
            new TallFlowerBlock(FabricBlockSettings.copyOf(Blocks.LILAC)));
    public static final Block CORRUPTED_CLOSED_EYEBLOSSOM = registerBlock("corrupted_closed_eyeblossom",
            new ModEyeBlossomBlock(false, () -> ModBlocks.CORRUPTED_OPEN_EYEBLOSSOM, StatusEffects.NAUSEA, 7, FabricBlockSettings.copyOf(Blocks.POPPY)));
    public static final Block CORRUPTED_OPEN_EYEBLOSSOM = registerBlock("corrupted_open_eyeblossom",
            new ModEyeBlossomBlock(true, () -> ModBlocks.CORRUPTED_CLOSED_EYEBLOSSOM, StatusEffects.BLINDNESS, 11, FabricBlockSettings.copyOf(Blocks.POPPY)));
    public static final Block POTTED_CORRUPTED_CLOSED_EYEBLOSSOM = registerBlockWithoutBlockItem("potted_corrupted_closed_eyeblossom",
            new FlowerPotBlock(CORRUPTED_CLOSED_EYEBLOSSOM, FabricBlockSettings.copyOf(Blocks.POTTED_POPPY)));
    public static final Block POTTED_CORRUPTED_OPEN_EYEBLOSSOM = registerBlockWithoutBlockItem("potted_corrupted_open_eyeblossom",
            new FlowerPotBlock(CORRUPTED_OPEN_EYEBLOSSOM, FabricBlockSettings.copyOf(Blocks.POTTED_POPPY)));
    public static final Block BUSH = registerBlock("bush",
            new CustomShrubBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)));
    public static final Block WILD_BUSH = registerBlock("wild_bush",
            new CustomShrubBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)));
    public static final Block WEEDS = registerBlock("weeds",
            new CustomShrubBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)));
    public static final Block WITHERED_BUSH = registerBlock("withered_bush",
            new CustomShrubBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)));
    public static final Block WITHERED_WILD_BUSH = registerBlock("withered_wild_bush",
            new CustomShrubBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)));
    public static final Block WITHERED_WEEDS = registerBlock("withered_weeds",
            new CustomShrubBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)));
    public static final Block POTTED_ACIDIC_MUSHROOM = registerBlockWithoutBlockItem("potted_acidic_mushroom",
            new FlowerPotBlock(ACIDIC_MUSHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM)));
    public static final Block POTTED_CORRUPTED_MUSHROOM = registerBlockWithoutBlockItem("potted_corrupted_mushroom",
            new FlowerPotBlock(CORRUPTED_MUSHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM)));
    public static final Block POTTED_BLACKENED_MUSHROOM = registerBlockWithoutBlockItem("potted_blackened_mushroom",
            new FlowerPotBlock(BLACKENED_MUSHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM)));
    public static final Block POTTED_CHARRED_FUNGUS = registerBlockWithoutBlockItem("potted_charred_fungus",
            new FlowerPotBlock(CHARRED_FUNGUS, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM)));

    public static final Block ACIDIC_PITCHER_CROP = registerBlock("acidic_pitcher_crop",
            new AcidicPitcherCropBlock(FabricBlockSettings.copyOf(Blocks.PITCHER_CROP)));
    public static final Block ACIDIC_PITCHER = registerBlock("acidic_pitcher",
            new TallFlowerBlock(FabricBlockSettings.copyOf(Blocks.PITCHER_PLANT)));

    public static final Block CORRUPTED_TORCHFLOWER = registerBlock("corrupted_torchflower",
            new FlowerBlock(StatusEffects.NIGHT_VISION, 100,
                    AbstractBlock.Settings.copy(Blocks.TORCHFLOWER)));

    public static final Block POTTED_CORRUPTED_TORCHFLOWER = Registry.register(Registries.BLOCK,
            new Identifier(CrimsonMoon.MOD_ID, "potted_corrupted_torchflower"),
            new FlowerPotBlock(CORRUPTED_TORCHFLOWER, AbstractBlock.Settings.copy(Blocks.POTTED_TORCHFLOWER)));

    public static final Block CORRUPTED_TORCHFLOWER_CROP = Registry.register(Registries.BLOCK,
            new Identifier(CrimsonMoon.MOD_ID, "corrupted_torchflower_crop"),
            new CorruptedTorchflowerCropBlock(AbstractBlock.Settings.copy(Blocks.TORCHFLOWER_CROP)));

    public static final Block WITHERED_LILY_PAD = registerLilyPad("withered_lily_pad",
            new LilyPadBlock(FabricBlockSettings.copyOf(Blocks.LILY_PAD)));

    public static final Block CORRUPTED_LILY_PAD = registerLilyPad("corrupted_lily_pad",
            new LilyPadBlock(FabricBlockSettings.copyOf(Blocks.LILY_PAD)));

    public static final Block GLOOMLIGHT = registerBlock("gloomlight",
            new Block(FabricBlockSettings.copyOf(Blocks.SHROOMLIGHT).luminance(state -> 15).sounds(BlockSoundGroup.SHROOMLIGHT)));

    public static final Block CHARRED_VINES = registerBlockWithoutBlockItem("charred_vines",
            new CharredVinesBlock(FabricBlockSettings.copyOf(Blocks.CAVE_VINES)
                    .luminance(CharredVines.getLuminanceSupplier(10)) // Change 10 to 0 if they shouldn't emit light
                    .sounds(BlockSoundGroup.CAVE_VINES)));

    public static final Block CHARRED_VINES_PLANT = registerBlockWithoutBlockItem("charred_vines_plant",
            new CharredVinesPlantBlock(FabricBlockSettings.copyOf(Blocks.CAVE_VINES_PLANT)
                    .luminance(CharredVines.getLuminanceSupplier(10))
                    .sounds(BlockSoundGroup.CAVE_VINES)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(CrimsonMoon.MOD_ID, name), block);
    }



    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(CrimsonMoon.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        CrimsonMoon.LOGGER.info("Registering ModBlocks for " + CrimsonMoon.MOD_ID);
    }

    private static Block registerLilyPad(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(CrimsonMoon.MOD_ID, name),
                new PlaceableOnWaterItem(block, new FabricItemSettings()));
        return Registry.register(Registries.BLOCK, new Identifier(CrimsonMoon.MOD_ID, name), block);
    }

}
