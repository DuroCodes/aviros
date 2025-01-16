package me.duro.aviros.item

import me.duro.aviros.Aviros
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.AxeItem
import net.minecraft.world.item.HoeItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.PickaxeItem
import net.minecraft.world.item.ShovelItem
import net.minecraft.world.item.SwordItem
import net.minecraft.world.item.equipment.ArmorType
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredRegister

object ModItems {
    val REGISTRY: DeferredRegister.Items = DeferredRegister.createItems(Aviros.MOD_ID)

    val SKYRITE = registerItem("skyrite") { Item(it) }
    val SKYRITE_SWORD = registerItem("skyrite_sword") { SwordItem(ModToolMaterials.SKYRITE, 3f, -2.4f, it) }
    val SKYRITE_AXE = registerItem("skyrite_axe") { AxeItem(ModToolMaterials.SKYRITE, 5f, -3.1f, it) }
    val SKYRITE_SHOVEL = registerItem("skyrite_shovel") { ShovelItem(ModToolMaterials.SKYRITE, 1.5f, -3.0f, it) }
    val SKYRITE_HOE = registerItem("skyrite_hoe") { HoeItem(ModToolMaterials.SKYRITE, -2f, -1f, it) }
    val SKYRITE_PICKAXE = registerItem("skyrite_pickaxe") { PickaxeItem(ModToolMaterials.SKYRITE, 1f, -2.8f, it) }

    val SKYRITE_HELMET =
        registerItem("skyrite_helmet", Item.Properties().durability(ArmorType.HELMET.getDurability(19))) {
            ArmorItem(
                ModArmorMaterials.SKYRITE, ArmorType.HELMET, it
            )
        }

    val SKYRITE_CHESTPLATE =
        registerItem("skyrite_chestplate", Item.Properties().durability(ArmorType.CHESTPLATE.getDurability(19))) {
            ArmorItem(
                ModArmorMaterials.SKYRITE, ArmorType.CHESTPLATE, it
            )
        }

    val SKYRITE_LEGGINGS =
        registerItem("skyrite_leggings", Item.Properties().durability(ArmorType.LEGGINGS.getDurability(19))) {
            ArmorItem(
                ModArmorMaterials.SKYRITE, ArmorType.LEGGINGS, it
            )
        }

    val SKYRITE_BOOTS = registerItem("skyrite_boots", Item.Properties().durability(ArmorType.BOOTS.getDurability(19))) {
        ArmorItem(
            ModArmorMaterials.SKYRITE, ArmorType.BOOTS, it
        )
    }

    val JYNWOOD_ROD = registerItem("jynwood_rod", Item.Properties()) { Item(it) }

    private fun addResourceKey(name: String, properties: Item.Properties) = properties.setId(
        ResourceKey.create(
            Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Aviros.MOD_ID, name)
        )
    )

    private fun registerItem(
        name: String, properties: Item.Properties = Item.Properties(), item: (Item.Properties) -> Item,
    ) = REGISTRY.register(name) { -> item(addResourceKey(name, properties)) }

    fun register(eventBus: IEventBus) = REGISTRY.register(eventBus)
}