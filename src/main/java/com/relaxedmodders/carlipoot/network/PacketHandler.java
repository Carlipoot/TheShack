package com.relaxedmodders.carlipoot.network;

import com.relaxedmodders.carlipoot.extendedproperties.ExtendedPlayer;
import com.relaxedmodders.carlipoot.lib.Reference;
import com.relaxedmodders.carlipoot.network.message.MessageManaBar;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler {

	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID.toLowerCase());
	
	public static void init() {
		INSTANCE.registerMessage(MessageManaBar.class, MessageManaBar.class, 0, Side.CLIENT);
	}
	
}