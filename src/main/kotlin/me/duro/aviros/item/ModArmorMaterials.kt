package me.duro.aviros.item

import me.duro.aviros.Aviros
import me.duro.aviros.util.ModTags
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.item.equipment.*

object ModArmorMaterials {
    val SKYRITE = ArmorMaterial(
        41,
        mapOf(
            ArmorType.BOOTS to 4,
            ArmorType.LEGGINGS to 7,
            ArmorType.CHESTPLATE to 9,
            ArmorType.HELMET to 4,
            ArmorType.BODY to 11,
        ),
        15,
        SoundEvents.ARMOR_EQUIP_NETHERITE,
        3.0f,
        0.1f,
        ModTags.Items.SKYRITE_REPAIR,
        ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.fromNamespaceAndPath(Aviros.MOD_ID, "skyrite"))
    )
}