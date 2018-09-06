package cc.holstr.romac.items;

import cc.holstr.romac.Reference;
import cc.holstr.romac.materials.ModMaterials;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGladius extends ItemSword {

    public ItemGladius() {
        super(ModMaterials.steel);
        setUnlocalizedName(Reference.MOD_ID+".gladius");
        setRegistryName("gladius");

        setCreativeTab(CreativeTabs.COMBAT);

    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this,0,new ModelResourceLocation(getRegistryName(),"inventory"));
        //Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation(getRegistryName(), ""));
    }
}
