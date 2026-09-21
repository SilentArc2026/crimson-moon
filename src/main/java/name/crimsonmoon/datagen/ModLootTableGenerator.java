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
        addDrop(ModBlocks.Crimson_Block);
        addDrop(ModBlocks.Solarium_Block);
        addDrop(ModBlocks.Vampyrite_Block);
        addDrop(ModBlocks.Raw_Vampyrite_Block);

        addDrop(ModBlocks.Vampyrite_Ore, oreDrops(ModBlocks.Vampyrite_Ore, ModItems.RAW_VAMPYRITE));
        addDrop(ModBlocks.Deepslate_Vampyrite_Ore, oreDrops(ModBlocks.Deepslate_Vampyrite_Ore, ModItems.RAW_VAMPYRITE));

    }
}
