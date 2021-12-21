package io.github.rpod24.QuickSleep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class tabComplete implements TabCompleter {
	
	@Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		try {
        if (command.getName().equalsIgnoreCase("quicksleep")||command.getName().equalsIgnoreCase("qs")) {
            List<String> mainArguments = Arrays.asList("help", "setTimeCycle", "setTimeDelay");
            List<String> finalList = new ArrayList<>();
            if (args.length == 1) {
                if (!args[0].equals("")) {
                    for (String string : mainArguments) {
                        if (string.startsWith(args[0].toLowerCase())) {
                            finalList.add(string);
                        }

                    }
                } else {
                    finalList = mainArguments;
                }
                Collections.sort(finalList);
                return finalList;
            }
            
            else if(args.length==2) {
            	if (!args[0].equals("")) {
                    for (String string : mainArguments) {
                    	for (int i = 0; i < string.length(); i++) {
                            if (string.toLowerCase().charAt(i)==(args[0].charAt(i))) {
                                finalList.add(string);
                            }
                            i=string.length()+1;
						}
                    }

                } else {
                    finalList = mainArguments;
                }

                Collections.sort(finalList);
                return finalList;
            }
            
            if (args.length == 0) {
                finalList = mainArguments;
                Collections.sort(finalList);
                return finalList;
            }
        }
		}
		catch (Exception e) {
			System.out.println("An unexpected error occurred!");
			System.out.println(e);
		}
        return null;
    }
	
}
