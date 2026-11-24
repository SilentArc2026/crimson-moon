package name.crimsonmoon.client.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;


import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;

public class BracerModel<T extends PlayerEntity> extends EntityModel<T> {
    public final ModelPart leftArm;
    public final ModelPart rightArm;

    public BracerModel(ModelPart root) {
        this.leftArm = root.getChild("left_arm");
        this.rightArm = root.getChild("right_arm");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        modelPartData.addChild("left_arm", ModelPartBuilder.create()
                        .uv(40, 16).mirrored().cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.75F)).mirrored(false),
                ModelTransform.pivot(5.0F, 2.0F, 0.0F));

        modelPartData.addChild("right_arm", ModelPartBuilder.create()
                        .uv(40, 16).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.75F)),
                ModelTransform.pivot(-5.0F, 2.0F, 0.0F));

        return TexturedModelData.of(modelData, 64, 32);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // Arm rotations are synced in BracerFeatureRenderer
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.leftArm.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        this.rightArm.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}