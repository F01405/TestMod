package f01405.TestMod.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import f01405.TestMod.testMod;

public class ItemiPod extends Item {

	public ItemiPod(int par1) {
		super(par1);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("testmod:iPod");
	}
	
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		player.getFoodStats().setFoodLevel(20);
		player.setFire(5);
		return new ItemStack (testMod.chilliSeeds);
	}

}
