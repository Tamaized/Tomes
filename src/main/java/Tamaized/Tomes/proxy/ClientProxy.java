package Tamaized.Tomes.proxy;

import Tamaized.TamModized.proxy.AbstractProxy;
import Tamaized.Tomes.Tomes;
import Tamaized.Tomes.network.ClientPacketHandler;

public class ClientProxy extends AbstractProxy {

	public ClientProxy() {
		super(Side.CLIENT);
	}

	@Override
	public void preRegisters() {

	}

	@Override
	public void preInit() {

	}

	@Override
	public void init() {

	}

	@Override
	public void postInit() {
		Tomes.channel.register(new ClientPacketHandler());
	}
}
