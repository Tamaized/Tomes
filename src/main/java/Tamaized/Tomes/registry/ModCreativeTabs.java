package Tamaized.Tomes.registry;

import Tamaized.TamModized.registry.ITamModel;
import Tamaized.TamModized.registry.ITamRegistry;
import Tamaized.Tomes.Tomes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class ModCreativeTabs implements ITamRegistry {

	public static CreativeTabs tab;

	@Override
	public void preInit() {
		tab = new CreativeTabs("tomes") {
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(Tomes.items.thunder);
			}
		};
	}

	@Override
	public void init() {

	}

	@Override
	public void postInit() {

	}

	@Override
	public void clientPreInit() {

	}

	@Override
	public void clientInit() {

	}

	@Override
	public void clientPostInit() {

	}

	@Override
	public ArrayList<ITamModel> getModelList() {
		return new ArrayList<>();
	}

	@Override
	public String getModID() {
		return Tomes.modid;
	}
}
