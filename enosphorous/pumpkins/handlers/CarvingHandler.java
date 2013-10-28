package enosphorous.pumpkins.handlers;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import enosphorous.pumpkins.block.Blocks;
import enosphorous.pumpkins.common.Remote;
import enosphorous.pumpkins.item.ItemCarvingKnife;
import enosphorous.pumpkins.item.Items;

public class CarvingHandler {

	@ForgeSubscribe
	public void onPlayerInteract(PlayerInteractEvent event){
		if(event.entityPlayer.worldObj.getBlockId(event.x, event.y, event.z) == Block.pumpkin.blockID && event.entityPlayer.inventory.getCurrentItem() !=null && event.entityPlayer.inventory.getCurrentItem().itemID == Block.torchWood.blockID){

			int playerFacing = MathHelper.floor_double((double)((event.entityPlayer.rotationYaw * 4F) / 360f) + 0.5D) &3;

			event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, Block.pumpkinLantern.blockID, (2 + playerFacing) % 4, 0);
			event.setCanceled(true);
			
			if (event.entityPlayer.capabilities.isCreativeMode == false){
				event.entityPlayer.inventory.consumeInventoryItem(Block.torchWood.blockID);
			}
			
		}
		
	}
	
}
