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
                    .icon(() -> new ItemStack(ModBlocks.Crimson_Block)).entries((displayContext, entries) -> {
                        entries.add(ModItems.Crimson_Ingot);
                        entries.add(ModItems.Crimson_upgrade_smithing_template);
                        entries.add(ModItems.Crimson_Plate);
                        entries.add(ModItems.Crimson_Axe);
                        entries.add(ModItems.Crimson_Shovel);
                        entries.add(ModItems.Blood_Blade);
                        entries.add(ModItems.Crimson_Hoe);
                        entries.add(ModItems.Crimson_Pickaxe);

                        entries.add(ModBlocks.Crimson_Block);
                    }).build());


    public static void registerItemGroups() {
    }
}
