package com.relaxedmodders.carlipoot.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import com.relaxedmodders.carlipoot.extendedproperties.ExtendedPlayer;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class WorldEventHandler {

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
			ExtendedPlayer.get((EntityPlayer) event.entity).sync();
	}
	
}
