package cc.holstr.romac.blocks;

import cc.holstr.romac.Reference;
import cc.holstr.romac.items.ItemBlockOreDict;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSteel extends BlockModel {

    public BlockSteel() {
        super(Material.IRON, MapColor.IRON, "steel_block", "steel_block");
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setHardness(6);
        setHarvestLevel("pickaxe",2);
    }

    @Override
    public ItemBlock getItemBlock() {
        ItemBlockOreDict ibod = new ItemBlockOreDict(this, "blockSteel");
        ibod.setRegistryName(getRegistryName());
        return ibod;
    }
}
