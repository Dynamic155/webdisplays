package net.montoyo.wd.core;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.montoyo.wd.WebDisplays;
import net.montoyo.wd.block.BlockKeyboardRight;
import net.montoyo.wd.block.BlockPeripheral;
import net.montoyo.wd.block.BlockScreen;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(WebDisplays.MODID);

    public static final DeferredBlock<BlockScreen> SCREEN = BLOCKS.registerBlock("screen", BlockScreen::new, () ->
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .strength(1.5f, 10.f)
                    .pushReaction(PushReaction.IGNORE));

    public static final DeferredBlock<BlockPeripheral> PERIPHERAL = BLOCKS.registerBlock("peripheral", BlockPeripheral::new, () ->
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .strength(1.5f, 10.f)
                    .pushReaction(PushReaction.IGNORE));

    public static final DeferredBlock<BlockKeyboardRight> KEYBOARD_RIGHT = BLOCKS.registerBlock("keyboard", BlockKeyboardRight::new, () ->
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .strength(1.5f, 10.f)
                    .pushReaction(PushReaction.IGNORE)
                    .noOcclusion());

}
