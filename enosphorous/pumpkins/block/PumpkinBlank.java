package enosphorous.pumpkins.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PumpkinBlank extends Block{

	public PumpkinBlank(int par1, Material par2Material) {
		super(par1, par2Material);
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName("pumpkins:pumpkin");

	}
	
    /** The type of tree this log came from. */
    public static final String[] color = {"albino", "brown", "cactus", "cyan", "grey", "lapis", "lightblue", 
    		                              "lightgrey", "lime", "magenta", "pink", "purple", "red", "yellow", "orange"};
    @SideOnly(Side.CLIENT)
    private Icon[] pumpkin_side;
    @SideOnly(Side.CLIENT)
    private Icon[] pumpkin_top;
    
    @SideOnly(Side.CLIENT)

    /**
     * The icon for the side of the block.
     */
    protected Icon getSideIcon(int par1)
    {
        return this.pumpkin_side[par1];
    }

    @SideOnly(Side.CLIENT)

    /**
     * The icon for the tops and bottoms of the block.
     */
    protected Icon getEndIcon(int par1)
    {
        return this.pumpkin_top[par1];
    }
    
    @Override
    public void getSubBlocks(int id, CreativeTabs tab, List list){
    	
    	for(int i = 0; i < PumpkinBlank.color.length; i++){
    		
    		list.add(new ItemStack(this, 1, i));
    		
    	}
    	
    }
    
    @Override
    public int damageDropped(int meta){
    	
    	return meta;
    	
    }
    
    @Override
    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.pumpkin_side = new Icon[color.length];
        this.pumpkin_top = new Icon[color.length];

        for (int i = 0; i < this.pumpkin_side.length; ++i)
        {
            this.pumpkin_side[i] = par1IconRegister.registerIcon(this.getTextureName() + "_" + color[i] + "_side");
            this.pumpkin_top[i] = par1IconRegister.registerIcon(this.getTextureName() + "_" + color[i] + "_top");
        }
    }

}
