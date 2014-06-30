package com.relaxedmodders.carlipoot.item;

import com.relaxedmodders.carlipoot.lib.Strings;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class ItemFireSword extends TSItemSword {

	public ItemFireSword(ToolMaterial mat) {
		super(mat);
        this.setUnlocalizedName(Strings.ItemFireSwordName);
        this.setCreativeTab(CreativeTabs.tabCombat);
        ModItems.register(this);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackingEntity) {
	   hitEntity.setFire(4);
	   return true;
	}

}
