package net.montoyo.wd.core;

import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

/*
 * TODO none of the original mod's ~14 packets (see legacy-1.12.2/.../net) are ported yet -- almost
 * all of them carry TileEntityScreen state or drive GUI screens that don't exist yet in this port.
 * This class is just the modern registration entry point (NeoForge replaced the old
 * SimpleNetworkWrapper/IMessage/@Message reflection setup -- see legacy Messages.java -- with
 * CustomPacketPayload records + StreamCodec, registered here via a PayloadRegistrar).
 *
 * Each future payload: a record implementing CustomPacketPayload with a TYPE + STREAM_CODEC, then
 * registrar.playToServer(TYPE, STREAM_CODEC, handler) or .playToClient(...) below.
 */
public class ModNetworking {

    private static final String PROTOCOL_VERSION = "1";

    public static void register(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(PROTOCOL_VERSION);
    }

}
