package Tamaized.Tomes.items;

import Tamaized.Tomes.entity.EntityElthunder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TomeElthunder extends ItemTome {

	public TomeElthunder() {
		super("tome_elthunder", 15);
	}

	@Override
	public boolean use(World world, EntityPlayer caster) {
		if (!world.isRemote)
			world.spawnEntity(new EntityElthunder(world, caster));
		return true;
	}

	@Override
	public int getRGBDurabilityForDisplay(ItemStack stack) {
		return 0xFFFF00;
	}
}
