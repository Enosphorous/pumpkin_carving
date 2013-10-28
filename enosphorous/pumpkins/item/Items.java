package enosphorous.pumpkins.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import enosphorous.pumpkins.block.Blocks;
import enosphorous.pumpkins.common.ConfigLoader;

public class Items {
	
	public static Item wood_carver;
	public static Item stone_carver;
	public static Item iron_carver;
	public static Item gold_carver;
	public static Item diamond_carver;
	
	public static Item pumpkinMush;
	public static Item melonSeeds;
	public static Item pumpkinSeeds;
	
	public static void init(){
		
		wood_carver = new ItemCarvingKnife(ConfigLoader.wood_carverID, ToolMaterial.WOOD_CARVER).setUnlocalizedName("carver").setTextureName("pumpkins:wood_carver").setCreativeTab(CreativeTabs.tabTools);
		stone_carver = new ItemCarvingKnife(ConfigLoader.stone_carverID, ToolMaterial.STONE_CARVER).setUnlocalizedName("carver").setTextureName("pumpkins:stone_carver").setCreativeTab(CreativeTabs.tabTools);
		iron_carver = new ItemCarvingKnife(ConfigLoader.iron_carverID, ToolMaterial.IRON_CARVER).setUnlocalizedName("carver").setTextureName("pumpkins:iron_carver").setCreativeTab(CreativeTabs.tabTools);
		gold_carver = new ItemCarvingKnife(ConfigLoader.gold_carverID, ToolMaterial.GOLD_CARVER).setUnlocalizedName("carver").setTextureName("pumpkins:gold_carver").setCreativeTab(CreativeTabs.tabTools);
		diamond_carver = new ItemCarvingKnife(ConfigLoader.diamond_carverID, ToolMaterial.DIAMOND_CARVER).setUnlocalizedName("carver").setTextureName("pumpkins:diamond_carver").setCreativeTab(CreativeTabs.tabTools);
		
		pumpkinMush = new ItemGeneric(ConfigLoader.pumpkinMush, "pumpkinMush", "Pumpkin Mush");
		melonSeeds = new ItemSeeds(ConfigLoader.melonSeeds, "melonSeeds", "Melon Seeds", new ItemStack(Blocks.melon, 0, 0));
		pumpkinSeeds = new ItemSeeds(ConfigLoader.pumpkinSeeds, "pumpkinSeeds", "Pumpkin Seeds", new ItemStack(Blocks.melon, 0, 1));
		
	}

}
