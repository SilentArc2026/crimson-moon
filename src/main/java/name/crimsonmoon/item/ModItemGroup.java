package name.crimsonmoon.item;

import name.crimsonmoon.CrimsonMoon;
import name.crimsonmoon.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup Crimson_Moon_Combat = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CrimsonMoon.MOD_ID, "crimson_moon_combat"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.crimson_moon_combat"))
                    .icon(() -> new ItemStack(ModItems.HEAVENLY_BLADE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.VAMPYRITE_SWORD);
                        entries.add(ModItems.CRIMSON_SWORD);
                        entries.add(ModItems.Blood_Blade);
                        entries.add(ModItems.TURQITE_SWORD);
                        entries.add(ModItems.SOLARIUM_SWORD);
                        entries.add(ModItems.HEAVENLY_BLADE);
                        entries.add(ModItems.VAMPYRITE_HELMET);
                        entries.add(ModItems.VAMPYRITE_CHESTPLATE);
                        entries.add(ModItems.VAMPYRITE_LEGGINGS);
                        entries.add(ModItems.VAMPYRITE_BOOTS);
                        entries.add(ModItems.CRIMSON_HELMET);
                        entries.add(ModItems.CRIMSON_CHESTPLATE);
                        entries.add(ModItems.CRIMSON_LEGGINGS);
                        entries.add(ModItems.CRIMSON_BOOTS);
                        entries.add(ModItems.TURQITE_HELMET);
                        entries.add(ModItems.TURQITE_CHESTPLATE);
                        entries.add(ModItems.TURQITE_LEGGINGS);
                        entries.add(ModItems.TURQITE_BOOTS);
                        entries.add(ModItems.SOLARIUM_HELMET);
                        entries.add(ModItems.SOLARIUM_CHESTPLATE);
                        entries.add(ModItems.SOLARIUM_LEGGINGS);
                        entries.add(ModItems.SOLARIUM_BOOTS);

                    }).build());

    public static final ItemGroup Crimson_Moon_Dev_Blocks = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CrimsonMoon.MOD_ID, "crimson_moon_dev_blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.crimson_moon_dev_blocks"))
                    .icon(() -> new ItemStack(ModBlocks.REDSTONE_HEART)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.CORRUPTED_REDSTONE_HEART);
                        entries.add(ModBlocks.REDSTONE_HEART);
                        entries.add(ModItems.PLUME_OF_CRIMSON);
                        entries.add(ModItems.CORRUPTED_STAR);
                        entries.add(ModItems.THE_BEHEMOTHS_HORN);

                    }).build());

    public static final ItemGroup Crimson_Moon_Functional_Blocks = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CrimsonMoon.MOD_ID, "crimson_moon_functional_blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.crimson_moon_functional_blocks"))
                    .icon(() -> new ItemStack(ModBlocks.CORRUPTED_SIGN)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.ACIDIC_SLAB);
                        entries.add(ModBlocks.ACIDIC_STAIRS);
                        entries.add(ModBlocks.ACIDIC_BUTTON);
                        entries.add(ModBlocks.ACIDIC_PRESSURE_PLATE);
                        entries.add(ModBlocks.ACIDIC_FENCE);
                        entries.add(ModBlocks.ACIDIC_FENCE_GATE);
                        entries.add(ModBlocks.ACIDIC_DOOR);
                        entries.add(ModBlocks.ACIDIC_TRAPDOOR);
                        entries.add(ModBlocks.ACIDIC_SIGN);
                        entries.add(ModBlocks.ACIDIC_HANGING_SIGN);
                        entries.add(ModBlocks.ACIDIC_TRAPPED_RUG);
                        entries.add(ModBlocks.CORRUPTED_SLAB);
                        entries.add(ModBlocks.CORRUPTED_STAIRS);
                        entries.add(ModBlocks.CORRUPTED_BUTTON);
                        entries.add(ModBlocks.CORRUPTED_PRESSURE_PLATE);
                        entries.add(ModBlocks.CORRUPTED_FENCE);
                        entries.add(ModBlocks.CORRUPTED_FENCE_GATE);
                        entries.add(ModBlocks.CORRUPTED_DOOR);
                        entries.add(ModBlocks.CORRUPTED_TRAPDOOR);
                        entries.add(ModBlocks.CORRUPTED_SIGN);
                        entries.add(ModBlocks.CORRUPTED_HANGING_SIGN);
                        entries.add(ModBlocks.CHARRED_STAIRS);
                        entries.add(ModBlocks.CHARRED_SLAB);
                        entries.add(ModBlocks.CHARRED_BUTTON);
                        entries.add(ModBlocks.CHARRED_PRESSURE_PLATE);
                        entries.add(ModBlocks.CHARRED_FENCE);
                        entries.add(ModBlocks.CHARRED_FENCE_GATE);
                        entries.add(ModBlocks.CHARRED_DOOR);
                        entries.add(ModBlocks.CHARRED_TRAPDOOR);
                        entries.add(ModBlocks.CHARRED_SIGN);
                        entries.add(ModBlocks.CHARRED_HANGING_SIGN);
                        entries.add(ModBlocks.PALM_SLAB);
                        entries.add(ModBlocks.PALM_STAIRS);
                        entries.add(ModBlocks.PALM_BUTTON);
                        entries.add(ModBlocks.PALM_PRESSURE_PLATE);
                        entries.add(ModBlocks.PALM_FENCE);
                        entries.add(ModBlocks.PALM_FENCE_GATE);
                        entries.add(ModBlocks.PALM_DOOR);
                        entries.add(ModBlocks.PALM_TRAPDOOR);
                        entries.add(ModBlocks.PALM_SIGN);
                        entries.add(ModBlocks.PALM_HANGING_SIGN);
                        entries.add(ModBlocks.PALM_MOSAIC_SLAB);
                        entries.add(ModBlocks.PALM_MOSAIC_STAIRS);
                        entries.add(ModBlocks.WITHERED_PALM_STAIRS);
                        entries.add(ModBlocks.WITHERED_PALM_SLAB);
                        entries.add(ModBlocks.WITHERED_PALM_BUTTON);
                        entries.add(ModBlocks.WITHERED_PALM_PRESSURE_PLATE);
                        entries.add(ModBlocks.WITHERED_PALM_FENCE);
                        entries.add(ModBlocks.WITHERED_PALM_FENCE_GATE);
                        entries.add(ModBlocks.WITHERED_PALM_DOOR);
                        entries.add(ModBlocks.WITHERED_PALM_TRAPDOOR);
                        entries.add(ModBlocks.WITHERED_PALM_SIGN);
                        entries.add(ModBlocks.WITHERED_PALM_HANGING_SIGN);
                        entries.add(ModBlocks.WITHERED_PALM_MOSAIC_SLAB);
                        entries.add(ModBlocks.WITHERED_PALM_MOSAIC_STAIRS);
                        entries.add(ModBlocks.CUT_BLACK_SANDSTONE_SLAB);
                        entries.add(ModBlocks.CUT_BLACK_SANDSTONE_STAIRS);
                        entries.add(ModBlocks.SMOOTH_BLACK_SANDSTONE_SLAB);
                        entries.add(ModBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS);
                        entries.add(ModBlocks.BLACK_SANDSTONE_STAIRS);
                        entries.add(ModBlocks.BLACK_SANDSTONE_SLAB);
                        entries.add(ModBlocks.BLACK_SANDSTONE_WALL);
                    }).build());

    public static final ItemGroup Crimson_Moon_Nature = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CrimsonMoon.MOD_ID, "crimson_moon_nature"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.crimson_moon_nature"))
                    .icon(() -> new ItemStack(ModBlocks.Crimsonite_Block)).entries((displayContext, entries) -> {
                        entries.add(ModItems.GLOOM_BERRIES);
                        entries.add(ModItems.ACIDIC_PITCHER_POD);
                        entries.add(ModItems.CORRUPTED_TORCHFLOWER_SEEDS);
                        entries.add(ModItems.RAW_ACIDIC_BEEF);

                        entries.add(ModBlocks.GLOOMLIGHT);
                        entries.add(ModBlocks.Turqite_Bricks);
                        entries.add(ModBlocks.Turqite_Crystal_Block);
                        entries.add(ModBlocks.Budding_Crystalized_Turqite_Block);
                        entries.add(ModBlocks.Crystalized_Turqite_Block);
                        entries.add(ModBlocks.Smooth_Basalt_Turqite_Ore);
                        entries.add(ModBlocks.Turqite_Cluster);
                        entries.add(ModBlocks.SMALL_TURQITE_BUD);
                        entries.add(ModBlocks.MEDIUM_TURQITE_BUD);
                        entries.add(ModBlocks.LARGE_TURQITE_BUD);
                        entries.add(ModBlocks.CORRUPTED_LEAVES);
                        entries.add(ModBlocks.CORRUPTED_LOG);
                        entries.add(ModBlocks.CORRUPTED_PLANKS);
                        entries.add(ModBlocks.CORRUPTED_SAPLING);
                        entries.add(ModBlocks.CORRUPTED_WOOD);
                        entries.add(ModBlocks.STRIPPED_CORRUPTED_LOG);
                        entries.add(ModBlocks.STRIPPED_CORRUPTED_WOOD);
                        entries.add(ModBlocks.ACIDIC_LEAVES);
                        entries.add(ModBlocks.ACIDIC_LOG);
                        entries.add(ModBlocks.ACIDIC_PLANKS);
                        entries.add(ModBlocks.ACIDIC_SAPLING);
                        entries.add(ModBlocks.ACIDIC_WOOD);
                        entries.add(ModBlocks.STRIPPED_ACIDIC_LOG);
                        entries.add(ModBlocks.STRIPPED_ACIDIC_WOOD);
                        entries.add(ModBlocks.DOLOMITE);
                        entries.add(ModBlocks.DOLOMITE_BRICKS);
                        entries.add(ModBlocks.POLISHED_DOLOMITE);
                        entries.add(ModBlocks.CORRUPTED_DIRT);
                        entries.add(ModBlocks.CORRUPTED_GRASS_BLOCK);
                        entries.add(ModBlocks.ACIDIC_DIRT);
                        entries.add(ModBlocks.ACIDIC_GRASS_BLOCK);
                        entries.add(ModBlocks.CORRUPTED_GRASS);
                        entries.add(ModBlocks.CORRUPTED_TALL_GRASS);
                        entries.add(ModBlocks.ACIDIC_TALL_GRASS);
                        entries.add(ModBlocks.CHARRED_LOG);
                        entries.add(ModBlocks.CHARRED_PLANKS);
                        entries.add(ModBlocks.CHARRED_WOOD);
                        entries.add(ModBlocks.STRIPPED_CHARRED_LOG);
                        entries.add(ModBlocks.STRIPPED_CHARRED_WOOD);
                        entries.add(ModBlocks.ACIDIC_GRASS);
                        entries.add(ModBlocks.CHARRED_WART_BLOCK);
                        entries.add(ModBlocks.CHARRED_FUNGUS);
                        entries.add(ModBlocks.ACID_FLOWER);
                        entries.add(ModBlocks.CORRUPTED_POPPY);
                        entries.add(ModBlocks.ACIDIC_LILAC);
                        entries.add(ModBlocks.CORRUPTED_OPEN_EYEBLOSSOM);
                        entries.add(ModBlocks.CORRUPTED_CLOSED_EYEBLOSSOM);
                        entries.add(ModBlocks.CORRUPTED_REDSTONE_HEART);
                        entries.add(ModBlocks.CORRUPTED_WITHER_ROSE);
                        entries.add(ModBlocks.PALM_LEAVES);
                        entries.add(ModBlocks.PALM_LOG);
                        entries.add(ModBlocks.PALM_PLANKS);
                        entries.add(ModBlocks.PALM_WOOD);
                        entries.add(ModBlocks.STRIPPED_PALM_LOG);
                        entries.add(ModBlocks.STRIPPED_PALM_WOOD);
                        entries.add(ModBlocks.PALM_SAPLING);
                        entries.add(ModBlocks.WITHERED_PALM_LEAVES);
                        entries.add(ModBlocks.WITHERED_PALM_LOG);
                        entries.add(ModBlocks.WITHERED_PALM_PLANKS);
                        entries.add(ModBlocks.WITHERED_PALM_SAPLING);
                        entries.add(ModBlocks.WITHERED_PALM_WOOD);
                        entries.add(ModBlocks.STRIPPED_WITHERED_PALM_LOG);
                        entries.add(ModBlocks.STRIPPED_WITHERED_PALM_WOOD);
                        entries.add(ModBlocks.ACIDIC_PITCHER);
                        entries.add(ModBlocks.CORRUPTED_TORCHFLOWER);
                        entries.add(ModBlocks.PINK_FLOWER);
                        entries.add(ModBlocks.CAT_TAILS);
                        entries.add(ModBlocks.WITHERED_CAT_TAILS);
                        entries.add(ModBlocks.BUSH);
                        entries.add(ModBlocks.WILD_BUSH);
                        entries.add(ModBlocks.WEEDS);
                        entries.add(ModBlocks.WITHERED_BUSH);
                        entries.add(ModBlocks.WITHERED_WILD_BUSH);
                        entries.add(ModBlocks.WITHERED_WEEDS);
                        entries.add(ModBlocks.FIRE_FLOWER);
                        entries.add(ModBlocks.WITHERED_LILY_PAD);
                        entries.add(ModBlocks.CORRUPTED_LILY_PAD);
                        entries.add(ModBlocks.ACIDIC_MUSHROOM);
                        entries.add(ModBlocks.BLACKENED_MUSHROOM);
                        entries.add(ModBlocks.CORRUPTED_MUSHROOM);
                        entries.add(ModBlocks.ACIDIC_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.BLACKENED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.CORRUPTED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.ACIDIC_MUSHROOM_STEM);
                        entries.add(ModBlocks.CORRUPTED_MUSHROOM_STEM);
                        entries.add(ModBlocks.WET_SAND);
                        entries.add(ModBlocks.WET_RED_SAND);
                        entries.add(ModBlocks.WET_BLACK_SAND);
                        entries.add(ModBlocks.BLACK_SAND);
                        entries.add(ModBlocks.PALM_MOSAIC);
                        entries.add(ModBlocks.WITHERED_PALM_MOSAIC);
                        entries.add(ModBlocks.BLACK_SANDSTONE);
                        entries.add(ModBlocks.CUT_BLACK_SANDSTONE);
                        entries.add(ModBlocks.CHISELED_BLACK_SANDSTONE);
                        entries.add(ModBlocks.SMOOTH_BLACK_SANDSTONE);
                    }).build());

    public static final ItemGroup Crimson_Moon_Resources = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CrimsonMoon.MOD_ID, "crimson_moon_resources"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.crimson_moon_resources"))
                    .icon(() -> new ItemStack(ModItems.SOLARIUM_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.Crimsonite_upgrade_smithing_template);
                        entries.add(ModItems.Crimsonite_Ingot);
                        entries.add(ModItems.Crimsonite_Plate);
                        entries.add(ModBlocks.Crimsonite_Block);

                        entries.add(ModItems.RAW_VAMPYRITE);
                        entries.add(ModItems.VAMPYRITE_INGOT);
                        entries.add(ModBlocks.Vampyrite_Ore);
                        entries.add(ModBlocks.Deepslate_Vampyrite_Ore);
                        entries.add(ModBlocks.Raw_Vampyrite_Block);
                        entries.add(ModBlocks.Vampyrite_Block);

                        entries.add(ModItems.SOLAR_STAR);
                        entries.add(ModItems.SOLARIUM_UPGRADE_SMITHING_TEMPLATE);
                        entries.add(ModItems.SOLARIUM_INGOT);
                        entries.add(ModBlocks.Solarium_Block);

                        entries.add(ModItems.TURQITE_UPGRADE_SMITHING_TEMPLATE);
                        entries.add(ModItems.TURQITE_CRYSTAL);
                        entries.add(ModItems.REFINED_TURQITE);
                        entries.add(ModBlocks.Refined_Turqite_Block);

                        entries.add(ModItems.ACIDIC_LEATHER);
                        entries.add(ModItems.DIAMOND_ROD);
                        entries.add(ModItems.HEAVENLY_UPGRADE_SMITHING_TEMPLATE);


                    }).build());

    public static final ItemGroup Crimson_Moon_Tools_AND_UTILITIES = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CrimsonMoon.MOD_ID, "crimson_moon_tools_and_utilities"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.crimson_moon_tools_and_utilities"))
                    .icon(() -> new ItemStack(ModItems.SOLARIUM_PICKAXE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.VAMPYRITE_SHOVEL);
                        entries.add(ModItems.VAMPYRITE_PICKAXE);
                        entries.add(ModItems.VAMPYRITE_AXE);
                        entries.add(ModItems.VAMPYRITE_HOE);
                        entries.add(ModItems.Crimson_Shovel);
                        entries.add(ModItems.Crimson_Pickaxe);
                        entries.add(ModItems.Crimson_Axe);
                        entries.add(ModItems.Crimson_Hoe);
                        entries.add(ModItems.TURQITE_SHOVEL);
                        entries.add(ModItems.TURQITE_PICKAXE);
                        entries.add(ModItems.TURQITE_AXE);
                        entries.add(ModItems.TURQITE_HOE);
                        entries.add(ModItems.SOLARIUM_SHOVEL);
                        entries.add(ModItems.SOLARIUM_PICKAXE);
                        entries.add(ModItems.SOLARIUM_AXE);
                        entries.add(ModItems.SOLARIUM_HOE);
                        entries.add(ModItems.ACIDIC_BOAT);
                        entries.add(ModItems.ACIDIC_CHEST_BOAT);
                        entries.add(ModItems.CORRUPTED_BOAT);
                        entries.add(ModItems.CORRUPTED_CHEST_BOAT);
                        entries.add(ModItems.CHARRED_BOAT);
                        entries.add(ModItems.CHARRED_CHEST_BOAT);
                        entries.add(ModItems.PALM_BOAT);
                        entries.add(ModItems.PALM_CHEST_BOAT);
                        entries.add(ModItems.WITHERED_PALM_BOAT);
                        entries.add(ModItems.WITHERED_PALM_CHEST_BOAT);
                        entries.add(ModItems.ACIDIC_LEATHER_HORSE_ARMOR);
                        entries.add(ModItems.ACIDIC_SADDLE);

                    }).build());


    public static void registerItemGroups() {
    }
}
