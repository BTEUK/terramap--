package fr.smyler.terramap.proxy;

import fr.smyler.terramap.TerramapMod;
import fr.smyler.terramap.network.S2CTerramapHelloPacket;
import fr.smyler.terramap.network.TerramapPacketHandlers;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import net.minecraftforge.fml.relauncher.Side;

public class TerramapServerProxy extends TerramapProxy{

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		TerramapPacketHandlers.registerHandlers(Side.SERVER);
		TerramapMod.logger.debug("Terramap server pre-init");
	}

	@Override
	public void init(FMLInitializationEvent event) {
		TerramapMod.logger.debug("Terramap server init");
	}

	@Override
	public void onServerHello(S2CTerramapHelloPacket s) {
		// Should never be called on server
	}

	@Override
	public void onPlayerLoggedOut(PlayerLoggedOutEvent event) {
		// We don't care about that on servers
	}

	@Override
	public float getDefaultGuiSize() {
		// Don't care on server, this is just for the client config
		return 0;
	}

	@Override
	public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
	}

}
