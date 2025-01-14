package me.duro.aviros.block

import me.duro.aviros.Aviros
import me.duro.aviros.block.custom.FlammableLeaves
import me.duro.aviros.block.custom.FlammablePlanks
import me.duro.aviros.block.custom.ModFlammableRotatedPillarBlock
import me.duro.aviros.item.ModItems
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.util.valueproviders.UniformInt
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.*
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.properties.BlockSetType
import net.minecraft.world.level.block.state.properties.WoodType
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredRegister

object ModBlocks {
    val REGISTRY: DeferredRegister.Blocks = DeferredRegister.createBlocks(Aviros.MOD_ID)

    val SKYRITE_BLOCK = registerBlock(
        "skyrite_block",
        BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL),
        ::Block
    )

    val SKYRITE_ORE = registerBlock(
        "skyrite_ore", BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)
    ) { DropExperienceBlock(UniformInt.of(2, 5), it) }

    val DEEPSLATE_SKYRITE_ORE = registerBlock(
        "deepslate_skyrite_ore",
        BlockBehaviour.Properties.of().strength(4.5f, 3f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)
    ) { DropExperienceBlock(UniformInt.of(2, 5), it) }

    val JYNWOOD_LOG = registerBlock(
        "jynwood_log", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG), ::ModFlammableRotatedPillarBlock
    )

    val JYNWOOD_WOOD = registerBlock(
        "jynwood_wood", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), ::ModFlammableRotatedPillarBlock
    )

    val STRIPPED_JYNWOOD_LOG = registerBlock(
        "stripped_jynwood_log",
        BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG),
        ::ModFlammableRotatedPillarBlock
    )

    val STRIPPED_JYNWOOD_WOOD = registerBlock(
        "stripped_jynwood_wood",
        BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD),
        ::ModFlammableRotatedPillarBlock
    )

    val JYNWOOD_PLANKS = registerBlock(
        "jynwood_planks", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), ::FlammablePlanks
    )

    val JYNWOOD_STAIRS = registerBlock(
        "jynwood_stairs", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)
    ) { StairBlock(JYNWOOD_PLANKS.get().defaultBlockState(), it) }

    val JYNWOOD_SLAB = registerBlock(
        "jynwood_slab", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB), ::SlabBlock
    )

    val JYNWOOD_FENCE = registerBlock(
        "jynwood_fence", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE), ::FenceBlock
    )

    val JYNWOOD_FENCE_GATE = registerBlock(
        "jynwood_fence_gate", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)
    ) { FenceGateBlock(WoodType.OAK, it) }

    val JYNWOOD_DOOR = registerBlock(
        "jynwood_door", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)
    ) { DoorBlock(BlockSetType.OAK, it) }

    val JYNWOOD_TRAPDOOR = registerBlock(
        "jynwood_trapdoor", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)
    ) { TrapDoorBlock(BlockSetType.OAK, it) }

    val JYNWOOD_PRESSURE_PLATE = registerBlock(
        "jynwood_pressure_plate", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)
    ) { PressurePlateBlock(BlockSetType.OAK, it) }

    val JYNWOOD_BUTTON = registerBlock(
        "jynwood_button", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)
    ) { ButtonBlock(BlockSetType.OAK, 30, it) }

    val JYNWOOD_LEAVES = registerBlock(
        "jynwood_leaves", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), ::FlammableLeaves
    )

    val JYNWOOD_SAPLING = registerBlock(
        "jynwood_sapling", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)
    ) { SaplingBlock(null, it) }

    private fun addResourceKey(name: String, properties: BlockBehaviour.Properties) = properties.setId(
        ResourceKey.create(
            Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Aviros.MOD_ID, name)
        )
    )

    private fun <T : Block> registerBlock(
        name: String, properties: BlockBehaviour.Properties, block: (BlockBehaviour.Properties) -> T
    ) = REGISTRY.register(name) { -> block(addResourceKey(name, properties)) }.also {
        registerBlockItem(name, it)
    }

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
