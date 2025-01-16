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

        dropSelf(ModBlocks.JYNWOOD_LOG.get())
        dropSelf(ModBlocks.JYNWOOD_WOOD.get())
        dropSelf(ModBlocks.STRIPPED_JYNWOOD_LOG.get())
        dropSelf(ModBlocks.STRIPPED_JYNWOOD_WOOD.get())
        dropSelf(ModBlocks.JYNWOOD_PLANKS.get())
        dropSelf(ModBlocks.JYNWOOD_STAIRS.get())
        add(ModBlocks.JYNWOOD_SLAB.get()) { createSlabItemTable(ModBlocks.JYNWOOD_SLAB.get()) }
        dropSelf(ModBlocks.JYNWOOD_FENCE.get())
        dropSelf(ModBlocks.JYNWOOD_FENCE_GATE.get())
        dropSelf(ModBlocks.JYNWOOD_DOOR.get())
        dropSelf(ModBlocks.JYNWOOD_TRAPDOOR.get())
        add(ModBlocks.JYNWOOD_DOOR.get()) { createDoorTable(ModBlocks.JYNWOOD_DOOR.get()) }
        dropSelf(ModBlocks.JYNWOOD_BUTTON.get())
        dropSelf(ModBlocks.JYNWOOD_PRESSURE_PLATE.get())
        dropSelf(ModBlocks.JYNWOOD_SAPLING.get())
        add(ModBlocks.JYNWOOD_LEAVES.get()) {
            createLeavesDrops(it, ModBlocks.JYNWOOD_SAPLING.get(), *NORMAL_LEAVES_SAPLING_CHANCES)
        }

        dropSelf(ModBlocks.AVIROS_PORTAL.get())
    }

    override fun getKnownBlocks() = ModBlocks.REGISTRY.entries.map { it.value() }
}