package me.duro.aviros.datagen

import me.duro.aviros.Aviros
import me.duro.aviros.worldgen.ModBiomeModifiers
import me.duro.aviros.worldgen.ModConfiguredFeatures
import me.duro.aviros.worldgen.ModPlacedFeatures
import net.minecraft.core.HolderLookup
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.Registries
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider
import net.neoforged.neoforge.registries.NeoForgeRegistries
import java.util.concurrent.CompletableFuture

class ModDatapackProvider(
    output: PackOutput, registries: CompletableFuture<HolderLookup.Provider>
) : DatapackBuiltinEntriesProvider(output, registries, BUILDER, setOf(Aviros.MOD_ID)) {
    companion object {
        val BUILDER: RegistrySetBuilder =
            RegistrySetBuilder().add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
                .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
                .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
    }
}