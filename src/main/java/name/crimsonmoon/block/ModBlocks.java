package name.crimsonmoon.block;

import name.crimsonmoon.CrimsonMoon;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block Crimson_Block = registerBlock("crimson_block",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(CrimsonMoon.MOD_ID, name), block);
    }



    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(CrimsonMoon.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        CrimsonMoon.LOGGER.info("Registering ModBlocks for " + CrimsonMoon.MOD_ID);
    }
}
