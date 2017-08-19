package tamaized.tomes.registry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ModCreativeTabs {

	public static CreativeTabs tab = new CreativeTabs("tomes") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.thunder);
		}
	};
}
