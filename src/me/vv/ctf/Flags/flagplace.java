package me.vv.ctf.Flags;

import com.sun.xml.internal.bind.v2.runtime.Location;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import me.vv.ctf.Globals.Globals;
import me.vv.ctf.Teams.Team;

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
		
		if (e.getBlockPlaced().getType().equals(Material.RED_BANNER) || e.getBlockPlaced().getType().equals(Material.BLUE_BANNER)) {
			Location locPlacedAt = e.getBlockAgainst().getLocation();
			if(locPlacedAt.equals(playerTeam.getFlagScoreLocation())) {
				Bukkit.broadcastMessage(playerTeam.getColour() + "Team " + playerTeam.getName() + " has captured " + "Team " +
					opposingTeam.getName() + "'s flag!");
					Bukkit.broadcastMessage(playerTeam.getColour() + "Team " + playerTeam.getName() + "has won!");
			} else {
				Bukkit.broadcastMessage(opposingTeam.getColour() + "Team " + opposingTeam.getName() + "'s flag was dropped at: " +
					locPlacedAt.toString() + ".");
			}
		}
	}	

}


