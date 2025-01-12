package me.duro.aviros.block

import me.duro.aviros.Aviros
import me.duro.aviros.item.ModItems
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.util.valueproviders.UniformInt
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.DropExperienceBlock
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier

object ModBlocks {
    val REGISTRY: DeferredRegister.Blocks = DeferredRegister.createBlocks(Aviros.MOD_ID)

    val SKYRITE_ORE = registerBlock("skyrite_ore") {
        DropExperienceBlock(
            UniformInt.of(2, 5),
            BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE).setId(
                ResourceKey.create(
                    Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Aviros.MOD_ID, "skyrite_ore")
                )
            )
        )
    }

    val DEEPSLATE_SKYRITE_ORE = registerBlock("deepslate_skyrite_ore") {
        DropExperienceBlock(
            UniformInt.of(2, 5),
            BlockBehaviour.Properties.of().strength(4.5f, 3f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)
                .setId(
                    ResourceKey.create(
                        Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Aviros.MOD_ID, "deepslate_skyrite_ore")
                    )
                )
        )
    }

    val SKYRITE_BLOCK = registerBlock("skyrite_block") {
        Block(
            BlockBehaviour.Properties.of().strength(5f, 6f).requiresCorrectToolForDrops().sound(SoundType.METAL).setId(
                ResourceKey.create(
                    Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Aviros.MOD_ID, "skyrite_block")
                )
            )
        )
    }

    private fun <T : Block> registerBlock(name: String, block: Supplier<T>) =
        REGISTRY.register(name, block).also { registerBlockItem(name, it) }

    private fun <T : Block> registerBlockItem(name: String, block: DeferredBlock<T>) =
        ModItems.REGISTRY.register(name) { ->
            BlockItem(
                block.get(), Item.Properties().useBlockDescriptionPrefix().setId(
                    ResourceKey.create(
                        Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Aviros.MOD_ID, name)
                    )
                )
            )
        }

    fun register(eventBus: IEventBus) = REGISTRY.register(eventBus)
}
