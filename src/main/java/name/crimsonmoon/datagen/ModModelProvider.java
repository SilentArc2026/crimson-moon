package name.crimsonmoon.datagen;

import name.crimsonmoon.block.ModBlocks;
import name.crimsonmoon.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Crimson_Block);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Raw_Vampyrite_Block);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Vampyrite_Block);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Vampyrite_Ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Deepslate_Vampyrite_Ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Solarium_Block);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.Crimson_Ingot, Models.GENERATED);
        itemModelGenerator.register(ModItems.Crimson_Plate, Models.GENERATED);
        itemModelGenerator.register(ModItems.Blood_Blade, Models.HANDHELD);
        itemModelGenerator.register(ModItems.Crimson_Pickaxe, Models.HANDHELD);
        itemModelGenerator.register(ModItems.Crimson_Axe, Models.HANDHELD);
        itemModelGenerator.register(ModItems.Crimson_Shovel, Models.HANDHELD);
        itemModelGenerator.register(ModItems.Crimson_Hoe, Models.HANDHELD);
        itemModelGenerator.register(ModItems.Crimson_upgrade_smithing_template, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRIMSON_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.VAMPYRITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_VAMPYRITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOLARIUM_INGOT, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CRIMSON_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CRIMSON_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CRIMSON_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CRIMSON_BOOTS));

    }
}
