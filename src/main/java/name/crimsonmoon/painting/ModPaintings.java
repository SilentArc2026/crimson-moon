package name.crimsonmoon.painting;

import name.crimsonmoon.CrimsonMoon;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPaintings {

    public static final PaintingVariant A_FORGOTTEN_TOOL = registerPainting("a_forgotten_tool", new PaintingVariant(16, 16));
    public static final PaintingVariant BLUB = registerPainting("blub", new PaintingVariant(16, 16));
    public static final PaintingVariant THE_FINAL_RISE_OF_THE_CRIMSON_MOON = registerPainting("the_final_rise_of_the_crimson_moon", new PaintingVariant(64, 48));
    public static final PaintingVariant THE_FIRST_CRIMSON_MOON = registerPainting("the_first_crimson_moon", new PaintingVariant(64, 48));
    public static final PaintingVariant THE_FORGOTTEN_LEGEND = registerPainting("the_forgotten_legend", new PaintingVariant(80, 48));
    public static final PaintingVariant THE_SEVEN_FLOWERS = registerPainting("the_seven_flowers", new PaintingVariant(80, 48));
    public static final PaintingVariant THE_SEVEN_SOULS = registerPainting("the_seven_souls", new PaintingVariant(64, 48));
    public static final PaintingVariant THE_TRUE_HERO = registerPainting("the_true_hero", new PaintingVariant(64, 48));
    public static final PaintingVariant THE_WITHER_STORM = registerPainting("the_wither_storm", new PaintingVariant(48, 64));
    public static final PaintingVariant TORQUE_DAWG_DEATH = registerPainting("torque_dawg_death", new PaintingVariant(64, 48));

    private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {

        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(CrimsonMoon.MOD_ID, name), paintingVariant);
    }

    public static void registerPaintings(){
        CrimsonMoon.LOGGER.info("Registering Paintings for " + CrimsonMoon.MOD_ID);

    }
}
