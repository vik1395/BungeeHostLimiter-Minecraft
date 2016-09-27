BungeeHostLimiter adds an extra layer of security to you BungeeCord server. Certain players can be given custom IPs without which they cannot log in to the server. You can also specify the host names that default players are forced to use to join the server. If they use any other host name or the direct IP, they are kicked with a message asking them to use the correct IP.

This plugin works similar to [WorldGuard's](http://dev.bukkit.org/bukkit-plugins/worldguard/) Host Keys

Please report any issues with this plugin [HERE](https://github.com/vik1395/BungeeHostLimiter-Minecraft/issues)

If you like my work, please consider donating, I would greatly appreciate it. [![Image](https://www.paypalobjects.com/en_US/i/btn/btn_donate_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=vik1395lp%40gmail%2ecom&lc=US&item_name=Spigot%20Plugins&item_number=LegitPlay%2enet%20Plugin%20Dev&no_note=0&currency_code=USD&bn=PP%2dDonationsBF%3abtn_donateCC_LG%2egif%3aNonHostedGuest)

**Config File**
-------------

    #--- BungeeHostLimiter Config File ---#
    
    Default Host Names:
    
        - play.legitplay.net
    
        - mc.legitplay.net
    
    # Enter a list of default host names players can use to log in to your server.
    
    # Leave this empty if you want to only use custom host names.
    
    Custom Host Names:
    
        md_5: md5.legitplay.net
    
        Vik1395: Vik1395.legitplay.net
    
    # Enter a list of players and their custom Wildcard Hosts.
    
    # These players can only login to the server using the given host name.
    
    Default Kick Message: 'You have not entered using a valid IP. Please use one of the following IPs to enter this Server: %list%'
    
    # Enter the kick message shown to default players that log in through an IP not
    
    # listed in the Default Host Names. Use %list% to show the list of IPs they can use.
    
    Custom Kick Message: 'You have not entered using a valid host key!'
    
    # Enter the kick message shown to players who dont join with their custom key.

This plugin is licensed under [CC Attribution-NonCommercial-ShareAlike 4.0 International](http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en_US). 

In very basic terms, Do whatever you want with the code of this plugin, as long as you give credits to the author and/or the plugin itself.

Please leave a comment or rate the plugin, and tell me what you think of it. I would really appreciate it.
