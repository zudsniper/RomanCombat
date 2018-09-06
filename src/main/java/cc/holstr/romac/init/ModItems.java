package cc.holstr.romac.init;

import cc.holstr.romac.items.ItemBluntHammer;
import cc.holstr.romac.items.ItemGladius;
import cc.holstr.romac.items.ItemSteelIngot;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {

    @GameRegistry.ObjectHolder("romancombat:gladius")
    public static ItemGladius gladius;

    @GameRegistry.ObjectHolder("romancombat:steel_ingot")
    public static ItemSteelIngot steelIngot;

    @GameRegistry.ObjectHolder("romancombat:blunt_hammer")
    public static ItemBluntHammer bluntHammer;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        gladius.initModel();
        steelIngot.initModel();
        bluntHammer.initModel();
    }

    public static void init() {
        gladius = new ItemGladius();
        steelIngot = new ItemSteelIngot();
        bluntHammer = new ItemBluntHammer();
    }

    public static void register() {

    }

    public static void registerRenders() {

    }

    private static void registerRender(Item item) {

    }
}
