package name.crimsonmoon.datagen;

import name.crimsonmoon.block.ModBlocks;
import name.crimsonmoon.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PitcherCropBlock;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.AlternativeEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.state.property.Properties;

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
        addDrop(ModBlocks.PALM_DOOR, doorDrops(ModBlocks.PALM_DOOR));
        addDrop(ModBlocks.PALM_SLAB, slabDrops(ModBlocks.PALM_SLAB));
        addDrop(ModBlocks.WITHERED_PALM_DOOR, doorDrops(ModBlocks.WITHERED_PALM_DOOR));
        addDrop(ModBlocks.WITHERED_PALM_SLAB, slabDrops(ModBlocks.WITHERED_PALM_SLAB));
        addDrop(ModBlocks.ACIDIC_SLAB, slabDrops(ModBlocks.ACIDIC_SLAB));
        addDrop(ModBlocks.Turqite_Cluster, drops(ModItems.TURQITE_CRYSTAL));
        addDrop(ModBlocks.CORRUPTED_GRASS_BLOCK, dropsWithSilkTouch(ModBlocks.CORRUPTED_GRASS_BLOCK, ItemEntry.builder(ModBlocks.CORRUPTED_DIRT)));
        addDrop(ModBlocks.ACIDIC_GRASS_BLOCK, dropsWithSilkTouch(ModBlocks.ACIDIC_GRASS_BLOCK, ItemEntry.builder(ModBlocks.ACIDIC_DIRT)));
        addDrop(ModBlocks.ACIDIC_GRASS, grassDrops(ModBlocks.ACIDIC_GRASS));
        addDrop(ModBlocks.ACIDIC_TALL_GRASS, block -> tallGrassDrops(block, Blocks.AIR));
        addDrop(ModBlocks.CORRUPTED_TALL_GRASS, block -> tallGrassDrops(block, Blocks.AIR));
        addDrop(ModBlocks.ACIDIC_LEAVES, leavesDrops(ModBlocks.ACIDIC_LEAVES, ModBlocks.ACIDIC_SAPLING, 0.5f));
        addDrop(ModBlocks.CORRUPTED_LEAVES, leavesDrops(ModBlocks.CORRUPTED_LEAVES, ModBlocks.CORRUPTED_SAPLING, 0.5f));
        addDrop(ModBlocks.WITHERED_PALM_LEAVES, leavesDrops(ModBlocks.WITHERED_PALM_LEAVES, ModBlocks.WITHERED_PALM_SAPLING, 0.5f));
        addDrop(ModBlocks.CHARRED_WART_BLOCK);
        addDrop(ModBlocks.ACIDIC_LILAC, dropsWithProperty(ModBlocks.ACIDIC_LILAC, TallFlowerBlock.HALF, DoubleBlockHalf.LOWER));
        addDrop(ModBlocks.CAT_TAILS, dropsWithProperty(ModBlocks.CAT_TAILS, TallFlowerBlock.HALF, DoubleBlockHalf.LOWER));
        addDrop(ModBlocks.WITHERED_CAT_TAILS, dropsWithProperty(ModBlocks.WITHERED_CAT_TAILS, TallFlowerBlock.HALF, DoubleBlockHalf.LOWER));
        addDrop(ModBlocks.CORRUPTED_CLOSED_EYEBLOSSOM);
        addDrop(ModBlocks.CORRUPTED_OPEN_EYEBLOSSOM);
        addDrop(ModBlocks.CORRUPTED_REDSTONE_HEART);
        addDrop(ModBlocks.GLOOMLIGHT);
        addDrop(ModBlocks.CORRUPTED_WITHER_ROSE);
        addDrop(ModBlocks.PALM_LOG);
        addDrop(ModBlocks.PALM_WOOD);
        addDrop(ModBlocks.STRIPPED_PALM_LOG);
        addDrop(ModBlocks.STRIPPED_PALM_WOOD);
        addDrop(ModBlocks.PALM_PLANKS);
        addDrop(ModBlocks.PALM_STAIRS);
        addDrop(ModBlocks.PALM_BUTTON);
        addDrop(ModBlocks.PALM_PRESSURE_PLATE);
        addDrop(ModBlocks.PALM_FENCE);
        addDrop(ModBlocks.PALM_FENCE_GATE);
        addDrop(ModBlocks.PALM_TRAPDOOR);
        addDrop(ModBlocks.WITHERED_PALM_STAIRS);
        addDrop(ModBlocks.WITHERED_PALM_BUTTON);
        addDrop(ModBlocks.WITHERED_PALM_PRESSURE_PLATE);
        addDrop(ModBlocks.WITHERED_PALM_FENCE);
        addDrop(ModBlocks.WITHERED_PALM_FENCE_GATE);
        addDrop(ModBlocks.WITHERED_PALM_TRAPDOOR);
        addDrop(ModBlocks.PALM_SIGN);
        addDrop(ModBlocks.PALM_HANGING_SIGN);
        addDrop(ModBlocks.PALM_SAPLING);
        addDrop(ModBlocks.WITHERED_PALM_LOG);
        addDrop(ModBlocks.WITHERED_PALM_WOOD);
        addDrop(ModBlocks.STRIPPED_WITHERED_PALM_LOG);
        addDrop(ModBlocks.STRIPPED_WITHERED_PALM_WOOD);
        addDrop(ModBlocks.WITHERED_PALM_PLANKS);
        addDrop(ModBlocks.WITHERED_PALM_SAPLING);
        addDrop(ModBlocks.WITHERED_PALM_SIGN);
        addDrop(ModBlocks.WITHERED_PALM_HANGING_SIGN);
        addDrop(ModBlocks.ACIDIC_PITCHER, block -> dropsWithProperty(block, TallFlowerBlock.HALF, DoubleBlockHalf.LOWER));
        addDrop(ModBlocks.CORRUPTED_TORCHFLOWER);
        addDrop(ModBlocks.PINK_FLOWER);
        addDrop(ModBlocks.FIRE_FLOWER);
        addDrop(ModBlocks.CORRUPTED_LILY_PAD);
        addDrop(ModBlocks.WITHERED_LILY_PAD);
        addDropWithSilkTouch(ModBlocks.ACIDIC_MUSHROOM_BLOCK);
        addDropWithSilkTouch(ModBlocks.BLACKENED_MUSHROOM_BLOCK);
        addDropWithSilkTouch(ModBlocks.CORRUPTED_MUSHROOM_BLOCK);
        addDropWithSilkTouch(ModBlocks.ACIDIC_MUSHROOM_STEM);
        addDropWithSilkTouch(ModBlocks.CORRUPTED_MUSHROOM_STEM);
        addDrop(ModBlocks.CORRUPTED_MUSHROOM);
        addDrop(ModBlocks.BLACKENED_MUSHROOM);
        addDrop(ModBlocks.ACIDIC_MUSHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_CORRUPTED_TORCHFLOWER);
        addPottedPlantDrops(ModBlocks.POTTED_FIRE_FLOWER);
        addDrop(ModBlocks.CORRUPTED_TORCHFLOWER_CROP, ModItems.CORRUPTED_TORCHFLOWER_SEEDS);
        addDrop(ModBlocks.BUSH, silkTouchOrShearsDrop(ModBlocks.BUSH));
        addDrop(ModBlocks.WILD_BUSH, silkTouchOrShearsDrop(ModBlocks.WILD_BUSH));
        addDrop(ModBlocks.WEEDS, silkTouchOrShearsDrop(ModBlocks.WEEDS));
        addDrop(ModBlocks.WITHERED_BUSH, silkTouchOrShearsDrop(ModBlocks.WITHERED_BUSH));
        addDrop(ModBlocks.WITHERED_WILD_BUSH, silkTouchOrShearsDrop(ModBlocks.WITHERED_WILD_BUSH));
        addDrop(ModBlocks.WITHERED_WEEDS, silkTouchOrShearsDrop(ModBlocks.WITHERED_WEEDS));

        BlockStatePropertyLootCondition.Builder isMaturePitcher = BlockStatePropertyLootCondition.builder(ModBlocks.ACIDIC_PITCHER_CROP)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(PitcherCropBlock.AGE, 4)
                        .exactMatch(PitcherCropBlock.HALF, DoubleBlockHalf.LOWER));

        BlockStatePropertyLootCondition.Builder isLowerPitcherCrop = BlockStatePropertyLootCondition.builder(ModBlocks.ACIDIC_PITCHER_CROP)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(PitcherCropBlock.HALF, DoubleBlockHalf.LOWER));

        addDrop(ModBlocks.ACIDIC_PITCHER_CROP, LootTable.builder().pool(
                addSurvivesExplosionCondition(ModBlocks.ACIDIC_PITCHER_CROP, LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0f))
                        .with(AlternativeEntry.builder(
                                ItemEntry.builder(ModBlocks.ACIDIC_PITCHER).conditionally(isMaturePitcher),
                                ItemEntry.builder(ModItems.ACIDIC_PITCHER_POD).conditionally(isLowerPitcherCrop)
                        ))
                )
        ));

        addPottedPlantDrops(ModBlocks.POTTED_CORRUPTED_OPEN_EYEBLOSSOM);
        addPottedPlantDrops(ModBlocks.POTTED_CORRUPTED_CLOSED_EYEBLOSSOM);
        addPottedPlantDrops(ModBlocks.POTTED_ACID_FLOWER);
        addPottedPlantDrops(ModBlocks.POTTED_CORRUPTED_POPPY);
        addPottedPlantDrops(ModBlocks.POTTED_CORRUPTED_WITHER_ROSE);
        addPottedPlantDrops(ModBlocks.POTTED_PINK_FLOWER);

        addDrop(ModBlocks.Vampyrite_Ore, oreDrops(ModBlocks.Vampyrite_Ore, ModItems.RAW_VAMPYRITE));
        addDrop(ModBlocks.Deepslate_Vampyrite_Ore, oreDrops(ModBlocks.Deepslate_Vampyrite_Ore, ModItems.RAW_VAMPYRITE));
        addDrop(ModBlocks.Smooth_Basalt_Turqite_Ore, oreDrops(ModBlocks.Smooth_Basalt_Turqite_Ore, ModItems.TURQITE_CRYSTAL));

        addDrop(ModBlocks.CHARRED_VINES, berryVineDrops(ModBlocks.CHARRED_VINES));
        addDrop(ModBlocks.CHARRED_VINES_PLANT, berryVineDrops(ModBlocks.CHARRED_VINES_PLANT));


    }



    private LootTable.Builder berryVineDrops(Block vineBlock) {
        return LootTable.builder().pool(
                LootPool.builder()
                        .with(ItemEntry.builder(ModItems.GLOOM_BERRIES))
                        .conditionally(
                                BlockStatePropertyLootCondition.builder(vineBlock)
                                        .properties(StatePredicate.Builder.create().exactMatch(Properties.BERRIES, true))
                        )
        );
    }

    private LootTable.Builder silkTouchOrShearsDrop(Block block) {
        return LootTable.builder()
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0f))
                        .conditionally(WITH_SILK_TOUCH_OR_SHEARS)
                        .with(ItemEntry.builder(block))
                );
    }
}
