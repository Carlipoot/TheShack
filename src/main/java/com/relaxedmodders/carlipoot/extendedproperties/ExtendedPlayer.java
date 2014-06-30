package com.relaxedmodders.carlipoot.extendedproperties;

import com.relaxedmodders.carlipoot.TheShack;
import com.relaxedmodders.carlipoot.network.PacketHandler;
import com.relaxedmodders.carlipoot.network.message.MessageManaBar;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayer implements IExtendedEntityProperties {
	
	public final static String EXT_PROP_NAME = "ExtendedPlayer";

	private final EntityPlayer player;

	private int currentMana, maxMana;

	public ExtendedPlayer(EntityPlayer player) {
		this.player = player;
		this.currentMana = this.maxMana = 100;
	}

	/**
	 * Used to register these extended properties for the player during EntityConstructing event
	 * This method is for convenience only; it will make your code look nicer
	 */
	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer(player));
	}

	/**
	 * Returns ExtendedPlayer properties for player
	 * This method is for convenience only; it will make your code look nicer
	 */
	public static final ExtendedPlayer get(EntityPlayer player)	{
		return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();

		properties.setInteger("CurrentMana", this.currentMana);
		properties.setInteger("MaxMana", this.maxMana);

		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);

		this.currentMana = properties.getInteger("CurrentMana");
		this.maxMana = properties.getInteger("MaxMana");
	}

	@Override
	public void init(Entity entity, World world) {}

	/**
	 * Returns true if the amount of mana was consumed or false
	 * if the player's current mana was insufficient
	 */
	public boolean consumeMana(int amount) {
		boolean sufficient = amount <= this.currentMana;
		this.currentMana -= (amount < this.currentMana ? amount : this.currentMana);

		sync();
		return sufficient;
	}

	/**
	 * Simple method sets current mana to max mana
	 */
	public void replenishMana()	{
		this.currentMana = this.maxMana;
		sync();
	}
	
	public int getCurrentMana() {
		return this.currentMana;
	}
	
	public int getMaxMana() {
		return this.maxMana;
	}
	
	public void setCurrentMana(int amount) {
		this.currentMana = (amount < this.maxMana ? amount : this.maxMana);
	}
	
	public void setMaxMana(int amount) {
		this.maxMana = (amount > 0 ? amount : 0);
	}
	
	public void sync() {
		PacketHandler.INSTANCE.sendToAll(new MessageManaBar(this.currentMana, this.maxMana));
	}
	
}