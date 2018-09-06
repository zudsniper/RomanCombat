package cc.holstr.romac.items;

import cc.holstr.romac.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public abstract class ItemModel extends Item {

    /**
     * provide essential registry & naming IDs
     * @param unlocalizedName adds MOD_ID for you!
     * @param registryName
     */
    public ItemModel(String unlocalizedName, String registryName) {
        setUnlocalizedName(Reference.MOD_ID+"."+unlocalizedName);
        setRegistryName(registryName);
    }

    public abstract void initModel();
}
