package name.crimsonmoon.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import name.crimsonmoon.CrimsonMoon;
import name.crimsonmoon.block.ModBlocks;
import name.crimsonmoon.block.custom.CorruptedTorchflowerCropBlock;
import name.crimsonmoon.item.ModInstruments;
import name.crimsonmoon.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.PitcherCropBlock;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {

    private static final Model LILY_PAD_TEMPLATE = new Model(
            Optional.of(new Identifier("minecraft", "block/lily_pad")), Optional.empty(), TextureKey.TEXTURE);
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap sandstoneTextures = new TextureMap()
                .put(TextureKey.TOP, TextureMap.getSubId(ModBlocks.BLACK_SANDSTONE, "_top"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(ModBlocks.BLACK_SANDSTONE, "_bottom"))
                .put(TextureKey.SIDE, TextureMap.getId(ModBlocks.BLACK_SANDSTONE))
                .put(TextureKey.WALL, TextureMap.getId(ModBlocks.BLACK_SANDSTONE));


        BlockStateModelGenerator.BlockTexturePool blackSandstonePool = blockStateModelGenerator.new BlockTexturePool(sandstoneTextures);
        blackSandstonePool.base(ModBlocks.BLACK_SANDSTONE, Models.CUBE_BOTTOM_TOP);
        blackSandstonePool.stairs(ModBlocks.BLACK_SANDSTONE_STAIRS);
        blackSandstonePool.slab(ModBlocks.BLACK_SANDSTONE_SLAB);
        blackSandstonePool.wall(ModBlocks.BLACK_SANDSTONE_WALL);

        TextureMap cutTextures = new TextureMap()
                .put(TextureKey.TOP, TextureMap.getSubId(ModBlocks.BLACK_SANDSTONE, "_top"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(ModBlocks.BLACK_SANDSTONE, "_top"))
                .put(TextureKey.SIDE, TextureMap.getId(ModBlocks.CUT_BLACK_SANDSTONE));

        TextureMap chiseledTextures = new TextureMap()
                .put(TextureKey.TOP, TextureMap.getSubId(ModBlocks.BLACK_SANDSTONE, "_top"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(ModBlocks.BLACK_SANDSTONE, "_top"))
                .put(TextureKey.SIDE, TextureMap.getId(ModBlocks.CHISELED_BLACK_SANDSTONE));
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(
                ModBlocks.CHISELED_BLACK_SANDSTONE,
                Models.CUBE_BOTTOM_TOP.upload(ModBlocks.CHISELED_BLACK_SANDSTONE, chiseledTextures, blockStateModelGenerator.modelCollector)
        ));

        TextureMap smoothTextures = TextureMap.all(TextureMap.getSubId(ModBlocks.BLACK_SANDSTONE, "_top"));

        BlockStateModelGenerator.BlockTexturePool cutSandstonePool = blockStateModelGenerator.new BlockTexturePool(cutTextures);
        cutSandstonePool.base(ModBlocks.CUT_BLACK_SANDSTONE, Models.CUBE_BOTTOM_TOP);
        cutSandstonePool.stairs(ModBlocks.CUT_BLACK_SANDSTONE_STAIRS);
        cutSandstonePool.slab(ModBlocks.CUT_BLACK_SANDSTONE_SLAB);

        BlockStateModelGenerator.BlockTexturePool smoothSandstonePool = blockStateModelGenerator.new BlockTexturePool(smoothTextures);
        smoothSandstonePool.base(ModBlocks.SMOOTH_BLACK_SANDSTONE, Models.CUBE_ALL);
        smoothSandstonePool.stairs(ModBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS);
        smoothSandstonePool.slab(ModBlocks.SMOOTH_BLACK_SANDSTONE_SLAB);



        TextureMap textureMap = TextureMap.all(ModBlocks.ACIDIC_TRAPPED_RUG);

        Identifier upModelId = Models.PRESSURE_PLATE_UP.upload(
                ModBlocks.ACIDIC_TRAPPED_RUG, textureMap, blockStateModelGenerator.modelCollector);
        Identifier downModelId = Models.PRESSURE_PLATE_DOWN.upload(
                ModBlocks.ACIDIC_TRAPPED_RUG, textureMap, blockStateModelGenerator.modelCollector);

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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ACIDIC_MUSHROOM_STEM);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CORRUPTED_MUSHROOM_STEM);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WET_RED_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WET_BLACK_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WET_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLACK_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REDSTONE_HEART);
        blockStateModelGenerator.registerSingleton(ModBlocks.CORRUPTED_GRASS_BLOCK, TexturedModel.CUBE_BOTTOM_TOP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ACIDIC_DIRT);
        blockStateModelGenerator.registerSingleton(ModBlocks.ACIDIC_GRASS_BLOCK, TexturedModel.CUBE_BOTTOM_TOP);
        blockStateModelGenerator.registerTintableCross(ModBlocks.CORRUPTED_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.BUSH, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.WILD_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.WEEDS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.WITHERED_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.WITHERED_WILD_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.WITHERED_WEEDS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.CORRUPTED_TALL_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.ACIDIC_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.ACIDIC_TALL_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.blockStateCollector.accept(
                BlockStateModelGenerator.createPressurePlateBlockState(
                        ModBlocks.ACIDIC_TRAPPED_RUG, upModelId, downModelId));

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.ACID_FLOWER, ModBlocks.POTTED_ACID_FLOWER, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.FIRE_FLOWER, ModBlocks.POTTED_FIRE_FLOWER, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.PINK_FLOWER, ModBlocks.POTTED_PINK_FLOWER, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CORRUPTED_TORCHFLOWER, ModBlocks.POTTED_CORRUPTED_TORCHFLOWER, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CORRUPTED_WITHER_ROSE, ModBlocks.POTTED_CORRUPTED_WITHER_ROSE, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CORRUPTED_POPPY, ModBlocks.POTTED_CORRUPTED_POPPY, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CORRUPTED_CLOSED_EYEBLOSSOM, ModBlocks.POTTED_CORRUPTED_CLOSED_EYEBLOSSOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CORRUPTED_OPEN_EYEBLOSSOM, ModBlocks.POTTED_CORRUPTED_OPEN_EYEBLOSSOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.ACIDIC_LILAC, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.CAT_TAILS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.WITHERED_CAT_TAILS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerCrop(ModBlocks.CORRUPTED_TORCHFLOWER_CROP, CorruptedTorchflowerCropBlock.AGE, 0, 1);

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
        BlockStateModelGenerator.BlockTexturePool palmmosaicTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PALM_MOSAIC);
        BlockStateModelGenerator.BlockTexturePool witheredpalmmosaicTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.WITHERED_PALM_MOSAIC);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.CHARRED_FUNGUS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.ACIDIC_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.CORRUPTED_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.BLACKENED_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
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
        witheredpalmmosaicTexturePool.slab(ModBlocks.WITHERED_PALM_MOSAIC_SLAB);
        witheredpalmmosaicTexturePool.stairs(ModBlocks.WITHERED_PALM_MOSAIC_STAIRS);
        palmmosaicTexturePool.slab(ModBlocks.PALM_MOSAIC_SLAB);
        palmmosaicTexturePool.stairs(ModBlocks.PALM_MOSAIC_STAIRS);

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

        uploadPitcherModels(blockStateModelGenerator);
        registerCustomPitcherCrop(blockStateModelGenerator, ModBlocks.ACIDIC_PITCHER_CROP);
        registerCustomTall3DPlant(blockStateModelGenerator, ModBlocks.ACIDIC_PITCHER);

        registerLilyPad(blockStateModelGenerator, ModBlocks.WITHERED_LILY_PAD);
        registerLilyPad(blockStateModelGenerator, ModBlocks.CORRUPTED_LILY_PAD);

        // 1. Corrupted Mushroom Block (uses its own inside texture)
        registerCustomMushroomBlock(
                blockStateModelGenerator,
                ModBlocks.CORRUPTED_MUSHROOM_BLOCK,
                TextureMap.getId(ModBlocks.CORRUPTED_MUSHROOM_BLOCK),
                TextureMap.getSubId(ModBlocks.CORRUPTED_MUSHROOM_BLOCK, "_inside")
        );

