package name.crimsonmoon.datagen;

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

    }
}
