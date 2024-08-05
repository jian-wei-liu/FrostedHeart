package com.teammoeg.frostedheart.base.block;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import blusunrize.immersiveengineering.common.blocks.IEBaseBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

public abstract class PipeTileEntity extends IEBaseBlockEntity{

	public PipeTileEntity(BlockEntityType<? extends BlockEntity> type,BlockPos l,BlockState state) {
		super(type,l,state);

	}
    public abstract void onFaceChange(Direction dir,boolean isConnect);

}
