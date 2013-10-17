package enosphorous.pumpkins.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enosphorous.pumpkins.api.ICarving;

public class ItemCarvingKnife extends Item implements ICarving
{
    private float weaponDamage;
    private final EnumToolMaterial toolMaterial;

    public ItemCarvingKnife(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1);
        this.toolMaterial = par2EnumToolMaterial;
        this.maxStackSize = 1;
        this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
        this.setCreativeTab(CreativeTabs.tabTools);
        this.weaponDamage = 4.0F + par2EnumToolMaterial.getDamageVsEntity();
    }

    public float func_82803_g()
    {
        return this.toolMaterial.getDamageVsEntity();
    }

    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        if (par2Block.blockID == Block.web.blockID)
        {
            return 15.0F;
        }
        else
        {
            Material material = par2Block.blockMaterial;
            return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.pumpkin ? 1.0F : 1.5F;
        }
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        par1ItemStack.damageItem(2, par3EntityLivingBase);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase)
    {
        if ((double)Block.blocksList[par3].getBlockHardness(par2World, par4, par5, par6) != 0.0D)
        {
            par1ItemStack.damageItem(2, par7EntityLivingBase);
        }

        return true;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block.blockID == Block.web.blockID;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return this.toolMaterial.getEnchantability();
    }

    /**
     * Return the name for this tool's material.
     */
    public String getToolMaterialName()
    {
        return this.toolMaterial.toString();
    }

	@Override
	public Item toolMaterialItem() {
		
		if (this.itemID == Items.wood_carver.itemID){
			return null;
		}
		else if (this.itemID == Items.stone_carver.itemID){
			return null;
		}
		else if (this.itemID == Items.iron_carver.itemID){
			return Item.ingotIron;
		}
		else if (this.itemID == Items.gold_carver.itemID){
			return Item.ingotGold;
		}
		else if (this.itemID == Items.diamond_carver.itemID){
			return Item.diamond;
		}
		return null;
	}

	@Override
	public int durability() {
		
		if (this.itemID == Items.wood_carver.itemID){
			return 24;
		}
		else if (this.itemID == Items.stone_carver.itemID){
			return 50;
		}
		else if (this.itemID == Items.wood_carver.itemID){
			return 115;
		}
		else if (this.itemID == Items.gold_carver.itemID){
			return 18;
		}
		else if (this.itemID == Items.diamond_carver.itemID){
			return 240;
		}
		return 0;
	}

	@Override
	public Block toolMaterialBlock() {
		
		if (this.itemID == Items.wood_carver.itemID){
			return Block.planks;
		}
		else if (this.itemID == Items.stone_carver.itemID){
			return Block.cobblestone;
		}
		else if (this.itemID == Items.iron_carver.itemID){
			return null;
		}
		else if (this.itemID == Items.gold_carver.itemID){
			return null;
		}
		else if (this.itemID == Items.diamond_carver.itemID){
			return null;
		}
		return null;
	}

}
