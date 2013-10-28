package enosphorous.pumpkins.block;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enosphorous.pumpkins.common.Remote;
import enosphorous.pumpkins.item.ItemCarvingKnife;
import enosphorous.pumpkins.item.Items;
import enosphorous.pumpkins.tile.TileEntityMelon;
import enosphorous.pumpkins.tile.TileEntityMelon.Color;
import enosphorous.pumpkins.tile.TileEntityMelon.Face;

public class BlockMelon extends BlockContainer {
	
	public enum NaturalTypes{
		pumpkin("Pumpkin"),
		melon("Melon"),
		whitePumpkin("Albino Pumpkin"),
		yellowPumpkin("Pale Pumpkin"),
		reset("void"); //used in resetting an unlit melon to lit. 
		
		public final String displayName;
		
		private NaturalTypes(String displayName){
			this.displayName = displayName;
		}
		
		public static NaturalTypes indexOf(int index){
			for(NaturalTypes bit : NaturalTypes.values())
				if(bit.ordinal() == index)
					return bit;
			return reset;
		}
		
		public static NaturalTypes getRandomPumpkinType(Random rand){
			if(rand.nextBoolean())
				return pumpkin;
			else
				if(rand.nextBoolean())
					return whitePumpkin;
				else
					return yellowPumpkin;
		}
	}
	
	Icon[][][][] sides = new Icon[2][Face.values().length][Color.values().length][2]; //type, face, color, lit

	protected BlockMelon(int id) {
		super(id, Material.pumpkin);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister icoReg){
        for(String type : new String[]{"pumpkin", "melon"})
        	for(Face face : Face.values())
        		for(Color color : Color.values())
        			for(String lit : new String[]{"off", "on"})
        				icoReg.registerIcon(buildString("pumpkins:", type, "-", face, "-", color, "-", lit));
    }
	
	private String buildString(Object... values){
		StringBuffer buff = new StringBuffer();
		
		for(Object value : values)
			buff.append(value);
		
		return buff.toString();
	}
	
	@SideOnly(Side.CLIENT)

