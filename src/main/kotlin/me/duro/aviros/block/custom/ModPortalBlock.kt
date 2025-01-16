package me.duro.aviros.block.custom

import me.duro.aviros.Aviros
import me.duro.aviros.worldgen.dimension.ModDimensions
import net.minecraft.core.BlockPos
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult

class ModPortalBlock(properties: Properties) : Block(properties) {
    override fun useItemOn(
        stack: ItemStack,
        state: BlockState,
        level: Level,
        pos: BlockPos,
        player: Player,
        hand: InteractionHand,
        hitResult: BlockHitResult
    ): InteractionResult {
        val destination = when (level.dimension()) {
            ModDimensions.AVIROS_LEVEL_KEY -> Level.OVERWORLD
            else -> ModDimensions.AVIROS_LEVEL_KEY
        }

        val serverLevel = level.server?.getLevel(destination) ?: return InteractionResult.FAIL
        player.teleportTo(serverLevel, pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), setOf(), 0f, 0f, false)
        return InteractionResult.SUCCESS
    }
}