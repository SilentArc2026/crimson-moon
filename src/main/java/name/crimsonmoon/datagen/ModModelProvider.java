package name.crimsonmoon.datagen;

import name.crimsonmoon.CrimsonMoon;
import name.crimsonmoon.block.ModBlocks;
import name.crimsonmoon.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Crimsonite_Block);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Raw_Vampyrite_Block);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Vampyrite_Block);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Vampyrite_Ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Deepslate_Vampyrite_Ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Solarium_Block);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Budding_Crystalized_Turqite_Block);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Crystalized_Turqite_Block);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Refined_Turqite_Block);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Smooth_Basalt_Turqite_Ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Turqite_Bricks);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Turqite_Crystal_Block);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOLOMITE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOLOMITE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POLISHED_DOLOMITE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CORRUPTED_DIRT);
        blockStateModelGenerator.registerSingleton(ModBlocks.CORRUPTED_GRASS_BLOCK, TexturedModel.CUBE_BOTTOM_TOP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ACIDIC_DIRT);
        blockStateModelGenerator.registerSingleton(ModBlocks.ACIDIC_GRASS_BLOCK, TexturedModel.CUBE_BOTTOM_TOP);
        blockStateModelGenerator.registerTintableCross(ModBlocks.CORRUPTED_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.CORRUPTED_TALL_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.ACIDIC_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.ACIDIC_TALL_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);


        blockStateModelGenerator.registerLog(ModBlocks.CORRUPTED_LOG).log(ModBlocks.CORRUPTED_LOG).wood(ModBlocks.CORRUPTED_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_CORRUPTED_LOG).log(ModBlocks.STRIPPED_CORRUPTED_LOG).wood(ModBlocks.STRIPPED_CORRUPTED_WOOD);
        BlockStateModelGenerator.BlockTexturePool corruptedTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CORRUPTED_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CORRUPTED_LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.CORRUPTED_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerLog(ModBlocks.ACIDIC_LOG).log(ModBlocks.ACIDIC_LOG).wood(ModBlocks.ACIDIC_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_ACIDIC_LOG).log(ModBlocks.STRIPPED_ACIDIC_LOG).wood(ModBlocks.STRIPPED_ACIDIC_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ACIDIC_LEAVES);
        BlockStateModelGenerator.BlockTexturePool acidicTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ACIDIC_PLANKS);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.ACIDIC_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        corruptedTexturePool.stairs(ModBlocks.CORRUPTED_STAIRS);
        corruptedTexturePool.slab(ModBlocks.CORRUPTED_SLAB);
        acidicTexturePool.stairs(ModBlocks.ACIDIC_STAIRS);
        acidicTexturePool.slab(ModBlocks.ACIDIC_SLAB);
        corruptedTexturePool.button(ModBlocks.CORRUPTED_BUTTON);
        corruptedTexturePool.pressurePlate(ModBlocks.CORRUPTED_PRESSURE_PLATE);
        acidicTexturePool.button(ModBlocks.ACIDIC_BUTTON);
        acidicTexturePool.pressurePlate(ModBlocks.ACIDIC_PRESSURE_PLATE);
        corruptedTexturePool.fence(ModBlocks.CORRUPTED_FENCE);
        corruptedTexturePool.fenceGate(ModBlocks.CORRUPTED_FENCE_GATE);
        acidicTexturePool.fence(ModBlocks.ACIDIC_FENCE);
        acidicTexturePool.fenceGate(ModBlocks.ACIDIC_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.ACIDIC_DOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.CORRUPTED_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.ACIDIC_TRAPDOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.CORRUPTED_TRAPDOOR);

        // === 1. TURQITE CLUSTER ===
        Identifier clusterModel = Models.CROSS.upload(
                ModBlocks.Turqite_Cluster,
                TextureMap.cross(ModBlocks.Turqite_Cluster),
                blockStateModelGenerator.modelCollector
        );

        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(ModBlocks.Turqite_Cluster)
                        .coordinate(BlockStateVariantMap.create(net.minecraft.state.property.Properties.FACING)
                                .register(net.minecraft.util.math.Direction.UP,    BlockStateVariant.create().put(VariantSettings.MODEL, clusterModel))
                                .register(net.minecraft.util.math.Direction.DOWN,  BlockStateVariant.create().put(VariantSettings.MODEL, clusterModel).put(VariantSettings.X, VariantSettings.Rotation.R180))
                                .register(net.minecraft.util.math.Direction.NORTH, BlockStateVariant.create().put(VariantSettings.MODEL, clusterModel).put(VariantSettings.X, VariantSettings.Rotation.R90))
                                .register(net.minecraft.util.math.Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.MODEL, clusterModel).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                .register(net.minecraft.util.math.Direction.EAST,  BlockStateVariant.create().put(VariantSettings.MODEL, clusterModel).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                .register(net.minecraft.util.math.Direction.WEST,  BlockStateVariant.create().put(VariantSettings.MODEL, clusterModel).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                        )
        );
        // FIX: Use .asItem() to target the exact method signature signature
        blockStateModelGenerator.registerParentedItemModel(ModBlocks.Turqite_Cluster.asItem(), clusterModel);

        // === 2. SMALL, MEDIUM, LARGE BUDS ===
        registerManualCluster(blockStateModelGenerator, ModBlocks.SMALL_TURQITE_BUD);
        registerManualCluster(blockStateModelGenerator, ModBlocks.MEDIUM_TURQITE_BUD);
        registerManualCluster(blockStateModelGenerator, ModBlocks.LARGE_TURQITE_BUD);
    }

    private void registerManualCluster(BlockStateModelGenerator generator, Block block) {
        Identifier budModel = Models.CROSS.upload(block, TextureMap.cross(block), generator.modelCollector);
        generator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(block)
                        .coordinate(BlockStateVariantMap.create(net.minecraft.state.property.Properties.FACING)
                                .register(net.minecraft.util.math.Direction.UP,    BlockStateVariant.create().put(VariantSettings.MODEL, budModel))
                                .register(net.minecraft.util.math.Direction.DOWN,  BlockStateVariant.create().put(VariantSettings.MODEL, budModel).put(VariantSettings.X, VariantSettings.Rotation.R180))
                                .register(net.minecraft.util.math.Direction.NORTH, BlockStateVariant.create().put(VariantSettings.MODEL, budModel).put(VariantSettings.X, VariantSettings.Rotation.R90))
                                .register(net.minecraft.util.math.Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.MODEL, budModel).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                .register(net.minecraft.util.math.Direction.EAST,  BlockStateVariant.create().put(VariantSettings.MODEL, budModel).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                .register(net.minecraft.util.math.Direction.WEST,  BlockStateVariant.create().put(VariantSettings.MODEL, budModel).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                        )
        );
        // FIX: Use .asItem() here as well
        generator.registerParentedItemModel(block.asItem(), budModel);
    } // FIXED: Removed the stray closing braces that were cutting the class file in half

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.Crimsonite_Ingot, Models.GENERATED);
        itemModelGenerator.register(ModItems.Crimsonite_Plate, Models.GENERATED);
        itemModelGenerator.register(ModItems.Blood_Blade, Models.HANDHELD);
        itemModelGenerator.register(ModItems.Crimson_Pickaxe, Models.HANDHELD);
        itemModelGenerator.register(ModItems.Crimson_Axe, Models.HANDHELD);
        itemModelGenerator.register(ModItems.Crimson_Shovel, Models.HANDHELD);
        itemModelGenerator.register(ModItems.Crimson_Hoe, Models.HANDHELD);
        itemModelGenerator.register(ModItems.Crimsonite_upgrade_smithing_template, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRIMSON_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.VAMPYRITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_VAMPYRITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOLARIUM_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOLARIUM_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOLARIUM_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOLARIUM_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOLARIUM_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.VAMPYRITE_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.VAMPYRITE_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.VAMPYRITE_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.VAMPYRITE_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.VAMPYRITE_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_ROD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOLARIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOLARIUM_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOLAR_STAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQITE_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQITE_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.REFINED_TURQITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQITE_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQITE_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQITE_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQITE_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQITE_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAVENLY_BLADE, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CRIMSON_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CRIMSON_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CRIMSON_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CRIMSON_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SOLARIUM_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SOLARIUM_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SOLARIUM_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SOLARIUM_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.VAMPYRITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.VAMPYRITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.VAMPYRITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.VAMPYRITE_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TURQITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TURQITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TURQITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TURQITE_BOOTS));
    }
}