package name.crimsonmoon.block;

import name.crimsonmoon.CrimsonMoon;
import name.crimsonmoon.world.tree.AcidicSaplingGenerator;
import name.crimsonmoon.world.tree.CorruptedSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

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
    public static final Block CORRUPTED_SAPLING  = registerBlock("corrupted_sapling",
            new SaplingBlock(new CorruptedSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block ACIDIC_LOG = registerBlock("acidic_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block ACIDIC_WOOD = registerBlock("acidic_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block STRIPPED_ACIDIC_LOG = registerBlock("stripped_acidic_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block STRIPPED_ACIDIC_WOOD = registerBlock("stripped_acidic_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block ACIDIC_PLANKS  = registerBlock("acidic_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block ACIDIC_LEAVES  = registerBlock("acidic_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block ACIDIC_SAPLING  = registerBlock("acidic_sapling",
            new SaplingBlock(new AcidicSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block DOLOMITE = registerBlock("dolomite",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block DOLOMITE_BRICKS = registerBlock("dolomite_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block POLISHED_DOLOMITE = registerBlock("polished_dolomite",
            new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE)));

    public static final Block CORRUPTED_STAIRS = registerBlock("corrupted_stairs",
            new StairsBlock(ModBlocks.CORRUPTED_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block CORRUPTED_SLAB = registerBlock("corrupted_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block ACIDIC_STAIRS = registerBlock("acidic_stairs",
            new StairsBlock(ModBlocks.ACIDIC_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block ACIDIC_SLAB = registerBlock("acidic_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block CORRUPTED_BUTTON = registerBlock("corrupted_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));
    public static final Block CORRUPTED_PRESSURE_PLATE = registerBlock("corrupted_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
    public static final Block ACIDIC_BUTTON = registerBlock("acidic_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));
    public static final Block ACIDIC_FENCE = registerBlock("acidic_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
    public static final Block ACIDIC_FENCE_GATE = registerBlock("acidic_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.OAK));
    public static final Block CORRUPTED_FENCE = registerBlock("corrupted_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
    public static final Block CORRUPTED_FENCE_GATE = registerBlock("corrupted_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.OAK));
    public static final Block ACIDIC_PRESSURE_PLATE = registerBlock("acidic_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
    public static final Block CORRUPTED_DOOR = registerBlock("corrupted_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR), BlockSetType.OAK));
    public static final Block CORRUPTED_TRAPDOOR = registerBlock("corrupted_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    public static final Block ACIDIC_DOOR = registerBlock("acidic_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR), BlockSetType.OAK));
    public static final Block ACIDIC_TRAPDOOR = registerBlock("acidic_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));



    //public static final Block ACID_FLOWER = registerBlock("acid_flower",
            //new FlowerBlock(StatusEffects.POISON, 5, FabricBlockSettings.copyOf(Blocks.ALLIUM)));
    //public static final Block POTTED_ACID_FLOWER = registerBlockWithoutBlockItem("potted_acid_flower",
            //new FlowerPotBlock(ACID_FLOWER, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM)));


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
