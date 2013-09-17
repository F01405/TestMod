package f01405.TestMod;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import f01405.TestMod.World.fireWorldGenTrees;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class WorldGeneratorTestMod implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkx, int chunkz, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.dimensionId){
			
		case 0 : generateSurface(world, random, chunkx*16, chunkz*16);
		
	}
	}
	private void generateSurface(World world, Random random, int Blockx, int Blockz) {
		
		for(int i = 0; i<5; i++) {
			
			int xcoord = Blockx + random.nextInt(16);
			int zcoord = Blockz + random.nextInt(16);
			int ycoord = random.nextInt(30);
			
			(new WorldGenMinable (testMod.oreFire.blockID, 6)).generate(world, random, xcoord, ycoord, zcoord);
			
		}
		
		for (int t = 0; t < 30; t++) {
			int xcoord1 = Blockx + random.nextInt(16);
			int zcoord1 = Blockz + random.nextInt(16);
			int ycoord1 = random.nextInt(90);
		
		(new fireWorldGenTrees(false, 22, 0, 0, true)).generate(world, random, xcoord1, ycoord1, zcoord1);
		}
	}
	
}