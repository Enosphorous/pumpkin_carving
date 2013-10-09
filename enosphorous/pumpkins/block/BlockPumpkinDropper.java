package enosphorous.pumpkins.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockPumpkinDropper extends Block{

	public BlockPumpkinDropper(int par1, Material par2Material) {
		super(par1, par2Material);

	}
	
	@Override
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return par1Random.nextInt(3) + 1;
    }
	
	@Override

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Item.pumpkinSeeds.itemID;
    }

}
