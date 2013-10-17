package enosphorous.pumpkins.compatibility;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class Allocator {
	
	/**
	 * Items for Biomes o' Plenty.
	 */
	
	public static Item getMudball()
	{
		return GameRegistry.findItem("BiomesOPlenty", "mudBall");
	}
	
	public static Item getAmythest()
	{
		return GameRegistry.findItem("BiomesOPlenty", "miscItems");
	}
	
	/**
	 * Items for Thaumcraft 4.
	 */
	
	public static Item getThaumium()
	{
		return GameRegistry.findItem("Thaumcraft", "ItemResource");
	}

}
