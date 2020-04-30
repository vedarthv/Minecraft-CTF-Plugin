package me.vv.ctf.Teams;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import me.vv.ctf.Globals.Globals;


public class SetTeam implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;

		if(label.equalsIgnoreCase("setteam") || label.equalsIgnoreCase("st")) {
			
			if(args.length!=2 || !(args[0].equals("blue") || args[0].equals("red"))) {
				player.sendMessage(ChatColor.RED + "Usage: /setteam <red,blue> <player>");
				return true;
			}
		
			Player p = Bukkit.getPlayer(args[1]);
	
			if (p == null) {
				player.sendMessage(ChatColor.RED + args[1] + " not found!");
				return true;
			}

			Team targetTeam = args[0].equals("blue") ? Globals.blue_team : Globals.red_team;
			Team opposingTeam = args[0].equals("blue") ? Globals.red_team : Globals.blue_team;
			targetTeam.addMember(p);
			opposingTeam.removeMember(p);
			
			return true;
		}
		return false; 
	}
}