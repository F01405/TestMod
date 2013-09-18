package f01405.TestMod.Dimensions;

import f01405.TestMod.testMod;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderStrawberryDimension extends WorldProvider {

	public void registerWorldChunkManager() {
		
		this.worldChunkMgr = new WorldChunkManagerHell(testMod.fireBiome, 0.8F, 0.1F);
		this.dimensionId = testMod.strawberryDimensionId;
	}
	
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderStrawberryDimension(worldObj, worldObj.getSeed(), false);
	}
	
	@Override
	public String getDimensionName() {
		return "Strawberry";
	}

}
