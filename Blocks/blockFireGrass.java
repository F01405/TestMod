package f01405.TestMod.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class blockFireGrass extends Block {

	public blockFireGrass(int par1, Material par2Material) {
		super(par1, par2Material);
	}
	
	public Icon field_94393_a; //Top of our Block
	public Icon field_94392_b; //Bottom of our Block
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1RegisterIcon) {
		this.blockIcon = par1RegisterIcon.registerIcon("testmod:fireGrass_Side");
		field_94393_a = par1RegisterIcon.registerIcon("testmod:fireGrass_Top");
		field_94392_b = par1RegisterIcon.registerIcon("testmod:fireGrass_Bottom");
	}
	
	public Icon getIcon(int par1, int par2) {
		return par1 == 0 ? this.field_94392_b : (par1 == 1 ? this.field_94393_a: this.blockIcon);
	}

}
