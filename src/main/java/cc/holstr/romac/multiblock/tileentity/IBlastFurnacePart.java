package cc.holstr.romac.multiblock.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class IBlastFurnacePart extends TileEntity implements ITickable {
    final static Logger logger = LogManager.getLogger(IBlastFurnacePart.class);
    private boolean hasMaster = false, isMaster = false;
    private int height;
    private BlockPos masterPos;

    public boolean checkMultiblockForm() {
        int numBlocks = 0;
        int height = 0;
        int y = 0;
        logger.info("checkMultiblockForm");
        for(int x = getPos().getX() - 1; x < getPos().getX() + 2; x++) {
            for(int z = getPos().getZ() - 1; z < getPos().getZ() + 2; z++) {
                y = getPos().getY();
                TileEntity te = getWorld().getTileEntity(new BlockPos(x,y,z));
                while(te instanceof IBlastFurnacePart) {
                    if(isMaster()) {
                        if(((IBlastFurnacePart)te).hasMaster()) {
                            numBlocks++;
                        }
                    } else if(!((IBlastFurnacePart)te).hasMaster()) {
                        numBlocks++;
                    }
                }
            }
        }
        height = y - getPos().getY();
        boolean air = true;
        for(int i = getPos().getY()+1; i<y-1 ;i++) {
            if(!getWorld().isAirBlock(new BlockPos(getPos().getX(),i,getPos().getZ()))) {
               air = false;
            }
        }
        return ((9 + 8*(y-getPos().getY()) + 8) > numBlocks) && air;
    }

    public void setupStructure() {
        logger.info("setupStructure");
        for(int x = getPos().getX() - 1; x < getPos().getX() + 2; x++) {
            for(int y = getPos().getY(); y < getPos().getZ() + height; y++) {
                for(int z = getPos().getZ() - 1; z < getPos().getZ() + 2; z++) {
                    TileEntity te = getWorld().getTileEntity(new BlockPos(x,y,z));
                    boolean master = (x == getPos().getX() && y == getPos().getY() && z == getPos().getZ());
                    if(te instanceof IBlastFurnacePart) {
                        ((IBlastFurnacePart)te).setMasterPos(getPos());
                        ((IBlastFurnacePart)te).setHasMaster(true);
                        ((IBlastFurnacePart)te).setMaster(master);
                    }
                }
            }
        }
    }

    public void reset() {
        masterPos = null;
        hasMaster = false;
        isMaster = false;
    }

    public void resetStructure() {
        logger.info("resetStructure");
        for(int x = getPos().getX() - 1; x < getPos().getX() + 2; x++) {
            for(int y = getPos().getY(); y < getPos().getZ() + height; y++) {
                for(int z = getPos().getZ() - 1; z < getPos().getZ() + 2; z++) {
                    TileEntity te = getWorld().getTileEntity(new BlockPos(x,y,z));
                    if(te instanceof IBlastFurnacePart) {
                        ((IBlastFurnacePart)te).reset();
                    }
                }
            }
        }
    }

    public boolean checkForMaster() {
        TileEntity te = getWorld().getTileEntity(getMasterPos());
        return te instanceof IBlastFurnacePart;
    }

    @Override
    public void update() {
        logger.info("update called");
        if(getWorld().isRemote) {
            if(hasMaster()) {
                if(isMaster()) {

                }
            } else {
                if(checkMultiblockForm()) {
                    setupStructure();
                }
            }
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        NBTTagCompound tag = super.writeToNBT(compound);
        compound.setInteger("masterX", masterPos.getX());
        compound.setInteger("masterY", masterPos.getY());
        compound.setInteger("masterZ", masterPos.getZ());
        compound.setBoolean("hasMaster", hasMaster);
        compound.setBoolean("isMaster", isMaster);

        if(hasMaster() && isMaster()) {

        }
        return tag;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.setMasterPos(new BlockPos(compound.getInteger("masterX"),compound.getInteger("masterY"),compound.getInteger("masterZ")));
        setMaster(compound.getBoolean("isMaster"));
        setHasMaster(compound.getBoolean("hasMaster"));

        if(hasMaster() && isMaster()) {

        }
    }

    public boolean hasMaster() {
        return hasMaster;
    }

    public void setHasMaster(boolean hasMaster) {
        this.hasMaster = hasMaster;
    }

    public boolean isMaster() {
        return isMaster;
    }

    public void setMaster(boolean master) {
        isMaster = master;
    }

    public BlockPos getMasterPos() {
        return masterPos;
    }

    public void setMasterPos(BlockPos masterPos) {
        this.masterPos = masterPos;
    }
}
