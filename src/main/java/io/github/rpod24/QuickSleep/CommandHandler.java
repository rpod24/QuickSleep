package io.github.rpod24.QuickSleep;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;

public class CommandHandler implements CommandExecutor
{
    private static HashMap<String, CommandInterface> commands = new HashMap<String, CommandInterface>();
    public void register(String name, CommandInterface cmd) {
        commands.put(name, cmd);
    }
    public boolean exists(String name) {
        return commands.containsKey(name);
    }
    public CommandInterface getExecutor(String name) {
        return commands.get(name);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
            if(args.length == 0) {
                getExecutor("QuickSleep").onCommand(sender, cmd, commandLabel, args);
                return true;
            }
            if(args.length > 0) {
                if(exists(args[0])){
                    getExecutor(args[0]).onCommand(sender, cmd, commandLabel, args);
                    return true;
                } else {
                    sender.sendMessage("This command doesn't exist!");
                    return true;
                }
            }
        
        return false;
    }
 
}
 