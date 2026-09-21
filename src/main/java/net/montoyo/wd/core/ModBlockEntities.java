package net.montoyo.wd.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.montoyo.wd.WebDisplays;
import net.montoyo.wd.entity.TileEntityKeyboard;
import net.montoyo.wd.entity.TileEntityRCtrl;
import net.montoyo.wd.entity.TileEntityRedCtrl;
import net.montoyo.wd.entity.TileEntityScreen;
import net.montoyo.wd.entity.TileEntityServer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, WebDisplays.MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileEntityScreen>> SCREEN = BLOCK_ENTITIES.register("screen", () ->
            new BlockEntityType<>(TileEntityScreen::new, ModBlocks.SCREEN.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileEntityKeyboard>> KEYBOARD = BLOCK_ENTITIES.register("keyboard", () ->
            new BlockEntityType<>(TileEntityKeyboard::new, ModBlocks.PERIPHERAL.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileEntityRCtrl>> REMOTE_CONTROLLER = BLOCK_ENTITIES.register("remotectrl", () ->
            new BlockEntityType<>(TileEntityRCtrl::new, ModBlocks.PERIPHERAL.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileEntityRedCtrl>> REDSTONE_CONTROLLER = BLOCK_ENTITIES.register("redstonectrl", () ->
            new BlockEntityType<>(TileEntityRedCtrl::new, ModBlocks.PERIPHERAL.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileEntityServer>> SERVER = BLOCK_ENTITIES.register("server", () ->
            new BlockEntityType<>(TileEntityServer::new, ModBlocks.PERIPHERAL.get()));

}
