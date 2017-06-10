package Tamaized.Tomes.proxy;

import Tamaized.TamModized.proxy.AbstractProxy;
import Tamaized.Tomes.Tomes;
import Tamaized.Tomes.entity.EntityElthunder;
import Tamaized.Tomes.entity.EntityThunder;
import Tamaized.Tomes.entity.render.RenderSpellElthunder;
import Tamaized.Tomes.entity.render.RenderSpellThunder;
import Tamaized.Tomes.network.ClientPacketHandler;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends AbstractProxy {

	public ClientProxy() {
		super(Side.CLIENT);
	}

	@Override
	public void preRegisters() {

	}

	@Override
	public void preInit() {
		RenderingRegistry.registerEntityRenderingHandler(EntityThunder.class, new IRenderFactory<EntityThunder>() {
			@Override
			public Render<? super EntityThunder> createRenderFor(RenderManager manager) {
				return new RenderSpellThunder(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityElthunder.class, new IRenderFactory<EntityElthunder>() {
			@Override
			public Render<? super EntityElthunder> createRenderFor(RenderManager manager) {
				return new RenderSpellElthunder(manager);
			}
		});
	}

	@Override
	public void init() {

	}

	@Override
	public void postInit() {
		Tomes.channel.register(new ClientPacketHandler());
	}
}
