package me.vik1395.BungeeHostLimiter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.md_5.bungee.api.plugin.Plugin;

/*

Author: Vik1395
Project: BungeeHostLimiter

Copyright 2015

Licensed under Creative CommonsAttribution-ShareAlike 4.0 International Public License (the "License");
You may not use this file except in compliance with the License.

You may obtain a copy of the License at http://creativecommons.org/licenses/by-sa/4.0/legalcode

You may find an abridged version of the License at http://creativecommons.org/licenses/by-sa/4.0/
*/

public class Main extends Plugin
{
	public static Plugin plugin;
	public static List<String> def;
	public static HashMap<String, String> custom = new HashMap<>();
	public static String customkick, defaultkick;
	
	@SuppressWarnings("unchecked")
	public void onEnable() 
	{
		plugin = this;
		getProxy().getPluginManager().registerListener(this, new ListenerClass());
		
		YamlManager ym = new YamlManager();
		ym.saveDefaultConfig();
		
		def = YamlManager.config.getStringList("Default Host Names");
		Object customraw = YamlManager.config.get("Custom Host Names");
		customkick = YamlManager.config.getString("Custom Kick Message");
		defaultkick = YamlManager.config.getString("Default Kick Message");
		
		if (customraw != null && customraw instanceof Map) 
		{
			for (Map.Entry<Object, Object> entry : ((Map<Object, Object>) customraw).entrySet()) 
			{
				String user = String.valueOf(entry.getKey());
				String cuskey = String.valueOf(entry.getValue());
				custom.put(user.toLowerCase(), cuskey);
			}
		}
		
		//For Future Use
		/*Iterator<Entry<String, String>> iter = custom.entrySet().iterator();
		while(iter.hasNext())
		{
			Entry<String, String> cusentry = (Entry<String, String>)iter.next();
		}
		
		for(int i = 0; i<Main.def.size(); i++)
		{
			getLogger().info(Main.def.get(i));
		}*/
	}
}
