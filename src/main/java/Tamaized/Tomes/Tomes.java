package Tamaized.Tomes;

import Tamaized.TamModized.TamModBase;
import Tamaized.TamModized.TamModized;
import Tamaized.TamModized.proxy.AbstractProxy;
import Tamaized.Tomes.network.ServerPacketHandler;
import Tamaized.Tomes.registry.ModItems;
import Tamaized.Tomes.sound.ModSoundEvents;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.FMLEventChannel;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.apache.logging.log4j.LogManager;

@Mod(modid = Tomes.modid, name = "VoidCraft", version = Tomes.version, dependencies = "required-before:" + TamModized.modid + "@[${tamversion},)")
public class Tomes extends TamModBase {

	public static final String version = "${version}";
	public static final String modid = "tomes";
	public static final String networkChannelName = "Tomes";

	@Mod.Instance(modid)
	public static Tomes instance = new Tomes();

	public static FMLEventChannel channel;

	public static ModItems items;

	@SidedProxy(clientSide = "Tamaized.Tomes.proxy.ClientProxy", serverSide = "Tamaized.Tomes.proxy.ServerProxy")
	public static AbstractProxy proxy;

	public static String getVersion() {
		return version;
	}

	@Override
	protected AbstractProxy getProxy() {
		return proxy;
	}

	@Override
	public String getModID() {
		return modid;
	}

	@Override
	@EventHandler
	public void FMLpreInit(FMLPreInitializationEvent event) {
		super.FMLpreInit(event);
	}

	@Override
	@EventHandler
	public void FMLinit(FMLInitializationEvent event) {
		super.FMLinit(event);
	}

	@Override
	@EventHandler
	public void FMLpostInit(FMLPostInitializationEvent event) {
		super.FMLpostInit(event);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		logger = LogManager.getLogger("Tomes");

		logger.info("Starting Tomes PreInit");

		channel = NetworkRegistry.INSTANCE.newEventDrivenChannel(networkChannelName);

		register(items = new ModItems());

		ModSoundEvents.register();

	}

	@Override
	public void init(FMLInitializationEvent event) {
		logger.info("Starting Tomes Init");

	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		logger.info("Starting Tomes PostInit");

		channel.register(new ServerPacketHandler());

	}

}