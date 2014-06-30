package com.relaxedmodders.carlipoot;

import com.relaxedmodders.carlipoot.item.ModItems;
import com.relaxedmodders.carlipoot.lib.Reference;
import com.relaxedmodders.carlipoot.network.PacketHandler;
import com.relaxedmodders.carlipoot.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class TheShack {

    @SidedProxy(clientSide = Reference.CLIENTPROXYLOCATION, serverSide = Reference.COMMONPROXYLOCATION)
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	ModItems.init();
    	
    	PacketHandler.init();
    	
    	proxy.registerEventHandlers();
    	proxy.registerOverlays();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {}
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {}
    
}
