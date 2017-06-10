package Tamaized.Tomes.registry;

import Tamaized.TamModized.registry.ITamModel;
import Tamaized.TamModized.registry.ITamRegistry;
import Tamaized.Tomes.Tomes;
import Tamaized.Tomes.items.ItemTome;
import Tamaized.Tomes.items.TomeArcthunder;
import Tamaized.Tomes.items.TomeElthunder;
import Tamaized.Tomes.items.TomeThunder;

import java.util.ArrayList;

public class ModItems implements ITamRegistry {

	private ArrayList<ITamModel> models;

	public static ItemTome thunder;
	public static ItemTome elthunder;
	public static ItemTome arcthunder;

	@Override
	public void preInit() {
		models = new ArrayList<>();

		models.add(thunder = new TomeThunder());
		models.add(elthunder = new TomeElthunder());
		models.add(arcthunder = new TomeArcthunder());
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
		return models;
	}

	@Override
	public String getModID() {
		return Tomes.modid;
	}
}
