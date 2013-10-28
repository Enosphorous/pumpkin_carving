package enosphorous.pumpkins.tile;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityMelon extends TileEntity {
	
	
	public enum Face{
		blank,
		vanilla,
		creeper,
		skeleton,
		fangs,
		skeleton_two,
		villager,
		sword,
		pickaxe,
		top,
		bottom;
		
		public static Face indexOf(int index){
			for(Face bit : Face.values())
				if(bit.ordinal() == index)
					return bit;
			return blank;
		}
		
		public static Face increment(Face input){
			int id = input.ordinal();
			if(id + 1 == top.ordinal())
				return vanilla;
			else
				return indexOf(id + 1);
		}
	}
	
	public enum Color{
		none,
		white,
		orange,
		magenta,
		lightblue,
		yellow,
		lime,
		pink,
		darkgrey,
		lightgrey,
		cyan,
		purple,
		blue,
		brown,
		green,
		red,
		black;
		
		public static Color indexOf(int index){
			for(Color bit : Color.values())
				if(bit.ordinal() == index)
					return bit;
			return none;
		}
	}
	
	private boolean isMelon = false; //false is pumpkin, true is melon
	private Face[] faces = {Face.bottom, Face.top, Face.blank, Face.blank, Face.blank, Face.blank}; //Ordered by ForgeDirection
	private Color color = Color.none;
	private boolean isLit = false; //false is off, true is on.
	private boolean isRed = false; //false is regualar, true is redstone torch.
	private boolean hasChanged = false; //becomes true when the player modifies this melon.

	
	
	
	public boolean isMelon() {
		return isMelon;
	}

	public void setMelon(boolean isMelon) {
		this.isMelon = isMelon;
	}

	public Face[] getFaces() {
		return faces;
	}

	public void setFaces(Face[] faces) {
		this.faces = faces;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isLit() {
		return isLit;
	}

	public void setLit(boolean isLit) {
		hasChanged = true;
		this.isLit = isLit;
	}

	public boolean isRed() {
		return isRed;
	}

	public void setRed(boolean isRed) {
		hasChanged = true;
		this.isRed = isRed;
	}

	public boolean isHasChanged() {
		return hasChanged;
	}

	public boolean canUpdate(){
        return false;
    }
	
	public Face getFace(int sideId){
		return faces[sideId];
	}
	
	public boolean carve(ForgeDirection side){
		if(side == ForgeDirection.DOWN || side == ForgeDirection.UP || side == ForgeDirection.UNKNOWN)
			return false;
		else{
			if(faces[side.ordinal()] == Face.blank)
				dropItemStack(worldObj, xCoord, yCoord, zCoord, new ItemStack(Item.pumpkinSeeds, worldObj.rand.nextInt(3) + 1, 0));
			
			faces[side.ordinal()] = Face.increment(faces[side.ordinal()]);
			hasChanged = true;
			return true;
		}
	}
	
	public void rotate(){
		Face temp = faces[2];
		faces [2] = faces[3];
		faces[3] = faces[4];
		faces[4] = faces[5];
		faces[5] = temp;
		hasChanged = true;
	}
	
	public boolean recolor(Color newColor){
		if(newColor != color){
			color = newColor;
			hasChanged = true;
			return true;
		}
		else
			return false;
	}
	
	private void dropItemStack(World world, int x, int y, int z, ItemStack stack)
    {
        if (world == null || stack == null || stack.stackSize <= 0)
        {
            return;
        }

        if (!world.isRemote && world.getGameRules().getGameRuleBooleanValue("doTileDrops"))
        {
            float f = 0.7F;
            double d0 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            double d1 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            double d2 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            EntityItem entityitem = new EntityItem(world, (double)x + d0, (double)y + d1, (double)z + d2, stack);
            entityitem.delayBeforeCanPickup = 10;
            world.spawnEntityInWorld(entityitem);
        }
    }
	
	
	@Override
    public void readFromNBT(NBTTagCompound tag){
		isMelon = tag.getBoolean("isMelon");
		for(int i = 2; i < faces.length; i++)
			faces[i] = Face.indexOf(tag.getByte("Face" + i));
		color = Color.indexOf(tag.getByte("Color"));
		isLit = tag.getBoolean("isLit");
		isRed = tag.getBoolean("isRed");
		hasChanged = tag.getBoolean("hasChanged");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag){
    	tag.setBoolean("isMelon", isMelon);
    	for(int i = 2; i < faces.length; i++)
    		tag.setByte("Face" + i, (byte)faces[i].ordinal());
    	tag.setByte("Color", (byte)color.ordinal());
    	tag.setBoolean("isLit", isLit);
    	tag.setBoolean("isRed", isRed);
    	tag.setBoolean("hasChanged", hasChanged);
    }
	
    @Override
    public final Packet getDescriptionPacket(){
        NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, tag);
    }

    @Override
    public final void onDataPacket(INetworkManager net, Packet132TileEntityData packet){
        this.readFromNBT(packet.data);
    }
	
}
