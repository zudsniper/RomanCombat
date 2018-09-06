package cc.holstr.romac.blocks;

import cc.holstr.romac.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public abstract class BlockModel extends Block implements IBlock {

    public BlockModel(Material blockMaterialIn, MapColor blockMapColorIn) {
        super(blockMaterialIn, blockMapColorIn);
    }

    public BlockModel(Material materialIn) {
        super(materialIn);
    }

    /**
     * provide essential registry & naming IDs
     * @param unlocalizedName adds MOD_ID for you!
     * @param registryName
     */
    public BlockModel(Material blockMaterialIn, MapColor blockMapColorIn, String unlocalizedName, String registryName) {
        super(blockMaterialIn, blockMapColorIn);
        setUnlocalizedName(Reference.MOD_ID+"."+unlocalizedName);
        setRegistryName(registryName);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    public ItemBlock getItemBlock() {
        ItemBlock ib = new ItemBlock(this);
        ib.setRegistryName(getRegistryName());
        return ib;
    }
}
