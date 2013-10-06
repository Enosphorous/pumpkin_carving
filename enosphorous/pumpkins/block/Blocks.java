package enosphorous.pumpkins.block;

import cpw.mods.fml.common.registry.GameRegistry;
import enosphorous.pumpkins.common.ConfigLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.material.Material;

public class Blocks {
	
	public static Block natural_pumpkin;
	public static Block carved_melon;
	public static Block melon_o_lantern;
	
	public static void init(){
		
		carved_melon = (new BlockCarvedMelon(ConfigLoader.carved_melonID, false)).setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("melon").setTextureName("pumpkins:melon");
		natural_pumpkin = (new BlockNaturalPumpkin(ConfigLoader.natural_pumpkinID, false)).setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("pumpkin").setTextureName("pumpkins:pumpkin");
		melon_o_lantern = (new BlockLitMelon(ConfigLoader.lit_melonID, true)).setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("melon").setTextureName("pumpkins:melon").setLightValue(1.0F);
		
	}
	
	public static void register(){
		
		GameRegistry.registerBlock(carved_melon);
		GameRegistry.registerBlock(natural_pumpkin);
		GameRegistry.registerBlock(melon_o_lantern);
		
	}

}
