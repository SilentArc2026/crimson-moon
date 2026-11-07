package name.crimsonmoon.datagen;

import name.crimsonmoon.block.ModBlocks;
import name.crimsonmoon.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

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
        addDrop(ModBlocks.ACIDIC_DOOR, doorDrops(ModBlocks.ACIDIC_DOOR));
        addDrop(ModBlocks.CORRUPTED_DOOR, doorDrops(ModBlocks.CORRUPTED_DOOR));
        addDrop(ModBlocks.CORRUPTED_SLAB, slabDrops(ModBlocks.CORRUPTED_SLAB));
        addDrop(ModBlocks.ACIDIC_SLAB, slabDrops(ModBlocks.ACIDIC_SLAB));
        addDrop(ModBlocks.Turqite_Cluster, drops(ModItems.TURQITE_CRYSTAL));

        addDrop(ModBlocks.Vampyrite_Ore, oreDrops(ModBlocks.Vampyrite_Ore, ModItems.RAW_VAMPYRITE));
        addDrop(ModBlocks.Deepslate_Vampyrite_Ore, oreDrops(ModBlocks.Deepslate_Vampyrite_Ore, ModItems.RAW_VAMPYRITE));
        addDrop(ModBlocks.Smooth_Basalt_Turqite_Ore, oreDrops(ModBlocks.Smooth_Basalt_Turqite_Ore, ModItems.TURQITE_CRYSTAL));

    }
}
