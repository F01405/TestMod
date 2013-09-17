package f01405.TestMod.Tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class hardFirePickaxeItem extends ItemPickaxe {

	public hardFirePickaxeItem(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register) {
		this.itemIcon = register.registerIcon("testmod:hardFirePickaxe");

    }
}
