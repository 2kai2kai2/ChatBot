package com.kaikai.chatbot.main;

public class ChatProcessor {
	
	
	
	public static void process(String s) {
		System.out.println("process");
		//System.out.println(s.substring(0, 4).toLowerCase().trim());
		String text = s.trim().substring(s.indexOf(" ")/*+1*/);
		if (text.length() >= Main.commandword.length()) {
			System.out.println(text.trim().substring(0, Main.commandword.length()));
			if (text.trim().substring(0, Main.commandword.length()).trim().equalsIgnoreCase(Main.commandword)) {
				System.out.println("ikai!");
				
				if (Main.enabled) {ChatOut.chatout./**/queue/*chat*/(getResponse(text.trim().substring(Main.commandword.length()).toLowerCase().trim()));}
				else if (eq( text.trim().substring(Main.commandword.length()).toLowerCase().trim(), new String[]{"enable", "turn on", "un-turn off"} )) {Main.enabled = true; ChatOut.chatout.queue("Chatbot Enabled. Chat \"" + Main.commandword + "\" + your command to use.");}
				//else {}
				
			}
		}
	}
	
	public static String getResponse(String s) {
		System.out.println("getResponse " + s);
		//Conplex commands
		if (s.trim().equalsIgnoreCase("version")) {return "This ChatBot is currently running version " + Main.version;}
		
		//Simple commands
		else if (Main.commands.containsKey(s)) {return Main.commands.get(s);}
		else {return "";}
	}
	
	public static boolean eq(String a, String b) {return (a.trim().equalsIgnoreCase(b.trim()));}
	public static boolean eq(String a, String[] b) {
		for (int i = 0; b.length > i; i++) {
			if (eq(a, b[i])) {return true;}
		}
		return false;
	}
	
	
}
