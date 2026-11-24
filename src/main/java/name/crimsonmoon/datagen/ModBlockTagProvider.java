package name.crimsonmoon.datagen;

import name.crimsonmoon.block.ModBlocks;
import name.crimsonmoon.item.ModItems;
import name.crimsonmoon.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.mininglevel.v1.FabricMineableTags;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.DARKSTEEL_CHAIN, ModBlocks.DARKSTEEL_LANTERN, ModBlocks.DARKSTEEL_SOUL_LANTERN, ModBlocks.DARKSTEEL_BARS, ModBlocks.CORRUPTED_REDSTONE_HEART, ModBlocks.Crimsonite_Block, ModBlocks.Solarium_Block, ModBlocks.Deepslate_Vampyrite_Ore, ModBlocks.Raw_Vampyrite_Block, ModBlocks.Vampyrite_Block, ModBlocks.Vampyrite_Ore, ModBlocks.Budding_Crystalized_Turqite_Block, ModBlocks.Crystalized_Turqite_Block, ModBlocks.Refined_Turqite_Block, ModBlocks.Smooth_Basalt_Turqite_Ore, ModBlocks.Turqite_Bricks, ModBlocks.Turqite_Crystal_Block, ModBlocks.Turqite_Cluster, ModBlocks.BLACK_SANDSTONE, ModBlocks.CUT_BLACK_SANDSTONE, ModBlocks.CHISELED_BLACK_SANDSTONE, ModBlocks.SMOOTH_BLACK_SANDSTONE, ModBlocks.BLACK_SANDSTONE_STAIRS, ModBlocks.BLACK_SANDSTONE_SLAB, ModBlocks.BLACK_SANDSTONE_WALL, ModBlocks.CUT_BLACK_SANDSTONE_SLAB, ModBlocks.CUT_BLACK_SANDSTONE_STAIRS, ModBlocks.SMOOTH_BLACK_SANDSTONE_SLAB, ModBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.Crimsonite_Block, ModBlocks.Solarium_Block, ModBlocks.CORRUPTED_REDSTONE_HEART, ModBlocks.DARKSTEEL_BLOCK, ModBlocks.DARKSTEEL_DOOR, ModBlocks.DARKSTEEL_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.Vampyrite_Ore, ModBlocks.Vampyrite_Block, ModBlocks.Raw_Vampyrite_Block, ModBlocks.Deepslate_Vampyrite_Ore, ModBlocks.Budding_Crystalized_Turqite_Block, ModBlocks.Crystalized_Turqite_Block, ModBlocks.Refined_Turqite_Block, ModBlocks.Smooth_Basalt_Turqite_Ore, ModBlocks.Turqite_Bricks, ModBlocks.Turqite_Crystal_Block, ModBlocks.Turqite_Cluster);
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.DOLOMITE, ModBlocks.POLISHED_DOLOMITE, ModBlocks.DOLOMITE_BRICKS, ModBlocks.DARKSTEEL_BARS);
        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.WITHERED_PALM_PRESSURE_PLATE, ModBlocks.PALM_PRESSURE_PLATE, ModBlocks.CHARRED_PRESSURE_PLATE, ModBlocks.ACIDIC_PRESSURE_PLATE, ModBlocks.ACIDIC_PRESSURE_PLATE, ModBlocks.ACIDIC_TRAPPED_RUG);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.CORRUPTED_SLAB, ModBlocks.CORRUPTED_STAIRS, ModBlocks.ACIDIC_SLAB, ModBlocks.ACIDIC_STAIRS, ModBlocks.ACIDIC_FENCE, ModBlocks.ACIDIC_FENCE_GATE, ModBlocks.CORRUPTED_FENCE, ModBlocks.CORRUPTED_FENCE_GATE, ModBlocks.ACIDIC_DOOR, ModBlocks.CORRUPTED_DOOR, ModBlocks.ACIDIC_TRAPDOOR, ModBlocks.CORRUPTED_TRAPDOOR, ModBlocks.CHARRED_STAIRS, ModBlocks.CHARRED_SLAB, ModBlocks.CHARRED_BUTTON, ModBlocks.CHARRED_PRESSURE_PLATE, ModBlocks.CHARRED_FENCE, ModBlocks.CHARRED_FENCE_GATE, ModBlocks.CHARRED_DOOR, ModBlocks.CHARRED_TRAPDOOR, ModBlocks.PALM_STAIRS, ModBlocks.PALM_SLAB, ModBlocks.PALM_BUTTON, ModBlocks.PALM_PRESSURE_PLATE, ModBlocks.PALM_FENCE, ModBlocks.PALM_FENCE_GATE, ModBlocks.PALM_DOOR, ModBlocks.PALM_TRAPDOOR, ModBlocks.WITHERED_PALM_STAIRS, ModBlocks.WITHERED_PALM_SLAB, ModBlocks.WITHERED_PALM_BUTTON, ModBlocks.WITHERED_PALM_PRESSURE_PLATE, ModBlocks.WITHERED_PALM_FENCE, ModBlocks.WITHERED_PALM_FENCE_GATE, ModBlocks.WITHERED_PALM_DOOR, ModBlocks.WITHERED_PALM_TRAPDOOR, ModBlocks.PALM_MOSAIC, ModBlocks.PALM_MOSAIC_SLAB, ModBlocks.PALM_MOSAIC_STAIRS, ModBlocks.WITHERED_PALM_MOSAIC, ModBlocks.WITHERED_PALM_MOSAIC_SLAB, ModBlocks.WITHERED_PALM_MOSAIC_STAIRS);
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.CORRUPTED_FENCE, ModBlocks.ACIDIC_FENCE, ModBlocks.CHARRED_FENCE, ModBlocks.PALM_FENCE, ModBlocks.WITHERED_PALM_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.CORRUPTED_FENCE_GATE, ModBlocks.ACIDIC_FENCE_GATE, ModBlocks.CHARRED_FENCE_GATE, ModBlocks.PALM_FENCE_GATE, ModBlocks.WITHERED_PALM_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.CORRUPTED_DIRT, ModBlocks.CORRUPTED_GRASS_BLOCK, ModBlocks.ACIDIC_DIRT, ModBlocks.ACIDIC_GRASS_BLOCK, ModBlocks.BLACK_SAND, ModBlocks.WET_BLACK_SAND, ModBlocks.WET_RED_SAND, ModBlocks.WET_SAND);
        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(ModBlocks.CORRUPTED_DIRT, ModBlocks.CORRUPTED_GRASS_BLOCK, ModBlocks.ACIDIC_GRASS_BLOCK, ModBlocks.ACIDIC_DIRT);
        getOrCreateTagBuilder(BlockTags.REPLACEABLE_BY_TREES)
                .add(ModBlocks.CAT_TAILS, ModBlocks.CORRUPTED_TALL_GRASS, ModBlocks.CORRUPTED_GRASS, ModBlocks.ACIDIC_TALL_GRASS, ModBlocks.ACIDIC_GRASS, ModBlocks.BUSH, ModBlocks.WILD_BUSH, ModBlocks.WEEDS, ModBlocks.WITHERED_BUSH, ModBlocks.WITHERED_WILD_BUSH, ModBlocks.WITHERED_WEEDS, ModBlocks.WITHERED_CAT_TAILS);
        getOrCreateTagBuilder(BlockTags.TALL_FLOWERS)
                .add(ModBlocks.CORRUPTED_TALL_GRASS, ModBlocks.ACIDIC_TALL_GRASS, ModBlocks.CAT_TAILS, ModBlocks.WITHERED_CAT_TAILS);
        getOrCreateTagBuilder(BlockTags.TALL_FLOWERS)
                .add(ModBlocks.ACIDIC_LILAC, ModBlocks.ACIDIC_PITCHER);
        getOrCreateTagBuilder(BlockTags.CROPS)
                .add(ModBlocks.ACIDIC_PITCHER_CROP);
        getOrCreateTagBuilder(FabricMineableTags.SHEARS_MINEABLE)
                .add(ModBlocks.ACIDIC_TRAPPED_RUG);
        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
                .add(ModBlocks.DEAD_BLOOD_BUSH, ModBlocks.FIRE_FLOWER, ModBlocks.ACID_FLOWER, ModBlocks.CORRUPTED_POPPY, ModBlocks.CORRUPTED_OPEN_EYEBLOSSOM, ModBlocks.CORRUPTED_WITHER_ROSE, ModBlocks.PINK_FLOWER);
        getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                .add(ModBlocks.CHARRED_VINES, ModBlocks.CHARRED_VINES_PLANT);
        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.ACIDIC_LEAVES, ModBlocks.CORRUPTED_LEAVES, ModBlocks.PALM_LEAVES, ModBlocks.WITHERED_PALM_LEAVES);
        getOrCreateTagBuilder(BlockTags.REPLACEABLE)
                .add(ModBlocks.DEAD_BLOOD_BUSH, ModBlocks.WEEDS, ModBlocks.WILD_BUSH, ModBlocks.BUSH, ModBlocks.CAT_TAILS, ModBlocks.WITHERED_BUSH, ModBlocks.WITHERED_WILD_BUSH, ModBlocks.WITHERED_WEEDS, ModBlocks.WITHERED_CAT_TAILS);
        getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT)
                .add(ModBlocks.BUSH, ModBlocks.WILD_BUSH, ModBlocks.WEEDS, ModBlocks.CAT_TAILS, ModBlocks.WITHERED_BUSH, ModBlocks.WITHERED_WILD_BUSH, ModBlocks.WITHERED_WEEDS, ModBlocks.WITHERED_CAT_TAILS);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.BLACK_SANDSTONE_WALL);
        getOrCreateTagBuilder(BlockTags.DAMPENS_VIBRATIONS)
                .add(ModBlocks.BLOOD_SCULK_SENSOR);
        getOrCreateTagBuilder(BlockTags.SAND)
                .add(ModBlocks.BLACK_SAND, ModBlocks.WET_SAND, ModBlocks.WET_RED_SAND, ModBlocks.WET_BLACK_SAND);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.BLOOD_SCULK, ModBlocks.BLOOD_SCULK_CATALYST, ModBlocks.BLOOD_SCULK_SENSOR, ModBlocks.BLOOD_SCULK_SHRIEKER, ModBlocks.BLOOD_SCULK_VEIN);

        //Tag for Custom Tool Material for Crimson
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric","needs_tool_level_5")))
                .add(ModBlocks.Crimsonite_Block, ModBlocks.Solarium_Block);
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric","needs_iron_tool")))
                .add(ModBlocks.Vampyrite_Block, ModBlocks.Vampyrite_Ore, ModBlocks.Raw_Vampyrite_Block, ModBlocks.Deepslate_Vampyrite_Ore, ModBlocks.Budding_Crystalized_Turqite_Block, ModBlocks.Crystalized_Turqite_Block, ModBlocks.Refined_Turqite_Block, ModBlocks.Smooth_Basalt_Turqite_Ore, ModBlocks.Turqite_Bricks, ModBlocks.Turqite_Crystal_Block);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.CHARRED_WOOD, ModBlocks.STRIPPED_CHARRED_LOG, ModBlocks.STRIPPED_CHARRED_WOOD, ModBlocks.CHARRED_LOG, ModBlocks.CORRUPTED_LOG, ModBlocks.CORRUPTED_WOOD, ModBlocks.STRIPPED_CORRUPTED_LOG, ModBlocks.STRIPPED_CORRUPTED_WOOD, ModBlocks.ACIDIC_LOG, ModBlocks.ACIDIC_WOOD, ModBlocks.STRIPPED_ACIDIC_LOG, ModBlocks.STRIPPED_ACIDIC_WOOD, ModBlocks.PALM_LOG, ModBlocks.PALM_WOOD, ModBlocks.STRIPPED_PALM_LOG, ModBlocks.STRIPPED_PALM_WOOD);
    }
}
