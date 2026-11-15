package name.crimsonmoon.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import name.crimsonmoon.CrimsonMoon;
import name.crimsonmoon.block.ModBlocks;
import name.crimsonmoon.item.ModItems;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModBoats {
    public static final Identifier CORRUPTED_BOAT_ID = new Identifier(CrimsonMoon.MOD_ID, "corrupted_boat");
    public static final Identifier CORRUPTED_CHEST_BOAT_ID = new Identifier(CrimsonMoon.MOD_ID, "corrupted_chest_boat");
    public static final Identifier ACIDIC_BOAT_ID = new Identifier(CrimsonMoon.MOD_ID, "acidic_boat");
    public static final Identifier ACIDIC_CHEST_BOAT_ID = new Identifier(CrimsonMoon.MOD_ID, "acidic_chest_boat");
    public static final Identifier CHARRED_BOAT_ID = new Identifier(CrimsonMoon.MOD_ID, "charred_boat");
    public static final Identifier CHARRED_CHEST_BOAT_ID = new Identifier(CrimsonMoon.MOD_ID, "charred_chest_boat");

    public static final RegistryKey<TerraformBoatType> CORRUPTED_BOAT_KEY = TerraformBoatTypeRegistry.createKey(CORRUPTED_BOAT_ID);
    public static final RegistryKey<TerraformBoatType> ACIDIC_BOAT_KEY = TerraformBoatTypeRegistry.createKey(ACIDIC_BOAT_ID);
    public static final RegistryKey<TerraformBoatType> CHARRED_BOAT_KEY = TerraformBoatTypeRegistry.createKey(CHARRED_BOAT_ID);

    public static void registerBoats() {
        TerraformBoatType corruptedBoat = new TerraformBoatType.Builder()
                .item(ModItems.CORRUPTED_BOAT)
                .chestItem(ModItems.CORRUPTED_CHEST_BOAT)
                .planks(ModBlocks.CORRUPTED_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, CORRUPTED_BOAT_KEY, corruptedBoat);

        TerraformBoatType acidicBoat = new TerraformBoatType.Builder()
                .item(ModItems.ACIDIC_BOAT)
                .chestItem(ModItems.ACIDIC_CHEST_BOAT)
                .planks(ModBlocks.ACIDIC_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, ACIDIC_BOAT_KEY, acidicBoat);

        TerraformBoatType charredBoat = new TerraformBoatType.Builder()
                .item(ModItems.CHARRED_BOAT)
                .chestItem(ModItems.CHARRED_CHEST_BOAT)
                .planks(ModBlocks.CHARRED_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, CHARRED_BOAT_KEY, charredBoat);
    }

}

