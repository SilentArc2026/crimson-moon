package name.crimsonmoon.item;

import name.crimsonmoon.CrimsonMoon;
import name.crimsonmoon.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item Crimson_Ingot = registerItem("crimson_ingot",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item Crimson_upgrade_smithing_template = registerItem("crimson_upgrade_smithing_template",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item Crimson_Plate = registerItem("crimson_plate",
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
    public static final Item SOLARIUM_PICKAXE = registerItem("solarium_pickaxe",
            new PickaxeItem(ModToolMaterial.SOLARIUM, 6, 3, new FabricItemSettings().fireproof()));
    public static final Item SOLARIUM_AXE = registerItem("solarium_axe",
            new AxeItem(ModToolMaterial.SOLARIUM, 11, -1, new FabricItemSettings().fireproof()));
    public static final Item SOLARIUM_SHOVEL = registerItem("solarium_shovel",
            new ShovelItem(ModToolMaterial.SOLARIUM, 3, 1, new FabricItemSettings().fireproof()));
    public static final Item SOLARIUM_HOE = registerItem("solarium_hoe",
            new HoeItem(ModToolMaterial.SOLARIUM, 2, 1, new FabricItemSettings().fireproof()));
    public static final Item CRIMSON_HELMET = registerItem("crimson_helmet",
            new ArmorItem(ModArmorMaterials.CRIMSON,ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item CRIMSON_CHESTPLATE = registerItem("crimson_chestplate",
            new ArmorItem(ModArmorMaterials.CRIMSON,ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item CRIMSON_LEGGINGS = registerItem("crimson_leggings",
            new ArmorItem(ModArmorMaterials.CRIMSON,ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item CRIMSON_BOOTS = registerItem("crimson_boots",
            new ArmorItem(ModArmorMaterials.CRIMSON,ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item CRIMSON_SWORD = registerItem("crimson_sword",
            new SwordItem(ModToolMaterial.CRIMSON, 5, 2, new FabricItemSettings().fireproof()));
    public static final Item RAW_VAMPYRITE = registerItem("raw_vampyrite",
            new Item(new FabricItemSettings()));
    public static final Item SOLARIUM_INGOT = registerItem("solarium_ingot",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item VAMPYRITE_INGOT = registerItem("vampyrite_ingot",
            new Item(new FabricItemSettings()));
    public static final Item VAMPYRITE_HELMET = registerItem("vampyrite_helmet",
            new ArmorItem(ModArmorMaterials.VAMPYRITE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item VAMPYRITE_CHESTPLATE = registerItem("vampyrite_chestplate",
            new ArmorItem(ModArmorMaterials.VAMPYRITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item VAMPYRITE_LEGGINGS = registerItem("vampyrite_leggings",
            new ArmorItem(ModArmorMaterials.VAMPYRITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item VAMPYRITE_BOOTS = registerItem("vampyrite_boots",
            new ArmorItem(ModArmorMaterials.VAMPYRITE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item SOLARIUM_HELMET = registerItem("solarium_helmet",
            new ArmorItem(ModArmorMaterials.SOLARIUM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item SOLARIUM_CHESTPLATE = registerItem("solarium_chestplate",
            new ArmorItem(ModArmorMaterials.SOLARIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item SOLARIUM_LEGGINGS = registerItem("solarium_leggings",
            new ArmorItem(ModArmorMaterials.SOLARIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item SOLARIUM_BOOTS = registerItem("solarium_boots",
            new ArmorItem(ModArmorMaterials.SOLARIUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item VAMPYRITE_SWORD = registerItem("vampyrite_sword",
            new SwordItem(ModToolMaterial.VAMPYRITE, 4, 2, new FabricItemSettings()));
    public static final Item SOLARIUM_SWORD = registerItem("solarium_sword",
            new SwordItem(ModToolMaterial.SOLARIUM, 9, 3, new FabricItemSettings().fireproof()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CrimsonMoon.MOD_ID, name), item);
    }

    private static void itemGroupIngredients(FabricItemGroupEntries entries) {

    }

    public static void registerModItems() {
        CrimsonMoon.LOGGER.info("Registering Mod Items for " + CrimsonMoon.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}
