package me.vv.ctf.Flags;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import me.vv.ctf.Globals.Globals;
import me.vv.ctf.Teams.Team;

public class flagbreak implements Listener {


	@EventHandler 
	public void onPlayerBlockEvent(BlockBreakEvent e) {
		final String RED = "red";
		final String BLUE = "blue";

		String flag = "";
		if(e.getBlock().getType().equals(Material.BLUE_BANNER)) {
			flag = BLUE;
		} else if(e.getBlock().getType().equals(Material.RED_BANNER)) {
			flag = RED;
		} else {
			return;
		}
		
		Player p = e.getPlayer();
		Team playerTeam = null;
		Team opposingTeam = null;
		String team = "";
		if(Globals.red_team.isPlayerInTeam(p)) {
			team = RED;
			playerTeam = Globals.red_team;
			opposingTeam = Globals.blue_team;
		} else if(Globals.blue_team.isPlayerInTeam(p)) {
			team = BLUE;
			playerTeam = Globals.blue_team;
			opposingTeam = Globals.red_team;
		} else {
			e.setCancelled(true);
			return;
		}

		if(team == flag) {	// player breaking their own flag
			Bukkit.broadcastMessage(playerTeam.getColour() + "Team " + playerTeam.getName() + "'s flag was returned by " + p.getName());

			// returning logic
			e.getBlock().setType(Material.AIR);
			if(flag == RED) {
				playerTeam.getFlagSpawnLocation().getBlock().setType(Material.RED_BANNER);
			} else {
				playerTeam.getFlagSpawnLocation().getBlock().setType(Material.BLUE_BANNER);
			}
			e.setCancelled(true);
			} else {						// player breaking enemy flag
			Bukkit.broadcastMessage(opposingTeam.getColour() + "Team " + opposingTeam.getName() + "'s flag was stolen by " + p.getName());
			if(flag == RED) {
				Globals.red_flag_holder = p;	// p is on Blue team
			} else {
				Globals.blue_flag_holder = p;	// p is on Red team
			}
		}
	}
}