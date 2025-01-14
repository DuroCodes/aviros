package me.duro.aviros.util

import me.duro.aviros.Aviros
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.tags.ItemTags

object ModTags {
    object Blocks {
        val NEEDS_SKYRITE_TOOL = createTag("needs_skyrite_tool")
        val INCORRECT_SKYRITE_TOOL = createTag("incorrect_skyrite_tool")

        private fun createTag(name: String) =
            BlockTags.create(ResourceLocation.fromNamespaceAndPath(Aviros.MOD_ID, name))
    }

    object Items {
        val SKYRITE_TOOL_MATERIALS = createTag("skyrite_tool_materials")
        val SKYRITE_REPAIR = createTag("skyrite_repair")

        private fun createTag(name: String) =
            ItemTags.create(ResourceLocation.fromNamespaceAndPath(Aviros.MOD_ID, name))
    }
}