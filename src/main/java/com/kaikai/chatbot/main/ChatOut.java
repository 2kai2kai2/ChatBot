package com.kaikai.chatbot.main;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import scala.collection.mutable.Queue;

public class ChatOut implements Runnable {
	
	public static int chatdelay = 1; //seconds between chats
	public static long lastchat = 0;
	public static ArrayList<String> chatqueue = new ArrayList<String>();
	public static Thread thread = new Thread();
	
	public static void queue(String s) {
		if (!thread.isAlive()) {thread.start();}
		chatqueue.add(s);
	}
	
	public static void chat(String s) {
		Minecraft.getMinecraft().player.sendChatMessage(s);
	}

	@Override
	public void run() {
		if (!chatqueue.isEmpty()) {
			if (lastchat+(1000*chatdelay) < System.currentTimeMillis()) {
				chat(chatqueue.get(0));
				chatqueue.remove(0);
			}
		}
	}
	
	
}
