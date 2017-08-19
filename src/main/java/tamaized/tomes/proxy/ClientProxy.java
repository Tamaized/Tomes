package tamaized.tomes.proxy;

import tamaized.tomes.Tomes;
import tamaized.tomes.common.entity.EntityArcthunder;
import tamaized.tomes.common.entity.EntityElthunder;
import tamaized.tomes.common.entity.EntityThoron;
import tamaized.tomes.common.entity.EntityThunder;
import tamaized.tomes.client.entity.render.RenderSpellArcthunder;
import tamaized.tomes.client.entity.render.RenderSpellElthunder;
import tamaized.tomes.client.entity.render.RenderSpellThoron;
import tamaized.tomes.client.entity.render.RenderSpellThunder;
import tamaized.tomes.network.ClientPacketHandler;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import tamaized.tammodized.proxy.AbstractProxy;

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
		RenderingRegistry.registerEntityRenderingHandler(EntityArcthunder.class, new IRenderFactory<EntityArcthunder>() {
			@Override
			public Render<? super EntityArcthunder> createRenderFor(RenderManager manager) {
				return new RenderSpellArcthunder(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityThoron.class, new IRenderFactory<EntityThoron>() {
			@Override
			public Render<? super EntityThoron> createRenderFor(RenderManager manager) {
				return new RenderSpellThoron(manager);
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
