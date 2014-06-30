package com.relaxedmodders.carlipoot.proxy;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

import com.relaxedmodders.carlipoot.client.overlay.OverlayManaBar;
import com.relaxedmodders.carlipoot.handler.RenderEventHandler;

import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerEventHandlers() {
		super.registerEventHandlers();
	
		FMLCommonHandler.instance().bus().register(new RenderEventHandler(Minecraft.getMinecraft()));
	}
	
	@Override
	public void registerOverlays() {
		super.registerOverlays();
		
        MinecraftForge.EVENT_BUS.register(new OverlayManaBar(Minecraft.getMinecraft()));
    }
	
}