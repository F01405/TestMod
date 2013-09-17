package f01405.TestMod.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class blockFireTest extends Block {

	public blockFireTest(int par1) {
		super(par1, Material.rock);
	}
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
    }
	
	public boolean isOpaqueCube()
    {
        return true;
    }
	
	 public boolean renderAsNormalBlock()
	    {
	        return false;
	    }

	public Icon field_94393_a; //Top of our Block
	public Icon field_94392_b; //Bottom of our Block
	public Icon field_94475_c; //Face of our Block
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1RegisterIcon) {
		field_94393_a = par1RegisterIcon.registerIcon("testmod:phoneBooth_top");
		field_94392_b = par1RegisterIcon.registerIcon("testmod:phoneBooth_bottom");
		field_94475_c = par1RegisterIcon.registerIcon("testmod:phoneBooth_frontTop");
		this.blockIcon = par1RegisterIcon.registerIcon("testmod:phoneBooth_side");
	}
	

}
