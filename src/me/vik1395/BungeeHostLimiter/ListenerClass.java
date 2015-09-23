package me.vik1395.BungeeHostLimiter;

import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

/*

Author: Vik1395
Project: BungeeHostLimiter

Copyright 2015

Licensed under Creative CommonsAttribution-ShareAlike 4.0 International Public License (the "License");
You may not use this file except in compliance with the License.

You may obtain a copy of the License at http://creativecommons.org/licenses/by-sa/4.0/legalcode

You may find an abridged version of the License at http://creativecommons.org/licenses/by-sa/4.0/
 */

public class ListenerClass implements Listener
{
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onLogin(PreLoginEvent ple)
	{
		String pname = ple.getConnection().getName().toLowerCase();
		String connip = ple.getConnection().getVirtualHost().getHostName();
		
		if(Main.custom.containsKey(pname))
		{
			String cusip = Main.custom.get(pname);
			
			if(!connip.equals(cusip))
			{
				ple.setCancelReason(Main.customkick);
				ple.setCancelled(true);
			}
			return;
		}
		
		else
		{
			boolean islegal = false;
			if(Main.def==null || Main.def.size()<1 || Main.def.isEmpty())
			{
				islegal = true;
			}
			else
			{
				for(int i = 0; i<Main.def.size(); i++)
				{
					if(connip.equalsIgnoreCase(Main.def.get(i)))
					{
						islegal = true;
						break;
					}
				}
			}
			
			if(islegal==false)
			{
				String iplist = "\n";
				for(String defip: Main.def)
				{
					iplist = iplist + "- " + defip + "\n";
				}
				
				ple.setCancelReason(Main.defaultkick.replace("%list%", iplist));
				ple.setCancelled(true);
				return;
			}
		}
	}
}
