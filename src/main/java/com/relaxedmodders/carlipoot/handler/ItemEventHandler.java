package com.relaxedmodders.carlipoot.handler;

import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ItemEventHandler {

	@SubscribeEvent
	public void onItemToss(ItemTossEvent event) {
		event.entityItem.setFire(10);
	}
	
	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event) {
		for ( EntityItem item : event.drops ) {
			item.setFire(10);
		}
	}
	
}
