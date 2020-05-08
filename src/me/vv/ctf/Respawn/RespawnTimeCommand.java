package me.vv.ctf.Respawn;

import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.vv.ctf.Globals.Globals;
import net.md_5.bungee.api.ChatColor;

public class RespawnTimeCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if(label.equalsIgnoreCase("respawntime") || label.equalsIgnoreCase("rt") ) {
			
			
			if(!(StringUtils.isNumeric(args[0]))){
				player.sendMessage(ChatColor.DARK_RED + "Usage /rt <Natural number>");
				return true;
			}
			
			if(Integer.parseInt(args[0]) < 0){
				player.sendMessage(ChatColor.DARK_RED + "Please enter a positive value for time.");
				return true;
			}
			

			Globals.respawn_time = Integer.parseInt(args[0]);
			player.sendMessage("Respawn timer set");
			return true;
		}
		return false;
		
	}

}





