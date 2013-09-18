package f01405.TestMod.Dimensions;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.Teleporter;

public class StrawberryPortalPosition extends ChunkCoordinates
{
    /** The worldtime at which this PortalPosition was last verified */
    public long lastUpdateTime;

    /** The teleporter to which this PortalPosition applies */
    final StrawberryDimensionTeleporter teleporterInstance;

    public StrawberryPortalPosition(StrawberryDimensionTeleporter StrawberryDimensionTeleporter, int par2, int par3, int par4, long par5)
    {
        super(par2, par3, par4);
        this.teleporterInstance = StrawberryDimensionTeleporter;
        this.lastUpdateTime = par5;
    }
}

