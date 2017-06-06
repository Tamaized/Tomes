package Tamaized.Tomes.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TomeThunder extends ItemTome {

	public TomeThunder() {
		super("tome_thunder", 30);
	}

	@Override
	public boolean use(World world, EntityPlayer caster) {
		return true;
	}

	@Override
	public int getRGBDurabilityForDisplay(ItemStack stack) {
		return 0xFFFF00;
	}
}
