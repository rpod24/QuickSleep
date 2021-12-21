package io.github.rpod24.QuickSleep;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Global {
	private int timeCycleIncrease;
	private double timeCycleDelay;
	private ChatColor pluginColor = ChatColor.AQUA;
	
	FileConfiguration config;
	JavaPlugin plugin;
	public Global(FileConfiguration _config, JavaPlugin _plugin) {
		try {
			config = _config;
		plugin = _plugin;
		setTimeIncrease(config.getInt("timeIncrease"));
		setTimeDelay(config.getInt("timeCycleDelay"));
		} catch (Exception e) {
			System.out.println("An unexpected error occurred!");
			System.out.println(e);
		}
		
	}
	
	
	public static class helpConstants {
		public static final String[] commands = {"/quicksleep setTimeCycle [int]", "/quicksleep setTimeDelay [int]", "/quicksleep help"};
		public static final String[] commandToolTip = {"sets the amount of ticks foward per cycle of loop(cycle length is determined by setTimeDelay)", 
				"sets the amount of time per loop repeat which increases the ingame time by what ever TimeCycle is.",
				"/quicksleep help: lists all valid commands"};
	}
	
	
	public void setTimeIncrease(int amount) {
		try {
			timeCycleIncrease = amount;
			config.set("timeIncrease", amount);
			plugin.saveConfig();
		} catch (Exception e) {
			System.out.println("An unexpected error occurred!");
			System.out.println(e);
		}
	}
	public int getTimeIncrease() {
		return timeCycleIncrease;
	}
	public void setTimeDelay(double amount) {
		try {
			timeCycleDelay = amount;
		config.set("timeCycleDelay", amount);
		plugin.saveConfig();
		}catch (Exception e) {
			System.out.println("An unexpected error occurred!");
			System.out.println(e);
		}
		
	}
	public double getTimeDelay() {
		return timeCycleDelay;
	}
	public ChatColor getPluginChatColor() {
		return pluginColor;
	}
}
