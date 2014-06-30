package com.relaxedmodders.carlipoot.client.overlay;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import com.relaxedmodders.carlipoot.TheShack;
import com.relaxedmodders.carlipoot.extendedproperties.ExtendedPlayer;
import com.relaxedmodders.carlipoot.lib.Reference;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class OverlayManaBar extends Gui 
{
	private Minecraft mc;

	private static final ResourceLocation texturepathold = new ResourceLocation(Reference.RESOURCEPREFIX + "textures/gui/manaBar.png");
	private static final ResourceLocation texturepath = new ResourceLocation(Reference.RESOURCEPREFIX + "textures/gui/icons.png");

	public OverlayManaBar(Minecraft mc)	{
		super();
		this.mc = mc;
	}

   	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent event)	{
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE) {
			return;
		}

		ExtendedPlayer props = ExtendedPlayer.get(this.mc.thePlayer);

		if (props == null || props.getMaxMana() == 0) {
			return;
		}

		int xPos = event.resolution.getScaledWidth() - (2 + 9);
		int yPos = event.resolution.getScaledHeight() - (2 + 9);

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		// Somewhere in Minecraft vanilla code it says to do this because of a lighting bug
		GL11.glDisable(GL11.GL_LIGHTING);

		this.mc.getTextureManager().bindTexture(texturepath);

		for ( int i = 0; i < 10; i++ ) {
			this.drawTexturedModalRect(xPos, yPos - (10 * i), 0, 9, 9, 9);
		}

		int nFull = (int) Math.floor((((float) props.getCurrentMana()) / 10));
		
		for ( int i = 0; i < nFull; i++ ) {
			this.drawTexturedModalRect(xPos, yPos - (10 * i), 0, 0, 9, 9);
		}
		
		if ( nFull > 0 && (props.getCurrentMana() % nFull) > 0 ) {
			this.drawTexturedModalRect(xPos, yPos - (10 * nFull), 9, 0, 9, 9);
		}
	}
   	
}
