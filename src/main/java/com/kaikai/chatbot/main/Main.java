package com.kaikai.chatbot.main;

import java.io.File;
import java.util.HashMap;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import scala.actors.threadpool.Arrays;

@Mod(modid="chatbot", name="ChatBot", version="v.1.0.0A-mc1.12")
public class Main {
	@SidedProxy(clientSide="com.kaikai.chatbot.main.ClientProxy",serverSide="com.kaikai.chatbot.main.ServerProxy")
	public static CommonProxy proxy;
	
	public static Configuration config;
	
	public static HashMap<String, String> commands = new HashMap<String, String>();
	
	public static boolean enabled = false; //TODO: make this do something
	public static String commandword = "ikai:";
	public static String version = "v.1.0.0A-mc1.12";
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
        
        
        
        config = new Configuration(new File("config/chatbot.cfg"));
        try {
        	config.load();
        	
        	Property commandwordprop = config.get(Configuration.CATEGORY_GENERAL, "commandword", "ikai:", "The command word to speak to the chatbot");
        	commandword = commandwordprop.getString();
        	
        	String[] commandlistprop = config.getStringList("commands", "CommandsList", defaultconfigcom, "A list of simple user set commands. do not use the character ':'");
        	for (int i = 0; i < commandlistprop.length; i++) {
        		//System.out.println(i + commandlistprop[i]);
        		String k = commandlistprop[i].substring(0, commandlistprop[i].indexOf(":")/*-1*/).trim();
        		//System.out.println(k);
        		if (commandlistprop[i].indexOf(":") < commandlistprop[i].length() && commandlistprop[i].indexOf(":") > 0) { //to make sure there is a ':' and a string to reply afterwards
        			String s = commandlistprop[i].substring(commandlistprop[i].indexOf(":")+1).trim();
        			//System.out.println(k + " " + s);
        			if (k.trim().startsWith("[") && k.trim().endsWith("]")) { //List of commands with the same output - do "[hi,hello,hey]:Hello!"
        				//System.out.println("[  ] " + k);
        				String a = k.substring(1, k.length()-1);
        				String[] kla = a.split(",");
        				for (int j = 0; j < kla.length; j++) {
        					commands.put(kla[j].trim(), s);
        				}
        			} else {commands.put(k, s);} //(else) 1 command -> 1 output
        			//System.out.println(k + " " + s);
        		}
        	}
        	System.out.println("ChatBot commands: " + commands);
        	
        } catch (Exception e1) {
        	
        } finally {
        	if (config.hasChanged()) config.save();
        }
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
        
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
    
    
    public String[] defaultconfigcom = new String[]{
    		"test:tested",
    		"[hi,hello,hey]:Hello."
    		};
    
    
    
}
