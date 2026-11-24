package name.crimsonmoon.client.render;

import name.crimsonmoon.client.model.BracerModel;
import name.crimsonmoon.item.custom.BracerItem;
import name.crimsonmoon.util.BracerHolder;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class BracerFeatureRenderer<T extends PlayerEntity, M extends PlayerEntityModel<T>> extends FeatureRenderer<T, M> {
    private final BracerModel<T> model;

    public BracerFeatureRenderer(FeatureRendererContext<T, M> context, BracerModel<T> model) {
        super(context);
        this.model = model;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T player,
                       float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        ItemStack stack = ((BracerHolder) player).crimson_moon$getEquippedBracer();
        if (stack.isEmpty() || !(stack.getItem() instanceof BracerItem bracer)) {
            return;
        }

        // Copy arm rotations and crouching/swinging transforms from the player model
        this.model.leftArm.copyTransform(this.getContextModel().leftArm);
        this.model.rightArm.copyTransform(this.getContextModel().rightArm);

        // Extract clean material name (strips "crimson-moon:" if present)
        String rawName = bracer.getMaterial().getName();
        String materialName = rawName.contains(":") ? rawName.split(":")[1] : rawName;
        String fileName = materialName.equals("chainmail") ? "chain_fishnets" : materialName + "_bracers";

        Identifier texture = new Identifier("crimson-moon", "textures/models/armor/" + fileName + ".png");

        VertexConsumer vertexConsumer = ItemRenderer.getArmorGlintConsumer(
                vertexConsumers,
                RenderLayer.getArmorCutoutNoCull(texture),
                false,
                stack.hasGlint()
        );

        // Pass 'light' (NOT 0) and 1.0F for R, G, B, A!
        this.model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
    }
}
