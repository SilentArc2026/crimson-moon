package name.crimsonmoon.datagen;

import name.crimsonmoon.block.ModBlocks;
import name.crimsonmoon.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.item.Items;
import net.minecraft.loot.entry.ItemEntry;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.Crimsonite_Block);
        addDrop(ModBlocks.Solarium_Block);
        addDrop(ModBlocks.Vampyrite_Block);
        addDrop(ModBlocks.Raw_Vampyrite_Block);
        addDrop(ModBlocks.Budding_Crystalized_Turqite_Block);
        addDrop(ModBlocks.Crystalized_Turqite_Block);
        addDrop(ModBlocks.Refined_Turqite_Block);
        addDrop(ModBlocks.Turqite_Bricks);
        addDrop(ModBlocks.DOLOMITE_BRICKS);
        addDrop(ModBlocks.DOLOMITE);
        addDrop(ModBlocks.POLISHED_DOLOMITE);
        addDrop(ModBlocks.ACIDIC_SAPLING);
        addDrop(ModBlocks.CORRUPTED_SAPLING);
        addDrop(ModBlocks.Turqite_Crystal_Block);
        addDrop(ModBlocks.ACIDIC_STAIRS);
        addDrop(ModBlocks.CORRUPTED_STAIRS);
        addDrop(ModBlocks.CORRUPTED_BUTTON);
        addDrop(ModBlocks.CORRUPTED_PRESSURE_PLATE);
        addDrop(ModBlocks.ACIDIC_BUTTON);
        addDrop(ModBlocks.ACIDIC_PRESSURE_PLATE);
        addDrop(ModBlocks.ACIDIC_FENCE);
        addDrop(ModBlocks.ACIDIC_FENCE_GATE);
        addDrop(ModBlocks.CORRUPTED_FENCE);
        addDrop(ModBlocks.CORRUPTED_FENCE_GATE);
        addDrop(ModBlocks.ACIDIC_TRAPDOOR);
        addDrop(ModBlocks.CORRUPTED_TRAPDOOR);
        addDrop(ModBlocks.CORRUPTED_DIRT);
        addDrop(ModBlocks.ACIDIC_DIRT);
        addDrop(ModBlocks.ACIDIC_LOG);
        addDrop(ModBlocks.STRIPPED_ACIDIC_LOG);
        addDrop(ModBlocks.ACIDIC_PLANKS);
        addDrop(ModBlocks.ACIDIC_WOOD);
        addDrop(ModBlocks.STRIPPED_ACIDIC_WOOD);
        addDrop(ModBlocks.CORRUPTED_LOG);
        addDrop(ModBlocks.STRIPPED_CORRUPTED_LOG);
        addDrop(ModBlocks.CORRUPTED_WOOD);
        addDrop(ModBlocks.STRIPPED_CORRUPTED_WOOD);
        addDrop(ModBlocks.CORRUPTED_PLANKS);
        addDrop(ModBlocks.CHARRED_PLANKS);
        addDrop(ModBlocks.CHARRED_LOG);
        addDrop(ModBlocks.CHARRED_WOOD);
        addDrop(ModBlocks.CHARRED_FENCE);
        addDrop(ModBlocks.CHARRED_FENCE_GATE);
        addDrop(ModBlocks.CHARRED_TRAPDOOR);
        addDrop(ModBlocks.CHARRED_STAIRS);
        addDrop(ModBlocks.CHARRED_BUTTON);
        addDrop(ModBlocks.CHARRED_FUNGUS);
        addDrop(ModBlocks.ACID_FLOWER);
        addDrop(ModBlocks.CORRUPTED_POPPY);
        addDrop(ModBlocks.CHARRED_PRESSURE_PLATE);
        addDrop(ModBlocks.STRIPPED_CHARRED_LOG);
        addDrop(ModBlocks.STRIPPED_CHARRED_WOOD);
        addDrop(ModBlocks.CHARRED_SIGN);
        addDrop(ModBlocks.CHARRED_HANGING_SIGN);
        addDrop(ModBlocks.CORRUPTED_SIGN);
        addDrop(ModBlocks.CORRUPTED_HANGING_SIGN);
        addDrop(ModBlocks.ACIDIC_SIGN);
        addDrop(ModBlocks.ACIDIC_HANGING_SIGN);
        addDrop(ModBlocks.ACIDIC_DOOR, doorDrops(ModBlocks.ACIDIC_DOOR));
        addDrop(ModBlocks.CORRUPTED_DOOR, doorDrops(ModBlocks.CORRUPTED_DOOR));
        addDrop(ModBlocks.CORRUPTED_SLAB, slabDrops(ModBlocks.CORRUPTED_SLAB));
        addDrop(ModBlocks.CHARRED_DOOR, doorDrops(ModBlocks.CHARRED_DOOR));
        addDrop(ModBlocks.CHARRED_SLAB, slabDrops(ModBlocks.CHARRED_SLAB));
        addDrop(ModBlocks.ACIDIC_SLAB, slabDrops(ModBlocks.ACIDIC_SLAB));
        addDrop(ModBlocks.Turqite_Cluster, drops(ModItems.TURQITE_CRYSTAL));
        addDrop(ModBlocks.CORRUPTED_GRASS_BLOCK, dropsWithSilkTouch(ModBlocks.CORRUPTED_GRASS_BLOCK, ItemEntry.builder(ModBlocks.CORRUPTED_DIRT)));
        addDrop(ModBlocks.ACIDIC_GRASS_BLOCK, dropsWithSilkTouch(ModBlocks.ACIDIC_GRASS_BLOCK, ItemEntry.builder(ModBlocks.ACIDIC_DIRT)));
        addDrop(ModBlocks.ACIDIC_GRASS, grassDrops(ModBlocks.ACIDIC_GRASS));
        addDrop(ModBlocks.ACIDIC_TALL_GRASS, block -> tallGrassDrops(block, Blocks.AIR));
        addDrop(ModBlocks.CORRUPTED_TALL_GRASS, block -> tallGrassDrops(block, Blocks.AIR));
        addDrop(ModBlocks.ACIDIC_LEAVES, block -> tallGrassDrops(block, Blocks.AIR));
        addDrop(ModBlocks.CORRUPTED_LEAVES, block -> tallGrassDrops(block, Blocks.AIR));
        addDrop(ModBlocks.CHARRED_WART_BLOCK, block -> tallGrassDrops(block, Blocks.AIR));
        addDrop(ModBlocks.ACIDIC_LILAC, block -> dropsWithProperty(block, TallFlowerBlock.HALF, DoubleBlockHalf.LOWER));
        addDrop(ModBlocks.CORRUPTED_CLOSED_EYEBLOSSOM);
        addDrop(ModBlocks.CORRUPTED_OPEN_EYEBLOSSOM);
        addDrop(ModBlocks.CORRUPTED_REDSTONE_HEART);

        addPottedPlantDrops(ModBlocks.POTTED_CORRUPTED_OPEN_EYEBLOSSOM);
        addPottedPlantDrops(ModBlocks.POTTED_CORRUPTED_CLOSED_EYEBLOSSOM);
        addPottedPlantDrops(ModBlocks.POTTED_ACID_FLOWER);
        addPottedPlantDrops(ModBlocks.POTTED_CORRUPTED_POPPY);

        addDrop(ModBlocks.Vampyrite_Ore, oreDrops(ModBlocks.Vampyrite_Ore, ModItems.RAW_VAMPYRITE));
        addDrop(ModBlocks.Deepslate_Vampyrite_Ore, oreDrops(ModBlocks.Deepslate_Vampyrite_Ore, ModItems.RAW_VAMPYRITE));
        addDrop(ModBlocks.Smooth_Basalt_Turqite_Ore, oreDrops(ModBlocks.Smooth_Basalt_Turqite_Ore, ModItems.TURQITE_CRYSTAL));


    }
}
