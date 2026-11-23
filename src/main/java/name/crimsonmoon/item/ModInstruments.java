package name.crimsonmoon.item;

import name.crimsonmoon.CrimsonMoon;
import name.crimsonmoon.sounds.ModSounds;
import net.minecraft.item.Instrument;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModInstruments {
    public static final RegistryKey<Instrument> BEHEMOTH_CALL = RegistryKey.of(
            RegistryKeys.INSTRUMENT,
            new Identifier(CrimsonMoon.MOD_ID, "behemoth_call")
    );

    public static final TagKey<Instrument> BEHEMOTH_HORNS = TagKey.of(
            RegistryKeys.INSTRUMENT,
            new Identifier(CrimsonMoon.MOD_ID, "behemoth_horns")
    );

    public static void bootstrap(Registerable<Instrument> registry) {
        registry.register(BEHEMOTH_CALL, new Instrument(
                ModSounds.BEHEMOTH_HORN_PLAY,
                140,    // useDuration in ticks (140 = 7 seconds, vanilla goat horn default)
                256.0f
        ));
    }

    public static void registerInstruments() {
        Registry.register(Registries.INSTRUMENT, BEHEMOTH_CALL, new Instrument(
                ModSounds.BEHEMOTH_HORN_PLAY,
                140,
                256.0f
        ));
    }
}