package enosphorous.pumpkins.common;


import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;



public class ConfigLoader {
    
	public static int     natural_pumpkinID                  = 2943;
	public static int     carved_melonID                     = 2944;
	public static int     lit_melonID                        = 2950;
	
	public static int     wood_carverID                      = 12945;
	public static int     stone_carverID                     = 12946;
	public static int     iron_carverID                      = 12947;
	public static int     gold_carverID                      = 12948;
	public static int     diamond_carverID                   = 12949;
	
	/**
	 * Compatiblity.
	 */
	
	public static int     mud_carverID                       = 12950;
	public static int     amethyst_carverID                  = 12951;
	
	public static int     thaumium_carverID                  = 12952;
	
	public static boolean loot                               = true;

    static final String   IDs                                = "ID CONFIGURATION";
    static final String   LOOTS                              = "GLOBAL CONFIGURATION";

    public static void load(Configuration config) {

        try {
            config.load();

            ConfigLoader.natural_pumpkinID = config.get(ConfigLoader.IDs, "natural pumpkin id", 2943).getInt(2943);
            ConfigLoader.carved_melonID = config.get(ConfigLoader.IDs, "carved melon id", 2944).getInt(2944);
            ConfigLoader.lit_melonID = config.get(ConfigLoader.IDs, "melon o' lantern id", 2950).getInt(2950);
            
            ConfigLoader.wood_carverID = config.get(ConfigLoader.IDs, "wood carver id", 12945).getInt(12945);
            ConfigLoader.stone_carverID = config.get(ConfigLoader.IDs, "stone carver id", 12946).getInt(12946);
            ConfigLoader.iron_carverID = config.get(ConfigLoader.IDs, "iron carver id", 12947).getInt(12947);
            ConfigLoader.gold_carverID = config.get(ConfigLoader.IDs, "gold carver id", 12948).getInt(12948);
            ConfigLoader.diamond_carverID = config.get(ConfigLoader.IDs, "diamond carver id", 12949).getInt(12949);
            
            
            ConfigLoader.mud_carverID = config.get(ConfigLoader.IDs, "mud carver id", 12950).getInt(12950);
            ConfigLoader.amethyst_carverID = config.get(ConfigLoader.IDs, "amethyst carver id", 12951).getInt(12951);
            ConfigLoader.thaumium_carverID = config.get(ConfigLoader.IDs, "thaumium carver id", 12952).getInt(12952);
            
            ConfigLoader.loot = config.get(ConfigLoader.LOOTS, "dungeon loot enabled", true).getBoolean(true);
            
            System.out.println("[PUMPKIN CARVING] Configuration file loaded.");
            
        } catch (Exception e) {
            FMLLog.log(Level.SEVERE, "Error loading the configuration of [PUMPKIN REALISM]. Error message: " + e.getMessage() + " / " + e.toString());
        } finally {
            config.save();
        }
        
    }

}