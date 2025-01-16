package me.duro.aviros.worldgen.dimension

import me.duro.aviros.Aviros
import me.duro.aviros.worldgen.biome.ModBiomes
import net.minecraft.core.Holder
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.util.valueproviders.ConstantInt
import net.minecraft.world.level.biome.FixedBiomeSource
import net.minecraft.world.level.dimension.BuiltinDimensionTypes
import net.minecraft.world.level.dimension.DimensionType
import net.minecraft.world.level.dimension.LevelStem
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings
import java.util.*

object ModDimensions {
    val AVIROS_KEY = ResourceKey.create(
        Registries.LEVEL_STEM, ResourceLocation.fromNamespaceAndPath(Aviros.MOD_ID, "aviros")
    )

    val AVIROS_LEVEL_KEY = ResourceKey.create(
        Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(Aviros.MOD_ID, "aviros")
    )

    val AVIROS_DIM_TYPE = ResourceKey.create(
        Registries.DIMENSION_TYPE, ResourceLocation.fromNamespaceAndPath(Aviros.MOD_ID, "aviros_type")
    )

    fun bootstrapType(context: BootstrapContext<DimensionType>): Holder.Reference<DimensionType> = context.register(
        AVIROS_DIM_TYPE, DimensionType(
            OptionalLong.of(12000),
            true,
            false,
            false,
            false,
            1.0,
            true,
            false,
            -64,
            384,
            256,
            BlockTags.INFINIBURN_OVERWORLD,
            BuiltinDimensionTypes.END_EFFECTS,
            1f,
            DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)
        )
    )

    fun bootstrapStem(context: BootstrapContext<LevelStem>) {
        val biomeRegistry = context.lookup(Registries.BIOME)
        val dimTypes = context.lookup(Registries.DIMENSION_TYPE)
        val noiseSettings = context.lookup(Registries.NOISE_SETTINGS)

        // FixedBiomeSource since there is only one biome (as of now)
        val wrappedChunkGenerator = NoiseBasedChunkGenerator(
            FixedBiomeSource(biomeRegistry.getOrThrow(ModBiomes.JYNWOOD_FIELDS)),
            noiseSettings.getOrThrow(NoiseGeneratorSettings.FLOATING_ISLANDS),
        )

        context.register(AVIROS_KEY, LevelStem(dimTypes.getOrThrow(AVIROS_DIM_TYPE), wrappedChunkGenerator))
    }

}