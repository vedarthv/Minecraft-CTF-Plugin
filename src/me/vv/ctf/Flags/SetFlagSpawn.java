package me.vv.ctf.Flags;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import me.vv.ctf.Globals.Globals;
import me.vv.ctf.Teams.Team;


public class SetFlagSpawn implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		boolean onATeam = false;
		Team playerTeam = null;
		for(int i = 0; i < Globals.teams.size(); i++) {
			Team t = Globals.teams.get(i);
				if(t.isPlayerInTeam(player)) {
					onATeam = true;
					playerTeam = t;
					break;
				}
		}

		if(label.equalsIgnoreCase("setflagspawn") || label.equalsIgnoreCase("sfs")) {
			if(args.length != 0 || !onATeam) {
				player.sendMessage(ChatColor.RED + "Use /setflagspawn OR /sfs once standing on the block where your flag will spawn. Should be in a team!");
				return true;
			}
			
		playerTeam.setFlagSpawnLocation(player.getLocation());
		playerTeam.getFlagSpawnLocation().getBlock().getRelative(BlockFace.DOWN).setType(Material.BEDROCK);
		playerTeam.getFlagScoreLocation().getBlock().setType(Material.OBSIDIAN);
	
		for(int i = 0; i < Globals.teams.size(); i++) {
			Team t = Globals.teams.get(i);
				if(t.isPlayerInTeam(player)) {
					player.sendMessage(ChatColor.GOLD + "The flag spawn block is Bedrock");
					player.sendMessage(ChatColor.GOLD + "The flag score block is Obsidian");
				}
		}
		
		Bukkit.broadcastMessage(ChatColor.GOLD + "Team " + playerTeam.getName() + " has set their flag spawn!");
		return true;
	}
		
	  return false; 
   }
}