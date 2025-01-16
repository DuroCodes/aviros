package me.duro.aviros.worldgen.biome

import me.duro.aviros.Aviros
import net.minecraft.core.Holder
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BiomeDefaultFeatures
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.data.worldgen.placement.VegetationPlacements
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.Musics
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.MobCategory
import net.minecraft.world.level.biome.*
import net.minecraft.world.level.levelgen.GenerationStep

object ModBiomes {
    val JYNWOOD_FIELDS = ResourceKey.create(
        Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Aviros.MOD_ID, "jynwood_fields")
    )

    fun bootstrap(context: BootstrapContext<Biome>): Holder.Reference<Biome> =
        context.register(JYNWOOD_FIELDS, jynwoodFields(context))

    private fun jynwoodFields(context: BootstrapContext<Biome>): Biome {
        val spawnBuilder = MobSpawnSettings.Builder()
            .addSpawn(MobCategory.CREATURE, MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 3, 3))

        BiomeDefaultFeatures.farmAnimals(spawnBuilder)
        BiomeDefaultFeatures.commonSpawns(spawnBuilder)

        val biomeBuilder = BiomeGenerationSettings.Builder(
            context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER)
        ).addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_PLAINS)

        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeBuilder)
//        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeBuilder)
        BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeBuilder)
        BiomeDefaultFeatures.addDefaultSprings(biomeBuilder)
//        BiomeDefaultFeatures.addSurfaceFreezing(biomeBuilder)
//        BiomeDefaultFeatures.addMossyStoneBlock(biomeBuilder)
//        BiomeDefaultFeatures.addForestFlowers(biomeBuilder)
//        BiomeDefaultFeatures.addFerns(biomeBuilder)
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder)
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder)
//        BiomeDefaultFeatures.addExtraGold(biomeBuilder)
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder)
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder)

        return Biome.BiomeBuilder()
            .hasPrecipitation(true)
            .downfall(0.8f)
            .temperature(0.7f)
            .generationSettings(biomeBuilder.build())
            .mobSpawnSettings(spawnBuilder.build())
            .specialEffects(
                BiomeSpecialEffects.Builder()
                    .waterColor(0x3F76E4)
                    .waterFogColor(0x50533)
                    .fogColor(0x50533)
                    .skyColor(0x50533)
                    .foliageColorOverride(0x804263)
                    .fogColor(0x804263)
                    .grassColorOverride(0x804263)
                    .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                    .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_GAME))
                    .build()
            ).build()
    }
}