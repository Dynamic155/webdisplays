package net.montoyo.wd.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.montoyo.wd.core.ModBlockEntities;

/*
 * TODO registration-only port. The "remote controller" peripheral -- right-click to open a
 * connected screen's URL config remotely (see legacy-1.12.2 TileEntityRCtrl/TileEntityPeripheralBase)
 * -- isn't ported yet; it depends on TileEntityScreen and the SetURLData packet, neither ported.
 */
public class TileEntityRCtrl extends BlockEntity {

    public TileEntityRCtrl(BlockPos pos, BlockState state) {
        super(ModBlockEntities.REMOTE_CONTROLLER.get(), pos, state);
    }

}
