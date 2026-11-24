package name.crimsonmoon.datagen;

import name.crimsonmoon.block.ModBlocks;
import name.crimsonmoon.item.ModItems;
import name.crimsonmoon.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        generateWoodSetRecipes(
                exporter,
                ModTags.Items.CORRUPTED_LOGS,
                ModBlocks.CORRUPTED_LOG,
                ModBlocks.STRIPPED_CORRUPTED_LOG,
                ModBlocks.CORRUPTED_WOOD,
                ModBlocks.STRIPPED_CORRUPTED_WOOD,
                ModBlocks.CORRUPTED_PLANKS,
                ModBlocks.CORRUPTED_STAIRS,
                ModBlocks.CORRUPTED_SLAB,
                ModBlocks.CORRUPTED_FENCE,
                ModBlocks.CORRUPTED_FENCE_GATE,
                ModBlocks.CORRUPTED_DOOR,
                ModBlocks.CORRUPTED_TRAPDOOR,
                ModBlocks.CORRUPTED_PRESSURE_PLATE,
                ModBlocks.CORRUPTED_BUTTON,
                ModBlocks.CORRUPTED_SIGN,
                ModBlocks.CORRUPTED_WALL_SIGN,
                ModItems.CORRUPTED_HANGING_SIGN,
                ModItems.CORRUPTED_BOAT,
                ModItems.CORRUPTED_CHEST_BOAT
        );
        generateWoodSetRecipes(
                exporter,
                ModTags.Items.ACIDIC_LOGS,
                ModBlocks.ACIDIC_LOG,
                ModBlocks.STRIPPED_ACIDIC_LOG,
                ModBlocks.ACIDIC_WOOD,
                ModBlocks.STRIPPED_ACIDIC_WOOD,
                ModBlocks.ACIDIC_PLANKS,
                ModBlocks.ACIDIC_STAIRS,
                ModBlocks.ACIDIC_SLAB,
                ModBlocks.ACIDIC_FENCE,
                ModBlocks.ACIDIC_FENCE_GATE,
                ModBlocks.ACIDIC_DOOR,
                ModBlocks.ACIDIC_TRAPDOOR,
                ModBlocks.ACIDIC_PRESSURE_PLATE,
                ModBlocks.ACIDIC_BUTTON,
                ModBlocks.ACIDIC_SIGN,
                ModBlocks.ACIDIC_WALL_SIGN,
                ModItems.ACIDIC_HANGING_SIGN,
                ModItems.ACIDIC_BOAT,
                ModItems.ACIDIC_CHEST_BOAT
        );
        generateWoodSetRecipes(
                exporter,
                ModTags.Items.CHARRED_LOGS,
                ModBlocks.CHARRED_LOG,
                ModBlocks.STRIPPED_CHARRED_LOG,
                ModBlocks.CHARRED_WOOD,
                ModBlocks.STRIPPED_CHARRED_WOOD,
                ModBlocks.CHARRED_PLANKS,
                ModBlocks.CHARRED_STAIRS,
                ModBlocks.CHARRED_SLAB,
                ModBlocks.CHARRED_FENCE,
                ModBlocks.CHARRED_FENCE_GATE,
                ModBlocks.CHARRED_DOOR,
                ModBlocks.CHARRED_TRAPDOOR,
                ModBlocks.CHARRED_PRESSURE_PLATE,
                ModBlocks.CHARRED_BUTTON,
                ModBlocks.CHARRED_SIGN,
                ModBlocks.CHARRED_WALL_SIGN,
                ModItems.CHARRED_HANGING_SIGN,
                ModItems.CHARRED_BOAT,
                ModItems.CHARRED_CHEST_BOAT
        );
        generateWoodSetRecipes(
                exporter,
                ModTags.Items.PALM_LOGS,
                ModBlocks.PALM_LOG,
                ModBlocks.STRIPPED_PALM_LOG,
                ModBlocks.PALM_WOOD,
                ModBlocks.STRIPPED_PALM_WOOD,
                ModBlocks.PALM_PLANKS,
                ModBlocks.PALM_STAIRS,
                ModBlocks.PALM_SLAB,
                ModBlocks.PALM_FENCE,
                ModBlocks.PALM_FENCE_GATE,
                ModBlocks.PALM_DOOR,
                ModBlocks.PALM_TRAPDOOR,
                ModBlocks.PALM_PRESSURE_PLATE,
                ModBlocks.PALM_BUTTON,
                ModBlocks.PALM_SIGN,
                ModBlocks.PALM_WALL_SIGN,
                ModItems.PALM_HANGING_SIGN,
                ModItems.PALM_BOAT,
                ModItems.PALM_CHEST_BOAT
        );
        generateWoodSetRecipes(
                exporter,
                ModTags.Items.WITHERED_PALM_LOGS,
                ModBlocks.WITHERED_PALM_LOG,
                ModBlocks.STRIPPED_WITHERED_PALM_LOG,
                ModBlocks.WITHERED_PALM_WOOD,
                ModBlocks.STRIPPED_WITHERED_PALM_WOOD,
                ModBlocks.WITHERED_PALM_PLANKS,
                ModBlocks.WITHERED_PALM_STAIRS,
                ModBlocks.WITHERED_PALM_SLAB,
                ModBlocks.WITHERED_PALM_FENCE,
                ModBlocks.WITHERED_PALM_FENCE_GATE,
                ModBlocks.WITHERED_PALM_DOOR,
                ModBlocks.WITHERED_PALM_TRAPDOOR,
                ModBlocks.WITHERED_PALM_PRESSURE_PLATE,
                ModBlocks.WITHERED_PALM_BUTTON,
                ModBlocks.WITHERED_PALM_SIGN,
                ModBlocks.WITHERED_PALM_WALL_SIGN,
                ModItems.WITHERED_PALM_HANGING_SIGN,
                ModItems.WITHERED_PALM_BOAT,
                ModItems.WITHERED_PALM_CHEST_BOAT
        );



        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.Crimsonite_Ingot)
                .pattern("CCN")
                .pattern("CG ")
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TURQITE_UPGRADE_SMITHING_TEMPLATE)
                .pattern("CCC")
                .pattern("CNC")
                .pattern("CDC")
                .input('C', ModItems.REFINED_TURQITE)
                .input('D', Items.DIAMOND)
                .input('N', Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                .criterion(hasItem(ModItems.REFINED_TURQITE), conditionsFromItem(ModItems.REFINED_TURQITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TURQITE_UPGRADE_SMITHING_TEMPLATE) + "_"));
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
                .pattern("V")
                .pattern("V")
                .pattern("D")
                .input('D', ModItems.DIAMOND_ROD)
                .input('V', ModItems.VAMPYRITE_INGOT)
                .criterion(hasItem(ModItems.DIAMOND_ROD), conditionsFromItem(ModItems.DIAMOND_ROD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VAMPYRITE_SWORD) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VAMPYRITE_SHOVEL)
                .pattern("V")
                .pattern("D")
                .pattern("D")
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
                .pattern("VV")
                .pattern("VD")
                .pattern(" D")
                .input('D', ModItems.DIAMOND_ROD)
                .input('V', ModItems.VAMPYRITE_INGOT)
                .criterion(hasItem(ModItems.DIAMOND_ROD), conditionsFromItem(ModItems.DIAMOND_ROD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VAMPYRITE_AXE) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VAMPYRITE_HOE)
                .pattern("VV")
                .pattern(" D")
                .pattern(" D")
                .input('D', ModItems.DIAMOND_ROD)
                .input('V', ModItems.VAMPYRITE_INGOT)
                .criterion(hasItem(ModItems.DIAMOND_ROD), conditionsFromItem(ModItems.DIAMOND_ROD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VAMPYRITE_HOE) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SOLARIUM_INGOT, 1)
                .pattern("BNB")
                .pattern("NSN")
                .pattern("BNB")
                .input('N', Items.NETHERITE_BLOCK)
                .input('B', Items.BLAZE_ROD)
                .input('S', ModItems.SOLAR_STAR)
                .criterion(hasItem(ModItems.SOLAR_STAR), conditionsFromItem(ModItems.SOLAR_STAR))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SOLARIUM_INGOT) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SOLAR_STAR, 1)
                .pattern("BGB")
                .pattern("GSG")
                .pattern("BGB")
                .input('G', Items.GOLD_INGOT)
                .input('B', Items.BLAZE_ROD)
                .input('S', Items.NETHER_STAR)
                .criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SOLAR_STAR) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.POLISHED_DOLOMITE, 4)
                .pattern("DD")
                .pattern("DD")
                .input('D', ModBlocks.DOLOMITE)
                .criterion(hasItem(ModBlocks.DOLOMITE), conditionsFromItem(ModBlocks.DOLOMITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.POLISHED_DOLOMITE) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.DOLOMITE_BRICKS, 4)
                .pattern("PP")
                .pattern("PP")
                .input('P', ModBlocks.POLISHED_DOLOMITE)
                .criterion(hasItem(ModBlocks.POLISHED_DOLOMITE), conditionsFromItem(ModBlocks.POLISHED_DOLOMITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.DOLOMITE_BRICKS) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PALM_MOSAIC)
                .pattern("P")
                .pattern("P")
                .input('P', ModBlocks.PALM_SLAB)
                .criterion(hasItem(ModBlocks.PALM_PLANKS), conditionsFromItem(ModBlocks.PALM_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PALM_MOSAIC) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PALM_MOSAIC_SLAB, 6)
                .pattern("PPP")
                .input('P', ModBlocks.PALM_MOSAIC)
                .criterion(hasItem(ModBlocks.PALM_MOSAIC), conditionsFromItem(ModBlocks.PALM_MOSAIC))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PALM_MOSAIC_SLAB) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PALM_MOSAIC_STAIRS, 4)
                .pattern("P  ")
                .pattern("PP ")
                .pattern("PPP")
                .input('P', ModBlocks.PALM_MOSAIC)
                .criterion(hasItem(ModBlocks.PALM_MOSAIC), conditionsFromItem(ModBlocks.PALM_MOSAIC))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PALM_MOSAIC_STAIRS) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.WITHERED_PALM_MOSAIC)
                .pattern("P")
                .pattern("P")
                .input('P', ModBlocks.WITHERED_PALM_SLAB)
                .criterion(hasItem(ModBlocks.WITHERED_PALM_SLAB), conditionsFromItem(ModBlocks.WITHERED_PALM_SLAB))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.WITHERED_PALM_MOSAIC) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.WITHERED_PALM_MOSAIC_SLAB, 6)
                .pattern("PPP")
                .input('P', ModBlocks.WITHERED_PALM_MOSAIC)
                .criterion(hasItem(ModBlocks.WITHERED_PALM_MOSAIC), conditionsFromItem(ModBlocks.WITHERED_PALM_MOSAIC))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.WITHERED_PALM_MOSAIC_SLAB) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.WITHERED_PALM_MOSAIC_STAIRS, 4)
                .pattern("P  ")
                .pattern("PP ")
                .pattern("PPP")
                .input('P', ModBlocks.WITHERED_PALM_MOSAIC)
                .criterion(hasItem(ModBlocks.WITHERED_PALM_MOSAIC), conditionsFromItem(ModBlocks.WITHERED_PALM_MOSAIC))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.WITHERED_PALM_MOSAIC_STAIRS) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ACIDIC_TRAPPED_RUG)
                .pattern("LL")
                .input('L', ModItems.ACIDIC_LEATHER)
                .criterion(hasItem(ModItems.ACIDIC_LEATHER), conditionsFromItem(ModItems.ACIDIC_LEATHER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ACIDIC_TRAPPED_RUG) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.ACIDIC_SADDLE)
                .pattern(" L ")
                .pattern("LIL")
                .input('L', ModItems.ACIDIC_LEATHER)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ACIDIC_SADDLE) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DARKSTEEL_PICKAXE)
                .pattern("DDD")
                .pattern(" S ")
                .pattern(" S ")
                .input('D', ModItems.DARKSTEEL_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.DARKSTEEL_INGOT), conditionsFromItem(ModItems.DARKSTEEL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DARKSTEEL_PICKAXE) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DARKSTEEL_HATCHET)
                .pattern("DD")
                .pattern("DS")
                .pattern(" S")
                .input('D', ModItems.DARKSTEEL_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.DARKSTEEL_INGOT), conditionsFromItem(ModItems.DARKSTEEL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DARKSTEEL_HATCHET) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DARKSTEEL_DAGGER)
                .pattern("D")
                .pattern("D")
                .pattern("S")
                .input('D', ModItems.DARKSTEEL_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.DARKSTEEL_INGOT), conditionsFromItem(ModItems.DARKSTEEL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DARKSTEEL_DAGGER) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DARKSTEEL_SPADE)
                .pattern("D")
                .pattern("S")
                .pattern("S")
                .input('D', ModItems.DARKSTEEL_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.DARKSTEEL_INGOT), conditionsFromItem(ModItems.DARKSTEEL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DARKSTEEL_SPADE) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DARKSTEEL_TROWEL)
                .pattern("DD")
                .pattern(" S")
                .pattern(" S")
                .input('D', ModItems.DARKSTEEL_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.DARKSTEEL_INGOT), conditionsFromItem(ModItems.DARKSTEEL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DARKSTEEL_TROWEL) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.DARKSTEEL_DOOR, 3)
                .pattern("DD")
                .pattern("DD")
                .pattern("DD")
                .input('D', ModItems.DARKSTEEL_INGOT)
                .criterion(hasItem(ModItems.DARKSTEEL_INGOT), conditionsFromItem(ModItems.DARKSTEEL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.DARKSTEEL_DOOR) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.DARKSTEEL_BLOCK)
                .pattern("DDD")
                .pattern("DDD")
                .pattern("DDD")
                .input('D', ModItems.DARKSTEEL_INGOT)
                .criterion(hasItem(ModItems.DARKSTEEL_INGOT), conditionsFromItem(ModItems.DARKSTEEL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.DARKSTEEL_BLOCK) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DARKSTEEL_HELMET)
                .pattern("DDD")
                .pattern("D D")
                .input('D', ModItems.DARKSTEEL_INGOT)
                .criterion(hasItem(ModItems.DARKSTEEL_INGOT), conditionsFromItem(ModItems.DARKSTEEL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DARKSTEEL_HELMET) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DARKSTEEL_CHESTPLATE)
                .pattern("D D")
                .pattern("DDD")
                .pattern("DDD")
                .input('D', ModItems.DARKSTEEL_INGOT)
                .criterion(hasItem(ModItems.DARKSTEEL_INGOT), conditionsFromItem(ModItems.DARKSTEEL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DARKSTEEL_CHESTPLATE) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DARKSTEEL_LEGGINGS)
                .pattern("DDD")
                .pattern("D D")
                .pattern("D D")
                .input('D', ModItems.DARKSTEEL_INGOT)
                .criterion(hasItem(ModItems.DARKSTEEL_INGOT), conditionsFromItem(ModItems.DARKSTEEL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DARKSTEEL_LEGGINGS) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DARKSTEEL_BOOTS)
                .pattern("D D")
                .pattern("D D")
                .input('D', ModItems.DARKSTEEL_INGOT)
                .criterion(hasItem(ModItems.DARKSTEEL_INGOT), conditionsFromItem(ModItems.DARKSTEEL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DARKSTEEL_BOOTS) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.DARKSTEEL_TRAPDOOR)
                .pattern("DD")
                .pattern("DD")
                .input('D', ModItems.DARKSTEEL_INGOT)
                .criterion(hasItem(ModItems.DARKSTEEL_INGOT), conditionsFromItem(ModItems.DARKSTEEL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.DARKSTEEL_TRAPDOOR) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DARKSTEEL_INGOT)
                .pattern("DDD")
                .pattern("DDD")
                .pattern("DDD")
                .input('D', ModItems.DARKSTEEL_NUGGET)
                .criterion(hasItem(ModItems.DARKSTEEL_NUGGET), conditionsFromItem(ModItems.DARKSTEEL_NUGGET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DARKSTEEL_INGOT) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DARKSTEEL_HORSE_ARMOR)
                .pattern("D D")
                .pattern("DDD")
                .pattern("D D")
                .input('D', ModItems.DARKSTEEL_INGOT)
                .criterion(hasItem(ModItems.DARKSTEEL_INGOT), conditionsFromItem(ModItems.DARKSTEEL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DARKSTEEL_HORSE_ARMOR) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.DARKSTEEL_BARS, 16)
                .pattern("DDD")
                .pattern("DDD")
                .input('D', ModItems.DARKSTEEL_INGOT)
                .criterion(hasItem(ModItems.DARKSTEEL_INGOT), conditionsFromItem(ModItems.DARKSTEEL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.DARKSTEEL_BARS) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.DARKSTEEL_LANTERN)
                .pattern("DDD")
                .pattern("DTD")
                .pattern("DDD")
                .input('D', ModItems.DARKSTEEL_NUGGET)
                .input('T', Items.TORCH)
                .criterion(hasItem(ModItems.DARKSTEEL_NUGGET), conditionsFromItem(ModItems.DARKSTEEL_NUGGET))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.DARKSTEEL_LANTERN) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.DARKSTEEL_SOUL_LANTERN)
                .pattern("DDD")
                .pattern("DTD")
                .pattern("DDD")
                .input('D', ModItems.DARKSTEEL_NUGGET)
                .input('T', Items.SOUL_TORCH)
                .criterion(hasItem(ModItems.DARKSTEEL_NUGGET), conditionsFromItem(ModItems.DARKSTEEL_NUGGET))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.DARKSTEEL_SOUL_LANTERN) + "_"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.DARKSTEEL_CHAIN)
                .pattern("N")
                .pattern("I")
                .pattern("N")
                .input('N', ModItems.DARKSTEEL_NUGGET)
                .input('I', ModItems.DARKSTEEL_INGOT)
                .criterion(hasItem(ModItems.DARKSTEEL_INGOT), conditionsFromItem(ModItems.DARKSTEEL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.DARKSTEEL_CHAIN) + "_"));

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.Crimsonite_Ingot, RecipeCategory.MISC, ModBlocks.Crimsonite_Block);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SOLARIUM_INGOT, RecipeCategory.MISC, ModBlocks.Solarium_Block);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.VAMPYRITE_INGOT, RecipeCategory.MISC, ModBlocks.Vampyrite_Block);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RAW_VAMPYRITE, RecipeCategory.MISC, ModBlocks.Raw_Vampyrite_Block);
        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_SANDSTONE, ModBlocks.BLACK_SAND);
        createStairsRecipe(ModBlocks.CUT_BLACK_SANDSTONE_STAIRS, Ingredient.ofItems(ModBlocks.CUT_BLACK_SANDSTONE))
                .criterion(hasItem(ModBlocks.CUT_BLACK_SANDSTONE), conditionsFromItem(ModBlocks.CUT_BLACK_SANDSTONE))
                .offerTo(exporter);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BLACK_SANDSTONE_SLAB, ModBlocks.CUT_BLACK_SANDSTONE);
        createStairsRecipe(ModBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS, Ingredient.ofItems(ModBlocks.SMOOTH_BLACK_SANDSTONE))
                .criterion(hasItem(ModBlocks.SMOOTH_BLACK_SANDSTONE), conditionsFromItem(ModBlocks.SMOOTH_BLACK_SANDSTONE))
                .offerTo(exporter);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_BLACK_SANDSTONE_SLAB, ModBlocks.SMOOTH_BLACK_SANDSTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BLACK_SANDSTONE_STAIRS, ModBlocks.BLACK_SANDSTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BLACK_SANDSTONE_STAIRS, ModBlocks.CUT_BLACK_SANDSTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BLACK_SANDSTONE_SLAB, ModBlocks.BLACK_SANDSTONE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BLACK_SANDSTONE_SLAB, ModBlocks.CUT_BLACK_SANDSTONE, 2);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS, ModBlocks.SMOOTH_BLACK_SANDSTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_BLACK_SANDSTONE_SLAB, ModBlocks.SMOOTH_BLACK_SANDSTONE, 2);


        offerCutCopperRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BLACK_SANDSTONE, ModBlocks.BLACK_SANDSTONE);
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_BLACK_SANDSTONE, ModBlocks.BLACK_SANDSTONE_SLAB);

        createStairsRecipe(ModBlocks.BLACK_SANDSTONE_STAIRS, Ingredient.ofItems(ModBlocks.BLACK_SANDSTONE))
                .criterion(hasItem(ModBlocks.BLACK_SANDSTONE), conditionsFromItem(ModBlocks.BLACK_SANDSTONE))
                .offerTo(exporter);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_SANDSTONE_SLAB, ModBlocks.BLACK_SANDSTONE);
        offerWallRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.BLACK_SANDSTONE_WALL, ModBlocks.BLACK_SANDSTONE);

        offerSmelting(exporter, List.of(ModBlocks.BLACK_SANDSTONE), RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.SMOOTH_BLACK_SANDSTONE, 0.1f, 200, "black_sandstone");

        offerBracerCraftingRecipe(exporter, ModItems.LEATHER_BRACERS, Items.LEATHER);
        offerBracerCraftingRecipe(exporter, ModItems.CHAIN_FISHNETS, Items.CHAIN);
        offerBracerCraftingRecipe(exporter, ModItems.IRON_BRACERS, Items.IRON_INGOT);
        offerBracerCraftingRecipe(exporter, ModItems.GOLD_BRACERS, Items.GOLD_INGOT);
        offerBracerCraftingRecipe(exporter, ModItems.DIAMOND_BRACERS, Items.DIAMOND);
        offerBracerCraftingRecipe(exporter, ModItems.DARKSTEEL_BRACERS, ModItems.DARKSTEEL_INGOT);
        offerBracerCraftingRecipe(exporter, ModItems.VAMPYRITE_BRACERS, ModItems.VAMPYRITE_INGOT);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BLACK_SANDSTONE, ModBlocks.BLACK_SANDSTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_BLACK_SANDSTONE, ModBlocks.BLACK_SANDSTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_SANDSTONE_STAIRS, ModBlocks.BLACK_SANDSTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_SANDSTONE_SLAB, ModBlocks.BLACK_SANDSTONE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.BLACK_SANDSTONE_WALL, ModBlocks.BLACK_SANDSTONE);

        offerSmelting(exporter, List.of(ModItems.RAW_VAMPYRITE, ModBlocks.Vampyrite_Ore, ModBlocks.Deepslate_Vampyrite_Ore),
                RecipeCategory.MISC, ModItems.VAMPYRITE_INGOT, .25f, 200, "vampyrite_ingot");
        offerBlasting(exporter, List.of(ModItems.RAW_VAMPYRITE, ModBlocks.Vampyrite_Ore, ModBlocks.Deepslate_Vampyrite_Ore),
                RecipeCategory.MISC, ModItems.VAMPYRITE_INGOT, .25f, 200, "vampyrite_ingot");
        offerSmelting(exporter, List.of(ModItems.TURQITE_CRYSTAL),
                RecipeCategory.MISC, ModItems.REFINED_TURQITE, .25f, 200, "refined_turqite");
        offerBlasting(exporter, List.of(ModItems.TURQITE_CRYSTAL),
                RecipeCategory.MISC, ModItems.REFINED_TURQITE, .25f, 200, "refined_turqite");
        offerSmelting(exporter, List.of(ModItems.RAW_ACIDIC_BEEF),
                RecipeCategory.MISC, Items.COOKED_BEEF, .25f, 200, "cooked_beef");
        offerFoodCookingRecipe(exporter, "furnace", RecipeSerializer.SMELTING, 200, ModItems.RAW_ACIDIC_BEEF, Items.COOKED_BEEF, 0.35f);
        offerFoodCookingRecipe(exporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, 400, ModItems.RAW_ACIDIC_BEEF, Items.COOKED_BEEF, 0.35f);
        offerFoodCookingRecipe(exporter, "smoker", RecipeSerializer.SMOKING, 100, ModItems.RAW_ACIDIC_BEEF, Items.COOKED_BEEF, 0.35f);
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimsonite_upgrade_smithing_template),
                Ingredient.ofItems(ModItems.TURQITE_SWORD),
                Ingredient.ofItems(ModItems.Crimsonite_Ingot),
                RecipeCategory.COMBAT,
                ModItems.CRIMSON_SWORD
        ).criterion(hasItem(ModItems.Crimsonite_Ingot), conditionsFromItem(ModItems.Crimsonite_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CRIMSON_SWORD) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.HEAVENLY_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.SOLARIUM_SWORD),
                Ingredient.ofItems(ModItems.SOLAR_STAR),
                RecipeCategory.COMBAT,
                ModItems.HEAVENLY_BLADE
        ).criterion(hasItem(ModItems.HEAVENLY_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.HEAVENLY_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HEAVENLY_BLADE) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimsonite_upgrade_smithing_template),
                Ingredient.ofItems(ModItems.TURQITE_PICKAXE),
                Ingredient.ofItems(ModItems.Crimsonite_Ingot),
                RecipeCategory.TOOLS,
                ModItems.Crimson_Pickaxe
        ).criterion(hasItem(ModItems.Crimsonite_Ingot), conditionsFromItem(ModItems.Crimsonite_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.Crimson_Pickaxe) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimsonite_upgrade_smithing_template),
                Ingredient.ofItems(ModItems.TURQITE_AXE),
                Ingredient.ofItems(ModItems.Crimsonite_Ingot),
                RecipeCategory.TOOLS,
                ModItems.Crimson_Axe
        ).criterion(hasItem(ModItems.Crimsonite_Ingot), conditionsFromItem(ModItems.Crimsonite_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.Crimson_Axe) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimsonite_upgrade_smithing_template),
                Ingredient.ofItems(ModItems.TURQITE_SHOVEL),
                Ingredient.ofItems(ModItems.Crimsonite_Ingot),
                RecipeCategory.TOOLS,
                ModItems.Crimson_Shovel
        ).criterion(hasItem(ModItems.Crimsonite_Ingot), conditionsFromItem(ModItems.Crimsonite_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.Crimson_Shovel) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimsonite_upgrade_smithing_template),
                Ingredient.ofItems(ModItems.TURQITE_HOE),
                Ingredient.ofItems(ModItems.Crimsonite_Ingot),
                RecipeCategory.TOOLS,
                ModItems.Crimson_Hoe
        ).criterion(hasItem(ModItems.Crimsonite_Ingot), conditionsFromItem(ModItems.Crimsonite_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.Crimson_Hoe) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimsonite_upgrade_smithing_template),
                Ingredient.ofItems(ModItems.TURQITE_HELMET),
                Ingredient.ofItems(ModItems.Crimsonite_Ingot),
                RecipeCategory.COMBAT,
                ModItems.CRIMSON_HELMET
        ).criterion(hasItem(ModItems.Crimsonite_Ingot), conditionsFromItem(ModItems.Crimsonite_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CRIMSON_HELMET) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimsonite_upgrade_smithing_template),
                Ingredient.ofItems(ModItems.TURQITE_CHESTPLATE),
                Ingredient.ofItems(ModItems.Crimsonite_Ingot),
                RecipeCategory.COMBAT,
                ModItems.CRIMSON_CHESTPLATE
        ).criterion(hasItem(ModItems.Crimsonite_Ingot), conditionsFromItem(ModItems.Crimsonite_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CRIMSON_CHESTPLATE) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimsonite_upgrade_smithing_template),
                Ingredient.ofItems(ModItems.TURQITE_LEGGINGS),
                Ingredient.ofItems(ModItems.Crimsonite_Ingot),
                RecipeCategory.COMBAT,
                ModItems.CRIMSON_LEGGINGS
        ).criterion(hasItem(ModItems.Crimsonite_Ingot), conditionsFromItem(ModItems.Crimsonite_Ingot))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CRIMSON_LEGGINGS) + "_"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.Crimsonite_upgrade_smithing_template),
                Ingredient.ofItems(ModItems.TURQITE_BOOTS),
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
                Ingredient.ofItems(ModItems.DARKSTEEL_DAGGER),
                Ingredient.ofItems(ModItems.SOLARIUM_INGOT),
                RecipeCategory.COMBAT,
                ModItems.SOLARIUM_SWORD
        ).criterion(hasItem(ModItems.SOLARIUM_INGOT), conditionsFromItem(ModItems.SOLARIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SOLARIUM_SWORD) + "_"));
SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.SOLARIUM_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.DARKSTEEL_PICKAXE),
                Ingredient.ofItems(ModItems.SOLARIUM_INGOT),
                RecipeCategory.TOOLS,
                ModItems.SOLARIUM_PICKAXE
        ).criterion(hasItem(ModItems.SOLARIUM_INGOT), conditionsFromItem(ModItems.SOLARIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SOLARIUM_PICKAXE) + "_"));
SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.SOLARIUM_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.DARKSTEEL_HATCHET),
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
SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.TURQITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.VAMPYRITE_HELMET),
                Ingredient.ofItems(ModItems.REFINED_TURQITE),
                RecipeCategory.COMBAT,
                ModItems.TURQITE_HELMET
        ).criterion(hasItem(ModItems.REFINED_TURQITE), conditionsFromItem(ModItems.REFINED_TURQITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TURQITE_HELMET) + "_"));
SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.TURQITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.VAMPYRITE_CHESTPLATE),
                Ingredient.ofItems(ModItems.REFINED_TURQITE),
                RecipeCategory.COMBAT,
                ModItems.TURQITE_CHESTPLATE
        ).criterion(hasItem(ModItems.REFINED_TURQITE), conditionsFromItem(ModItems.REFINED_TURQITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TURQITE_CHESTPLATE) + "_"));
SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.TURQITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.VAMPYRITE_LEGGINGS),
                Ingredient.ofItems(ModItems.REFINED_TURQITE),
                RecipeCategory.COMBAT,
                ModItems.TURQITE_LEGGINGS
        ).criterion(hasItem(ModItems.REFINED_TURQITE), conditionsFromItem(ModItems.REFINED_TURQITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TURQITE_LEGGINGS) + "_"));
SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.TURQITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.VAMPYRITE_BOOTS),
                Ingredient.ofItems(ModItems.REFINED_TURQITE),
                RecipeCategory.COMBAT,
                ModItems.TURQITE_BOOTS
        ).criterion(hasItem(ModItems.REFINED_TURQITE), conditionsFromItem(ModItems.REFINED_TURQITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TURQITE_BOOTS) + "_"));
SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.TURQITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.VAMPYRITE_SWORD),
                Ingredient.ofItems(ModItems.REFINED_TURQITE),
                RecipeCategory.COMBAT,
                ModItems.TURQITE_SWORD
        ).criterion(hasItem(ModItems.REFINED_TURQITE), conditionsFromItem(ModItems.REFINED_TURQITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TURQITE_SWORD) + "_"));
SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.TURQITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.VAMPYRITE_PICKAXE),
                Ingredient.ofItems(ModItems.REFINED_TURQITE),
                RecipeCategory.TOOLS,
                ModItems.TURQITE_PICKAXE
        ).criterion(hasItem(ModItems.REFINED_TURQITE), conditionsFromItem(ModItems.REFINED_TURQITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TURQITE_PICKAXE) + "_"));
SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.TURQITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.VAMPYRITE_AXE),
                Ingredient.ofItems(ModItems.REFINED_TURQITE),
                RecipeCategory.TOOLS,
                ModItems.TURQITE_AXE
        ).criterion(hasItem(ModItems.REFINED_TURQITE), conditionsFromItem(ModItems.REFINED_TURQITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TURQITE_AXE) + "_"));
SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.TURQITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.VAMPYRITE_SHOVEL),
                Ingredient.ofItems(ModItems.REFINED_TURQITE),
                RecipeCategory.TOOLS    ,
                ModItems.TURQITE_SHOVEL
        ).criterion(hasItem(ModItems.REFINED_TURQITE), conditionsFromItem(ModItems.REFINED_TURQITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TURQITE_SHOVEL) + "_"));
SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.TURQITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.VAMPYRITE_HOE),
                Ingredient.ofItems(ModItems.REFINED_TURQITE),
                RecipeCategory.TOOLS,
                ModItems.TURQITE_HOE
        ).criterion(hasItem(ModItems.REFINED_TURQITE), conditionsFromItem(ModItems.REFINED_TURQITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TURQITE_HOE) + "_"));
offerBracerSmithingRecipe(exporter,
                Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE,
                ModItems.DIAMOND_BRACERS,
                Items.NETHERITE_INGOT,
                ModItems.NETHERITE_BRACERS,
                "netherite_bracers_smithing");
