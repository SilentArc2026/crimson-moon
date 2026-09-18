package name.crimsonmoon.datagen;

import name.crimsonmoon.block.ModBlocks;
import name.crimsonmoon.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

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

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.Crimson_Ingot, RecipeCategory.MISC, ModBlocks.Crimson_Block);

    }
}
