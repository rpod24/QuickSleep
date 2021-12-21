package io.github.rpod24.QuickSleep;
import org.bukkit.ChatColor;
//Imports Needed.
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
//ArgsCmd also implements CommandInterface
public class help implements CommandInterface
{
	Global config;
	
	public help(Global _config){
		config = _config;
	}
	
	@Override
	public boolean onCommand(CommandSender _sender, Command cmd, String commandLabel, String[] args) {
	      CommandSender p = _sender;
	  
		
			p.sendMessage(config.getPluginChatColor()+"[QuickSleep] "+ChatColor.RESET+"Valid Commands: ");
			for (int i = 0; i < Global.helpConstants.commands.length; i++) {
				p.sendMessage(""+ChatColor.YELLOW+Global.helpConstants.commands[i]+": "+ChatColor.RESET+Global.helpConstants.commandToolTip[i]);
			}
      return false;
  }

}
