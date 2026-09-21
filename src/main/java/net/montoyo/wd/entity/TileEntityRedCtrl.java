package net.montoyo.wd.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.montoyo.wd.core.ModBlockEntities;

/*
 * TODO registration-only port. The redstone controller peripheral (see legacy-1.12.2
 * TileEntityRedCtrl/TileEntityPeripheralBase) isn't ported yet; its GUI-driven configuration and
 * screen redstone-input wiring depend on TileEntityScreen and the SMessageRedstoneCtrl packet.
 */
public class TileEntityRedCtrl extends BlockEntity {

    public TileEntityRedCtrl(BlockPos pos, BlockState state) {
        super(ModBlockEntities.REDSTONE_CONTROLLER.get(), pos, state);
    }

}