    /**
     * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
     */
    public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side){
        return getIcon((TileEntityMelon)world.getBlockTileEntity(y, y, z), side);
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int sideId, int metadata){
    	return getIcon(createTileEntity(metadata), sideId);
    }
    
    @SideOnly(Side.CLIENT)
    private Icon getIcon(TileEntityMelon tile, int sideId){
    	return getIcon(tile.isMelon(), tile.getFace(sideId), tile.getColor(), tile.isLit());
    }
    
    @SideOnly(Side.CLIENT)
    private Icon getIcon(boolean isMelon, Face face, Color color, boolean isLit){
    	return sides[isMelon ? 1 : 0][face.ordinal()][color.ordinal()][isLit ? 1 : 0];
    }

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMelon();
	}
	
	@Override
	public TileEntity createTileEntity(World world, int metadata){
		return createTileEntity(metadata);
    }
	
	private TileEntityMelon createTileEntity(int meta){
		TileEntityMelon tile = new TileEntityMelon();
		
		NaturalTypes special = NaturalTypes.indexOf(meta);
		
		switch(special){
		case melon:
			tile.setMelon(true);
			break;
		case pumpkin:
			tile.setMelon(false);
			break;
		case whitePumpkin:
			tile.setColor(Color.white);
			break;
		case yellowPumpkin:
			tile.setColor(Color.yellow);
			break;
		default:
		}
		
		return tile;
	}
	
	private TileEntityMelon getTile(IBlockAccess world, int x, int y, int z){
		return (TileEntityMelon) world.getBlockTileEntity(x, y, z);
	}
	
	
	
	/**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int sideId, float par7, float par8, float par9){
    	ItemStack heldStack = player.inventory.getCurrentItem();
    	
        if(heldStack !=null){
    		Item heldItem = heldStack.getItem();
    		TileEntityMelon tile = getTile(world, x, y, z);
    		
    		if(heldItem instanceof ItemCarvingKnife){
    			if(tile.carve(ForgeDirection.getOrientation(sideId))){
    				player.inventory.getCurrentItem().damageItem(1, player);
    				
    				String s = "tilecrack_(" + blockID + ")";//TODO: Test this.

                    for (int j1 = 0; j1 < 8; ++j1)
                    {
                    	world.spawnParticle(s, x, y, z, world.rand.nextGaussian() * 0.15D, world.rand.nextDouble() * 0.2D, world.rand.nextGaussian() * 0.15D);
                    }

    				world.playSoundAtEntity(player, Remote.CARVE_SOUND, 1F, 1F);//TODO: move this to carve() and make sound play for ALL players nearby.
    				return true;
    			}
    		}
    		
    		if(heldItem.itemID == Item.stick.itemID)
    			tile.rotate();
    		
    		int oreId = OreDictionary.getOreID(player.inventory.getCurrentItem());
    		
    		if(oreId == OreDictionary.getOreID("dyeWhite") && tile.recolor(Color.white))
    			heldStack.splitStack(1);
    		if(oreId == OreDictionary.getOreID("dyeOrange") && tile.recolor(Color.orange))
    			heldStack.splitStack(1);
    		if(oreId == OreDictionary.getOreID("dyeMagenta") && tile.recolor(Color.magenta))
    			heldStack.splitStack(1);
    		if(oreId == OreDictionary.getOreID("dyeLightBlue") && tile.recolor(Color.lightblue))
    			heldStack.splitStack(1);
    		if(oreId == OreDictionary.getOreID("dyeYellow") && tile.recolor(Color.yellow))
    			heldStack.splitStack(1);
    		if(oreId == OreDictionary.getOreID("dyeLime") && tile.recolor(Color.lime))
    			heldStack.splitStack(1);
    		if(oreId == OreDictionary.getOreID("dyePink") && tile.recolor(Color.pink))
    			heldStack.splitStack(1);
    		if(oreId == OreDictionary.getOreID("dyeGray") && tile.recolor(Color.darkgrey))
    			heldStack.splitStack(1);
    		if(oreId == OreDictionary.getOreID("dyeLightGray") && tile.recolor(Color.lightgrey))
    			heldStack.splitStack(1);
    		if(oreId == OreDictionary.getOreID("dyeCyan") && tile.recolor(Color.cyan))
    			heldStack.splitStack(1);
    		if(oreId == OreDictionary.getOreID("dyePurple") && tile.recolor(Color.purple))
    			heldStack.splitStack(1);
    		if(oreId == OreDictionary.getOreID("dyeBlue") && tile.recolor(Color.blue))
    			heldStack.splitStack(1);
    		if(oreId == OreDictionary.getOreID("dyeBrown") && tile.recolor(Color.brown))
    			heldStack.splitStack(1);
    		if(oreId == OreDictionary.getOreID("dyeGreen") && tile.recolor(Color.green))
    			heldStack.splitStack(1);
    		if(oreId == OreDictionary.getOreID("dyeRed") && tile.recolor(Color.red))
    			heldStack.splitStack(1);
    		if(oreId == OreDictionary.getOreID("dyeBlack") && tile.recolor(Color.black))
    			heldStack.splitStack(1);
    		
    		if(heldItem.itemID == Block.torchWood.blockID && !tile.isLit()){
    			tile.setLit(true);
    			world.setBlock(x, y, z, Blocks.melonLit.blockID, NaturalTypes.reset.ordinal(), 3);
    		}
    		
    		if(heldItem.itemID == Block.torchRedstoneActive.blockID && !tile.isLit()){
    			tile.setLit(true);
    			tile.setRed(true);
    			world.setBlock(x, y, z, Blocks.melonLit.blockID, NaturalTypes.reset.ordinal(), 3);
    		}
    		
    		return true;
        }
	
        return false;
    }
	
    public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection axis){
    	getTile(world, x, y, z).rotate();
        return true;
    }
    
    /**
     * This returns a complete list of items dropped from this block.
     *
     * @param world The current world
     * @param x X Position
     * @param y Y Position
     * @param z Z Position
     * @param metadata Current metadata
     * @param fortune Breakers fortune level
     * @return A ArrayList containing all items this block drops
     */
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune){
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        
        TileEntityMelon tile = getTile(world, x, y, z);
        
        if(tile.isHasChanged()){
        	if(tile.isMelon())
        		ret.add(new ItemStack(Item.melon, world.rand.nextInt(6) + 3, 0));
        	else
        		ret.add(new ItemStack(Items.pumpkinMush, 1, 0));
        }
        else{
        	switch(NaturalTypes.indexOf(metadata)){
			case melon:
				ret.add(new ItemStack(Blocks.melon.blockID, 1, NaturalTypes.melon.ordinal()));
				break;
			case pumpkin:
				ret.add(new ItemStack(Blocks.melon.blockID, 1, NaturalTypes.pumpkin.ordinal()));
				break;
			case whitePumpkin:
				ret.add(new ItemStack(Blocks.melon.blockID, 1, NaturalTypes.whitePumpkin.ordinal()));
				break;
			case yellowPumpkin:
				ret.add(new ItemStack(Blocks.melon.blockID, 1, NaturalTypes.yellowPumpkin.ordinal()));
				break;
			default:
				break;
        	}
        }
        	
        
        return ret;
    }
    
    /**
     * Called on server worlds only when the block has been replaced by a different block ID, or the same block with a
     * different metadata value, but before the new metadata value is set. Args: World, x, y, z, old block ID, old
     * metadata
     */
    public void breakBlock(World world, int x, int y, int z, int oldBlockId, int oldMeta){
    	//if the old block wasn't lit, but the tile is now, then we're just lighting it
    	if(oldBlockId == Blocks.melon.blockID && getTile(world, x, y, z).isLit())
    		return;
    	else //otherwise, kill the tile. 
    		world.removeBlockTileEntity(x, y, z);
    }
    
    /**
     * Returns true if the block is emitting direct/strong redstone power on the specified side. Args: World, X, Y, Z,
     * side. Note that the side is reversed - eg it is 1 (up) when checking the bottom of the block.
     */
    public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int side){
    	return getTile(world, x, y, z).isRed() ? 15 : 0;
    }
	

}
