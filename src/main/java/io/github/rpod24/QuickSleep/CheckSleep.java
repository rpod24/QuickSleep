package io.github.rpod24.QuickSleep;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.Event.Result;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class CheckSleep implements Listener {
	Global config;
	JavaPlugin plugin;
	public CheckSleep(Global _config, JavaPlugin pl){
		config = _config;
		plugin = pl;
	}
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Bukkit.broadcastMessage("Welcome to the server!");
    }
	
	@EventHandler
    public void onPlayerBedEnterEvent(PlayerBedEnterEvent event) {
		try {
			Player player = event.getPlayer();
			if(event.getBedEnterResult()==PlayerBedEnterEvent.BedEnterResult.OK) {
				event.setUseBed(Result.ALLOW);
				event.useBed();
				player.sendMessage(config.getPluginChatColor()+"[QuickSleep] "+ChatColor.RESET+"Good night!");
				Bukkit.broadcastMessage(config.getPluginChatColor()+"[QuickSleep] "+ChatColor.RESET+player.getName()+" went to sleep . . .");
				BukkitRunnable task = new runner(player);
			    task.runTaskLater(plugin, 10);
				
				player.getWorld().setStorm(false);
				player.getWorld().setThundering(false);
			}
		
		}
		catch (Exception e) {
	    	  System.out.println("An unexpected error occurred!");
	    	  System.out.println(e);
	    }
		
    }
	
	public class runner extends BukkitRunnable {
		Player player;
		public runner(Player _player) {
			player = _player;
		}
        @Override
        public void run() {
        	long lastUpdate = System.currentTimeMillis();
			while(player.getLocation().getWorld().getTime()%24000>9000) {
				if(System.currentTimeMillis()>= lastUpdate+config.getTimeDelay()) {
					player.getLocation().getWorld().setTime(player.getLocation().getWorld().getTime()+config.getTimeIncrease());
					lastUpdate = System.currentTimeMillis();
				}
				
			}
        }
    }

}
