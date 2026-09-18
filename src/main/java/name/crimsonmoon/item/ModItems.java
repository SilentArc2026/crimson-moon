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
    public static final Item Blood_Blade = registerItem("blood_blade",
            new SwordItem(ModToolMaterial.CRIMSON, 5, 3, new FabricItemSettings().fireproof()));
    public static final Item Crimson_Pickaxe = registerItem("crimson_pickaxe",
            new PickaxeItem(ModToolMaterial.CRIMSON, 2, 1, new FabricItemSettings().fireproof()));
    public static final Item Crimson_Axe = registerItem("crimson_axe",
            new AxeItem(ModToolMaterial.CRIMSON, 6, -1, new FabricItemSettings().fireproof()));
    public static final Item Crimson_Shovel = registerItem("crimson_shovel",
            new ShovelItem(ModToolMaterial.CRIMSON, 1, 1, new FabricItemSettings().fireproof()));
    public static final Item Crimson_Hoe = registerItem("crimson_hoe",
            new HoeItem(ModToolMaterial.CRIMSON, 0, 1, new FabricItemSettings().fireproof()));

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
