package net.montoyo.wd;

import com.mojang.logging.LogUtils;
import net.montoyo.wd.core.ModBlockEntities;
import net.montoyo.wd.core.ModBlocks;
import net.montoyo.wd.core.ModCreativeTab;
import net.montoyo.wd.core.ModItems;
import net.montoyo.wd.core.ModNetworking;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import org.slf4j.Logger;

@Mod(WebDisplays.MODID)
public class WebDisplays {
    public static final String MODID = "webdisplays";
    public static final Logger LOGGER = LogUtils.getLogger();

    public WebDisplays(IEventBus modEventBus) {
        LOGGER.info("WebDisplays initializing (port to Minecraft 26.2 in progress)");

        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTab.TABS.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);

        modEventBus.addListener(ModNetworking::register);
    }
}
