package name.crimsonmoon;

import name.crimsonmoon.block.ModBlocks;
import name.crimsonmoon.block.entity.ModBlockEntities;
import name.crimsonmoon.entity.ModBoats;
import name.crimsonmoon.item.ModInstruments;
import name.crimsonmoon.item.ModItemGroup;
import name.crimsonmoon.item.ModItems;
import name.crimsonmoon.painting.ModPaintings;
import name.crimsonmoon.sounds.ModSounds;
import name.crimsonmoon.world.feature.ModFeatures;
import name.crimsonmoon.world.gen.ModWorldGeneration;
import name.crimsonmoon.world.tree.ModFoliagePlacerTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
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

		ModBlockEntities.registerBlockEntities();

		ModBoats.registerBoats();

		ModFeatures.registerModFeatures();

		ModFoliagePlacerTypes.register();

		ModSounds.registerSounds();
		ModInstruments.registerInstruments();

		TillableBlockRegistry.register(ModBlocks.CORRUPTED_GRASS_BLOCK, HoeItem::canTillFarmland, HoeItem.createTillAction(Blocks.FARMLAND.getDefaultState()));
		TillableBlockRegistry.register(ModBlocks.CORRUPTED_DIRT, HoeItem::canTillFarmland, HoeItem.createTillAction(Blocks.FARMLAND.getDefaultState()));
		TillableBlockRegistry.register(ModBlocks.ACIDIC_GRASS_BLOCK, HoeItem::canTillFarmland, HoeItem.createTillAction(Blocks.FARMLAND.getDefaultState()));
		TillableBlockRegistry.register(ModBlocks.ACIDIC_DIRT, HoeItem::canTillFarmland, HoeItem.createTillAction(Blocks.FARMLAND.getDefaultState()));

		CompostingChanceRegistry.INSTANCE.add(ModBlocks.BUSH, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.WILD_BUSH, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.WEEDS, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.CAT_TAILS, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.WITHERED_BUSH, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.WITHERED_WILD_BUSH, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.WITHERED_WEEDS, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.WITHERED_CAT_TAILS, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.CORRUPTED_TORCHFLOWER, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.ACID_FLOWER, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.PINK_FLOWER, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.CORRUPTED_WITHER_ROSE, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.ACIDIC_LILAC, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.ACIDIC_PITCHER, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.ACIDIC_SAPLING, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.CORRUPTED_SAPLING, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.PALM_SAPLING, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.WITHERED_PALM_SAPLING, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.CHARRED_FUNGUS, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.CHARRED_WART_BLOCK, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.CORRUPTED_CLOSED_EYEBLOSSOM, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.CORRUPTED_OPEN_EYEBLOSSOM, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.ACIDIC_GRASS, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.ACIDIC_TALL_GRASS, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.CORRUPTED_GRASS, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.CORRUPTED_TALL_GRASS, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.CORRUPTED_POPPY, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.CHARRED_VINES, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.FIRE_FLOWER, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.GLOOM_BERRIES, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.ACIDIC_PITCHER_POD, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.ACIDIC_MUSHROOM, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.CORRUPTED_MUSHROOM, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.BLACKENED_MUSHROOM, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.CHARRED_FUNGUS, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.DEAD_BLOOD_BUSH, 0.3f);
	}
}
