package me.duro.aviros.datagen

import me.duro.aviros.Aviros
import net.minecraft.data.loot.LootTableProvider
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.data.event.GatherDataEvent

@EventBusSubscriber(modid = Aviros.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
object DataGenerators {
    @SubscribeEvent
    fun gatherData(event: GatherDataEvent.Client) {
        val generator = event.generator
        val packOutput = generator.packOutput
        val lookupProvider = event.lookupProvider

        generator.addProvider(
            true, LootTableProvider(
                packOutput, emptySet(), listOf(
                    LootTableProvider.SubProviderEntry(::ModBlockLootTableProvider, LootContextParamSets.BLOCK)
                ), lookupProvider
            )
        )

        generator.addProvider(true, ModBlockTagProvider(packOutput, lookupProvider))
        generator.addProvider(true, ModRecipeProvider.Runner(packOutput, lookupProvider))
        generator.addProvider(true, ModModelProvider(packOutput))
    }
}