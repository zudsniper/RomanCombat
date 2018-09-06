package cc.holstr.romac.items;

import cc.holstr.romac.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class ItemSteelIngot extends ItemModel implements ItemOreDict {

    public ItemSteelIngot() {
       super("steel_ingot","steel_ingot");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this,0,new ModelResourceLocation(getRegistryName(),"inventory"));
    }


    public void initOreDict() {
        OreDictionary.registerOre("ingotSteel", this);
    }
}
