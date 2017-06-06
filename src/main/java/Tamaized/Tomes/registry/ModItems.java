package Tamaized.Tomes.registry;

import Tamaized.TamModized.registry.ITamModel;
import Tamaized.TamModized.registry.ITamRegistry;
import Tamaized.Tomes.Tomes;

import java.util.ArrayList;

public class ModItems implements ITamRegistry {

	private ArrayList<ITamModel> models;

	@Override
	public void preInit() {
		models = new ArrayList<>();
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
