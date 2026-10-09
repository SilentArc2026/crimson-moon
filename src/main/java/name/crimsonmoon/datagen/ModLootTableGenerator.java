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
        addDrop(ModBlocks.Turqite_Crystal_Block);
        addDrop(ModBlocks.Turqite_Cluster, drops(ModItems.TURQITE_CRYSTAL));

        addDrop(ModBlocks.Vampyrite_Ore, oreDrops(ModBlocks.Vampyrite_Ore, ModItems.RAW_VAMPYRITE));
        addDrop(ModBlocks.Deepslate_Vampyrite_Ore, oreDrops(ModBlocks.Deepslate_Vampyrite_Ore, ModItems.RAW_VAMPYRITE));
        addDrop(ModBlocks.Smooth_Basalt_Turqite_Ore, oreDrops(ModBlocks.Smooth_Basalt_Turqite_Ore, ModItems.TURQITE_CRYSTAL));

    }
}
