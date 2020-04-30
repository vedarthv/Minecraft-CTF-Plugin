package me.vv.ctf.Teams;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;


public class SetTeam implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		
		if(label.equalsIgnoreCase("setteam") || label.equalsIgnoreCase("st")) {
			
			if(args.length!=2 || !(args[0].equals("blue") || args[0].equals("red"))) {
				player.sendMessage(ChatColor.RED + "Usage: /setteam <red,blue> <player>");
				player.sendMessage(ChatColor.RED +"Args length:" + args.length);
				player.sendMessage(ChatColor.RED +"Team:" + args[0]);
				player.sendMessage(ChatColor.RED +"Player:" + args[1]);
				return true;
			}
		
			Player p = Bukkit.getPlayer(args[1]);
	
			if (p == null) {
				
				player.sendMessage(ChatColor.RED + args[1] + " Not Found!");
				return true;
			}
			Team.AssignTeam(args[0],p);
			
			
		}
		return false; 
	}
}