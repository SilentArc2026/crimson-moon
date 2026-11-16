package name.crimsonmoon.datagen;

import name.crimsonmoon.CrimsonMoon;
import name.crimsonmoon.block.ModBlocks;
import name.crimsonmoon.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.item.ArmorItem;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CORRUPTED_REDSTONE_HEART);
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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GLOOMLIGHT);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CORRUPTED_DIRT);
        blockStateModelGenerator.registerSingleton(ModBlocks.CORRUPTED_GRASS_BLOCK, TexturedModel.CUBE_BOTTOM_TOP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ACIDIC_DIRT);
        blockStateModelGenerator.registerSingleton(ModBlocks.ACIDIC_GRASS_BLOCK, TexturedModel.CUBE_BOTTOM_TOP);
        blockStateModelGenerator.registerTintableCross(ModBlocks.CORRUPTED_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.CORRUPTED_TALL_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.ACIDIC_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.ACIDIC_TALL_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.ACID_FLOWER, ModBlocks.POTTED_ACID_FLOWER, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CORRUPTED_WITHER_ROSE, ModBlocks.POTTED_CORRUPTED_WITHER_ROSE, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CORRUPTED_POPPY, ModBlocks.POTTED_CORRUPTED_POPPY, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CORRUPTED_CLOSED_EYEBLOSSOM, ModBlocks.POTTED_CORRUPTED_CLOSED_EYEBLOSSOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CORRUPTED_OPEN_EYEBLOSSOM, ModBlocks.POTTED_CORRUPTED_OPEN_EYEBLOSSOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.ACIDIC_LILAC, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerLog(ModBlocks.CORRUPTED_LOG).log(ModBlocks.CORRUPTED_LOG).wood(ModBlocks.CORRUPTED_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_CORRUPTED_LOG).log(ModBlocks.STRIPPED_CORRUPTED_LOG).wood(ModBlocks.STRIPPED_CORRUPTED_WOOD);
        BlockStateModelGenerator.BlockTexturePool corruptedTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CORRUPTED_PLANKS);
        blockStateModelGenerator.registerLog(ModBlocks.PALM_LOG).log(ModBlocks.PALM_LOG).wood(ModBlocks.PALM_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_PALM_LOG).log(ModBlocks.STRIPPED_PALM_LOG).wood(ModBlocks.STRIPPED_PALM_WOOD);
        BlockStateModelGenerator.BlockTexturePool palmTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PALM_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PALM_LEAVES);
        blockStateModelGenerator.registerLog(ModBlocks.WITHERED_PALM_LOG).log(ModBlocks.WITHERED_PALM_LOG).wood(ModBlocks.WITHERED_PALM_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_WITHERED_PALM_LOG).log(ModBlocks.STRIPPED_WITHERED_PALM_LOG).wood(ModBlocks.STRIPPED_WITHERED_PALM_WOOD);
        BlockStateModelGenerator.BlockTexturePool witheredpalmTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.WITHERED_PALM_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WITHERED_PALM_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CORRUPTED_LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.WITHERED_PALM_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.CORRUPTED_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.ACIDIC_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerLog(ModBlocks.ACIDIC_LOG).log(ModBlocks.ACIDIC_LOG).wood(ModBlocks.ACIDIC_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_ACIDIC_LOG).log(ModBlocks.STRIPPED_ACIDIC_LOG).wood(ModBlocks.STRIPPED_ACIDIC_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ACIDIC_LEAVES);
        blockStateModelGenerator.registerLog(ModBlocks.CHARRED_LOG).log(ModBlocks.CHARRED_LOG).wood(ModBlocks.CHARRED_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_CHARRED_LOG).log(ModBlocks.STRIPPED_CHARRED_LOG).wood(ModBlocks.STRIPPED_CHARRED_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHARRED_WART_BLOCK);
        BlockStateModelGenerator.BlockTexturePool acidicTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ACIDIC_PLANKS);
        BlockStateModelGenerator.BlockTexturePool charredTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CHARRED_PLANKS);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.CHARRED_FUNGUS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.PALM_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_CORRUPTED_LOG, ModBlocks.CORRUPTED_HANGING_SIGN, ModBlocks.CORRUPTED_HANGING_WALL_SIGN);
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_ACIDIC_LOG, ModBlocks.ACIDIC_HANGING_SIGN, ModBlocks.ACIDIC_HANGING_WALL_SIGN);
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_CHARRED_LOG, ModBlocks.CHARRED_HANGING_SIGN, ModBlocks.CHARRED_HANGING_WALL_SIGN);
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_PALM_LOG, ModBlocks.PALM_HANGING_SIGN, ModBlocks.PALM_HANGING_WALL_SIGN);
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_WITHERED_PALM_LOG, ModBlocks.WITHERED_PALM_HANGING_SIGN, ModBlocks.WITHERED_PALM_HANGING_WALL_SIGN);

        corruptedTexturePool.family(BlockFamilies.register(ModBlocks.CORRUPTED_PLANKS).sign(ModBlocks.CORRUPTED_SIGN, ModBlocks.CORRUPTED_WALL_SIGN).build());
        acidicTexturePool.family(BlockFamilies.register(ModBlocks.ACIDIC_PLANKS).sign(ModBlocks.ACIDIC_SIGN, ModBlocks.ACIDIC_WALL_SIGN).build());
        charredTexturePool.family(BlockFamilies.register(ModBlocks.CHARRED_PLANKS).sign(ModBlocks.CHARRED_SIGN, ModBlocks.CHARRED_WALL_SIGN).build());
        palmTexturePool.family(BlockFamilies.register(ModBlocks.PALM_PLANKS).sign(ModBlocks.PALM_SIGN, ModBlocks.PALM_WALL_SIGN).build());
        witheredpalmTexturePool.family(BlockFamilies.register(ModBlocks.WITHERED_PALM_PLANKS).sign(ModBlocks.WITHERED_PALM_SIGN, ModBlocks.WITHERED_PALM_WALL_SIGN).build());


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
        charredTexturePool.stairs(ModBlocks.CHARRED_STAIRS);
        charredTexturePool.slab(ModBlocks.CHARRED_SLAB);
        charredTexturePool.button(ModBlocks.CHARRED_BUTTON);
        charredTexturePool.pressurePlate(ModBlocks.CHARRED_PRESSURE_PLATE);
        charredTexturePool.fence(ModBlocks.CHARRED_FENCE);
        charredTexturePool.fenceGate(ModBlocks.CHARRED_FENCE_GATE);
        palmTexturePool.stairs(ModBlocks.PALM_STAIRS);
        palmTexturePool.slab(ModBlocks.PALM_SLAB);
        palmTexturePool.button(ModBlocks.PALM_BUTTON);
        palmTexturePool.pressurePlate(ModBlocks.PALM_PRESSURE_PLATE);
        palmTexturePool.fence(ModBlocks.PALM_FENCE);
        palmTexturePool.fenceGate(ModBlocks.PALM_FENCE_GATE);
        witheredpalmTexturePool.stairs(ModBlocks.WITHERED_PALM_STAIRS);
        witheredpalmTexturePool.slab(ModBlocks.WITHERED_PALM_SLAB);
        witheredpalmTexturePool.button(ModBlocks.WITHERED_PALM_BUTTON);
        witheredpalmTexturePool.pressurePlate(ModBlocks.WITHERED_PALM_PRESSURE_PLATE);
        witheredpalmTexturePool.fence(ModBlocks.WITHERED_PALM_FENCE);
        witheredpalmTexturePool.fenceGate(ModBlocks.WITHERED_PALM_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.ACIDIC_DOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.CORRUPTED_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.ACIDIC_TRAPDOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.CORRUPTED_TRAPDOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.CHARRED_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.CHARRED_TRAPDOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.PALM_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PALM_TRAPDOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.WITHERED_PALM_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.WITHERED_PALM_TRAPDOOR);

        registerBerryVine(blockStateModelGenerator, ModBlocks.CHARRED_VINES);
        registerBerryVine(blockStateModelGenerator, ModBlocks.CHARRED_VINES_PLANT);

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

    private void registerBerryVine(BlockStateModelGenerator generator, Block block) {
        Identifier unlitModel = generator.createSubModel(block, "", Models.CROSS, TextureMap::cross);
        Identifier litModel = generator.createSubModel(block, "_lit", Models.CROSS, TextureMap::cross);

        generator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(block).coordinate(
                        BlockStateVariantMap.create(Properties.BERRIES)
                                .register(false, BlockStateVariant.create().put(VariantSettings.MODEL, unlitModel))
                                .register(true, BlockStateVariant.create().put(VariantSettings.MODEL, litModel))
                )
        );
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

        itemModelGenerator.register(ModItems.GLOOM_BERRIES, Models.GENERATED);

        itemModelGenerator.register(ModItems.CORRUPTED_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORRUPTED_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ACIDIC_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ACIDIC_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHARRED_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHARRED_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PALM_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PALM_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.WITHERED_PALM_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.WITHERED_PALM_CHEST_BOAT, Models.GENERATED);
    }
}