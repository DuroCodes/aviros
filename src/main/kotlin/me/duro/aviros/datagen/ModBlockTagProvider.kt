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
    }
}