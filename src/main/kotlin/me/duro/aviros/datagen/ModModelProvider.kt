package me.duro.aviros.datagen

import me.duro.aviros.Aviros
import me.duro.aviros.block.ModBlocks
import me.duro.aviros.item.ModItems
import net.minecraft.client.data.models.BlockModelGenerators
import net.minecraft.client.data.models.ItemModelGenerators
import net.minecraft.client.data.models.ModelProvider
import net.minecraft.client.data.models.model.ModelTemplates
import net.minecraft.client.data.models.model.TexturedModel
import net.minecraft.data.PackOutput
import net.minecraft.world.item.equipment.EquipmentAssets

class ModModelProvider(output: PackOutput) : ModelProvider(output, Aviros.MOD_ID) {
    override fun registerModels(blockModels: BlockModelGenerators, itemModels: ItemModelGenerators) {
        blockModels.createTrivialCube(ModBlocks.SKYRITE_BLOCK.get())
        blockModels.createTrivialCube(ModBlocks.SKYRITE_ORE.get())
        blockModels.createTrivialCube(ModBlocks.DEEPSLATE_SKYRITE_ORE.get())

        blockModels.woodProvider(ModBlocks.JYNWOOD_LOG.get()).log(ModBlocks.JYNWOOD_LOG.get())
            .wood(ModBlocks.JYNWOOD_WOOD.get())
        blockModels.woodProvider(ModBlocks.STRIPPED_JYNWOOD_LOG.get()).log(ModBlocks.STRIPPED_JYNWOOD_LOG.get())
            .wood(ModBlocks.STRIPPED_JYNWOOD_WOOD.get())
        blockModels.createTrivialBlock(ModBlocks.JYNWOOD_LEAVES.get(), TexturedModel.LEAVES)
        blockModels.createCrossBlockWithDefaultItem(ModBlocks.JYNWOOD_SAPLING.get(), BlockModelGenerators.PlantType.NOT_TINTED)
        blockModels.family(ModBlocks.JYNWOOD_PLANKS.get()).fence(ModBlocks.JYNWOOD_FENCE.get())
            .fenceGate(ModBlocks.JYNWOOD_FENCE_GATE.get()).button(ModBlocks.JYNWOOD_BUTTON.get())
            .stairs(ModBlocks.JYNWOOD_STAIRS.get()).slab(ModBlocks.JYNWOOD_SLAB.get())
            .pressurePlate(ModBlocks.JYNWOOD_PRESSURE_PLATE.get())
            .door(ModBlocks.JYNWOOD_DOOR.get())
            .trapdoor(ModBlocks.JYNWOOD_TRAPDOOR.get())

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

