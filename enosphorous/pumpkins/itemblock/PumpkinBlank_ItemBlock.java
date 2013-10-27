package enosphorous.pumpkins.itemblock;

import enosphorous.pumpkins.block.PumpkinBlank;
import enosphorous.pumpkins.common.Remote;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class PumpkinBlank_ItemBlock extends ItemBlock{

	public PumpkinBlank_ItemBlock(int par1) {
		super(par1);
		setHasSubtypes(true);

	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack){
		
		
		return "tile." + PumpkinBlank.color[itemstack.getItemDamage()];
	}

}
