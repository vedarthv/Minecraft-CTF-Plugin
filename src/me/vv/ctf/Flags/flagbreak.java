package me.vv.ctf.Flags;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import me.vv.ctf.Globals.Globals;
import me.vv.ctf.Teams.Team;
import net.md_5.bungee.api.ChatColor;

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
		
		e.getBlock().setType(Material.AIR);
		if(team == flag) {	// player breaking their own flag
			Bukkit.broadcastMessage(playerTeam.getColour() + "Team " + playerTeam.getName() + "'s flag was returned by " + p.getName());

			// returning logic
			if(flag == RED) {
				playerTeam.getFlagSpawnLocation().getBlock().setType(Material.RED_BANNER);
			} 
			else {
				playerTeam.getFlagSpawnLocation().getBlock().setType(Material.BLUE_BANNER);
			}
	
		} 
		else {						// player breaking enemy flag
				if(p.getInventory().firstEmpty() == -1) { // Player has no space in their inventory
					p.sendMessage(ChatColor.DARK_RED + "Cannot pick up the flag! Inventory is full!");
					e.setCancelled(true);
					return;
				}
	    Material banner = flag == RED ? Material.RED_BANNER : Material.BLUE_BANNER;
	    p.getInventory().addItem(new ItemStack(banner));
	    
	    Bukkit.broadcastMessage(opposingTeam.getColour() + "Team " + opposingTeam.getName() + "'s flag was stolen by " + p.getName());
				
			if(flag == RED) {
				Globals.red_flag_holder = p;	// p is on Blue team
				Bukkit.broadcastMessage(opposingTeam.getColour() + "Team " + opposingTeam.getName() + "'s flag was stolen by " + p.getName());
							} 
			else {
				Globals.blue_flag_holder = p;	// p is on Red team
				Bukkit.broadcastMessage(opposingTeam.getColour() + "Team " + opposingTeam.getName() + "'s flag was stolen by " + p.getName());
			}
		}
		e.setCancelled(true);
	}
}