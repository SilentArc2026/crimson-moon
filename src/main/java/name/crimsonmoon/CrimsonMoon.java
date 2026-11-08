package name.crimsonmoon;

import name.crimsonmoon.block.ModBlocks;
import name.crimsonmoon.item.ModItemGroup;
import name.crimsonmoon.item.ModItems;
import name.crimsonmoon.painting.ModPaintings;
import name.crimsonmoon.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.TillableBlockRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.item.HoeItem;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrimsonMoon implements ModInitializer {
	public static final String MOD_ID = "crimson-moon";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModWorldGeneration.generateModWorldGeneration();

		ModPaintings.registerPaintings();

		TillableBlockRegistry.register(ModBlocks.CORRUPTED_GRASS_BLOCK, HoeItem::canTillFarmland, HoeItem.createTillAction(Blocks.FARMLAND.getDefaultState()));
		TillableBlockRegistry.register(ModBlocks.CORRUPTED_DIRT, HoeItem::canTillFarmland, HoeItem.createTillAction(Blocks.FARMLAND.getDefaultState()));
		TillableBlockRegistry.register(ModBlocks.ACIDIC_GRASS_BLOCK, HoeItem::canTillFarmland, HoeItem.createTillAction(Blocks.FARMLAND.getDefaultState()));
		TillableBlockRegistry.register(ModBlocks.ACIDIC_DIRT, HoeItem::canTillFarmland, HoeItem.createTillAction(Blocks.FARMLAND.getDefaultState()));
	}
}
