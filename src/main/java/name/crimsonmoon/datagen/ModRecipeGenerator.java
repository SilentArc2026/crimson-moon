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
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.Crimson_Ingot)
                .pattern("CCN")
                .pattern("CG ")
                .pattern("   ")
                .input('C', ModItems.Crimson_Plate)
                .input('G', Items.GOLD_INGOT)
                .input('N', Items.NETHERITE_SCRAP)
                .criterion(hasItem(ModItems.Crimson_Plate), conditionsFromItem(ModItems.Crimson_Plate))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.Crimson_Ingot) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.Crimson_upgrade_smithing_template)
                .pattern("CCC")
                .pattern("CNC")
                .pattern("CDC")
                .input('C', ModItems.Crimson_Plate)
                .input('D', Items.DIAMOND)
                .input('N', Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                .criterion(hasItem(ModItems.Crimson_Plate), conditionsFromItem(ModItems.Crimson_Plate))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.Crimson_upgrade_smithing_template) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.Crimson_Block)
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModItems.Crimson_Ingot)
                .criterion(hasItem(ModItems.Crimson_Ingot), conditionsFromItem(ModItems.Crimson_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.Crimson_Block) + "_"));
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

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.Crimson_Ingot, RecipeCategory.MISC, ModBlocks.Crimson_Block);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SOLARIUM_INGOT, RecipeCategory.MISC, ModBlocks.Solarium_Block);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.VAMPYRITE_INGOT, RecipeCategory.MISC, ModBlocks.Vampyrite_Block);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RAW_VAMPYRITE, RecipeCategory.MISC, ModBlocks.Raw_Vampyrite_Block);
        offerSmelting(exporter, List.of(ModItems.RAW_VAMPYRITE, ModBlocks.Vampyrite_Ore, ModBlocks.Deepslate_Vampyrite_Ore),
                RecipeCategory.MISC, ModItems.VAMPYRITE_INGOT, .25f, 200, "vampyrite_ingot");
        offerBlasting(exporter, List.of(ModItems.RAW_VAMPYRITE, ModBlocks.Vampyrite_Ore, ModBlocks.Deepslate_Vampyrite_Ore),
                RecipeCategory.MISC, ModItems.VAMPYRITE_INGOT, .25f, 200, "vampyrite_ingot");
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimson_upgrade_smithing_template),
                Ingredient.ofItems(Items.NETHERITE_SWORD),
                Ingredient.ofItems(ModItems.Crimson_Ingot),
                RecipeCategory.COMBAT,
                ModItems.CRIMSON_SWORD
        ).criterion(hasItem(ModItems.Crimson_Ingot), conditionsFromItem(ModItems.Crimson_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CRIMSON_SWORD) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimson_upgrade_smithing_template),
                Ingredient.ofItems(Items.NETHERITE_PICKAXE),
                Ingredient.ofItems(ModItems.Crimson_Ingot),
                RecipeCategory.TOOLS,
                ModItems.Crimson_Pickaxe
        ).criterion(hasItem(ModItems.Crimson_Ingot), conditionsFromItem(ModItems.Crimson_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.Crimson_Pickaxe) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimson_upgrade_smithing_template),
                Ingredient.ofItems(Items.NETHERITE_AXE),
                Ingredient.ofItems(ModItems.Crimson_Ingot),
                RecipeCategory.TOOLS,
                ModItems.Crimson_Axe
        ).criterion(hasItem(ModItems.Crimson_Ingot), conditionsFromItem(ModItems.Crimson_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.Crimson_Axe) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimson_upgrade_smithing_template),
                Ingredient.ofItems(Items.NETHERITE_SHOVEL),
                Ingredient.ofItems(ModItems.Crimson_Ingot),
                RecipeCategory.TOOLS,
                ModItems.Crimson_Shovel
        ).criterion(hasItem(ModItems.Crimson_Ingot), conditionsFromItem(ModItems.Crimson_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.Crimson_Shovel) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimson_upgrade_smithing_template),
                Ingredient.ofItems(Items.NETHERITE_HOE),
                Ingredient.ofItems(ModItems.Crimson_Ingot),
                RecipeCategory.TOOLS,
                ModItems.Crimson_Hoe
        ).criterion(hasItem(ModItems.Crimson_Ingot), conditionsFromItem(ModItems.Crimson_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.Crimson_Hoe) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimson_upgrade_smithing_template),
                Ingredient.ofItems(Items.NETHERITE_HELMET),
                Ingredient.ofItems(ModItems.Crimson_Ingot),
                RecipeCategory.COMBAT,
                ModItems.CRIMSON_HELMET
        ).criterion(hasItem(ModItems.Crimson_Ingot), conditionsFromItem(ModItems.Crimson_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CRIMSON_HELMET) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimson_upgrade_smithing_template),
                Ingredient.ofItems(Items.NETHERITE_CHESTPLATE),
                Ingredient.ofItems(ModItems.Crimson_Ingot),
                RecipeCategory.COMBAT,
                ModItems.CRIMSON_CHESTPLATE
        ).criterion(hasItem(ModItems.Crimson_Ingot), conditionsFromItem(ModItems.Crimson_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CRIMSON_CHESTPLATE) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimson_upgrade_smithing_template),
                Ingredient.ofItems(Items.NETHERITE_LEGGINGS),
                Ingredient.ofItems(ModItems.Crimson_Ingot),
                RecipeCategory.COMBAT,
                ModItems.CRIMSON_LEGGINGS
        ).criterion(hasItem(ModItems.Crimson_Ingot), conditionsFromItem(ModItems.Crimson_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CRIMSON_LEGGINGS) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimson_upgrade_smithing_template),
                Ingredient.ofItems(Items.NETHERITE_BOOTS),
                Ingredient.ofItems(ModItems.Crimson_Ingot),
                RecipeCategory.COMBAT,
                ModItems.CRIMSON_BOOTS
        ).criterion(hasItem(ModItems.Crimson_Ingot), conditionsFromItem(ModItems.Crimson_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CRIMSON_BOOTS) + "_"));

    }
}
