package enosphorous.pumpkins.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenPlains;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class Generator implements IWorldGenerator
{
       public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
       {
             switch(world.provider.dimensionId)
             {
                    case -1: generateNether(world, random, chunkX * 16, chunkZ * 16);
                    case 0: generateSurface(world, random, chunkX * 16, chunkZ * 16);
                    case 1: generateEnd(world, random, chunkX * 16, chunkZ * 16);
             }
       }
      
       private void generateEnd(World world, Random random, int x, int z)
       {
            
       }

       private void generateSurface(World world, Random random, int x, int z)
       {
    	   
    	   BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x, z);
    	   //WorldGenBalsamFirLargeTree tree = new WorldGenBalsamFirLargeTree();
    	  
    	   if((biome instanceof BiomeGenPlains))// then add ||BiomeGenXYZ if you want more.
    	   {
    	    if (random.nextInt(1000) == 0)
    	    {
    	    	if (world.getWorldInfo().getTerrainType() == WorldType.DEFAULT ||
    	    		world.getWorldInfo().getTerrainType() == WorldType.DEFAULT_1_1 ||
    	    		world.getWorldInfo().getTerrainType() == WorldType.LARGE_BIOMES){
    	                  int i = x + random.nextInt(16) + 8;
    	                  int k = z + random.nextInt(16) + 8;
    	                  int j = world.getHeightValue(i, k);
    	                  new WorldGenPumpkin().generate(world, random, i, j, k);
    	    	}
    	    }
    	   }

            
       }

       private void generateNether(World world, Random random, int x, int z)
       {
            
       }

}
