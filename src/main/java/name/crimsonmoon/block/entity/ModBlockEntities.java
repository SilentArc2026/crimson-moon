package name.crimsonmoon.block.entity;

import name.crimsonmoon.CrimsonMoon;
import name.crimsonmoon.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<ModSignBlockEntity> MOD_SIGN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            new Identifier(CrimsonMoon.MOD_ID, "mod_sign_entity"),
            FabricBlockEntityTypeBuilder.create(ModSignBlockEntity::new,
                    ModBlocks.ACIDIC_SIGN, ModBlocks.CHARRED_SIGN, ModBlocks.CORRUPTED_SIGN, ModBlocks.ACIDIC_WALL_SIGN, ModBlocks.CHARRED_WALL_SIGN, ModBlocks.CORRUPTED_WALL_SIGN, ModBlocks.PALM_SIGN, ModBlocks.PALM_WALL_SIGN, ModBlocks.WITHERED_PALM_SIGN, ModBlocks.WITHERED_PALM_WALL_SIGN).build());
    public static final BlockEntityType<ModHangingSignBlockEntity> MOD_HANGING_SIGN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            new Identifier(CrimsonMoon.MOD_ID, "mod_hanging_sign_entity"),
            FabricBlockEntityTypeBuilder.create(ModHangingSignBlockEntity::new,
                ModBlocks.ACIDIC_HANGING_SIGN, ModBlocks.CHARRED_HANGING_SIGN, ModBlocks.CORRUPTED_HANGING_SIGN, ModBlocks.ACIDIC_HANGING_WALL_SIGN, ModBlocks.CHARRED_HANGING_WALL_SIGN, ModBlocks.CORRUPTED_HANGING_WALL_SIGN, ModBlocks.PALM_HANGING_SIGN, ModBlocks.PALM_HANGING_WALL_SIGN, ModBlocks.WITHERED_PALM_HANGING_SIGN, ModBlocks.WITHERED_PALM_HANGING_WALL_SIGN).build(null));

    public static void registerBlockEntities() {
        CrimsonMoon.LOGGER.info("Registering Block Entities for " + CrimsonMoon.MOD_ID);
    }
}
