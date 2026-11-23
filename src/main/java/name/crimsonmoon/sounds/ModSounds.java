package name.crimsonmoon.sounds;

import name.crimsonmoon.CrimsonMoon;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final RegistryEntry<SoundEvent> BEHEMOTH_HORN_PLAY = registerReference("item.the_behemoths_horn.play");

    private static RegistryEntry<SoundEvent> registerReference(String name) {
        Identifier id = new Identifier(CrimsonMoon.MOD_ID, name);
        return Registry.registerReference(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        CrimsonMoon.LOGGER.info("Registering Mod Sounds for " + CrimsonMoon.MOD_ID);
    }
}