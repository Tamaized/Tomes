package Tamaized.Tomes.items;

import Tamaized.Tomes.entity.EntityThoron;
import Tamaized.Tomes.entity.EntityThunder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TomeThoron extends ItemTome {

	public TomeThoron() {
		super("tome_thoron", 3);
	}

	@Override
	public boolean use(World world, EntityPlayer caster) {
		if (!world.isRemote)
			world.spawnEntity(new EntityThoron(world, caster));
		return true;
	}

	@Override
	public int getRGBDurabilityForDisplay(ItemStack stack) {
		return 0xFFFF00;
	}
}
