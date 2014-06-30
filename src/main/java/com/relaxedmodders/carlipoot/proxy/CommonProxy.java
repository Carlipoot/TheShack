package com.relaxedmodders.carlipoot.proxy;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

import com.relaxedmodders.carlipoot.client.overlay.OverlayManaBar;
import com.relaxedmodders.carlipoot.handler.ItemEventHandler;
import com.relaxedmodders.carlipoot.handler.PlayerEventHandler;
import com.relaxedmodders.carlipoot.handler.WorldEventHandler;

import cpw.mods.fml.common.FMLCommonHandler;

public class CommonProxy {
	
	public void registerEventHandlers() {
		ItemEventHandler itemEventHandler = new ItemEventHandler();

        FMLCommonHandler.instance().bus().register(itemEventHandler);
        MinecraftForge.EVENT_BUS.register(itemEventHandler);
        MinecraftForge.EVENT_BUS.register(new PlayerEventHandler());
        MinecraftForge.EVENT_BUS.register(new WorldEventHandler());
	}

	public void registerOverlays() {

	}
	
}
