package f01405.TestMod;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;
import f01405.TestMod.Blocks.blockFireSapling;
import net.minecraft.block.BlockSapling;

public class Fire_Bonemeal_Event {
	
	@ForgeSubscribe
	public void usedBonemeal(BonemealEvent event)
	{
		if (event.ID == testMod.fireSapling.blockID) {
			if (!event.world.isRemote) {
				((blockFireSapling)testMod.fireSapling).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
			}
		}
	}

}
