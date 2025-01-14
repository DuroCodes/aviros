package me.duro.aviros.item

import me.duro.aviros.Aviros
import me.duro.aviros.util.ModTags
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.item.equipment.*

object ModArmorMaterials {
    val SKYRITE = ArmorMaterial(
        15,
        mapOf(
            ArmorType.BOOTS to 2,
            ArmorType.LEGGINGS to 5,
            ArmorType.CHESTPLATE to 6,
            ArmorType.HELMET to 2,
            ArmorType.BODY to 0
        ),
        16,
        SoundEvents.ARMOR_EQUIP_IRON,
        0f,
        0f,
        ModTags.Items.SKYRITE_REPAIR,
        ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.fromNamespaceAndPath(Aviros.MOD_ID, "skyrite"))
    )
}