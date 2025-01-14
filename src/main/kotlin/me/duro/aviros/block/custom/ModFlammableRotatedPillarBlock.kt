package me.duro.aviros.block.custom

import me.duro.aviros.block.ModBlocks
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.item.AxeItem
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.block.RotatedPillarBlock
import net.minecraft.world.level.block.state.BlockState
import net.neoforged.neoforge.common.ItemAbility

class ModFlammableRotatedPillarBlock(properties: Properties) : RotatedPillarBlock(properties) {
    override fun isFlammable(state: BlockState, level: BlockGetter, pos: BlockPos, direction: Direction) = true
    override fun getFlammability(state: BlockState, level: BlockGetter, pos: BlockPos, direction: Direction) = 5
    override fun getFireSpreadSpeed(state: BlockState, level: BlockGetter, pos: BlockPos, direction: Direction) = 5

    override fun getToolModifiedState(
        state: BlockState, context: UseOnContext, itemAbility: ItemAbility, simulate: Boolean
    ): BlockState? {
        val strippedWoods = mapOf(
            ModBlocks.JYNWOOD_LOG.get() to ModBlocks.STRIPPED_JYNWOOD_LOG.get(),
            ModBlocks.JYNWOOD_WOOD.get() to ModBlocks.STRIPPED_JYNWOOD_WOOD.get()
        )

        if (context.itemInHand.item is AxeItem) {
            val strippedWood = strippedWoods[state.block]
            if (strippedWood != null) return strippedWood.defaultBlockState().setValue(AXIS, state.getValue(AXIS))
        }

        return super.getToolModifiedState(state, context, itemAbility, simulate)
    }
}