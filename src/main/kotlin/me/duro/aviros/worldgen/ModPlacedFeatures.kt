package me.duro.aviros.worldgen

import me.duro.aviros.Aviros
import me.duro.aviros.block.ModBlocks
import me.duro.aviros.datagen.ModOrePlacement
import net.minecraft.core.Holder
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.data.worldgen.placement.PlacementUtils
import net.minecraft.data.worldgen.placement.VegetationPlacements
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.levelgen.VerticalAnchor
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import net.minecraft.world.level.levelgen.placement.PlacementModifier

object ModPlacedFeatures {
    val SKYRITE_ORE_PLACED_KEY = registerKey("skyrite_ore_placed")
    val JYNWOOD_PLACED_KEY = registerKey("jynwood_placed")

    fun bootstrap(context: BootstrapContext<PlacedFeature>) {
        val configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE)

        register(
            context,
            SKYRITE_ORE_PLACED_KEY,
            configuredFeatures.getOrThrow(ModConfiguredFeatures.AVIROS_SKYRITE_ORE_KEY),
            ModOrePlacement.rareOrePlacement(
                100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))
            )
        )

        register(
            context,
            JYNWOOD_PLACED_KEY,
            configuredFeatures.getOrThrow(ModConfiguredFeatures.JYNWOOD_KEY),
            VegetationPlacements.treePlacement(
                PlacementUtils.countExtra(3, 0.1f, 2), ModBlocks.JYNWOOD_SAPLING.get()
            ),
        )
    }


    private fun registerKey(name: String) = ResourceKey.create(
        Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(
            Aviros.MOD_ID, name
        )
    )

    private fun register(
        context: BootstrapContext<PlacedFeature>,
        key: ResourceKey<PlacedFeature>,
        configuration: Holder<ConfiguredFeature<*, *>>,
        modifiers: List<PlacementModifier>,
    ): Holder.Reference<PlacedFeature> = context.register(key, PlacedFeature(configuration, modifiers))
}
