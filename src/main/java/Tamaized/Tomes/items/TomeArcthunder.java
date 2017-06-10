package Tamaized.Tomes.items;

import Tamaized.Tomes.entity.EntityArcthunder;
import Tamaized.Tomes.entity.EntityElthunder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TomeArcthunder extends ItemTome {

	public TomeArcthunder() {
		super("tome_arcthunder", 4);
	}

	@Override
	public boolean use(World world, EntityPlayer caster) {
		if (!world.isRemote)
			world.spawnEntity(new EntityArcthunder(world, caster));
		return true;
	}

	@Override
	public int getRGBDurabilityForDisplay(ItemStack stack) {
		return 0xFFFF00;
	}
}
