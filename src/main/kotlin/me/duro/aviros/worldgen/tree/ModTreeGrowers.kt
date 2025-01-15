package me.duro.aviros.worldgen.tree

import me.duro.aviros.Aviros
import me.duro.aviros.worldgen.ModConfiguredFeatures
import net.minecraft.world.level.block.grower.TreeGrower
import java.util.*

object ModTreeGrowers {
    val JYNWOOD = TreeGrower(
        Aviros.MOD_ID + ":jynwood",
        Optional.empty(), Optional.of(ModConfiguredFeatures.JYNWOOD_KEY), Optional.empty(),
    )
}