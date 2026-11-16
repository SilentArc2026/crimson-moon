package name.crimsonmoon.world.tree;

import name.crimsonmoon.CrimsonMoon;
import name.crimsonmoon.mixin.FoliagePlacerTypeInvoker;
import name.crimsonmoon.world.tree.custom.PalmFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<?> PALM_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister(
            "palm_foliage_placer", PalmFoliagePlacer.CODEC);

    public static void register() {
        CrimsonMoon.LOGGER.info("Registering the Foliage Placers for " + CrimsonMoon.MOD_ID);
    }
}
