package me.duro.aviros.item

import me.duro.aviros.Aviros
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredRegister

object ModCreativeModeTabs {
    val REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Aviros.MOD_ID)

    val AVIROS_TAB = REGISTRY.register("aviros") { ->
        CreativeModeTab.builder()
            .title(Component.translatable("creativetab.aviros.aviros_items"))
            .icon { ItemStack(ModItems.SKYRITE.get()) }.displayItems { _, output ->
            ModItems.REGISTRY.entries.forEach { entry ->
                output.accept(ItemStack(entry.value()))
            }
        }.build()
    }

    fun register(eventBus: IEventBus) = REGISTRY.register(eventBus)
}