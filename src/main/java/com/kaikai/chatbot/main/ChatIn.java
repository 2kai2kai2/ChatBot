package com.kaikai.chatbot.main;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

@Mod.EventBusSubscriber
public class ChatIn {
	
	@SubscribeEvent
	public static void recieve(ClientChatReceivedEvent e) {
		if (e.getType() == ChatType.CHAT) {
			String get = e.getMessage().getUnformattedText();
			ChatProcessor.process(get);
		}
		
		
	}
	
	
	//e.player.sendMessage(new TextComponentString("Welcome"));
}
