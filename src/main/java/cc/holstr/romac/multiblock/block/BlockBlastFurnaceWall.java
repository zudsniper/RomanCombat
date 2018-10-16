package cc.holstr.romac.multiblock.block;

import cc.holstr.romac.Reference;
import cc.holstr.romac.blocks.IBlock;
import cc.holstr.romac.multiblock.tileentity.IBlastFurnacePart;
import cc.holstr.romac.multiblock.tileentity.TileEntityBlastFurnaceWall;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;

public class BlockBlastFurnaceWall extends Block implements IBlock {
    final static Logger logger = LogManager.getLogger(IBlastFurnacePart.class);

    public BlockBlastFurnaceWall() {
        super(Material.ROCK);
        setUnlocalizedName(Reference.MOD_ID+".blast_furnace_wall");
        setRegistryName("blast_furnace_wall");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public ItemBlock getItemBlock() {
        ItemBlock ib = new ItemBlock(this);
        ib.setRegistryName(getRegistryName());
        return ib;
    }

    @Nullable
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        logger.info("reee");
        return new TileEntityBlastFurnaceWall();
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }
}