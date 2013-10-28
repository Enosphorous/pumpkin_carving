package enosphorous.pumpkins.itemblock;

import enosphorous.pumpkins.block.BlockMelon;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMelon extends ItemBlock{

	public ItemBlockMelon(int par1) {
		super(par1);
		setHasSubtypes(true);

	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack){
		return "tile.pumkinCarver" + BlockMelon.NaturalTypes.indexOf(itemstack.getItemDamage()).displayName.replace(" ", "");
	}

}
