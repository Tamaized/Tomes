package tamaized.tomes.common.items;

import tamaized.tomes.common.entity.EntityThunder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TomeThunder extends ItemTome {

	public TomeThunder() {
		super("tome_thunder", 20);
	}

	@Override
	public boolean use(World world, EntityPlayer caster) {
		if (!world.isRemote)
			world.spawnEntity(new EntityThunder(world, caster));
		return true;
	}

	@Override
	public int getRGBDurabilityForDisplay(ItemStack stack) {
		return 0xFFFF00;
	}
}
