package name.crimsonmoon;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import name.crimsonmoon.block.ModBlocks;
import name.crimsonmoon.block.entity.ModBlockEntities;
import name.crimsonmoon.client.model.BracerModel;
import name.crimsonmoon.client.render.BracerFeatureRenderer;
import name.crimsonmoon.entity.ModBoats;
import name.crimsonmoon.item.ModItems;
import name.crimsonmoon.util.ModWoodTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class CrimsonMoonModClient implements ClientModInitializer {

    public static final EntityModelLayer BRACER_LAYER =
            new EntityModelLayer(new Identifier("crimson_moon", "bracer"), "main");
    @Override
    public void onInitializeClient() {

        EntityModelLayerRegistry.registerModelLayer(BRACER_LAYER, BracerModel::getTexturedModelData);

        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
            if (entityRenderer instanceof PlayerEntityRenderer playerRenderer) {
                registrationHelper.register(new BracerFeatureRenderer<>(
                        playerRenderer,
                        new BracerModel<>(context.getPart(BRACER_LAYER))
                ));
            }
        });

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Turqite_Cluster, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_TURQITE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_TURQITE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_TURQITE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORRUPTED_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACIDIC_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORRUPTED_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACIDIC_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORRUPTED_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACIDIC_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACIDIC_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACIDIC_TALL_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORRUPTED_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORRUPTED_TALL_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHARRED_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHARRED_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHARRED_FUNGUS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_CORRUPTED_POPPY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORRUPTED_POPPY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_ACID_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACID_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACIDIC_LILAC, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_CORRUPTED_CLOSED_EYEBLOSSOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_CORRUPTED_OPEN_EYEBLOSSOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORRUPTED_OPEN_EYEBLOSSOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORRUPTED_CLOSED_EYEBLOSSOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHARRED_VINES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHARRED_VINES_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORRUPTED_WITHER_ROSE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_CORRUPTED_WITHER_ROSE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALM_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALM_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALM_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WITHERED_PALM_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WITHERED_PALM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WITHERED_PALM_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WITHERED_PALM_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACIDIC_PITCHER_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACIDIC_PITCHER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORRUPTED_TORCHFLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_CORRUPTED_TORCHFLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORRUPTED_TORCHFLOWER_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_PINK_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FIRE_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_FIRE_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILD_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WEEDS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAT_TAILS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WITHERED_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WITHERED_WILD_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WITHERED_WEEDS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WITHERED_CAT_TAILS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WITHERED_LILY_PAD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORRUPTED_LILY_PAD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACIDIC_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORRUPTED_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACKENED_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLOOD_SCULK_VEIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLOOD_SCULK_SENSOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLOOD_SCULK_SHRIEKER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_ACIDIC_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_CHARRED_FUNGUS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_CORRUPTED_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_BLACKENED_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_DEAD_BLOOD_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEAD_BLOOD_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_CRIMSON_CACTUS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CRIMSON_CACTUS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARKSTEEL_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARKSTEEL_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARKSTEEL_BARS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARKSTEEL_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARKSTEEL_SOUL_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARKSTEEL_CHAIN, RenderLayer.getCutout());


        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(ModWoodTypes.ACIDIC, TexturedRenderLayers.getSignTextureId(ModWoodTypes.ACIDIC));
        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(ModWoodTypes.CORRUPTED, TexturedRenderLayers.getSignTextureId(ModWoodTypes.CORRUPTED));
        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(ModWoodTypes.CHARRED, TexturedRenderLayers.getSignTextureId(ModWoodTypes.CHARRED));
        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(ModWoodTypes.PALM, TexturedRenderLayers.getSignTextureId(ModWoodTypes.PALM));
        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(ModWoodTypes.WITHERED, TexturedRenderLayers.getSignTextureId(ModWoodTypes.WITHERED));

        BlockEntityRendererFactories.register(ModBlockEntities.MOD_SIGN_BLOCK_ENTITY, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY, HangingSignBlockEntityRenderer::new);

        TerraformBoatClientHelper.registerModelLayers(ModBoats.ACIDIC_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.CORRUPTED_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.CHARRED_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.PALM_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.WITHERED_PALM_BOAT_ID, false);

        ModelPredicateProviderRegistry.register(
                ModItems.THE_BEHEMOTHS_HORN,
                new Identifier("tooting"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F);


    }


}
