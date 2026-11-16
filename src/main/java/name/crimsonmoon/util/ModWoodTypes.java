package name.crimsonmoon.util;

import name.crimsonmoon.CrimsonMoon;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeRegistry;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.minecraft.util.Identifier;

public class ModWoodTypes {
    public static final WoodType CORRUPTED = WoodTypeRegistry.register(new Identifier(CrimsonMoon.MOD_ID, "corrupted"), BlockSetType.OAK);
    public static final WoodType WITHERED = WoodTypeRegistry.register(new Identifier(CrimsonMoon.MOD_ID, "withered"), BlockSetType.OAK);
    public static final WoodType CHARRED = WoodTypeRegistry.register(new Identifier(CrimsonMoon.MOD_ID, "charred"), BlockSetType.OAK);
    public static final WoodType ACIDIC = WoodTypeRegistry.register(new Identifier(CrimsonMoon.MOD_ID, "acidic"), BlockSetType.OAK);
    public static final WoodType PALM = WoodTypeRegistry.register(new Identifier(CrimsonMoon.MOD_ID, "palm"), BlockSetType.OAK);
}
