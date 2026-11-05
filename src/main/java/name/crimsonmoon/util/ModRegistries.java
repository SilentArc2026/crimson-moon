package name.crimsonmoon.util;


import name.crimsonmoon.block.ModBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModRegistries {

    public static void registerModStuffs() {
        registerStrippable();

    }

    private static void registerStrippable() {
        StrippableBlockRegistry.register(ModBlocks.CORRUPTED_LOG, ModBlocks.STRIPPED_CORRUPTED_LOG);
        StrippableBlockRegistry.register(ModBlocks.CORRUPTED_WOOD, ModBlocks.STRIPPED_CORRUPTED_WOOD);
        StrippableBlockRegistry.register(ModBlocks.ACIDIC_LOG, ModBlocks.STRIPPED_ACIDIC_LOG);
        StrippableBlockRegistry.register(ModBlocks.ACIDIC_WOOD, ModBlocks.STRIPPED_ACIDIC_WOOD);
    }
    private static void registerFlammable() {
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CORRUPTED_LOG,5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CORRUPTED_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CORRUPTED_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CORRUPTED_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CORRUPTED_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CORRUPTED_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ACIDIC_LOG,5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ACIDIC_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ACIDIC_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ACIDIC_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ACIDIC_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ACIDIC_LEAVES, 30, 60);
    }
}
