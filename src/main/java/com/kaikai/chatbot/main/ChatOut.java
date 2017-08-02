package com.kaikai.chatbot.main;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import scala.collection.mutable.Queue;

public class ChatOut {
	
	public static ChatOut chatout = new ChatOut();
	
	public ChatOut() {
		chatdelay = Main.chatdelay;
		MinecraftForge.EVENT_BUS.register(this);
		
	}
	
	public int chatdelay = 1; //seconds between chats
	public static long lastchat = 0;
	public ArrayList<String> chatqueue = new ArrayList<String>();
	
	public void queue(String s) {
		chatqueue.add(s);
	}
	
	public static void chat(String s) {
		Minecraft.getMinecraft().player.sendChatMessage(s);
	}

	@SubscribeEvent
	public void ClientTick(ClientTickEvent e) {
		//System.out.println("tick");
		if (!chatqueue.isEmpty()) {
			if (lastchat+(1000*chatdelay) < System.currentTimeMillis()) {
				chat(chatqueue.get(0));
				chatqueue.remove(0);
				lastchat = System.currentTimeMillis();
			}
		}
	}
	
}
