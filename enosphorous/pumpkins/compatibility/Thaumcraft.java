package enosphorous.pumpkins.compatibility;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import enosphorous.pumpkins.common.ConfigLoader;
import enosphorous.pumpkins.item.ItemCarvingKnife;
import enosphorous.pumpkins.item.ToolMaterial;

public class Thaumcraft {
	
	/**
	 * This class will create all compatibility items, recipes, and integral forces for
	 * playing with both this mod and Biomes o' Plenty.
	 * 
	 * Feature List
	 * 
	 * - Thaumium Carver
	 */
	public static Item thaumiumCarver;
	
	/**
	 * Getting all applicable items for crafting and other uses in this mod. Essentially
	 * making an API for Thaumcraft, for me to use.
	 */
	
	public static void getCompatiblity(){
	
	if (GameRegistry.findItem("Thaumcraft", "ItemResource") == null){
		System.out.println("[CARVING] Thaumcraft not detected. Not running compatibility.");
	}
	else{
		/**
		 * Getting the items from Thaumcraft using items and itemstacks.
		 */
		Item thaumium = Allocator.getThaumium();
		ItemStack thaumium_stack = new ItemStack(thaumium, 1, 2);

		thaumiumCarver = new ItemCarvingKnife(ConfigLoader.thaumium_carverID, ToolMaterial.THAUMIUM_CARVER).setTextureName("pumpkins:thaumium_carver").setUnlocalizedName("carver");
		
		GameRegistry.addShapedRecipe(new ItemStack(thaumiumCarver, 1, 0), new Object[]{"## ", " # ", "@  ", '@', Item.stick, '#', thaumium});
		
	}
	
}	

}