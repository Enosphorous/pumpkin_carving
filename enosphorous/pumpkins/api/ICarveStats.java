package enosphorous.pumpkins.api;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.EnumChatFormatting;

public interface ICarveStats {
	
	/**
	 * Will return the material that the tool is made of. Used to repair tools/to find the
	 * durability and stuffs. Only applies to item counterparts.
	 * 
	 * @return The item returned is the item that the tools can be repaired by means of. This is
	 * mainly for outside reference and can be used in events in the future.
	 */
	public Item toolMaterialItem();
	
	/**
	 * Will return the material that the tool is made of. Used to repair tools/to find the
	 * durability and stuffs. Only applies to block counterparts.
	 * 
	 * @return The item returned is the item that the tools can be repaired by means of. This is
	 * mainly for outside reference and can be used in events in the future.
	 */
	public Block toolMaterialBlock();
	
	/**
	 * This is mainly for outside uses, and can be used to find the MAXIMUM durability for the
	 * tool. This can be used in external referencing.
	 * 
	 * @return The integer that represents the number of uses the item has. Can be used to create
	 * modification add-ons and other fun stuff.
	 */
	public int durability();

}