// 2. Blackened Mushroom Block (shares Corrupted's inside texture)
        registerCustomMushroomBlock(
                blockStateModelGenerator,
                ModBlocks.BLACKENED_MUSHROOM_BLOCK,
                TextureMap.getId(ModBlocks.BLACKENED_MUSHROOM_BLOCK),
                TextureMap.getSubId(ModBlocks.CORRUPTED_MUSHROOM_BLOCK, "_inside")
        );

// 3. Acidic Mushroom Block (uses its own inside texture)
        registerCustomMushroomBlock(
                blockStateModelGenerator,
                ModBlocks.ACIDIC_MUSHROOM_BLOCK,
                TextureMap.getId(ModBlocks.ACIDIC_MUSHROOM_BLOCK),
                TextureMap.getSubId(ModBlocks.ACIDIC_MUSHROOM_BLOCK, "_inside")
        );



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
    }

    private void registerCustomPitcherCrop(BlockStateModelGenerator generator, Block cropBlock) {
        Identifier airModel = new Identifier("minecraft", "block/air");

        BlockStateVariantMap variantMap = BlockStateVariantMap.create(PitcherCropBlock.AGE, PitcherCropBlock.HALF)
                .register(0, DoubleBlockHalf.LOWER, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cropBlock, "_stage_0")))
                .register(0, DoubleBlockHalf.UPPER, BlockStateVariant.create().put(VariantSettings.MODEL, airModel))
                .register(1, DoubleBlockHalf.LOWER, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cropBlock, "_stage_1")))
                .register(1, DoubleBlockHalf.UPPER, BlockStateVariant.create().put(VariantSettings.MODEL, airModel))
                .register(2, DoubleBlockHalf.LOWER, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cropBlock, "_stage_2")))
                .register(2, DoubleBlockHalf.UPPER, BlockStateVariant.create().put(VariantSettings.MODEL, airModel))
                .register(3, DoubleBlockHalf.LOWER, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cropBlock, "_bottom_stage_3")))
                .register(3, DoubleBlockHalf.UPPER, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cropBlock, "_top_stage_3")))
                .register(4, DoubleBlockHalf.LOWER, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cropBlock, "_bottom_stage_4")))
                .register(4, DoubleBlockHalf.UPPER, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cropBlock, "_top_stage_4")));

        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(cropBlock).coordinate(variantMap));
    }

    private void registerCustomTall3DPlant(BlockStateModelGenerator generator, Block plantBlock) {
        BlockStateVariantMap variantMap = BlockStateVariantMap.create(TallFlowerBlock.HALF)
                .register(DoubleBlockHalf.LOWER, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(plantBlock, "_bottom")))
                .register(DoubleBlockHalf.UPPER, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(plantBlock, "_top")));

        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(plantBlock).coordinate(variantMap));
    }

    private static Model createPitcherBottomModel(String parent) {
        return new Model(Optional.of(new Identifier("minecraft", "block/" + parent)), Optional.empty(),
                TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE);
    }

    private static Model createPitcherTopModel(String parent) {
        return new Model(Optional.of(new Identifier("minecraft", "block/" + parent)), Optional.empty(),
                TextureKey.TOP, TextureKey.SIDE);
    }

    private void uploadPitcherModels(BlockStateModelGenerator generator) {
        Identifier bottom0 = new Identifier("crimson-moon", "block/acidic_pitcher_crop_bottom");
        Identifier bottom1 = new Identifier("crimson-moon", "block/acidic_pitcher_crop_bottom_stage_1");
        Identifier bottom2 = new Identifier("crimson-moon", "block/acidic_pitcher_crop_bottom_stage_2");
        Identifier bottom3 = new Identifier("crimson-moon", "block/acidic_pitcher_crop_bottom_stage_3");
        Identifier bottom4 = new Identifier("crimson-moon", "block/acidic_pitcher_crop_bottom_stage_4");

        Identifier topBase = new Identifier("crimson-moon", "block/acidic_pitcher_crop_top");
        Identifier top3 = new Identifier("crimson-moon", "block/acidic_pitcher_crop_top_stage_3");
        Identifier top4 = new Identifier("crimson-moon", "block/acidic_pitcher_crop_top_stage_4");
        Identifier side = new Identifier("crimson-moon", "block/acidic_pitcher_crop_side");

        // Crop stages 0 - 4
        createPitcherBottomModel("pitcher_crop_stage_0").upload(
                ModelIds.getBlockSubModelId(ModBlocks.ACIDIC_PITCHER_CROP, "_stage_0"),
                new TextureMap().put(TextureKey.BOTTOM, bottom0).put(TextureKey.TOP, topBase).put(TextureKey.SIDE, side),
                generator.modelCollector);

        createPitcherBottomModel("pitcher_crop_stage_1").upload(
                ModelIds.getBlockSubModelId(ModBlocks.ACIDIC_PITCHER_CROP, "_stage_1"),
                new TextureMap().put(TextureKey.BOTTOM, bottom1).put(TextureKey.TOP, topBase).put(TextureKey.SIDE, side),
                generator.modelCollector);

        createPitcherBottomModel("pitcher_crop_stage_2").upload(
                ModelIds.getBlockSubModelId(ModBlocks.ACIDIC_PITCHER_CROP, "_stage_2"),
                new TextureMap().put(TextureKey.BOTTOM, bottom2).put(TextureKey.TOP, topBase).put(TextureKey.SIDE, side),
                generator.modelCollector);

        createPitcherBottomModel("pitcher_crop_bottom_stage_3").upload(
                ModelIds.getBlockSubModelId(ModBlocks.ACIDIC_PITCHER_CROP, "_bottom_stage_3"),
                new TextureMap().put(TextureKey.BOTTOM, bottom3).put(TextureKey.TOP, topBase).put(TextureKey.SIDE, side),
                generator.modelCollector);

        createPitcherTopModel("pitcher_crop_top_stage_3").upload(
                ModelIds.getBlockSubModelId(ModBlocks.ACIDIC_PITCHER_CROP, "_top_stage_3"),
                new TextureMap().put(TextureKey.TOP, top3).put(TextureKey.SIDE, side),
                generator.modelCollector);

        createPitcherBottomModel("pitcher_crop_bottom_stage_4").upload(
                ModelIds.getBlockSubModelId(ModBlocks.ACIDIC_PITCHER_CROP, "_bottom_stage_4"),
                new TextureMap().put(TextureKey.BOTTOM, bottom4).put(TextureKey.TOP, topBase).put(TextureKey.SIDE, side),
                generator.modelCollector);

        createPitcherTopModel("pitcher_crop_top_stage_4").upload(
                ModelIds.getBlockSubModelId(ModBlocks.ACIDIC_PITCHER_CROP, "_top_stage_4"),
                new TextureMap().put(TextureKey.TOP, top4).put(TextureKey.SIDE, side),
                generator.modelCollector);

        // Mature 2-block-tall Acidic Pitcher flower
        createPitcherBottomModel("pitcher_plant_bottom").upload(
                ModelIds.getBlockSubModelId(ModBlocks.ACIDIC_PITCHER, "_bottom"),
                new TextureMap().put(TextureKey.BOTTOM, bottom4).put(TextureKey.TOP, topBase).put(TextureKey.SIDE, side),
                generator.modelCollector);

        createPitcherTopModel("pitcher_plant_top").upload(
                ModelIds.getBlockSubModelId(ModBlocks.ACIDIC_PITCHER, "_top"),
                new TextureMap().put(TextureKey.TOP, top4).put(TextureKey.SIDE, side),
                generator.modelCollector);
    }

    private void registerCustomMushroomBlock(BlockStateModelGenerator generator, Block block, Identifier outsideTexture, Identifier insideTexture) {
        // 1. Create the single-face model for the OUTSIDE (cap) texture
        Identifier outsideModel = Models.TEMPLATE_SINGLE_FACE.upload(
                block,
                "_outside",
                TextureMap.texture(outsideTexture),
                generator.modelCollector
        );

        // 2. Create the single-face model for the INSIDE (pore) texture
        Identifier insideModel = Models.TEMPLATE_SINGLE_FACE.upload(
                block,
                "_inside",
                TextureMap.texture(insideTexture),
                generator.modelCollector
        );

        // 3. Build the Multipart Blockstate mapping each direction (true = outside, false = inside)
        generator.blockStateCollector.accept(
                MultipartBlockStateSupplier.create(block)
                        // UP (Rotate 270 degrees on X-axis to point North face straight up)
                        .with(When.create().set(Properties.UP, true), BlockStateVariant.create().put(VariantSettings.MODEL, outsideModel).put(VariantSettings.X, VariantSettings.Rotation.R270))
                        .with(When.create().set(Properties.UP, false), BlockStateVariant.create().put(VariantSettings.MODEL, insideModel).put(VariantSettings.X, VariantSettings.Rotation.R270))
                        // DOWN (Rotate 90 degrees on X-axis to point North face straight down)
                        .with(When.create().set(Properties.DOWN, true), BlockStateVariant.create().put(VariantSettings.MODEL, outsideModel).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, true))
                        .with(When.create().set(Properties.DOWN, false), BlockStateVariant.create().put(VariantSettings.MODEL, insideModel).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, true))
                        // NORTH
                        .with(When.create().set(Properties.NORTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, outsideModel))
                        .with(When.create().set(Properties.NORTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, insideModel))
                        // SOUTH
                        .with(When.create().set(Properties.SOUTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, outsideModel).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                        .with(When.create().set(Properties.SOUTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, insideModel).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                        // EAST
                        .with(When.create().set(Properties.EAST, true), BlockStateVariant.create().put(VariantSettings.MODEL, outsideModel).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .with(When.create().set(Properties.EAST, false), BlockStateVariant.create().put(VariantSettings.MODEL, insideModel).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        // WEST
                        .with(When.create().set(Properties.WEST, true), BlockStateVariant.create().put(VariantSettings.MODEL, outsideModel).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                        .with(When.create().set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, insideModel).put(VariantSettings.Y, VariantSettings.Rotation.R270))
        );

        // 4. Register the inventory item model using the outside cap texture
        Identifier inventoryModel = Models.CUBE_ALL.upload(
                block,
                "_inventory",
                TextureMap.all(outsideTexture),
                generator.modelCollector
        );
        generator.registerParentedItemModel(block, inventoryModel);
    }




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
        itemModelGenerator.register(ModItems.HEAVENLY_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
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
        itemModelGenerator.register(ModBlocks.Turqite_Cluster.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.SMALL_TURQITE_BUD.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.MEDIUM_TURQITE_BUD.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.LARGE_TURQITE_BUD.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.CHARRED_FUNGUS.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.ACIDIC_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.CORRUPTED_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.PALM_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.WITHERED_PALM_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.ACIDIC_MUSHROOM.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.BLACKENED_MUSHROOM.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.CORRUPTED_MUSHROOM.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.PLUME_OF_CRIMSON, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORRUPTED_STAR, Models.GENERATED);

        itemModelGenerator.register(ModItems.GLOOM_BERRIES, Models.GENERATED);
        itemModelGenerator.register(ModItems.ACIDIC_LEATHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ACIDIC_BEEF, Models.GENERATED);

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

        itemModelGenerator.register(ModItems.ACIDIC_PITCHER_POD, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.ACIDIC_PITCHER.asItem(), Models.GENERATED);

        itemModelGenerator.register(ModBlocks.WITHERED_LILY_PAD.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.CORRUPTED_LILY_PAD.asItem(), Models.GENERATED);

        itemModelGenerator.register(ModItems.ACIDIC_LEATHER_HORSE_ARMOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.ACIDIC_SADDLE, Models.GENERATED);

        registerHornModel(itemModelGenerator, ModItems.THE_BEHEMOTHS_HORN);
    }

    private void registerHornModel(ItemModelGenerator generator, Item horn) {
        Identifier baseModelId = ModelIds.getItemModelId(horn);
        Identifier tootingModelId = baseModelId.withPrefixedPath("tooting_");
        // Both models reuse the same texture: assets/<mod_id>/textures/item/the_behemoths_horn.png
        Identifier textureId = TextureMap.getId(horn);

        // 1. Generate the "tooting_the_behemoths_horn.json" child model
        // Parent "minecraft:item/tooting_goat_horn" inherits the exact 1st/3rd-person mouth-raising display transforms
        generator.writer.accept(tootingModelId, () -> {
            JsonObject json = new JsonObject();
            json.addProperty("parent", "minecraft:item/tooting_goat_horn");

            JsonObject textures = new JsonObject();
            textures.addProperty("layer0", textureId.toString());
            json.add("textures", textures);

            return json;
        });

        // 2. Generate the main "the_behemoths_horn.json" model with the "tooting": 1 override
        // Parent "minecraft:item/goat_horn" inherits standard goat horn display transforms
        generator.writer.accept(baseModelId, () -> {
            JsonObject json = new JsonObject();
            json.addProperty("parent", "minecraft:item/goat_horn");

            JsonObject textures = new JsonObject();
            textures.addProperty("layer0", textureId.toString());
            json.add("textures", textures);

            JsonArray overrides = new JsonArray();
            JsonObject tootingOverride = new JsonObject();
            JsonObject predicate = new JsonObject();
            predicate.addProperty("tooting", 1);

            tootingOverride.add("predicate", predicate);
            tootingOverride.addProperty("model", tootingModelId.toString());
            overrides.add(tootingOverride);

            json.add("overrides", overrides);
            return json;
        });
    }

    private void registerLilyPad(BlockStateModelGenerator generator, Block lilyPad) {
        // Generates the block model using your block texture
        Identifier modelId = LILY_PAD_TEMPLATE.upload(
                lilyPad,
                TextureMap.texture(lilyPad),
                generator.modelCollector
        );

        // Generates the blockstate with random 0, 90, 180, and 270 degree rotations
        generator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(
                        lilyPad,
                        BlockStateModelGenerator.createModelVariantWithRandomHorizontalRotations(modelId)
                )
        );
    }
}