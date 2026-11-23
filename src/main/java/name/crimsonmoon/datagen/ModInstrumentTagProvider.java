package name.crimsonmoon.datagen;

import name.crimsonmoon.item.ModInstruments;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Instrument;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import java.util.concurrent.CompletableFuture;

public class ModInstrumentTagProvider extends FabricTagProvider<Instrument> {
    public ModInstrumentTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.INSTRUMENT, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModInstruments.BEHEMOTH_HORNS)
                .addOptional(ModInstruments.BEHEMOTH_CALL.getValue());
    }
}