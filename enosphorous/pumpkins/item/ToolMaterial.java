package enosphorous.pumpkins.item;

import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;

public class ToolMaterial {
	
	public static EnumToolMaterial WOOD_CARVER;
	public static EnumToolMaterial STONE_CARVER;
	public static EnumToolMaterial IRON_CARVER;
	public static EnumToolMaterial GOLD_CARVER;
	public static EnumToolMaterial DIAMOND_CARVER;
	
	public static void init(){
		
		WOOD_CARVER = EnumHelper.addToolMaterial("WOOD_CARVER", 0, 24, 1, 1, 0);
		STONE_CARVER = EnumHelper.addToolMaterial("STONE_CARVER", 0, 50, 1, 3, 0);
		IRON_CARVER = EnumHelper.addToolMaterial("IRON_CARVER", 0, 115, 1, 4, 0);
		GOLD_CARVER = EnumHelper.addToolMaterial("GOLD_CARVER", 0, 18, 1, 1, 0);
		DIAMOND_CARVER = EnumHelper.addToolMaterial("IRON_CARVER", 0, 240, 1, 6, 0);
		
	}

}
