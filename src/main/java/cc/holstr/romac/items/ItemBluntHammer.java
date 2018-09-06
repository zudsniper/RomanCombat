package cc.holstr.romac.items;

import cc.holstr.romac.Reference;
import cc.holstr.romac.materials.ModMaterials;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashSet;

public class ItemBluntHammer extends ItemTool {

    public ItemBluntHammer() {
        super(1.0f, 2f, ModMaterials.steel, new HashSet<>());
        setUnlocalizedName(Reference.MOD_ID + ".blunt_hammer");
        setRegistryName("blunt_hammer");

        setCreativeTab(CreativeTabs.TOOLS);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this,0,new ModelResourceLocation(getRegistryName(),"inventory"));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

        int distance = 10;

        Vec3d vec3 = playerIn.getPositionVector();
        Vec3d vec3a = playerIn.getLook(1.0f);
        Vec3d vec3b = vec3.addVector(vec3a.x * distance, vec3a.y * distance, vec3a.z * distance);

        RayTraceResult pos = worldIn.rayTraceBlocks(vec3, vec3b);
        pos.getBlockPos();

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
