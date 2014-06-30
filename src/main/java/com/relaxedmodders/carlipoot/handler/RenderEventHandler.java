package com.relaxedmodders.carlipoot.handler;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEventHandler {

	private Minecraft mc;

	public RenderEventHandler(Minecraft mc) {
		this.mc = mc;
	}

//	@SubscribeEvent
//	public void onRenderTick(RenderTickEvent event) {
//		if (event.phase == Phase.START) {
//			if ( mc.thePlayer != null ) {
//				mc.thePlayer.rotationYaw += 1.0F;
//			}
//		}
//		
//		if (event.phase == Phase.END) {
//			if ( mc.thePlayer != null ) {
//				mc.thePlayer.rotationPitch
//				+= 1.0F;
//			}
//		}
//	}
	
}
