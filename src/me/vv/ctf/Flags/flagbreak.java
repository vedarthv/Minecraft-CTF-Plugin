package me.vv.ctf.Flags;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;
import me.vv.ctf.Globals.Globals;
import me.vv.ctf.Teams.Team;
import org.bukkit.ChatColor;
import org.bukkit.Location;

public class flagbreak implements Listener {
	
	@EventHandler
	public void onBlockExplodeEvent(EntityExplodeEvent e) { //Does not allow the flag and the block below it to explode 
		
		 for (Block block : new ArrayList<Block>(e.blockList())) {
		    if (block.getType().equals(Material.BLUE_BANNER) || block.getType().equals(Material.RED_BANNER)) {
		    	Location loc = block.getLocation();
		    	loc.setY(loc.getY() -1);
		    	e.blockList().remove(loc.getBlock());
		    	e.blockList().remove(block);
		    }
     	}
	}
	
	@EventHandler //Extension of the onBlockExplodeEvent (Covers the case for blocks below the flag that obey gravity)
    public void onEntityChangeBlockEvent (EntityChangeBlockEvent e) { 
        if (e.getEntityType().equals(EntityType.FALLING_BLOCK)) {
        	Location loc = e.getBlock().getLocation();
        	loc.setY(loc.getY()+1);
            if (loc.getBlock().getType().equals(Material.BLUE_BANNER) || loc.getBlock().getType().equals(Material.RED_BANNER)){
            	e.setCancelled(true);
            	e.getBlock().setType(Material.DIRT);
            }
        }
            
    }
	
	
	@EventHandler 
	public void onPlayerBlockEvent(BlockBreakEvent e) {
		
		Player p = e.getPlayer();
		Location blockAbove = e.getBlock().getLocation();  // if player breaks block below the flag.
		blockAbove.setY(blockAbove.getY() +1);
		if(blockAbove.getBlock().getType().equals(Material.BLUE_BANNER) || blockAbove.getBlock().getType().equals(Material.RED_BANNER)){
			e.setCancelled(true);
			return;
		}
		
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
			e.getBlock().setType(Material.AIR);
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
	    		
			if(flag == RED) {
				Globals.red_flag_holder = p;	// p is on Blue team
				Bukkit.broadcastMessage(opposingTeam.getColour() + "Team " + opposingTeam.getName() + "'s flag was stolen by " + p.getName());
				e.getBlock().setType(Material.AIR);
				} 
			else {
				Globals.blue_flag_holder = p;	// p is on Red team
				Bukkit.broadcastMessage(opposingTeam.getColour() + "Team " + opposingTeam.getName() + "'s flag was stolen by " + p.getName());
				e.getBlock().setType(Material.AIR);
			}
		}
		e.setCancelled(true);
	}
}