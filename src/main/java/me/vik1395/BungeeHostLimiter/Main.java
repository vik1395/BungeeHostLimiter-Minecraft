package me.vik1395.BungeeHostLimiter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

/*

Author: Vik1395
Project: BungeeHostLimiter

Copyright 2015

Licensed under Creative CommonsAttribution-NonCommercial-ShareAlike 4.0 International Public License (the "License");
You may not use this file except in compliance with the License.

You may obtain a copy of the License at http://creativecommons.org/licenses/by-sa/4.0/legalcode

You may find an abridged version of the License at http://creativecommons.org/licenses/by-sa/4.0/
*/

public class Main extends Plugin
{
	public static Plugin plugin;
	  public static List<String> def;
	  public static Configuration custom;
	  public static String customkick;
	  public static String defaultkick;
	  
	  public void onEnable()
	  {
	    plugin = this;
	    loadConfig();
	    
	    getProxy().getPluginManager().registerListener(this, new ListenerClass());
	    
	    getProxy().getPluginManager().registerCommand(this, new Command("bhlreload"){

			@Override
			public void execute(CommandSender sender, String[] args)
			  {
			    if ((sender instanceof ProxiedPlayer))
			    {
			      if (((ProxiedPlayer)sender).hasPermission("bungeehostlimiter.reload")) {}
			    }
			    else
			    {
			      loadConfig();
			      getProxy().getLogger().info("[BungeeHostLimiter]" + ChatColor.GREEN + "Config has been reloaded");
			    }
			  }
	    	
	    });
	  }
	  
	  public void loadConfig()
	  {
	    YamlManager ym = new YamlManager();
	    ym.saveDefaultConfig();
	    def = YamlManager.config.getStringList("Default Host Names");
	    custom = (Configuration)YamlManager.config.get("Custom Host Names");
	    customkick = YamlManager.config.getString("Custom Kick Message");
	    defaultkick = YamlManager.config.getString("Default Kick Message");
	  }
	}