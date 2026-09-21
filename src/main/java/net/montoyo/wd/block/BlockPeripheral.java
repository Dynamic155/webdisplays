package net.montoyo.wd.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.montoyo.wd.core.DefaultPeripheral;
import org.jspecify.annotations.Nullable;

/*
 * TODO registration-only port. The original BlockPeripheral backs 5 different peripheral types
 * (keyboard, CC/OC interface, remote controller, redstone controller, server) each with their own
 * TileEntity and right-click behavior (see legacy-1.12.2 BlockPeripheral). None of the per-type
 * TileEntities are ported yet, so this block currently has no block entity and no interaction logic.
 * The keyboard's special 2-block placement logic (BlockKeyboardRight) and bounding boxes are also
 * not yet ported.
 */
public class BlockPeripheral extends Block {
    public static final MapCodec<BlockPeripheral> CODEC = simpleCodec(BlockPeripheral::new);

    public static final EnumProperty<DefaultPeripheral> TYPE = EnumProperty.create("type", DefaultPeripheral.class);
    public static final IntegerProperty FACING = IntegerProperty.create("facing", 0, 3);

    public BlockPeripheral(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(TYPE, DefaultPeripheral.KEYBOARD).setValue(FACING, 0));
    }

    @Override
    protected MapCodec<BlockPeripheral> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE, FACING);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        LivingEntity placer = context.getPlayer();
        int rot = placer == null ? 0 : Mth.floor(placer.getYRot() * 4.0f / 360.0f + 2.5) & 3;
        return defaultBlockState().setValue(FACING, rot);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        // TODO: port the per-peripheral-type interaction logic from legacy BlockPeripheral#onBlockActivated
        return InteractionResult.PASS;
    }
}
