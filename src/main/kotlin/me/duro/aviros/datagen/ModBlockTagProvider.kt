package me.duro.aviros.datagen

import me.duro.aviros.Aviros
import me.duro.aviros.block.ModBlocks
import me.duro.aviros.util.ModTags
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.tags.BlockTags
import net.neoforged.neoforge.common.data.BlockTagsProvider
import java.util.concurrent.CompletableFuture

class ModBlockTagProvider(
    output: PackOutput, lookupProvider: CompletableFuture<HolderLookup.Provider>
) : BlockTagsProvider(output, lookupProvider, Aviros.MOD_ID) {
    override fun addTags(provider: HolderLookup.Provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.SKYRITE_BLOCK.get()).add(ModBlocks.SKYRITE_ORE.get())
            .add(ModBlocks.DEEPSLATE_SKYRITE_ORE.get())

        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.SKYRITE_BLOCK.get()).add(ModBlocks.SKYRITE_ORE.get())
            .add(ModBlocks.DEEPSLATE_SKYRITE_ORE.get())

        tag(ModTags.Blocks.NEEDS_SKYRITE_TOOL).addTags(BlockTags.NEEDS_STONE_TOOL)
        tag(ModTags.Blocks.INCORRECT_SKYRITE_TOOL).addTags(BlockTags.INCORRECT_FOR_STONE_TOOL)
            .remove(ModTags.Blocks.NEEDS_SKYRITE_TOOL)

        tag(BlockTags.LOGS_THAT_BURN).add(
            ModBlocks.JYNWOOD_LOG.get(),
            ModBlocks.JYNWOOD_WOOD.get(),
            ModBlocks.STRIPPED_JYNWOOD_LOG.get(),
            ModBlocks.STRIPPED_JYNWOOD_WOOD.get(),
        )

        tag(BlockTags.PLANKS).add(ModBlocks.JYNWOOD_PLANKS.get())
        tag(BlockTags.WOODEN_SLABS).add(ModBlocks.JYNWOOD_SLAB.get())
        tag(BlockTags.WOODEN_STAIRS).add(ModBlocks.JYNWOOD_STAIRS.get())
        tag(BlockTags.WOODEN_FENCES).add(ModBlocks.JYNWOOD_FENCE.get())
        tag(BlockTags.FENCE_GATES).add(ModBlocks.JYNWOOD_FENCE_GATE.get())
        tag(BlockTags.WOODEN_DOORS).add(ModBlocks.JYNWOOD_DOOR.get())
        tag(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.JYNWOOD_TRAPDOOR.get())
        tag(BlockTags.WOODEN_BUTTONS).add(ModBlocks.JYNWOOD_BUTTON.get())
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.JYNWOOD_PRESSURE_PLATE.get())
        tag(BlockTags.LEAVES).add(ModBlocks.JYNWOOD_LEAVES.get())
        tag(BlockTags.SAPLINGS).add(ModBlocks.JYNWOOD_SAPLING.get())
    }
}