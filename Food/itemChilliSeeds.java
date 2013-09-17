package f01405.TestMod.Food;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemSeeds;

public class itemChilliSeeds extends ItemSeeds {

	public itemChilliSeeds(int par1, int par2, int par3) {
		super(par1, par2, par3);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("testmod:chilliSeeds");
	}
	

}
