package enosphorous.pumpkins.compatibility;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import enosphorous.pumpkins.common.ConfigLoader;
import enosphorous.pumpkins.item.ItemCarvingKnife;
import enosphorous.pumpkins.item.ToolMaterial;

public class BOP {
	
	/**
	 * This class will create all compatibility items, recipes, and integral forces for
	 * playing with both this mod and Biomes o' Plenty.
	 * 
	 * Feature List
	 * 
	 * - Muddy Carver
	 * - Amethyst Carver
	 */
	public static Item mudCarver;
	public static Item amethystCarver;
	
	/**
	 * Getting all applicable items for crafting and other uses in this mod. Essentially
	 * making an API for Biomes o' Plenty, for me to use.
	 * 
	 * *An easy-to-use API, considering I couldn't figure out the real one.
	 */
	
	
	
	public static void getCompatiblity(){
	
	if (GameRegistry.findItem("BiomesOPlenty", "mudSword") == null){
		System.out.println("[CARVING] Biomes o' Plenty not detected. Not running compatibility.");
	}
	else{
		/**
		 * Getting the items from Biomes o' Plenty using items and itemstacks.
		 */
		Item mudball = Allocator.getMudball();
		Item amethyst = Allocator.getAmythest();
		ItemStack amethyst_stack = new ItemStack(amethyst, 1, 2);
		
		mudCarver = new ItemCarvingKnife(ConfigLoader.mud_carverID, ToolMaterial.MUD_CARVER).setTextureName("pumpkins:mud_carver").setUnlocalizedName("carver");
		amethystCarver = new ItemCarvingKnife(ConfigLoader.amethyst_carverID, ToolMaterial.AMETHYST_CARVER).setTextureName("pumpkins:amethyst_carver").setUnlocalizedName("carver");
		
		GameRegistry.addShapedRecipe(new ItemStack(mudCarver, 1, 0), new Object[]{"## ", " # ", "@  ", '@', Item.stick, '#', mudball});
		GameRegistry.addShapedRecipe(new ItemStack(amethystCarver, 1, 0), new Object[]{"## ", " # ", "@  ", '@', Item.stick, '#', amethyst});
		
	}
	
}	

}
