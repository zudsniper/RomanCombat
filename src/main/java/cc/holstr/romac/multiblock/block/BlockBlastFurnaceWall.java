package cc.holstr.romac.multiblock.block;

import cc.holstr.romac.Reference;
import cc.holstr.romac.blocks.IBlock;
import cc.holstr.romac.multiblock.tileentity.TileEntityBlastFurnaceWall;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockBlastFurnaceWall extends BlockContainer implements IBlock {

    protected BlockBlastFurnaceWall() {
        super(Material.ROCK, MapColor.STONE);
        setUnlocalizedName(Reference.MOD_ID+".furnace_wall");
        setRegistryName("furnace_wall");
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityBlastFurnaceWall();
    }

    @Override
    public ItemBlock getItemBlock() {
        ItemBlock ib = new ItemBlock(this);
        ib.setRegistryName(getRegistryName());
        return ib;
    }
}
