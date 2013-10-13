package enosphorous.pumpkins.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import enosphorous.pumpkins.block.Blocks;
import enosphorous.pumpkins.item.Items;

public class RecipeHandler {
	
	public static void init(){
		
		/**Crafting a Melon o' Lantern*/
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.melon_o_lantern, 1, 0), new Object[]{Block.torchWood, Blocks.carved_melon});
		
		/**Crafting Pumpkin Carvers*/
		GameRegistry.addShapedRecipe(new ItemStack(Items.wood_carver, 1, 0), new Object[]{"## ", " # ", "@  ", '@', Item.stick, '#', Block.planks});
		GameRegistry.addShapedRecipe(new ItemStack(Items.stone_carver, 1, 0), new Object[]{"## ", " # ", "@  ", '@', Item.stick, '#', Block.cobblestone});
		GameRegistry.addShapedRecipe(new ItemStack(Items.iron_carver, 1, 0), new Object[]{"## ", " # ", "@  ", '@', Item.stick, '#', Item.ingotIron});
		GameRegistry.addShapedRecipe(new ItemStack(Items.gold_carver, 1, 0), new Object[]{"## ", " # ", "@  ", '@', Item.stick, '#', Item.ingotGold});
		GameRegistry.addShapedRecipe(new ItemStack(Items.diamond_carver, 1, 0), new Object[]{"## ", " # ", "@  ", '@', Item.stick, '#', Item.diamond});
		
	}

}
