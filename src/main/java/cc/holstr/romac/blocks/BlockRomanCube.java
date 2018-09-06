package cc.holstr.romac.blocks;

import cc.holstr.romac.Reference;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockRomanCube extends BlockModel {

    public BlockRomanCube() {
        super(Material.IRON, MapColor.IRON, "roman_cube", "roman_cube");
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

    }

    @Override
    public ItemBlock getItemBlock() {
        ItemBlock ib = new ItemBlock(this);
        ib.setRegistryName(getRegistryName());
        return ib;
    }
}
