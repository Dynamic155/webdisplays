package net.montoyo.wd.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.montoyo.wd.core.ModBlockEntities;

/*
 * TODO registration-only port. Keystroke forwarding to a connected screen, the cat-sitting-on-
 * keyboard easter egg, and the two-block keyboard/keyboard-right pairing (see legacy-1.12.2
 * TileEntityKeyboard) aren't ported yet; they depend on TileEntityScreen and BlockKeyboardRight's
 * placement logic.
 */
public class TileEntityKeyboard extends BlockEntity {

    public TileEntityKeyboard(BlockPos pos, BlockState state) {
        super(ModBlockEntities.KEYBOARD.get(), pos, state);
    }

}
