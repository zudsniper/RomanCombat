package cc.holstr.romac.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.oredict.OreDictionary;

public class ItemBlockOreDict extends ItemBlock implements ItemOreDict {

    private String oreDictName;

    public ItemBlockOreDict(Block block, String oreDictName) {
        super(block);
        this.oreDictName = oreDictName;

    }

    @Override
    public void initOreDict() {
        OreDictionary.registerOre(oreDictName, this);
    }
}
