package enosphorous.pumpkins.common;


import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;



public class ConfigLoader {
	public static int     wood_carverID                      = 12945;
	public static int     stone_carverID                     = 12946;
	public static int     iron_carverID                      = 12947;
	public static int     gold_carverID                      = 12948;
	public static int     diamond_carverID                   = 12949;
	
	public static int     pumpkinMush						 = 12950;
	public static int     melonSeeds						 = 12951;
	public static int     pumpkinSeeds						 = 12952;
	
	public static int     melonID                    		 = 2951;
	public static int     melonLitID                    	 = 2952;
	
								
	
	/**
	 * Compatiblity.
	 */

	
	public static boolean loot                               = true;

    static final String   IDs                                = "ID CONFIGURATION";
    static final String   LOOTS                              = "GLOBAL CONFIGURATION";

    public static void load(Configuration config) {

        try {
            config.load();

            ConfigLoader.melonID = config.get(ConfigLoader.IDs, "melon id", melonID).getInt(melonID);
            ConfigLoader.melonLitID = config.get(ConfigLoader.IDs, "lit melon id", melonLitID).getInt(melonLitID);
            
            ConfigLoader.wood_carverID = config.get(ConfigLoader.IDs, "wood carver id", 12945).getInt(12945);
            ConfigLoader.stone_carverID = config.get(ConfigLoader.IDs, "stone carver id", 12946).getInt(12946);
            ConfigLoader.iron_carverID = config.get(ConfigLoader.IDs, "iron carver id", 12947).getInt(12947);
            ConfigLoader.gold_carverID = config.get(ConfigLoader.IDs, "gold carver id", 12948).getInt(12948);
            ConfigLoader.diamond_carverID = config.get(ConfigLoader.IDs, "diamond carver id", 12949).getInt(12949);
            
            ConfigLoader.pumpkinMush = config.get(ConfigLoader.IDs, "pumpkin mush id", pumpkinMush).getInt(pumpkinMush);
            ConfigLoader.melonSeeds = config.get(ConfigLoader.IDs, "melon seeds id", melonSeeds).getInt(melonSeeds);
            ConfigLoader.pumpkinSeeds = config.get(ConfigLoader.IDs, "pumpkin seeds id", pumpkinSeeds).getInt(pumpkinSeeds);
            
            ConfigLoader.loot = config.get(ConfigLoader.LOOTS, "dungeon loot enabled", true).getBoolean(true);
            
            System.out.println("[PUMPKIN CARVING] Configuration file loaded.");
            
        } catch (Exception e) {
            FMLLog.log(Level.SEVERE, "Error loading the configuration of [PUMPKIN REALISM]. Error message: " + e.getMessage() + " / " + e.toString());
        } finally {
            config.save();
        }
        
    }

}