package me.duro.aviros

import me.duro.aviros.block.ModBlocks
import me.duro.aviros.item.ModCreativeModeTabs
import me.duro.aviros.item.ModItems
import net.minecraft.client.Minecraft
import net.minecraft.world.item.CreativeModeTabs
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.neoforge.forge.runForDist

@Mod(Aviros.MOD_ID)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
object Aviros {
    const val MOD_ID = "aviros"
    val LOGGER = LogManager.getLogger(MOD_ID)!!

    init {
        LOGGER.log(Level.INFO, "Hello world!")

        ModCreativeModeTabs.register(MOD_BUS)
        ModItems.register(MOD_BUS)
        ModBlocks.register(MOD_BUS)

        val obj = runForDist(
            clientTarget = {
                MOD_BUS.addListener(::onClientSetup)
                Minecraft.getInstance()
            },
            serverTarget = {
                MOD_BUS.addListener(::onServerSetup)
                "test"
            })

        println(obj)

        MOD_BUS.addListener(::addCreativeTab)
    }

    private fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER.log(Level.INFO, "Initializing client...")
    }

    private fun onServerSetup(event: FMLDedicatedServerSetupEvent) {
        LOGGER.log(Level.INFO, "Server starting...")
    }

    @SubscribeEvent
    fun onCommonSetup(event: FMLCommonSetupEvent) {
        LOGGER.log(Level.INFO, "Hello! This is working!")
    }

    private fun addCreativeTab(event: BuildCreativeModeTabContentsEvent) {
        when (event.tabKey) {
            CreativeModeTabs.BUILDING_BLOCKS -> {
                event.accept(ModBlocks.SKYRITE_ORE)
                event.accept(ModBlocks.DEEPSLATE_SKYRITE_ORE)
                event.accept(ModBlocks.SKYRITE_BLOCK)
            }

            CreativeModeTabs.INGREDIENTS -> {
                event.accept(ModItems.SKYRITE)
            }

            CreativeModeTabs.COMBAT -> {
                event.accept(ModItems.SKYRITE_AXE)
                event.accept(ModItems.SKYRITE_HOE)
                event.accept(ModItems.SKYRITE_PICKAXE)
                event.accept(ModItems.SKYRITE_SHOVEL)
                event.accept(ModItems.SKYRITE_SWORD)
            }
        }
    }
}
