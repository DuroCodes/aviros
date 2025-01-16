package me.duro.aviros.worldgen

import me.duro.aviros.Aviros
import me.duro.aviros.worldgen.biome.ModBiomes
import net.minecraft.core.HolderSet
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BiomeTags
import net.minecraft.world.level.biome.Biomes
import net.minecraft.world.level.levelgen.GenerationStep
import net.neoforged.neoforge.common.world.BiomeModifier
import net.neoforged.neoforge.common.world.BiomeModifiers
import net.neoforged.neoforge.registries.NeoForgeRegistries

object ModBiomeModifiers {
    val ADD_SKYRITE_ORE = registerKey("add_skyrite_ore")
    val ADD_TREE_JYNWOOD = registerKey("add_tree_jynwood")

    fun bootstrap(context: BootstrapContext<BiomeModifier>) {
        val placedFeatures = context.lookup(Registries.PLACED_FEATURE)
        val biomes = context.lookup(Registries.BIOME)

        context.register(
            ADD_SKYRITE_ORE, BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(ModBiomes.JYNWOOD_FIELDS)), // should prob be a BiomeTag for aviros
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SKYRITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
            )
        )

        context.register(
            ADD_TREE_JYNWOOD, BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(ModBiomes.JYNWOOD_FIELDS)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.JYNWOOD_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
            )
        )
    }

    private fun registerKey(name: String) = ResourceKey.create(
        NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(
            Aviros.MOD_ID, name
        )
    )
}