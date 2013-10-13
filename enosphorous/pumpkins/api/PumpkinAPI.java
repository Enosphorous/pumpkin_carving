package enosphorous.pumpkins.api;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class PumpkinAPI {
	
	public static Item getWoodCarver()
	{
		return GameRegistry.findItem("carving", "wood_carver");
	}
	
	public static Item getStoneCarver()
	{
		return GameRegistry.findItem("carving", "stone_carver");
	}
	
	public static Item getIronCarver()
	{
		return GameRegistry.findItem("carving", "iron_carver");
	}
	
	public static Item getGoldCarver()
	{
		return GameRegistry.findItem("carving", "gold_carver");
	}
	
	public static Item getDiamondCarver()
	{
		return GameRegistry.findItem("carving", "diamond_carver");
	}
	
	public static Block getNaturalPumpkin()
	{
		return GameRegistry.findBlock("carving", "natural_pumpkin");
	}
	
	public static Block getCarvedMelon()
	{
		return GameRegistry.findBlock("carving", "carved_melon");
	}
	
	public static Block getMelonOLantern()
	{
		return GameRegistry.findBlock("carving", "melon_o_lantern");
	}

}
