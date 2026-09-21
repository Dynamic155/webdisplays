package net.montoyo.wd.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.montoyo.wd.core.ModBlockEntities;

/*
 * TODO registration-only port. Owner tracking (setOwner/NameUUIDPair) and the miniserv-backed
 * right-click behavior (see legacy-1.12.2 TileEntityServer) aren't ported yet -- they depend on
 * Util.readOwnerFromNBT/writeOwnerToNBT and the ServerData network packet, neither ported.
 */
public class TileEntityServer extends BlockEntity {

    public TileEntityServer(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SERVER.get(), pos, state);
    }

}
