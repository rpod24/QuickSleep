package io.github.rpod24.QuickSleep;
import org.bukkit.ChatColor;
//Imports Needed.
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
//ArgsCmd also implements CommandInterface
public class IncreaseDelay implements CommandInterface
{
	Global config;
	
	public IncreaseDelay(Global _config){
		config = _config;
	}
	
	@Override
	public boolean onCommand(CommandSender _sender, Command cmd, String commandLabel, String[] args) {
	      CommandSender p = _sender;
	      if(args.length > 2||args.length < 2) {
	    	  p.sendMessage(config.getPluginChatColor()+"[QuickSleep] "+ChatColor.RESET+" Invalid use of the command! Usage: /QuickSleep setTimeDelay [int]");
	    	  return false;
	      }
		try {
			config.setTimeDelay(Double.parseDouble(args[1]));
			p.sendMessage(config.getPluginChatColor()+"[QuickSleep] "+ChatColor.RESET+"Done! Time delay now: "+config.getTimeDelay());
			return true;
		}catch (Exception e) {
			System.out.println("An unexpected error occurred!");
			System.out.println(e);
      }
      return false;
  }

}
