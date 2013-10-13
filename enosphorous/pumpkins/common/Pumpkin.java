package enosphorous.pumpkins.common;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import enosphorous.pumpkins.local.LocalizationHandler;
import enosphorous.pumpkins.block.Blocks;
import enosphorous.pumpkins.client.ClientProxy;
import enosphorous.pumpkins.handlers.CarvingHandler;
import enosphorous.pumpkins.handlers.LootHandler;
import enosphorous.pumpkins.handlers.RecipeHandler;
import enosphorous.pumpkins.item.Items;
import enosphorous.pumpkins.item.ToolMaterial;
import enosphorous.pumpkins.world.Generator;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.MOD_VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Pumpkin {

	@Instance(Reference.MOD_INSTANCE)
	public static Pumpkin instance;
	
    @SidedProxy(clientSide = Reference.CLIENT_PATH, serverSide = Reference.SERVER_PATH)
    public static CommonProxy proxy;
    public static ClientProxy client;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {

        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        ConfigLoader.load(config);
        
        ToolMaterial.init();
        
        Blocks.init();
        Blocks.register();
        
        Items.init();
        
        RecipeHandler.init();
        
        LocalizationHandler.init();
        
        if (ConfigLoader.loot){
        LootHandler.dewheedlize();
        }
        
        MinecraftForge.EVENT_BUS.register(new CarvingHandler());
        GameRegistry.registerWorldGenerator(new Generator());

	}

}