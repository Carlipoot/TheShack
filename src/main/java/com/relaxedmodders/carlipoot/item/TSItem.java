package com.relaxedmodders.carlipoot.item;

import com.relaxedmodders.carlipoot.lib.Reference;
import com.relaxedmodders.carlipoot.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TSItem extends Item {

    public String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
 
    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", Reference.NAMEPREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
 
    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Reference.NAMEPREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
	
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Reference.RESOURCEPREFIX + getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

}
