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
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block CORRUPTED_REDSTONE_HEART = registerBlock("corrupted_redstone_heart",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK).luminance(state -> 5)));

    public static final Block Crimsonite_Block = registerBlock("crimsonite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)));
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
            new MushroomBlock(FabricBlockSettings.copyOf(Blocks.WARPED_WART_BLOCK)));
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
    public static final Block CORRUPTED_POPPY = registerBlock("corrupted_poppy",
            new FlowerBlock(StatusEffects.WITHER, 4, FabricBlockSettings.copyOf(Blocks.ALLIUM)));
    public static final Block POTTED_CORRUPTED_POPPY = registerBlockWithoutBlockItem("potted_corrupted_poppy",
            new FlowerPotBlock(CORRUPTED_POPPY, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM)));
    public static final Block CORRUPTED_WITHER_ROSE = registerBlock("corrupted_wither_rose",
            new CorruptedWitherRoseBlock(StatusEffects.WITHER, StatusEffects.DARKNESS, 60, 0, AbstractBlock.Settings.copy(Blocks.WITHER_ROSE)));
    public static final Block POTTED_CORRUPTED_WITHER_ROSE = registerBlockWithoutBlockItem("potted_corrupted_wither_rose",
            new FlowerPotBlock(CORRUPTED_WITHER_ROSE, FabricBlockSettings.copyOf(Blocks.POTTED_WITHER_ROSE)));
    public static final Block ACIDIC_LILAC = registerBlock("acidic_lilac",
            new TallFlowerBlock(FabricBlockSettings.copyOf(Blocks.LILAC)));
    public static final Block CORRUPTED_CLOSED_EYEBLOSSOM = registerBlock("corrupted_closed_eyeblossom",
            new ModEyeBlossomBlock(false, () -> ModBlocks.CORRUPTED_OPEN_EYEBLOSSOM, StatusEffects.NAUSEA, 7, FabricBlockSettings.copyOf(Blocks.POPPY)));
    public static final Block CORRUPTED_OPEN_EYEBLOSSOM = registerBlock("corrupted_open_eyeblossom",
            new ModEyeBlossomBlock(true, () -> ModBlocks.CORRUPTED_CLOSED_EYEBLOSSOM, StatusEffects.BLINDNESS, 11, FabricBlockSettings.copyOf(Blocks.POPPY)));
    public static final Block POTTED_CORRUPTED_CLOSED_EYEBLOSSOM = registerBlockWithoutBlockItem("potted_corrupted_closed_eyeblossom",
            new FlowerPotBlock(CORRUPTED_CLOSED_EYEBLOSSOM, FabricBlockSettings.copyOf(Blocks.POTTED_POPPY)));
    public static final Block POTTED_CORRUPTED_OPEN_EYEBLOSSOM = registerBlockWithoutBlockItem("potted_corrupted_open_eyeblossom",
            new FlowerPotBlock(CORRUPTED_OPEN_EYEBLOSSOM, FabricBlockSettings.copyOf(Blocks.POTTED_POPPY)));

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
}
