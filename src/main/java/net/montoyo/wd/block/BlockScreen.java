package net.montoyo.wd.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.Nullable;

/*
 * TODO this is a registration-only port for now. The original 1.12.2 BlockScreen implemented a
 * whole custom multiblock system (see Multiblock/BlockSide/TileEntityScreen in legacy-1.12.2) that
 * drives right-click screen creation, per-side neighbor "connected texture" flags via
 * ExtendedBlockState/IUnlistedProperty (which no longer exist), redstone I/O, and pixel-accurate
 * click mapping. None of that is wired up here yet -- it depends on TileEntityScreen, which hasn't
 * been ported to BlockEntity yet.
 */
public class BlockScreen extends Block {
    public static final MapCodec<BlockScreen> CODEC = simpleCodec(BlockScreen::new);

    public static final BooleanProperty HAS_TE = BooleanProperty.create("haste");
    public static final BooleanProperty EMITTING = BooleanProperty.create("emitting");

    public BlockScreen(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(HAS_TE, false).setValue(EMITTING, false));
    }

    @Override
    protected MapCodec<BlockScreen> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HAS_TE, EMITTING);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        // TODO: port the multiblock screen-creation/click-handling logic from legacy BlockScreen#onBlockActivated
        return InteractionResult.PASS;
    }

    @Override
    protected int getSignal(BlockState state, net.minecraft.world.level.BlockGetter level, BlockPos pos, Direction direction) {
        return state.getValue(EMITTING) ? 15 : 0;
    }

    @Override
    protected boolean isSignalSource(BlockState state) {
        return state.getValue(EMITTING);
    }
}