offerBracerSmithingRecipe(exporter,
                ModItems.SOLARIUM_UPGRADE_SMITHING_TEMPLATE,
                ModItems.DARKSTEEL_BRACERS,
                ModItems.SOLARIUM_INGOT,
                ModItems.SOLARIUM_BRACERS,
                "solarium_bracers_smithing");
offerBracerSmithingRecipe(exporter,
                ModItems.TURQITE_UPGRADE_SMITHING_TEMPLATE,
                ModItems.VAMPYRITE_BRACERS,
                ModItems.REFINED_TURQITE,
                ModItems.TURQITE_BRACERS,
                "turqite_bracers_smithing");
offerBracerSmithingRecipe(exporter,
                ModItems.Crimsonite_upgrade_smithing_template,  // Replace with your template item
                ModItems.TURQITE_BRACERS,                   // Replace with the base bracer required for Crimson
                ModItems.Crimsonite_Ingot,                     // Replace with your Crimson ingot/gem item
                ModItems.CRIMSON_BRACERS,
                "crimson_bracers_smithing");

    }

    private static void offerBracerCraftingRecipe(Consumer<RecipeJsonProvider> exporter, Item result, Item material) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, result)
                .pattern("M M")
                .pattern("M M")
                .input('M', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    private static void offerBracerSmithingRecipe(Consumer<RecipeJsonProvider> exporter, Item template, Item base, Item addition, Item result, String recipeName) {
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(template),
                        Ingredient.ofItems(base),
                        Ingredient.ofItems(addition),
                        RecipeCategory.COMBAT,
                        result)
                .criterion(hasItem(addition), conditionsFromItem(addition))
                .offerTo(exporter, new Identifier("crimson-moon", recipeName));
    }
    private void generateWoodSetRecipes(
            Consumer<RecipeJsonProvider> exporter,
            TagKey<Item> logItemTag,
            Block log, Block strippedLog, Block wood, Block strippedWood,
            Block planks, Block stairs, Block slab, Block fence, Block fenceGate,
            Block door, Block trapdoor, Block pressurePlate, Block button,
            Block standingSign, Block wallSign, ItemConvertible hangingSignItem,
            ItemConvertible boatItem, ItemConvertible chestBoatItem
    ) {
        offerPlanksRecipe(exporter, planks, logItemTag, 4);
        offerBarkBlockRecipe(exporter, wood, log);
        offerBarkBlockRecipe(exporter, strippedWood, strippedLog);
        offerHangingSignRecipe(exporter, hangingSignItem, strippedLog);

        offerBoatRecipe(exporter, boatItem, planks);
        offerChestBoatRecipe(exporter, chestBoatItem, boatItem);

        BlockFamily family = new BlockFamily.Builder(planks)
                .stairs(stairs)
                .slab(slab)
                .fence(fence)
                .fenceGate(fenceGate)
                .door(door)
                .trapdoor(trapdoor)
                .pressurePlate(pressurePlate)
                .button(button)
                .sign(standingSign, wallSign)
                .group("wooden")
                .unlockCriterionName("has_planks")
                .build();

        generateFamily(exporter, family);
    }




}
