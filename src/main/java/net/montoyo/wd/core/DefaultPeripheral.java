package net.montoyo.wd.core;

import net.minecraft.util.StringRepresentable;

/*
 * TODO: CC_INTERFACE/OC_INTERFACE (ComputerCraft/OpenComputers integration) are dropped for now --
 * neither mod has a Minecraft 26.2 release yet to compile against. Re-add once they do.
 * TileEntity classes for these peripherals aren't ported yet either (see net.montoyo.wd.entity in
 * legacy-1.12.2); BlockPeripheral currently doesn't instantiate any block entity.
 */
public enum DefaultPeripheral implements StringRepresentable {

    KEYBOARD("keyboard", "Keyboard"),                    //WITH FACING
    REMOTE_CONTROLLER("remotectrl", "Remote_Controller"), //WITHOUT FACING
    REDSTONE_CONTROLLER("redstonectrl", "Redstone_Controller"),
    SERVER("server", "Server");

    private final String name;
    private final String wikiName;

    DefaultPeripheral(String name, String wname) {
        this.name = name;
        wikiName = wname;
    }

    @Override
    public String getSerializedName() {
        return name;
    }

    public boolean hasFacing() {
        return this == KEYBOARD;
    }

    public String getWikiName() {
        return wikiName;
    }

}
