package name.crimsonmoon.block;

import name.crimsonmoon.CrimsonMoon;
import name.crimsonmoon.world.tree.CorruptedSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
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
