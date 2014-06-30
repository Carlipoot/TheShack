package com.relaxedmodders.carlipoot.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

import com.relaxedmodders.carlipoot.extendedproperties.ExtendedPlayer;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerEventHandler {

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		if ( event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) event.entity) == null )
			ExtendedPlayer.register((EntityPlayer) event.entity);

		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME) == null)
			event.entity.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer((EntityPlayer) event.entity));
	}
	
	@SubscribeEvent
	public void onLivingFallEvent(LivingFallEvent event) {
		if (event.entity instanceof EntityPlayer) {
			ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer) event.entity);

			if (event.distance > 3.0F && props.getCurrentMana() > 0) {
				float reduceby = props.getCurrentMana() < (event.distance - 3.0F) ? props.getCurrentMana() : (event.distance - 3.0F);
				event.distance -= reduceby;

				props.consumeMana((int) reduceby);
			}
		}
	}
	
	@SubscribeEvent
	public void onEntityJump(LivingJumpEvent event) {
		event.entity.motionY *= 5;
		event.entity.motionX *= 5;
		event.entity.motionZ *= 5;
	}
	
	@SubscribeEvent
	public void onEntityInteract(EntityInteractEvent event) {
		event.entityPlayer.addChatMessage(new ChatComponentText("This is a " + event.target));
	}
	
}
