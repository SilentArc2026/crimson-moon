package name.crimsonmoon.datagen;

import name.crimsonmoon.block.ModBlocks;
import name.crimsonmoon.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.CRIMSON_HELMET, ModItems.CRIMSON_CHESTPLATE, ModItems.CRIMSON_LEGGINGS, ModItems.CRIMSON_BOOTS, ModItems.VAMPYRITE_BOOTS, ModItems.VAMPYRITE_LEGGINGS, ModItems.VAMPYRITE_CHESTPLATE, ModItems.VAMPYRITE_HELMET, ModItems.SOLARIUM_BOOTS, ModItems.SOLARIUM_LEGGINGS, ModItems.SOLARIUM_CHESTPLATE, ModItems.SOLARIUM_HELMET);
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.STRIPPED_CHARRED_WOOD.asItem(), ModBlocks.STRIPPED_CHARRED_LOG.asItem(), ModBlocks.CHARRED_WOOD.asItem(), ModBlocks.CHARRED_LOG.asItem(), ModBlocks.CORRUPTED_LOG.asItem(), ModBlocks.CORRUPTED_WOOD.asItem(), ModBlocks.STRIPPED_CORRUPTED_LOG.asItem(), ModBlocks.STRIPPED_CORRUPTED_WOOD.asItem(), ModBlocks.STRIPPED_ACIDIC_WOOD.asItem(), ModBlocks.STRIPPED_ACIDIC_LOG.asItem(), ModBlocks.ACIDIC_LOG.asItem(), ModBlocks.ACIDIC_WOOD.asItem(), ModBlocks.PALM_LOG.asItem(), ModBlocks.PALM_WOOD.asItem(), ModBlocks.STRIPPED_PALM_LOG.asItem(), ModBlocks.STRIPPED_PALM_WOOD.asItem(), ModBlocks.WITHERED_PALM_LOG.asItem(), ModBlocks.WITHERED_PALM_WOOD.asItem(), ModBlocks.STRIPPED_WITHERED_PALM_LOG.asItem(), ModBlocks.STRIPPED_WITHERED_PALM_WOOD.asItem());
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.CORRUPTED_PLANKS.asItem(), ModBlocks.ACIDIC_PLANKS.asItem(), ModBlocks.CHARRED_PLANKS.asItem(), ModBlocks.PALM_PLANKS.asItem(), ModBlocks.WITHERED_PALM_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.ACIDIC_SLAB.asItem(), ModBlocks.CORRUPTED_SLAB.asItem(), ModBlocks.CHARRED_SLAB.asItem(), ModBlocks.PALM_SLAB.asItem(), ModBlocks.WITHERED_PALM_SLAB.asItem());
        getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS)
                .add(ModBlocks.CORRUPTED_POPPY.asItem(), ModBlocks.ACID_FLOWER.asItem(), ModBlocks.CORRUPTED_OPEN_EYEBLOSSOM.asItem(), ModBlocks.CORRUPTED_WITHER_ROSE.asItem());

    }
}