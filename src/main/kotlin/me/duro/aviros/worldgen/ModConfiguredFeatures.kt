package me.duro.aviros.worldgen

import me.duro.aviros.Aviros
import me.duro.aviros.block.ModBlocks
import net.minecraft.core.Holder
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.util.valueproviders.ConstantInt
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest

object ModConfiguredFeatures {
    val AVIROS_SKYRITE_ORE_KEY = registerKey("skyrite_ore")
    val JYNWOOD_KEY = registerKey("jynwood")

    fun bootstrap(context: BootstrapContext<ConfiguredFeature<*, *>>) {
        val stoneReplaceables = TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES)
        val deepslateReplaceables = TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES)

        val avirosSkyriteOres = listOf(
            OreConfiguration.target(stoneReplaceables, ModBlocks.SKYRITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_SKYRITE_ORE.get().defaultBlockState()),
        )

        register(context, AVIROS_SKYRITE_ORE_KEY, Feature.ORE, OreConfiguration(avirosSkyriteOres, 9))
        register(
            context, JYNWOOD_KEY, Feature.TREE, TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.JYNWOOD_LOG.get()),
                ForkingTrunkPlacer(5, 2, 2),

                BlockStateProvider.simple(ModBlocks.JYNWOOD_LEAVES.get()),
                BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),

                TwoLayersFeatureSize(1, 0, 1)
            ).ignoreVines().build()
        )
    }

    private fun registerKey(name: String) = ResourceKey.create(
        Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(
            Aviros.MOD_ID, name
        )
    )

    private fun <FC : FeatureConfiguration, F : Feature<FC>> register(
        context: BootstrapContext<ConfiguredFeature<*, *>>,
        key: ResourceKey<ConfiguredFeature<*, *>>,
        feature: F,
        configuration: FC,
    ): Holder.Reference<ConfiguredFeature<*, *>> = context.register(key, ConfiguredFeature(feature, configuration))
}