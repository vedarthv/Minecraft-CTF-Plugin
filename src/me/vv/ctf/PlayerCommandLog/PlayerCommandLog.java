package me.vv.ctf.PlayerCommandLog;

import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import me.vv.ctf.Globals.Globals;

public class PlayerCommandLog implements CommandExecutor{

		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			Player player = (Player) sender;

			if(label.equalsIgnoreCase("cmdtoggle") || label.equalsIgnoreCase("gmtg")) {
				
				if(args.length!=1 || !(args[0].equals("on") || args[0].equals("off"))) {
					player.sendMessage(ChatColor.RED + "Usage: /cmdtoggle <on/off>");
					return true;
				}
				
				if(args[0].equals("on")) {
						Globals.loggers.add(player);
						return true;
						
				}
				else{
					player.sendMessage("cmdtoggle is off.");
					Globals.loggers.remove(player);
					return true;
				}
					
			}
			return false; 
		}
}


