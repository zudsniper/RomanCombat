package cc.holstr.romac.proxy;

import cc.holstr.romac.blocks.BlockRomanCube;
import cc.holstr.romac.blocks.BlockSteel;
import cc.holstr.romac.blocks.IBlock;
import cc.holstr.romac.items.ItemBluntHammer;
import cc.holstr.romac.items.ItemGladius;
import cc.holstr.romac.items.ItemOreDict;
import cc.holstr.romac.items.ItemSteelIngot;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Arrays;

@Mod.EventBusSubscriber()
public class CommonProxy {

    private static ItemBlock[] blockItems;

    public void preInit(FMLPreInitializationEvent e) {
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    }


    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        registerAllBlocks(event, new BlockRomanCube(), new BlockSteel());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        registerAllItems(event, new ItemGladius(), new ItemSteelIngot(), new ItemBluntHammer());
        //register itemBlocks
        registerBlockItems(event,blockItems);

    }

    private static void registerAllItems(RegistryEvent.Register<Item> event, Item... items) {
        for(Item item : items) {
            event.getRegistry().register(item);
            if(item instanceof ItemOreDict) {
                ((ItemOreDict)item).initOreDict();
            }
        }
    }

    private static void registerAllBlocks(RegistryEvent.Register<Block> event, IBlock... blocks) {
        blockItems = new ItemBlock[blocks.length];
        event.getRegistry().registerAll(Arrays.stream(blocks).map(b -> (Block)b).toArray(Block[]::new));
        for (int i = 0; i < blockItems.length; i++) {
            blockItems[i] = blocks[i].getItemBlock();
        }
    }

    private static void registerBlockItems(RegistryEvent.Register<Item> event, ItemBlock[] itemblocks) {
        for(ItemBlock item : itemblocks) {
            event.getRegistry().register(item);
            if(item instanceof ItemOreDict) {
                ((ItemOreDict)item).initOreDict();
            }
        }
    }
}
