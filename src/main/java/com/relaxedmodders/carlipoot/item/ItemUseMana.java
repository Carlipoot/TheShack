package com.relaxedmodders.carlipoot.item;

import com.relaxedmodders.carlipoot.extendedproperties.ExtendedPlayer;
import com.relaxedmodders.carlipoot.lib.Strings;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemUseMana extends TSItem {
	
    public ItemUseMana() {
        this.setUnlocalizedName(Strings.ItemUseManaName);
        this.setCreativeTab(CreativeTabs.tabCombat);
        ModItems.register(this);
    }

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if ( !world.isRemote ) {
			ExtendedPlayer props = ExtendedPlayer.get(player);

			if ( props.consumeMana(15) ) {
				// System.out.println("[MANA ITEM] Player had enough mana. Do something awesome!");
			} else {
				// System.out.println("[MANA ITEM] Player ran out of mana. Sad face.");
				props.replenishMana();
			}
		}
		
		return itemstack;
	}
	
}
