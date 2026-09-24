package name.crimsonmoon.datagen;

import name.crimsonmoon.block.ModBlocks;
import name.crimsonmoon.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.Crimsonite_Ingot)
                .pattern("CCN")
                .pattern("CG ")
                .pattern("   ")
                .input('C', ModItems.Crimsonite_Plate)
                .input('G', Items.GOLD_INGOT)
                .input('N', Items.NETHERITE_SCRAP)
                .criterion(hasItem(ModItems.Crimsonite_Plate), conditionsFromItem(ModItems.Crimsonite_Plate))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.Crimsonite_Ingot) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.Crimsonite_upgrade_smithing_template)
                .pattern("CCC")
                .pattern("CNC")
                .pattern("CDC")
                .input('C', ModItems.Crimsonite_Plate)
                .input('D', Items.DIAMOND)
                .input('N', Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                .criterion(hasItem(ModItems.Crimsonite_Plate), conditionsFromItem(ModItems.Crimsonite_Plate))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.Crimsonite_upgrade_smithing_template) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.Crimsonite_Block)
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModItems.Crimsonite_Ingot)
                .criterion(hasItem(ModItems.Crimsonite_Ingot), conditionsFromItem(ModItems.Crimsonite_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.Crimsonite_Block) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.Vampyrite_Block)
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModItems.VAMPYRITE_INGOT)
                .criterion(hasItem(ModItems.VAMPYRITE_INGOT), conditionsFromItem(ModItems.VAMPYRITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.Vampyrite_Block) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.Solarium_Block)
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModItems.SOLARIUM_INGOT)
                .criterion(hasItem(ModItems.SOLARIUM_INGOT), conditionsFromItem(ModItems.SOLARIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.Solarium_Block) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.Raw_Vampyrite_Block)
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModItems.RAW_VAMPYRITE)
                .criterion(hasItem(ModItems.RAW_VAMPYRITE), conditionsFromItem(ModItems.RAW_VAMPYRITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.Raw_Vampyrite_Block) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VAMPYRITE_HELMET)
                .pattern("   ")
                .pattern("VVV")
                .pattern("V V")
                .input('V', ModItems.VAMPYRITE_INGOT)
                .criterion(hasItem(ModItems.VAMPYRITE_INGOT), conditionsFromItem(ModItems.VAMPYRITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VAMPYRITE_HELMET) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VAMPYRITE_CHESTPLATE)
                .pattern("V V")
                .pattern("VVV")
                .pattern("VVV")
                .input('V', ModItems.VAMPYRITE_INGOT)
                .criterion(hasItem(ModItems.VAMPYRITE_INGOT), conditionsFromItem(ModItems.VAMPYRITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VAMPYRITE_CHESTPLATE) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VAMPYRITE_LEGGINGS)
                .pattern("VVV")
                .pattern("V V")
                .pattern("V V")
                .input('V', ModItems.VAMPYRITE_INGOT)
                .criterion(hasItem(ModItems.VAMPYRITE_INGOT), conditionsFromItem(ModItems.VAMPYRITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VAMPYRITE_LEGGINGS) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VAMPYRITE_BOOTS)
                .pattern("   ")
                .pattern("V V")
                .pattern("V V")
                .input('V', ModItems.VAMPYRITE_INGOT)
                .criterion(hasItem(ModItems.VAMPYRITE_INGOT), conditionsFromItem(ModItems.VAMPYRITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VAMPYRITE_BOOTS) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DIAMOND_ROD)
                .pattern("DSD")
                .pattern("DSD")
                .pattern("DSD")
                .input('D', Items.DIAMOND)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DIAMOND_ROD) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VAMPYRITE_SWORD)
                .pattern(" V ")
                .pattern(" V ")
                .pattern(" D ")
                .input('D', ModItems.DIAMOND_ROD)
                .input('V', ModItems.VAMPYRITE_INGOT)
                .criterion(hasItem(ModItems.DIAMOND_ROD), conditionsFromItem(ModItems.DIAMOND_ROD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VAMPYRITE_SWORD) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VAMPYRITE_SHOVEL)
                .pattern(" V ")
                .pattern(" D ")
                .pattern(" D ")
                .input('D', ModItems.DIAMOND_ROD)
                .input('V', ModItems.VAMPYRITE_INGOT)
                .criterion(hasItem(ModItems.DIAMOND_ROD), conditionsFromItem(ModItems.DIAMOND_ROD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VAMPYRITE_SHOVEL) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VAMPYRITE_PICKAXE)
                .pattern("VVV")
                .pattern(" D ")
                .pattern(" D ")
                .input('D', ModItems.DIAMOND_ROD)
                .input('V', ModItems.VAMPYRITE_INGOT)
                .criterion(hasItem(ModItems.DIAMOND_ROD), conditionsFromItem(ModItems.DIAMOND_ROD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VAMPYRITE_PICKAXE) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VAMPYRITE_AXE)
                .pattern("VV ")
                .pattern("VD ")
                .pattern(" D ")
                .input('D', ModItems.DIAMOND_ROD)
                .input('V', ModItems.VAMPYRITE_INGOT)
                .criterion(hasItem(ModItems.DIAMOND_ROD), conditionsFromItem(ModItems.DIAMOND_ROD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VAMPYRITE_AXE) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VAMPYRITE_HOE)
                .pattern("VV ")
                .pattern(" D ")
                .pattern(" D ")
                .input('D', ModItems.DIAMOND_ROD)
                .input('V', ModItems.VAMPYRITE_INGOT)
                .criterion(hasItem(ModItems.DIAMOND_ROD), conditionsFromItem(ModItems.DIAMOND_ROD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VAMPYRITE_HOE) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SOLARIUM_INGOT)
                .pattern("BNB")
                .pattern("NSN")
                .pattern("BNB")
                .input('N', Items.NETHERITE_BLOCK)
                .input('B', Items.BLAZE_ROD)
                .input('S', ModItems.SOLAR_STAR)
                .criterion(hasItem(ModItems.SOLAR_STAR), conditionsFromItem(ModItems.SOLAR_STAR))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SOLARIUM_INGOT) + "3"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SOLAR_STAR)
                .pattern("BGB")
                .pattern("GSG")
                .pattern("BGB")
                .input('G', Items.GOLD_INGOT)
                .input('B', Items.BLAZE_ROD)
                .input('S', Items.NETHER_STAR)
                .criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SOLAR_STAR) + "1"));

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.Crimsonite_Ingot, RecipeCategory.MISC, ModBlocks.Crimsonite_Block);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SOLARIUM_INGOT, RecipeCategory.MISC, ModBlocks.Solarium_Block);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.VAMPYRITE_INGOT, RecipeCategory.MISC, ModBlocks.Vampyrite_Block);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RAW_VAMPYRITE, RecipeCategory.MISC, ModBlocks.Raw_Vampyrite_Block);
        offerSmelting(exporter, List.of(ModItems.RAW_VAMPYRITE, ModBlocks.Vampyrite_Ore, ModBlocks.Deepslate_Vampyrite_Ore),
                RecipeCategory.MISC, ModItems.VAMPYRITE_INGOT, .25f, 200, "vampyrite_ingot");
        offerBlasting(exporter, List.of(ModItems.RAW_VAMPYRITE, ModBlocks.Vampyrite_Ore, ModBlocks.Deepslate_Vampyrite_Ore),
                RecipeCategory.MISC, ModItems.VAMPYRITE_INGOT, .25f, 200, "vampyrite_ingot");
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimsonite_upgrade_smithing_template),
                Ingredient.ofItems(Items.NETHERITE_SWORD),
                Ingredient.ofItems(ModItems.Crimsonite_Ingot),
                RecipeCategory.COMBAT,
                ModItems.CRIMSON_SWORD
        ).criterion(hasItem(ModItems.Crimsonite_Ingot), conditionsFromItem(ModItems.Crimsonite_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CRIMSON_SWORD) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimsonite_upgrade_smithing_template),
                Ingredient.ofItems(Items.NETHERITE_PICKAXE),
                Ingredient.ofItems(ModItems.Crimsonite_Ingot),
                RecipeCategory.TOOLS,
                ModItems.Crimson_Pickaxe
        ).criterion(hasItem(ModItems.Crimsonite_Ingot), conditionsFromItem(ModItems.Crimsonite_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.Crimson_Pickaxe) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimsonite_upgrade_smithing_template),
                Ingredient.ofItems(Items.NETHERITE_AXE),
                Ingredient.ofItems(ModItems.Crimsonite_Ingot),
                RecipeCategory.TOOLS,
                ModItems.Crimson_Axe
        ).criterion(hasItem(ModItems.Crimsonite_Ingot), conditionsFromItem(ModItems.Crimsonite_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.Crimson_Axe) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimsonite_upgrade_smithing_template),
                Ingredient.ofItems(Items.NETHERITE_SHOVEL),
                Ingredient.ofItems(ModItems.Crimsonite_Ingot),
                RecipeCategory.TOOLS,
                ModItems.Crimson_Shovel
        ).criterion(hasItem(ModItems.Crimsonite_Ingot), conditionsFromItem(ModItems.Crimsonite_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.Crimson_Shovel) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimsonite_upgrade_smithing_template),
                Ingredient.ofItems(Items.NETHERITE_HOE),
                Ingredient.ofItems(ModItems.Crimsonite_Ingot),
                RecipeCategory.TOOLS,
                ModItems.Crimson_Hoe
        ).criterion(hasItem(ModItems.Crimsonite_Ingot), conditionsFromItem(ModItems.Crimsonite_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.Crimson_Hoe) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimsonite_upgrade_smithing_template),
                Ingredient.ofItems(Items.NETHERITE_HELMET),
                Ingredient.ofItems(ModItems.Crimsonite_Ingot),
                RecipeCategory.COMBAT,
                ModItems.CRIMSON_HELMET
        ).criterion(hasItem(ModItems.Crimsonite_Ingot), conditionsFromItem(ModItems.Crimsonite_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CRIMSON_HELMET) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimsonite_upgrade_smithing_template),
                Ingredient.ofItems(Items.NETHERITE_CHESTPLATE),
                Ingredient.ofItems(ModItems.Crimsonite_Ingot),
                RecipeCategory.COMBAT,
                ModItems.CRIMSON_CHESTPLATE
        ).criterion(hasItem(ModItems.Crimsonite_Ingot), conditionsFromItem(ModItems.Crimsonite_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CRIMSON_CHESTPLATE) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimsonite_upgrade_smithing_template),
                Ingredient.ofItems(Items.NETHERITE_LEGGINGS),
                Ingredient.ofItems(ModItems.Crimsonite_Ingot),
                RecipeCategory.COMBAT,
                ModItems.CRIMSON_LEGGINGS
        ).criterion(hasItem(ModItems.Crimsonite_Ingot), conditionsFromItem(ModItems.Crimsonite_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CRIMSON_LEGGINGS) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimsonite_upgrade_smithing_template),
                Ingredient.ofItems(Items.NETHERITE_BOOTS),
                Ingredient.ofItems(ModItems.Crimsonite_Ingot),
                RecipeCategory.COMBAT,
                ModItems.CRIMSON_BOOTS
        ).criterion(hasItem(ModItems.Crimsonite_Ingot), conditionsFromItem(ModItems.Crimsonite_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CRIMSON_BOOTS) + "_"));
SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.SOLARIUM_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.CRIMSON_HELMET),
                Ingredient.ofItems(ModItems.SOLARIUM_INGOT),
                RecipeCategory.COMBAT,
                ModItems.SOLARIUM_HELMET
        ).criterion(hasItem(ModItems.SOLARIUM_INGOT), conditionsFromItem(ModItems.SOLARIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SOLARIUM_HELMET) + "_"));
SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.SOLARIUM_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.CRIMSON_CHESTPLATE),
                Ingredient.ofItems(ModItems.SOLARIUM_INGOT),
                RecipeCategory.COMBAT,
                ModItems.SOLARIUM_CHESTPLATE
        ).criterion(hasItem(ModItems.SOLARIUM_INGOT), conditionsFromItem(ModItems.SOLARIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SOLARIUM_CHESTPLATE) + "_"));
SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.SOLARIUM_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.CRIMSON_LEGGINGS),
                Ingredient.ofItems(ModItems.SOLARIUM_INGOT),
                RecipeCategory.COMBAT,
                ModItems.SOLARIUM_LEGGINGS
        ).criterion(hasItem(ModItems.SOLARIUM_INGOT), conditionsFromItem(ModItems.SOLARIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SOLARIUM_LEGGINGS) + "_"));
SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.SOLARIUM_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.CRIMSON_BOOTS),
                Ingredient.ofItems(ModItems.SOLARIUM_INGOT),
                RecipeCategory.COMBAT,
                ModItems.SOLARIUM_BOOTS
        ).criterion(hasItem(ModItems.SOLARIUM_INGOT), conditionsFromItem(ModItems.SOLARIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SOLARIUM_BOOTS) + "_"));
SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.SOLARIUM_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.CRIMSON_SWORD),
                Ingredient.ofItems(ModItems.SOLARIUM_INGOT),
                RecipeCategory.COMBAT,
                ModItems.SOLARIUM_SWORD
        ).criterion(hasItem(ModItems.SOLARIUM_INGOT), conditionsFromItem(ModItems.SOLARIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SOLARIUM_SWORD) + "_"));
SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.SOLARIUM_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.Crimson_Pickaxe),
                Ingredient.ofItems(ModItems.SOLARIUM_INGOT),
                RecipeCategory.TOOLS,
                ModItems.SOLARIUM_PICKAXE
        ).criterion(hasItem(ModItems.SOLARIUM_INGOT), conditionsFromItem(ModItems.SOLARIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SOLARIUM_PICKAXE) + "_"));
SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.SOLARIUM_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.Crimson_Axe),
                Ingredient.ofItems(ModItems.SOLARIUM_INGOT),
                RecipeCategory.TOOLS,
                ModItems.SOLARIUM_AXE
        ).criterion(hasItem(ModItems.SOLARIUM_INGOT), conditionsFromItem(ModItems.SOLARIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SOLARIUM_AXE) + "_"));
SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.SOLARIUM_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.Crimson_Shovel),
                Ingredient.ofItems(ModItems.SOLARIUM_INGOT),
                RecipeCategory.TOOLS,
                ModItems.SOLARIUM_SHOVEL
        ).criterion(hasItem(ModItems.SOLARIUM_INGOT), conditionsFromItem(ModItems.SOLARIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SOLARIUM_SHOVEL) + "_"));
SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.SOLARIUM_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.Crimson_Hoe),
                Ingredient.ofItems(ModItems.SOLARIUM_INGOT),
                RecipeCategory.TOOLS,
                ModItems.SOLARIUM_HOE
        ).criterion(hasItem(ModItems.SOLARIUM_INGOT), conditionsFromItem(ModItems.SOLARIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SOLARIUM_HOE) + "_"));

    }
}
