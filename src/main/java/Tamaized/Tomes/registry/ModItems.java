package Tamaized.Tomes.registry;

import Tamaized.Tomes.Tomes;
import Tamaized.Tomes.items.*;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tamaized.tammodized.registry.ITamRegistry;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = Tomes.modid)
public class ModItems {

	public static ItemTome thunder;
	public static ItemTome elthunder;
	public static ItemTome arcthunder;
	public static ItemTome thoron;
	private static ArrayList<ITamRegistry> list;

	static {
		list = new ArrayList<>();

		list.add(thunder = new TomeThunder());
		list.add(elthunder = new TomeElthunder());
		list.add(arcthunder = new TomeArcthunder());
		list.add(thoron = new TomeThoron());
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		for (ITamRegistry b : list)
			b.registerItem(event);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void registerModels(ModelRegistryEvent event) {
		for (ITamRegistry b : list)
			b.registerModel(event);
	}
}
