package com.kaikai.chatbot.main;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}
	
	public static void chat(String s) {
		Minecraft.getMinecraft().player.sendChatMessage(s);
	}
	
}
