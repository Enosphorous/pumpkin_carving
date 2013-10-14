package enosphorous.pumpkins.handlers;

import enosphorous.pumpkins.common.Remote;
import enosphorous.pumpkins.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class LootHandler {
	
	public static void dewheedlize(){
		
		/**
		 * Essential loot handling.
		 */
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Items.iron_carver), 1, 1, Remote.IRON_LOOT_RARITY));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Items.iron_carver), 1, 1, Remote.IRON_LOOT_RARITY));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(Items.iron_carver), 1, 1, Remote.IRON_LOOT_RARITY));
		
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Items.wood_carver), 1, 1, Remote.WOOD_LOOT_RARITY));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Items.wood_carver), 1, 1, Remote.WOOD_LOOT_RARITY));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(Items.wood_carver), 1, 1, Remote.WOOD_LOOT_RARITY));
		
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Items.stone_carver), 1, 1, Remote.STONE_LOOT_RARITY));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Items.stone_carver), 1, 1, Remote.STONE_LOOT_RARITY));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(Items.stone_carver), 1, 1, Remote.STONE_LOOT_RARITY));
		
		/**
		 * Puts things in the bonus chest.
		 * Only wood and stone.
		 */
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Items.stone_carver), 1, 1, Remote.STONE_BONUS_RARITY));
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Items.wood_carver), 1, 1, Remote.WOOD_BONUS_RARITY));
		
	}

}
