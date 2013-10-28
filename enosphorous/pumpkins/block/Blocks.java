package enosphorous.pumpkins.block;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import enosphorous.pumpkins.common.ConfigLoader;
import enosphorous.pumpkins.itemblock.ItemBlockMelon;
import enosphorous.pumpkins.tile.TileEntityMelon;

public class Blocks {

	public static Block melon;
	public static Block melonLit;
	
	public static void init(){
		melon = new BlockMelon(ConfigLoader.melonID).setHardness(1f).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("melon");
		melonLit = new BlockMelon(ConfigLoader.melonID).setHardness(1f).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("melonLit").setLightValue(1F);
	}
	
	public static void register(){
		GameRegistry.registerBlock(melon, ItemBlockMelon.class, "PumpkinCarverMelon");
		GameRegistry.registerBlock(melonLit, ItemBlockMelon.class, "PumpkinCarverMelonLit");
		GameRegistry.registerTileEntity(TileEntityMelon.class, "PumpkinCarverMelonTile");
	}
}
