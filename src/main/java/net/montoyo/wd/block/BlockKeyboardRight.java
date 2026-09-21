package net.montoyo.wd.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

/*
 * TODO registration-only port. This is the "right half" companion block placed automatically next
 * to a keyboard peripheral (see legacy-1.12.2 BlockKeyboardRight/BlockPeripheral). The placement
 * pairing logic, TileEntityKeyboard connection, and cat-sitting-on-keyboard easter egg aren't ported
 * yet.
 */
public class BlockKeyboardRight extends Block {
    public static final MapCodec<BlockKeyboardRight> CODEC = simpleCodec(BlockKeyboardRight::new);

    public static final IntegerProperty FACING = IntegerProperty.create("facing", 0, 3);

    public BlockKeyboardRight(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(FACING, 0));
    }

    @Override
    protected MapCodec<BlockKeyboardRight> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        // TODO: port keyboard interaction from legacy BlockKeyboardRight#onBlockActivated
        return InteractionResult.PASS;
    }
}
