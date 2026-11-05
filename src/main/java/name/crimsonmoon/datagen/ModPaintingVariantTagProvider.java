package name.crimsonmoon.datagen;

import name.crimsonmoon.CrimsonMoon;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.tag.TagProvider;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.PaintingVariantTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModPaintingVariantTagProvider extends TagProvider<PaintingVariant> {
    public ModPaintingVariantTagProvider(DataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture) {
        super(output, RegistryKeys.PAINTING_VARIANT, registryLookupFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(PaintingVariantTags.PLACEABLE)
                .addOptional(new Identifier(CrimsonMoon.MOD_ID, "a_forgotten_tool"))
                .addOptional(new Identifier(CrimsonMoon.MOD_ID, "blub"))
                .addOptional(new Identifier(CrimsonMoon.MOD_ID, "the_final_rise_of_the_crimson_moon"))
                .addOptional(new Identifier(CrimsonMoon.MOD_ID, "the_first_crimson_moon"))
                .addOptional(new Identifier(CrimsonMoon.MOD_ID, "the_forgotten_legend"))
                .addOptional(new Identifier(CrimsonMoon.MOD_ID, "the_seven_flowers"))
                .addOptional(new Identifier(CrimsonMoon.MOD_ID, "the_seven_souls"))
                .addOptional(new Identifier(CrimsonMoon.MOD_ID, "the_true_hero"))
                .addOptional(new Identifier(CrimsonMoon.MOD_ID, "the_wither_storm"))
                .addOptional(new Identifier(CrimsonMoon.MOD_ID, "torque_dawg_death"));

    }
}
