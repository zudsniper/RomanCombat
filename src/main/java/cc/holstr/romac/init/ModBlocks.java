package cc.holstr.romac.init;

import cc.holstr.romac.blocks.BlockRomanCube;
import cc.holstr.romac.blocks.BlockSteel;
import cc.holstr.romac.items.ItemGladius;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    @GameRegistry.ObjectHolder("romancombat:roman_cube")
    public static BlockRomanCube blockRomanCube;

    @GameRegistry.ObjectHolder("romancombat:steel_block")
    public static BlockSteel blockSteel;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        blockRomanCube.initModel();
        blockSteel.initModel();
    }

    public static void init() {
        blockRomanCube = new BlockRomanCube();
        blockSteel = new BlockSteel();
    }
}
