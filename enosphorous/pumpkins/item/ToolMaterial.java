package enosphorous.pumpkins.item;

import enosphorous.pumpkins.common.Remote;
import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;

public class ToolMaterial {
	
	public static EnumToolMaterial WOOD_CARVER;
	public static EnumToolMaterial STONE_CARVER;
	public static EnumToolMaterial IRON_CARVER;
	public static EnumToolMaterial GOLD_CARVER;
	public static EnumToolMaterial DIAMOND_CARVER;
	
	/**
	 * Begin compatibility tool materials.
	 */
	
	public static EnumToolMaterial MUD_CARVER;
	public static EnumToolMaterial AMETHYST_CARVER;
	public static EnumToolMaterial THAUMIUM_CARVER;
	
	public static void init(){
		
		WOOD_CARVER = EnumHelper.addToolMaterial("WOOD_CARVER", 0, Remote.WOOD_DURABILITY, 1, 1, 0);
		STONE_CARVER = EnumHelper.addToolMaterial("STONE_CARVER", 0, Remote.STONE_DURABILITY, 1, 3, 0);
		IRON_CARVER = EnumHelper.addToolMaterial("IRON_CARVER", 0, Remote.IRON_DURABILITY, 1, 4, 0);
		GOLD_CARVER = EnumHelper.addToolMaterial("GOLD_CARVER", 0, Remote.GOLD_DURABILITY, 1, 1, 0);
		DIAMOND_CARVER = EnumHelper.addToolMaterial("DIAMOND_CARVER", 0, Remote.DIAMOND_DURABILITY, 1, 6, 0);
		
		MUD_CARVER = EnumHelper.addToolMaterial("MUD_CARVER", 0, Remote.MUD_DURABILITY, 1, 1, 0);
		AMETHYST_CARVER = EnumHelper.addToolMaterial("AMETHYST_CARVER", 0, Remote.AMETHYST_DURABILITY, 1, 7, 0);
		THAUMIUM_CARVER = EnumHelper.addToolMaterial("THAUMIUM_CARVER", 0, Remote.THAUMIUM_DURABILITY, 1, 6, 0);
		
	}

}
