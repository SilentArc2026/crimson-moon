package name.crimsonmoon.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import name.crimsonmoon.CrimsonMoon;
import name.crimsonmoon.block.ModBlocks;
import name.crimsonmoon.entity.ModBoats;
import name.crimsonmoon.item.custom.BracerItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ACIDIC_LEATHER = registerItem("acidic_leather",
            new Item(new FabricItemSettings()));
    public static final Item DARKSTEEL_INGOT = registerItem("darksteel_ingot",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_NUGGET = registerItem("darksteel_nugget",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_DAGGER = registerItem("darksteel_dagger",
            new SwordItem(ModToolMaterial.DARKSTEEL, 6, 2, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_PICKAXE = registerItem("darksteel_pickaxe",
            new PickaxeItem(ModToolMaterial.DARKSTEEL, 4, 0, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_HATCHET = registerItem("darksteel_hatchet",
            new AxeItem(ModToolMaterial.DARKSTEEL, 8, 1, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_SPADE = registerItem("darksteel_spade",
            new ShovelItem(ModToolMaterial.DARKSTEEL, 3, 1, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_TROWEL = registerItem("darksteel_trowel",
            new HoeItem(ModToolMaterial.DARKSTEEL, 2, 1, new FabricItemSettings().fireproof()));
    public static final Item THE_BEHEMOTHS_HORN = registerItem("the_behemoths_horn",
            new GoatHornItem(new FabricItemSettings().maxCount(1), ModInstruments.BEHEMOTH_HORNS));
    public static final Item ACIDIC_LEATHER_HORSE_ARMOR = registerItem("acidic_leather_horse_armor",
            new HorseArmorItem(3, "acidic_leather", new FabricItemSettings()));
    public static final Item DARKSTEEL_HORSE_ARMOR = registerItem("darksteel_horse_armor",
            new HorseArmorItem(5, "darksteel", new FabricItemSettings()));
    public static final Item ACIDIC_SADDLE = registerItem("acidic_saddle",
            new SaddleItem(new FabricItemSettings().maxCount(1)));
    public static final Item CORRUPTED_STAR = registerItem("corrupted_star",
            new Item(new FabricItemSettings()));
    public static final Item PLUME_OF_CRIMSON = registerItem("plume_of_crimson",
            new Item(new FabricItemSettings()));
    public static final Item RAW_ACIDIC_BEEF = registerItem("raw_acidic_beef",
            new Item(new FabricItemSettings().food(ModFoodComponents.RAW_ACIDIC_BEEF)));
    public static final Item Crimsonite_Ingot = registerItem("crimsonite_ingot",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item Crimsonite_upgrade_smithing_template = registerItem("crimsonite_upgrade_smithing_template",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item Crimsonite_Plate = registerItem("crimsonite_plate",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item SOLAR_STAR = registerItem("solar_star",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item SOLARIUM_UPGRADE_SMITHING_TEMPLATE = registerItem("solarium_upgrade_smithing_template",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item DIAMOND_ROD = registerItem("diamond_rod",
            new Item(new FabricItemSettings()));
    public static final Item Blood_Blade = registerItem("blood_blade",
            new SwordItem(ModToolMaterial.CRIMSON, 7, 3, new FabricItemSettings().fireproof()));
    public static final Item Crimson_Pickaxe = registerItem("crimson_pickaxe",
            new PickaxeItem(ModToolMaterial.CRIMSON, 2, 1, new FabricItemSettings().fireproof()));
    public static final Item Crimson_Axe = registerItem("crimson_axe",
            new AxeItem(ModToolMaterial.CRIMSON, 9, -1, new FabricItemSettings().fireproof()));
    public static final Item Crimson_Shovel = registerItem("crimson_shovel",
            new ShovelItem(ModToolMaterial.CRIMSON, 1, 1, new FabricItemSettings().fireproof()));
    public static final Item Crimson_Hoe = registerItem("crimson_hoe",
            new HoeItem(ModToolMaterial.CRIMSON, 0, 1, new FabricItemSettings().fireproof()));
    public static final Item VAMPYRITE_PICKAXE = registerItem("vampyrite_pickaxe",
            new PickaxeItem(ModToolMaterial.VAMPYRITE, 1, 0.5f, new FabricItemSettings()));
    public static final Item VAMPYRITE_AXE = registerItem("vampyrite_axe",
            new AxeItem(ModToolMaterial.VAMPYRITE, 7, -1, new FabricItemSettings()));
    public static final Item VAMPYRITE_SHOVEL = registerItem("vampyrite_shovel",
            new ShovelItem(ModToolMaterial.VAMPYRITE, 0, 1, new FabricItemSettings()));
    public static final Item VAMPYRITE_HOE = registerItem("vampyrite_hoe",
            new HoeItem(ModToolMaterial.VAMPYRITE, -1, 1, new FabricItemSettings()));
    public static final Item TURQITE_PICKAXE = registerItem("turqite_pickaxe",
            new PickaxeItem(ModToolMaterial.TURQITE, 2, 0.5f, new FabricItemSettings()));
    public static final Item TURQITE_AXE = registerItem("turqite_axe",
            new AxeItem(ModToolMaterial.TURQITE, 8, -1, new FabricItemSettings()));
    public static final Item TURQITE_SHOVEL = registerItem("turqite_shovel",
            new ShovelItem(ModToolMaterial.TURQITE, 1, 1, new FabricItemSettings()));
    public static final Item TURQITE_HOE = registerItem("turqite_hoe",
            new HoeItem(ModToolMaterial.TURQITE, 0, 1, new FabricItemSettings()));
    public static final Item SOLARIUM_PICKAXE = registerItem("solarium_pickaxe",
            new PickaxeItem(ModToolMaterial.SOLARIUM, 6, 3, new FabricItemSettings().fireproof()));
    public static final Item SOLARIUM_AXE = registerItem("solarium_axe",
            new AxeItem(ModToolMaterial.SOLARIUM, 11, -1, new FabricItemSettings().fireproof()));
    public static final Item SOLARIUM_SHOVEL = registerItem("solarium_shovel",
            new ShovelItem(ModToolMaterial.SOLARIUM, 3, 1, new FabricItemSettings().fireproof()));
    public static final Item SOLARIUM_HOE = registerItem("solarium_hoe",
            new HoeItem(ModToolMaterial.SOLARIUM, 2, 1, new FabricItemSettings().fireproof()));
    public static final Item CRIMSON_HELMET = registerItem("crimson_helmet",
            new ArmorItem(ModArmorMaterials.CRIMSON,ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));
    public static final Item CRIMSON_CHESTPLATE = registerItem("crimson_chestplate",
            new ArmorItem(ModArmorMaterials.CRIMSON,ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));
    public static final Item CRIMSON_LEGGINGS = registerItem("crimson_leggings",
            new ArmorItem(ModArmorMaterials.CRIMSON,ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));
    public static final Item CRIMSON_BOOTS = registerItem("crimson_boots",
            new ArmorItem(ModArmorMaterials.CRIMSON,ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof()));
    public static final Item CRIMSON_SWORD = registerItem("crimson_sword",
            new SwordItem(ModToolMaterial.CRIMSON, 5, 2, new FabricItemSettings().fireproof()));
    public static final Item RAW_VAMPYRITE = registerItem("raw_vampyrite",
            new Item(new FabricItemSettings()));
    public static final Item SOLARIUM_INGOT = registerItem("solarium_ingot",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item VAMPYRITE_INGOT = registerItem("vampyrite_ingot",
            new Item(new FabricItemSettings()));
    public static final Item REFINED_TURQITE = registerItem("refined_turqite",
            new Item(new FabricItemSettings()));
    public static final Item TURQITE_UPGRADE_SMITHING_TEMPLATE = registerItem("turqite_upgrade_smithing_template",
            new Item(new FabricItemSettings()));
    public static final Item HEAVENLY_UPGRADE_SMITHING_TEMPLATE = registerItem("heavenly_upgrade_smithing_template",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item TURQITE_CRYSTAL = registerItem("turqite_crystal",
            new Item(new FabricItemSettings()));
    public static final Item VAMPYRITE_HELMET = registerItem("vampyrite_helmet",
            new ArmorItem(ModArmorMaterials.VAMPYRITE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item VAMPYRITE_CHESTPLATE = registerItem("vampyrite_chestplate",
            new ArmorItem(ModArmorMaterials.VAMPYRITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item VAMPYRITE_LEGGINGS = registerItem("vampyrite_leggings",
            new ArmorItem(ModArmorMaterials.VAMPYRITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item VAMPYRITE_BOOTS = registerItem("vampyrite_boots",
            new ArmorItem(ModArmorMaterials.VAMPYRITE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item TURQITE_HELMET = registerItem("turqite_helmet",
            new ArmorItem(ModArmorMaterials.TURQITE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item TURQITE_CHESTPLATE = registerItem("turqite_chestplate",
            new ArmorItem(ModArmorMaterials.TURQITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item TURQITE_LEGGINGS = registerItem("turqite_leggings",
            new ArmorItem(ModArmorMaterials.TURQITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item TURQITE_BOOTS = registerItem("turqite_boots",
            new ArmorItem(ModArmorMaterials.TURQITE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item SOLARIUM_HELMET = registerItem("solarium_helmet",
            new ArmorItem(ModArmorMaterials.SOLARIUM, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));
    public static final Item SOLARIUM_CHESTPLATE = registerItem("solarium_chestplate",
            new ArmorItem(ModArmorMaterials.SOLARIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));
    public static final Item SOLARIUM_LEGGINGS = registerItem("solarium_leggings",
            new ArmorItem(ModArmorMaterials.SOLARIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));
    public static final Item SOLARIUM_BOOTS = registerItem("solarium_boots",
            new ArmorItem(ModArmorMaterials.SOLARIUM, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_HELMET = registerItem("darksteel_helmet",
            new ArmorItem(ModArmorMaterials.DARKSTEEL, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_CHESTPLATE = registerItem("darksteel_chestplate",
            new ArmorItem(ModArmorMaterials.DARKSTEEL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_LEGGINGS = registerItem("darksteel_leggings",
            new ArmorItem(ModArmorMaterials.DARKSTEEL, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_BOOTS = registerItem("darksteel_boots",
            new ArmorItem(ModArmorMaterials.DARKSTEEL, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof()));
    public static final Item VAMPYRITE_SWORD = registerItem("vampyrite_sword",
            new SwordItem(ModToolMaterial.VAMPYRITE, 4, 2, new FabricItemSettings()));
    public static final Item TURQITE_SWORD = registerItem("turqite_sword",
            new SwordItem(ModToolMaterial.TURQITE, 5, 2, new FabricItemSettings()));
    public static final Item SOLARIUM_SWORD = registerItem("solarium_sword",
            new SwordItem(ModToolMaterial.SOLARIUM, 9, 3, new FabricItemSettings().fireproof()));
    public static final Item HEAVENLY_BLADE = registerItem("heavenly_blade",
            new SwordItem(ModToolMaterial.SOLARIUM, 10, 3, new FabricItemSettings().fireproof()));

    public static final Item ACIDIC_SIGN = registerItem("acidic_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.ACIDIC_SIGN, ModBlocks.ACIDIC_WALL_SIGN));
    public static final Item ACIDIC_HANGING_SIGN = registerItem("acidic_hanging_sign",
            new HangingSignItem(ModBlocks.ACIDIC_HANGING_SIGN, ModBlocks.ACIDIC_HANGING_WALL_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item CORRUPTED_SIGN = registerItem("corrupted_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.CORRUPTED_SIGN, ModBlocks.CORRUPTED_WALL_SIGN));
    public static final Item CORRUPTED_HANGING_SIGN = registerItem("corrupted_hanging_sign",
            new HangingSignItem(ModBlocks.CORRUPTED_HANGING_SIGN, ModBlocks.CORRUPTED_HANGING_WALL_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item CHARRED_SIGN = registerItem("charred_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.CHARRED_SIGN, ModBlocks.CHARRED_WALL_SIGN));
    public static final Item CHARRED_HANGING_SIGN = registerItem("charred_hanging_sign",
            new HangingSignItem(ModBlocks.CHARRED_HANGING_SIGN, ModBlocks.CHARRED_HANGING_WALL_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item PALM_SIGN = registerItem("palm_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.PALM_SIGN, ModBlocks.PALM_WALL_SIGN));
    public static final Item PALM_HANGING_SIGN = registerItem("palm_hanging_sign",
            new HangingSignItem(ModBlocks.PALM_HANGING_SIGN, ModBlocks.PALM_HANGING_WALL_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item WITHERED_PALM_SIGN = registerItem("withered_palm_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.WITHERED_PALM_SIGN, ModBlocks.WITHERED_PALM_WALL_SIGN));
    public static final Item WITHERED_PALM_HANGING_SIGN = registerItem("withered_palm_hanging_sign",
            new HangingSignItem(ModBlocks.WITHERED_PALM_HANGING_SIGN, ModBlocks.WITHERED_PALM_HANGING_WALL_SIGN, new FabricItemSettings().maxCount(16)));

    public static final Item CORRUPTED_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.CORRUPTED_BOAT_ID, ModBoats.CORRUPTED_BOAT_KEY, false);
    public static final Item CORRUPTED_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.CORRUPTED_CHEST_BOAT_ID, ModBoats.CORRUPTED_BOAT_KEY, true);
    public static final Item ACIDIC_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.ACIDIC_BOAT_ID, ModBoats.ACIDIC_BOAT_KEY, false);
    public static final Item ACIDIC_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.ACIDIC_CHEST_BOAT_ID, ModBoats.ACIDIC_BOAT_KEY, true);
    public static final Item CHARRED_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.CHARRED_BOAT_ID, ModBoats.CHARRED_BOAT_KEY, false);
    public static final Item CHARRED_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.CHARRED_CHEST_BOAT_ID, ModBoats.CHARRED_BOAT_KEY, true);
    public static final Item PALM_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.PALM_BOAT_ID, ModBoats.PALM_BOAT_KEY, false);
    public static final Item PALM_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.PALM_CHEST_BOAT_ID, ModBoats.PALM_BOAT_KEY, true);
    public static final Item WITHERED_PALM_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.WITHERED_PALM_BOAT_ID, ModBoats.WITHERED_PALM_BOAT_KEY, false);
    public static final Item WITHERED_PALM_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.WITHERED_PALM_CHEST_BOAT_ID, ModBoats.WITHERED_PALM_BOAT_KEY, true);

    public static final Item GLOOM_BERRIES = registerItem("gloom_berries",
            new AliasedBlockItem(ModBlocks.CHARRED_VINES, new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1F).build())));

    public static final Item ACIDIC_PITCHER_POD = registerItem("acidic_pitcher_pod",
            new AliasedBlockItem(ModBlocks.ACIDIC_PITCHER_CROP, new FabricItemSettings()));

    public static final Item CORRUPTED_TORCHFLOWER_SEEDS = registerItem("corrupted_torchflower_seeds",
            new AliasedBlockItem(ModBlocks.CORRUPTED_TORCHFLOWER_CROP, new FabricItemSettings()));

    public static final Item CHAIN_FISHNETS = registerItem("chain_fishnets",
            new BracerItem(ArmorMaterials.CHAIN, 1, 2, new FabricItemSettings()));
    public static final Item CRIMSON_BRACERS = registerItem("crimson_bracers",
            new BracerItem(ModArmorMaterials.CRIMSON, 3, 4, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_BRACERS = registerItem("darksteel_bracers",
            new BracerItem(ModArmorMaterials.DARKSTEEL, 4, 5, new FabricItemSettings().fireproof()));
    public static final Item DIAMOND_BRACERS = registerItem("diamond_bracers",
            new BracerItem(ArmorMaterials.DIAMOND, 3, 3, new FabricItemSettings()));
    public static final Item GOLD_BRACERS = registerItem("gold_bracers",
            new BracerItem(ArmorMaterials.GOLD, 2, 1, new FabricItemSettings()));
    public static final Item IRON_BRACERS = registerItem("iron_bracers",
            new BracerItem(ArmorMaterials.IRON, 2, 2, new FabricItemSettings()));
    public static final Item LEATHER_BRACERS = registerItem("leather_bracers",
            new BracerItem(ArmorMaterials.LEATHER, 1, 1, new FabricItemSettings()));
    public static final Item NETHERITE_BRACERS = registerItem("netherite_bracers",
            new BracerItem(ArmorMaterials.NETHERITE, 4, 4, new FabricItemSettings().fireproof()));
    public static final Item SOLARIUM_BRACERS = registerItem("solarium_bracers",
            new BracerItem(ModArmorMaterials.SOLARIUM, 5, 6, new FabricItemSettings().fireproof()));
    public static final Item TURQITE_BRACERS = registerItem("turqite_bracers",
            new BracerItem(ModArmorMaterials.TURQITE, 3, 3, new FabricItemSettings()));
    public static final Item VAMPYRITE_BRACERS = registerItem("vampyrite_bracers",
            new BracerItem(ModArmorMaterials.VAMPYRITE, 2, 2, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CrimsonMoon.MOD_ID, name), item);
    }

    private static void itemGroupIngredients(FabricItemGroupEntries entries) {

    }

    public static void registerModItems() {
        CrimsonMoon.LOGGER.info("Registering Mod Items for " + CrimsonMoon.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(LEATHER_BRACERS);
            entries.add(CHAIN_FISHNETS);
            entries.add(IRON_BRACERS);
            entries.add(GOLD_BRACERS);
            entries.add(DIAMOND_BRACERS);
            entries.add(NETHERITE_BRACERS);
        });
    }
}
