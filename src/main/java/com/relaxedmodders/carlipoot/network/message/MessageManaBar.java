package com.relaxedmodders.carlipoot.network.message;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import com.relaxedmodders.carlipoot.extendedproperties.ExtendedPlayer;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageManaBar implements IMessage, IMessageHandler<MessageManaBar, IMessage> {

	public int currentMana;
	public int maxMana;
	
	public MessageManaBar() {}
	
	public MessageManaBar(int current, int max) {
		this.currentMana = current;
		this.maxMana = max;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.currentMana = buf.readInt();
		this.maxMana = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(currentMana);
		buf.writeInt(maxMana);
	}
	
	@Override
	public IMessage onMessage(MessageManaBar message, MessageContext ctx) {
        Minecraft mc = Minecraft.getMinecraft();

        if ( mc .theWorld.isRemote ) {
        	if ( mc.thePlayer != null ) {
        		EntityPlayer player = (EntityPlayer) mc.thePlayer;
        		
        		ExtendedPlayer props = ExtendedPlayer.get(mc.thePlayer);
        		props.setCurrentMana(message.currentMana);
        		props.setMaxMana(message.maxMana);
        	}
        }
        
		return null;
	}
	
}
