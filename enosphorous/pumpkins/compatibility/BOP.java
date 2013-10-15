package enosphorous.pumpkins.compatibility;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import enosphorous.pumpkins.common.ConfigLoader;
import enosphorous.pumpkins.item.ItemCarvingKnife;
import enosphorous.pumpkins.item.Items;
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
	
	public static void getCompatiblity(){
	
	if (GameRegistry.findItem("BiomesOPlenty", "mudSword") == null){
		System.out.println("[CARVING] Biomes o' Plenty not detected. Not running compatibility.");
	}
	else{
		mudCarver = new ItemCarvingKnife(ConfigLoader.mud_carverID, ToolMaterial.MUD_CARVER);
		amethystCarver = new ItemCarvingKnife(ConfigLoader.amethyst_carverID, ToolMaterial.AMETHYST_CARVER);
	}
	
}	

}
