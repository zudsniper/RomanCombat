package cc.holstr.romac.multiblock;

import cc.holstr.beefCore.multiblock.IMultiblockPart;
import cc.holstr.beefCore.multiblock.MultiblockControllerBase;
import cc.holstr.beefCore.multiblock.rectangular.RectangularMultiblockControllerBase;
import cc.holstr.romac.Reference;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class StructureBlastFurnace extends RectangularMultiblockControllerBase {

    protected StructureBlastFurnace(World world) {
        super(world);
    }

    @Override
    public void onAttachedPartWithMultiblockData(IMultiblockPart part, NBTTagCompound data) {

    }

    @Override
    protected void onBlockAdded(IMultiblockPart newPart) {

    }

    @Override
    protected void onBlockRemoved(IMultiblockPart oldPart) {

    }

    @Override
    protected void onMachineAssembled() {

    }

    @Override
    protected void onMachineRestored() {

    }

    @Override
    protected void onMachinePaused() {

    }

    @Override
    protected void onMachineDisassembled() {

    }

    @Override
    protected int getMinimumNumberOfBlocksForAssembledMachine() {
        return Reference.blastFurnaceMinNumberBlocks;
    }

    @Override
    protected int getMaximumXSize() {
        return Reference.blastFurnaceMaxX;
    }

    @Override
    protected int getMaximumZSize() {
        return Reference.blastFurnaceMaxZ;
    }

    @Override
    protected int getMaximumYSize() {
        return Reference.blastFurnaceMaxY;
    }

    @Override
    protected void onAssimilate(MultiblockControllerBase assimilated) {

    }

    @Override
    protected void onAssimilated(MultiblockControllerBase assimilator) {

    }

    @Override
    protected boolean updateServer() {
        return false;
    }

    @Override
    protected void updateClient() {

    }

    @Override
    public void writeToNBT(NBTTagCompound data) {

    }

    @Override
    public void readFromNBT(NBTTagCompound data) {

    }

    @Override
    public void formatDescriptionPacket(NBTTagCompound data) {

    }

    @Override
    public void decodeDescriptionPacket(NBTTagCompound data) {

    }
}
