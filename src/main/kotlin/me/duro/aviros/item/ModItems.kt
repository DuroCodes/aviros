package me.duro.aviros.item

import me.duro.aviros.Aviros
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister

object ModItems {
    val REGISTRY: DeferredRegister.Items = DeferredRegister.createItems(Aviros.MOD_ID)

    val SKYRITE = registerItem("skyrite")
    val SKYRITE_AXE = registerItem("skyrite_axe")
    val SKYRITE_HOE = registerItem("skyrite_hoe")
    val SKYRITE_PICKAXE = registerItem("skyrite_pickaxe")
    val SKYRITE_SHOVEL = registerItem("skyrite_shovel")
    val SKYRITE_SWORD = registerItem("skyrite_sword")
    val SKYRITE_HELMET = registerItem("skyrite_helmet")
    val SKYRITE_CHESTPLATE = registerItem("skyrite_chestplate")
    val SKYRITE_LEGGINGS = registerItem("skyrite_leggings")
    val SKYRITE_BOOTS = registerItem("skyrite_boots")

    private fun registerItem(name: String): DeferredItem<Item> = REGISTRY.register(name) { ->
        Item(
            Item.Properties().setId(
                ResourceKey.create(
                    Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Aviros.MOD_ID, name)
                )
            )
        )
    }

    fun register(eventBus: IEventBus) = REGISTRY.register(eventBus)
}