package tamaized.tomes;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import org.apache.logging.log4j.LogManager;
import tamaized.tammodized.TamModBase;
import tamaized.tammodized.TamModized;
import tamaized.tammodized.proxy.AbstractProxy;
import tamaized.tomes.common.entity.EntityArcthunder;
import tamaized.tomes.common.entity.EntityElthunder;
import tamaized.tomes.common.entity.EntityThoron;
import tamaized.tomes.common.entity.EntityThunder;
import tamaized.tomes.common.sound.ModSoundEvents;
import tamaized.tomes.network.NetworkMessages;
import tamaized.tomes.registry.ModCreativeTabs;
import tamaized.tomes.registry.ModItems;

@Mod(modid = Tomes.modid, name = "VoidCraft", version = Tomes.version, dependencies = "required-before:" + TamModized.modid + "@[${tamversion},)")
public class Tomes extends TamModBase {

	public static final String version = "${version}";
	public static final String modid = "tomes";
	public static final String networkChannelName = "Tomes";
	public static final ModItems items = new ModItems();
	public static final ModCreativeTabs tabs = new ModCreativeTabs();
	@Mod.Instance(modid)
	public static Tomes instance = new Tomes();
	public static SimpleNetworkWrapper network;
	@SidedProxy(clientSide = "tamaized.tomes.proxy.ClientProxy", serverSide = "tamaized.tomes.proxy.ServerProxy")
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

		NetworkMessages.register(network = NetworkRegistry.INSTANCE.newSimpleChannel(modid));

		ModSoundEvents.register();

		registerEntity(EntityThunder.class, "Thunder", this, modid, 128, 1, true);
		registerEntity(EntityElthunder.class, "Elthunder", this, modid, 128, 1, true);
		registerEntity(EntityArcthunder.class, "Arcthunder", this, modid, 128, 1, true);
		registerEntity(EntityThoron.class, "Thoron", this, modid, 128, 1, true);

	}

	@Override
	public void init(FMLInitializationEvent event) {
		logger.info("Starting Tomes Init");

	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		logger.info("Starting Tomes PostInit");
	}

}