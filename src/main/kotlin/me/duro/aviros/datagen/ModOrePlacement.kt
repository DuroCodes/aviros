package me.duro.aviros.datagen

import net.minecraft.world.level.levelgen.placement.BiomeFilter
import net.minecraft.world.level.levelgen.placement.CountPlacement
import net.minecraft.world.level.levelgen.placement.InSquarePlacement
import net.minecraft.world.level.levelgen.placement.PlacementModifier
import net.minecraft.world.level.levelgen.placement.RarityFilter

object ModOrePlacement {
    private fun orePlacement(modifier: PlacementModifier, heightRange: PlacementModifier) =
        listOf(modifier, InSquarePlacement.spread(), heightRange, BiomeFilter.biome())

    fun commonOrePlacement(count: Int, heightRange: PlacementModifier) =
        orePlacement(CountPlacement.of(count), heightRange)

    fun rareOrePlacement(chance: Int, heightRange: PlacementModifier) =
        orePlacement(RarityFilter.onAverageOnceEvery(chance), heightRange)
}