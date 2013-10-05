package enosphorous.pumpkins.common;


import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;



public class ConfigLoader {
    
	public static int     natural_pumpkinID                  = 2943;
	public static int     carved_melonID                     = 2944;
	
	public static int     wood_carverID                      = 2945;
	public static int     stone_carverID                     = 2946;
	public static int     iron_carverID                      = 2947;
	public static int     gold_carverID                      = 2948;
	public static int     diamond_carverID                   = 2949;

    static final String   IDs                                = "ID CONFIGURATION";

    public static void load(Configuration config) {

        try {
            config.load();

            ConfigLoader.natural_pumpkinID = config.get(ConfigLoader.IDs, "natural pumpkin id", 2943).getInt(2943);
            ConfigLoader.carved_melonID = config.get(ConfigLoader.IDs, "carved melon id", 2944).getInt(2944);
            
            ConfigLoader.wood_carverID = config.get(ConfigLoader.IDs, "wood carver id", 2945).getInt(2945);
            ConfigLoader.stone_carverID = config.get(ConfigLoader.IDs, "stone carver id", 2946).getInt(2946);
            ConfigLoader.iron_carverID = config.get(ConfigLoader.IDs, "iron carver id", 2947).getInt(2947);
            ConfigLoader.gold_carverID = config.get(ConfigLoader.IDs, "gold carver id", 2948).getInt(2948);
            ConfigLoader.diamond_carverID = config.get(ConfigLoader.IDs, "diamond carver id", 2949).getInt(2949);
            
            System.out.println("[KILLER MINECARTS] Configuration file loaded.");
            
        } catch (Exception e) {
            FMLLog.log(Level.SEVERE, "Error loading the configuration of [PUMPKIN REALISM]. Error message: " + e.getMessage() + " / " + e.toString());
        } finally {
            config.save();
        }
        
    }

}