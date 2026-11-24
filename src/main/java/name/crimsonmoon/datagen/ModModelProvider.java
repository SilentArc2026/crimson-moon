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
import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.block.enums.SculkSensorPhase;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {

    private static final TextureKey LANTERN_KEY = TextureKey.of("lantern");

    private static final Model CUSTOM_LANTERN_TEMPLATE = new Model(
            Optional.of(new Identifier("minecraft", "block/template_lantern")),
            Optional.empty(),
            LANTERN_KEY
    );

    private static final Model CUSTOM_HANGING_LANTERN_TEMPLATE = new Model(
            Optional.of(new Identifier("minecraft", "block/template_hanging_lantern")),
            Optional.of("_hanging"),
            LANTERN_KEY
    );

    private static final TextureKey CACTUS_KEY = TextureKey.of("cactus");
    private static final TextureKey CACTUS_TOP_KEY = TextureKey.of("cactustop");

    private static final Model CACTUS_MODEL = new Model(
            Optional.of(new Identifier("minecraft", "block/cactus")),
            Optional.empty(),
            TextureKey.TOP, TextureKey.BOTTOM, TextureKey.SIDE, TextureKey.PARTICLE
    );


    private static final Model POTTED_CACTUS_MODEL = new Model(
            Optional.of(new Identifier("minecraft", "block/potted_cactus")),
            Optional.empty(),
            CACTUS_KEY, CACTUS_TOP_KEY
    );


    private static final TextureKey TENDRILS = TextureKey.of("tendrils");
    private static final TextureKey INNER_TOP = TextureKey.of("inner_top");

    private static final TextureKey SCULK_VEIN = TextureKey.of("sculk_vein");

    private static final Model VEIN_TEMPLATE = new Model(
            Optional.of(new Identifier("minecraft", "block/sculk_vein")),
            Optional.empty(),
            TextureKey.PARTICLE, SCULK_VEIN
    );

    // Parent model templates pointing to vanilla geometry
    private static final Model SENSOR_INACTIVE_TEMPLATE = new Model(
            Optional.of(new Identifier("minecraft", "block/sculk_sensor_inactive")),
            Optional.empty(),
            TextureKey.BOTTOM, TextureKey.SIDE, TextureKey.TOP, TENDRILS
    );
    private static final Model SENSOR_ACTIVE_TEMPLATE = new Model(
            Optional.of(new Identifier("minecraft", "block/sculk_sensor_active")),
            Optional.of("_active"),
            TextureKey.BOTTOM, TextureKey.SIDE, TextureKey.TOP, TENDRILS
    );
    private static final Model SHRIEKER_TEMPLATE = new Model(
            Optional.of(new Identifier("minecraft", "block/sculk_shrieker")),
            Optional.empty(),
            TextureKey.BOTTOM, TextureKey.SIDE, TextureKey.TOP, INNER_TOP
    );
    private static final Model SHRIEKER_CAN_SUMMON_TEMPLATE = new Model(
            Optional.of(new Identifier("minecraft", "block/sculk_shrieker_can_summon")),
            Optional.of("_can_summon"),
            TextureKey.BOTTOM, TextureKey.SIDE, TextureKey.TOP, INNER_TOP
    );

    private static final Model LILY_PAD_TEMPLATE = new Model(
            Optional.of(new Identifier("minecraft", "block/lily_pad")), Optional.empty(), TextureKey.TEXTURE);
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        Model chainModel = new Model(
                Optional.of(new Identifier("minecraft", "block/chain")),
                Optional.empty(),
                TextureKey.ALL,
                TextureKey.PARTICLE
        );

        TextureMap chainTextures = new TextureMap()
                .put(TextureKey.ALL, TextureMap.getId(ModBlocks.DARKSTEEL_CHAIN))
                .put(TextureKey.PARTICLE, TextureMap.getId(ModBlocks.DARKSTEEL_CHAIN));

        Identifier chainModelId = chainModel.upload(ModBlocks.DARKSTEEL_CHAIN, chainTextures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.DARKSTEEL_CHAIN, chainModelId);


        TextureMap cactusTextures = new TextureMap()
                .put(TextureKey.TOP, TextureMap.getSubId(ModBlocks.CRIMSON_CACTUS, "_top"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(ModBlocks.CRIMSON_CACTUS, "_bottom"))
                .put(TextureKey.SIDE, TextureMap.getSubId(ModBlocks.CRIMSON_CACTUS, "_side"))
                .put(TextureKey.PARTICLE, TextureMap.getSubId(ModBlocks.CRIMSON_CACTUS, "_side"));

        Identifier cactusModelId = CACTUS_MODEL.upload(ModBlocks.CRIMSON_CACTUS, cactusTextures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(
                BlockStateModelGenerator.createSingletonBlockState(ModBlocks.CRIMSON_CACTUS, cactusModelId)
        );

        // --- 2. POTTED CRIMSON CACTUS ---
        Identifier pottedModelId = new Identifier("crimson-moon", "block/potted_crimson_cactus");
        blockStateModelGenerator.modelCollector.accept(pottedModelId, () -> createPottedCactusJson(
                TextureMap.getSubId(ModBlocks.CRIMSON_CACTUS, "_side").toString(),
                TextureMap.getSubId(ModBlocks.CRIMSON_CACTUS, "_top").toString()
        ));
        blockStateModelGenerator.blockStateCollector.accept(
                BlockStateModelGenerator.createSingletonBlockState(ModBlocks.POTTED_CRIMSON_CACTUS, pottedModelId)
        );

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

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOOD_SCULK);

        // 2. Blood Sculk Catalyst (bloom = false / true)
        registerBloodSculkCatalyst(blockStateModelGenerator);

        // 3. Blood Sculk Sensor (inactive / active / cooldown)
        registerBloodSculkSensor(blockStateModelGenerator);

        // 4. Blood Sculk Shrieker (can_summon = false / true)
        registerBloodSculkShrieker(blockStateModelGenerator);

        // 5. Blood Sculk Vein (6-directional multipart)
        registerBloodSculkVein(blockStateModelGenerator);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CORRUPTED_REDSTONE_HEART);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DARKSTEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CORRUPTED_MOSS_BLOCK);
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
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CHARRED_FUNGUS, ModBlocks.POTTED_CHARRED_FUNGUS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.ACIDIC_MUSHROOM, ModBlocks.POTTED_ACIDIC_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CORRUPTED_MUSHROOM, ModBlocks.POTTED_CORRUPTED_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.BLACKENED_MUSHROOM, ModBlocks.POTTED_BLACKENED_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.DEAD_BLOOD_BUSH, ModBlocks.POTTED_DEAD_BLOOD_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED);
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
        blockStateModelGenerator.registerDoor(ModBlocks.DARKSTEEL_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.DARKSTEEL_TRAPDOOR);

        registerBerryVine(blockStateModelGenerator, ModBlocks.CHARRED_VINES);
        registerBerryVine(blockStateModelGenerator, ModBlocks.CHARRED_VINES_PLANT);

        uploadPitcherModels(blockStateModelGenerator);
        registerCustomPitcherCrop(blockStateModelGenerator, ModBlocks.ACIDIC_PITCHER_CROP);
        registerCustomTall3DPlant(blockStateModelGenerator, ModBlocks.ACIDIC_PITCHER);

        registerLilyPad(blockStateModelGenerator, ModBlocks.WITHERED_LILY_PAD);
        registerLilyPad(blockStateModelGenerator, ModBlocks.CORRUPTED_LILY_PAD);

        registerIronBars(blockStateModelGenerator, ModBlocks.DARKSTEEL_BARS);
        registerCustomLantern(blockStateModelGenerator, ModBlocks.DARKSTEEL_LANTERN);
        registerCustomLantern(blockStateModelGenerator, ModBlocks.DARKSTEEL_SOUL_LANTERN);

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
    private void registerBloodSculkCatalyst(BlockStateModelGenerator generator) {
        Block block = ModBlocks.BLOOD_SCULK_CATALYST;
        Identifier bottom = TextureMap.getSubId(block, "_bottom");

        TextureMap normalMap = new TextureMap()
                .put(TextureKey.BOTTOM, bottom)
                .put(TextureKey.SIDE, TextureMap.getSubId(block, "_side"))
                .put(TextureKey.TOP, TextureMap.getSubId(block, "_top"));

        TextureMap bloomMap = new TextureMap()
                .put(TextureKey.BOTTOM, bottom)
                .put(TextureKey.SIDE, TextureMap.getSubId(block, "_side_bloom"))
                .put(TextureKey.TOP, TextureMap.getSubId(block, "_top_bloom"));

        Identifier normalModel = Models.CUBE_BOTTOM_TOP.upload(block, normalMap, generator.modelCollector);
        Identifier bloomModel = Models.CUBE_BOTTOM_TOP.upload(block, "_bloom", bloomMap, generator.modelCollector);

        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block)
                .coordinate(BlockStateVariantMap.create(Properties.BLOOM)
                        .register(false, BlockStateVariant.create().put(VariantSettings.MODEL, normalModel))
                        .register(true, BlockStateVariant.create().put(VariantSettings.MODEL, bloomModel))
                ));
    }

    private void registerBloodSculkSensor(BlockStateModelGenerator generator) {
        Block block = ModBlocks.BLOOD_SCULK_SENSOR;
        Identifier bottom = TextureMap.getSubId(block, "_bottom");
        Identifier side = TextureMap.getSubId(block, "_side");
        Identifier top = TextureMap.getSubId(block, "_top");

        TextureMap inactiveMap = new TextureMap()
                .put(TextureKey.BOTTOM, bottom)
                .put(TextureKey.SIDE, side)
                .put(TextureKey.TOP, top)
                .put(TENDRILS, TextureMap.getSubId(block, "_tendril_inactive"));

        TextureMap activeMap = new TextureMap()
                .put(TextureKey.BOTTOM, bottom)
                .put(TextureKey.SIDE, side)
                .put(TextureKey.TOP, top)
                .put(TENDRILS, TextureMap.getSubId(block, "_tendril_active"));

        Identifier inactiveModel = SENSOR_INACTIVE_TEMPLATE.upload(block, inactiveMap, generator.modelCollector);
        Identifier activeModel = SENSOR_ACTIVE_TEMPLATE.upload(block, activeMap, generator.modelCollector);

        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block)
                .coordinate(BlockStateVariantMap.create(SculkSensorBlock.SCULK_SENSOR_PHASE)
                        .register(SculkSensorPhase.INACTIVE, BlockStateVariant.create().put(VariantSettings.MODEL, inactiveModel))
                        .register(SculkSensorPhase.ACTIVE, BlockStateVariant.create().put(VariantSettings.MODEL, activeModel))
                        .register(SculkSensorPhase.COOLDOWN, BlockStateVariant.create().put(VariantSettings.MODEL, inactiveModel))
                ));
    }

    private void registerBloodSculkShrieker(BlockStateModelGenerator generator) {
        Block block = ModBlocks.BLOOD_SCULK_SHRIEKER;
        Identifier bottom = TextureMap.getSubId(block, "_bottom");
        Identifier side = TextureMap.getSubId(block, "_side");
        Identifier top = TextureMap.getSubId(block, "_top");

        TextureMap normalMap = new TextureMap()
                .put(TextureKey.BOTTOM, bottom)
                .put(TextureKey.SIDE, side)
                .put(TextureKey.TOP, top)
                .put(INNER_TOP, TextureMap.getSubId(block, "_inner_top"));

        TextureMap summonMap = new TextureMap()
                .put(TextureKey.BOTTOM, bottom)
                .put(TextureKey.SIDE, side)
                .put(TextureKey.TOP, top)
                .put(INNER_TOP, TextureMap.getSubId(block, "_can_summon_inner_top"));

        Identifier normalModel = SHRIEKER_TEMPLATE.upload(block, normalMap, generator.modelCollector);
        Identifier summonModel = SHRIEKER_CAN_SUMMON_TEMPLATE.upload(block, summonMap, generator.modelCollector);

        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block)
                .coordinate(BlockStateVariantMap.create(SculkShriekerBlock.CAN_SUMMON)
                        .register(false, BlockStateVariant.create().put(VariantSettings.MODEL, normalModel))
                        .register(true, BlockStateVariant.create().put(VariantSettings.MODEL, summonModel))
                ));
    }


    private void registerBloodSculkVein(BlockStateModelGenerator generator) {
        Block block = ModBlocks.BLOOD_SCULK_VEIN;
        Identifier veinTex = TextureMap.getId(block);

        TextureMap veinMap = new TextureMap()
                .put(TextureKey.PARTICLE, veinTex)
                .put(SCULK_VEIN, veinTex); // <-- Use the exact same constant here

        Identifier modelId = VEIN_TEMPLATE.upload(block, veinMap, generator.modelCollector);


        // 6-way Multipart blockstate matching vanilla sculk_vein
        MultipartBlockStateSupplier supplier = MultipartBlockStateSupplier.create(block)
                .with(When.create().set(Properties.NORTH, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, modelId))
                .with(When.create().set(Properties.EAST, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, modelId)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, true))
                .with(When.create().set(Properties.SOUTH, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, modelId)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R180).put(VariantSettings.UVLOCK, true))
                .with(When.create().set(Properties.WEST, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, modelId)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R270).put(VariantSettings.UVLOCK, true))
                .with(When.create().set(Properties.UP, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, modelId)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.UVLOCK, true))
                .with(When.create().set(Properties.DOWN, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, modelId)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, true));

        // Fallback when all faces are false (default item/block preview state)
        When allFalse = When.create()
                .set(Properties.NORTH, false).set(Properties.EAST, false)
                .set(Properties.SOUTH, false).set(Properties.WEST, false)
                .set(Properties.UP, false).set(Properties.DOWN, false);

        supplier.with(allFalse, BlockStateVariant.create().put(VariantSettings.MODEL, modelId))
                .with(allFalse, BlockStateVariant.create().put(VariantSettings.MODEL, modelId).put(VariantSettings.Y, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, true))
                .with(allFalse, BlockStateVariant.create().put(VariantSettings.MODEL, modelId).put(VariantSettings.Y, VariantSettings.Rotation.R180).put(VariantSettings.UVLOCK, true))
                .with(allFalse, BlockStateVariant.create().put(VariantSettings.MODEL, modelId).put(VariantSettings.Y, VariantSettings.Rotation.R270).put(VariantSettings.UVLOCK, true))
                .with(allFalse, BlockStateVariant.create().put(VariantSettings.MODEL, modelId).put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.UVLOCK, true))
                .with(allFalse, BlockStateVariant.create().put(VariantSettings.MODEL, modelId).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, true));

        generator.blockStateCollector.accept(supplier);


    }

    private static com.google.gson.JsonObject createPottedCactusJson(String sideTex, String topTex) {
        com.google.gson.JsonObject root = new com.google.gson.JsonObject();
        root.addProperty("ambientocclusion", false);

        com.google.gson.JsonObject textures = new com.google.gson.JsonObject();
        textures.addProperty("particle", "minecraft:block/flower_pot");
        textures.addProperty("flowerpot", "minecraft:block/flower_pot");
        textures.addProperty("dirt", "minecraft:block/dirt");
        textures.addProperty("cactus", sideTex);
        textures.addProperty("cactustop", topTex);
        root.add("textures", textures);

        com.google.gson.JsonArray elements = new com.google.gson.JsonArray();

        // 1. Pot West Wall
        com.google.gson.JsonObject el1 = makeBox(5, 0, 5, 6, 6, 11);
        addFace(el1, "down", 5, 5, 6, 11, "#flowerpot", "down");
        addFace(el1, "up", 5, 5, 6, 11, "#flowerpot", null);
        addFace(el1, "north", 10, 10, 11, 16, "#flowerpot", null);
        addFace(el1, "south", 5, 10, 6, 16, "#flowerpot", null);
        addFace(el1, "west", 5, 10, 11, 16, "#flowerpot", null);
        addFace(el1, "east", 5, 10, 11, 16, "#flowerpot", null);
        elements.add(el1);

        // 2. Pot East Wall
        com.google.gson.JsonObject el2 = makeBox(10, 0, 5, 11, 6, 11);
        addFace(el2, "down", 10, 5, 11, 11, "#flowerpot", "down");
        addFace(el2, "up", 10, 5, 11, 11, "#flowerpot", null);
        addFace(el2, "north", 5, 10, 6, 16, "#flowerpot", null);
        addFace(el2, "south", 10, 10, 11, 16, "#flowerpot", null);
        addFace(el2, "west", 5, 10, 11, 16, "#flowerpot", null);
        addFace(el2, "east", 5, 10, 11, 16, "#flowerpot", null);
        elements.add(el2);

        // 3. Pot North Wall
        com.google.gson.JsonObject el3 = makeBox(6, 0, 5, 10, 6, 6);
        addFace(el3, "down", 6, 10, 10, 11, "#flowerpot", "down");
        addFace(el3, "up", 6, 5, 10, 6, "#flowerpot", null);
        addFace(el3, "north", 6, 10, 10, 16, "#flowerpot", null);
        addFace(el3, "south", 6, 10, 10, 16, "#flowerpot", null);
        elements.add(el3);

        // 4. Pot South Wall
        com.google.gson.JsonObject el4 = makeBox(6, 0, 10, 10, 6, 11);
        addFace(el4, "down", 6, 5, 10, 6, "#flowerpot", "down");
        addFace(el4, "up", 6, 10, 10, 11, "#flowerpot", null);
        addFace(el4, "north", 6, 10, 10, 16, "#flowerpot", null);
        addFace(el4, "south", 6, 10, 10, 16, "#flowerpot", null);
        elements.add(el4);

        // 5. Pot Bottom
        com.google.gson.JsonObject el5 = makeBox(6, 0, 6, 10, 1, 10);
        addFace(el5, "down", 6, 6, 10, 10, "#flowerpot", "down");
        elements.add(el5);

        // 6. Dirt
        com.google.gson.JsonObject el6 = makeBox(6, 1, 6, 10, 4, 10);
        addFace(el6, "up", 6, 6, 10, 10, "#dirt", null);
        elements.add(el6);

        // 7. Cactus Body & Custom Top
        com.google.gson.JsonObject el7 = makeBox(6, 4, 6, 10, 16, 10);
        addFace(el7, "up", 6, 6, 10, 10, "#cactustop", "up");
        addFace(el7, "north", 6, 4, 10, 16, "#cactus", null);
        addFace(el7, "south", 6, 4, 10, 16, "#cactus", null);
        addFace(el7, "west", 6, 4, 10, 16, "#cactus", null);
        addFace(el7, "east", 6, 4, 10, 16, "#cactus", null);
        elements.add(el7);

        root.add("elements", elements);
        return root;
    }

    private static com.google.gson.JsonObject makeBox(int x1, int y1, int z1, int x2, int y2, int z2) {
        com.google.gson.JsonObject box = new com.google.gson.JsonObject();
        com.google.gson.JsonArray from = new com.google.gson.JsonArray();
        from.add(x1); from.add(y1); from.add(z1);
        com.google.gson.JsonArray to = new com.google.gson.JsonArray();
        to.add(x2); to.add(y2); to.add(z2);
        box.add("from", from);
        box.add("to", to);
        box.add("faces", new com.google.gson.JsonObject());
        return box;
    }

    private static void addFace(com.google.gson.JsonObject box, String dir, int u1, int v1, int u2, int v2, String tex, String cull) {
        com.google.gson.JsonObject face = new com.google.gson.JsonObject();
        com.google.gson.JsonArray uv = new com.google.gson.JsonArray();
        uv.add(u1); uv.add(v1); uv.add(u2); uv.add(v2);
        face.add("uv", uv);
        face.addProperty("texture", tex);
        if (cull != null) {
            face.addProperty("cullface", cull);
        }
        box.getAsJsonObject("faces").add(dir, face);
    }

    private static final TextureKey BARS = TextureKey.of("bars");

    private void registerIronBars(BlockStateModelGenerator generator, Block barsBlock) {
        Identifier texture = TextureMap.getId(barsBlock);
        TextureMap textures = new TextureMap()
                .put(BARS, texture)
                .put(TextureKey.EDGE, texture)
                .put(TextureKey.PARTICLE, texture);

        Identifier postEnds = createBarsModel(generator, barsBlock, "_post_ends", "iron_bars_post_ends", textures);
        Identifier post = createBarsModel(generator, barsBlock, "_post", "iron_bars_post", textures);
        Identifier cap = createBarsModel(generator, barsBlock, "_cap", "iron_bars_cap", textures);
        Identifier capAlt = createBarsModel(generator, barsBlock, "_cap_alt", "iron_bars_cap_alt", textures);
        Identifier side = createBarsModel(generator, barsBlock, "_side", "iron_bars_side", textures);
        Identifier sideAlt = createBarsModel(generator, barsBlock, "_side_alt", "iron_bars_side_alt", textures);

        generator.blockStateCollector.accept(MultipartBlockStateSupplier.create(barsBlock)
                .with(BlockStateVariant.create().put(VariantSettings.MODEL, postEnds))
                .with(When.create().set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, false),
                        BlockStateVariant.create().put(VariantSettings.MODEL, post))
                .with(When.create().set(Properties.NORTH, true).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, false),
                        BlockStateVariant.create().put(VariantSettings.MODEL, cap))
                .with(When.create().set(Properties.NORTH, false).set(Properties.EAST, true).set(Properties.SOUTH, false).set(Properties.WEST, false),
                        BlockStateVariant.create().put(VariantSettings.MODEL, cap).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create().set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, true).set(Properties.WEST, false),
                        BlockStateVariant.create().put(VariantSettings.MODEL, capAlt))
                .with(When.create().set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, capAlt).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create().set(Properties.NORTH, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, side))
                .with(When.create().set(Properties.EAST, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, side).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create().set(Properties.SOUTH, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, sideAlt))
                .with(When.create().set(Properties.WEST, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, sideAlt).put(VariantSettings.Y, VariantSettings.Rotation.R90)));
    }

    private Identifier createBarsModel(BlockStateModelGenerator generator, Block block, String suffix, String vanillaParent, TextureMap textures) {
        Model template = new Model(Optional.of(new Identifier("minecraft", "block/" + vanillaParent)), Optional.of(suffix), BARS, TextureKey.EDGE, TextureKey.PARTICLE);
        return template.upload(block, suffix, textures, generator.modelCollector);
    }
    private void registerCustomLantern(BlockStateModelGenerator generator, Block lanternBlock) {
        TextureMap textureMap = new TextureMap().put(LANTERN_KEY, TextureMap.getId(lanternBlock));

        Identifier standingModel = CUSTOM_LANTERN_TEMPLATE.upload(lanternBlock, textureMap, generator.modelCollector);
        Identifier hangingModel = CUSTOM_HANGING_LANTERN_TEMPLATE.upload(lanternBlock, textureMap, generator.modelCollector);

        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(lanternBlock)
                .coordinate(BlockStateVariantMap.create(Properties.HANGING)
                        .register(false, BlockStateVariant.create().put(VariantSettings.MODEL, standingModel))
                        .register(true, BlockStateVariant.create().put(VariantSettings.MODEL, hangingModel))));
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
        itemModelGenerator.register(ModItems.CRIMSON_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VAMPYRITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_VAMPYRITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOLARIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLARIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLARIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLARIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLARIUM_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VAMPYRITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VAMPYRITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VAMPYRITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VAMPYRITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VAMPYRITE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_ROD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOLARIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOLARIUM_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOLAR_STAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQITE_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQITE_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAVENLY_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.REFINED_TURQITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQITE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HEAVENLY_BLADE, Models.HANDHELD);
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
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.DARKSTEEL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.DARKSTEEL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.DARKSTEEL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.DARKSTEEL_BOOTS));
        itemModelGenerator.register(ModBlocks.Turqite_Cluster.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.SMALL_TURQITE_BUD.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.MEDIUM_TURQITE_BUD.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.LARGE_TURQITE_BUD.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.ACIDIC_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.CORRUPTED_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.PALM_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.WITHERED_PALM_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.PLUME_OF_CRIMSON, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORRUPTED_STAR, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.BLOOD_SCULK_VEIN.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.DARKSTEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DARKSTEEL_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DARKSTEEL_HATCHET, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DARKSTEEL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DARKSTEEL_SPADE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DARKSTEEL_TROWEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DARKSTEEL_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.DARKSTEEL_BARS.asItem(), Models.GENERATED);

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
        itemModelGenerator.register(ModItems.DARKSTEEL_HORSE_ARMOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.ACIDIC_SADDLE, Models.GENERATED);

        itemModelGenerator.register(ModBlocks.DARKSTEEL_LANTERN.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.DARKSTEEL_SOUL_LANTERN.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.DARKSTEEL_CHAIN.asItem(), Models.GENERATED);

        itemModelGenerator.register(ModItems.LEATHER_BRACERS, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHAIN_FISHNETS, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_BRACERS, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_BRACERS, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_BRACERS, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_BRACERS, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRIMSON_BRACERS, Models.GENERATED);
        itemModelGenerator.register(ModItems.DARKSTEEL_BRACERS, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQITE_BRACERS, Models.GENERATED);
        itemModelGenerator.register(ModItems.VAMPYRITE_BRACERS, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOLARIUM_BRACERS, Models.GENERATED);


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