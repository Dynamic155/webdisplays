package net.montoyo.wd.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.montoyo.wd.WebDisplays;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTab {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WebDisplays.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WEBDISPLAYS = TABS.register("webdisplays", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.webdisplays"))
            .icon(() -> ModItems.SCREEN.toStack())
            .displayItems((parameters, output) -> {
                output.accept(ModItems.SCREEN.get());
                output.accept(ModItems.PERIPHERAL.get());
                output.accept(ModItems.SCREEN_CONFIGURATOR.get());
                output.accept(ModItems.OWNERSHIP_THIEF.get());
                output.accept(ModItems.LINKER.get());
                output.accept(ModItems.MINE_PAD.get());
                output.accept(ModItems.LASER_POINTER.get());
                ModItems.UPGRADES.values().forEach(item -> output.accept(item.get()));
                ModItems.CRAFT_COMPONENTS.values().forEach(item -> output.accept(item.get()));
                // Advancement icon items are internal-only (used as advancement JSON icons); not shown in the creative tab.
            })
            .build());

}
