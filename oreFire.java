package f01405.TestMod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class oreFire extends Block {

	public oreFire(int id, Material material) {
		super(id, material);
	}
	
	public int idDropped(int par1, Random par2random, int par3) {
		return testMod.fireRock.itemID;
	}

}
