package me.vv.ctf.Flags;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import me.vv.ctf.Globals.Globals;
import me.vv.ctf.Teams.Team;
import org.bukkit.ChatColor;

public class flagplace implements Listener {
	
	@EventHandler 
	public void onBlockPlace(BlockPlaceEvent e) {
		
		Player p = e.getPlayer();
		Team playerTeam = null;
		Team opposingTeam = null;
		if(Globals.red_team.isPlayerInTeam(p)) {
			playerTeam = Globals.red_team;
			opposingTeam = Globals.blue_team;
		} else if(Globals.blue_team.isPlayerInTeam(p)) {
			playerTeam = Globals.blue_team;
			opposingTeam = Globals.red_team;
		}
		
		if (e.getBlockPlaced().getType().equals(Material.RED_WALL_BANNER) || e.getBlockPlaced().getType().equals(Material.BLUE_WALL_BANNER)) {
			e.setCancelled(true);
			p.sendMessage(ChatColor.RED + "Cannot place a Wall Banner!");
			return;
		}
		
		if (e.getBlockPlaced().getType().equals(Material.RED_BANNER) || e.getBlockPlaced().getType().equals(Material.BLUE_BANNER)) {
			Location locPlacedAt = e.getBlockAgainst().getLocation();	
			Location blockBelow = e.getBlock().getLocation();
			if(locPlacedAt.equals(playerTeam.getFlagScoreLocation())) {
				Globals.blue_flag_holder = null;
				Globals.red_flag_holder = null;
				Bukkit.broadcastMessage(playerTeam.getColour() + "Team " + playerTeam.getName() + " has captured " + "Team " +
					opposingTeam.getName() + "'s flag!");
					Bukkit.broadcastMessage(playerTeam.getColour() + "Team " + playerTeam.getName() + " has won!");
			} 
			else if (blockBelow.equals(playerTeam.getFlagSpawnLocation())) {
					e.setCancelled(true);
					p.sendMessage(ChatColor.DARK_RED + "Place the flag on Obisidian!");
					return;
			} 
			else {
				if(p.getName().equals(Globals.safeGetName(Globals.red_flag_holder))) {
					Globals.red_flag_holder = null;
				}
				else {
					Globals.blue_flag_holder = null;
				}
				Team t = e.getBlockPlaced().getType().equals(Material.RED_BANNER) ? Globals.red_team : Globals.blue_team;
				Bukkit.broadcastMessage(t.getColour() + "Team " + t.getName() + " 's flag was dropped at: " + Globals.getNiceLocation(locPlacedAt) + ".");
			}
		}
	}	

}


