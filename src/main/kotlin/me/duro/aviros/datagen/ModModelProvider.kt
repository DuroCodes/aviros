package me.duro.aviros.datagen

import me.duro.aviros.Aviros
import me.duro.aviros.block.ModBlocks
import me.duro.aviros.item.ModItems
import net.minecraft.client.data.models.BlockModelGenerators
import net.minecraft.client.data.models.ItemModelGenerators
import net.minecraft.client.data.models.ModelProvider
import net.minecraft.client.data.models.model.ModelTemplates
import net.minecraft.data.PackOutput
import net.minecraft.world.item.equipment.EquipmentAssets

class ModModelProvider(output: PackOutput) : ModelProvider(output, Aviros.MOD_ID) {
    override fun registerModels(blockModels: BlockModelGenerators, itemModels: ItemModelGenerators) {
        blockModels.createTrivialCube(ModBlocks.SKYRITE_BLOCK.get())
        blockModels.createTrivialCube(ModBlocks.SKYRITE_ORE.get())
        blockModels.createTrivialCube(ModBlocks.DEEPSLATE_SKYRITE_ORE.get())

        itemModels.generateFlatItem(ModItems.SKYRITE.get(), ModelTemplates.FLAT_ITEM)
        itemModels.generateFlatItem(ModItems.SKYRITE_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM)
        itemModels.generateFlatItem(ModItems.SKYRITE_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM)
        itemModels.generateFlatItem(ModItems.SKYRITE_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM)
        itemModels.generateFlatItem(ModItems.SKYRITE_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM)
        itemModels.generateFlatItem(ModItems.SKYRITE_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM)

        itemModels.generateTrimmableItem(ModItems.SKYRITE_HELMET.get(), EquipmentAssets.IRON, "helmet", false)
        itemModels.generateTrimmableItem(ModItems.SKYRITE_CHESTPLATE.get(), EquipmentAssets.IRON, "chestplate", false)
        itemModels.generateTrimmableItem(ModItems.SKYRITE_LEGGINGS.get(), EquipmentAssets.IRON, "leggings", false)
        itemModels.generateTrimmableItem(ModItems.SKYRITE_BOOTS.get(), EquipmentAssets.IRON, "boots", false)
    }
}