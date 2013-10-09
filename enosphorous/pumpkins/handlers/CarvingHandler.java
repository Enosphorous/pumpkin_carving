package enosphorous.pumpkins.handlers;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import enosphorous.pumpkins.block.Blocks;
import enosphorous.pumpkins.item.Items;

public class CarvingHandler {

	@ForgeSubscribe
	public void onPlayerInteract(PlayerInteractEvent event){
		
		if(event.entityPlayer.worldObj.getBlockId(event.x, event.y, event.z) == Blocks.natural_pumpkin.blockID && event.entityPlayer.inventory.getCurrentItem() !=null && event.entityPlayer.inventory.getCurrentItem().itemID == Items.wood_carver.itemID ||
				event.entityPlayer.worldObj.getBlockId(event.x, event.y, event.z) == Blocks.natural_pumpkin.blockID && event.entityPlayer.inventory.getCurrentItem() !=null && event.entityPlayer.inventory.getCurrentItem().itemID == Items.stone_carver.itemID ||
				event.entityPlayer.worldObj.getBlockId(event.x, event.y, event.z) == Blocks.natural_pumpkin.blockID && event.entityPlayer.inventory.getCurrentItem() !=null && event.entityPlayer.inventory.getCurrentItem().itemID == Items.iron_carver.itemID ||
				event.entityPlayer.worldObj.getBlockId(event.x, event.y, event.z) == Blocks.natural_pumpkin.blockID && event.entityPlayer.inventory.getCurrentItem() !=null && event.entityPlayer.inventory.getCurrentItem().itemID == Items.gold_carver.itemID ||
				event.entityPlayer.worldObj.getBlockId(event.x, event.y, event.z) == Blocks.natural_pumpkin.blockID && event.entityPlayer.inventory.getCurrentItem() !=null && event.entityPlayer.inventory.getCurrentItem().itemID == Items.diamond_carver.itemID){

			
			event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, Blocks.pumpkin_dropper.blockID);
			event.entityPlayer.worldObj.destroyBlock(event.x, event.y, event.z, true);
			
			event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, Block.pumpkin.blockID);
			event.entityPlayer.inventory.getCurrentItem().damageItem(1, event.entityPlayer);
			event.entityPlayer.worldObj.playSoundAtEntity(event.entityPlayer, "random.wood_click", 1F, 1F);
			
		}
		
		if(event.entityPlayer.worldObj.getBlockId(event.x, event.y, event.z) == Block.melon.blockID && event.entityPlayer.inventory.getCurrentItem() !=null && event.entityPlayer.inventory.getCurrentItem().itemID == Items.wood_carver.itemID ||
				event.entityPlayer.worldObj.getBlockId(event.x, event.y, event.z) == Block.melon.blockID && event.entityPlayer.inventory.getCurrentItem() !=null && event.entityPlayer.inventory.getCurrentItem().itemID == Items.stone_carver.itemID ||
				event.entityPlayer.worldObj.getBlockId(event.x, event.y, event.z) == Block.melon.blockID && event.entityPlayer.inventory.getCurrentItem() !=null && event.entityPlayer.inventory.getCurrentItem().itemID == Items.iron_carver.itemID ||
				event.entityPlayer.worldObj.getBlockId(event.x, event.y, event.z) == Block.melon.blockID && event.entityPlayer.inventory.getCurrentItem() !=null && event.entityPlayer.inventory.getCurrentItem().itemID == Items.gold_carver.itemID ||
				event.entityPlayer.worldObj.getBlockId(event.x, event.y, event.z) == Block.melon.blockID && event.entityPlayer.inventory.getCurrentItem() !=null && event.entityPlayer.inventory.getCurrentItem().itemID == Items.diamond_carver.itemID){

					event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, Blocks.melon_dropper.blockID);
					event.entityPlayer.worldObj.destroyBlock(event.x, event.y, event.z, true);

					event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, Blocks.carved_melon.blockID);
					event.entityPlayer.inventory.getCurrentItem().damageItem(1, event.entityPlayer);
					event.entityPlayer.worldObj.playSoundAtEntity(event.entityPlayer, "random.wood_click", 1F, 1F);
					
					
				}
		
	}
	
}
