package tamaized.tomes.common.items;

import tamaized.tomes.registry.ModCreativeTabs;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import tamaized.tammodized.common.items.TamItem;

import javax.annotation.Nullable;
import java.util.List;

public abstract class ItemTome extends TamItem {

	private static final TextFormatting[] colors = new TextFormatting[]{TextFormatting.DARK_RED, TextFormatting.RED, TextFormatting.GOLD, TextFormatting.YELLOW, TextFormatting.DARK_GREEN, TextFormatting.GREEN};

	public ItemTome(String n, int maxUse) {
		super(ModCreativeTabs.tab, n, 1);
		setMaxDamage(maxUse);
	}

	@Override
	public final ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		if (use(worldIn, playerIn))
			stack.damageItem(1, playerIn);
		return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
	}

	/**
	 * @param world
	 * @param caster
	 * @return true if we should damage the item
	 */
	public abstract boolean use(World world, EntityPlayer caster);

	@Override
	public final boolean showDurabilityBar(ItemStack stack) {
		return true;
	}

	@Override
	public abstract int getRGBDurabilityForDisplay(ItemStack stack);

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(TextFormatting.DARK_PURPLE + "Uses Left: " + getTextColorFromDurability(stack) + (stack.getMaxDamage() - stack.getItemDamage()));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	private TextFormatting getTextColorFromDurability(ItemStack stack) {
		float perc = 1 - ((float) stack.getItemDamage() / (float) stack.getMaxDamage());
		for (int i = colors.length - 1; i >= 0; i--) {
			if (perc >= ((float) i / (float) colors.length))
				return colors[i];
		}
		return colors[0];
	}
}
