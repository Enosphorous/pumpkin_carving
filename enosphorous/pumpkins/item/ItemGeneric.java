package enosphorous.pumpkins.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGeneric extends Item {

	/** Icon index in the icons table. */
    public Icon itemIcon;
    public final String name;
    public final String displayName;
    public final String modName;

    public ItemGeneric(int id, String name, String displayName){
    	super(id);
        this.name = name;
        setUnlocalizedName(name);
        this.displayName = displayName;
        modName = Loader.instance().activeModContainer().getModId();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(modName.toLowerCase().replace('|', '_') + name);
    }
}
