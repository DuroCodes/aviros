package me.duro.aviros.datagen

import me.duro.aviros.block.ModBlocks
import me.duro.aviros.item.ModItems
import net.minecraft.core.HolderLookup
import net.minecraft.data.loot.BlockLootSubProvider
import net.minecraft.world.flag.FeatureFlags

class ModBlockLootTableProvider(
    registries: HolderLookup.Provider
) : BlockLootSubProvider(setOf(), FeatureFlags.REGISTRY.allFlags(), registries) {
    override fun generate() {
        dropSelf(ModBlocks.SKYRITE_BLOCK.get())
        add(ModBlocks.SKYRITE_ORE.get()) { createOreDrop(it, ModItems.SKYRITE.get()) }
        add(ModBlocks.DEEPSLATE_SKYRITE_ORE.get()) { createOreDrop(it, ModItems.SKYRITE.get()) }
    }

    override fun getKnownBlocks() = ModBlocks.REGISTRY.entries.map { it.value() }
}