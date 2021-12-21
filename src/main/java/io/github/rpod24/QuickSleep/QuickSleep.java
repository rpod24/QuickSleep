package io.github.rpod24.QuickSleep;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class QuickSleep extends JavaPlugin {
	FileConfiguration config = this.getConfig();
	Global vars;
	final JavaPlugin pl = this;
	@Override
    public void onEnable() {
		vars = new Global(config, this);
		getServer().getPluginManager().registerEvents(new CheckSleep(vars, pl), this);
		System.out.println("QuickSleep plugin enabled! This plugin is a one person sleep plugin, where it will animate the time as the player sleeps for all players.");
		config.addDefault("timeIncrease", 100);
		config.addDefault("timeCycleDelay", 100);
		config.addDefault("timeEnd", 100);
		config.options().copyDefaults(true);
        saveConfig();
        this.registerCommands();
    }
	
	public static QuickSleep getInstance() {
        return QuickSleep.getInstance();
    }
    
    @Override
    public void onDisable() {
		System.out.println("Goodbye!");
    }

    
    public void registerCommands() {
    	CommandHandler handler = new CommandHandler();
        handler.register("setTimeCycle", new IncreaseTime(vars));
        handler.register("setTimeDelay", new IncreaseDelay(vars));
        handler.register("help", new help(vars));
        this.getCommand("QuickSleep").setExecutor(handler);
        this.getCommand("QuickSleep").setTabCompleter(new tabComplete());
        this.getCommand("QS").setExecutor(handler);
        this.getCommand("QS").setTabCompleter(new tabComplete());
    }
}
