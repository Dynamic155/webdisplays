package net.montoyo.wd.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.montoyo.wd.core.ModBlockEntities;

/*
 * TODO registration-only port. This is the mod's core piece and by far the largest (~1100 lines in
 * legacy-1.12.2 TileEntityScreen): multiblock screen state (an inner Screen class per multiblock
 * side), URL/resolution/rotation config, per-player permissions (ScreenRights), upgrades
 * (DefaultUpgrade), redstone I/O, and the JS query bridge back to the embedded MCEF browser. None
 * of that is ported yet. Most of the mod's network packets and every peripheral TileEntity
 * ultimately operate on a connected TileEntityScreen, so porting this is the natural next step
 * after this registration pass.
 */
public class TileEntityScreen extends BlockEntity {

    public TileEntityScreen(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SCREEN.get(), pos, state);
    }

}
