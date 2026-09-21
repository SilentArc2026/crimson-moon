package name.crimsonmoon.datagen;

import name.crimsonmoon.block.ModBlocks;
import name.crimsonmoon.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.Crimson_Block, ModBlocks.Solarium_Block, ModBlocks.Deepslate_Vampyrite_Ore, ModBlocks.Raw_Vampyrite_Block, ModBlocks.Vampyrite_Block, ModBlocks.Vampyrite_Ore);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.Crimson_Block, ModBlocks.Solarium_Block);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.Vampyrite_Ore, ModBlocks.Vampyrite_Block, ModBlocks.Raw_Vampyrite_Block, ModBlocks.Deepslate_Vampyrite_Ore);

       //Tag for Custom Tool Material for Crimson
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric","needs_tool_level_5")))
                .add(ModBlocks.Crimson_Block, ModBlocks.Solarium_Block);
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric","needs_iron_tool")))
                .add(ModBlocks.Vampyrite_Block, ModBlocks.Vampyrite_Ore, ModBlocks.Raw_Vampyrite_Block, ModBlocks.Deepslate_Vampyrite_Ore);
    }
}
