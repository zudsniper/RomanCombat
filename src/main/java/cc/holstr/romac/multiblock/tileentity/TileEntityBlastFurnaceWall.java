package cc.holstr.romac.multiblock.tileentity;

import cc.holstr.beefCore.multiblock.MultiblockValidationException;
import cc.holstr.beefCore.multiblock.rectangular.RectangularMultiblockTileEntityBase;
import net.minecraft.util.math.BlockPos;

public class TileEntityBlastFurnaceWall extends RectangularMultiblockTileEntityBase {

    @Override
    public void isGoodForFrame() throws MultiblockValidationException {

    }

    @Override
    public void isGoodForSides() throws MultiblockValidationException {

    }

    @Override
    public void isGoodForTop() throws MultiblockValidationException {

    }

    @Override
    public void isGoodForBottom() throws MultiblockValidationException {

    }

    @Override
    public void isGoodForInterior() throws MultiblockValidationException {
        BlockPos pos = getPos();
        throw new MultiblockValidationException(String.format("%d, %d, %d - no blocks but lava should be placed inside the blast furnace.",pos.getX(), pos.getY(), pos.getZ()));
    }
}
