package me.vv.ctf.Teams;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.vv.ctf.Globals.Globals;


public class PrintTeams implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;

		if(label.equalsIgnoreCase("teams")) {
			if(args.length != 0) {
				player.sendMessage(ChatColor.RED + "Usage: /teams");
				return true;
			}
      
      for(int i = 0; i < Globals.teams.size(); i++) {
        Team currTeam = Globals.teams.get(i);
        player.sendMessage(currTeam.getColour() + currTeam.getName() + ": " + currTeam.stringOfMembers());
      }

      return true;
		}
		return false; 
	}
}