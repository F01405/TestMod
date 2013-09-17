package f01405.TestMod.Biomes;

import f01405.TestMod.testMod;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class biomeFireBiome extends BiomeGenBase {

	public biomeFireBiome(int par1) {
		super(par1);
		this.topBlock = (byte)Block.cake.blockID;
	    this.fillerBlock = (byte)Block.blockDiamond.blockID;
	}

}
