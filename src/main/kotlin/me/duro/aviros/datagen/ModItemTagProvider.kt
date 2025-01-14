package me.duro.aviros.datagen

import me.duro.aviros.Aviros
import me.duro.aviros.block.ModBlocks
import me.duro.aviros.item.ModItems
import me.duro.aviros.util.ModTags
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraft.tags.ItemTags
import net.minecraft.world.level.block.Block
import java.util.concurrent.CompletableFuture

class ModItemTagProvider(
    output: PackOutput,
    lookupProvider: CompletableFuture<HolderLookup.Provider>,
    blockTags: CompletableFuture<TagLookup<Block>>,
) : ItemTagsProvider(output, lookupProvider, blockTags, Aviros.MOD_ID) {
    override fun addTags(provider: HolderLookup.Provider) {
        tag(ItemTags.SWORDS).add(ModItems.SKYRITE_SWORD.get())
        tag(ItemTags.AXES).add(ModItems.SKYRITE_AXE.get())
        tag(ItemTags.PICKAXES).add(ModItems.SKYRITE_PICKAXE.get())
        tag(ItemTags.SHOVELS).add(ModItems.SKYRITE_SHOVEL.get())
        tag(ItemTags.HOES).add(ModItems.SKYRITE_HOE.get())
        tag(ItemTags.HEAD_ARMOR).add(ModItems.SKYRITE_HELMET.get())
        tag(ItemTags.CHEST_ARMOR).add(ModItems.SKYRITE_CHESTPLATE.get())
        tag(ItemTags.LEG_ARMOR).add(ModItems.SKYRITE_LEGGINGS.get())
        tag(ItemTags.FOOT_ARMOR).add(ModItems.SKYRITE_BOOTS.get())
        tag(ItemTags.TRIMMABLE_ARMOR).add(
            ModItems.SKYRITE_HELMET.get(),
            ModItems.SKYRITE_CHESTPLATE.get(),
            ModItems.SKYRITE_LEGGINGS.get(),
            ModItems.SKYRITE_BOOTS.get()
        )
        tag(ModTags.Items.SKYRITE_TOOL_MATERIALS).add(
            ModItems.SKYRITE_SWORD.get(),
            ModItems.SKYRITE_AXE.get(),
            ModItems.SKYRITE_PICKAXE.get(),
            ModItems.SKYRITE_SHOVEL.get(),
            ModItems.SKYRITE_HOE.get()
        )
        tag(ModTags.Items.SKYRITE_REPAIR).add(ModItems.SKYRITE.get())

        tag(ItemTags.LOGS_THAT_BURN).add(
            ModBlocks.JYNWOOD_LOG.get().asItem(),
            ModBlocks.JYNWOOD_WOOD.get().asItem(),
            ModBlocks.STRIPPED_JYNWOOD_LOG.get().asItem(),
            ModBlocks.STRIPPED_JYNWOOD_WOOD.get().asItem()
        )
        tag(ItemTags.PLANKS).add(ModBlocks.JYNWOOD_PLANKS.get().asItem())
        tag(ItemTags.WOODEN_SLABS).add(ModBlocks.JYNWOOD_SLAB.get().asItem())
        tag(ItemTags.WOODEN_STAIRS).add(ModBlocks.JYNWOOD_STAIRS.get().asItem())
        tag(ItemTags.WOODEN_FENCES).add(ModBlocks.JYNWOOD_FENCE.get().asItem())
        tag(ItemTags.FENCE_GATES).add(ModBlocks.JYNWOOD_FENCE_GATE.get().asItem())
        tag(ItemTags.WOODEN_DOORS).add(ModBlocks.JYNWOOD_DOOR.get().asItem())
    }
}