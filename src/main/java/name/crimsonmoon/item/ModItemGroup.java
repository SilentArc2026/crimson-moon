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
    public static final ItemGroup Crimson_Moon_Group = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CrimsonMoon.MOD_ID, "crimson_moon_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.crimson_moon_group"))
                    .icon(() -> new ItemStack(ModBlocks.Crimsonite_Block)).entries((displayContext, entries) -> {
                        entries.add(ModItems.Crimsonite_Ingot);
                        entries.add(ModItems.Crimsonite_upgrade_smithing_template);
                        entries.add(ModItems.Crimsonite_Plate);
                        entries.add(ModItems.Crimson_Axe);
                        entries.add(ModItems.Crimson_Shovel);
                        entries.add(ModItems.Blood_Blade);
                        entries.add(ModItems.Crimson_Hoe);
                        entries.add(ModItems.Crimson_Pickaxe);
                        entries.add(ModItems.CRIMSON_HELMET);
                        entries.add(ModItems.CRIMSON_CHESTPLATE);
                        entries.add(ModItems.CRIMSON_LEGGINGS);
                        entries.add(ModItems.CRIMSON_BOOTS);
                        entries.add(ModItems.CRIMSON_SWORD);
                        entries.add(ModItems.VAMPYRITE_INGOT);
                        entries.add(ModItems.RAW_VAMPYRITE);
                        entries.add(ModItems.SOLARIUM_HELMET);
                        entries.add(ModItems.SOLARIUM_CHESTPLATE);
                        entries.add(ModItems.SOLARIUM_LEGGINGS);
                        entries.add(ModItems.SOLARIUM_BOOTS);
                        entries.add(ModItems.VAMPYRITE_HELMET);
                        entries.add(ModItems.VAMPYRITE_CHESTPLATE);
                        entries.add(ModItems.VAMPYRITE_LEGGINGS);
                        entries.add(ModItems.VAMPYRITE_BOOTS);
                        entries.add(ModItems.SOLARIUM_INGOT);
                        entries.add(ModItems.SOLARIUM_SWORD);
                        entries.add(ModItems.SOLARIUM_PICKAXE);
                        entries.add(ModItems.SOLARIUM_AXE);
                        entries.add(ModItems.SOLARIUM_SHOVEL);
                        entries.add(ModItems.SOLARIUM_HOE);
                        entries.add(ModItems.VAMPYRITE_AXE);
                        entries.add(ModItems.VAMPYRITE_SHOVEL);
                        entries.add(ModItems.VAMPYRITE_PICKAXE);
                        entries.add(ModItems.VAMPYRITE_SWORD);
                        entries.add(ModItems.VAMPYRITE_HOE);
                        entries.add(ModItems.DIAMOND_ROD);
                        entries.add(ModItems.SOLARIUM_UPGRADE_SMITHING_TEMPLATE);
                        entries.add(ModItems.SOLAR_STAR);

                        entries.add(ModBlocks.Crimsonite_Block);
                        entries.add(ModBlocks.Raw_Vampyrite_Block);
                        entries.add(ModBlocks.Vampyrite_Block);
                        entries.add(ModBlocks.Vampyrite_Ore);
                        entries.add(ModBlocks.Deepslate_Vampyrite_Ore);
                        entries.add(ModBlocks.Solarium_Block);
                    }).build());


    public static void registerItemGroups() {
    }
}
