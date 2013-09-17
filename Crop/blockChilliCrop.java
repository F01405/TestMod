package f01405.TestMod.Crop;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import f01405.TestMod.testMod;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class blockChilliCrop extends BlockCrops {
	
	@SideOnly(Side.CLIENT) 
		private Icon [] iconArray;
	

	public blockChilliCrop(int par1) {
		super(par1);
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		if (par2 < 7) {
			if (par2 == 6) {
				par2 = 5;
			}
			return this.iconArray[par2 >> 1];
		} else {
			return this.iconArray[3];
		}
	}
	
	//Seed that is dropped by harvesting the crop
	protected int getSeedItem() {
		return testMod.chilliSeeds.itemID;
	}
	
	//Food that is dropped by Harvesting the crop
	protected int getCropItem() {
		return testMod.chilli.itemID;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.iconArray = new Icon[4];
		
		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon("testmod:chilliBlock_" + (i + i));
		}
	}

}
