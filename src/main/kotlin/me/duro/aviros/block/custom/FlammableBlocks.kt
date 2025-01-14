package me.duro.aviros.block.custom

import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.LeavesBlock
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.BlockState

class FlammablePlanks(properties: BlockBehaviour.Properties) : Block(properties) {
    override fun isFlammable(state: BlockState, level: BlockGetter, pos: BlockPos, direction: Direction) = true
    override fun getFlammability(state: BlockState, level: BlockGetter, pos: BlockPos, direction: Direction) = 20
    override fun getFireSpreadSpeed(state: BlockState, level: BlockGetter, pos: BlockPos, direction: Direction) = 5
}

class FlammableLeaves(properties: BlockBehaviour.Properties) : LeavesBlock(properties) {
    override fun isFlammable(state: BlockState, level: BlockGetter, pos: BlockPos, direction: Direction) = true
    override fun getFlammability(state: BlockState, level: BlockGetter, pos: BlockPos, direction: Direction) = 60
    override fun getFireSpreadSpeed(state: BlockState, level: BlockGetter, pos: BlockPos, direction: Direction) = 30
}