package f01405.TestMod.Food;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class chilliItem extends ItemFood {


	public chilliItem(int id, int hunger, float saturation, boolean wolffood) {
		super(id, hunger, saturation, wolffood);
	}
	

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		
		this.itemIcon = par1IconRegister.registerIcon("testmod:chilli");
		
	}

}
