package com.relaxedmodders.carlipoot.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

import com.relaxedmodders.carlipoot.TheShack;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

	// Items
	public static ItemFireSword fireSword;
	public static ItemUseMana useMana;
	
	public static void init() {
		fireSword = new ItemFireSword(Item.ToolMaterial.EMERALD);
        useMana = new ItemUseMana();
	}
	
    public static void register(TSItem item) {
    	String s = item.getUnwrappedUnlocalizedName(item.getUnlocalizedName());
        GameRegistry.registerItem(item, s);
    }

	public static void register(TSItemSword itemSword) {
    	String s = itemSword.getUnwrappedUnlocalizedName(itemSword.getUnlocalizedName());
        GameRegistry.registerItem(itemSword, s);
    }
	
}
